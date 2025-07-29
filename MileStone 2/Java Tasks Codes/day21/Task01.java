package day21;

import java.util.*;

public class Task01{
	public static void main(String[] args) {
		Animal obj = new Cat();
		obj.sound(); //Meow is the sound of cat
		
		List<Cat> Cobj = new ArrayList<>();
List<? extends Animal> Aobj = Cobj;  // this will give you a wildcard , 

	}
}

class Animal {
	void sound() {
		System.out.println(" sounds of different animals");
	}
}
class Cat extends Animal{
	@Override
	void sound() {
		System.out.println(" Meow is the sound of cat");
	}
} 