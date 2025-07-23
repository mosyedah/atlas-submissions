package practicePackage;


class Customer1 {
	String items = "Tomatoes";
	
	void billing() {
		System.out.println("inside super billing");
		System.out.println("Billing Items : "+items);
	}
	
}
public class Task033_InheritanceSuperKeywordExample extends Customer1 {




	String items = "Onions";  // This shadows Customer.items
	
	void billing() {
		super.billing();
		super.items = "Potatoes";
		System.out.println("Child's items: " + items);         // prints "Onions"
		System.out.println("Parent's items: " + super.items);  // prints "Tomatoes"
	}
	
	public static void main(String[] args) {
		Task033_InheritanceSuperKeywordExample m = new Task033_InheritanceSuperKeywordExample();
//		m.billing();
		
		Customer1 obj = new Task033_InheritanceSuperKeywordExample();
		
		obj.billing();
		
		
	}
}
