package fromTreesDay16;

public class HomeTaskJuly10 {

    public int searchElement(int[] arr, int target, int index) {
        if (index >= arr.length) return -1;
        if (arr[index] == target) return index;
        return searchElement(arr, target, index + 1);
    }

    public int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    public int sumOfDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    public String reverseString(String s) {
        if (s.length() == 0 || s.charAt(0) == '\0') return "";
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public String decimalToBinary(int n) {
        if (n == 0) return "";
        return decimalToBinary(n / 2) + (n % 2);
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public void copyArray(int[] src, int[] dst, int index) {
        if (index >= src.length) return;
        dst[index] = src[index];
        copyArray(src, dst, index + 1);
    }

    public static void main(String[] args) {
        HomeTaskJuly10 ht = new HomeTaskJuly10();

        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        System.out.println("Index of " + target + ": " + ht.searchElement(arr, target, 0));

        int number = 1234;
        System.out.println("Count of digits in " + number + ": " + ht.countDigits(number));
        System.out.println("Sum of digits in " + number + ": " + ht.sumOfDigits(number));

        String str = "hello\0";
        System.out.println("Reversed string: " + ht.reverseString(str));

        int decimal = 10;
        String binary = ht.decimalToBinary(decimal);
        System.out.println("Binary of " + decimal + ": " + (binary.equals("") ? "0" : binary));

        String word = "madam";
        System.out.println("Is \"" + word + "\" a palindrome? " + ht.isPalindrome(word));

        int[] dst = new int[arr.length];
        ht.copyArray(arr, dst, 0);
        System.out.print("Copied array: ");
        for (int n : dst) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}




