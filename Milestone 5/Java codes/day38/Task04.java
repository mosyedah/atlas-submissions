package day38;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Task04 {
	
	@Test
	void testHasField() {
		Customer customer = new Customer("John");
		assertThat(customer, hasProperty("name"));
	}
	
}
