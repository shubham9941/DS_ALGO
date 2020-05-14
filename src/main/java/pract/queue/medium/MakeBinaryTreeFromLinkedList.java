package pract.queue.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MakeBinaryTreeFromLinkedList {
    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Tree convert(Node head, Tree node) {
        Queue<Tree> q = new LinkedList<Tree>();
        if (head != null) {
            Tree root = new Tree(head.data);
            node = root;
            q.add(root);
        }
        while (head != null && head.next != null && !q.isEmpty()) {
            Tree top = q.poll();
            Tree left = new Tree(head.next.data);
            Tree right = (head.next.next != null) ? new Tree(head.next.next.data) : null;
            top.left = left;
            top.right = right;
            q.add(left);
            q.add(right);
            head = head.next.next;
        }
        return node;
    }

    public static void printByLevel(Tree root) {
        Queue<Tree> q = new LinkedList<Tree>();
        if (root != null) {
            System.out.println(root.data);
            if (root.left != null)
                q.add(root.left);
            if (root.right != null)
                q.add(root.right);

        }
        while (!q.isEmpty()) {
            Tree first = q.poll();
            System.out.println(first.data);
            if (first.left != null)
                q.add(first.left);
            if (first.right != null)
                q.add(first.right);
        }
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(6);

        Tree root = convert(n, null);
        printByLevel(root);


    }
}
