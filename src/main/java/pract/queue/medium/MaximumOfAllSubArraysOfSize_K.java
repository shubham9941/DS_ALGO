package pract.queue.medium;

import pract.Reader;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumOfAllSubArraysOfSize_K {

    static void push(int[] arr, int i, Deque<Integer> q) {
        if (q.isEmpty()) {
            q.addLast(i);
        } else if (arr[q.getLast()] > arr[i]) {
            q.addLast(i);
        } else {
            q.removeLast();
            push(arr, i, q);
        }
    }

    static void siftWindow(int removalIndex, Deque<Integer> q, int[] arr) {
        System.out.print(arr[q.peek()] + " ");
        if (q.peek() == removalIndex) {
            q.remove();
        }

    }

    static void printDataByWindow(int[] arr, int n, int k) {
        Deque<Integer> q = new LinkedList<>();
        int i = 0;
        for (; i < k; i++) {
            push(arr, i, q);
        }
        for (; i < n; i++) {
            siftWindow(i - k, q, arr);
            push(arr, i, q);
        }
        if (!q.isEmpty()) {
            System.out.print(arr[q.peek()]);
        }
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