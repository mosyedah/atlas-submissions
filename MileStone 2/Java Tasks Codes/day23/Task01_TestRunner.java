package day23;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Task01_TestRunner {
	public static void main(String[] args) {
		Result resObj = JUnitCore.runClasses(Task01_JunitTest.class);
		for(Failure oFailure : resObj.getFailures())
			System.out.println(oFailure);
		
		System.out.println(resObj.wasSuccessful());
	}
}
