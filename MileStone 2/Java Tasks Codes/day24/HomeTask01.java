package day24;

public class HomeTask01 {
	
	static class SingletonDemoClass{
		private static SingletonDemoClass instance;
		private SingletonDemoClass() {
			
		}
		
		public static SingletonDemoClass getInstance() {
			if(instance==null)
				instance = new SingletonDemoClass();
			return instance;
		}
	}
	
	public static void main(String[] args) {
		HomeTask01.SingletonDemoClass instance = HomeTask01.SingletonDemoClass.getInstance();
		HomeTask01.SingletonDemoClass instance2 = HomeTask01.SingletonDemoClass.getInstance();
		
		System.out.println(instance == instance2); //printing false why
		
	}
	
	
}
