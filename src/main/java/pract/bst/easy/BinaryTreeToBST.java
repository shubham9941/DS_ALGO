package pract.bst.easy;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static void fillDataFromTree(Node n, ArrayList<Integer> al) {
        if (n != null) {
            fillDataFromTree(n.left, al);
            al.add(n.data);
            fillDataFromTree(n.right, al);
        }
    }

    static void convert(Node root, ArrayList<Integer> al) {
        if (root != null) {
            convert(root.left, al);
            root.data = al.get(0);
            al.remove(0);
            convert(root.right, al);
        }
    }

    static Node binaryTreeToBST(Node root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        fillDataFromTree(root, al);
        Collections.sort(al);
        convert(root, al);
        return root;
    }

    static void printInOrder(Node n) {
        if (n != null) {
            printInOrder(n.left);
            System.out.print(n.data + " ");
            printInOrder(n.right);
        }
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);

        printInOrder(n);
        binaryTreeToBST(n);
        System.out.println("");
        printInOrder(n);


    }
}
