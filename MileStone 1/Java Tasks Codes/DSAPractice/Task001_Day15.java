package DSAPractice;

public class Task001_Day15 {
	static class Node {
		Node nextNode;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	
	
	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		
		n1.nextNode = n2;
		n2.nextNode = n3;
		n3.nextNode = n4;
		n4.nextNode = n5;
		
		
		Node current = n1;
		while (current!=null) {
			System.out.println(current.data);
			current = current.nextNode;
		}
	}
}
