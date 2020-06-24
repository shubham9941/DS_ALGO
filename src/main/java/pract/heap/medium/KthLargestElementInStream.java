package pract.heap.medium;

import pract.Reader;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    static void print(int[] arr, int l, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < l; i++) {

            if(pq.size() < k){
                pq.add(arr[i]);
            }
            else if (arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }

            if (i + 1 < k) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(pq.peek() + " ");
            }

        }

    }

    public static void main(String[] args)throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int k = sc.nextInt();
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            print(arr, arr.length, k);
            System.out.println();

        }

    }
}
