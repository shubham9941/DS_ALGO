package pract.linked_list.easy;

public class DetectLoop extends LinkedList {

    int detectAndRemoveLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("Yes Loop is there, time to remove");
                System.out.println("F  = " + fast.data);
                System.out.println("S  = " + slow.data);

                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                System.out.println("Loop detected at data " + fast.data);
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        DetectLoop obj = new DetectLoop();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        obj.add(node1);
        obj.add(node2);
        obj.add(node3);
        obj.add(node4);
        obj.add(node5);
        obj.add(node3);
        obj.detectAndRemoveLoop(obj.head);
        obj.printData();
    }
}
