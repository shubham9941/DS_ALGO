package pract.dp.pract.easy;

import pract.Reader;

/**
 * Stickler the thief wants to loot money from a society having n houses in a single line.
 * He is a weird person and follows a certain rule when looting the houses.
 * According to the rule, he will never loot two consecutive houses.
 * At the same time, he wants to maximize the amount he loots.
 * The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy.
 * He asks for your help to find the maximum money he can get if he strictly follows the rule.
 * Each house has a[i] amount of money present in it.
 */

public class SticklerThief {

    static int getMaxAmount(int[] arr, int n, int[] t) {
        if (n <= 0) {
            return 0;
        }
        if (t[n - 1] != -1) {
            return t[n - 1];
        }

        t[n - 1] = Integer.max(arr[n - 1] + getMaxAmount(arr, n - 2, t),
                getMaxAmount(arr, n - 1, t));
        return t[n - 1];
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            int[] t = new int[size + 1];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < size + 1; i++) {
                t[i] = -1;
            }
            System.out.println(getMaxAmount(arr, size , t));
        }
    }
}
