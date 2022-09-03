package pract.array.medium;

import pract.Reader;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class SmallestDistinctWindow {

    static void removeAllNotUsefullChar(String str, LinkedHashMap<Character, Integer> mp, int start, int end) {
        for (int i = start; i < end; i++) {
            mp.remove(str.charAt(i));
        }
    }

    static int find(String str, int n) {
        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (mp.containsKey(c)) {
                int pre_start = start;
                start = mp.get(c) + 1;
                removeAllNotUsefullChar(str, mp, pre_start, start);
            }
            mp.put(c, i);
            end = i;
        }
        System.out.println(mp);
        return (end - start + 1);

    }

    public static void main(String[] args) throws Exception {
//        Reader sc = new Reader();
//        int testCases = sc.nextInt();
//        while (testCases-- > 0) {
//            String str = sc.readLine();
//            System.out.println(find(str , str.length()));
//        }

        String s = "lcpsklryvmcpjnbpbwllsrehfmxrkecwitrsglrexvtjmxypunbqfgxmuvgfajclfvenhyuhuorjosamibdn";
        Set<Character> st = new HashSet<>();
        for(char c  : s.toCharArray()){
            st.add(c);
        }
        System.out.println("===st=== " + st);


    }
}
