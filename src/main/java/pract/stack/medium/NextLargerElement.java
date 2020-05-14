package pract.stack.medium;

import pract.Reader;

import java.util.Stack;

public class NextLargerElement {

    static long getLargest(Stack<Long> stk, Long n) {
        if(stk.isEmpty()){
            stk.push(n);
            return -1 ;
        }
        else if(stk.peek() > n ){
            long largest = stk.peek();
            stk.push(n);
            return largest;
        }
        else {
            stk.pop();
            return getLargest(stk, n);
        }
    }

    static void printLargest(long[] arr , int size) {
        Stack<Long> stk = new Stack<Long>();
        Stack<Long> res = new Stack<Long>();
        for(int i =  size-1 ; i >=0 ; i-- ){
            res.push(getLargest(stk, arr[i]));
        }
        while (!res.isEmpty()){
            System.out.print(res.pop() + " ");
        }

    }

    public static void main(String[] args) throws Exception {

        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            long[] arr = new long[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextLong();
            }
            printLargest(arr, size);
        }

    }
}
