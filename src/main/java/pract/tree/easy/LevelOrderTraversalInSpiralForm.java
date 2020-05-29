package pract.tree.easy;

import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static void printSpiral(Node node) {
        if (node != null) {
            Stack<Node> stk1 = new Stack<>(); // will process from L to R
            Stack<Node> stk2 = new Stack<>(); // will process from R to L
            stk2.push(node);
            String chance = "stk2";

            while (!stk2.isEmpty() || !stk1.isEmpty()) {
                if (chance.equals("stk2")) {
                    while (!stk2.isEmpty()) {
                        Node top = stk2.pop();
                        System.out.print(top.data + " ");
                        if (top.right != null) {
                            stk1.push(top.right);
                        }
                        if (top.left != null) {
                            stk1.push(top.left);
                        }
                    }
                    chance = "stk1";
                } else {
                    while (!stk1.isEmpty()) {
                        Node top = stk1.pop();
                        System.out.print(top.data + " ");
                        if (top.left != null) {
                            stk2.push(top.left);
                        }
                        if (top.right != null) {
                            stk2.push(top.right);
                        }
                    }
                    chance = "stk2";
                }
            }
        }
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(7);
        n.left.right = new Node(6);
//
        n.right.left = new Node(5);
        n.right.right = new Node(4);
        printSpiral(n);

    }
}
