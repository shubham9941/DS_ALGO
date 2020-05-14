package ds_algo_assignment.week_1;

import java.util.Arrays;

public class BitonicSearch {

//    int findPeak(int[] arr, int l, int r) {
//
//    }

    static int getIndexFromBitonic(int[] arr, int key) {
        String a = Arrays.toString(arr);
        System.out.println(a);
        return a.indexOf("20");
    }

    public static void main(String[] args) {
        int[] arr = {-3, 9, 8, 20, 17, 5, 1};
        System.out.println(getIndexFromBitonic(arr, 20));

    }
}