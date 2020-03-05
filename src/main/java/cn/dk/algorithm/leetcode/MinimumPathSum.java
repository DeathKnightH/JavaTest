package cn.dk.algorithm.leetcode;

/**
 * [64] 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinimumPathSum {
    /**
     * 递归解法，结果超出时间限制，应该是由于递归重复计算的问题导致
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int endx = grid.length - 1;
        int endy = grid[0].length - 1;
        return minPath(grid, endx, endy);
    }

    private static int minPath(int[][] grid, int endx, int endy) {
        if (endx == 0 && endy == 0) {
            return grid[endx][endy];
        }
        if (endx == 0) {
            return grid[endx][endy] + minPath(grid, endx, endy - 1);
        }
        if (endy == 0) {
            return grid[endx][endy] + minPath(grid, endx - 1, endy);
        }
        return grid[endx][endy] + Math.min(minPath(grid, endx - 1, endy), minPath(grid, endx, endy - 1));
    }

    /**
     * 动态规范解法，使用一个同样大小的数组
     *
     * @param grid
     * @return
     */
    public static int minPathSumAdvance(int[][] grid) {
        // 用同样大小的辅助数组记录已经计算过的数据，避免重复计算
        int[][] sumGrid = new int[grid.length][grid[0].length];
        return minPathHelper(grid, 0, 0, sumGrid);
    }

    private static int minPathHelper(int[][] grid, int x, int y, int[][] sumGrid) {
        if (sumGrid[x][y] != 0) {
            return sumGrid[x][y];
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        int xLast = Integer.MAX_VALUE, yLast = Integer.MAX_VALUE;
        if (x < grid.length - 1) {
            xLast = minPathHelper(grid, x + 1, y, sumGrid);
        }
        if (y < grid[0].length - 1) {
            yLast = minPathHelper(grid, x, y + 1, sumGrid);
        }
        sumGrid[x][y] = grid[x][y] + Math.min(xLast, yLast);
        return sumGrid[x][y];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
//        System.out.println(minPathSum(grid));
        grid = new int[][]{
                {3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}
        };
        System.out.println(minPathSumAdvance(grid));
    }
}
