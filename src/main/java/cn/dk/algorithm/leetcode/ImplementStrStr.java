package cn.dk.algorithm.leetcode;

/**
 * [28] 实现strStr()
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * <p>
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
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
