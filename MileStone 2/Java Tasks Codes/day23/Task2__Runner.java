package day23;



import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Task2__Runner {
	public static void main(String[] args) {
		Result res = JUnitCore.runClasses(Task2_SuiteClass.class);
		if (res.wasSuccessful()) 
			System.out.println("All Tests Passed");
		else
			System.out.println("not all passed");
		
		
		for(Failure failure : res.getFailures())
			System.out.println(failure);
	}
}
