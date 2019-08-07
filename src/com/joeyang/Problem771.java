package com.joeyang;

import java.util.HashSet;
import java.util.Set;

public class Problem771 {
    /**
     * 使用 hash code 来避免 for 循环嵌套
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> diamonds = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            diamonds.add(J.charAt(i));
        }
        for (int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (diamonds.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
