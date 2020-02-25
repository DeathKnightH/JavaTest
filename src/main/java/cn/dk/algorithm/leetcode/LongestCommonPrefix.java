package cn.dk.algorithm.leetcode;

import java.util.Arrays;

/**
 * [14] 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
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
