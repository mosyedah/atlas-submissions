package day21;

public class HomeTask1 {
	public class BookDetails {
	    private String title;
	    private String author;
	    private double price;

	    public BookDetails(String title, String author, double price) {
	        this.title = title;
	        this.author = author;
	        this.price = price;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public double getPrice() {
	        return price;
	    }
	}

	public class BookFormatter {
	    public String formatTitle(String title) {
	        return "Title: " + title.toUpperCase();
	    }
	}

	public class PriceCalculator {
	    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
	        return originalPrice * (1 - discountPercentage);
	    }
	}

}
