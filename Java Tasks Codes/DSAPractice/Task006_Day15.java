package DSAPractice;

import java.util.Stack;

public class Task006_Day15 {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println(index(30));
	}
	
	static int index(int searchValue) {
		
		System.out.println(stack);
		
		int pos = -1;
		for (Integer integer : stack) {
			if (integer == searchValue) {
				return pos+1;
			}
			pos++;
		}
		return -1; //means not found
	}
}
