package ds_algo_assignment.week_4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Iterator;

class Item implements Comparable<Item> {
    int v;
    int p;

    Item(int v, int p) {
        this.v = v;
        this.p = p;
    }

    @Override
    public int compareTo(Item o) {
        return (this.p-o.p);
    }


//    @Override
//    boolean equals(Item obj) {
//        return false;
//    }
}


//
//class ItemComprator implements Comparator<Item>{
//    @Override
//    public int compare(Item o1, Item o2) {
//        return (o1.p-o2.p);
//    }
//}

public class Test {
    public static void main(String[] args) {
        MinPQ<Item> pq = new MinPQ<Item>(3);
        Item one = new Item(5,3);
        pq.insert(one);
        Item two = new Item(4,1);
        pq.insert(two);
        Item three = new Item(3,2);
        pq.insert(three);

        Iterator<Item> it = pq.iterator();
        while(it.hasNext()){
            System.out.println(it.next().v);
        }


    }
}
