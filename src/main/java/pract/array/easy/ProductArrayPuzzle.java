package pract.array.easy;

import pract.Reader;

public class ProductArrayPuzzle {

    static void printProduct(int[] arr, int size) {
        int multi = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            multi = multi * arr[i];
        }
        for (int i = 0; i < size; i++) {
            sb.append((multi / arr[i]) + " ");
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
            printProduct(arr, size);
        }
    }
}
