package pract.linked_list;

import java.util.Comparator;
import java.util.TreeMap;

class MyComporator implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {

        if(o1 instanceof Integer && o2 instanceof Integer){
            System.out.println("Hey i am Interger");
            return ((int) o1 - (int) o2) ;
        }
        else if(o1 instanceof String && o2 instanceof String){
            return (((String) o1).compareTo((String)o2)) ;
        }



        return 0;
    }
}

public class Test {
    void abc(){
        TreeMap<Object, String> tree_map = new TreeMap<Object, String>(new MyComporator());

        // Mapping string values to int keys
        tree_map.put(2, "q");
        tree_map.put(1, "p");
        System.out.println(tree_map);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.abc();
    }
}
