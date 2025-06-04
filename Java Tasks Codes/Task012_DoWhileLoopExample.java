package practicePackage;

import java.util.Scanner;

public class Task012_DoWhileLoopExample {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correctId = "admin";
        String correctPassword = "1234";

        String loginId, password;

        do {
            System.out.print("Enter Login ID: ");
            loginId = sc.nextLine();
            System.out.print("Enter Password: ");
            password = sc.nextLine();

            if (!loginId.equals(correctId) || !password.equals(correctPassword)) {
                System.out.println("Invalid ID or Password");
            }
        } while (!loginId.equals(correctId) || !password.equals(correctPassword));

        System.out.println("Login successful");

	}

}
