package cn.dk.algorithm.leetcode;

import java.util.Arrays;

public class Q1449A {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(largestNumber(new int[]{2,4,6,2,4,6,4,4,4}, 5));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 先 dp 求最大数字的长度，再贪心把数字从大到小排列
     * @param cost cost 数组
     * @param target 目标 cost
     * @return 刚好满足 cost 目标的最大数字
     */
    public static String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 9; i++) {
            int temp = cost[i];
            for (int j = temp; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - temp] + 1);
            }
        }
        int longest = dp[target];
        if(longest <= 0){
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i > 0 ; i--) {
            while (target >= cost[i - 1] && dp[target] - dp[target - cost[i - 1]] == 1){
                stringBuilder.append(i);
                target = target - cost[i - 1];
            }
        }
        return stringBuilder.toString();
    }
}
