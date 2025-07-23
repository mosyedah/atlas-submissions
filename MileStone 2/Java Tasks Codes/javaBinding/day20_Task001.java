package javaBinding;

public class day20_Task001 {
	public class Student {
	    private String name;
	    private int rollNo;
	    private int[] marks;
	    private double feesPaid;

	    public Student(String name, int rollNo, int[] marks, double feesPaid) {
	        this.name = name;
	        this.rollNo = rollNo;
	        this.marks = marks;
	        this.feesPaid = feesPaid;
	    }

	    public void registrationDetails() {
	        System.out.println("----- Registration Details -----");
	        System.out.println("Name     : " + name);
	        System.out.println("Roll No. : " + rollNo);
	    }

	    public void marksCalc() {
	        int total = 0;
	        for (int mark : marks) {
	            total += mark;
	        }
	        double average = (double) total / marks.length;
	        System.out.println("----- Marks Summary -----");
	        System.out.println("Total Marks  : " + total);
	        System.out.println("Average Marks: " + average);
	    }

	    public void feesCalc() {
	        double totalFees = 50000.0;
	        double balance = totalFees - feesPaid;
	        System.out.println("----- Fees Details -----");
	        System.out.println("Fees Paid     : ₹" + feesPaid);
	        System.out.println("Remaining Fees: ₹" + balance);
	    }
	}


}
