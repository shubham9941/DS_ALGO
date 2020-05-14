package pract.array.easy;

public class Test {
    public static void main(String[] args) {
//        int[] arr = {1, 0, 0, 1, 0};
//        int[] arr = {1, 0, 1, 0};
        int[] arr = {1, 0, 1, 0, 0, 0, 1};
        int totalOne = 0;
        int start = -1;
        int end = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                totalOne++;
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                    max = Math.max(max, end - start - 1);
                    start = i;
                }
            }
        }
        System.out.println(max + totalOne);
    }
}
