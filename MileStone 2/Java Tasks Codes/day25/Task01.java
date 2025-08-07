package day25;

public class Task01 {
    // Main method
    public static void main(String[] args) {
        Task01_Mobile mobile = Task01_Mobile.builder()
                              .buildStorage(512)
                              .buildMemory(16)
                              .build();
        //Mobile mobile2 = new Mobile();// error pvt constructor
        System.out.println(mobile);
    }
}

// Product class with nested builder
class Task01_Mobile {
    private int storage;
    private int memory;

    // Private constructor
    private Task01_Mobile() {}

    public int getStorage() {
        return storage;
    }

    public int getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Mobile [Storage = " + storage + " GB, Memory = " + memory + " GB]";
    }

    // Static method to get builder
    public static Builder builder() {
        return new Builder();
    }

    // Nested static Builder class
    public static class Builder {
        private final Task01_Mobile mobile;

        public Builder() {
            this.mobile = new Task01_Mobile();
        }

        public Builder buildStorage(int storage) {
            mobile.storage = storage;
            return this;
        }

        public Builder buildMemory(int memory) {
            mobile.memory = memory;
            return this;
        }

        public Task01_Mobile build() {
            return mobile;
        }
    }
}



