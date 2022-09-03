package pract.array.medium;

import pract.Reader;

import java.util.Stack;

public class StockSpanProblem {
    static int updateAndGetRes(Stack<Integer> stk, int[] res, int[] arr, int k) {
        int r = 0;
        while (!stk.isEmpty() && arr[stk.peek()] <= k) {
            int index = stk.pop();
            r += res[index];
        }
        return r;
    }

    static void get(int[] arr, int n) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] res = new int[n];

        stk.push(0);
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[stk.peek()]) {
                stk.push(i);
                res[i] = 1;
            } else {
                int r = updateAndGetRes(stk, res, arr, arr[i]);
                stk.push(i);
                res[i] = r + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
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
            get(arr, size);
            System.out.println();

        }
    }
}
