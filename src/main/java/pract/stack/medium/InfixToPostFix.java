package pract.stack.medium;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostFix {

    HashMap<Character, Integer> priorityMp = new HashMap<Character, Integer>();

    InfixToPostFix() {
        priorityMp.put('+', 1);
        priorityMp.put('-', 1);
        priorityMp.put('*', 2);
        priorityMp.put('/', 2);
        priorityMp.put('^', 3);
    }

    boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    void pushAccordingPriority(char c, Stack<Character> stk) {
//        System.out.println("c = " + c);
        if (stk.empty() || stk.peek() == '(') {
            stk.push(c);
        } else {
            char top = stk.peek();
            if (priorityMp.get(c) > priorityMp.get(top)) {
                stk.push(c);
            } else {
                System.out.print(stk.pop() + "");
                pushAccordingPriority(c, stk);
            }
        }
    }

    void printALLUderBrackets(Stack<Character> stk) {
        if (stk.peek() != '(') {
            System.out.print(stk.pop());
            printALLUderBrackets(stk);
        }
    }

    void convert(String str) {
        Stack<Character> stk = new Stack<Character>();
        char[] arr = str.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                printALLUderBrackets(stk);
                stk.pop();

            } else if (!isOperator(c)) {
                System.out.print(c);
            } else {
                pushAccordingPriority(c, stk);
            }
        }

        while (!stk.empty()) {
            System.out.println("-----");
            System.out.print(stk.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InfixToPostFix obj = new InfixToPostFix();
        int testCases = Integer.parseInt(sc.nextLine());
        while (testCases-- > 0) {
            String str = sc.next();
            obj.convert(str);
            System.out.println();
        }


    }
}
