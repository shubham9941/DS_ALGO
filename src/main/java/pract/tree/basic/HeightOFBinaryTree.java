package pract.tree.basic;

public class HeightOFBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else return Math.max(height(root.left), height(root.right)) + 1;

    }


    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);


        n.left.left = new Node(4);
        n.left.left.left = new Node(5);
        System.out.println(height(n));
    }
}
