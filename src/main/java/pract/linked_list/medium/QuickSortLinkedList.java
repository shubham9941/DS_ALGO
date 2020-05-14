package pract.linked_list.medium;

public class QuickSortLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    void exchange(Node head1, Node head2) {
//        System.out.println("---exchange head1 = " + head1.data);
//        System.out.println("---exchange head2 = " + head2.data);
        int temp = head1.data;
        head1.data = head2.data;
        head2.data = temp;
    }

    Node getPivotPrevious(Node j, Node r) {
        Node head = j;
//        System.out.println("J data - " + j.data);
//        System.out.println("R data - " + r.data);
        Node i = null;
        while (j != null && r != null && j != r) {
            if (j.data < r.data) {
                i = (i == null) ? head : i.next;
//                System.out.println(">>>>>>>>j>>>>>> " + j.data);
//                System.out.println(">>>>>>>>i>>>>>> " + i.data);
                exchange(i, j);
            }
            j = j.next;
        }
        Node prev = (i == null) ? head : i;
        i = (i == null) ? head : i.next;
        exchange(i, r);
        return prev;
    }

    void sort(Node l, Node r) {
        if (l != null && r != null && l != r) {
            Node pivot_prev = getPivotPrevious(l, r);
            Node pivot = (pivot_prev == l) ? pivot_prev : pivot_prev.next;
            Node pivot_next = pivot.next;

            if (pivot == l) {
                sort(pivot_next, r);
            } else if (pivot == r) {
                sort(l, pivot_prev);
            } else {
                sort(l, pivot_prev);
                sort(pivot_next, r);
            }
        }

    }

    public static void main(String[] args) {
        QuickSortLinkedList obj = new QuickSortLinkedList();
        Node n = new Node(30);
//        n.next = new Node(3);
//        n.next.next = new Node(4);
//        n.next.next.next = new Node(20);
//        n.next.next.next.next = new Node(5);
        obj.sort(n, n);
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

}
