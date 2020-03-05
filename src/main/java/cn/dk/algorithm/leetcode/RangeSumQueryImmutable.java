package cn.dk.algorithm.leetcode;

/**
 * [303] 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * 说明:
 * <p>
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class RangeSumQueryImmutable {
    private int[] sumList;

    public RangeSumQueryImmutable(int[] nums) {
        sumList = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sumList[0] = nums[0];
            } else {
                this.sumList[i] = sumList[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sumList[j];
        }
        return sumList[j] - sumList[i - 1];
    }
}
