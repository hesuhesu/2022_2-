#include "GL/glut.h"

void display() {
	glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // color으로 덮어 지운다
	glClear(GL_COLOR_BUFFER_BIT); // color 과 관련된 버퍼를 비워둠
	
	glColor3f(0.0f, 0.0f, 0.0f); // RGB. 0.0 ~ 1.0
	
	glBegin(GL_POLYGON); // start
	glVertex2f(-0.5f, -0.5f); // 도형에 대한 정점. vertex이며 x,y 
	glVertex2f(0.5f, -0.5f);
	glVertex2f(0.0f, 0.5f);
	glEnd(); // 도형 정의에 대한 end

	glFinish(); // end

}

int main(int argc, char **argv) {

	glutInit(&argc, argv); // glutLib를 초기화
	glutCreateWindow("OpenGL"); // 창의 이름
	glutDisplayFunc(display); // display 함수 호출. callback
	glutMainLoop(); // main이 순차 실행될 때 종료를 막기위해 적용되는 코드
	return 0;
}