package cn.dk.algorithm.leetcode.twopointers;

/**
 * [633] 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 * <p>
 * 示例1:
 * <p>
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例2:
 * <p>
 * <p>
 * 输入: 3
 * 输出: False
 */
public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        // 右指针开平方，减少循环次数
        int start = 0, end = (int) Math.sqrt(c);
        while (start <= end) {
            if (start * start + end * end > c) {
                end--;
                continue;
            } else if (start * start + end * end < c) {
                start++;
                continue;
            } else {
                return true;
            }
        }
        // 遍历完还没找到返回 false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(100000));
    }
}
