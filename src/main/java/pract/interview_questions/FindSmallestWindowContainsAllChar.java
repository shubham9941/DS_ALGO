package pract.interview_questions;

import java.util.HashMap;

public class FindSmallestWindowContainsAllChar {

    static class MapNodeInfo {
        int actual;
        int found;

        MapNodeInfo(int actual) {
            this.actual = actual;
            this.found = 0;
        }
    }

    static int findSubString(String str, String pat) {

        HashMap<Character, MapNodeInfo> mp = new HashMap<>();
        int reqWindow = pat.length();
        int currentWindow = 0;
        int minWin = Integer.MAX_VALUE;
        System.out.println("===reqWindow=== " + reqWindow);
        for (int i = 0; i < reqWindow; i++) {
            char c = pat.charAt(i);
            if (mp.containsKey(c)) {
                mp.get(c).actual++;
            } else {
                mp.put(c, new MapNodeInfo(1));
            }
        }

        mp.forEach((x,y) -> {
            System.out.println(x + " = "+ y.actual);
        });

        int i = 0;
        int j = 0;
        for (; j < str.length(); j++) {
            char c = str.charAt(j);
            if (mp.containsKey(c)) {
                mp.get(c).found++;
                if (mp.get(c).found <= mp.get(c).actual) {
                    currentWindow++;
                }
            }

            if (currentWindow == reqWindow) {
                System.out.println("Window detected for i = " + i + " j = " + j);
                minWin = (j - i + 1) < minWin ? (j - i + 1) : minWin;
                while (true) {
                    char ci = str.charAt(i);
                    if (mp.containsKey(ci)) {
                        if (mp.get(ci).found > mp.get(ci).actual) {
                            mp.get(ci).found--;
                            minWin = (j - i + 1) < minWin ? (j - i + 1) : minWin;
                        }
                        else{
                            minWin = (j - i + 1) < minWin ? (j - i + 1) : minWin;
                            System.out.println("i = " + i );
                            System.out.println("j = " + j );
                            break;
                        }

                    }
                    i++;
                }
            }

        }

        return minWin;

    }

    public static void main(String[] args) {

        String str = "geeksforgeeks";
        String pract = "ork";

        System.out.println(str.substring(3,7));

//        System.out.println(findSubString(str,pract));

    }
}
