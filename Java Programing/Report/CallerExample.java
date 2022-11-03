package practice;

import java.util.*;
/*

1. 영상 수업에 포함된 callback 함수 예제를 활용하여 아래의 코드를 완성하라.
2. setCallBack() 메소드를 호출하면서 callback 메소드를 전달하도록 구현, 인터페이스 CallBack을 구현하는 익명 클래스 형태로 구현할 것
3. execute() 메소드를 호출하여 사용자 입력을 시작함
[Hint] 수업 자료에 포함된 callback 예제와 거의 유사한 형태임

출력 예시 :

1과 2중 하나를 입력하세요.
1
Caller : Input from Callee 1
callee's num : 1

 */

class Callee {
	public interface CallBack {
		public void onInputOne(Callee callee);
		public void onInputTwo(Callee callee);
	}
	
	private Integer num;
	private CallBack callback;
	
	public Callee() {
		this.num = 0;
		this.callback = null;
	}
	
	public void setCallBack(CallBack callback) {
		this.callback = callback;
	}
	
	public Integer getNum() {
		return this.num;
	}
	
	// execute 함수 구현
	public void execute() {
		Scanner sc = new Scanner(System.in);
		this.num = 0;
		System.out.println("1과 2중 하나를 입력하세요.");
		this.num = sc.nextInt();
	}
	
}

public class CallerExample {

	public static void main(String[] args) {
		Callee callee = new Callee();
		
		// setCallBack 메소드 구현
		
		callee.execute();
	}

}
