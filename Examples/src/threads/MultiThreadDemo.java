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
		NewThread ob1 = new NewThread("one");
		NewThread ob2 = new NewThread("two");
		NewThread ob3 = new NewThread("three");
		
		System.out.println("Thread one is alive: " 
							+ ob1.t.isAlive());
		System.out.println("Thread two is alive: " 
							+ ob2.t.isAlive());
		System.out.println("Thread three is alive: " 
							+ ob3.t.isAlive());
		
		try {
			// Thread.sleep(10000);
			System.out.println("Waiting for threads to finish.");
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch(InterruptedException e) {
			System.out.println("Main thread interrumped.");
		}
		System.out.println("Thread one is alive: " 
							+ ob1.t.isAlive());
		System.out.println("Thread two is alive: " 
							+ ob2.t.isAlive());
		System.out.println("Thread three is alive: " 
							+ ob3.t.isAlive());
		System.out.println("Main Thread exiting");
	}
}
