package pract.tree.hard;

public class NumberOfTurns {
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

    static int getTurns(Node root, int key, int turnCount, String prev_turn) {
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return turnCount;
        }
        if (prev_turn.equals("Root")) {
            int leftRes = getTurns(root.left, key, turnCount + 1, "Left");
            return (leftRes != -1) ? leftRes : getTurns(root.right, key, turnCount + 1, "Right");
        }

        if (prev_turn.equals("Left")) {
            int leftRes = getTurns(root.left, key, turnCount, "Left");
            return (leftRes != -1) ? leftRes : getTurns(root.right, key, turnCount + 1, "Right");
        }

        int leftRes = getTurns(root.left, key, turnCount + 1, "Left");
        return (leftRes != -1) ? leftRes : getTurns(root.right, key, turnCount, "Right");

    }

    static int NumberOfTurns(Node root, int first, int second) {
        Node lca = lca(root, first, second);

        int firstRes = getTurns(lca, first, -1, "Root");
        int secondRes = getTurns(lca, second, -1, "Root");
        int res = firstRes + secondRes + 1;
        if(res > 0) {
            return res ;
        }
        return -1 ;

    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.right.left = new Node(6);
        n.right.right = new Node(7);

        n.left.left.left = new Node(8);

        n.right.left.left = new Node(9);
        n.right.left.right = new Node(10);


        System.out.println(NumberOfTurns(n, 1, 6));


    }
}
