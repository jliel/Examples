package threads;

class Clicker implements Runnable {
	long click = 0;
	Thread t;
	private volatile boolean running = true;
	
	public Clicker(int prioriti) {
		t = new Thread(this);
		t.setPriority(prioriti);
	}
	
	public void run() {
		while(running) {
			click++;
		}
	}
	
	public void stop() { 
		running = false;
	}
	
	public void start() {
		t.start();
	}
}

public class HiLoPri {
	public static void main(String args[]) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi = new Clicker(Thread.NORM_PRIORITY + 2);
		Clicker lo = new Clicker(Thread.MIN_PRIORITY);
		
		lo.start();
		hi.start();
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			System.out.println("Main thread interrumped.");
		}
		
		lo.stop();
		hi.stop();
		
		try {
			lo.t.join();
			hi.t.join();
		} catch(InterruptedException e) {
			System.out.println("InterrumpionException caught.");
		}			
		System.out.println("Low-priority thread: " + lo.click);
		System.out.println("High-priority thread: " + hi.click);
	}
}
