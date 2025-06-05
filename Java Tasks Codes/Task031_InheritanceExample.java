package practicePackage;

class Calculation {
	   int z;
		
	   public void addition(int x, int y) {
	      z = x + y;
	      System.out.println("The sum of the given numbers:"+z);
	   }
		
	   public void Subtraction(int x, int y) {
	      z = x - y;
	      System.out.println("The difference between the given numbers:"+z);
	   }
	}


public class Task031_InheritanceExample extends Calculation{
	 public void multiplication(int x, int y) {
	      z = x * y;
	      System.out.println("The product of the given numbers:"+z);
	   }
		
	   public static void main(String args[]) {
	      int a = 20, b = 10;
	      Task031_InheritanceExample demo = new Task031_InheritanceExample();
	      demo.addition(a, b);
	      demo.Subtraction(a, b);
	      demo.multiplication(a, b);
	   }

}
