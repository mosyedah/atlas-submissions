package practicePackage;

class Employee {
	private int pwd;
	protected int salary;
	public int empid;

	protected void setPwd(int pwd) {
		this.pwd = pwd;
	}

	protected int getPwd() {
		return pwd;
	}
}

public class Task037_EncapsulationExample extends Employee {
	public Task037_EncapsulationExample() {
		setPwd(1254);
		salary = 50000;
		empid = 10001;
	}

	void showDetails() {
		System.out.println("Password: " + getPwd());
		System.out.println("Salary: " + salary);
		System.out.println("EmpID: " + empid);
	}

	public static void main(String[] args) {
		Task037_EncapsulationExample obj = new Task037_EncapsulationExample();
		obj.showDetails();
	}
}
