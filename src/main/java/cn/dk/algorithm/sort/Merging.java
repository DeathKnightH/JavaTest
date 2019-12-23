package cn.dk.algorithm.sort;

import java.util.Arrays;

public class Merging {
    /**
     * 归并排序的递归实现
     * @param intArray
     * @return
     */
    public static int mergingSortRecursion(int[] intArray){
        int[] resultArray = new int[intArray.length];           //新申请一组空间用于存储归并后的数组
        int sumTimes = mergingSortRecursion(intArray, resultArray, 0, intArray.length - 1);
        //System.arraycopy(resultArray,0, intArray, 0, intArray.length);
        return sumTimes;
    }

    /**
     * 归并排序的递归实现
     * 把srcArray中 [start,end]段的元素进行归并排序，归并至resultArray
     * @param srcArray 原序列
     * @param resultArray 归并后的结果序列
     * @param start 起点下标
     * @param end 终点下标
     * @return
     */
    public static int mergingSortRecursion(int[] srcArray, int[] resultArray, int start, int end){
        int sumTimes = 0;
        if(start == end){       //当待排序子序列中只有一个元素时，这一个元素的子序列本身一定是有序的
            resultArray[start] = srcArray[start];
            return sumTimes;
        }

        int middle = (start + end) / 2;
        sumTimes += mergingSortRecursion(srcArray, resultArray, start, middle);
        sumTimes += mergingSortRecursion(srcArray, resultArray, middle + 1, end);
        sumTimes += merge(resultArray, srcArray, start, middle, end);
        System.arraycopy(srcArray, start ,resultArray, start, end - start + 1);

        return sumTimes;
    }

    /**
     * 归并两个有序的子序列
     * @param srcArray 待排序的原数组序列
     * @param resultArray 归并后的结果序列
     * @param start 起点下标
     * @param middle 中间点下标，第一个有序子列范围为 [start,middle]，第二个有序子列范围为[middle+1,end]
     * @param end 终点下标
     * @return 循环次数
     */
    public static int merge(int[] srcArray, int[] resultArray, int start, int middle, int end){
        int sumTimes = 0;
        int i,j;
        for (i = start, j = middle + 1; start <=middle && j <= end; i++) {  // 按照归并后的数组长度进行遍历，从前往后，确保顺序为升序
            if(srcArray[start] > srcArray[j]){                              // 从头开始比较两个有序子序列，最小的值即为当前剩余未排序中最小的值，把最小值设置到相应位置
                resultArray[i] = srcArray[j];
                j ++;
            }else{
                resultArray[i] = srcArray[start];
                start ++;
            }
            sumTimes ++;
        }
        // 循环完，两个子序列的其中一个可能还有剩余（不可能两个都有剩余，因为只有其中一个子序列遍历超过了端点才会停止循环）
        if( start <= middle){
            for (int k = 0; k <= middle - start; k++) {
                resultArray[i + k] = srcArray[start + k];
            }
        }
        if( j <= end){
            for (int k = 0; k <= end - j; k++) {
                resultArray[i + k] = srcArray[j + k];
            }
        }

        return sumTimes;
    }
}
