#include "GL/glut.h"

void display() {
	glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // color���� ���� �����
	glClear(GL_COLOR_BUFFER_BIT); // color �� ���õ� ���۸� �����
	
	glColor3f(0.0f, 0.0f, 0.0f); // RGB. 0.0 ~ 1.0
	
	glBegin(GL_POLYGON); // start
	glVertex2f(-0.5f, -0.5f); // ������ ���� ����. vertex�̸� x,y 
	glVertex2f(0.5f, -0.5f);
	glVertex2f(0.0f, 0.5f);
	glEnd(); // ���� ���ǿ� ���� end

	glFinish(); // end

}

int main(int argc, char **argv) {

	glutInit(&argc, argv); // glutLib�� �ʱ�ȭ
	glutCreateWindow("OpenGL"); // â�� �̸�
	glutDisplayFunc(display); // display �Լ� ȣ��. callback
	glutMainLoop(); // main�� ���� ����� �� ���Ḧ �������� ����Ǵ� �ڵ�
	return 0;
}