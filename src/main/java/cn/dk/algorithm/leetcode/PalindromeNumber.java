package cn.dk.algorithm.leetcode;

/**
 * [9] 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 1234;
        System.out.println(x + ":" + palindromeNumber.isPalindrome(x));
        x = 123321;
        System.out.println(x + ":" + palindromeNumber.isPalindrome(x));
        x = 12321;
        System.out.println(x + ":" + palindromeNumber.isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        char[] charList = xString.toCharArray();
        int low = 0;
        int high = charList.length - 1;
        while ( low <= high ){
            if(charList[low] != charList[high]){
                return false;
            }
            low ++;
            high --;
        }
        return true;
    }
}
