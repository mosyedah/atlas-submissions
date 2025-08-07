package day24.Task03.factory;

import day24.Task03.NoteBook.LongBook;
import day24.Task03.NoteBook.ShortBook;
import day24.Task03.product.NoteBook;

interface AbsNoteBookFactory {
	NoteBook createLongNoteBook();
	NoteBook createShortNoteBook();
}

public class NoteBookFactory implements AbsNoteBookFactory{
	@Override
	public NoteBook createLongNoteBook() {
		return new LongBook();
	}
	
	@Override
	public NoteBook createShortNoteBook() {
		return new ShortBook();
	}
}
