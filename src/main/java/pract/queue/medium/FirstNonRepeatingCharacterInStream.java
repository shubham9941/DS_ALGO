package pract.queue.medium;

import java.util.*;

/**
 * Input:
 * 2
 * 4
 * a a b c
 * 3
 * a a c
 * <p>
 * Output:
 * a -1 b b
 * a -1 c
 */

public class FirstNonRepeatingCharacterInStream {

    static void printData(Queue<Character> qu, Map<Character, Integer> mp) {
        if (qu.isEmpty()) {
            System.out.print("-1" + " ");
        } else {
            char first = qu.peek();
            if (mp.containsKey(first) && mp.get(first) > 1) {
                qu.poll();
                printData(qu, mp);
            } else {
                System.out.print(first + " ");
            }
        }
    }

    static void printFirstNonRepeating(String str, int totalChars) {

        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        Queue<Character> qu = new LinkedList<Character>();
        for (int i = 0; i <= totalChars; i = i + 2) {
            char c = str.charAt(i);
            qu.add(c);
            int v = (mp.containsKey(c)) ? mp.get(c) + 1 : 1;
            mp.put(c, v);
            printData(qu, mp);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        while (testCases-- > 0) {
            int size = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            printFirstNonRepeating(str, size * 2 - 2);
            System.out.println("");
        }


    }

}
