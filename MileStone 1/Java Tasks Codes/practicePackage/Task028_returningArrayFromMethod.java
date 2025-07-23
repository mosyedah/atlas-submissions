package practicePackage;

public class Task028_returningArrayFromMethod {
	public static void main(String[] args) {
		int[] arr = giveMeArray();
		for (int i : arr) {
			System.out.print(i +", ");
		}
	}

	private static int[] giveMeArray() {

		return new int[] { 1, 2, 3, 4, 5 };
	}

}
