package practice;

import java.util.*;

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
		
		if(this.callback != null) {
			if (this.num == 1) {
				System.out.println("Caller : Input from Callee 1");
				this.callback.onInputOne(Callee.this);
			}
			else if (this.num == 2) {
				System.out.println("Caller : Input from Callee 2");
				this.callback.onInputTwo(Callee.this);
			}
			else {
				System.out.println("1과 2 중 하나를 입력해주시요!");
			}
		}
	}
}

public class CallerExample {

	public static void main(String[] args) {
		Callee callee = new Callee();
		
		// setCallBack 메소드 구현
		callee.setCallBack(new Callee.CallBack() {
			
			@Override
			public void onInputTwo(Callee callee) {
				System.out.println("callee's num : 2");
			}
			
			@Override
			public void onInputOne(Callee callee) {
				System.out.println("callee's num : 1");
			}
		});
		callee.execute();
	}

}
