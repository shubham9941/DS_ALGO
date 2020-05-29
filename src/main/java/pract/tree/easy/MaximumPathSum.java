package pract.tree.easy;

/*
Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.

*/

public class MaximumPathSum {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int MAX_PATH;

    static int calculateMaxPath(Node root) {
        if (root.left == null && root.right == null) return root.data;
        if (root.left == null) return calculateMaxPath(root.right) + root.data;
        if (root.right == null) return calculateMaxPath(root.left) + root.data;
        int left = calculateMaxPath(root.left);
        int right = calculateMaxPath(root.right);
        int total = left + right + root.data;
        if (total > MAX_PATH) {
            MAX_PATH = total;
        }
        return (left > right ? left : right) + root.data;

    }

    public static int maxPathSum(Node root) {
        if (root != null) {
            MAX_PATH = Integer.MIN_VALUE;
            calculateMaxPath(root);
            return MAX_PATH;
        }
        return 0;
    }

    public static void main(String[] args) {

        Node n = new Node(-9);
        n.left = new Node(6);
        n.right = new Node(-10);

//        n.left.left = new Node(-10);
//        n.left.right = new Node(4);

        System.out.print(maxPathSum(n));


    }
}
