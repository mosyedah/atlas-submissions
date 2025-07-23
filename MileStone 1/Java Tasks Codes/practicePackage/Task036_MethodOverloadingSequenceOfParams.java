package practicePackage;

//Task036: Demonstrates method overloading with different sequence of parameters
public class Task036_MethodOverloadingSequenceOfParams {


	// Method with int first, then float
	static void add(int x, float y) {
		System.out.println("int x: " + x + ", float y: " + y);
	}

	// Overloaded method with float first, then int
	static void add(float x, int y) {
		System.out.println("float x: " + x + ", int y: " + y);
	}

	// Main method
	public static void main(String[] args) {
		add(10.50f, 60); // Calls float, int version
		add(100, 80.80f); // Calls int, float version
	}
}
