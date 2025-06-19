package fromStreams;

import java.util.Arrays;
import java.util.List;

public class Task13_StreamExampleSort {
	public static void main(String[] args) {
		List<String> friends = Arrays.asList("Zara", "Ali", "Meena", "John", "Sara");

		System.out.println("Sorted Friends:");
		friends.stream().sorted().forEach(System.out::println);
	}

}
