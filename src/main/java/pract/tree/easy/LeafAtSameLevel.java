package pract.tree.easy;

public class LeafAtSameLevel {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int checkLeafs(Node n, int level) {
        if (n.left == null && n.right == null) {
            return level;
        }
        if (n.left == null) {
            return checkLeafs(n.right, level + 1);
        }
        if (n.right == null) {
            return checkLeafs(n.left, level + 1);
        }

        int left = checkLeafs(n.left, level + 1);
        int right = checkLeafs(n.right, level + 1);
        if (left != -1 && right != -1 && left == right) {
            return left;
        } else {
            return -1;
        }
    }

    static boolean check(Node root) {
        if (root != null) {
            return (checkLeafs(root , 1) != -1);
        }
        return true;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

//        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.right.left = new Node(6);
        System.out.print(check(n));
    }
}
