#include "gl/glut.h"
#include <cstdio>
#include "GCBezierCurve.h"

using namespace std;

// ctrl+k+c
// ctrl+k+u

Vec2 mousePt = { 1, 0 };
float rotateAngle = 0.0;
vector<Vec2> ctrlPts;
vector<vector<float>> all;

void drawAABB(int start, int i) { // AABB 를 그리는 함수. start 함수로 그리기 시작점과 현재 i 의 index 를 받아 그립니다.
    glColor3f(1, 0, 1);
    glLineWidth(1.0);
    glBegin(GL_LINE_LOOP);
    glVertex2f(all[start][0], all[start][1]);
    glVertex2f(all[i][0], all[start][1]);
    glVertex2f(all[i][0], all[i][1]);
    glVertex2f(all[start][0], all[i][1]);
    glEnd();
}

void displayGlutPrimitives() {

    // glutWireSphere(1.0, 40, 40);
    //glutSolidSphere(1.0, 20, 20);

    //glutWireCube(0.5);
    //glutSolidCube(0.5);

    //glutWireCone(1.0, 1.5, 12, 12);
    //glutSolidCone(1.0, 1.5, 12, 12);

    //glutWireTorus(0.3, 0.7, 20, 20);
    //glutSolidTorus(0.3, 0.7, 20, 20);

    // glutWireTeapot(1.0);
    // glutSolidTeapot(1.0);
}

void display() {
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0f, 0.0f, 0.0f);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluOrtho2D(-5.0, 5.0, -5.0, 5.0);

    //----------------- 0. Display Glut Primitives -------------------
    //displayGlutPrimitives();
    // ----------------------------------------------------------------


    //--------------- 1. Simple transform ------------------------
        /*glMatrixMode(GL_MODELVIEW);
        glColor3f(0.0f, 0.0f, 0.0f);
        glLoadIdentity();
        glTranslatef(1.0, 0.0, 0.0);
        displayGlutPrimitives();

        glColor3f(1.0, 0.0, 0.0);
        glLoadIdentity();
        glTranslatef(0.0, 1.0, 0.0);
        displayGlutPrimitives();

        glColor3f(0.0, 0.0, 1.0);
        glLoadIdentity();
        glTranslatef(0.0, 0.0, 1.0);
        displayGlutPrimitives();*/
        // ----------------------------------------------------------------


        // --------------- 2. Multiple transform --------------------------
            //glMatrixMode(GL_MODELVIEW);
            //// Rotate-Translate
            //glLoadIdentity();
            //glColor3f(1, 0, 0);
            //glRotatef(rotateAngle, 0.0, 0.0, 1.0);
            //glTranslatef(1.0, 0.0, 0.0);
            //displayGlutPrimitives();

            ////Translate-Rotate
            //glColor3f(0, 0, 1);
            //glLoadIdentity();
            //glTranslatef(1.0, 0.0, 0.0);
            //glRotatef(rotateAngle, 0.0, 0.0, 1.0);
            //displayGlutPrimitives();
        // ----------------------------------------------------------------


        // --------------- 3. Bezier Curve --------------------------
    BezierCurve2D curve(ctrlPts);

    glPointSize(5.0);
    glLineWidth(1.0);
    glColor3f(1, 0, 0);
    glBegin(GL_POINTS);
    for (auto& pt : ctrlPts)
        glVertex2f(pt.x, pt.y);
    glEnd();
    glBegin(GL_LINE_STRIP);
    for (auto& pt : ctrlPts)
        glVertex2f(pt.x, pt.y);
    glEnd();

    glColor3f(0, 0, 0);
    glLineWidth(2.0);
    glBegin(GL_LINE_STRIP);


    for (int i = 0; i <= 100; i++) {
        auto pt = curve.Evaluate(i / 100.0);
        glVertex2f(pt.x, pt.y);
        vector<float> vt; // 임시 벡터 생성
        vt.push_back(pt.x);
        vt.push_back(pt.y);
        all.push_back(vt); // 모든 값 all 벡터에 삽입
    }
    glEnd();

    int start = 0; // 시작 지점. 그리고 수정하고 반복
    int type = -1; // 타입. 태초 타입은 -1, 0 타입은 음의 기울기, 1 타입은 양의 기울기
    if ((all[1][1] - all[0][1]) / (all[1][0] - all[0][0]) > 0) { // 1번째와 0번째의 선분 기울기가 양이라면?
        type = 1;
    }
    else if (all[1][1] - all[0][1] == 0) { // 1번째 y 와 0번째 y 가 동일값일 경우
        if (all[1][0] - all[0][0] > 0) { // 양의 방향이면
            type = 1;
        }
        else { // 음의 방향이면
            type = 0;
        }
    }
    else if (all[1][0] - all[0][0] == 0) { // 1번째 x 와 0번째 x 가 동일값일 경우 (분자가 0이면 num error 가능성)
        if (all[1][1] - all[0][1] > 0) { // 양의 방향이면
            type = 1;
        }
        else { // 음의 방향이면
            type = 0;
        }
    }
    else { // 1번째와 0번째의 선분 기울기가 음이라면?
        type = 0;
    }

    for (int i = 1; i < all.size(); i++) {
        if ((all[i][1] - all[i - 1][1]) / (all[i][0] - all[i - 1][0]) > 0) { // 기울기가 0 보다 클 때
            if (type == 1) { // 같은 양의 기울기로 진행중이였을 때
                if (i == all.size() - 1) { // 끝나는 지점일 경우
                    drawAABB(start, i);
                }
                else if (i == 1) { // 이미 for 문 밖에서 1에 대한 정의를 완료함, 추가로 index 1이 삽입되면, 아래 2개의 else if 에서 오류 도출
                    continue;
                }
                else if (((all[i][0] - all[i - 1][0]) > 0) && ((all[i - 1][0] - all[i - 2][0]) < 0)) { // 예시를 x 좌표로만 들었지만, 급 유턴을 하는 방향성은 동일하므로 y 좌표도 적용됩니다.
                    drawAABB(start, i);
                    start = i;
                }
                else if (((all[i][0] - all[i - 1][0]) < 0) && ((all[i - 1][0] - all[i - 2][0]) > 0)) { // 위 조건문과 동일
                    drawAABB(start, i);
                    start = i;
                }
            }
            else { // 기울기가 역전된 상황
                drawAABB(start, i);
                start = i; // 시작지점 변경
                type = 1; // 양의 기울기 타입으로 변경
            }
        }
        else if ((all[i][1] - all[i - 1][1]) / (all[i][0] - all[i - 1][0]) < 0) { // 기울기가 0 보다 작을 때
            if (type == 0) { // 같은 음의 기울기로 진행중이였을 때
                if (i == all.size() - 1) { // 끝나는 지점일 경우
                    drawAABB(start, i);
                }
                else if (i == 1) { // 이미 for 문 밖에서 1에 대한 정의를 완료함, 추가로 index 1이 삽입되면, 아래 2개의 else if 에서 오류 도출
                    continue;
                }
                else if (((all[i][0] - all[i - 1][0]) > 0) && ((all[i - 1][0] - all[i - 2][0]) < 0)) { // 예시를 x 좌표로만 들었지만, 급 유턴을 하는 방향성은 동일하므로 y 좌표도 적용됩니다.
                    drawAABB(start, i);
                    start = i;
                }
                else if (((all[i][0] - all[i - 1][0]) < 0) && ((all[i - 1][0] - all[i - 2][0]) > 0)) { // 위 조건문과 동일
                    drawAABB(start, i);
                    start = i;
                }
            }
            else { // 기울기가 역전된 상황
                drawAABB(start, i);
                start = i;
                type = 0;
            }
        }
    }
    all.clear(); // 전역 벡터 all 초기화.(초기화 x 라면 데이터 누적)
    glutSwapBuffers();
}

void keyboard(unsigned char key, int x, int y) {

    switch (key) {
    case 27: // ESC
        exit(0);
        break;
    }
    glutPostRedisplay();
}

void special(int key, int x, int y)
{
    switch (key)
    {
    case GLUT_KEY_UP:
        rotateAngle += 10;
        break;
    case GLUT_KEY_DOWN:
        rotateAngle -= 10;
        break;
    }
    glutPostRedisplay();
}

void mouseCoordinateTranslate(int winX, int winY)
{
    mousePt.x = winX / 50.0 - 5;
    mousePt.y = (winY / 50.0 - 5) * (-1.0);
}

void changeCtrlPts()
{
    for (auto& pt : ctrlPts) {
        if (sqrt(pow(pt.x - mousePt.x, 2) + pow(pt.y - mousePt.y, 2)) < 0.5) {
            pt = mousePt;
            break;
        }
    }
}

void mouse(int button, int state, int x, int y)
{
    printf("mouse: %d %d %d %d\n", button, state, x, y);
    if (state == GLUT_DOWN) {
        mouseCoordinateTranslate(x, y);
        changeCtrlPts();
    }
    glutPostRedisplay();
}

void mouseMotion(int x, int y)
{
    printf("mouse motion: %d %d\n", x, y);
    mouseCoordinateTranslate(x, y);
    changeCtrlPts();

    glutPostRedisplay();
}

void mousePassiveMotion(int x, int y)
{
    printf("mouse passive motion: %d %d\n", x, y);
    mouseCoordinateTranslate(x, y);
    glutPostRedisplay();
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition(1280, 100);

    ctrlPts.push_back({ -2, -1 });
    ctrlPts.push_back({ 0, 2 });
    ctrlPts.push_back({ 2, -1 });
    ctrlPts.push_back({ 4, 3 });

    glutCreateWindow("OpenGL");
    glutDisplayFunc(display);
    glutKeyboardFunc(keyboard);
    glutSpecialFunc(special);
    glutMouseFunc(mouse);
    glutMotionFunc(mouseMotion);
    //glutPassiveMotionFunc(mousePassiveMotion);
    glutMainLoop();

    return 0;
}