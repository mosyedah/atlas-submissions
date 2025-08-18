package day26;


class HomeTask01_StrategyPattern {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        double amount = 100.0;
        ps.setStrategy(new PaypalPayment("sssss"));
        ps.checkout(amount);
        // cux now chooses different strategy at checkout page
        ps.setStrategy(new CreditCardPayment(11111));
        ps.checkout(amount);
    }
}
class PaypalApi{
    public static boolean validToken(String token){
        return token.length()>5;
    }
}

class CardApi{
    public static boolean validCard(int cardNo){
        return cardNo>10000;
    }
}

interface PaymentStrategy{
    void pay(double amount);
}

class PaypalPayment implements PaymentStrategy{
    String authTokenFromPaypal;
    
    PaypalPayment(String authTokenFromPaypal){
        this.authTokenFromPaypal = authTokenFromPaypal;
    }
    @Override
    public void pay(double amount ){
        if(PaypalApi.validToken(authTokenFromPaypal))//example connectin to paypal API 
            System.out.println("Payed with Paypal , Amount ::: "+amount);
        else
            System.out.println("Payment failed with Paypal");
        
    }
}
class CreditCardPayment implements PaymentStrategy{
    int cardNo;
    
    CreditCardPayment(int cardNo){
        this.cardNo = cardNo;
    }
    
    @Override
    public void pay(double amount ){
        if(CardApi.validCard(cardNo)) 
            
        System.out.println("Payed with Credit Card , Amount ::: "+amount);
        else 
        System.out.println("Payment failed with credit card, try a different method");
    }
}

class PaymentService {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }
    public void checkout(double amount){
        if(strategy==null) throw new IllegalArgumentException("No strategy assigned");
        strategy.pay(amount);
    }
}

