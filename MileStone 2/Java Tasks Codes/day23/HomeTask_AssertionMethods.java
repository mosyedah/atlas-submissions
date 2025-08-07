package day23;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Ignore;
import org.junit.Test;

public class HomeTask_AssertionMethods {
	@Test
	public void testBooleanTrue() {
		assertTrue(true);
	}
	
	@Test
	public void testBooleanFalse() {
		assertFalse(false);
	}
	
	@Test
	public void testThrowsRuntimeException() {
		assertThrows(RuntimeException.class, ()->{
			throw new RuntimeException("message");
		});
	}
	
	@Test
	public void testNotSame() {
		assertNotSame(new String("d"), new int[2]);
	}
	
	@Test
	public void testSame() {
		assertSame("","");
	}
	
	@Test(timeout = 1000)
	public void testArrayEquals() throws InterruptedException{
		Thread.sleep(1500);
		String[] a1 = {"",""};
		String[] a2 = {"",""};
		assertArrayEquals(a1,a2);
	}
	
	@Ignore
	@Test
	public void testArrayNotEquals() {
		String[] s1 = {"a","b"};
		String[] s2 = {"a","b"};
		assertFalse("Arrays should not be equal in values",Arrays.equals(s1, s2));
	}
}
