package cn.dk.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [3] 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        System.out.println("pwwkew: " + result);

        result = lengthOfLongestSubstring("bbbbb");
        System.out.println("bbbbb: " + result);

        result = lengthOfLongestSubstring("abcabcbb");
        System.out.println("abcabcbb: " + result);
    }

    /**
     * access success
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int head,end;
        int length = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (head = 0, end = 0; end < chars.length; end ++){
            if (characterIntegerMap.containsKey(chars[end]) && characterIntegerMap.get(chars[end]) >= head ){
                int last = characterIntegerMap.put(chars[end], end);
                head = last + 1;
            }else {
                characterIntegerMap.put(chars[end], end);
            }
            length = length > (end - head + 1) ? length : (end - head + 1);
        }

        return length;
    }

    /**
     * 高票代码
     * 用一个i记录重复后的起点，j记录被插入set的字符的位置
     * while每次都判断一下j处的字符是否在set中，在就继续从i开始删除set中的元素，直达删除到重复的字符时，插入新的j，记录下目前为止最长的子串长度
     * 最终j抵达字符串的终点，返回最长子串的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringHighVote(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                // 当前set中不包含指针j处对应的char，直接插入，并使j++
                set.add(s.charAt(j++));
                // 记录最长的子串长度
                max = Math.max(max, set.size());
            } else {
                // 当前set中含有指针j处的char，存在重复，需要继续从起点i开始删除set元素，直至不和j重复为止
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
