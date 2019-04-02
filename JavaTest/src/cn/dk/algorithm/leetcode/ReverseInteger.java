package cn.dk.algorithm.leetcode;

public class ReverseInteger {
    public static void main(String[] args){
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = 120;
        System.out.println(reverseInteger.reverse(x));
    }

    public int reverse(int x) {
        int sign = Integer.signum(x);
        if(sign == 0){
            return 0;
        }
        String unsignedString = String.valueOf(Math.abs(x));
        char[] intCharList = unsignedString.toCharArray();
        for (int i = 0; i < (intCharList.length/2 + 1); i++) {
            if(intCharList.length -1 -i >= i){
                char temp = intCharList[i];
                intCharList[i] = intCharList[intCharList.length -1 -i];
                intCharList[intCharList.length -1 -i] = temp;
            }
        }
        String resultString = String.valueOf(intCharList);
        Integer result = 0;
        try{
            result = Integer.valueOf(resultString);
        }catch(NumberFormatException e){
            return 0;
        }
        if(!resultString.equals(String.valueOf(Math.abs(result)))){
            return 0;
        }
        if(sign == -1){
            return - result;
        }
        return result;
    }
}
