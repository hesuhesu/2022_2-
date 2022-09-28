package practice;

class Car {
	
	int model, maker;
	static int numberOfCars;
	
	public Car(int md, int mk){
		this.model = md;
		this.maker = mk;
		numberOfCars++;
	}
	
	public static int Host ()  {
		return numberOfCars;
	}
	
	
}

public class CarTest {

	public static void main(String[] args) {
		
		Car[] list;
		list = new Car[5];
		
		for(int i=0; i < 5; i++) {
			list[i] = new Car(i,i);
			System.out.println("자동차 1대 생선, 누적 생산량=" + Car.Host() + "대");
		}
		
	}
}
