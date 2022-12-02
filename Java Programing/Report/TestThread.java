package practice;

class MyThread extends Thread {	
	
	// (Math.random() * (n2 - n1 + 1)) + n1 .. 이 때 n2는 범위내 최대값 n1은 최솟값이다.
	float delay = (int)(Math.random()*4001)+1000; 
	
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" has been started");
		
		try{
		    Thread.sleep((int)delay);
		}catch(InterruptedException e){
		    e.printStackTrace();
		}
		System.out.println(threadName + " has been ended ("+delay+"ms)");
	}
	
}

class MyRunnable implements Runnable {
	
	float delay = (int)(Math.random()*4001)+1000; 
	
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" has been started");
		
		try{
		    Thread.sleep((int)delay);
		}catch(InterruptedException e){
		    e.printStackTrace();
		}
		System.out.println(threadName + " has been ended ("+delay+"ms)");
	}
}


public class TestThread {
	
	public static void main(String args[]) {
		
		
		// 스레드 객체 생성
		Thread thread1 = new MyThread();
		thread1.setName("Thread #1");
		Thread thread2 = new MyThread();
		thread2.setName("Thread #2");
		
		
		// 런에이블 객체 생성
		Runnable runnable1 = new MyRunnable();
		Runnable runnable2 = new MyRunnable();
		
		Thread thread3 = new Thread(runnable1);
		thread3.setName("Thread #3");
		Thread thread4 = new Thread(runnable2);
		thread4.setName("Thread #4");
		
		
		// 모든 스레드 시작
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
