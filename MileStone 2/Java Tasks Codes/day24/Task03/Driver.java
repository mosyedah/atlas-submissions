package day24.Task03;

import day24.Task03.factory.NoteBookFactory;
import day24.Task03.factory.TextBookFactory;
import day24.Task03.product.NoteBook;
import day24.Task03.product.TextBook;

public class Driver {
	
	public static void main(String[] args) {
		
		NoteBookFactory noteBookFactory = new NoteBookFactory();
		
		NoteBook longNoteBook = noteBookFactory.createLongNoteBook();
		NoteBook shortNoteBook = noteBookFactory.createShortNoteBook();
		
		longNoteBook.writing();
		shortNoteBook.writing();
		
		System.out.println("--------------------");
		
		TextBookFactory textBookFactory = new TextBookFactory();
		TextBook longTextBook = textBookFactory.createLongTextBook();
		TextBook shortTextBook = textBookFactory.createShortTextBook();
		
		longTextBook.reading();
		shortTextBook.reading();
	}
	
}
