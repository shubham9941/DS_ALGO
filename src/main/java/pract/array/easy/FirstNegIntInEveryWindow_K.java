package pract.array.easy;

import java.util.LinkedList;

public class FirstNegIntInEveryWindow_K {

    static void printData(int[] arr, int n, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = 0;

        for (; i < k; i++) {
            if (arr[i] < 0) {
                list.add(i);
            }
        }

        for (; i < n; i++) {
            if (list.isEmpty()) {
                System.out.println(0);
            }
            if (!list.isEmpty() && list.peek() < i) {
                System.out.println(arr[list.peek()]);
                list.remove(list.peek());
            }
            if (arr[i] < 0) {
                list.add(i);
            }
        }
    }

    static void printFirstNegativeInteger(int arr[],
                                          int n, int k)
    {
        LinkedList<Integer> Di = new LinkedList<>();

        // Process first k (or first window)
        // elements of array
        int i;
        for (i = 0; i < k; i++)

            // Add current element at the rear of Di
            // if it is a negative integer
            if (arr[i] < 0)
                Di.add(i);

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for ( ; i < n; i++)
        {
            // if Di is not empty then the element
            // at the front of the queue is the first
            // negative integer of the previous window
            if (!Di.isEmpty())
                System.out.print(arr[Di.peek()] + " ");

                // else the window does not have a
                // negative integer
            else
                System.out.print("0" + " ");

            // Remove the elements which are
            // out of this window
            while ((!Di.isEmpty()) &&
                    Di.peek() < (i - k + 1))
                Di.remove(); // Remove from front of queue

            // Add current element at the rear of Di
            // if it is a negative integer
            if (arr[i] < 0)
                Di.add(i);
        }

        // Print the first negative
        // integer of last window
        if (!Di.isEmpty())
            System.out.print(arr[Di.peek()] + " ");
        else
            System.out.print("0" + " ");
    }

    public static void main(String[] args) {

        int[] arr = {-8, 2, 3, -6, 10};
        printFirstNegativeInteger(arr , arr.length , 2);

    }
}
