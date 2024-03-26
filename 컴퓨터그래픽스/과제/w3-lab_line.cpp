#include "gl/glut.h"
#include <cstdio>
#include <vector>

using namespace std;
vector<vector<float>> vt;
float use_it = 2.0;

struct Vec2 {
    float x, y;
};

Vec2 mousePt = { 0, 0 };

void display() {
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0f, 0.0f, 0.0f);

    for (int i = 0; i < vt.size(); i++) {
        if (i == 0) {
            continue;
        }
        glLineWidth(vt[i][2]);
        glBegin(GL_LINES);
        if (vt[i][3] == true) {
            if (vt[i - 1][3] == false) {
                glEnd();
            }
            else {
                glVertex2f(vt[i - 1][0], vt[i - 1][1]);
                glVertex2f(vt[i][0], vt[i][1]);
                glEnd();
            }
        }
    }
    glutSwapBuffers();
}

void keyboard(unsigned char key, int x, int y) {

    switch (key) {
    case 49:
        use_it = 2.0;
        break;
    case 50:
        use_it = 4.0;
        break;
    case 51:
        use_it = 6.0;
        break;
    case 52:
        use_it = 8.0;
        break;
    case 53:
        use_it = 10.0;
        break;
    case 82:
        vt.clear();
        break;
    case 27: // ESC
        exit(0);
        break;
    }
    glutPostRedisplay();
}

void mouseCoordinateTranslate(int winX, int winY)
{
    mousePt.x = winX / 250.0 - 1;
    mousePt.y = (winY / 250.0 - 1) * (-1.0);

}

void mouse(int button, int state, int x, int y)
{
    printf("mouse: %d %d %d %d\n", button, state, x, y);
    if (state == GLUT_DOWN) {
        mouseCoordinateTranslate(x, y);
        vector<float> vts;
        vts.push_back(mousePt.x);
        vts.push_back(mousePt.y);
        vts.push_back(use_it);
        vts.push_back(false);
        vt.push_back(vts);
    }
    glutPostRedisplay();
}

void mouseMotion(int x, int y)
{
    printf("mouse motion: %d %d\n", x, y);
    mouseCoordinateTranslate(x, y);
    vector<float> vts;
    vts.push_back(mousePt.x);
    vts.push_back(mousePt.y);
    vts.push_back(use_it);
    vts.push_back(true);
    vt.push_back(vts);
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
    glutInitWindowPosition(1480, 100);


    glutCreateWindow("OpenGL");
    glutDisplayFunc(display);
    glutKeyboardFunc(keyboard);
    glutMouseFunc(mouse);
    glutMotionFunc(mouseMotion);
    // glutPassiveMotionFunc(mousePassiveMotion);
    glutMainLoop();

    return 0;
}
