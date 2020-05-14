package pract.linked_list.hard;


public class ReorderList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node reverseList(Node head) {
        Node prev = null;
        Node current = head ;
        Node next ;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node getMiddle(Node head) {
        Node prev_slow_pointer = null;
        Node slow_pointer = head;
        Node fast_pointer = head;

        while (fast_pointer != null && fast_pointer.next != null) {
            fast_pointer = fast_pointer.next.next;
            prev_slow_pointer = slow_pointer;
            slow_pointer = slow_pointer.next;
        }
        if(fast_pointer == null){
            slow_pointer = prev_slow_pointer;
        }
        return slow_pointer;
    }

    Node reorderlist(Node head) {
        Node firstPart = head;
        Node middle = getMiddle(head);
        Node lastPart = middle.next;
        middle.next = null;
        lastPart = reverseList(lastPart);

        while(firstPart!=null && lastPart!=null){
            Node temp = firstPart.next;
            firstPart.next = lastPart;
            lastPart = lastPart.next;
            firstPart.next.next = temp;
            firstPart = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        ReorderList obj = new ReorderList();
        Node n = obj.reorderlist(node);
        while (n!=null){
            System.out.println(n.data);
            n =n.next;
        }

    }
}
