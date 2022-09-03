package pract.interview_questions.sde_2;

import java.util.HashMap;
import java.util.PriorityQueue;

public class K_th_MostFrequentWords {

    static HashMap<String, Integer> mp;
    PriorityQueue<Word> pq;
    int k;

    K_th_MostFrequentWords(int k) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        mp = new HashMap<>();
    }

    static class Word implements Comparable<Word> {
        String w;

        Word(String w) {
            this.w = w;
        }

        @Override
        public int compareTo(Word o) {
            System.out.println("---here---");
//            if (mp.get(this.w) < mp.get(o.w)) {
//                return -1;
//            }
//            return 1;
            return mp.get(this.w) - mp.get(o.w);
        }


    }

    String find(String[] arr, int n) {
        mp.put(arr[0], 1);
        pq.add(new Word(arr[0]));

        for (int i = 1; i < n; i++) {
            if (pq.size() < k) {
                if (mp.containsKey(arr[i])) {
                    Word top = pq.poll();
                    mp.put(arr[i], mp.get(arr[i]) + 1);
                    pq.add(top);
                } else {
                    mp.put(arr[i], 1);
                    pq.add(new Word(arr[i]));
                }
            } else {
                if (mp.containsKey(arr[i])) {
                    mp.put(arr[i], mp.get(arr[i]) + 1);
                    pq.add(pq.poll());
                }
                else{
                    mp.put(arr[i] , 1);
                }


            }


        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().w);
        }
        System.out.println(mp);
        return "";

    }

    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "A", "A", "C", "C", "C", "D"};
        K_th_MostFrequentWords obj = new K_th_MostFrequentWords(3);

        System.out.println(obj.find(arr, arr.length));
//        PriorityQueue<Word> pq = new PriorityQueue<>();
//        mp = new HashMap<>();
//        mp.put("A" , 5);
//        mp.put("B" , 1);
//
//        pq.add(new Word("A"));
//        pq.add(new Word("B"));
//
//        while (!pq.isEmpty()){
//            System.out.println(pq.poll().w);
//        }

    }
}
