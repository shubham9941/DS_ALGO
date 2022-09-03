package pract.interview_questions;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;

public class DigonalSumTree {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static void findSum(Node root) {
        if (root == null) {
            System.out.println(0);
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sum = 0;
            int size = q.size();
            while (size-- > 0) {
                Node top = q.poll();
                while (top != null) {
                    sum += top.data;
                    if (top.left != null) {
                        q.add(top.left);
                    }
                    top = top.right;
                }
            }
            System.out.println(sum);
        }

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(9);
        root.left.right = new Node(6);

        root.left.left.right = new Node(10);
        root.left.right.left = new Node(11);

        root.right.right = new Node(5);
        root.right.left = new Node(4);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(7);

        findSum(root);


    }
}
