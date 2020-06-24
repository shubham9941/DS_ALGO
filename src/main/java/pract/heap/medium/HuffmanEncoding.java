package pract.heap.medium;

import pract.Reader;

import java.util.PriorityQueue;

public class HuffmanEncoding {

    static class Node implements Comparable<Node> {
        char data;
        int freq;
        Node left;
        Node right;

        Node(char data, int freq) {
            this.data = data;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node o) {
            if(this.freq < o.freq){
                return -1;
            }
            return 1;
        }
    }

    static Node buildTree(String str, int[] freq, int n) {
        Node root = null;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Node(str.charAt(i), freq[i]));
        }
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('$', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            root = newNode;
            pq.add(newNode);

        }

        return root;
    }

    static void printByInOrder(Node root, String str) {
        if (root != null) {
            printByInOrder(root.left , str+'0');
            if(root.data!='$'){
                System.out.print(str + " ");
            }
            printByInOrder(root.right , str+'1');
        }
    }

    public static void main(String[] args) throws Exception {


        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            String str = sc.readLine();
            int size = str.length();
            int[] freq = new int[size];
            for (int i = 0; i < size; i++) {
                freq[i] = sc.nextInt();
            }

            printByInOrder( buildTree(str, freq, size), "");

        }
    }
}
