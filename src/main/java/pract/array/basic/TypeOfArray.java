package pract.array.basic;

/*
 You are given an array of size N having no duplicate elements. The array can be categorized into following:
1.  Ascending
2.  Descending
3.  Descending Rotated
4.  Ascending Rotated
Your task is to print which type of array it is and the maximum element of that array.

Input:
The first line of input contains an integer T denoting the no test cases. Then T test caes follow. Each testcase contains two lines of input. The first line contains an integer N denoting the size of the array. The next line contains N space separated values of the array.

Output:
For each test case, print the largest element in the array and and integer x denoting the type of the array.

Constraints:
1 <= T <= 100
3 <= N <= 107
1 <= A[] <= 1018*/

import pract.Reader;

public class TypeOfArray {
    static void printTypeOfArray(int[] arr, int size) {
        int max = arr[0];
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i + 1] > max) {
                max = arr[i + 1];
            }
            if (arr[i + 1] - arr[i] > 0) {
                pos++;
            } else {
                neg++;
            }
        }
        if (pos > 0 && neg == 0) {
            System.out.println(max + " 1");
        } else if (neg > 0 && pos == 0) {
            System.out.println(max + " 2");
        } else if (pos > neg) {
            System.out.println(max + " 4");
        } else {
            System.out.println(max + " 3");
        }
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
            printTypeOfArray(arr, arr.length);
        }

    }
}
