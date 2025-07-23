package DSAPractice;

import java.util.LinkedList;

public class Task07_LinkedListTraversal {
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<String>();
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Banna");
		fruits.add("Mango");
		fruits.add("Blueberry");
		
		System.out.println("PRinting with Foreach\n");
		for (String string : fruits) {
			System.out.println(string);
		}
		
		System.out.println("\nPrinting with for\n");
		int size = fruits.size();
		for (int i = 0; i <size ; i++) {
			System.out.println(fruits.get(i));
		}
	}
	
	
}
