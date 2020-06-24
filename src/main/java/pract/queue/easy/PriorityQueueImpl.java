package pract.queue.easy;

import java.util.PriorityQueue;

public class PriorityQueueImpl {

    int DEFAULT_CAPACITY;
    int[] queue;
    int size;

    PriorityQueueImpl(int cap) {
        this.DEFAULT_CAPACITY = cap;
        this.queue = new int[cap + 1];
        queue[0] = cap;
        size = 0;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private boolean bubbleUp(int pos) {
        if (pos == 1)
            return true;
        else if (queue[pos] > queue[pos / 2]) {

            swap(queue, pos, pos / 2);
            return bubbleUp(pos / 2);
        } else return true;

    }

    private boolean sink(int pos) {
        int j = pos * 2;
        if (j > size)
            return true;
        else if (j < size) {
            j = (queue[j] > queue[j + 1]) ? j : j + 1;
        }
        if (queue[j] > queue[pos]){
            swap(queue, j, pos);
            return sink(j);
        } else return true;
    }

    public boolean add(int v) {
        if(size == DEFAULT_CAPACITY)
            throw new RuntimeException("Capacity full");
        size++;
        queue[size] = v;
        if (size == 1)
            return true;
        else
            return bubbleUp(size);
    }

    public void remove() {
//        System.out.println("Before removing size = " + size);
        if(size == 0 )
            throw new RuntimeException("No more element exist in queue");
        swap(queue , 1 , size);
        System.out.print(queue[size] + " ");
        size--;
        sink(1);

    }

    public void printAll() {
        int to = size;
        for(int i  = 1 ; i <= to ; i ++){
//            System.out.print(queue[i] + " ");
            remove();
        }
    }

    public static void main(String[] args) {
        PriorityQueueImpl queue = new PriorityQueueImpl(4);
//        PriorityQueue queue = new PriorityQueue(10);
        queue.add(4);
        queue.add(2);
        queue.add(3);
        queue.add(1);
//        queue.add(5);
//        queue.add(6);
//        System.out.println(queue);
        queue.printAll();

    }
}
