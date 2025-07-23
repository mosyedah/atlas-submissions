package DSAPractice;

import java.util.LinkedList;

public class Task01_day_14_LinkedListExample {
public static void main(String[] args) {
	LinkedList<String> fruits = new LinkedList<String>();
	fruits.add("Apple");
	fruits.add("Banana");
	fruits.addFirst("Orange");
	fruits.addFirst("Pear");
	fruits.addLast("Mango");
	
	fruits.removeFirst();
	fruits.removeLast();
	
	fruits.remove("Banana");
	
	System.out.println(fruits);
	
	for (String string : fruits) {
		System.out.println(string);
	}
	
	
}
}
