#include "gl/glut.h"
#include <iostream>
#include <cstdio>

using namespace std;

struct Vec2 {
    float x, y;
};

Vec2 mousePt = { 0, 0 };
float arr[];
void display() {
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);

    glColor3f(0.0f, 0.0f, 0.0f);

    glBegin(GL_POINTS);
    glVertex2f(mousePt.x, mousePt.y);
    
    glEnd();
    glutSwapBuffers();
}

void keyboard(unsigned char key, int x, int y) {

    switch (key) {
    case 49:
        cout << "size 1\n";
        glPointSize(2.0);
        break;
    case 50:
        cout << "size 2\n";
        glPointSize(4.0);
        break;
    case 51:
        cout << "size 3\n";
        glPointSize(6.0);
        break;
    case 52:
        cout << "size 4\n";
        glPointSize(8.0);
        break;
    case 53:
        cout << "size 5\n";
        glPointSize(10.0);
        break;
    case 82:
        cout << "All Clear\n";
        
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
    }
    glutPostRedisplay();
}

void mouseMotion(int x, int y)
{
    printf("mouse motion: %d %d\n", x, y);
    mouseCoordinateTranslate(x, y);
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
    //glutPassiveMotionFunc(mousePassiveMotion);
    glutMainLoop();

    return 0;
}
