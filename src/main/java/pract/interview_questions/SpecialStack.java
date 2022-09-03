package pract.interview_questions;

import java.util.Stack;

public class SpecialStack {
     int min;

    SpecialStack() {
        min = Integer.MAX_VALUE;
    }


    public void push(int a, Stack<Integer> s) {
        if (isEmpty(s)) {
            min = a;
            s.push(a);
        } else if (a > min) {
            s.push(a - min);
        } else {
            s.push(a - min);
            min = a;
        }
    }

    public int pop(Stack<Integer> s) {
        int top = s.pop();
        if (isEmpty(s)) {
            min = Integer.MAX_VALUE;
            return top;
        }
        if (top >= 0) {
            return min + top;
        }
        else{
            int nextMin = min-top;
            int act = min;
            min = nextMin;
            return act;
        }
    }

    public int min(Stack<Integer> s) {
        return min;
    }

    public boolean isFull(Stack<Integer> s, int n) {
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.isEmpty();
    }

    public static void main(String[] args) {

        SpecialStack stk = new SpecialStack();
        int n = 5;
        Stack<Integer> s = new Stack<Integer>() ;
        stk.push(18, s);
//        stk.push(19, s);
//        stk.push(29, s);
//        stk.push(15, s);
//        stk.push(16, s);

        System.out.println(stk.isFull(s, 5));

//        System.out.println("Min = " + stk.min);
//        System.out.println(stk.pop(s));
//        System.out.println(stk.pop(s));
//        System.out.println(stk.pop(s));
//        System.out.println(stk.pop(s));
//        System.out.println(stk.pop(s));
//        System.out.println(stk.pop(s));
//        System.out.println("Min = " + stk.min);

    }
}
