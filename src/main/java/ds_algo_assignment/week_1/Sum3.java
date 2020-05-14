package ds_algo_assignment.week_1;

import pract.Reader;

import java.util.Arrays;

public class Sum3 {


    private static boolean search(int[] arr, int l, int r, int num) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == num) return true;
            else if (num < arr[mid]) return search(arr, l, mid, num);
            else return search(arr, mid + 1, r, num);
        } else return false;

    }


    static boolean binarySearch(int arr[], int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return true;

            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }

        return false;
    }

    // Using brut force with complexity:- (n^3)
    static void printSum1(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
//                    if (arr[i] + arr[j] + arr[k] == n)
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                }
            }
        }
    }

    // Using binary search at last loop with complexity:- (n^2)log(n)
    static void printSum2(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (j + 1 < arr.length) {
                    int num = n - (arr[i] + arr[j]);
                    if (binarySearch(arr, j + 1, arr.length, num)) {
                        System.out.println(arr[i] + " " + arr[j] + " " + num);
                    }
                }

            }
        }
    }

    // Using with another approach with time complexity:- (n^2)
    static void printSum3(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                if ((arr[i] + arr[j] + arr[k]) > n) {
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < n) {
                    j++;
                } else {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Reader sc = new Reader();
//        int[] arr = new int[50];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }
        int[] arr = {6, 4, 9, 7, 8};
        long start = System.currentTimeMillis();
        printSum1(arr, 15);
//        printSum2(arr, 15);
//        printSum3(arr, 0);
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");


    }
}
