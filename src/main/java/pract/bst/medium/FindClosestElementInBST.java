package pract.bst.medium;

public class FindClosestElementInBST {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static int MAX_DIFF;

    static void getMaxDiff(Node root, int k) { // use efficient way for traversing the using key like BST
        if (root != null) {
            getMaxDiff(root.left, k);
            int currentDiff = Math.abs(root.data - k);
            if (currentDiff < MAX_DIFF) {
                MAX_DIFF = currentDiff;
                getMaxDiff(root.right, k);
            } else {
                return;
            }
        }
    }

    static int maxDiff(Node root, int K) {
        MAX_DIFF = Integer.MAX_VALUE;
        getMaxDiff(root , K);
        return MAX_DIFF;
    }

    public static void main(String[] args) {

        Node n = new Node(10);
        n.left = new Node(2);
        n.right = new Node(11);

        n.left.left = new Node(1);
        n.left.right = new Node(5);

        n.left.right.left = new Node(3);
        n.left.right.right = new Node(6);

        n.left.right.left.right = new Node(4);

        System.out.print(maxDiff(n, 6));

    }
}
