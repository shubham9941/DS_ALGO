package pract.queue.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0
 */

public class RemoveMinimumNumbers {

    public static int pushNumber(Deque<Character> stk, char c, int k) {
        if (stk.isEmpty()) {
            stk.push(c);
            return k;
        } else if (!stk.isEmpty() && k > 0 && (Integer.parseInt(String.valueOf(c)) < Integer.parseInt(String.valueOf(stk.peekLast())))) {
            stk.pollLast();
            k--;
            return pushNumber(stk, c, k);
        } else {
            stk.addLast(c);
            return k;
        }
    }

    public static void removeFirstZeros(Deque<Character> dq) {
        if (!dq.isEmpty() && (dq.peekFirst() == '0')) {
            dq.removeFirst();
            removeFirstZeros(dq);
        }
    }


    public static String removeKdigits(String num, int k) {
        Deque<Character> stk = new LinkedList<>();
        if (num.isEmpty()) {
            return "0";
        }
        for (int i = 0; i < num.length(); i++) {
            k = pushNumber(stk, num.charAt(i), k);
        }
        if (k > 0) {
            while (!stk.isEmpty() && k > 0) {
                k--;
                stk.removeLast();
            }
        }
        removeFirstZeros(stk);

        if (stk.isEmpty()) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stk.isEmpty()) {
                sb.append(stk.poll());
            }

            return sb.toString();
        }

    }


    public static void main(String[] args) {

        String str = "112";

        System.out.println(removeKdigits(str, 1));
//        System.out.println(Integer.parseInt("012"));
    }
}
