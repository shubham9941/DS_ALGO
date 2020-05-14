package pract.stack.basic;

import pract.Reader;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given a postfix expression, the task is to evaluate the expression and print the final value. Operators will only include the basic arithmetic operators like *,/,+ and - .
 * <p>
 * Input:
 * The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an postfix expression.
 * <p>
 * Output:
 * For each test case, in a new line, evaluate the postfix expression and print the value.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= length of expression <= 100
 * <p>
 * Example:
 * Input:
 * 2
 * 231*+9-
 * 123+*8-
 * Output:
 * -4
 * -3
 */

public class PostfixExpression {

    int calCulate(int num1, int num2, char opr) {
        switch (opr) {
            case '+':
                return (num1 + num2);
            case '-':
                return (num1 - num2);
            case '*':
                return (num1 * num2);
            case '/':
                return (num1 / num2);
            default:
                throw new RuntimeException("Not found");
        }
    }

    void print(String str) {
        Stack<Integer> operand = new Stack<Integer>();
        for (char i : str.toCharArray()) {
            if (i == '+' || i == '-' || i == '*' || i == '/') {
                int num2 = operand.pop();
                int num1 = operand.pop();
                operand.push(calCulate(num1,num2, i));
            }
            else {
                operand.push(Character.getNumericValue(i));
            }
        }
        System.out.println(operand.pop());
    }

    public static void main(String[] args) throws Exception {

        PostfixExpression obj = new PostfixExpression();
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        while (testCases-- > 0) {
            String line = sc.nextLine();
            obj.print(line);
        }
    }
}
