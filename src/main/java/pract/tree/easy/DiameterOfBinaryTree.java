package pract.tree.easy;

/**
 * Given a Binary Tree, find diameter of it.
 * +The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
 * The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded
 * (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 */

public class DiameterOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int MAX_DIMETER;

    static int setDimeterByHieght(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHight = setDimeterByHieght(root.left);
        int rightHight = setDimeterByHieght(root.right);
        int currentDimeter = setDimeterByHieght(root.left) + setDimeterByHieght(root.right) + 1;
        if (currentDimeter > MAX_DIMETER) {
            MAX_DIMETER = currentDimeter;
        }
        return Math.max(leftHight, rightHight) + 1;
    }

    static int diameter(Node root) {
        MAX_DIMETER = Integer.MIN_VALUE;
        setDimeterByHieght(root);
        return MAX_DIMETER;
    }


    public static void main(String[] args) {

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);


        n.left.left = new Node(4);
        n.left.left.left = new Node(8);
        n.left.left.left.left = new Node(9);
        n.left.right = new Node(5);
        n.left.right.right = new Node(6);
        n.left.right.right.right = new Node(7);

        System.out.print(diameter(n));

    }
}
