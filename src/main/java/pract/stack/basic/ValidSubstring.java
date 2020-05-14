package pract.stack.basic;

import java.util.Stack;

public class ValidSubstring {

    Stack<Character> st = new Stack<Character>();

    void getValidate(String str) {
        int count = 0 ;
        for (char c : str.toCharArray()) {
            if (Character.compare(c, '(') == 0) {
              st.push(c);
            } else {
                if(!st.isEmpty()){
                    char poped = st.pop();
//                    if(Character.compare(poped, ))
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

    }
}
