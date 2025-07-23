package practicePackage;

// Task035: Demonstrates method overloading with different types of parameters
public class Task035_MethodOverloadingTypeOfParams {

	// Method with two char parameters
	static void add(char x, char y) {
		System.out.println("char x: " + x + ", char y: " + y);
	}

	// Overloaded method with two int parameters
	static void add(int x, int y) {
		System.out.println("int x: " + x + ", int y: " + y);
	}

	// Main method
	public static void main(String[] args) {
		add('d', 'a'); // Calls the char version
		add(100, 100); // Calls the int version
	}

}
