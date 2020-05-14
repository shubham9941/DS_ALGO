//package pract.queue.medium;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class RemoveMinimumNumbers {
//
//
//    public static String removeKdigits(String num, int k) {
//        Queue<Character> q = new LinkedList<Character>();
//        for (int i = 0; i < k; i++) {
//            q.add(num.charAt(i));
//
//        }
//        String firstPart = "";
//        String rest = num.substring(k);
//        if(rest.isEmpty()){
//            return "0";
//        }
//        StringBuilder lastPart = new StringBuilder(rest);
//        int min = Integer.parseInt(lastPart.toString());
//        int l = lastPart.length();
//        while (l-- > 0) {
//            q.add(lastPart.charAt(0));
//            lastPart.deleteCharAt(0);
//            firstPart = firstPart + q.poll();
//
//            String combinePart = firstPart + lastPart;
//            if (Integer.parseInt(combinePart) < min) {
//                min = Integer.parseInt(combinePart);
//            }
//        }
//
//        if( k == 2){
//            int m = Integer.parseInt(num.substring(1 , num.length()-1));
//            return (m < min ? m+"" : min+"");
//        }
//
//        return min+"";
//
//
//
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(removeKdigits("10200" , 1));
////        System.out.println(Integer.parseInt("012"));
//    }
//}
