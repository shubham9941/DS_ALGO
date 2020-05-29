package pract.tree.easy;

public class TransformToSumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int convert(Node node) {
        if (node == null) {
            return 0;
        }
        int left = convert(node.left);
        int right = convert(node.right);
        int nodeData = node.data;
        node.data = left + right;
        return (left + right + nodeData);
    }

    static void toSumTree(Node node) {
        if (node != null) {
            convert(node);
        }
    }

    static void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }


    public static void main(String[] args) {

        Node n = new Node(10);

        n.left = new Node(-2);
        n.right = new Node(6);

        n.left.left = new Node(8);
        n.left.right = new Node(-4);


        n.right.left = new Node(7);
        n.right.right = new Node(5);

        printInorder(n);
        toSumTree(n);
        System.out.println();
        printInorder(n);


    }
}
