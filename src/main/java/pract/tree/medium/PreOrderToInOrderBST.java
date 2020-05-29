package pract.tree.medium;

import pract.Reader;

public class PreOrderToInOrderBST {
    static int findIndex(int[] arr, int l, int r, int k) {
        int i = l + 1;
        for (; i <=r && arr[i] < k; i++) ;
        return i - 1;
    }

    static void printInOrder(int[] preOrder, int l, int r) {
        if (l <= r) {
            int index = findIndex(preOrder, l, r, preOrder[l]);
            printInOrder(preOrder, l + 1, index);
            System.out.print(preOrder[l] + " ");
            printInOrder(preOrder, index + 1, r);
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
            printInOrder(arr, 0, size - 1);
            System.out.println();
        }
    }
}

