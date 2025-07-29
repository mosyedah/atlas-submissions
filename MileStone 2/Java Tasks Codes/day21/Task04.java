package day21;

import java.util.*;
public class Task04 {
		public static void main(String[] args) {
			Animal obj = new Cat();
	        List<Animal> animals = new ArrayList<>();
		obj.addAcat(animals); //
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
		void addAcat(List<? super Cat> cats) {
			cats.add(new Cat());
		}
	}
	static class Cat extends Animal{
		@Override
		void sound() {
			System.out.println(" Meow is the sound of cat");
		}
	} 

}
