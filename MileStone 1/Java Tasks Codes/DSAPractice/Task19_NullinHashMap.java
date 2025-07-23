package DSAPractice;

import java.util.HashMap;

public class Task19_NullinHashMap {

	public static void main(String[] args) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put(null, 10);
		hmap.put(null, 20);
		
		System.out.println(hmap.get(null));
	}
}
