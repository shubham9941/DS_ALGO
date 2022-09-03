package pract.array.medium;

import pract.Reader;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedFromAnArray {

    static String createLargerNumber(Integer[] arr, int n) {

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                int firstPos = Integer.parseInt("" + first + second);
                int lastPos = Integer.parseInt("" + second + first);

                if (firstPos > lastPos) {
                    return -1;
                }
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int a : arr) {
            sb.append(a);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            Integer[] arr = new Integer[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(createLargerNumber(arr, size));
        }
    }
}
