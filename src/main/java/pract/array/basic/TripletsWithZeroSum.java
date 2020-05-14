package pract.array.basic;

// #AMAZON #GOOGLE #FACEBOOK

/* Return 1 if any of 3 element in array is 0 else 0 */

import pract.Reader;

import java.util.Arrays;

public class TripletsWithZeroSum {
    // this is for 0
    static boolean findTriplets(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) return true;
                if (sum > 0) k--;
                else j++;
            }
        }
        return false;
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
            System.out.println(findTriplets(arr, arr.length));
        }

    }
}
