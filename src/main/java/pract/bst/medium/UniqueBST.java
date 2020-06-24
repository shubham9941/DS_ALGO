package pract.bst.medium;

import pract.Reader;

public class UniqueBST {

    static void calculate(int[] T, int i) {
        int prev = -1;
        int after = i;
        for (int j = 1; j <= i; j++) {
            prev++;
            after--;
            T[i] += T[prev] * T[after];
        }
    }

    static int uniqueBST(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] T = new int[n + 1];
        T[0] = 1;
        T[1] = 1;
        for (int i = 2; i <= n; i++) {
            calculate(T, i);
        }
        return T[n];
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            System.out.println(uniqueBST(n));
        }

    }
}
