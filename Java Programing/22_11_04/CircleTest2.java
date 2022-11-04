package practice;

class Circle {
	int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	public boolean equals(Circle c1) {
		if(radius == c1.radius) return true;
		else return false;
	}
}

public class CircleTest2 {

	public static void main(String[] args) {
		Circle obj1 = new Circle(10);
		Circle obj2 = new Circle(10);
		if(obj1.equals(obj2)) System.out.println("2개의 원은 같습니다.");
		else System.out.println("2개의 원은 같지 않습니다.");

	}

}
