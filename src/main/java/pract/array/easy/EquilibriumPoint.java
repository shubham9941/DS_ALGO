/*
Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.

Output:
For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= Ai <= 108

Example:
Input:
2
1
1
5
1 3 5 2 2

Output:
1
3

*/

package pract.array.easy;

import pract.Reader;

public class EquilibriumPoint {

    static int printEquilibriumPoint(int[] arr, int size) {
        if (size == 1)
            return arr[0];
        int[] left = new int[size];
        left[0] = arr[0];
        int[] right = new int[size];
        right[size - 1] = arr[size - 1];

        for (int i = 1; i < size; i++) {
            left[i] = arr[i] + left[i - 1];
        }
        for (int j = size - 2; j >= 0; j--) {
            right[j] = arr[j] + right[j + 1];
        }
        for (int k = 0; k < size; k++) {
            if (left[k] == right[k]) {
                return k + 1;
            }
        }
        return -1;

    }

    //Solution from Geeks :-

    int equilibrium(int arr[], int n)
    {
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];

        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            if (leftsum == sum)
                return i;

            leftsum += arr[i];
        }

        /* If no equilibrium index found, then return 0 */
        return -1;
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
            System.out.println(printEquilibriumPoint(arr, size));
        }
    }
}
