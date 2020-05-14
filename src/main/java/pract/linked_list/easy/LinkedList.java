package pract.linked_list.easy;

import java.util.Scanner;

public class LinkedList {
    Node head;
    private int size;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }

    private void merge(int l, int m, int r, Node list) {
        System.out.println("Hey i m here>>> l = " + l + "r = " + r);
        int p = l;
        while (p != 1) {
            list = list.next;
            p--;
        }
        Node temp = list;
        LinkedList leftList = new LinkedList();
        LinkedList rightList = new LinkedList();
        while (l <= m) {
            leftList.add(temp.data);
            l++;
            temp = temp.next;
        }
        m++;
        while (m <= r) {
            rightList.add(temp.data);
            m++;
            temp = temp.next;
        }

        while (leftList.head != null && rightList.head != null) {
            if (leftList.head.data < rightList.head.data) {
                list.data = leftList.head.data;
                list = list.next;
                leftList.head = leftList.head.next;
            } else {
                list.data = rightList.head.data;
                list = list.next;
                rightList.head = rightList.head.next;
            }
        }

        while (leftList.head != null) {
            list.data = leftList.head.data;
            list = list.next;
            leftList.head = leftList.head.next;
        }


        while (rightList.head != null) {
            list.data = rightList.head.data;
            list = list.next;
            rightList.head = rightList.head.next;
        }
    }

    private void sortList(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortList(l, m);
            sortList(m + 1, r);
            merge(l, m, r, head);
        }

    }

    void add(int new_data) {
        size++;
        Node newNode = new Node(new_data);
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

    void add(Node newNode) {
        size++;
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

    Node getMiddle(){
        Node slowP;
        Node fastP;
        slowP = fastP = head;
        while(fastP!=null && fastP.next!=null){
            fastP = fastP.next.next;
            slowP = slowP.next;
        }
        return slowP;
    }

    void printData() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    Node updateFromLargestPos(int largestElementPos, Node list) {
        System.out.println("---largestElementPos---- " + largestElementPos);
        Node temp = list;
        int pos = largestElementPos - 1;
        if (pos == 0) {
            Node newNode = new Node(1);
            newNode.next = temp;
            list = newNode;
        } else {
            while (pos != 1) {
                temp = temp.next;
                pos--;
            }
            temp.data = temp.data + 1;
            temp = temp.next;
            while (temp != null) {
                temp.data = 0;
                temp = temp.next;
            }
        }
        return list;
    }

    Node addOneNumber(Node list) {
        Node temp = list;
        int firstLargestElement = 0;
        int pos = 0;
        while (temp.next != null) {
            pos++;
            if (temp.data != 9) {
                firstLargestElement = 0;
            } else if (firstLargestElement == 0) {
                firstLargestElement = pos;
            }
            temp = temp.next;
        }
        if (temp.data < 9) {
            temp.data += 1;
        } else {
            firstLargestElement = (firstLargestElement != 0 ? firstLargestElement : pos + 1);
            list = updateFromLargestPos(firstLargestElement, list);
            // update all position ;
        }
        return list;
    }

    void sort() {
        int count = 0;
        sortList(1, size);
    }

    void deleteNode(int data) {
        Node temp = head;
        Node prev = null;
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
            if(temp == null){
                throw new RuntimeException("Element not found");
            }
        }
        if(prev == null){
            head = head.next;
        }
        else {
            prev.next = prev.next.next;
        }

    }

    Node reverseList(Node node){
        Node prev = null;
        Node current = node ;
        Node  next ;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    void zigzag(Node head){
        Node tempNode =  head;

        while(tempNode!=null && tempNode.next!=null){
            Node prev = tempNode;
            Node current = tempNode.next;
            if(prev.data > current.data){
                int temp = prev.data;
                prev.data = current.data;
                current.data = temp;
            }
            if((current.next!=null && current.data < current.next.data)){
                int temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;
            }
            tempNode = tempNode.next.next;

        }

        StringBuilder sb = new StringBuilder();

        while(head!=null){
            sb.append(head.data + " ");
            head = head.next;
        }
        System.out.println(sb);
    }

    void printNthFromLast(int n)
    {
        Node main_ptr = head;
        Node ref_ptr = head;

        int count = 0;
        if (head != null) {
            while (count < n) {
                if (ref_ptr == null) {
                    System.out.println(n + " is greater than the no "
                            + " of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
            while (ref_ptr != null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no. " + n + " from last is " + main_ptr.data);
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases -- > 0) {
            LinkedList list = new LinkedList();
            int size = sc.nextInt();
            for(int i = 0 ; i < size ;i ++){
                list.add(sc.nextInt());
            }
            System.out.println(list.getMiddle().data);

//            list.zigzag(list.head);
        }

    }
}


