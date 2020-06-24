package pract.heap.medium;

import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SmallestRangein_K_lists {

    static class Node implements Comparable<Node> {
        int[] arr;
        int i;
        int j;

        Node(int[] arr, int i, int j) {
            this.arr = arr;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Node o) {
            if (this.arr[this.i] < o.arr[o.i]) {
                return -1;
            }
            return 1;
        }
    }


    static void findSmallestRange(int arr[][], int n, int k) {

        TreeMap<Integer, Node> mp = new TreeMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        String range = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            if (arr[i][0] > max) {
                max = arr[i][0];
            }
            pq.add(new Node(arr[i], 0, n - 1));
        }


        while (pq.size() != 0) {
            Node currentNode = pq.poll();

            int currentDiff = (max - currentNode.arr[currentNode.i]);
            if (currentDiff < min) {
                min = currentDiff;
                range = currentNode.arr[currentNode.i] + " " + max;
            }
            if (currentNode.i == currentNode.j) {
                break;
            }
            currentNode.i++;
            if (currentNode.arr[currentNode.i] > max) {
                max = currentNode.arr[currentNode.i];
            }
            pq.add(currentNode);

//            Iterator<Node> it = pq.iterator();
//            while (it.hasNext()){
//                Node nt = it.next();
//                System.out.println("PQ = " + nt.arr[nt.i]);
//            }

        }

        System.out.println(range);


    }

    public static void main(String[] args) {

//        int[][] arr = {
//                {1, 3, 5, 7, 9},
//                {0, 2, 4, 6, 8},
//                {2, 3, 5, 7, 11}
//        };
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        findSmallestRange(arr, 4, 3);

    }
}
