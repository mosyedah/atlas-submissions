package day38;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Task01 {
	
	@Test
	public void hamcrestMethod() {
		assertThat("Hello", equalToIgnoringCase("hello"));
	}

}
