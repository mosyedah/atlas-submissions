package fromMultiThreading;

import java.util.concurrent.locks.ReentrantLock;
public class Task8_ReentrantLockExample {

	static class Counter {
	    private int count = 0;
	    private final ReentrantLock lock = new ReentrantLock();

	    public void increment() {
	        lock.lock();   // acquire the lock
	        try {
	            count++;
	        } finally {
	            lock.unlock(); // always release the lock in finally
	        }
	    }

	    public int getCount() {
	        return count;
	    }
	}
	
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

        // Create two threads that increment the counter 1000 times each
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both to finish
        t1.join();
        t2.join();

        // Print the final count
        System.out.println("Final count: " + counter.getCount());



	}




}

