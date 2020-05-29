package pract.tree.easy;

public class TwoMirrorTrees {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static boolean areMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {
            return ((node1.data == node2.data) && areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left));
        }
        return false;

    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);

        Node n2 = new Node(1);
        n2.left = new Node(3);
        n2.right = new Node(2);

        System.out.print(areMirror(n1, n2));

    }
}
