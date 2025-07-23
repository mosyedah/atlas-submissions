package fromExceptions;

import java.util.ArrayList;
import java.util.List;

public class Task012_ArrayListExample1 {
public static void main(String[] args) {
	List<String> names = new ArrayList<String>(10);
	
	String[] namearrayStrings = {
		"Alice","Bob","Charlie","David","Emily",	
		"Fazzy","Ginger","Hald","Indiana","John"
	};
	
	for(String name : namearrayStrings) {
		names.add(name);
		
	}
	
	for(String name : names ) {
		System.out.println(name);
	}
}
}
