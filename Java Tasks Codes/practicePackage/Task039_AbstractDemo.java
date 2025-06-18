package practicePackage;



public class Task039_AbstractDemo {
    public static void main(String[] args) {
        Employee1 e = new SalariedEmployee("John Doe", "Hyderabad, TG", 43, 60000.0);
        System.out.println("\nCall mailCheck using Employee reference--");
        e.mailCheck();
        System.out.println("Monthly Pay: " + e.computePay());
    }
}

abstract class Employee1 {
    private String name;
    private String address;
    private int number;

    public Employee1(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public abstract double computePay();

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " at " + address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class SalariedEmployee extends Employee1 {
    private double annualSalary;

    public SalariedEmployee(String name, String address, int number, double annualSalary) {
        super(name, address, number);
        this.annualSalary = annualSalary;
    }

    @Override
    public double computePay() {
        System.out.println("Computing monthly pay for " + getName());
        return annualSalary / 12;
    }
}



