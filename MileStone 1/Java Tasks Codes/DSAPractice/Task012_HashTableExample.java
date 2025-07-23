package DSAPractice;


import java.util.HashMap;
import java.util.Map;

public class Task012_HashTableExample {
    public static void main(String[] args) {
        // Creating a hash table using HashMap
        HashMap<String, String> hmap = new HashMap<>();
        HashMap<String, String> hmap2 = new HashMap<>();

        // Inserting key-value pairs
        hmap.put("name", "Alice");
        hmap.put("age", "25");
        hmap.put("city", "New York");
        hmap.put("email", "alice@example.com");
        // Inserting key-value pairs
        hmap2.put("name", "Alice");
        hmap2.put("age", "25");
        hmap2.put("city", "New York");
        hmap2.put("email", "alice@example.com");

        // Displaying the hash table
        System.out.println("Hash Table Contents:");
        for (Map.Entry<String, String> entry : hmap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        for (Map.Entry<String, String> entry : hmap2.entrySet()) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        System.out.println(hmap2);
    }
}



