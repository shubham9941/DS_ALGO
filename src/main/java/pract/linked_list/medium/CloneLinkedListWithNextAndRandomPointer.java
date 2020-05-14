package pract.linked_list.medium;


import java.util.HashMap;
import java.util.Scanner;

public class CloneLinkedListWithNextAndRandomPointer {

    Node head;

    HashMap<String, Node> map = new HashMap<String, Node>();

    static class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;

        }
    }

    Node copyList(Node head) {

        // destroying original list by adding clone into it
        Node temp = head;
        while (temp != null) {
            Node cloneNode = new Node(temp.data);
            Node tempNext = temp.next;
            temp.next = cloneNode;
            cloneNode.next = tempNext;
            temp = tempNext;
        }

        temp = head;

        // Filling Arb part first

        while(temp !=null){
            temp.next.arb = (temp.arb!=null) ? temp.arb.next : temp.arb;
            temp = temp.next.next;
        }

        Node cloneListHead = temp = head.next;

        while (head != null) {
            Node orgListNext = head.next.next;
            temp.next = (orgListNext != null) ? orgListNext.next : orgListNext;

            head.next = orgListNext; // correcting the original list
            head = orgListNext;
            temp = temp.next;
        }
        return cloneListHead;
    }

    // Optimised with trick:)))
    Node copyList2(Node head) {
        Node temp = new Node(head.data);
        temp.next = head.next;
        temp.arb = head.arb;
        return temp ;
    }

    void printList(Node head) {
        while (head != null) {
            System.out.println("Data = " + head.data);
            if (head.arb != null) {
                System.out.println("Arb data = " + head.arb.data);
            } else {
                System.out.println("Arb = null");
            }
            head = head.next;
        }
    }

    void insert(String data) {
        Node newNode = new Node(Integer.parseInt(data));

        map.put(data, newNode);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void insertArb(String here, String to) {
        System.out.println(">>>here>>>" + here);
        System.out.println(">>>to>>>" + to);
        map.get(here).arb = map.get(to);
    }

    boolean checkBothAraSame(Node orginial , Node cloned){
        System.out.println(">>>Hey i m herer");
        while(orginial!=null){
            System.out.println("org :- " + orginial.data);
            if(orginial.data == cloned.data){
                if(orginial.arb == null){
                    if(!(orginial.arb == cloned.arb)){
                        System.out.println("org arb is null but cloned arb not null");
                        return false;
                    }
                }
                else if (!(orginial.arb.data == cloned.arb.data)) {
                    System.out.println("arb data not same :- " + cloned.data);
                    return false;
                }
            } else {
                System.out.println("Data not same orginial data = " + orginial.data + "and cloned data is :- " + cloned.data);
                return false;
            }
            cloned = cloned.next;
            orginial = orginial.next;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {

        CloneLinkedListWithNextAndRandomPointer obj  = new CloneLinkedListWithNextAndRandomPointer();

        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.arb = start.next.next;

        // 2's random points to 1
        start.next.arb = start;

        // 3's and 4's random points to 5
        start.next.next.arb = start.next.next.next.next;
        start.next.next.next.arb = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.arb = start.next;

        System.out.println("Original list : ");
        obj.printList(start);

        System.out.println(">>>>>>>>>>");

        System.out.println("Cloned list : ");
        Node cloned_list = obj.copyList(start);
        obj.printList(cloned_list);

        System.out.println(">>>>>>>>>>>");

        obj.printList(start);



    }
}

