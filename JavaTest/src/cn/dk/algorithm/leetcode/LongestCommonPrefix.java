package cn.dk.algorithm.leetcode;

import java.util.Arrays;

/**
 * 获取一个字符串数字的最长前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.getLongestCommonPrefix(new String[]{"aa","a"}));

    }

    public String getLongestCommonPrefix(String[] strings){
        if (strings == null || strings.length == 0){
            return "";
        }
        char[] prefixChars = strings[0].toCharArray();
        int prefixLength = prefixChars.length;
        for (String temp: strings) {
            char[] tempChars = temp.toCharArray();
            int min = Math.min(prefixLength, tempChars.length);

            for (int i = 0; i < min; i++) {
                if (prefixChars[i] != tempChars[i]){
                    prefixLength = i;
                    break;
                }
            }
            prefixLength = Math.min(prefixLength, min);
            if (prefixLength == 0){
                return "";
            }
        }
        return String.valueOf(Arrays.copyOfRange(prefixChars, 0, prefixLength ));
    }
}
