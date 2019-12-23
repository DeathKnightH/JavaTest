package cn.dk.algorithm.leetcode;

import java.util.Stack;

/**
 * [394] 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println("输入 \"3[a]2[bc]\", 返回：\"" + decodeString(s) + "\"");
        s = "3[a2[c]]";
        System.out.println("输入 \"3[a2[c]]\", 返回：\"" + decodeString(s) + "\"");
        s = "2[abc]3[cd]ef";
        System.out.println("输入 \"2[abc]3[cd]ef\", 返回：\"" + decodeString(s) + "\"");
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();

        for (char c : chars) {
            if (c != ']') {
                characterStack.push(c);
            } else {
                StringBuilder builder = new StringBuilder();
                // 要重复的字符出栈
                while (!characterStack.isEmpty() && characterStack.peek() != '[') {
                    builder.insert(0, characterStack.pop());
                }
                String stringToRepeat = builder.toString();
                // '[' 出栈
                characterStack.pop();
                StringBuilder digitBuilder = new StringBuilder();
                // 重复次数出栈
                while (!characterStack.isEmpty() && Character.isDigit(characterStack.peek())) {
                    digitBuilder.insert(0, characterStack.pop());
                }
                int num = Integer.valueOf(digitBuilder.toString());
                char[] charsInside = stringToRepeat.toCharArray();
                for (int i = 0; i < num; i++) {
                    for (char temp : charsInside) {
                        characterStack.push(temp);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!characterStack.isEmpty()) {
            stringBuilder.insert(0, characterStack.pop());
        }
        return stringBuilder.toString();
    }
}
