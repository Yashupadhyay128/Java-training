package Assignment4;

import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6, 3, 8, 4, 7};
        int max = findMax(numbers);
        int min = findMin(numbers);
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
        Arrays.sort(numbers);
        System.out.println("Sorted Array (ascending): " + Arrays.toString(numbers));
        reverseArray(numbers);
        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    }
