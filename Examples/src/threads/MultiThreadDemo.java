package threads;

class NewThread implements Runnable {
	String name;
	Thread t;
	
	public NewThread(String name) {
		this.name = name;
		t = new Thread(this, this.name);
		System.out.println("New Thread: " + t);
		t.start();
	}
	
	public void run() {
		try {
			for(int i=5; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			System.out.println(name + "Interrumped");
		}
		System.out.println(name + " exiting");
	}
}

public class MultiThreadDemo {
	public static void main(String args[]) {
		new NewThread("one");
		new NewThread("two");
		new NewThread("three");
		
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			System.out.println("Main thread interrumped.");
		}
		System.out.println("Main Thread exiting");
	}
}
