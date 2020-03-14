package cn.dk.algorithm.sort;

/**
 * quick sort
 */
public class Quick {
    /**
     * 快速排序的递归实现
     *
     * @param origin
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] origin, int start, int end) {
        if (origin == null || origin.length == 0 || start < 0 || end > origin.length - 1 || start > end) {
            return null;
        }
        int partition = partition(origin, start, end);
        if (partition > start) {
            quickSort(origin, start, partition - 1);
        }
        if (partition < end) {
            quickSort(origin, partition + 1, end);
        }
        return origin;
    }

    private static int partition(int[] origin, int start, int end) {
        int stand = origin[start];
        int i = start;
        for (i = start + 1; i <= end; i++) {
            if (stand <= origin[i]) {
                swapArray(origin, i, end);
                end--;
            }
        }
        swapArray(origin, start, i);
        return i;
    }

    private static void swapArray(int[] origin, int x, int y) {
        int temp = origin[x];
        origin[x] = origin[y];
        origin[y] = origin[temp];
    }
}
