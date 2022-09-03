package pract.array.medium;

import pract.Reader;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * <p>
 * Example:
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * <p>
 * NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting index
 * <p>
 * Input:
 * The first line contains an integer T, depicting total number of test cases.
 * Then following T lines contains an integer N depicting the size of array and next line followed by the value of array.
 * <p>
 * Output:
 * Print the Sub-array with maximum sum
 */

public class MaximumSubArray {
    static void find(int[] arr, int n) {
        int start = -1;
        int end = -1;
        int Max_so_far = Integer.MIN_VALUE;

        int currnt_start = -1;
        int current_end = -1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                currentSum += arr[i];
                if (currnt_start == -1) {
                    currnt_start = i;
                }
                current_end = i;
            } else {
                if ((currentSum > Max_so_far) || (currentSum == Max_so_far) && (current_end - currnt_start) > (end - start)) {
                    Max_so_far = currentSum;
                    start = currnt_start;
                    end = current_end;
                }
                currentSum = 0;
                currnt_start = -1;
                current_end = -1;
            }
        }

        if ((currentSum > Max_so_far) || (currentSum == Max_so_far) && (current_end - currnt_start) > (end - start)) {
            start = currnt_start;
            end = current_end;
        }
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            find(arr, n);
            System.out.println();
        }
    }
}
