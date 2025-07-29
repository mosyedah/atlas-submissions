package day20;

public class day20_Task003 {
	interface PaymentMethod {
	    void pay(double amount);
	}


	class CreditCardPayment implements PaymentMethod {
	    public void pay(double amount) {
	        System.out.println("Processing credit card payment of $" + amount);
	    }
	}

	class PayPalPayment implements PaymentMethod {
	    public void pay(double amount) {
	        System.out.println("Processing PayPal payment of $" + amount);
	    }
	}


	class BitcoinPayment implements PaymentMethod {
	    public void pay(double amount) {
	        System.out.println("Processing Bitcoin payment of $" + amount);
	    }
	}


}
