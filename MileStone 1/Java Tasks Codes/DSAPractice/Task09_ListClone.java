package DSAPractice;

import java.util.LinkedList;

public class Task09_ListClone {
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<String>();
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Banna");
		fruits.add("Mango");
		fruits.add("Blueberry");
		
		LinkedList<String> copyFruits = (LinkedList<String>) fruits.clone();
	}
}
