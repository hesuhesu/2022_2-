package practice;

class  eThrow1 {
	
	public void ethrow1(String str1, String str2) {
		int number1 = Integer.parseInt(str1);
		int number2 = Integer.parseInt(str2);
		System.out.println(number1 + number2);
	}
}

class eThrow2 {
	
	public void ethrow2(String str1, String str2) {
		int number1 = Integer.parseInt(str1);
		int number2 = Integer.parseInt(str2);
		System.out.println(number1 / number2);
	}
}

public class MainTest {
	
	public static void main(String[] args) {
		
		eThrow1 e1 = new eThrow1();
		eThrow2 e2 = new eThrow2();
		
		try {
			e1.ethrow1("30", "e"); // eThrow1 먼저 호출
		}
		catch (NumberFormatException ex){
			System.out.println("숫자 모양의 문자열을 넣어주세요. 오류사항은 밑에 참조");
			ex.printStackTrace();
	    }
		
		try{
	       
			e2.ethrow2("20", "0"); // eThrow2 2번째 호출. 출력시 순서대로 출력된다.
	    }
		catch (NumberFormatException ex){
			System.out.println("숫자 모양의 문자열을 넣어주세요. 오류사항은 밑에 참조");
			ex.printStackTrace();
	    }
		catch (ArithmeticException ex){
			System.out.println("0이 아닌 문자열을 넣어주세요. 오류사항은 밑에 참조");
			ex.printStackTrace();
	    }
	}
}