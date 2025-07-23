package DSAPractice;

import java.util.LinkedList;

public class Task06_removeAnyElement {
		public static void main(String[] args) {
			LinkedList<String> fruits = new LinkedList<String>();
			fruits.add("Orange");
			fruits.add("Apple");
			fruits.add("Banna");
			fruits.add("Mango");
			fruits.add("Blueberry");
			
			fruits.remove("Apple");
			
			System.out.println(fruits);
		}
}
