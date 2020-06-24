package pract.trie;

import java.util.Map;
import java.util.TreeMap;

public class Trie {

     TrieNode root;

     class TrieNode {
        Map<Character, TrieNode> childs;
        int count = 0;
        boolean isEndOfWord;

        TrieNode() {
            childs = new TreeMap<Character, TrieNode>();
            isEndOfWord = false;
        }
    }

    public  void insert(String str) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!current.childs.containsKey(c)) {
                current.childs.put(c, new TrieNode());
            }
            current.childs.get(c).count += 1;
            current = current.childs.get(c);
        }
        current.isEndOfWord = true;
    }

     boolean search(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (current.childs.containsKey(c)) {
                current = current.childs.get(c);
            } else {
                return false;
            }
        }

        return current.isEndOfWord;
    }


    public  int boggleSearch(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (current.childs.containsKey(c)) {
                current = current.childs.get(c);
            } else {
                return -1;
            }
        }
        if(current.isEndOfWord){
            return 1;
        }
        else return 0;

    }

     private void printAllWords(TrieNode root, String keys) {
        if (root.isEndOfWord) {
            System.out.println(keys);
        }
        root.childs.forEach((x, y) -> {
            printAllWords(y, keys + x);
        });
    }

     void printAutoSuggestions(String str) {
        TrieNode current = root;
        boolean isWordFound = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (current.childs.containsKey(c)) {
                current = current.childs.get(c);
            } else {
                isWordFound = false;
                break;
            }
        }
        if (isWordFound) {
            printAllWords(current, str);
        } else {
            System.out.print("Word not exist in dictionary");
        }

    }

    // Find longest common prefix
     String findLCP() {
        StringBuilder sb = new StringBuilder();
        TrieNode current = root;

        int MAX_COUNT  = Integer.MIN_VALUE;

        while (current.childs.size() == 1) {

            Map.Entry<Character, TrieNode> current_node_info  = current.childs.entrySet().stream().findFirst().get();
            char key = current_node_info.getKey();
            TrieNode childNode = current_node_info.getValue();

            if(childNode.count >= MAX_COUNT){
                MAX_COUNT = childNode.count;
                sb.append(key);
                current = childNode;
            }
            else{
                break;
            }
        }
        return sb.toString();
    }


//    static boolean preFixSearch(String str) {
//        TrieNode current = root;
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (current.childs.containsKey(c)) {
//                current = current.childs.get(c);
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("he");
        trie.insert("help");
        trie.insert("hell");
        trie.insert("hello");
//        insert("dog");
//        insert("cat");
//        insert("a");
//        insert("helps");
//        insert("helping");
//        System.out.print(boggleSearch("q"));

        System.out.println(trie.findLCP()) ;
//
//        System.out.println(search("lm"));
//        System.out.println(preFixSearch("lmt"));

    }

}
