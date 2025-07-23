package practicePackage;

import java.util.HashMap;
import java.util.Map;

public enum Task019_EnumExample2 {


    H("Hydrogen", 1, 1.008f),
    HE("Helium", 2, 4.0026f),
    NE("Neon", 10, 20.180f);

    public final String label;
    public final int atomicNumber;
    public final float atomicWeight;

    private static final Map<String, Task019_EnumExample2> BY_LABEL = new HashMap<>();
    private static final Map<Integer, Task019_EnumExample2> BY_ATOMIC_NUMBER = new HashMap<>();
    private static final Map<Float, Task019_EnumExample2> BY_ATOMIC_WEIGHT = new HashMap<>();

    private Task019_EnumExample2(String label, int atomicNumber, float atomicWeight) {
        System.out.println("Constructor: " + label);
        this.label = label;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }

    static {
        System.out.println("Static block running...");
        for (Task019_EnumExample2 e : values()) {
            BY_LABEL.put(e.label, e);
            BY_ATOMIC_NUMBER.put(e.atomicNumber, e);
            BY_ATOMIC_WEIGHT.put(e.atomicWeight, e);
        }
    }

    public static Task019_EnumExample2 valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static Task019_EnumExample2 valueOfAtomicNumber(int number) {
        return BY_ATOMIC_NUMBER.get(number);
    }

    public static Task019_EnumExample2 valueOfAtomicWeight(float weight) {
        return BY_ATOMIC_WEIGHT.get(weight);
    }

    public static void main(String[] args) {
//        System.out.println("Main starts...");
//        Element e = Element.valueOfLabel("Helium");
//        System.out.println("Looked up: " + e);
        
        for (Task019_EnumExample2 e : Task019_EnumExample2.values()) {
            System.out.println(
                e.name() + " - " + e.label + " - " + e.atomicNumber + " - " + e.atomicWeight
            );
        }


    }
}

