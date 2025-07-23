package DSAPractice;


public class Task014_HashTableCustom {

    public static class HashTable<Key, Value> {

        private class HashTableNode {
            private Key key;
            private Value value;
            private boolean active;
            private boolean tombstoned;

            public HashTableNode() {
                key = null;
                value = null;
                active = false;
                tombstoned = false;
            }

            public HashTableNode(Key initKey, Value initData) {
                key = initKey;
                value = initData;
                active = true;
                tombstoned = false;
            }
        }

        private final static int TABLE_SIZE = 9;
        private Object[] table;

        public HashTable() {
            table = new Object[TABLE_SIZE];
            for (int j = 0; j < TABLE_SIZE; j++)
                table[j] = new HashTableNode();
        }

        @SuppressWarnings("unchecked")
        public Value put(Key key, Value value) {
            int hash = Math.abs(key.hashCode()) % TABLE_SIZE;
            for (int i = 0; i < TABLE_SIZE; i++) {
                int index = (hash + i) % TABLE_SIZE;
                HashTableNode node = (HashTableNode) table[index];
                if (!node.active || node.tombstoned) {
                    table[index] = new HashTableNode(key, value);
                    return null;
                }
                if (node.active && node.key.equals(key)) {
                    Value oldValue = node.value;
                    node.value = value;
                    return oldValue;
                }
            }
            throw new IllegalStateException("HashTable is full");
        }

        @SuppressWarnings("unchecked")
        public Value get(Key key) {
            int hash = Math.abs(key.hashCode()) % TABLE_SIZE;
            for (int i = 0; i < TABLE_SIZE; i++) {
                int index = (hash + i) % TABLE_SIZE;
                HashTableNode node = (HashTableNode) table[index];
                if (node.active && node.key.equals(key)) {
                    return node.value;
                }
                if (!node.active && !node.tombstoned) {
                    return null;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>();
        ht.put("apple", 100);
        ht.put("banana", 200);
        ht.put("apple", 150);
        System.out.println("apple: " + ht.get("apple"));
        System.out.println("banana: " + ht.get("banana"));
        System.out.println("orange: " + ht.get("orange"));
    }
}



