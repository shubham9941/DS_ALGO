package pract.array.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge_k_SortedArrays {

    static class Pair implements Comparable<Pair> {
        int i;
        int j;
        int value;

        Pair(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value < o.value) {
                return -1;
            }
            return 1;
        }
    }

    static ArrayList<Integer> mergeAarray(int[][] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int j = arr[0].length - 1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < k; i++) {
            Pair p = new Pair(i, 0, arr[i][0]);
            pq.add(p);
        }

        while (!pq.isEmpty()) {
            Pair smallest = pq.poll();
            if (smallest.value == Integer.MAX_VALUE) {
                break;
            }
            res.add(smallest.value);
            if (smallest.j == j) {
                pq.add(new Pair(-1, -1, Integer.MAX_VALUE));
            } else {
                pq.add(new Pair(smallest.i, smallest.j + 1, arr[smallest.i][smallest.j + 1]));
            }
        }
        return res;
    }


    public static void main(String[] args) {

//        int arr[][] = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};

        int arr[][] = {
                {1, 2, 2, 2},
                {3, 3, 4, 4},
                {5, 5, 6, 6},
                {7, 8, 9, 9}
        };

        ArrayList<Integer> al = mergeAarray(arr, 4);
        System.out.print(al);

    }
}
