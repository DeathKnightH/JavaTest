package cn.dk.algorithm.leetcode;

public class ImplementStrStr {
    public static void main(String[] args) {
        int index = strStr("hello","ll");
        System.out.println(index);
        index = strStr("aaaaa", "bba");
        System.out.println(index);
        index = strStr("mississippi", "issip");
        System.out.println(index);
    }

    public static int strStr(String haystack, String needle){
        if (needle == null || "".equals(needle)){
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()){
            return -1;
        }
        int i = 0;
        while (i < haystack.length()){
            boolean flag = true;
            int j;
            for (j = 0; j < needle.length(); j++) {
                if((i + j) == haystack.length()){
                    return -1;
                }
                flag = flag && (haystack.charAt(i+j) == needle.charAt(j));
                if (!flag){
                    break;
                }
            }
            if (flag){
                return i;
            }else {
                i++;
            }
        }
        return -1;
    }
}
