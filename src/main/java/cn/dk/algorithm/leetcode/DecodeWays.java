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
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        int[] memory = new int[length + 1];
        memory[0] = 1;
        if (length > 1) {
            boolean b = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26;
            if(s.charAt(1) != '0'){
                if(b){
                    memory[1] = 2;
                }else{
                    memory[1] = 1;
                }
            }else{
                if(b){
                    memory[1] = 1;
                }
            }
        }
        if(length > 2){
            for (int i = 2; i < length; i++) {
                if (s.charAt(i) != '0'){
                    memory[i] += memory[i-1];
                }
                if(s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26)
                memory[i] += memory[i - 2];
            }
        }
        return memory[length - 1];
    }

    public static int numDecodingsD(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
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
        s = "210";
        System.out.println(s + ", ways: " + numDecodings(s));
    }
}
