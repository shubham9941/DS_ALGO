package pract.dp.pract.medium;

import pract.Reader;

import java.util.*;

public class WordBreakProblem {

    private static Set<String> dictionary = new HashSet<>();

    static boolean wordBreak(String word, int[] t) {
        int size = word.length();

        if (size == 0)
            return true;

        if (t[size] != -1) {
            return (t[size] == 1);
        }

        for (int i = 1; i <= size; i++) {
            boolean res = dictionary.contains(word.substring(0, i)) && wordBreak(word.substring(i, size), t);
            if (res) {
                t[size] = 1;
                return true;
            } else {
                t[size] = 0;
            }
        }

        t[size] = 0;
        return false;
    }

    static int getRes(String word, int[] t) {
        if (wordBreak(word, t)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int size = sc.nextInt();
            String[] dic = sc.readLine().split(" ");
            String word = sc.readLine();
            dictionary.addAll(Arrays.asList(dic));
            int[] t = new int[word.length() + 1];
            Arrays.fill(t, -1);
            System.out.println(getRes(word, t));
        }
    }


}

