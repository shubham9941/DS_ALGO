package pract.array.easy;

/*
Given a sorted array of numbers, value K and an index X in array, find the K closest numbers in position to X in array.
Example: Let array be 11 23 24 75 89, X be 24 and K be 2. Now we have to find K numbers closest to X that is 24. In this example, 23 and 75 are the closest 2 numbers to 24.
Note: K should be even and in cases with less than k/2 elements on left side or right side, we need to print other side elements. Like 2 4 5 6 7, X be 6 and K be 4 then answer is 2 4 5 7
*/

import pract.Reader;

public class FindKClosestElements {
    static int findIndex(int[] arr, int n, int l, int r) {
        if (r >= l) {
            int m = (l + r) / 2;
            if (arr[m] == n) {
                return m;
            } else if (n < arr[m]) {
                return findIndex(arr, n, l, m - 1);
            } else {
                return findIndex(arr, n, m + 1, r);
            }
        } else {
            return -1;
        }
    }

    static void printClosest(int[] arr, int size, int n, int k) {
        int m = findIndex(arr, n, 0, size);
        int leftAv = m;
        int rightAv = size - 1 - m;
        int lIndex;
        int rIndex;
        int mk = k / 2;
        if (mk <= leftAv && mk <= rightAv) {
            lIndex = mk;
            rIndex = mk;
        } else if (mk > leftAv && mk > rightAv)
            throw new RuntimeException("Not possible");
        else if (mk < leftAv) {
            lIndex = mk + mk - rightAv;
            rIndex = rightAv;
        } else {
            rIndex = mk + mk - leftAv;
            lIndex = leftAv;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m - lIndex; i < m; i++) {
            sb.append(arr[i] + " ");
        }
        for (int j = m + 1; j <= m + rIndex; j++) {
            sb.append(arr[j] + " ");
        }
        System.out.println(sb);
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
            int k = sc.nextInt();
            int n = sc.nextInt();
            printClosest(arr, size, n, k);
        }
    }
}
