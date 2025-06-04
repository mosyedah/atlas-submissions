package practicePackage;

import java.util.Scanner;

public class Task006_InputFromUser {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Id: ");
		String id = scanner.nextLine();

		System.out.print("Pwd: ");
		String pwd = scanner.nextLine();

		String maskedPwd = "*".repeat(pwd.length());

		System.out.println("\nHi ,");
		System.out.println("\tYour login id is " + id);
		System.out.println("And your pwd is " + maskedPwd);
	}
}
