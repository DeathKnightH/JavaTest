package cn.dk.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 罗马字符转正整数，范围1-3999
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int number = romanToInteger.romanToInteger("IV");
        System.out.println(number);
    }

    public int romanToInteger(String roman){
        char[] charList = roman.toCharArray();
        List<Integer> numberList = new ArrayList<>();
        for (char temp: charList ) {
            if (temp == 'I'){
                numberList.add(1);
            }else if (temp == 'V'){
                numberList.add(5);
            }else if (temp == 'X'){
                numberList.add(10);
            }else if (temp == 'L'){
                numberList.add(50);
            }else if (temp == 'C'){
                numberList.add(100);
            }else if (temp == 'D'){
                numberList.add(500);
            }else if (temp == 'M'){
                numberList.add(1000);
            }
        }
        int flag = 4000;
        int result = 0;
        for (int i = 0; i < numberList.size(); i++) {
            int temp = numberList.get(i);
            if (flag < temp){
                result = result + temp - 2 * flag;
            }else{
                result += temp;
            }
            flag = temp;
        }
        return result;
    }
}
