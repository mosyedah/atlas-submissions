package fromStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task007_StreamExample2 {
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.add(8);
		
//		nums.stream()
//		.map((i) -> i*i)
//		.forEach(i -> System.out.println(i));
		
		List<Integer> squares =nums.stream().map(i->i*i).collect(Collectors.toList());
		
		for (Integer integer : squares) {
			System.out.println(integer);
		}
	}
}
