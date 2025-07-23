package fromStreams;



import java.lang.FunctionalInterface;


public class Task004_LambdaExpression  {
//this is functional interface
	@FunctionalInterface
	interface MyInterface{
		
		// abstract method
		double getPiValue();
// void setPiValue(double value);
	}


 public static void main( String[] args ) {

 // declare a reference to MyInterface
 MyInterface ref;
 
 // lambda expression
 ref = () -> 3.1415;
 
 System.out.println("Value of Pi = " + ref.getPiValue());
 } 
}
