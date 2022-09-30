package practice_java;

class Animal{
	
	void move() {
		System.out.println("걸을 수 있음");
	}
	void makesound(){
		
	}
	
	
	
}

class Bird extends Animal{
	void makesound() {
		System.out.println("노래 부를 수 있음");
	}
	void fly() {
		System.out.println("날 수 있음");
	}
}

class Monkey extends Animal{
	void move() {
		System.out.println("두 발 네 발 걷기 모두 가능");
	}
	
	void makesound() {
		System.out.println("울음 소리를 낼 수 있음");
	}
	void jump() {
		System.out.println("나무 사이로 점프할 수 있음");
	}
}

public class AnimalTest {

	public static void main(String[] args) {

		Bird bird = new Bird();
		Monkey monkey = new Monkey();
		
		bird.move();
		monkey.move();
		
		bird.fly();
		monkey.jump();
		
		bird.makesound();
		monkey.makesound();
	}

}
