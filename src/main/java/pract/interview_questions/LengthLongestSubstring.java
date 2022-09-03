package pract.interview_questions;

import pract.Reader;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 */
public class LengthLongestSubstring {

    static int find(String str, int l) {
        int i = 0;
        int max_so_far = 0;
        boolean duplicateFound = false;
        char duplicate_char = '$';
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int j = 0; j < l; j++) {
            char c = str.charAt(j);

            if (!mp.containsKey(c)) {
                mp.put(c, 1);
                max_so_far = (j - i + 1) > max_so_far ? (j - i + 1) : max_so_far;
            } else {
                mp.put(c, mp.get(c) + 1);
                duplicateFound = true;
                duplicate_char = str.charAt(j);
            }
            while (i < j && duplicateFound) {
                int v = mp.get(str.charAt(i));
                if (v > 1) {
                    mp.put(str.charAt(i), v - 1);
                }
                else {
                    mp.remove(str.charAt(i));
                }
                if (str.charAt(i) == duplicate_char) {
                    duplicateFound = false;
                }
                i++;
            }
        }

        return max_so_far;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String str = sc.next();
            System.out.println(find(str , str.length()));
        }

    }
}
