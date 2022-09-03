package pract.interview_questions;

public class PreToPostBST {

    static class Index {
        int i;

        Index() {
            i = 0;
        }
    }

    static void convert(int[] pre, int min, int max, int n, Index ind) {
        if (ind.i != n && pre[ind.i] > min && pre[ind.i] < max) {
            int data = pre[ind.i];
            ind.i++;
            convert(pre, min, data, n, ind);
            convert(pre, data, max, n, ind);
            System.out.print(data + " ");
        }
    }

    public static void main(String[] args) {

//        int[]pre = {40,30,35,80,100};
        int[]pre = {40, 30, 32, 35, 80, 90, 100, 120};
        convert(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, pre.length, new Index());

    }
}
