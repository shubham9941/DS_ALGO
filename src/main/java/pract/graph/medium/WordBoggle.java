package pract.graph.medium;

import pract.Reader;
import pract.trie.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
 * Find all possible words that can be formed by a sequence of adjacent characters.
 * Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 * <p>
 * Example:
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 * boggle[][]   = {
 * {'G','I','Z'},
 * {'U','E','K'},
 * {'Q','S','E'}
 * };
 * <p>
 * Output:  Following words of dictionary are present
 * GEEKS, QUIZ
 */

public class WordBoggle {

    int[] X = {0, 0, -1, 1, -1, 1, -1, 1};
    int[] Y = {-1, 1, 0, 0, -1, 1, 1, -1};
    int n;
    int m;
    char[][] collections;
    Trie trie;

    TreeSet<String> al = new TreeSet<>();

    WordBoggle(int n, int m, char[][] collections, Trie trie) {
        this.n = n;
        this.m = m;
        this.collections = collections;
        this.trie = trie;
    }


    boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1);
    }


    void findWords(int i, int j, String p, boolean[][] visited) {
        visited[i][j] = true;

        String str = p + collections[i][j];
        int stage = trie.boggleSearch(str);
        if (stage == 1) {
            al.add(str);
        }
        if (stage != -1) {
            for (int k = 0; k < 8; k++) {
                int x = i + X[k];
                int y = j + Y[k];
                if (isValid(x, y, n, m) && !visited[x][y]) {
                    findWords(x, y, str, visited);
                }
            }
        }
        visited[i][j] = false;
    }

    void find() {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findWords(i, j, "", visited);
//                if (!visited[i][j]) {
//                    System.out.println("---checking for i = " + i  + " and j = " + j);
//                    findWords(i, j, "", visited);
//                }
            }
        }
        if (al.isEmpty()) {
            System.out.println(-1);
        } else {
            al.forEach(x -> System.out.print(x + " "));
        }

    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int dicLength = sc.nextInt();
            Trie trie = new Trie();
            for (String str : sc.readLine().split(" ")) {
                trie.insert(str);
            }
            int n = sc.nextInt();
            int m = sc.nextInt();
            String collectionData = sc.readLine();
            int k = 0;

            char[][] collections = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    collections[i][j] = collectionData.charAt(k);
                    k = k + 2;
                }
            }
            WordBoggle obj = new WordBoggle(n, m, collections, trie);
            obj.find();

        }

    }

}
