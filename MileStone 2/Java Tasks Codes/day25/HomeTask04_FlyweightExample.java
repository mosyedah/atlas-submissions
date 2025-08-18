package day25;
import java.util.HashMap;
import java.util.Map;

//Flyweight: stores common data
class CharacterStyle {
 private String font;
 private int size;

 public CharacterStyle(String font, int size) {
     this.font = font;
     this.size = size;
 }

 public void applyStyle(char c) {
     System.out.println("Char: " + c + " Font: " + font + " Size: " + size);
 }
}


class StyleFactory {
 private static Map<String, CharacterStyle> styles = new HashMap<>();

 public static CharacterStyle getStyle(String font, int size) {
     String key = font + size;
     styles.putIfAbsent(key, new CharacterStyle(font, size));
     return styles.get(key);
 }
}

//Client
public class HomeTask04_FlyweightExample {
 public static void main(String[] args) {
     CharacterStyle style1 = StyleFactory.getStyle("Arial", 12); // shared
     CharacterStyle style2 = StyleFactory.getStyle("Arial", 12); // same object reused

     style1.applyStyle('H');
     style2.applyStyle('i');

     System.out.println("Same object? " + (style1 == style2)); // true
 }
}

