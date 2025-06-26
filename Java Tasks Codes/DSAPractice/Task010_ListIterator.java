package DSAPractice;

import java.util.LinkedList;
import java.util.ListIterator;

public class Task010_ListIterator {
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<String>();
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Banna");
		fruits.add("Mango");
		fruits.add("Blueberry");
		
		ListIterator<String> iterator = fruits.listIterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
