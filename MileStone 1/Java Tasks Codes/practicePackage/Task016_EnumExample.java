package practicePackage;

enum Colors{
	RED,GREEN,BLUE,YELLOW;
	
	public void sprayColor() {
		System.out.printf("Spraying %s color",this.name());
	}
}

public class Task016_EnumExample {
	public static void main(String[] args) {
		Colors color = Colors.RED;
		
		color.sprayColor();
	}
}
