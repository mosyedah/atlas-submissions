package practicePackage;


public class Task024_ArrayExample4 {
	private static class Student{
		String name;
		public Student(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
	}
	public static void main(String[] args) {
		
		Student[] arr = new Student[3];
		arr[0] = new Student("Allen");
		arr[1] = new Student("Alice");
		arr[2] = new Student("Bob");
		
		for (Student student : arr) {
			System.out.println(student);
		}
	}
	
	
	
}
