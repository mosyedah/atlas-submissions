package practicePackage;

public class Task034_MethodOverloadingDiffParamCount {

	static void add(int x, int y) {
		System.out.println("x: " + x + ", y: " + y);
	}
	
	static void add(int x, int y, int z) {
		System.out.println("x: " + x + ", y: " + y + ", z: " + z);
	}
	
	public static void main(String[] args) {
		add(10, 20, 30);    // Calls method with 3 parameters
		add(50, 100);       // Calls method with 2 parameters
	}
}




