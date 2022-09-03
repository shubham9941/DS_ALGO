package pract.interview_questions.set1;

import java.util.Arrays;
import java.util.Comparator;

public class SortTheWordsInLexicographicalOrder {

    static class MyComporator implements Comparator<String> {
        public int compare(String o1, String o2) {
            int lim = Math.min(o1.length(), o2.length());
            int k = 0;
            while (k < lim) {
                char c1 = o1.charAt(k);
                char c2 = o2.charAt(k);
                if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                    if (c1 - c2 < 0) {
                        return -1;
                    }
                    if (c1 - c2 > 0) {
                        return 1;
                    }
                }
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }

            return o1.length() - o2.length();
        }
    }

    void sort(String[] arr, int n) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        String[] arr = {"funny", "fun", "fuNny"};
        String s1 = "funny";
        String s2 = "fun";
        Arrays.sort(arr, new MyComporator());
        System.out.println(Arrays.toString(arr));

    }
}
