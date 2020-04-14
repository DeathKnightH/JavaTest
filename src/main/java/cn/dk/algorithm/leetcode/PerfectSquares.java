package cn.dk.algorithm.leetcode;

/**
 * [279] 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int[] memory = new int[n + 1];
        int[] squares = new int[n];
        generateSquares(squares);
        memory[1] = 1;
        if (n > 1) {
            for (int i = 2; i < n + 1; i++) {
                memory[i] = i;
                for (int j = 0; j < i; j++) {
                    if (squares[j] <= i) {
                        int temp = i - squares[j];
                        memory[i] = Math.min(memory[i], memory[temp] + 1);
                    }
                }
            }
        }
        return memory[n];
    }

    /**
     * 计算生成 1 ~ n 之间所有可能的完全平方数
     *
     * @param squares
     */
    private static void generateSquares(int[] squares) {
        for (int i = 0; i < squares.length; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println("n = " + n + " ,sum of squares: " + numSquares(n));
        n = 13;
        System.out.println("n = " + n + " ,sum of squares: " + numSquares(n));
    }
}
