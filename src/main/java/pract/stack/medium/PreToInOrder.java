package pract.stack.medium;

import java.util.Stack;

public class PreToInOrder {

    int getIndex(int[] arr, int start, int end, int v) {
        int i = start;
        for (; i < end && arr[i + 1] < v; i++) ;
        return i;
    }

    void convert(int[] arr, int start, int end, Stack<Integer> stk) {
        if (start == end) {
            stk.push(arr[start]);
        } else {
            int v = arr[start];
            int index = getIndex(arr, start, end, v);
            if (index != start && index != end) {
                convert(arr, index + 1, end, stk);
                stk.push(v);
                convert(arr, start + 1, index, stk);
            } else if (index == start) {
                convert(arr, start + 1, end, stk);
                stk.push(v);
            } else {
                stk.push(v);
                convert(arr, start + 1, end, stk);
            }
        }
    }

    public static void main(String[] args) {
        PreToInOrder obj = new PreToInOrder();
        Stack<Integer> stk = new Stack<Integer>();
        int[] arr = {10, 9, 8, 15};
        obj.convert(arr, 0, arr.length - 1, stk);
        while (!stk.empty())
            System.out.print(stk.pop() + " ");
    }
}
