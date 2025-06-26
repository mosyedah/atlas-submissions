package DSAPractice;

public class NodeClassExample {
	static class Node<T>{
		T data;
		Node<T> nextNode;
		public Node(T data) {
			this.data = data;
		}
	}
}
