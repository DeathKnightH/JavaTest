package cn.dk.algorithm.leetcode;

/**
 * [343] 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * <p>
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class IntegerBreak {
    /**
     * dp解法，乍一看很容易想到动态规划，从 n = 5 开始往后都可以考虑由 n < 5的已有值来计算获得，即 f(n) = MAX(f(n - i), f(n - i -1), ..., f(2))
     *
     * @param n
     * @return
     */
    public static int integerBreakDP(int n) {
        // 暂存数组多申请一个空间，以下标对应 n 的大小，减少越界判断代码
        int[] memory = new int[n + 1];
        // n = 5 之前都是特殊值，其中 2,3的分解值小于原值，4的分解值等于原值
        memory[2] = 1;
        if (n > 2) {
            memory[3] = 2;
        }
        if (n > 3) {
            memory[4] = 4;
        }
        if (n > 4) {
            for (int i = 5; i < n + 1; i++) {
                // 由于使用 1 作为因子不会改变最后乘积的大小，而且在n > 5 时，一定满足memory[n] > memory[n - 1]， (原因是memory[n] 必定可以由 memory[n - 1]
                // 的任意一个因子加一，其他因子不变得到，所以一定是大于后者的)
                for (int j = 2; j < i - 1; j++) {
                    // 还需要考虑额外的情况，即 n 可以分解为 2, 3, 4 两两相加的和，这时候可以直接分解为两个数
                    memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
                }
            }
        }
        return memory[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("n = " + n + ", break result = " + integerBreakDP(n));
        n = 5;
        System.out.println("n = " + n + ", break result = " + integerBreakDP(n));
    }
}
