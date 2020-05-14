package pract.array.basic;

import java.util.Scanner;

public class ZigZagArray {
    static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    static void convertToZigZag(int[] arr, int l) {
        int n = l;
        if (l % 2 == 0) {
            n = l - 1;
        }
        for (int i = 1; i < n; i = i + 2) {
            int left = i - 1;
            int right = i + 1;
            if (!(arr[i] > arr[left])) {
                swap(arr, i, left);
            }
            if (!(arr[i] > arr[right])) {
                swap(arr, i, right);
            }
        }
        if (n == l - 1) {
            if (arr[l - 1] < arr[l - 2]) {
                swap(arr, l - 1, l - 2);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases -- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int i = 0 ; i < size ;i ++){
                arr[i] = sc.nextInt();
            }
            convertToZigZag(arr,size);
            StringBuilder sb = new StringBuilder();
            for(int d : arr){
                sb.append(d + " ");
            }
            System.out.println(sb);
        }

    }
}
