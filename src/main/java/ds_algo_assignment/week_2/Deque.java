package ds_algo_assignment.week_2;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        Node next;
        final Item v;

        Node(Item v) {
            this.v = v;
        }
    }

    private int size;
    private Node first;
    private Node last;

    private class MyIterator implements Iterator<Item> {
        Node head;

        MyIterator(Node head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public Item next() {
            if (head == null) {
                throw new java.util.NoSuchElementException("No more elements exist");
            }
            Item value = head.v;
            head = head.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }

    public Deque() {
        size = 0;
        first = null;
        last = null;

    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            size++;
            Node newNode = new Node(item);
            newNode.next = first;
            if (isEmpty()) {
                first = last = newNode;
            } else {
                newNode.next = first;
                first = newNode;
            }
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            size++;
            Node newNode = new Node(item);
            if (isEmpty()) {
                first = last = newNode;
            } else {
                last.next = newNode;
                last = last.next;
            }
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) {
            throw new java.util.NoSuchElementException("No more elements exist");
        }
        size--;
        Item value = first.v;
        first = first.next;
        return value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (last == null) {
            throw new java.util.NoSuchElementException("No more elements exist");
        }
        size--;
        if (first == last) {
            Item value = last.v;
            first = last = null;
            return value;
        } else {
            Node pointer = first;
            while (pointer.next.next != null) {
                pointer = pointer.next;
            }
            last = pointer;
            Item value = last.next.v;
            last.next = null;
            return value;
        }

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new MyIterator(first);
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<Integer>();
        dq.addLast(2);
        dq.addFirst(1);
        dq.addFirst(0);
        dq.removeLast();
        dq.removeFirst();

        for (Object aDq : dq) {
            System.out.println(aDq);
        }

    }

}