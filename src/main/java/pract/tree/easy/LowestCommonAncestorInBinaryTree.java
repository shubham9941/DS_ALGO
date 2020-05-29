package pract.tree.easy;

public class LowestCommonAncestorInBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return (root.data == n1 || root.data == n2) ? root : null;
        }
        if (root.left == null) {
            return (root.data == n1 || root.data == n2) ? root : lca(root.right, n1, n2);
        }
        if (root.right == null) {
            return (root.data == n1 || root.data == n2) ? root : lca(root.left, n1, n2);
        }

        Node leftRes = lca(root.left, n1, n2);
        Node rightRes = lca(root.right, n1, n2);
        if ((leftRes != null && rightRes != null) || root.data == n1 || root.data == n2) {
            return root;
        } else {
            return (leftRes != null) ? leftRes : rightRes;
        }
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);
        n.left.right = new Node(5);
//
        n.right.left = new Node(6);
        n.right.right = new Node(7);
//
        n.right.right.left = new Node(8);


        Node res = lca(n, 10, 5);
        if (res != null) {
            System.out.print(res.data);
        }

    }
}
