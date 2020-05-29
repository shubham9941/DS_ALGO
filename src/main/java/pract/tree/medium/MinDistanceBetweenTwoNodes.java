package pract.tree.medium;

import pract.tree.easy.LowestCommonAncestorInBinaryTree.*;

public class MinDistanceBetweenTwoNodes {
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

    static int findLevel(Node root, int level, int k) {
        if (root != null) {
            if (root.data == k) {
                return level;
            }
            int leftRes = findLevel(root.left, level + 1, k);
            return (leftRes != -1 ? leftRes : findLevel(root.right, level + 1, k));
        }
        return -1;
    }

    static int findDist(Node root, int a, int b) {
        Node LCA = lca(root, a, b);
        return findLevel(LCA, 0, a) + findLevel(LCA, 0, b);
    }


    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        System.out.print(findDist(n, 2, 3));


    }
}
