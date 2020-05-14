package ds_algo_assignment.week_2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private class Node {
        Node next;
        final Item v;

        Node(Item v) {
            this.v = v;
        }
    }

    private int size;
    private Node first;

    public RandomizedQueue() {
        size = 0;
        first = null;
    }

    private class MyIterator implements Iterator<Item> {

        private Item[] arr ;
        private int i = 0;

        MyIterator(Node lst , Item[] arr) {
            this.arr = arr;
            insertAllElements(lst);
        }

        private void insertAllElements(Node list) {

            while (list != null) {
                arr[i] = list.v;
                list = list.next;
                i++;
            }
            StdRandom.shuffle(arr);
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (i <= 0) {
                throw new java.util.NoSuchElementException("No more elements exist");
            }
            Item element = arr[--i];
            return  element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private Item delete(int pos) {
        size--;
        int counter = 1;
        if (pos == 0) {
            Item value = first.v;
            first = first.next;
            return value;
        } else {
            Node head = first;
            while (pos != counter) {
                counter++;
                head = head.next;
            }
            Item value = head.next.v;
            head.next = head.next.next;
            return value;
        }
    }

    private int getIndex() {
        if (size() == 0) {
            throw new java.util.NoSuchElementException("No more elements exist");
        }
        return StdRandom.uniform(0, size());
    }

    private Item getRandomElement(int pos, int counter) {
        Node head = first;
        while (pos != counter) {
            head = head.next;
            counter++;
        }
        return head.v;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        Node newNode = new Node(item);
        newNode.next = first;
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

    }

    public Item dequeue() {
        int index = getIndex();
        return delete(index);
    }

    public Item sample() {
        return getRandomElement(getIndex(), 0);
    }


    public Iterator<Item> iterator() {
        return new MyIterator(first , (Item[]) new Object[size]);
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> obj = new RandomizedQueue<Integer>();
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);

        for (Object anObj : obj) {
            System.out.println(anObj);
        }

    }

}