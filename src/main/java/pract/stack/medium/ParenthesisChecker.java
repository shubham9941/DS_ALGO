package pract.stack.medium;

import edu.princeton.cs.algs4.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParenthesisChecker {

    HashMap<Character, Character> mp;

    ParenthesisChecker() {
        mp = new HashMap<>();
        mp.put('}', '{');
        mp.put(')', '(');
        mp.put(']', '[');
    }

    void check(String str) {
        Stack<Character> stk = new Stack<Character>();
        String res = "balanced";
        for (char c : str.toCharArray()) {
            if (!mp.containsKey(c)) {
                stk.push(c);
            } else if(!stk.isEmpty()) {
                char top = stk.pop();
                if (Character.compare(top, (char) mp.get(c)) != 0) {
                    res = "not balanced";
                    break;
                }
            }
            else {
                res = "not balanced";
                break;
            }
        }
        if (!stk.isEmpty())
            res = "not balanced";
        System.out.println(res);
    }

    public static void main(String[] args) {
        ParenthesisChecker obj = new ParenthesisChecker();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String str = sc.nextLine();
            obj.check(str);
        }
    }
}
