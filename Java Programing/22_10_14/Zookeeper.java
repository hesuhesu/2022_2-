package practice_java;

abstract class Animal {
	String name;
	public abstract void setName(String name);
}


interface Predator {
	void feed();
}


class Tiger extends Animal {
	public void setName(String name) {
		System.out.println("feed Apple");
	}
}
class Lion extends Animal {
	public void setName(String name) {
		System.out.println("feed banana");
	}
}
class Crocodile extends Animal {
	public void setName(String name) {
		System.out.println("feed Gogi");
	}
}



public class Zookeeper {
	
	public void feed(Animal S) {
		S.setName("S");
	}
	
	
	public static void main(String[] args) {
		
		Zookeeper zooKeeper = new Zookeeper();
		
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		Crocodile crocodile = new Crocodile();
		
		zooKeeper.feed(tiger);
		zooKeeper.feed(lion);
		zooKeeper.feed(crocodile);
	}
}
