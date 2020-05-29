package pract.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSumInBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

     void addAllRightParts(Node node, Queue<Node> qu) {
        if (node != null) {
            qu.add(node);
            addAllRightParts(node.right, qu);
        }
    }

     void addAndPrintData(Queue<Node> qu, int size) {
        int sum = 0;
        while (size-- > 0) {
            Node first = qu.poll();
            sum += first.data;
            addAllRightParts(first.left, qu);
        }
        System.out.print(sum + " ");
        if (qu.size() > 0) {
            addAndPrintData(qu, qu.size());
        }
    }

     public void diagonalSum(Node root) {
        Queue<Node> qu = new LinkedList<>();
        addAllRightParts(root, qu);
        addAndPrintData(qu, qu.size());
    }

    public static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {

        Node n = new Node(1);

        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(9);
        n.left.right = new Node(6);

        n.right.left = new Node(4);
        n.right.right = new Node(5);

        n.left.left.right = new Node(10);
        n.left.right.left = new Node(11);


        n.right.left.left = new Node(12);
        n.right.left.right = new Node(7);

        DiagonalSumInBinaryTree tree = new DiagonalSumInBinaryTree();

        tree.diagonalSum(n);


    }
}
