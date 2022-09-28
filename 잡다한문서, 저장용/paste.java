package java_practice;

class Car {
	int a;
	String model, maker;
	static int numberOfCars;
	
	public Car(int a){
		this.a = a;
		numberOfCars++;
		
	}
	public static Car Stop(int p) {
		;
		
	}
	
	
}

public class Cartest {

	public static void main(String[] args) {

		Car[] list;
		list = new Car[5];
		
		for(int i=0; i < list.a; i++) {
			list[i] = new Car(i);
			System.out.println("자동차 1대 생선, 누적 생산량=" + list[i] + "대");
		}
		
		
		
	}

}
