package day23;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Task2_TestClass1 {
	@Test(timeout = 1000)
	public void testMessage() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals("Hello World", "Hello World");
	}
}
