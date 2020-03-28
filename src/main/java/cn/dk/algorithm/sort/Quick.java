package cn.dk.algorithm.sort;

import java.util.Arrays;

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
        if (origin == null || origin.length == 0 || start < 0 || end > origin.length - 1 || start >= end) {
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
        for (int i = start + 1; i <= end; i++) {
            while (stand < origin[i] && end >= i) {
                swapArray(origin, i, end);
                end--;
            }
        }
        swapArray(origin, start, end);
        return end;
    }

    private static void swapArray(int[] origin, int x, int y) {
        int temp = origin[x];
        origin[x] = origin[y];
        origin[y] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{5, 4, 6, 8, 7, 1};
        //int partition = partition(testArray, 0, 5);
        //System.out.println("Partition index: " + partition + ". Array: " + Arrays.toString(testArray));
        quickSort(testArray, 0, 5);
        System.out.println("Sort Array: " + Arrays.toString(testArray));
        testArray = new int[]{3, 2, 1};
        int partition = partition(testArray, 0, 2);
        System.out.println("Partition index: " + partition + ". Array: " + Arrays.toString(testArray));
    }
}
