package practicePackage;

public class Task020_ArrayExampleChar {
	public static void main(String[] args) {
		char[] name = { 'a', 'h', 'm', 'e', 'd' };
		
		System.out.printf("name : %s length is %d \n" , new String(name), name.length);
		
		System.out.println("chars in name are ::");
		for (char c : name) {
			System.out.print(c+", ");
		}
	}
}
