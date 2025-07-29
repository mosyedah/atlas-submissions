package day21;

import java.util.*;
public class Task03 {
		public static void main(String[] args) {
			Animal obj = new Cat();
	        List<Cat> cats = new ArrayList<>();
		cats.add(new Cat());
		obj.animalSound(cats); //
		}
	

	static class Animal {
		void sound() {
			System.out.println(" sounds of different animals");
		}
		void printList(List<?>  list) {
			for(Object element: list) {
				System.out.println(element);	
			} 
		}
		void animalSound(List<? extends Animal> animalList) {
			for(Animal elements : animalList)
				elements.sound();
			
		
		}
	}
	static class Cat extends Animal{
		@Override
		void sound() {
			System.out.println(" Meow is the sound of cat");
		}
	} 

}
