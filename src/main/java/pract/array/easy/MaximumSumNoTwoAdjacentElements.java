package pract.array.easy;

// Note - Very Imp

/*
Maximum sum such that no two elements are adjacent
Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

Examples :

Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20

*/

import pract.Reader;

public class MaximumSumNoTwoAdjacentElements {
    static int printMaximumSum(int[] arr, int size) {
        int excl = 0;
        int incl = arr[0];
        int temp;
        for (int i = 1; i < size; i++) {
            temp = incl;
            incl = Math.max(incl, arr[i] + excl);
            excl = temp;
        }

        return Math.max(incl , excl);

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            printMaximumSum(arr,  size);
        }
    }
}
