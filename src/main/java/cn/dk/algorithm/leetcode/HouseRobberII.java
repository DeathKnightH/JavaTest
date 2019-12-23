package cn.dk.algorithm.leetcode;

/**
 * [213] 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class HouseRobberII {
    public static void main(String[] args) {
        int[] houses = new int[]{2, 3, 3};
        System.out.println("输入: [2,3,2] 输出：" + dynamicProgram(houses));
        houses = new int[]{1, 2, 3, 1};
        System.out.println("输入: [1,2,3,1] 输出：" + dynamicProgram(houses));
    }

    /**
     * 动态规划解法
     *
     * @param nums 房屋价值数组
     * @return 能偷到的最多的钱
     */
    public static int dynamicProgram(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        return Math.max(subDynamic(nums, 0, length - 2), subDynamic(nums, 1, length - 1));
    }

    private static int subDynamic(int[] nums, int start, int end) {
        if (end == start) {
            return nums[start];
        }

        int[] dpAmount = new int[nums.length];
        dpAmount[start] = nums[start];
        dpAmount[start + 1] = Math.max(nums[start], nums[start + 1]);
        int result = dpAmount[start + 1];
        for (int i = start + 2; i < end + 1; i++) {
            dpAmount[i] = Math.max(dpAmount[i - 1], dpAmount[i - 2] + nums[i]);
            result = result > dpAmount[i] ? result : dpAmount[i];
        }
        return result;
    }
}
