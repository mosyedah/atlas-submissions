package DSAPractice;

import java.util.Stack;

public class Task005_Day15 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println(stack);
		
		int popped = stack.pop();
		System.out.println(popped + "  is the popped obj");
		
		System.out.println(stack);
		
		
	}
}
