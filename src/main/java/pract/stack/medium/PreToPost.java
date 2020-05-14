package pract.stack.medium;

import pract.Reader;

import java.util.Arrays;
import java.util.Stack;

public class PreToPost {

    public static boolean preToPost(int[] a, Stack<Integer> stk, int start, int end, int min, int max) {


        if (a[start] > max || a[start] < min) return false;
        stk.push(a[start]);
        if (start == end) {
            return true;
        }

        int idx = searchIdx(a, start, end, a[start]);
        if (idx == start) {
            return preToPost(a, stk, start + 1, end, a[start], max);
        }
        if (idx == end) {
            System.out.println(">>>>Hey i m herer>>>>>>");
            return preToPost(a, stk, start + 1, end, min, a[start]);
        }
        return preToPost(a, stk, idx + 1, end, a[start], max) && preToPost(a, stk, start + 1, idx, min, a[start]);
    }

    public static int searchIdx(int[] a, int start, int end, int val) {
        int i = start;
        for (; i < end && a[i + 1] < val; i++) ;

        return i;
    }

    public static int search(int[] arr, int l, int r, int k) {
        if (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == k)
                return m;
            else if (k > arr[m]) {
                return search(arr, m + 1, r, k);
            }
            return search(arr, l, m - 1, k);
        }

        return -1;
    }

    public static void myPreToPost(int[] preOrder, int pre_start, int pre_end, int[] inOrder, int start, int end, Stack<Integer> stk) {
        int root = preOrder[pre_start];
        stk.push(root);
        if (start == end) {
            return;
        } else {
            int index = search(inOrder, start, end, root);
            int leftElement = index - start;
            int rightElement = end - start;
            if (index == start) {
                myPreToPost(preOrder, pre_start + 1, pre_end, inOrder, start + 1, end, stk);
            } else if (index == end) {
                myPreToPost(preOrder, pre_start + 1, pre_end, inOrder, start, end - 1, stk);
            } else {
                myPreToPost(preOrder, pre_start + leftElement + 1, pre_end, inOrder, index + 1, end, stk);
                myPreToPost(preOrder, pre_start + 1, pre_start + leftElement + 1, inOrder, start, index - 1, stk);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] preOprder = new int[size];
            for (int i = 0; i < size; i++) {
                preOprder[i] = sc.nextInt();
            }
            int[] inOrder ;
            inOrder = preOprder.clone();
            Arrays.sort(inOrder);
            Stack<Integer> stk = new Stack<Integer>();
//            myPreToPost(preOprder, 0, size - 1, inOrder, 0, size - 1, stk);
            preToPost(preOprder, stk, 0, size-1, -1, 9999);
            while (!stk.isEmpty()) {
                System.out.print(stk.pop() + " ");
            }

        }



    }

}
