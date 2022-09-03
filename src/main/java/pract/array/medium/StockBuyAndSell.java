package pract.array.medium;

import pract.Reader;

public class StockBuyAndSell {

    static boolean atlestOnce = false;

    static void calMaxProfit(int[] arr, int start, int n) {
        int buy = -1;
        for (int i = start; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                buy = i;
                atlestOnce = true;
                break;
            }
        }
        if (buy == -1 && !atlestOnce) {
            System.out.print("No profit");
        } else if (buy != -1) {
            int i = buy;
            while (i < n - 1 && arr[i] < arr[i + 1])
                i++;
            System.out.print("(" + buy + " " + i + ") ");
            calMaxProfit(arr, i + 1, n);

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
            atlestOnce = false;
            calMaxProfit(arr, 0, size);
            System.out.println();
        }

    }
}
