package practicePackage;

public class Task027_PassingArrayToMethods {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 9, 0, 10, 19 };
		int sum = sumOfArr(arr);
		System.out.println("Sum of numbers in arr is "+sum);
	}

	private static int sumOfArr(int[] arr) {
		int sum =0;
		for (int i : arr) {
			sum+=i;
		}
		return sum;
	}
}
