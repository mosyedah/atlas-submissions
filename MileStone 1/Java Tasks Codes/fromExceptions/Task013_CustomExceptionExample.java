package fromExceptions;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class Task013_CustomExceptionExample {
	public static void main(String[] args) {
		try {
			throw new InvalidAgeException("invalid age");
			
		} catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Hello");
	}
	
	
}
