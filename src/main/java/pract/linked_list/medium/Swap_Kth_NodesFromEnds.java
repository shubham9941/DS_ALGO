package pract.linked_list.medium;

public class Swap_Kth_NodesFromEnds {

    static class Node {
        Node next ;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    static void swap(Node first , Node last){
        if(first == last)
            return;
        Node last_next = last.next;
        last.next = first.next;
        Node first_next = first.next;
        first.next = null;
        while(first_next.next!=last){
            first_next = first_next.next;
        }
        first_next.next = first;
        first.next = last_next;
    }

    int getSize(Node node){
        int size = 0 ;
        while (node!=null){
            size++;
            node = node.next;
        }
        return size;
    }

    static Node swapkthnode(Node head, int size, int k)
    {
        Node starting = head;
        Node prev_first = null;
        Node first = null;
        Node last = null;
        int lastPoint = (size - k) + 1 ;
        int i = 1 ;
        while(i!= lastPoint){
            if(i == k-1){
                prev_first = head;

            }
            if(i == k){
                first = head;
            }

            i++;
            head = head.next;
        }
        first = (first!=null) ? first : head;
        last = head;
        swap(first,last);

        if(k == 1){
            return last;
        }
        else {
            prev_first.next = last;
            return starting;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
//        node.next.next.next = new Node(4);
//        node.next.next.next.next = new Node(5);
//        node.next.next.next.next.next = new Node(6);
//        node.next.next.next.next.next.next = new Node(7);
//        node.next.next.next.next.next.next.next = new Node(8);

//        Node last =  node.next.next.next.next;
//        swap(node,    last);

        Node n = swapkthnode(node, 3, 4);

        while(n!=null){
            System.out.println(n.data);
            n = n.next;
        }

    }
}
