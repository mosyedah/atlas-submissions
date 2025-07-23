package fromStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task009_StreamExample3 {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			nums.add(i);
		}
		
		List<Integer> oddNums = nums.stream().filter(i->i%2!=0).collect(Collectors.toList());
		System.out.println(oddNums);
	}
}
