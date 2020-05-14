package pract.array.basic;

import pract.Reader;

public class AlternatePosAndNegNo {
    static void swap(int[] arr, int i, int j) {
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void convert(int[] arr, int size) {
        boolean temp = true;
        int i = 0;
        int j = 0;
        while (i < size) {
            for (j = i; j < size-1; j++) {
                if (arr[j] >= 0 && temp) {
                    temp = false;
                    break;
                } else if (arr[j] < 0 && !temp) {
                    temp = true;
                    break;
                }
            }
            swap(arr, i, j);
            i++;
        }
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
            convert(arr, arr.length);
            StringBuilder sb = new StringBuilder();
            for(int j : arr){
                sb.append(j+ " ");
            }
            System.out.println(sb);
        }

    }
}
