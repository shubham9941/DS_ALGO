package pract.array.easy;

import pract.Reader;

import java.util.Arrays;

public class FindFourElementsSum {


    static void printSum4(int[] arr, int size, int n) {
        Arrays.sort(arr);
        for (int p = 0; p < size - 3; p++) {
            for (int i = p + 1; i < size - 2; i++) {
                int j = i + 1;
                int k = size - 1;
                while (j < k) {
                    if ((arr[p] + arr[i] + arr[j] + arr[k]) > n) {
                        k--;
                    } else if (arr[p] + arr[i] + arr[j] + arr[k] < n) {
                        j++;
                    } else {
                        System.out.println(arr[p] + " " + arr[i] + " " + arr[j] + " " + arr[k]);
                        k--;
                    }
                }
            }
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
            int n = sc.nextInt();
            printSum4(arr, size ,n);
        }
    }
}
