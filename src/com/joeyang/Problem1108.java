package com.joeyang;

public class Problem1108 {
    /**
     * 使用 split 时，参数是正则表达式，而 '.' 是正则表达式中的关键字，因此需要转义后才能使用
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        String separator = "[.]";
        String[] elements = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element).append(separator);
        }
        int length = sb.length();
        String substring = sb.substring(0, length - separator.length());
        return substring;
    }
}
