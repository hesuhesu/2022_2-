package practice_java;

class Animal{
	public static void A() {
		System.out.println("static method in Animal");
	}
}

public class Dog extends Animal{
	public static void A() {
		System.out.println("static method in Dog");
	}
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Animal a = dog;
		a.A();
		dog.A();

	}

}
