package pract.heap.hard;

import pract.Reader;

import java.util.PriorityQueue;

public class MedianInAStreamOfIntegers {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int m;

    MedianInAStreamOfIntegers() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        m = 0;
    }

    int getCount() {
        if (max.size() == min.size()) {
            return 0;
        }
        if (max.size() < min.size()) {
            return -1;
        }
        return 1;
    }

    int findMedian(int i, int m) {
        int count = getCount();
        if (count == 0) { // if left and right have same number of elements
            if (m < i) {
                min.add(i);
                return min.peek();
            } else {
                max.add(i);
                return max.peek();
            }
        } else if (count == -1) { // if right(min) have more elements
            if (m < i) {
                max.add(min.poll());
                min.add(i);
            } else {
                max.add(i);
            }

            return (min.peek() + max.peek()) / 2;

        } else { // if left(max) have more elements then right
            if (m < i) {
                min.add(i);
            } else {
                min.add(max.poll());
                max.add(i);
            }
            return (min.peek() + max.peek()) / 2;
        }
    }

    void findMedianInStream(int i) {
        m = findMedian(i, m);
        System.out.println(m);
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int elementsInStream = sc.nextInt();
        MedianInAStreamOfIntegers obj = new MedianInAStreamOfIntegers();

        while (elementsInStream-- > 0) {
            obj.findMedianInStream(sc.nextInt());
        }
    }
}
