package practicePackage;

public class Task003_swapTwoNum {
	static int a = 2, b = 5;

	public static void main(String[] args) {
		System.out.printf("numbers before swap a : %d ,b :  %d \n", a, b);
		swap();
		System.out.printf("numbers after swap a : %d ,b :  %d \n", a, b);

	}

	public static void swap() {
		int temp = a;
		a = b;
		b = temp;
	}

}
