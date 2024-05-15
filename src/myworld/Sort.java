package myworld;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 4, 9, 2, 12, 3, 5, 10, 22, 33, 1, 5, 1, 99, 43, 129};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {

        int length = arr.length;


        while (length != 0) {
            int maxIndex = 0;
            for (int i = 1; i < length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;

                    maxIndex = i;
                }
            }
            length = maxIndex;
        }
    }
}
