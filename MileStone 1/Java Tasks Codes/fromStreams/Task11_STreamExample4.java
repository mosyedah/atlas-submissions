package fromStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11_STreamExample4 {
	public static void main(String[] args) {
		Integer[] num = { 10, 10, 34, 24, 24, 90, 12 };
		List<Integer> nums = Arrays.asList(num);
		System.out.println(nums.stream().distinct().collect(Collectors.toList()));

	}
}
