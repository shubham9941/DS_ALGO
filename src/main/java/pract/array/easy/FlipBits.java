package pract.array.easy;

/*
Given an array arr[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1.You have to do atmost one “Flip” operation of a subarray. Then finally display maximum number of 1 you can have in the array.

Input:
The first line of input consist of a single integer T denoting the total number of test case. First line of test case contains an integer N size of array. Second line of test case contains N space separated integers denoting the array arr[].

Output:
For each test case output a single integer representing  the maximum number of 1's you can have in the array after atmost one flip operation.

Constraints:
1 <= T = 100
1 <= N <= 104
0 <= arr[i] <= 1

Example:
Input:
1
5
1 0 0 1 0

Output:
4

Explanation:
We can perform a flip operation in the range [1,2]
After flip operation array is : 1 1 1 1 0

*/

import java.util.Scanner;

public class FlipBits {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int t = 0; t < c; t++) {
            int[] arr = new int[in.nextInt()];
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
                if (arr[i] == 1) count++;
                System.out.println("for i = " + i + " count = " + count);
            }
            System.out.println("Hey total count = " + count);
            //count subsequent 0s, and count num1

            int max = count;
            int cur = count;
            System.out.println("max = " + max);
            System.out.println("count = " + count);
            System.out.println("cur = " + cur);
            for (int i: arr) {
                if (i == 0) {
                    max = Math.max(max, ++cur);
                } else {
                    if (--cur < count) {
                        cur = count;
                    }
                }
            }
            System.out.println(max);
        }
        //code
    }
}
