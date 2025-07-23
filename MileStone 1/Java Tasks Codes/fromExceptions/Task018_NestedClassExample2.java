package fromExceptions;

public class Task018_NestedClassExample2 {
	private int X = 10;
	
	class InnerClass{
		public int getXofOuter() {
			return X;
		}
	}
	
	public static void main(String[] args) {
		Task018_NestedClassExample2 outer = new Task018_NestedClassExample2();
		Task018_NestedClassExample2.InnerClass inner = outer.new InnerClass();
		System.out.println(inner.getXofOuter());
	}
}
