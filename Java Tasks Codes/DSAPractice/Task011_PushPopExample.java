package DSAPractice;

import java.util.Spliterator;
import java.util.Stack;

public class Task011_PushPopExample {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("Apple");
		stack.push("Banana");
		stack.push("Orange");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		
		Spliterator<String> sp = stack.spliterator();
//		sp.forEachRemaining(System.out::println);
		sp.forEachRemaining(s->System.out.println(s));
		
	}
}
