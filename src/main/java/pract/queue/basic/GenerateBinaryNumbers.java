package pract.queue.basic;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();

        // Enqueue the first binary number
        q.add("1");

        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        generatePrintBinary(n);
    }
}
