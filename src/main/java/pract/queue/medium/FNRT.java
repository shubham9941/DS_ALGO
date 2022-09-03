package pract.queue.medium;

// copy of FirstNonRepeatingCharacter but O(1)

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FNRT {
    LinkedHashSet<Character> lhs ;
    HashSet<Character> hs ;
    FNRT(){
        lhs = new LinkedHashSet<>();
        hs = new HashSet<>();

    }

    void add(char c ){
        if(!hs.contains(c)){
            hs.add(c);
            lhs.add(c);
        }
        else{
            lhs.remove(c);
        }
    }

    void printFirst(){
        if(lhs.isEmpty()){
            System.out.println(-1 + " ");
        }
        else{
            System.out.println(lhs.iterator().next());
        }
    }
    public static void main(String[] args) {
        FNRT obj  = new FNRT();
        obj.add('a');
        obj.printFirst();
        obj.add('a');
        obj.printFirst();
        obj.add('c');
        obj.printFirst();
//        obj.add('c');
//        obj.printFirst();


    }
}
