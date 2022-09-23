package java_practice;

class BankAccount {
	
	private int i1, i2, balance;
	
	public BankAccount(int a) {
		balance = a;
		System.out.print("BankAccount [balance="+ a + "]");
	}
	
	public trasfer(int amount, ) {
		
	}
	
	/*
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	 */
	
}

public class Test {

	public static void main(String[] args) {
	
	BankAccount myAccount1 = new BankAccount(10000);
	BankAccount myAccount2 = new BankAccount(0);
	System.out.println(myAccount1);
	System.out.println(myAccount2 + "\n");
	
	
	myAccount1.trasfer(1000, myAccount2);
	System.out.println(myAccount1);
	System.out.println(myAccount2);
	}

}
