package pract.queue.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    // With space (combine petrol and distance in the Queue and provide it)
    static int getIndex(Queue<Integer> q, int size) {
        Queue<Integer> helper = new LinkedList<Integer>();
        int index = -1;
        int i = 0;
        int balance = 0;

        while (!q.isEmpty()) {
            System.out.println(" i = " + i);

            if ((index > size) || (i > (size * 2) - 1)) {
                index = -1;
                break;
            }

            if (index == -1)
                index = i;

            int first = q.poll() + balance;
            int second = q.poll();
            helper.add(first - balance);
            helper.add(second);
            if (first - second < 0) {
                while (!helper.isEmpty()) {
                    q.add(helper.poll());
                }
                index = -1;
                balance = 0;
            } else {
                balance = first - second;
            }
            i++;

            System.out.println(" First = " + first);
            System.out.println(" Second= " + second);
            System.out.println(" balance = " + balance);
            System.out.println(" index = " + index);
            System.out.println("");

        }
        return index;

    }

    //Without using any space
    static int tour(int petrol[], int distance[]) {
        int size = petrol.length;
        int index = -1;
        int i = 0;
        int balance = 0;
        boolean circleStarted = false;

        while (i != index) {
            if (circleStarted && index == -1) {
                break;
            }
            if (index == -1)
                index = i;

            int first = petrol[i] + balance;
            int second = distance[i];

            if (first - second < 0) {
                index = -1;
                balance = 0;
            } else {
                balance = first - second;
            }
            i++;
            if (i == size) {
                i = 0;
                circleStarted = true;
            }
        }
        return index;
    }    //Without using any space



    public static void main(String[] args) {

        int[] petrol = {1, 2, 3, 7};
        int[] distance = {1, 2, 4, 4};

        System.out.print(tour(petrol, distance));


    }
}
