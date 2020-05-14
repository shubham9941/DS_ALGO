package pract.linked_list.basic;

public class DoublyList {

    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }

    void push(int new_data) {
        Node newNode = new Node(new_data);
        if (head == null)
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void deletePosition(int pos) {
        Node temp = head;
        while (pos != 1) {
            temp = temp.next;
            pos--;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void printData() {
            Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DoublyList list = new DoublyList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.printData();
        System.out.println(">>>>>");
        list.deletePosition(2);
        list.printData();

    }
}
