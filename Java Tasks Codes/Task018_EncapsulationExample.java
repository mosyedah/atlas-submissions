package practicePackage;

class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.isBlank()) {
			this.name = name;

		}
	}

}

public class Task018_EncapsulationExample {
	public static void main(String[] args) {
		Person person = new Person();
		
		person.setName("John");
		
		System.out.println("Person name is "+person.getName());
		
	
	}
}
