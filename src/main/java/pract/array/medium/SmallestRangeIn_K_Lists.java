package pract.array.medium;

import pract.Reader;

import java.util.PriorityQueue;

public class SmallestRangeIn_K_Lists {

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

    static void find(int[][] arr, int k, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int from = 0;
        int to = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i][0] > max) {
                max = arr[i][0];
            }
            pq.add(new Pair(i, 0, arr[i][0]));
        }

        while (!pq.isEmpty()) {
            Pair s = pq.poll();
            if (max - s.value < range) {
                range = max - s.value;
                from = s.value;
                to = max;
            }
            if (s.j == n - 1) {
                break;
            }
            Pair newP = new Pair(s.i, s.j + 1, arr[s.i][s.j + 1]);
            if (newP.value > max) {
                max = newP.value;
            }
            pq.add(newP);
        }

        System.out.println(from + " " + to);
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            find(arr , k , n);

        }
    }
}
