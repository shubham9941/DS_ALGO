package pract.tree.easy;


import java.util.LinkedList;
import java.util.Queue;

public class ConvertToMirrorTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    static void printInorder(Node root){
        if(root!=null){
            printInorder(root.left);
            System.out.print(root.data+ " ");
            printInorder(root.right);
        }
    }

    //using Queue

    static void mirror(Node root) {
        Queue<Node> qu = new LinkedList<>();
        if (root != null) {
            qu.add(root);
            while (!qu.isEmpty()) {
                Node top = qu.poll();
                Node left = top.left;
                Node right = top.right;
                top.right = left;
                top.left = right;
                if (left != null) {
                    qu.add(left);
                }
                if (right != null) {
                    qu.add(right);
                }
            }
        }
    }

    // Without Queue

    Node mirror2(Node node)
    {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror2(node.left);
        Node right = mirror2(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }


    public static void main(String[] args) {
        Node n = new Node(10);
        n.left = new Node(20);
        n.right = new Node(30);

        n.left.left = new Node(40);
        n.left.right = new Node(60);
        printInorder(n);
        mirror(n);
        System.out.println();
        printInorder(n);

    }
}
