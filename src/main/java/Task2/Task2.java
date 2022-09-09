package main.java.Task2;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        int[] array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};

        System.out.println(Arrays.toString(array));
        System.out.println("------------------------");
        insertionSort(array);

        int[] test = {2, 5, 0, -1, 1, 6, 4, 5};
        int[] sortedArray = {-1,0,1,2,4,5,5,6};
        System.out.println("------------------------");
        System.out.println("Test");
        assert Arrays.equals(sortedArray,insertionSort(test)): "test failed";

    }
    private static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int q = i - 1;
            for (; q >= 0; q--) {
                if (value < array[q]) {
                    array[q + 1] = array[q];
                } else {
                    break;
                }
            }
            array[q + 1] = value;
        }
        System.out.println(Arrays.toString(array));
        return array;

    }
}
