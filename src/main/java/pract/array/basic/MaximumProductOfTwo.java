package pract.array.basic;

import java.util.Scanner;

public class MaximumProductOfTwo {
    static int getMaxProdOfTwo(int[] arr) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (r < temp) {
                l = r;
                r = temp;
            } else if (l < temp) {
                l = temp;
            }
        }
        return (l * r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getMaxProdOfTwo(arr));
        }

    }
}
