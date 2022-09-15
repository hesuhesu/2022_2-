package java_practice;

import java.util.Scanner;

public class java_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int b = 0;
		
		while (true) {
			System.out.print("정답을 추측하여 보시오:");
			int a = sc.nextInt();
			if (a == 59) {
				b += 1;
				System.out.println("축하합니다. 시도횟수=" + b);
				break;
			}
			else if (a < 59) {
				b += 1;
				System.out.println("낮다");
			}
			else {
				b += 1;
				System.out.println("높다");
			}
			
		}
		
	}

}
