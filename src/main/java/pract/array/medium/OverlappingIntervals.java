package pract.array.medium;

import pract.Reader;

import java.util.PriorityQueue;

public class OverlappingIntervals {

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.start < o.start) {
                return -1;
            }
            return 1;
        }
    }

    static void find(int[] arr, int n) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i = i + 2) {
            Pair p = new Pair(arr[i] , arr[i+1]);
            pq.add(p);
        }

        Pair prev = null;

        while (!pq.isEmpty()){
            Pair next = pq.poll();
            if(prev == null){
                prev = next;
            }
            else if (next.start > prev.end){
                System.out.println(prev.start + " " + prev.end + " ");
                prev = next;
            }
            else if (next.start < prev.end && next.end > prev.end){
                prev.end = next.end;
            }
        }

        System.out.println(prev.start + " " + prev.end + " ");
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int pairSize = sc.nextInt();
            int size = pairSize * 2;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            find(arr, size);
            System.out.println();

        }

    }
}

