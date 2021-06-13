package cn.dk.algorithm.leetcode;

import javax.swing.*;
import java.util.*;

public class Q1449 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(largestNumber(new int[]{7,6,5,5,5,6,8,7,8}, 12));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static String largestNumber(int[] cost, int target) {
        int[][] costDump = costDump(cost);
        int[][] dp = new int[target + 1][costDump.length];
        for (int i = 1; i <= target; i++) {
            Arrays.fill(dp[i], - 1);
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < costDump.length; j++) {
                int tempCost = costDump[j][0];
                if (tempCost <= i) {
                    dp[i] = max(dp[i], merge(dp[i - tempCost], j), costDump);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = costDump.length - 1; i >=0; i--) {
            for (int j = 0; j < dp[target][i]; j++) {
                result.append(costDump[i][1] + 1);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    private static int[][] costDump(int[] cost){
        Map<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            costMap.put(cost[i], i);
        }
        int num = costMap.size();
        int[][] result = new int[num][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> e : costMap.entrySet()){
            result[i][0] = e.getKey();
            result[i][1] = e.getValue();
            i ++;
        }
        Arrays.sort(result, Comparator.comparingInt(a -> a[1]));

        return result;

    }

    private static int[] merge(int[] a, int b){
        int[] un = new int[a.length];
        Arrays.fill(un, - 1);
        if(Arrays.equals(a, un)){
            return a;
        }
        int[] result = Arrays.copyOf(a, a.length);
        result[b] ++;
        return result;
    }

    private static int[] max(int[] a, int[] b, int[][] cost) {
        StringBuilder aS = new StringBuilder();
        StringBuilder bS = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a[i]; j++) {
                aS.append(cost[i][1] + 1);
            }
            for (int j = 0; j < b[i]; j++) {
                bS.append(cost[i][1] + 1);
            }
        }
        if(aS.length() < bS.length()){
            return b;
        }else if(aS.length() > bS.length()){
            return a;
        }else {
            return aS.toString().compareTo(bS.toString()) < 0 ? b : a;
        }
    }
}
