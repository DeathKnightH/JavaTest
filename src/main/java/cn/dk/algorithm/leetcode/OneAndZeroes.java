package cn.dk.algorithm.leetcode;

/**
 * 474
 */
public class OneAndZeroes {
    public static void main(String[] args) {
        int maxForm = findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        System.out.println(maxForm);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs){
            int zeros = count(s, '0');
            int ones = count(s, '1');
            if(zeros <= m && ones <= n){
                for(int i = m; i >= zeros; i --){
                    for (int j = n; j >= ones; j --) {
                        // 比zeros/ones大的dp都要可以用这个值更新，因为题目只要求不超过m和n，不需要相等
                            dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                        }
                    }
                }
            }
        return dp[m][n];
        }

    private static int count(String str, char target){
        int sum = 0;
        for (char temp : str.toCharArray()){
            if(temp == target){
                sum ++;
            }
        }
        return sum;
    }
}
