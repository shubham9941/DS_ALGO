package pract.interview_questions;

import java.util.PriorityQueue;

public class K_ClosestElements {

    static class ElemenInfo implements Comparable<ElemenInfo> {
        int element;
        int diff;

        ElemenInfo(int element, int diff) {
            this.element = element;
            this.diff = diff;
        }

        @Override
        public int compareTo(ElemenInfo o) {
            return this.diff - o.diff;
        }
    }

        static void findClosestElements(int[] arr, int k, int element) {
            PriorityQueue<ElemenInfo> pq = new PriorityQueue<ElemenInfo>((x, y) -> Integer.compare(y.diff, x.diff));
            for (int i : arr) {
                pq.add(new ElemenInfo(i, Math.abs(i - element)));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            pq.forEach(x -> {
                System.out.println(x.element);
            });
        }


    public static void main(String[] args) {
        int[] arr = {12, 15, 18, 21, 22, 43};
        findClosestElements(arr, 4, 20);
    }
}
