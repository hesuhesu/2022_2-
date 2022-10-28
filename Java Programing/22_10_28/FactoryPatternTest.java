package practice_java;

interface Shape {
	void draw();
}

class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Circle - draw() Method");
	}
}

class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Rectangle - draw() Method");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Square - draw() Method");
	}
}

class ShapeFactory {
	
	// 팩토리 메소드 - 객체 생성 후 반환
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		else if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}

public class FactoryPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
	}

}
