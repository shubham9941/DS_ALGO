package pract.tree.medium;

public class CheckBtreeIsBST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data > min && root.data < max) {
            return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
        }
        return false;

    }

    static boolean isBST(Node root){
        return isBST(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        Node n = new Node(50);
        n.left = new Node(35);
        n.right = new Node(65);

        n.left.left = new Node(25);
        n.left.right = new Node(36);


        System.out.print(isBST(n));

    }
}
