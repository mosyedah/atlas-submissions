package practicePackage;

public class Task004_basicCalculator {
	 public static int add(int a, int b) {
	        return a + b;
	    }

	    public static int subtract(int a, int b) {
	        return a - b;
	    }

	    public static int multiply(int a, int b) {
	        return a * b;
	    }

	    public static int divide(int a, int b) {
	        if (b != 0) {
	            return a / b;
	        } else {
	            System.out.println("Division by zero is not allowed.");
	            return 0;
	        }
	    }

	    public static void main(String[] args) {
	        System.out.println("Main started");

	        int num1 = 20;
	        int num2 = 5;

	        int sum = add(num1, num2);
	        System.out.println("Sum of 2 numbers is " + sum);

	        int diff = subtract(num1, num2);
	        System.out.println("Diff of 2 numbers is " + diff);

	        int product = multiply(num1, num2);
	        System.out.println("Product of 2 numbers is " + product);

	        int quotient = divide(num1, num2);
	        System.out.println("Division of 2 numbers is " + quotient);

	        System.out.println("Main ended");
	    }
}	
