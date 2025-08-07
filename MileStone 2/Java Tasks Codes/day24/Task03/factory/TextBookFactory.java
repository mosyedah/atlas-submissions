package day24.Task03.factory;

import day24.Task03.TextBook.LongBook;
import day24.Task03.TextBook.ShortBook;
import day24.Task03.product.TextBook;

interface AbsTextBookFactory {
	TextBook createLongTextBook();
	TextBook createShortTextBook();
}

public class TextBookFactory implements AbsTextBookFactory{
	@Override
	public TextBook createLongTextBook() {
		return new LongBook();
	}
	
	@Override
	public TextBook createShortTextBook() {
		return new ShortBook();
	}
}