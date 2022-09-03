package pract.dp.pract.easy;

import pract.Reader;

import java.util.Arrays;

public class ReachTheNthPoint {

    public static void main(String[] args) {
        int[] arr = new int[4 + 1];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 2];
        }

        System.out.println(Arrays.toString(arr));
    }
}
