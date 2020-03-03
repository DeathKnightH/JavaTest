package cn.dk.algorithm.leetcode;

/**
 * [70] 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs {
    /**
     * dp解法。第 n 阶梯的走法数 f(n) = f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // 初始状态，1阶1种，2阶2种
        int step1 = 1, step2 = 2;
        for (int i = 2; i < n; i++) {
            int result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return step2;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(n + "阶，有 " + climbStairs(n) + " 种走法");
    }
}
