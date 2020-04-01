package cn.dk.algorithm.leetcode.twopointers;

/**
 * [345] 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            // 两个指针都是元音字母时交换，同时使左指针右移一位，右指针左移一位
            if (isVowel(chars[start]) && isVowel(chars[end])) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            if (!isVowel(chars[start])) {
                start++;
            }
            if (!isVowel(chars[end])) {
                end--;
            }
        }
        return String.valueOf(chars);
    }

    /**
     * 判断字符是否是元音字母，注意大写字母
     *
     * @param c 需要判断的字符
     * @return 是返回 true，否返回 false
     */
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String testString = "hello";
        System.out.println("Reverse of " + testString + " is: " + reverseVowels(testString));
        testString = "leetcode";
        System.out.println("Reverse of " + testString + " is: " + reverseVowels(testString));
    }
}
