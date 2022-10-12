package practice_java;

abstract class Unit {
	int x;
	int y;
	String str;
	
	public abstract void move(int x, int y);
	
	public void stop(String str, int x, int y) {
		this.x = x;
		this.y = y;
		this.str = str;
		System.out.println("현재위치 : " + this.x + "," + this.y + "에" + " " + this.str + "가/이 멈춥니다.");
	}
}
class Tank extends Unit {
	
	public void move(int x, int y) {
		System.out.println("탱크의 위치:" + x +","+ y +"로 이동함.");
	}
	public void sizeMode() {
		System.out.println("공격모드 : 시즈모드 변환");
	}
}

class Marine extends Unit {
	public void move(int x, int y) {
		System.out.println("마린의 위치:" + x +","+ y +"로 이동함.");
	}
	public void stimPack() {
		System.out.println("공격모드 : 스팀팩 장전!");
	}
}

class DropShip extends Unit {
	public void move(int x, int y) {
		System.out.println("드랍쉽의 위치:" + x +","+ y +"로 이동함.");
	}
	public void load(){
		System.out.println("탑승모드 : 유닛 탑승!");
	}
	public void upload() {
		System.out.println("탑승모드 : 유닛 하강!");
	}
	
}


public class UnixEx {

	public static void main(String[] args) {
		
		System.out.println("-------------------------------------");
		Tank tank = new Tank();
		tank.move(100,300);
		tank.sizeMode();
		tank.stop("탱크",300,400);
		System.out.println("-------------------------------------");
		Marine marine = new Marine();
		marine.move(200,500);
		marine.stimPack();
		marine.stop("마린",300,400);
		System.out.println("-------------------------------------");
		DropShip dp = new DropShip();
		dp.move(500,600);
		dp.load();
		dp.upload();
		dp.stop("드림팀", 200,100);
	}

}
