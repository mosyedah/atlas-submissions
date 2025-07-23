package day18;

import java.util.LinkedList;

class Task001 {

    LinkedList<Node>[] data = new LinkedList[10];

    public void put(String key, int value) {
        int index = index(key);

        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        for (Node e : data[index]) {
            if (e.keyval.equals(key)) {
                e.value = value;
                return;
            }
        }

        data[index].add(new Node(key, value));
    }

    static class Node {
        String keyval;
        int value;

        Node(String k, int v) {
            keyval = k;
            value = v;
        }
        
    }
    public int index(String key) {
    		return Math.abs(key.hashCode() % data.length);
    }
    
    public static void main(String[] args) {
    	Task001 task = new Task001();

        // Test inserting new entries
        task.put("apple", 10);
        task.put("banana", 20);
        task.put("orange", 30);

        // Test updating an existing key
        task.put("banana", 25);

        // Display the hash table contents
        for (int i = 0; i < task.data.length; i++) {
            if (task.data[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Task001.Node entry : task.data[i]) {
                    System.out.print("[" + entry.keyval + ": " + entry.value + "] ");
                }
                System.out.println();
            }
        }

	}
}

