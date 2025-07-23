package DSAPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Spliterator;

public class Task013_SplitIterator {
	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("Orange");
		fruits.add("Apple");
		fruits.add("Banna");
		fruits.add("Mango");
		fruits.add("Blueberry");
		
		Spliterator<String> spI = fruits.spliterator();
		
		Spliterator<String> split1 = spI.trySplit();
		
		
		split1.forEachRemaining(s->System.out.println(s));
		
	}
}
