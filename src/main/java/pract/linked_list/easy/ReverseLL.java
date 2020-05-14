package pract.linked_list.easy;


class ReverseLL
{
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head ;
        Node  next ;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node reverseInGP(Node node, int k){
        Node head = node;
        Node res = null;
        int r = k-1;
        if(node == null)
            return null;
        else{
            while(node!=null && r > 0){
                r--;
                node = node.next;
            }
            Node restPart = (node !=null) ? node.next : null;
            if(node!=null){
                node.next = null;
            }
            res  = reverseList(head);
            head.next = reverseInGP(restPart , k) ;
        }
        return res;
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(6);
        n.next.next.next.next.next.next = new Node(7);
        n.next.next.next.next.next.next.next = new Node(8);

        ReverseLL obj = new ReverseLL();
        Node res = obj.reverseInGP(n , 3);
        if(res == null){
            System.out.println("Yes res is null");
        }
        while(res!=null){
            System.out.println(res.data);
            res = res.next;
        }

    }
}