package pract.tree.easy;

public class SumOfLeftLeafNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int LEFT_LEAVE_SUM = 0;

    static void getSum(Node node) {
        if (node != null) {
            if (node.left != null && node.left.left == null && node.left.right == null) {
                LEFT_LEAVE_SUM += node.left.data;
            }
            getSum(node.left);
            getSum(node.right);
        }
    }

    static int leftLeavesSum(Node root) {
        LEFT_LEAVE_SUM = 0;
        getSum(root);
        return LEFT_LEAVE_SUM;
    }

    public static void main(String[] args) {

        Node n = new Node(10);
        n.left = new Node(20);
        n.right = new Node(30);

        n.left.left = new Node(40);
        n.left.right = new Node(60);

        n.right.left = new Node(90);

        System.out.print(leftLeavesSum(n));

    }
}
