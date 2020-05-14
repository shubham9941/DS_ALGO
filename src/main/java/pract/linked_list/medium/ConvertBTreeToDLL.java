package pract.linked_list.medium;

import java.util.Date;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class ConvertBTreeToDLL {
    Node root;
    Node head;
    static Node previous;


    void convertToDLL(Node root) {
        if (root == null) {
            return;
        }
        convertToDLL(root.left);

        if (previous == null) {
            previous = head = root;
        } else {
            previous.right = root;
            root.left = previous;
            previous = previous.right;
        }
        convertToDLL(root.right);

    }

    void convertToDLLaAndRemoveLeaves(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        convertToDLLaAndRemoveLeaves(root.left);
        Node rootRight = root.right;
        root.left = null;
        root.right = null;

        if (previous == null) {
            previous = head = root;
        } else {
            previous.right = root;
            root.left = previous;
            previous = previous.right;
        }
        convertToDLLaAndRemoveLeaves(rootRight);

    }

    //convert BTree to CircularDoublyLinkedList

    void convertToCDLL(Node root) {
        Node rootRight = null;
        if (root == null || root == head) {
            return;
        }
        convertToCDLL(root.left);
        rootRight = root.right;

        if (previous == null) {
            System.out.println("Hey i m here.. " + root.data);
            previous = head = root;
            previous.right = root;
            previous.left = root;

        } else {
            System.out.println("else.... " + root.data);
            previous.right = root;
            root.left = previous;

            root.right = head;
            head.left = root;
            previous = previous.right;
        }

        convertToCDLL(rootRight);

    }

    Node bTreeToClist(Node root) {
//        if(root == null)
//            return null;
        convertToCDLL(root);
        return head;
    }

    void printDLL(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.right;
        }
    }

    void printCDLL(Node head) {
        Node temp = head;
        do {
            System.out.println(temp.data);
            temp = temp.right;
        } while (temp != head);
    }

    void printInOrder(Node node){
        if(node == null)
            return;
        printDLL(node.left);
        System.out.println(node.data);
        printDLL(node.right);
    }

    public static void main(String[] args) {

        ConvertBTreeToDLL tree = new ConvertBTreeToDLL();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//
//
//        tree.root.right.left = new Node(6);
//        tree.root.right.right = null;


//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(2);
//
//        tree.root.right.left = new Node(3);
//        tree.root.right.right = new Node(1);
//
//        tree.root.left.left.left = null;
//        tree.root.left.left.right = new Node(3);
//
//        tree.root.left.right.left = new Node(1);
//        tree.root.left.right.right = new Node(5);


//        tree.convertToDLL(tree.root);
//        tree.printDLL(tree.head);
        tree.convertToDLLaAndRemoveLeaves(tree.root);
//        tree.printDLL(tree.head);
        tree.printInOrder(tree.root);

        new Date(111L);


    }
}
