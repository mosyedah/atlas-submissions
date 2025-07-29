package day21;

import java.util.*;

public class Task02{
	public static void main(String[] args) {
		Animal obj = new Cat();
// 		obj.sound(); //Meow is the sound of cat
		
// 		List<Cat> Cobj = new ArrayList<>();
// List<? extends Animal> Aobj = Cobj;  // this will give you a wildcard , 
    List<Cat2> clist = new ArrayList<>();
	clist.add(new Cat2());
	//obj.printList(clist); //
	}
}

class Animal2 {
	void sound() {
		System.out.println(" sounds of different animals");
	}
	void printList(List<?>  list) {
		for(Object element: list) {
			System.out.println(element);	
		} 
	}
}
class Cat2 extends Animal2{
	@Override
	void sound() {
		System.out.println(" Meow is the sound of cat");
	}
} 