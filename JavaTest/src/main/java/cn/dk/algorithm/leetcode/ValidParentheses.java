package cn.dk.algorithm.leetcode;

import java.util.Stack;

/**
 * 校验字符串中括号是否有效配对
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("}]"));
        System.out.println(validParentheses.isValidOnlyParentheses("}]"));
    }
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (char tempChar: chars) {
            if (tempChar == '(' || tempChar == '[' || tempChar == '{') {
                charStack.push(Character.valueOf(tempChar));
            }
            if (!charStack.empty()) {
                if (tempChar == ')') {
                    if (charStack.peek() == '(') {
                        charStack.pop();
                    }else {
                        return false;
                    }
                } else if (tempChar == ']') {
                    if (charStack.peek() == '[') {
                        charStack.pop();
                    }else {
                        return false;
                    }
                } else if (tempChar == '}') {
                    if (charStack.peek() == '{') {
                        charStack.pop();
                    }else {
                        return false;
                    }
                }
            }else{
                if (tempChar == ')' || tempChar == ']' || tempChar == '}'){
                    return false;
                }
            }
        }
        return charStack.empty();
    }

    /**
     * 字符串中只包含括号字符:()[]{}
     * @param s
     * @return
     */
    public boolean isValidOnlyParentheses(String s){
        int length;
        do {
            length = s.length();
            s.replace("()", "").replace("[]","").replace("{}","");
        }while (length != s.length());
        return s.length() == 0;
    }
}
