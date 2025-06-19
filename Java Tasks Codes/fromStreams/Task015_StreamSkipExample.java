package fromStreams;

import java.util.ArrayList;
import java.util.List;

public class Task015_StreamSkipExample {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 30; i++) {
			nums.add(i);
		}
		nums.stream().skip(15).forEach(System.out::println);
		
	}
}
