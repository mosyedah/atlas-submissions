package DSAPractice;

import java.util.NoSuchElementException;

public class Task02_day14_SinglyLinkedList<V> {

	static class Node<T> {
		T data;
		Node<T> nextNode;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<V> headNode;
	private int size;

	public boolean isEmpty() {
		return headNode == null;
	}

	public int size() {
		return size;
	}

	public void add(V value) {
		if (value==null) {
			throw new IllegalArgumentException("Null values are not allowed");
		}
		Node<V> toAddNode = new Node<V>(value);
		if (isEmpty()) {
			headNode = toAddNode;
		} else {
			Node<V> current = headNode;
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = toAddNode;
		}
		size++;
	}

	public void addFirst(V value) {
		if (value==null) {
			throw new IllegalArgumentException("Null values are not allowed");
		}
		
		Node<V> toAddNode = new Node<V>(value);
		if (isEmpty()) {
			headNode = toAddNode;
		} else {
			toAddNode.nextNode = headNode;
			headNode = toAddNode;
		}
		size++;
	}

	public V removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("List is empty");
		} else {
			Node<V> oldHeadNode = headNode;
			headNode = headNode.nextNode;
			size--;
			return oldHeadNode.data;
		}
	}
	
	
	
	public V getElementAt(int index) {
		if (isEmpty()) {
			throw new IllegalArgumentException("Linked List is Empty");
		}
		if (size <= index || index < 0) {
			throw new IllegalArgumentException("Out Of Bounds, index starts at 0");
		}
		Node<V> current = headNode;
		for (int i = 0; i < index; i++) {
			current = current.nextNode;
		}
		return current.data;
	}

	public boolean addAt(int index, V value) {
		if (isEmpty()) {
			throw new IllegalArgumentException("Linked List is Empty");
		}
		if (size < index || index<0) {
			throw new IllegalArgumentException("Out Of Bounds, index starts at 0");
		}
		if (index == 0) {
			 addFirst(value);
			 return true;
		}
		if (index==size) {
			add(value);
			return true;
		}
		Node<V> current = headNode;
		Node<V> prev = null;
		Node<V> newNode = new Node<V>(value);
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.nextNode;
		}
		prev.nextNode = newNode;
		newNode.nextNode = current;
		size++;
		return true;

	}
	
	public boolean remove(V value) {
		if (value==null) {
			throw new IllegalArgumentException("Null values are not allowed");
		}
		if (isEmpty()) {
			throw new NoSuchElementException("List is Empty");
		}
		if(headNode.data.equals(value)) {
			 removeFirst();
			 return true;
		}
		Node<V> currentNode = headNode;
		Node<V> prevNode = null;
		while (currentNode!=null) {
			if (currentNode.data.equals(value)) {
				break;
			}
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		if (currentNode==null) {
			throw new NoSuchElementException("Element not found");
		}
		prevNode.nextNode = currentNode.nextNode;
		size--;
		return true;
		
	}
	
	
	/*
	 * returns -1 if not found , if found returns index
	 */
	public int contains(V value) {
		if (isEmpty()) {
			return -1;
		}
		int count = 0;
		Node<V> current = headNode;
		while (current!=null) {
			if (current.data.equals(value)) {
				return count;
			}
			current =current.nextNode;
			count++;
		}
		
		return -1;
	}
	
	
	
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("{ ");
			Node<V> current = headNode;
			while (current != null) {
				sb.append(current.data + " , ");
				current = current.nextNode;
			}
			sb.append(" }");
			return new String(sb);
		}
	}

	public static void main(String[] args) {
		Task02_day14_SinglyLinkedList<Integer> nums = new Task02_day14_SinglyLinkedList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.removeFirst();
		nums.add(40);
		nums.addFirst(44);

//		System.out.println(nums.getElementAt(29));
		nums.addAt(3, 66);
		System.out.println(nums);
		System.out.println(nums.size());
		nums.remove(44);
		System.out.println(nums);
		System.out.println(nums.size());
		System.out.println(nums.contains(220));
	}

}
