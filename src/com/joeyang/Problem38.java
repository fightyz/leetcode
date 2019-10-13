package com.joeyang;

public class Problem38 {
    public String countAndSay(int n) {
        String origin = "1";
        String result = "";
        for (int i = 1; i < n; i++) {
            char countedChar = ' ';
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < origin.length(); j++) {
                char currentChar = origin.charAt(j);
                if (currentChar != countedChar) {
                    if (count != 0) {
                        sb.append(count).append(countedChar);
                    }
                    countedChar = currentChar;
                    count = 0;
                }
                if (countedChar == currentChar) {
                    count++;
                }
            }
            origin = sb.append(count).append(countedChar).toString();
        }
        return origin;
    }
}
