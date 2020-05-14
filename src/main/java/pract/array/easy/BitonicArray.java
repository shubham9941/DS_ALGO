package pract.array.easy;

import pract.Reader;

public class BitonicArray {
    static String getRes(int[] arr, int size) {
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = arr[0];
        rightMax[size - 1] = arr[size - 1];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        int i = 1;
        while (i < size - 1) {
            if (leftMax[i - 1] < arr[i] && arr[i] > rightMax[i + 1])
                return "YES";
            i++;
        }
        return "NO";
    }


    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getRes(arr, size));
        }
    }
}
