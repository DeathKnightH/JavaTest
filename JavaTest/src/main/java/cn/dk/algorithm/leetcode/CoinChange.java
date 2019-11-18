package cn.dk.algorithm.leetcode;

/**
 * [322] 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int count = dynamicProgram(coins, 11);
        System.out.println("coins = [1, 2, 5], amount = 11 , count min:" + count);
        coins = new int[]{2};
        count = dynamicProgram(coins, 3);
        System.out.println("coins = [2], amount = 3 , count min:" + count);
    }

    /**
     * 暴力递归法
     *
     * @param coins  零钱面额数组
     * @param amount 总金额
     * @return 最少零钱个数
     */
    public static int force(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = amount + 1;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int subCount = force(coins, amount - coin);
                if (subCount >= 0 && subCount < count) {
                    count = subCount;
                }
            }
        }
        if (count == amount + 1) {
            return -1;
        }
        return count + 1;
    }

    /**
     * 使用一个带记录列表的递归
     *
     * @param coins  零钱面额数组
     * @param amount 总金额
     * @return 最少零钱个数
     */
    public static int withHelpList(int[] coins, int amount) {
        int[] helpList = new int[amount + 1];
        for (int i = 0; i < helpList.length; i++) {
            helpList[i] = -2;
        }
        return helper(coins, helpList, amount);
    }

    /**
     * 带一个记录列表的递归，用于记录已获得的结果，如果是已有记录的结果就直接返回，减少递归次数
     *
     * @param coins    零钱面额数组
     * @param helpList 已有结果的记录列表
     * @param amount   总金额
     * @return 最少零钱个数
     */
    private static int helper(int[] coins, int[] helpList, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (helpList[amount] != -2) {
            return helpList[amount];
        }
        int count = amount + 1;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int subCount = helper(coins, helpList, amount - coin);
                if (subCount >= 0 && subCount < count) {
                    count = subCount;
                }
            }
        }
        if (count == amount + 1) {
            helpList[amount] = -1;
            return -1;
        }
        helpList[amount] = count + 1;
        return count + 1;
    }

    /**
     * 动态规划非递归解法
     *
     * @param coins 零钱面额数组
     * @param amount 总金额
     * @return 最少零钱个数
     */
    public static int dynamicProgram(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];
        for (int i = 0; i < dpTable.length; i++) {
            dpTable[i] = amount + 1;
        }
        dpTable[0] = 0;
        for (int i = 1; i < dpTable.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dpTable[i] = Math.min(dpTable[i], 1 + dpTable[i - coin]);
                }
            }
        }
        return dpTable[amount] == amount + 1 ? -1 : dpTable[amount];
    }
}
