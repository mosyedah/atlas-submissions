package DSAPractice;

import java.util.LinkedList;

public class Task05_day2_LinkedListReplace {
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<String>();
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Banna");
		fruits.add("Mango");
		fruits.add("Blueberry");
		
		fruits.set(2, "Banana");
		
		System.out.println(fruits);
		
	}
}
