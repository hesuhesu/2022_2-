#include "gl/glut.h"
#include <cstdio>
#include <iostream>

using namespace std;

struct Vec2 {
    float x, y;
};

Vec2 linePt[4] = {
    {-0.3f, 0.2f}, // x1, y1
    {0.6f, -0.7f}, // x2, y2
    {-0.7f, -0.5f}, // x3, y3
    {0.5f, 0.0f} // x4, y4
};

void display() {
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);

    glLineWidth(5.0f); // ������ �β��� ����
    glColor3f(1.0, 0.0, 0.0);
    glBegin(GL_LINES);
    glVertex2f(linePt[0].x, linePt[0].y);
    glVertex2f(linePt[1].x, linePt[1].y);
    glEnd();

    glColor3f(0.0, 0.0, 1.0);
    glBegin(GL_LINES);
    glVertex2f(linePt[2].x, linePt[2].y);
    glVertex2f(linePt[3].x, linePt[3].y);
    glEnd();

    /* Calculate the interseciton point! */
    glColor3f(0.0, 1.0, 0.0);
    glPointSize(5.0); // ���� ũ�⸦ ����
    glBegin(GL_POINTS);

    float x_1 = linePt[1].x - linePt[0].x; // x2 - x1
    float y_1 = linePt[1].y - linePt[0].y; // y2 - y1

    float x_2 = linePt[3].x - linePt[2].x; // x4 - x3
    float y_2 = linePt[3].y - linePt[2].y; // y4 - y3

    float a = y_1 / x_1; // y = ax + b �� x ��� "a"
    float c = y_2 / x_2; // y = cx + d �� x ��� "c"

    // cout << "a : " << a << ", c : " << c << "\n";

    float b = (-a * linePt[0].x) + linePt[0].y; // y = ax + b �� ����� "b"
    float d = (-c * linePt[2].x) + linePt[2].y; // y = cx + d �� ����� "d"

    cout << "b : " << b << ", d : " << d << "\n";

    float a_min_c = a - c; // (a-c)x = d - b �� "a - c ��"
    float d_min_b = d - b; // (a-c)x = d - b �� "d - b ��"

    cout << "a - c : " << a_min_c << ", d - b : " << d_min_b << "\n";

    try {
        if (a_min_c == 0) throw a_min_c; // �����ϰų� ��ġ��. ������ �ش� ������ x�� ����� �������̹Ƿ� �����ص� ��.
        else if (d_min_b == 0) {
            glVertex2f(0, d);
        }
        else if ((d_min_b / a_min_c > linePt[3].x) || (d_min_b / a_min_c < linePt[2].x)) { // ����ó�� - 1. x ��ǥ�� ���󿡼� ����ٸ� 0 ������ �ֿܼ� ����.
            throw 0;
        }
        else if ((((c * (d_min_b / a_min_c)) + d) > linePt[0].y) || (((c * (d_min_b / a_min_c)) + d) < linePt[1].y)){ // ����ó�� - 2. y ��ǥ�� ���󿡼� ����ٸ� 1 ������ �ֿܼ� ����.
            throw 1;
        }
        else {
            glVertex2f(d_min_b / a_min_c, (c * (d_min_b / a_min_c)) + d); // ������ ���� �� ���� ǥ���Ѵ�.
        }
    }
    catch (int exception) {
        cout << exception << " type error!!\n";
    }
    glEnd(); 

    glutSwapBuffers();
}

void keyboard(unsigned char key, int x, int y) {

    switch (key) {
    case 'w':
        linePt[0].y += 0.1f;
        linePt[1].y += 0.1f;
        break;
    case 's':
        linePt[0].y -= 0.1f;
        linePt[1].y -= 0.1f;
        break;
    case 'a':
        linePt[0].x -= 0.1f;
        linePt[1].x -= 0.1f;
        break;
    case 'd':
        linePt[0].x += 0.1f;
        linePt[1].x += 0.1f;
        break;
    case 'i':
        linePt[2].y += 0.1f;
        linePt[3].y += 0.1f;
        break;
    case 'k':
        linePt[2].y -= 0.1f;
        linePt[3].y -= 0.1f;
        break;
    case 'j':
        linePt[2].x -= 0.1f;
        linePt[3].x -= 0.1f;
        break;
    case 'l':
        linePt[2].x += 0.1f;
        linePt[3].x += 0.1f;
        break;
    case 27: // ESC
        exit(0);
        break;
    }
    glutPostRedisplay();
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(500, 500); // â�� ũ��
    glutInitWindowPosition(1280, 100); // â ���� ��ġ

    glutCreateWindow("OpenGL");
    glutDisplayFunc(display);
    glutKeyboardFunc(keyboard);
    glutMainLoop();

    return 0;
}