package pract.array.easy;

public class MaximizeNumberOfOneS {
    static void findZeroes(int[] arr, int m) {
        // Left and right indexes of current window
        int wL = 0, wR = 0;

        // Left index and size of the widest window
        int bestL = 0, bestWindow = 0;

        // Count of zeroes in current window
        int zeroCount = 0;

        // While right boundary of current window doesn't cross
        // right end
        while (wR < arr.length) {
            // If zero count of current window is less than m,
            // widen the window toward right
            System.out.println("wR: - " + wR);
            System.out.println("wL: - " + wL);

            if (zeroCount <= m) {
                if (arr[wR] == 0)
                    zeroCount++;
                wR++;
            }
            System.out.println("Current zero:- " + zeroCount);

            // If zero count of current window is more than m,
            // reduce the window from left
            if (zeroCount > m) {
                if (arr[wL] == 0)
                    zeroCount--;
                wL++;
            }

            System.out.println();

            // Update widest window if this window size is more
            if ((wR - wL > bestWindow) && (zeroCount <= m)) {
                bestWindow = wR - wL;
                bestL = wL;
            }

        }

        System.out.println("bestWindow>>>>> " + bestWindow);

        // Print positions of zeroes in the widest window
        for (int i = 0; i < bestWindow; i++) {
            if (arr[bestL + i] == 0)
                System.out.print(bestL + i + " ");
        }
    }


    public static void main(String[] args) throws Exception {
//        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int[] arr = {1, 0, 0, 1, 0};
        findZeroes(arr,1);
//        int[] arr = {1,0,1,0};

//        printMaxLengthBF(arr, arr.length, 0);

//
//        Reader sc = new Reader();
//        int testCases = sc.nextInt();
//        while (testCases-- > 0) {
//            int size = sc.nextInt();
////            int[] arr = new int[size];
//            for (int i = 0; i < size; i++) {
//                arr[i] = sc.nextInt();
//            }
//            int k = sc.nextInt();
//            findZeroes(arr, k);
////            System.out.print(flipToMax(arr,  k));
//        }
    }

}
