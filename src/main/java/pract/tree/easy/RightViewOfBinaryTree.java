package pract.tree.easy;

/**
 * Note:- This prob can be solved using Queue(Level order traversal and print last value of queue)(solve it by your own)
 * <p>
 * Using recursive approach: -
 * Here we are using recursive approach where  -
 * we will traverse the tree first from right side then left side by passing each level
 * we will keep track of max right level that has been seen.
 * if we found any level which is in left part and value of its level is grater then max level value will print that one and update max
 */

public class RightViewOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int right_max_level ;

    static void printRightView(Node node, int level) {
        if (node != null) {
            if (level > right_max_level) {
                System.out.print(node.data + " ");
                right_max_level = level;
            }
            printRightView(node.right, level + 1);
            printRightView(node.left, level + 1);
        }
    }

    static void rightView(Node node) {
        right_max_level =  Integer.MIN_VALUE;
        printRightView(node, 0);
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);
        n.left.right = new Node(5);

        n.left.right.left = new Node(6);

        rightView(n);

    }
}
