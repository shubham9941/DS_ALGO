package pract.array.easy;

// Note:- This is DP question:
//Given an array A of positive integers.
// Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.

public class MaxSumWithoutAdjacents {


    static int getMax(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }

        return Integer.max(arr[n - 1] + getMax(arr, n - 2), getMax(arr, n - 1));
    }


    public static void main(String[] args) {
//        int[]arr = {5, 5, 10, 100, 10, 5};
        int[] arr = {3, 2, 7, 10};
        System.out.println(getMax(arr, arr.length));
    }
}
