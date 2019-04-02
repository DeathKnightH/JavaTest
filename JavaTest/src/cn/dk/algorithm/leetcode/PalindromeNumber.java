package cn.dk.algorithm.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {

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
