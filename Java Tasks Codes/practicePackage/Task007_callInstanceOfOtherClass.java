package practicePackage;

class Customer {
	String nameString = "Customer Name";

}

public class Task007_callInstanceOfOtherClass {
	public static void main(String[] args) {
		Customer customer = new Customer();
		System.out.println(customer.nameString);
	}
}
