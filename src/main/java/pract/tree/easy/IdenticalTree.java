package pract.tree.easy;

public class IdenticalTree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && (root1.data == root2.data)) {
            return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
        }
        return false;
    }

    public static void main(String[] args) {
        IdenticalTree tree = new IdenticalTree();
        Node n1 = new Node(1);
        Node n2 = new Node(1);

        n1.left = new Node(2);
        n2.left = new Node(2);

        n1.right = new Node(4);
        n2.right = new Node(3);
        System.out.print(tree.isIdentical(n1,n2));

    }
}
