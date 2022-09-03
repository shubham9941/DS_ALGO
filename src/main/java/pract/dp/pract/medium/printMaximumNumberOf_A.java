package pract.dp.pract.medium;


import pract.Reader;

class printMaximumNumberOf_A {

    //using recursion
    static int findoptimal(int N) {
        // The optimal string length is N
        // when N is smaller than 7
        if (N <= 6)
            return N;

        // Initialize result
        int max = 0;

        int b;
        for (b = N - 3; b >= 1; b--) {
            int curr = (N - b - 1) * findoptimal(b);
            if (curr > max)
                max = curr;
        }
        return max;
    }


    static int findoptimalUsingDP(int N, int[] t) {
        // The optimal string length is N
        // when N is smaller than 7
        if (N <= 6)
            return N;

        if (t[N] != -1) {
            return t[N];
        }

        // Initialize result
        int max = 0;

        int b;
        for (b = N - 3; b >= 1; b--) {
            int curr = (N - b - 1) * findoptimalUsingDP(b, t);
            if (curr > max)
                max = curr;
        }
        t[N] = max;
        return t[N];
    }

    // Driver program
    public static void main(String[] args) throws Exception {
        int[] t = new int[75 + 1];
        for (int i = 7; i < 75 + 1; i++) {
            t[i] = -1;
        }
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int N = sc.nextInt();
            System.out.println(findoptimalUsingDP(N , t));
        }
    }
}

// This code is contributed by vt_m.

