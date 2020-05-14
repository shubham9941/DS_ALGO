package ds_algo_assignment.week_2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.forEach(System.out::println);

        ArrayList<Integer> ab = new ArrayList<Integer>(al);
        ab.remove(1);
        System.out.println(">>>>>");
        al.forEach(System.out::println);


    }

}
