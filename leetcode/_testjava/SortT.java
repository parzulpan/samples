package _testjava;

import java.util.Arrays;
import java.util.Comparator;

public class SortT {
    public static void main(String[] args) {
        Integer[] array = { 5, 3, 9, 1, 2 };

        System.out.println("Original array:");
        printArray(array);

        Arrays.sort(array, Comparator.reverseOrder());

        System.out.println("Sorted array in descending order:");
        printArray(array);
    }

    private static void printArray(Integer[] arr) {
        for (Integer value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
