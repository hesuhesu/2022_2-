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
		else if(name.equalsIgnoreCase("Super")) {
			return new SuperRobot();
		}
		else if(name.equalsIgnoreCase("Power")) {
			return new PowerRobot();
		}
		return null;
	}
}

public class FactoryMain {

	public static void main(String[] args) {
		SuperRobotFactory S = new SuperRobotFactory();
		
		Robot R1 = S.createRobot("Super");
		System.out.println(R1.getName());
		
		Robot R2 = S.createRobot("Power");
		System.out.println(R2.getName());
	}
}
