package pract.dp.pract.medium;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    static int get(int[] arr, int n) {
        int[] t = new int[n];
        Arrays.fill(t, 1);

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && t[i] < t[j] + 1) {
                    t[i] = t[j] + 1;
                    max = (max < t[i]) ? t[i] : max;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(get(arr , arr.length));
    }
}
