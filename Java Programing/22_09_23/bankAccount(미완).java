package practice;

class BankAccount {
	
	private int balance;
	
	
	public BankAccount(int balance) {
		this.balance = balance;
		System.out.print("BankAccount [balance="+ balance + "]\n");
	}
	
	
	public void trasfer(int amount, BankAccount otherAccount) {
		
		System.out.print("trasfer(" + amount + ")\n");
	}
	
	
	public int getbalance() {		return balance;	}
	public void setbalance(int balance) {		this.balance = balance;	}
	
	
}

public class practice_1 {

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
