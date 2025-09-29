package day38;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;


public class Task05 {
	
	@Test
	void testListEmpty() {
		List<String> names = new ArrayList<String>();
		assertThat(names, empty());
	}
}
