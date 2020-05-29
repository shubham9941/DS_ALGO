package pract.tree.easy;

public class RemoveHalfNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node removeHalfNodes(Node root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null)
            return root;
        else if (root.left == null) {
            return removeHalfNodes(root.right);
        } else if (root.right == null) {
            return removeHalfNodes(root.left);
        } else {
            root.left = removeHalfNodes(root.left);
            root.right = removeHalfNodes(root.right);
            return root;
        }
    }

    public static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        Node n = new Node(2);
        n.left = new Node(7);
        n.right = new Node(5);

        n.left.right = new Node(6);

        n.left.right.left = new Node(8);
        n.left.right.right = new Node(11);new Node(5);


        n.right.right = new Node(9);
        n.right.right.left = new Node(4);

        printInOrder(n);
        removeHalfNodes(n);
        System.out.println();
        printInOrder(n);

    }
}
