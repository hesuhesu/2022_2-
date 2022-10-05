package practice_java;

class Shape{
	public double getArea() {
		return 0;
	}
	public Shape() {
		super();
	}
	public void draw() {
		
	}
}

class Rectangle extends Shape{
	public void draw() {
		System.out.println("사각형을 그렸습니다.");
	}
}
class Triangle extends Shape{
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
	}
}
class Circle extends Shape {
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}
}

public class Shape_2 {

	public static void main(String[] args) {
		
		Shape S = new Rectangle();
		S.draw();
		S = new Triangle();
		S.draw();
		S = new Circle();
		S.draw();
	}

}
