package cn.dk.algorithm.leetcode;

/**
 * [91] 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] memory = new int[length];
        if (s.charAt(0) == '0') {
            memory[0] = 0;
        } else {
            memory[0] = 1;
        }
        if (length > 1) {
            for (int i = 1; i < length; i++) {
                int increase = 0;
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) != '0' && Integer.valueOf(s.substring(i - 1, i)) <= 6)) {
                    increase = 1;
                }
                memory[i] = memory[i - 1] + increase;
            }
        }
        return memory[length - 1];
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(s + ", ways: " + numDecodings(s));
        s = "12";
        System.out.println(s + ", ways: " + numDecodings(s));
        s = "0";
        System.out.println(s + ", ways: " + numDecodings(s));
        s = "10";
        System.out.println(s + ", ways: " + numDecodings(s));
    }
}
