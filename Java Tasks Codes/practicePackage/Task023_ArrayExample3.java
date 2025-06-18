package practicePackage;


public class Task023_ArrayExample3 {
	private static class Student{
		String name;
		public Student(String name) {
			this.name = name;
		}
	}
public static void main(String[] args) {
	Student[] arr = new Student[3];
	arr[0] = new Student("Alen");
	arr[1] = new Student("Alice");
	arr[2] = new Student("Bob");
	
	for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i].name);
	}
}
}
