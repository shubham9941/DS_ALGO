package pract.tree.hard;

import java.util.ArrayList;

public class NodesAtGivenDistanceInBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static ArrayList<Integer> l  = new ArrayList<>();

    static class NodeInfo {
        int processedElement;
        int d;

        NodeInfo(int processedElement, int d) {
            this.processedElement = processedElement;
            this.d = d;
        }
    }

    static void printDistanceNodeFromRoot(Node root, int d) {
        if (root != null && d >= 0) {
            if (d == 0) {
                l.add(root.data);
//                System.out.print(root.data + " ");
            }
            printDistanceNodeFromRoot(root.left, d - 1);
            printDistanceNodeFromRoot(root.right, d - 1);
        }
    }

    static void processElement(Node root, int d, int processElement) {
        if (root != null) {
            if (d == 0) {
                l.add(root.data);
//                System.out.print(root.data);
            }
            if (root.left != null && root.left.data == processElement) {
                printDistanceNodeFromRoot(root.right, d - 1);
            }
            if (root.right != null && root.right.data == processElement) {
                printDistanceNodeFromRoot(root.left, d - 1);
            }
        }
    }

    static NodeInfo printKthDistance(Node root, int d, int k) {
        if (root == null) {
            return null;
        }
        if (root.data == k) {
            printDistanceNodeFromRoot(root, d);
            return new NodeInfo(root.data, d);
        }
        NodeInfo left = printKthDistance(root.left, d, k);
        if (left != null) {
            processElement(root, left.d - 1, left.processedElement);
            return new NodeInfo(root.data, left.d - 1);
        }

        NodeInfo right = printKthDistance(root.right, d, k);
        if (right != null) {
            processElement(root, right.d - 1, right.processedElement);
            return new NodeInfo(root.data, right.d - 1);
        }
        return null;
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k) {
        l = new ArrayList<Integer>();
        printKthDistance(root, k, target);
        return l;

    }

    public static void main(String[] args) {

        Node n = new Node(20);
        n.left = new Node(8);
        n.right = new Node(22);

        n.left.left = new Node(4);
        n.left.right = new Node(12);

        n.left.right.left = new Node(10);
        n.left.right.right = new Node(14);


        System.out.print(KDistanceNodes(n , 8 , 2));


    }
}
