package pract.linked_list.medium;

public class PolynomialAddition {
    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    public  Node add(Node p1 , Node p2){
        if(p1 == null)
            return p2;
        if(p2 == null)
            return p1;

        Node res = null;

        if(p1.pow > p2.pow){
            System.out.println("Hey 1");
            res = p1;
            res.next = add(p1.next , p2);
        }
        else if(p2.pow > p1.pow){
            System.out.println("Hey 2");
            res = p2;
            System.out.println("Res cof =  " + res.coeff + " pow = " + res.pow);
            res.next = add(p1,p2.next);
            return res ;
//            Node t = res;

//            while(t!=null){
//                System.out.println("t -> Coff = " + t.coeff);
//                System.out.println("t -> pow = " + t.pow);
//                t= t.next;
//            }


        }
        else {
            System.out.println("Hey 3");
            res = p1;
            res.coeff = p1.coeff + p2.coeff ;
            res.next = add(p1.next, p2.next);
        }
        return res ;

    }

    public static void main(String[] args) {
        Node p1 = new Node(1, 2);
        Node p2 = new Node(1,3);

        Node n =  (new PolynomialAddition()).add(p1,p2);
        while(n!=null){
            System.out.println("P1 -> Coff = " + p1.coeff);
            System.out.println("P1 -> pow = " + p1.pow);
            n= n.next;
        }
    }




}
