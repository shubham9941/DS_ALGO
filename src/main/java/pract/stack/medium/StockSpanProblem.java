package pract.stack.medium;

import java.util.Stack;

public class StockSpanProblem {

    // O(n)
    static void calculateSpan(int price[], int n, int S[])
    {
        // Create a stack and push index of first element
        // to it
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // Span value of first element is always 1
        S[0] = 1;

        // Calculate span values for rest of the elements
        for (int i = 1; i < n; i++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());

            // Push this element to stack
            st.push(i);
        }
    }

    // O(n^2)

    static int calculate(int v, Stack<Integer> stk) {
        if (stk.empty()) {
            return 1;
        } else if (stk.peek() > v) {
            return 1;
        } else {
            int top = stk.pop();
            int res = 1 + calculate(v, stk);
            stk.push(top);
            return res;
        }
    }

    static void printRes(int[]arr){
        Stack<Integer> stk = new Stack<Integer>();
        for(int i : arr){
            System.out.print(calculate(i , stk) + " ");
            stk.push(i);
        }
    }

    public static void main(String[] args) {
        int[]arr = {100, 80, 60, 70, 60, 75, 85};
//        int[]arr = {10, 4, 5, 90, 120, 80};
        printRes(arr);

    }
}
