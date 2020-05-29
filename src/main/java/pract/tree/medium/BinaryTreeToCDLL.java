package pract.tree.medium;

public class BinaryTreeToCDLL {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node root;
    static Node prev;

    static void convert(Node n) {
        if (n != null) {
            convert(n.left);
            addNode(n);
            convert(n.right);
        }
    }

    static void addNode(Node n) {
        if (n != null) {
            if (root == null) {
                root = prev = n;
            } else {
                prev.right = n;
                n.left = prev;
                prev = prev.right;
            }
        }
    }

    static Node bTreeToClist(Node n) {
        root = prev = null;
        convert(n);
        prev.right = root;
        root.left = prev;
        return root;
    }

    static void printData(Node root){
        Node head = root;
        do {
            System.out.print(head.data + " ");
            head = head.right;
        } while (head != root);
    }

    public static void main(String[] args) {

        Node n = new Node(10);
        n.left = new Node(20);
        n.right = new Node(30);

        n.left.left = new Node(40);
        n.left.right = new Node(60);


        Node res = bTreeToClist(n);
        printData(res);
//        System.out.print(res.left.data);



    }
}
