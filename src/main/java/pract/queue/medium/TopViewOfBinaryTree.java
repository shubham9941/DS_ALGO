package pract.queue.medium;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * 1
 * / \
 * 2   3
 * / \ / \
 * 4  5 6  7
 * <p>
 * Top view will be: 4 2 1 3 7
 */

public class TopViewOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }


    static void topView(Node root) {
        class QueueData {
            Node node;
            int hd;

            QueueData(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        if (root == null) {
            return;
        } else {
            Queue<QueueData> qu = new LinkedList<QueueData>();
            TreeMap<Integer, Node> mp = new TreeMap<Integer, Node>();
            qu.add(new QueueData(root, 0));

            while (!qu.isEmpty()) {
                QueueData first = qu.poll();
                if (!mp.containsKey(first.hd)) {
                    mp.put(first.hd, first.node);
                }
                if (first.node.left != null) {
                    QueueData left = new QueueData(first.node.left, first.hd - 1);
                    qu.add(left);
                }
                if (first.node.right != null) {
                    QueueData right = new QueueData(first.node.right, first.hd + 1);
                    qu.add(right);
                }
            }


            mp.values().forEach(x -> System.out.print(x.data + " "));
        }

    }

    public static void main(String[] args) {
//
//        String s = "shubham";
//        System.out.println(s.indexOf(" "));
//        System.out.print(s.substring(0,s.indexOf(" ")));

        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);


        n.left.right = new Node(4);
        n.left.right.right = new Node(5);
        n.left.right.right.right = new Node(6);
        n.left.right.right.right.right = new Node(7);

//
//        n.left.right = new Node(4);
//        n.left.right.right = new Node(5);
//        n.left.right.right.right = new Node(6);
//        n.left.right.right.right.right = new Node(7);

        topView(n);

    }
}
