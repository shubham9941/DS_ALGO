package pract.interview_questions.sde_2;

import pract.Reader;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    static long findMinCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        long cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            cost += first + second;
            pq.add(first + second);
        }
        return cost;
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
            System.out.println(findMinCost(arr));
        }

    }
}
