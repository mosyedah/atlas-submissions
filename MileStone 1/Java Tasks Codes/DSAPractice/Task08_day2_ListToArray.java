package DSAPractice;

import java.util.LinkedList;

public class Task08_day2_ListToArray {
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<String>();
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Banna");
		fruits.add("Mango");
		fruits.add("Blueberry");
		
		String[] fruitsArray = fruits.toArray(new String[0]);
		for (String string : fruitsArray) {
			System.out.println(string);
		}
	}
}
