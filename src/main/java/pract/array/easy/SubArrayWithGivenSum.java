package pract.array.easy;
/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5

10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15

*/

import pract.Reader;

public class SubArrayWithGivenSum {
    static void printRes(int[] arr, int size, int n) {
        int startingPos = 0;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (sum == n) {
                System.out.println((startingPos + 1) + " " + (i + 1));
                flag = true;
                break;
            } else if (sum > n) {

                while (sum > n) {
                    sum = sum - arr[startingPos];
                    startingPos++;
                }
                if (sum == n) {
                    System.out.println((startingPos + 1) + " " + (i + 1));
                    flag = true;
                    break;
                }
            }
        }
        if (!flag)
            System.out.println("-1");

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            printRes(arr, size ,n);
        }
    }
}
