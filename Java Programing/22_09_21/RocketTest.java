package java_practice;

import java.util.Scanner;

class Person {
	private String name, mobile, office, email;
	
	public Person(String n,String m,String o,String e) {
		name = n; mobile = m; office = o; email = e;	
	}
	
	
	@Override  
	 public String toString() {
		return "Person [name = " + name + " mobile = " + mobile + " office = " + office + " email = " + email + "]";	
	}
	
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getMobile() {		return mobile;	}
	public void setMobile(String Mobile) {		this.name = mobile;	}
	public String getOffice() {		return office;	}
	public void setOffice(String office) {		this.name = office;	}
	public String getEmail() {		return email;	}
	public void setEmail(String email) {		this.name = email;	}
	
}

class Rocket{
	
	private int a,b,length;
	
	public Rocket(int i, int j, int k) {
		a = i; // 필드의 변수와 대입 변수를 메인 함수에서 대입.
		b = j;
		length = k;
	}
	
	public void getInfo() { // x, y, 높이를 표현.
		System.out.printf("x좌표는 : %d, y좌표는 : %d, 높이는 : %d\n",a, b, length);
	}
	
	public void moveUp() { // y 좌표 1 증가.
		b += 1;
	}
}

public class RocketTest {

	public static void main(String[] args) {
		
		Person obj = new Person("eun", "01012345678", "0511234567", "hesuhesu@naver.com");
		System.out.print(obj);
		System.out.println("");
		
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
		
		
		
		}
	}
