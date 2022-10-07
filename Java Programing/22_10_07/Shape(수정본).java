package practice_java;

class Shape{
	
	public void getArea() {}
	public Shape() {super();}
	public void draw() {}
	
}

class Rectangle extends Shape{
	public void draw() {
		System.out.println("사각형을 그렸습니다.");
	}
	public void getArea() {
		System.out.println("사각형 넓이는 n**2");
	}
}
class Triangle extends Shape{
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
	}
	public void getArea() {
		System.out.println("삼각형 넓이는 n**2 * 1/2");
	}
}
class Circle extends Shape {
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}
	public void getArea() {
		System.out.println("원의 넓이는 r**2 * 3.14");
	}
}

public class Shape_2 {
	
	public static void print(Shape S) {
		S.getArea();
	}
	
	public static void main(String[] args) {
		
		Shape[] arrayOfShape;
		arrayOfShape = new Shape[3];
		
		arrayOfShape[0] = new Rectangle();
		arrayOfShape[1] = new Triangle();
		arrayOfShape[2] = new Circle();
		
		for (int i = 0; i < arrayOfShape.length; i++) {
			arrayOfShape[i].draw();
			print(arrayOfShape[i]);
		}
	}
}
