package pract.array.medium;

import pract.Reader;

public class Find_kth_min {

    static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    static int findActPos(int[] arr, int l, int r, int k) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        if (i == k - 1) {
            return arr[i];
        } else if (i > k - 1) {
            return findActPos(arr, l, i - 1, k);
        } else {
            return findActPos(arr, i + 1, r, k);
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

            int k = sc.nextInt();

           System.out.println(findActPos(arr, 0, size-1, k));
        }

    }
}
