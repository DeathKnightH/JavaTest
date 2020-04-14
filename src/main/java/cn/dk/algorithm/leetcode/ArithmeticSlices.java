package cn.dk.algorithm.leetcode;

import java.util.Arrays;

/**
 * [413] 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * <p>
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * <p>
 * 以下数列不是等差数列。
 * <p>
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * <p>
 * <p>
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
public class ArithmeticSlices {
    /**
     * 子数组必须是连续的，所以可以通过每一个子数组的长度计算然后求和得出所有子数组的数量
     *
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int sum = 0;
        int slicesLength = 0;
        boolean isSlices = false;
        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                if (!isSlices) {
                    isSlices = true;
                }
                slicesLength++;
            } else {
                if (isSlices) {
                    sum += (slicesLength + 1) * slicesLength / 2;
                    slicesLength = 0;
                }
            }
        }
        sum += (slicesLength + 1) * slicesLength / 2;
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(array));
        System.out.println("Array " + Arrays.toString(array) + ", DP function sum:" + dp(array));
    }

    /**
     * 动态规划解法，使用一个同样大小的一维数组存储到当前元素结束的等差子数组的个数，即 memory[i] = memory[i-1] + 1
     *
     * @param A
     * @return
     */
    public static int dp(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int sum = 0;
        int[] memory = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                memory[i] = memory[i - 1] + 1;
            }
            sum += memory[i];
        }
        return sum;
    }
}
