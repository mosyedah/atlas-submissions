package fromMultiThreading;

class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;

	RunnableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
// Let the thread sleep for a while.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");

	}

	public void start1() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
			System.out.println("I'm in start1");
			System.out.println("I'm in start2");
			System.out.println("I'm in start3");
			System.out.println("I'm in start4");
			System.out.println("I'm in start5");
		}
	}
}

public class Task2_FirstExampleMultiThreading {
	public static void main(String args[]) {
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start1();
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start1();
	}
}
