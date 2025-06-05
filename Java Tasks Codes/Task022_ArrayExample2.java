package practicePackage;

public class Task022_ArrayExample2 {
	public static void main(String[] args) {
		int arr[];
		arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < arr.length; i++) {

			System.out.printf("Element at index %d is %d \n", i, arr[i]);
		}
	}
}
