package day21;

import java.io.FileWriter;
import java.io.IOException;
public class HomeTask02 {
	
	static class Customer {
	    private String name;
	    private String custID;

	    public Customer(String name, String custID) {
	        this.name = name;
	        this.custID = custID;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getCustID() {
	        return custID;
	    }
	}

	static class CustomerDataSaver {
	    public void saveCustomerData(Customer customer) {
	        try {
	            FileWriter fw = new FileWriter(customer.getName() + ".txt");
	            fw.write("The customer name is " + customer.getName() + "\t");
	            fw.write("The customer ID is " + customer.getCustID() + "\t");
	            fw.close();
	            System.out.println("The data is saved in the file with your name");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

	
	    public static void main(String[] args) {
	        Customer cobj = new Customer("John", "CID01");
	        CustomerDataSaver saver = new CustomerDataSaver();
	        saver.saveCustomerData(cobj);
	    }
	

}
