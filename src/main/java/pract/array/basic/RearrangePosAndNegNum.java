package pract.array.basic;

import pract.Reader;

public class RearrangePosAndNegNum {
    static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

    }

    static int separatePosAndNegNum(int[] arr) {
        int temp = 0;
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < temp) {
                i++;
                swap(arr, i, j);
            }
        }
        return (i + 1);
    }

    static void rearrange(int[] arr) {
        int pos = separatePosAndNegNum(arr);
        for (int neg = 0; neg < pos && pos < arr.length; neg = neg + 2) {
            swap(arr, neg, pos);
            pos++;
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
            rearrange(arr);
            StringBuilder sb = new StringBuilder();
            for(int i : arr){
                sb.append(i + " ");
            }
            System.out.println(sb);
        }

    }
}
