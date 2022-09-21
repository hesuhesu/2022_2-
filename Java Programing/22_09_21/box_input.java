package java_practice;

import java.util.Scanner;

class Box {
	int width,length,height;
	double getVolume() {		
		return (double) width*height*length; 
	}
}


public class box_test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Box  b;
		b = new Box(); 	
		
		System.out.print("가로를 입력하세요 : ");
		b.width = sc.nextInt();
		System.out.print("세로를 입력하세요 : ");
		b.length = sc.nextInt();
		System.out.print("높이를 입력하세요 : ");
		b.height = sc.nextInt();
		
		System.out.println("상자의 가로, 세로, 높이는 " + b.width + ", " + b.length+", " + b.height + "입니다.");
		System.out.println("상자의 부피는 " + b.getVolume() + "입니다.");
		
	}
	
}
