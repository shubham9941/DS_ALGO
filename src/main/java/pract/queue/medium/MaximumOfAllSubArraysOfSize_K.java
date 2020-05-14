package pract.queue.medium;

import pract.Reader;

public class MaximumOfAllSubArraysOfSize_K {
    static void printDataByWindow(int[] arr, int n, int k) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        for (; i < k; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        sb.append(max + " ");
        for (; i < n; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            sb.append(max + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            printDataByWindow(arr, size, k);
        }

    }
}