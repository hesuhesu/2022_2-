package practice;

class MyThread extends Thread {	
	
	String myName;
	public void MyRunnable(String name) {		myName = name;	}
	
	public void run() {					
			System.out.print(myName+" has been started");
	}
}

 
public class ThreadRunner {
	
	public static void main(String args[]) {
		
		
		
		Thread thread1 = new MyThread();
		thread1.setName("Thread #1");
		Thread thread2 = new MyThread();
		thread1.setName("Thread #2");
		
		
		
		Runnable runnable1 = new MyRunnable();
		Runnable runnable2 = new MyRunnable();
		
		
		
		Thread thread3 = new Thread(runnable1);
		thread3.setName("Thread #3");
		Thread thread4 = new Thread(runnable2);
		thread4.setName("Thread #4");
		
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
