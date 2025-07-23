package day18;

import java.util.ArrayList;
import java.util.Arrays;

public class Task002 {
	public static void main(String[] args) {
		int [] arr = {1423,3829,3949,2934};
		int maxDigits = getMaxDigitsCount(arr);
		for (int i = 0; i < maxDigits; i++) {
			groupByDigits(arr, i);
		}
		System.out.println(Arrays.toString(arr));
	}
	static void printDigits(int num) {
		int i = 0;
		while(num!=0) {
			System.out.printf("%dth digit from last is : %d \n",i++, num%10);
			num = num/10;
		}
	}
	
	static int getMaxDigitsCount(int[] arr) {
		int len = arr.length;
		int max = Integer.MIN_VALUE;
		for(int n : arr) {
			if (n>max) {
				max = n;
			}
		}
		int count = 0;
		while(max!=0) {
			count++;
			max = max/10;
		}
		return count;
	}
	
	static void groupByDigits(int[] arr , int exp) {
		int div = 1;
		for(int i =0 ; i<=exp; i++) {
			div = div * 10;
		}
		
		ArrayList<Integer>[] unit = new ArrayList[10];
		for (int i = 0; i < unit.length; i++) {
			unit[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int index = (arr[i] % div)%10;
			unit[index].add(arr[i]);
		}
		
		int x = 0;
		for (int i = 0; i < 10 ; i++) {
			for (int n : unit[i]) {
				arr[x++] = n;
			}
		}		
		
	}
}
