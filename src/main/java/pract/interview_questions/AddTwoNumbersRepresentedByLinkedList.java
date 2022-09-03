package pract.interview_questions;

public class AddTwoNumbersRepresentedByLinkedList {

    static class Node {
        int v;
        Node next;

        Node(int v) {
            this.v = v;
        }
    }

    static Node reverse(Node root) {
        Node prev = root;
        Node current = prev.next;

        prev.next = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static void printList(Node root) {
        while (root != null) {
            System.out.print(root.v + " ");
            root = root.next;
        }
    }


    static Node findSum(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
//        printList(first);
//        printList(second);
        int sum = 0;
        int carry = 0;
        Node res = null;
        Node resP = res;
        while (first != null && second != null) {
            sum = first.v + second.v + carry;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            if (res == null) {
                resP = res = newNode;
            } else {
                resP.next = newNode;
                resP = resP.next;
            }
            first = first.next;
            second = second.next;

        }

        while (first != null) {
            sum = first.v + carry;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            if (resP == null) {
                resP = res = newNode;
            } else {
                resP.next = newNode;
                resP = resP.next;
            }
            first = first.next;
        }

        while (second != null) {
            sum = second.v + carry;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            if (resP == null) {
                resP = res = newNode;
            } else {
                resP.next = newNode;
                resP = resP.next;
            }
            second = second.next;
        }

        if (carry != 0) {
            resP.next = new Node(carry);
            resP = resP.next;
        }

//        if(res == null){
//            System.out.println("-----");
//        }
//        printList(res);

        return reverse(res);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);

        Node n2 = new Node(4);
        n2.next = new Node(5);
        n2.next.next = new Node(6);
        n2.next.next.next = new Node(7);

       printList(findSum(n1,n2));




    }
}
