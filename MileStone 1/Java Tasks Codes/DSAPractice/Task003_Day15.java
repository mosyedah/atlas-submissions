package DSAPractice;

public class Task003_Day15 {
	public static void main(String[] args) {
		CircularLinkedList c = new CircularLinkedList();
		c.add(10);
		c.add(20);
		c.add(30);
		c.add(40);
		c.add(50);
		System.out.println(c);
	}
	
	static class Node{
		int data;
		Node nextNode;
		public Node(int data) {
			this.data = data;
		}
		
		
	}
	
	static class CircularLinkedList{
		private Node headNode; 
		private Node tailNode;
		private int size;
		
		boolean isEmpty() {
			return headNode == null;
		}
		
		int size(){
			return size;
		}
		
		
		
		void add(int value) {
			Node newNode = new Node(value);
			if(isEmpty()) {
				headNode = newNode;
				tailNode = newNode;
				tailNode.nextNode = headNode;
			}
			else {
				tailNode.nextNode = newNode;
				newNode.nextNode = headNode;
				tailNode = newNode;
			}
			size++;
		}
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			if (isEmpty()) {
				return "[]";
			}
			builder.append("[ "+headNode.data);
			Node current = headNode.nextNode;
			
			while (current!=headNode) {
				builder.append(", "+current.data);
				current = current.nextNode;
			}
			builder.append(" ]");
			
			return new String(builder);
		}
	}
	
	
}
