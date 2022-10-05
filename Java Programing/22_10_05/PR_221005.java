package practice_java;

class Base {
	public Base() {
		System.out.println("Base() 생성자");
	}
}

class Derived extends Base {
	public Derived() {
		System.out.println("Derived() 생성자");
	}
}

public class PR_221005 {

	public static void main(String[] args) {
		
		Derived dv = new Derived();
	}

}
