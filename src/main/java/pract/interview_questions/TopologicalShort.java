package pract.interview_questions;

import java.util.*;

public class TopologicalShort {

    HashMap<Integer, LinkedList> mp;

    TopologicalShort() {
        mp = new HashMap<>();
    }

    void add(int source, int dest) {
        if (!mp.containsKey(source)) {
            mp.put(source, new LinkedList());
        }
        if (!mp.containsKey(dest)) {
            mp.put(dest, new LinkedList());
        }

        mp.get(source).add(dest);
//        mp.get(dest).add(source);

    }


    void sort() {
        HashMap<Integer, Integer> indgree = new HashMap<>();
        mp.keySet().forEach(x -> {
            indgree.put(x, 0);
        });

//        System.out.println("in = " + indgree);
//        System.out.println("mp = " + mp);

        mp.values().forEach(childList -> {
            childList.forEach(child -> {
//                System.out.println();
                indgree.put((Integer) child, indgree.get(child) + 1);
            });
        });


//        System.out.print(indgree);

        class NodeInfo implements Comparable<NodeInfo> {
            int v;

            NodeInfo(int v) {
                this.v = v;
            }

            @Override
            public int compareTo(NodeInfo o) {
                return indgree.get(this.v) - indgree.get(o.v);
            }
        }

        PriorityQueue<NodeInfo> pq = new PriorityQueue<>();
        mp.keySet().forEach(x -> {
            pq.add(new NodeInfo(x));
        });

        while (!pq.isEmpty()) {
            NodeInfo peek = pq.peek();
            if (indgree.get(peek.v) != 0) {
                System.out.println("Cycle is there ");
                break;
            }
            System.out.println(peek.v);
            mp.get(peek.v).forEach(child -> {
                indgree.put((Integer)child , indgree.get(child)-1);
            });
            pq.poll();
        }


    }

    void DFSUtil(int start, HashMap<Integer, Boolean> visted) {
        visted.put(start, true);
        System.out.print(start + " ");
        Iterator<Integer> it = mp.get(start).iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (!visted.get(next)) {
                DFSUtil(next, visted);
            }
        }
    }

    void DFS() {
        Set<Integer> set = mp.keySet();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        set.forEach(x -> visited.put(x, false));
        System.out.println(visited);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int next = it.next();
            if (!visited.get(next)) {
                DFSUtil(next, visited);
            }
        }
    }

    public static void main(String[] args) {

//        HashMap<Integer , Boolean> mp = new HashMap<>();
//        mp.put(1 , false);
//        System.out.println(mp);
//        mp.put(1 , true);
//        System.out.println(mp);

        TopologicalShort gp = new TopologicalShort();
        gp.add(2, 1);
        gp.add(3, 1);
        gp.add(10, 1);

        gp.add(4, 2);
        gp.add(5, 2);

        gp.add(5, 3);
        gp.add(6, 3);
        gp.add(7, 3);

        gp.add(6, 5);



//        gp.add(4,1);

//        gp.DFS();
        gp.sort();
    }


}
