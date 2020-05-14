package pract.stack.medium;

import java.util.Stack;

public class CelebrityProblem {


    // This solution is simple using O(n^2). Tried to solve in O(n) if possible

    static int getCelebrity(int[][] arr, int n) {
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    count = 0;
                    break;
                } else count++;
                if (count == n) {
                    stk.push(i);
                }
            }
        }
        if(stk.isEmpty() || stk.size() > 1){
            return -1 ;
        } else return stk.pop();
    }

    public static void main(String[] args) {

//        int[][] arr = {{0, 0, 1, 0},
//                {0, 0, 1, 0},
//                {0, 0, 0, 0},
//                {0, 0, 1, 0}};
//        int[][] arr = {{0, 0, 1, 0},
//                {0, 0, 1, 0},
//                {0, 1, 0, 0},
//                {0, 0, 1, 0}};
        int[][] arr = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

//        int[][] arr = {
//                {1, 1},
//                {1, 0}};

        int res = getCelebrity(arr, arr.length);
        System.out.println(res);

    }


}
