package pract.heap.medium;

import java.util.PriorityQueue;

public class Merge_K_sortedLikedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class NodeContainer implements Comparable<NodeContainer> {
        Node n;

        NodeContainer(Node n) {
            this.n = n;
        }

        @Override
        public int compareTo(NodeContainer o) {
            return (this.n.data - o.n.data);
        }
    }

    // Using Min heap(Priority queue approach)
    //Note:-(No extra space Required)
    // this can be done without this move array from left to right and combine list and store at i place. do this until you reached to the single element in array

    static Node mergeKList(Node[] arr, int n) {
        Node comninedList = null;
        Node root = comninedList;
        PriorityQueue<NodeContainer> qu = new PriorityQueue<>();
        for(int i = 0 ; i < n ;i ++){
            qu.add(new NodeContainer(arr[i]));
        }
        while (!qu.isEmpty()) {
            NodeContainer c = qu.poll();
            if(root == null){
                comninedList= root = c.n;
            }
            else{
                root.next = c.n;
                root = root.next;
            }
            if (c.n.next != null) {
                c.n = c.n.next;
                qu.add(c);
            }
        }

        return comninedList;

    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(5);

        Node n2 = new Node(3);
        n2.next = new Node(7);

        Node []arr = {n1,n2};

        Node list = mergeKList(arr , arr.length);
        while(list!=null){
            System.out.print(list.data + " ");
            list = list.next;
        }
    }
}
