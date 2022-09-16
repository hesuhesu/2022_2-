package java_practice;

import java.util.Scanner;

class Rocket{
	
	public int a,b;
	public int length;
	
	public Rocket(int i, int j, int k) {
		a = i; // 필드의 변수와 대입 변수를 메인 함수에서 대입.
		b = j;
		length = k;
	}
	
	public void getInfo() { // x, y, 높이를 표현.
		System.out.printf("%d, %d, %d\n",a, b, length);
	}
	
	public void moveUp() { // y 좌표 1 증가.
		b += 1;
		
	}
}

public class RocketTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x를 입력하세요 : ");
		int sc1 = sc.nextInt();
		
		System.out.print("y를 입력하세요 : ");
		int sc2 = sc.nextInt();
		
		System.out.print("length를 입력하세요 : ");
		int sc3 = sc.nextInt();
		 
		
		Rocket RK = new Rocket(sc1,sc2,sc3);
		
		
		RK.moveUp();
		RK.getInfo();
		System.out.println(RK);
		
		System.out.println("hello");
		
		
	}
}
