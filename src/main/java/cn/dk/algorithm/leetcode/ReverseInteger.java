package cn.dk.algorithm.leetcode;

/**
 * [7] 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 */
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
