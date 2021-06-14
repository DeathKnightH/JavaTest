package cn.dk.algorithm.common;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inputString = in.nextLine();
            System.out.println(helper(inputString));
        }
    }

    private static String helper(String s){
        int[] counts = new int[26];
        int length = s.length();
        boolean illegal = false;
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if( temp <= 'z' && temp >= 'a'){
                counts[temp - 'a'] += 1;
            }else if (temp <= 'Z' && temp >= 'A'){
                counts[temp - 'A'] += 1;
            }else {
                illegal = true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (illegal){
            stringBuilder.append('#');
        }
        for(int i = 0; i < 26; i ++){
            if (counts[i] != 0){
                char character = (char)('a' + i);
                for (int j = 0; j < counts[i]; j++) {
                    stringBuilder.append(character);
                }
            }
        }
        return stringBuilder.toString();
    }
}
