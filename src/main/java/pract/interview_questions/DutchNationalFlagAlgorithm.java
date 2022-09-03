package pract.interview_questions;


// Sort an array of 0s, 1s and 2s

import java.lang.reflect.Array;
import java.util.Arrays;

public class DutchNationalFlagAlgorithm {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int[] arr, int n) {
        int i = -1;
        int j = n;
        int k = 0;
        while (k < n && k < j) {
//            System.out.println(Arrays.toString(arr));
            if (arr[k] == 0) {
                i++;
                swap(arr, i, k);
                k++;

            } else if (arr[k] == 2) {
                j--;
                swap(arr, j, k);

            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,2, 2, 1, 0, 0};
        sort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
