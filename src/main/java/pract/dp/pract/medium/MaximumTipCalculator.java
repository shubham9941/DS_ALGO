package pract.dp.pract.medium;

import pract.Reader;

public class MaximumTipCalculator {

    static int get(int n, int[] rTips, int[] aTips, int r, int a , int [][][]t) {
        if (n == 0) {
            return 0;
        }

        if(t[n][r][a]!=-1){
            return t[n][r][a];
        }

        if (r == 0) {
            return t[n][r][a] = Integer.max(aTips[n - 1] + get(n - 1, rTips, aTips, r, a - 1, t),
                    get(n - 1, rTips, aTips, r, a, t));
        }

        if (a == 0) {
            return t[n][r][a] =  Integer.max(rTips[n - 1] + get(n - 1, rTips, aTips, r - 1, a, t),
                    get(n - 1, rTips, aTips, r, a, t));
        }

        return t[n][r][a] = Integer.max(
                rTips[n - 1] + get(n - 1, rTips, aTips, r - 1, a, t),
                aTips[n - 1] + get(n - 1, rTips, aTips, r, a - 1,t)
        );
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int size = sc.nextInt();
            int r = sc.nextInt();
            int a = sc.nextInt();

            int[]rtips = new int[size];
            int[]atips = new int[size];

            for(int i = 0 ; i < size ; i++){
                rtips[i] = sc.nextInt();
            }
            for(int i = 0 ; i < size ; i++){
                atips[i] = sc.nextInt();
            }

            int[][][] t = new int[size + 1][r + 1][a + 1];
            for (int i = 0; i < size + 1; i++) {
                for (int j = 0; j < r + 1; j++) {
                    for (int k = 0; k < a + 1; k++) {
                        t[i][j][k] = -1;
                    }
                }
            }

            System.out.println(get(size, rtips, atips, r, a, t));

        }
    }
}
