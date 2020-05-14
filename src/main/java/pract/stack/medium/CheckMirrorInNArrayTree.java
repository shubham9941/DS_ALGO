package pract.stack.medium;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CheckMirrorInNArrayTree {

    static String getMirror(int[] arr, int n) {
        Stack<String> stk = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        int root = arr[0];
        for (int i = 0; i < n - 1; i = i + 2) {
            if (arr[i] == root) {
                stk.push("" + root + arr[i + 1]);
            } else {
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
                root = arr[i];
                stk.push("" + root + arr[i + 1]);
            }
        }
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int numberOfNodes = sc.nextInt();
            int numberOfEdege = sc.nextInt();
            int size = numberOfEdege * 2;
            int[] treeRecord1 = new int[size];

            StringBuilder expectedRes = new StringBuilder();

            for (int i = 0; i < size; i++)
                treeRecord1[i] = sc.nextInt();
            for (int j = 0; j < size; j++)
                expectedRes.append(sc.nextInt());


            String res = getMirror(treeRecord1, size);
            System.out.println(">>>Res>>>> " + res);
            if (expectedRes.toString().equals(res))
                System.out.println(1);
            else System.out.println(0);


        }

    }
}
