package pract.linked_list.easy;

public class CheckPalindrome extends LinkedList {

    private Node getFirstHalfEndNode(Node head){
        Node slowP;
        Node slowP_prev = null;
        Node fastP;
        Node firstHalfEnd;
        slowP = fastP = head;
        while(fastP!=null && fastP.next!=null){
            slowP_prev = slowP;
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        if(fastP == null)
            firstHalfEnd = slowP_prev;
        else firstHalfEnd = slowP;

        return firstHalfEnd;
    }

    boolean isPalindrome(Node head) {
        boolean isPalindrom = true ;
        Node firstHalfEndPointer = getFirstHalfEndNode(head);
        Node secondHalfStartPointer = firstHalfEndPointer.next;
        Node reverseSecondHalf = reverseList(secondHalfStartPointer);
        Node temp = reverseSecondHalf;
        while(temp!=null){
            if(head.data!=temp.data){
                isPalindrom = false ;
                break;
            }
            head = head.next;
            temp = temp.next;
        }
        firstHalfEndPointer.next = reverseList(reverseSecondHalf);
        return isPalindrom;

    }

    public static void main(String[] args) {

        CheckPalindrome obj = new CheckPalindrome();
        obj.add(1);
//        obj.add(1);
//        obj.add(3);
//        obj.add(4);
//        obj.add(5);
//        obj.add(4);
//        obj.add(5);
        System.out.println(obj.isPalindrome(obj.head));
        System.out.println(">>>>>>>");
        obj.printData();

    }
}
