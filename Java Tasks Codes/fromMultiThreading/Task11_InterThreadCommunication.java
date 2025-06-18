package fromMultiThreading;

public class Task11_InterThreadCommunication {



static class SharedResource {
    private boolean ready = false;

    synchronized void produce() {
        try {
        while (true) {
			
        	while (ready) {
        		wait();
        	}
        	System.out.println("Producing...");
        	ready = true;
        	notify();
		}    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void consume() {
        try {
        	while(true) {
        		
        		while (!ready) {
        			wait();
        		}
        		System.out.println("Consuming...");
        		ready = false;
        		notify();
        	}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(resource::produce);
        Thread consumer = new Thread(resource::consume);

        producer.start();
        consumer.start();
    }
}

