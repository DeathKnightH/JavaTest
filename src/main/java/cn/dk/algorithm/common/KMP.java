package cn.dk.algorithm.common;

import java.util.Arrays;

public class KMP {
    /**
     * 获取subText字符串的next数组
     * @param subText
     * @return
     */
    public static int[] getNext(String subText){
        char[] charArr = subText.toCharArray();
        int[] next = new int[charArr.length];

        int i = 0;
        int j = -1;
        next[0] = -1;

        while(i < charArr.length - 1){
            if(j == -1 || charArr[i] == charArr[j]){
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 改进next数组，获取nextval数组
     * @param subText
     * @return
     */
    public static int[] getNextVal(String subText){
        char[] charArr = subText.toCharArray();
        int[] nextVal = new int[charArr.length];

        int i = 0;
        int j = -1;
        while (i < charArr.length){
            if (j == -1 || charArr[i] == charArr[j]){
                i++;
                j++;
                if(charArr[i] != charArr[j]){
                    nextVal[i] = j;
                }else {
                    nextVal[i] = nextVal[j];
                }
            }else {
                j = nextVal[j];
            }
        }
        return nextVal;
    }

    /**
     * 使用next数组进行kmp模式匹配，返回第一个匹配子串的index
     * @param sourceText
     * @param subText
     * @param pos
     * @return
     */
    public static int indexKmp(String sourceText, String subText, int pos){
        // 主串下标，起始位置为pos
        int i = pos;
        char[] mainCharArr = sourceText.toCharArray();

        // 子串下标，起始位置为0
        int j = 0;
        char[] subCharArr = subText.toCharArray();

        // 子串next数组
        int[] next = getNext(subText);

        while (i < sourceText.length() && j < subText.length()){
            if(j == -1 || mainCharArr[i] == subCharArr[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }

        if(j == subText.length()){
            return i - subText.length();
        }else {
            return -1;
        }
    }

    public static void main(String[] args){
        String test = "ababaaaba";
        int[] next = getNext(test);
        System.out.println(Arrays.toString(next));

        String testMain = "ababaaabbbababaaabacababaaaba";

        int index = indexKmp(testMain, test, 0);
        System.out.println(index);
    }
}
