package pract.interview_questions;

public class LCAInBinaryTree {
    static class Node {
        Node left;
        Node right;
        int v;

        Node(int v) {
            this.v = v;
        }
    }

    static int lca = -1;

    static int findLCA(Node n, int first, int second) {
        if (n == null) {
            return -1;
        }

        if(n.v == first || n.v == second){
            System.out.println(">>>>> ");
            System.out.println("n.v = " + n.v);
            return n.v;
        }

        if (lca != -1) {
            return lca;
        }

        int left = findLCA(n.left, first, second);
        int right = findLCA(n.right, first, second);

        System.out.println("left = " + left);
        System.out.println("right = " + right);

        if (left != -1 && right != -1) {
//            lca = n.v;
            return n.v;
        }
        else if (left != -1) return left;
        else if (right != -1) return right;
        else return -1;

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + findLCA(root, 4, 5));


    }
}
