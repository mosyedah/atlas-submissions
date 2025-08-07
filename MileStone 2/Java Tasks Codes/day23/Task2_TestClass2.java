package day23;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class Task2_TestClass2 {
	@Test
	public void testNullPointerException() {
		assertThrows(NullPointerException.class,()->{
			throw new NullPointerException();
		} );
	}
}
