package pract.queue.easy;

import pract.Reader;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntegerInEveryWindow_K {

    static void print(int[] arr, Queue<Integer> q, int start) {
        if (q.isEmpty())
            System.out.print(0 + " ");
        else {
            int top = q.peek();
            System.out.print(arr[top] + " ");
            if (top == start) {
                q.poll();
            }
        }
    }

    static void printData(int[] arr, int size, int k) {
        Queue<Integer> q = new LinkedList<Integer>();
        int i = 0;
        for (; i < k; i++) {
            if (arr[i] < 0)
                q.add(i);
        }
        print(arr, q, 0);
        for (; i < size; i++) {
            if (arr[i] < 0)
                q.add(i);
            int start = (i - k + 1);
            print(arr, q, start);
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
            printData(arr, size, k);
            System.out.println();
        }

    }
}
