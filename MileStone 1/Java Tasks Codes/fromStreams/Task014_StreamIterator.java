package fromStreams;

import java.util.stream.Stream;

public class Task014_StreamIterator {
	public static void main(String[] args) {
		Stream<Integer> nums = Stream.iterate(1, n -> n+1).limit(20);
		
//		nums.limit(20).forEach(System.out::println);
		// a stream can have only one terminal operation in its lifecycle
		nums.limit(10).forEach(i->System.out.print(i+", "));
	}
}
