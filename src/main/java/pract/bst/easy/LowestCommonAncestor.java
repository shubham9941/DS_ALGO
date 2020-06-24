package pract.bst.easy;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (n1 < root.data && n2 < root.data) {
            return lca(root.left, n1, n2);
        }
        if (n2 > root.data && n2 > root.data) {
            return lca(root.right, n1, n1);
        }
        return root;
    }
}
