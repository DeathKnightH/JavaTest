package cn.dk.algorithm.leetcode;

/**
 * [5] 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String source = "babad";
        System.out.println("中心扩散 输入: \"babad\" 输出：" + centerExtendSolution(source));
        System.out.println("动态规划 输入: \"babad\" 输出：" + dynamicProgram(source));
        source = "cbbd";
        System.out.println("中心扩散 输入: \"cbbd\" 输出：" + centerExtendSolution(source));
        System.out.println("动态规划 输入: \"cbbd\" 输出：" + dynamicProgram(source));

    }

    /**
     * 中心扩散解法
     *
     * @param s 源字符串
     * @return 最长回文子串
     */
    public static String centerExtendSolution(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int low = 0;
        int high = 0;
        int longest = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            int distanceOdd = centerExtend(chars, i, i);
            if (distanceOdd * 2 + 1 > longest) {
                longest = distanceOdd * 2 + 1;
                low = i - distanceOdd;
                high = i + distanceOdd;
            }
            if (chars[i] == chars[i + 1]) {
                int distance = centerExtend(chars, i, i + 1);
                if ((distance + 1) * 2 > longest) {
                    longest = (distance + 1) * 2;
                    low = i - distance;
                    high = i + 1 + distance;
                }
            }
        }
        return s.substring(low, high + 1);
    }

    /**
     * 求中心扩散距离
     *
     * @param chars      源字符数组
     * @param centerLow  中心点的低位index
     * @param centerHigh 中心点的高位index，如果与centerLow相等，则说明是计算奇数的回文
     * @return 从low中心扩散出来的最远的回文的距离
     */
    private static int centerExtend(char[] chars, int centerLow, int centerHigh) {
        for (int i = 0; centerLow - i >= 0 && centerHigh + i < chars.length; i++) {
            if (chars[centerLow - i] != chars[centerHigh + i]) {
                return i - 1;
            }
        }
        return centerLow < (chars.length - 1 - centerHigh) ? centerLow : chars.length - 1 - centerHigh;
    }

    /**
     * 动态规划解法
     *
     * @param s 源字符串
     * @return 最长回文子串
     */
    public static String dynamicProgram(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dpArray = new boolean[length][length];
        dpArray[0][0] = true;
        int low = 0, high = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    dpArray[i][j] = (i - j > 2 && dpArray[i - 1][j + 1]) || i - j <= 2;
                } else {
                    dpArray[i][j] = false;
                }
                if (dpArray[i][j] && i - j > high - low) {
                    low = j;
                    high = i;
                }
            }
        }
        return s.substring(low, high + 1);
    }
}
