package pract.tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftMostAndRightMostNodesOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void printAndAddToQueue(Node n, Queue<Node> qu) {
        System.out.print(n.data + " ");
        if (n.left != null) {
            qu.add(n.left);
        }
        if (n.right != null) {
            qu.add(n.right);
        }
    }


    public static void printCorner(Node node) {
        LinkedList<Node> qu = new LinkedList<Node>();
        qu.add(node);
        while (!qu.isEmpty()) {
            int size = qu.size();
            if (size == 1) {
                printAndAddToQueue(qu.poll(), qu);
            } else {
                Node first = qu.getFirst();
                Node last = qu.getLast();
                qu = new LinkedList<>();
                printAndAddToQueue(first, qu);
                printAndAddToQueue(last, qu);
            }
        }
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

//        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.right.left = new Node(6);
        n.right.right = new Node(7);
        printCorner(n);

    }
}
