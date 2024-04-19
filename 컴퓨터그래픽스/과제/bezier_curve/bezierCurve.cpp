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

void drawAABB(int start, int i) { // AABB �� �׸��� �Լ�. start �Լ��� �׸��� �������� ���� i �� index �� �޾� �׸��ϴ�.
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
        vector<float> vt; // �ӽ� ���� ����
        vt.push_back(pt.x);
        vt.push_back(pt.y);
        all.push_back(vt); // ��� �� all ���Ϳ� ����
    }
    glEnd();

    int start = 0; // ���� ����. �׸��� �����ϰ� �ݺ�
    int type = -1; // Ÿ��. ���� Ÿ���� -1, 0 Ÿ���� ���� ����, 1 Ÿ���� ���� ����
    if ((all[1][1] - all[0][1]) / (all[1][0] - all[0][0]) > 0) { // 1��°�� 0��°�� ���� ���Ⱑ ���̶��?
        type = 1;
    }
    else if (all[1][1] - all[0][1] == 0) { // 1��° y �� 0��° y �� ���ϰ��� ���
        if (all[1][0] - all[0][0] > 0) { // ���� �����̸�
            type = 1;
        }
        else { // ���� �����̸�
            type = 0;
        }
    }
    else if (all[1][0] - all[0][0] == 0) { // 1��° x �� 0��° x �� ���ϰ��� ��� (���ڰ� 0�̸� num error ���ɼ�)
        if (all[1][1] - all[0][1] > 0) { // ���� �����̸�
            type = 1;
        }
        else { // ���� �����̸�
            type = 0;
        }
    }
    else { // 1��°�� 0��°�� ���� ���Ⱑ ���̶��?
        type = 0;
    }

    for (int i = 1; i < all.size(); i++) {
        if ((all[i][1] - all[i - 1][1]) / (all[i][0] - all[i - 1][0]) > 0) { // ���Ⱑ 0 ���� Ŭ ��
            if (type == 1) { // ���� ���� ����� �������̿��� ��
                if (i == all.size() - 1) { // ������ ������ ���
                    drawAABB(start, i);
                }
                else if (i == 1) { // �̹� for �� �ۿ��� 1�� ���� ���Ǹ� �Ϸ���, �߰��� index 1�� ���ԵǸ�, �Ʒ� 2���� else if ���� ���� ����
                    continue;
                }
                else if (((all[i][0] - all[i - 1][0]) > 0) && ((all[i - 1][0] - all[i - 2][0]) < 0)) { // ���ø� x ��ǥ�θ� �������, �� ������ �ϴ� ���⼺�� �����ϹǷ� y ��ǥ�� ����˴ϴ�.
                    drawAABB(start, i);
                    start = i;
                }
                else if (((all[i][0] - all[i - 1][0]) < 0) && ((all[i - 1][0] - all[i - 2][0]) > 0)) { // �� ���ǹ��� ����
                    drawAABB(start, i);
                    start = i;
                }
            }
            else { // ���Ⱑ ������ ��Ȳ
                drawAABB(start, i);
                start = i; // �������� ����
                type = 1; // ���� ���� Ÿ������ ����
            }
        }
        else if ((all[i][1] - all[i - 1][1]) / (all[i][0] - all[i - 1][0]) < 0) { // ���Ⱑ 0 ���� ���� ��
            if (type == 0) { // ���� ���� ����� �������̿��� ��
                if (i == all.size() - 1) { // ������ ������ ���
                    drawAABB(start, i);
                }
                else if (i == 1) { // �̹� for �� �ۿ��� 1�� ���� ���Ǹ� �Ϸ���, �߰��� index 1�� ���ԵǸ�, �Ʒ� 2���� else if ���� ���� ����
                    continue;
                }
                else if (((all[i][0] - all[i - 1][0]) > 0) && ((all[i - 1][0] - all[i - 2][0]) < 0)) { // ���ø� x ��ǥ�θ� �������, �� ������ �ϴ� ���⼺�� �����ϹǷ� y ��ǥ�� ����˴ϴ�.
                    drawAABB(start, i);
                    start = i;
                }
                else if (((all[i][0] - all[i - 1][0]) < 0) && ((all[i - 1][0] - all[i - 2][0]) > 0)) { // �� ���ǹ��� ����
                    drawAABB(start, i);
                    start = i;
                }
            }
            else { // ���Ⱑ ������ ��Ȳ
                drawAABB(start, i);
                start = i;
                type = 0;
            }
        }
    }
    all.clear(); // ���� ���� all �ʱ�ȭ.(�ʱ�ȭ x ��� ������ ����)
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