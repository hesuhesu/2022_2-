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

    glLineWidth(5.0f); // 라인의 두께를 지정
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
    glPointSize(5.0); // 점의 크기를 지정
    glBegin(GL_POINTS);

    float x_1 = linePt[1].x - linePt[0].x; // x2 - x1
    float y_1 = linePt[1].y - linePt[0].y; // y2 - y1

    float x_2 = linePt[3].x - linePt[2].x; // x4 - x3
    float y_2 = linePt[3].y - linePt[2].y; // y4 - y3

    float a = y_1 / x_1; // y = ax + b 의 x 계수 "a"
    float c = y_2 / x_2; // y = cx + d 의 x 계수 "c"

    // cout << "a : " << a << ", c : " << c << "\n";

    float b = (-a * linePt[0].x) + linePt[0].y; // y = ax + b 의 상수값 "b"
    float d = (-c * linePt[2].x) + linePt[2].y; // y = cx + d 의 상수값 "d"

    cout << "b : " << b << ", d : " << d << "\n";

    float a_min_c = a - c; // (a-c)x = d - b 에 "a - c 값"
    float d_min_b = d - b; // (a-c)x = d - b 에 "d - b 값"

    cout << "a - c : " << a_min_c << ", d - b : " << d_min_b << "\n";

    try {
        if (a_min_c == 0) throw a_min_c; // 평행하거나 일치함. 하지만 해당 문제의 x의 계수는 고정값이므로 생략해도 됨.
        else if (d_min_b == 0) {
            glVertex2f(0, d);
        }
        else if ((d_min_b / a_min_c > linePt[3].x) || (d_min_b / a_min_c < linePt[2].x)) { // 예외처리 - 1. x 좌표가 선상에서 벗어난다면 0 에러를 콘솔에 띄운다.
            throw 0;
        }
        else if ((((c * (d_min_b / a_min_c)) + d) > linePt[0].y) || (((c * (d_min_b / a_min_c)) + d) < linePt[1].y)){ // 예외처리 - 2. y 좌표가 선상에서 벗어난다면 1 에러를 콘솔에 띄운다.
            throw 1;
        }
        else {
            glVertex2f(d_min_b / a_min_c, (c * (d_min_b / a_min_c)) + d); // 에러가 없을 시 점을 표기한다.
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
    glutInitWindowSize(500, 500); // 창의 크기
    glutInitWindowPosition(1280, 100); // 창 시작 위치

    glutCreateWindow("OpenGL");
    glutDisplayFunc(display);
    glutKeyboardFunc(keyboard);
    glutMainLoop();

    return 0;
}