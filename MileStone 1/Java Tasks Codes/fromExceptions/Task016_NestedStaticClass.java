package fromExceptions;

public class Task016_NestedStaticClass {
	  int x = 10;
	  static class InnerClass {
	    int y = 5;
	  }
	public static void main(String[] args) {
		Task016_NestedStaticClass.InnerClass obj = new Task016_NestedStaticClass.InnerClass();
		System.out.println(obj.y);
	}
}
