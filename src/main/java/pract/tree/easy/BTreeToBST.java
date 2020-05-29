package pract.tree.easy;

import java.util.Arrays;

public class BTreeToBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int i = 0;

    static int countNodes(Node root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //  Note:- Instead of using this method you can direct traverse the main tree preOrder and start filling the data
    static Node convertToBST(Node root, int[] arr, int l, int r) {
        if (root == null) {
            return null;
        }
        int index = countNodes(root.left);
        root.data = arr[l + index];
        root.left = convertToBST(root.left, arr, l, index - 1);
        root.right = convertToBST(root.right, arr, index + 1, r);
        return root;
    }

    static int fillByInorder(Node n, int[] arr) {
        if (n != null) {
            fillByInorder(n.left, arr);
            arr[i] = n.data;
            i++;
            fillByInorder(n.right, arr);
        }
        return i;
    }

    static Node binaryTreeToBST(Node root) {

        int totalNodes = countNodes(root);
        int[] arr = new int[totalNodes];
        i = 0;
        fillByInorder(root, arr);
        Arrays.sort(arr);
        convertToBST(root, arr, 0, totalNodes - 1);
        return root;
    }

    static void printInOrder(Node node) {
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

        n.left.left = new Node(4);
//        n.left.right = new Node(5);

//        int nodes = countNodes(n);
//        System.out.print("Total nodes :  " + nodes);
//
//        int[]arr = new int[nodes];
//
//        fillByInorder(n , arr);

        printInOrder(binaryTreeToBST(n));


    }
}
