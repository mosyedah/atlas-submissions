package DSAPractice;

public class Task009_Day15 {

	public static void main(String[] args) {

		MyDEqueue queue = new MyDEqueue();
		queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueueFront(5);
        queue.display();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeueRear());
        System.out.println(queue.peekFront());
        System.out.println(queue.size());
	}

	static class MyDEqueue {


		static class Node {
			int data;
			Node prev, next;

			Node(int data) {
				this.data = data;
			}
		}

		private Node head = null;
		private Node tail = null;
		private int size = 0;

		public void enqueue(int value) {
			Node node = new Node(value);
			if (tail == null) {
				head = tail = node;
			} else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			size++;
		}

		public void enqueueFront(int value) {
			Node node = new Node(value);
			if (head == null) {
				head = tail = node;
			} else {
				node.next = head;
				head.prev = node;
				head = node;
			}
			size++;
		}

		public int dequeue() {
			if (head == null)
				throw new RuntimeException("Queue is empty");
			int val = head.data;
			head = head.next;
			if (head != null)
				head.prev = null;
			else
				tail = null;
			size--;
			return val;
		}

		public int dequeueRear() {
			if (tail == null)
				throw new RuntimeException("Queue is empty");
			int val = tail.data;
			tail = tail.prev;
			if (tail != null)
				tail.next = null;
			else
				head = null;
			size--;
			return val;
		}

		public int peekFront() {
			if (head == null)
				throw new RuntimeException("Queue is empty");
			return head.data;
		}

		public int peekRear() {
			if (tail == null)
				throw new RuntimeException("Queue is empty");
			return tail.data;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int size() {
			return size;
		}

		public void clear() {
			head = tail = null;
			size = 0;
		}
		
		public void display() {
			if (isEmpty()) {
				System.out.println("[]");return;
			}
			StringBuilder builder = new StringBuilder();
			Node currentNode = head.next;
			builder.append("[ "+head.data);
			while (currentNode!=null) {
				builder.append(" , "+currentNode.data);
				currentNode=currentNode.next;
			}
			builder.append(" ]");
			System.out.println(builder);
		}
	}

}
