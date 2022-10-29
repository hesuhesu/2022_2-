package doit;

abstract class Robot {
	public abstract String getName();
}
abstract class RobotFactory{
	abstract Robot createRobot(String name);
}


class SuperRobot extends Robot{
	public String getName() {
		return "SuperRobot";
	}
}
class PowerRobot extends Robot{
	public String getName() {
		return "PowerRobot";
	}
}


class SuperRobotFactory extends RobotFactory{
	
	public Robot createRobot(String name) {
		if(name == null) {
			return null;
		}
		else if(name.equalsIgnoreCase("SuperRobot")) {
			return new SuperRobot();
		}
		else if(name.equalsIgnoreCase("PowerRobot")) {
			return new PowerRobot();
		}
			return null;
	}
}

class ModifiedSuperRobotFactory extends RobotFactory{  // 새로 생성한 class입니다.
	
	@SuppressWarnings("deprecation")
	Robot createRobot(String name) {
		String Name = "doit."+ name;
		try {                             
			Class<?> nameRobot = Class.forName(Name); 
			// Class.forName메소드는 매개값으로 주어진 클래스를 찾지 못하면 ClassNotFoundException 예외를 발생시키기 때문에 예외 처리가 필요(출처 : https://kephilab.tistory.com/97)
			Object obj = nameRobot.newInstance(); 
			return (Robot)obj;
		} 
		catch (Exception e) {
			return null;
		}
	}
}
		
public class FactoryMain {

	public static void main(String[] args) {
		
		SuperRobotFactory S1 = new SuperRobotFactory();
		ModifiedSuperRobotFactory S2 = new ModifiedSuperRobotFactory(); // 업캐스팅을 써도 되지만 편의상 같은 class로 선언했습니다. 
		
		System.out.println(S1.createRobot("SuperRobot").getName()); // 앞의 제출 과제에서는 Super만 했지만 통일성을 위해 class의 full name을 쓰는 방향으로 변경하였습니다.
		System.out.println(S1.createRobot("PowerRobot").getName());
		
		System.out.println(S2.createRobot("SuperRobot").getName()); // SuperRobotFactory와 비슷하게 구현. 여기가 main class의 구현 방식입니다.
		System.out.println(S2.createRobot("PowerRobot").getName());
		}
}
