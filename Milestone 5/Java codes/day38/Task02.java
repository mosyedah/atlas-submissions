package day38;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class Task02 {
	@Test
	void toStringTest() {
		Customer customer = new Customer("John");
		String string = customer.toString();
		
		assertThat(customer, hasToString(string));
	}
}
