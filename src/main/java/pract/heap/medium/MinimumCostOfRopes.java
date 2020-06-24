package pract.heap.medium;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    static void printMinCost(int[] arr, int l) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < l; i++) {
            pq.add(arr[i]);
        }
        int totalCost = 0;
        if (pq.size() == 1) {
            System.out.print(pq.poll());
        } else {
            while (pq.size() != 0) {
                int first = pq.poll();
                int second = pq.poll();
                if (pq.size() != 0) {
                    pq.add(first + second);
                }
                System.out.println("First = " + first);
                System.out.println("Second = " + second);
                System.out.println("Cost = " + totalCost);
                totalCost += (first + second);

            }


        }
        System.out.println(totalCost);
    }

    public static void main(String[] args) {
//        int[] arr = {4, 3, 2, 6};
        int[] arr = {4, 2,7,6,9};
        printMinCost(arr , arr.length);

    }
}
