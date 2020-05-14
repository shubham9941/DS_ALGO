package pract.array.easy;

/*
Given an array of positive integers. Check whether there are two numbers present with given product.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and a product P.
The second line of each test case contain elements of array.

Output:
Print "Yes" (Without quotes) if two numbers product is equal to P else "No" (without quotes).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
0 ≤ Ai ≤ 263 - 1
0 <= P <= 264 - 1

Example:
Input:
2
5 25
1 2 3 4 5
8 63
5 7 9 22 15 344 92 8

Output:
No
Yes
*/

import pract.Reader;

import java.util.Arrays;

public class EqualToProduct {
    static String getRes(int[] arr, int size, int num) {
        Arrays.sort(arr);
        int i = 0;
        int k = size - 1;
        while (i < k) {
            if (arr[i] * arr[k] > num)
                k--;
            else if (arr[i] * arr[k] < num)
                i++;
            else return "Yes";
        }
        return "No";

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int num = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getRes(arr, size, num));
        }
    }
}
