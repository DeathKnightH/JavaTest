package cn.dk.algorithm.leetcode;

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
