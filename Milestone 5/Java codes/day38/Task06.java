package day38;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;


public class Task06 {

	@Test
	void testListSize() {
		List<String> names = Arrays.asList("john","ALex","alice","Saanjh");
		
		assertThat(names, hasSize(4));
	}
	
}
