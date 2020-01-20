package cn.dk.algorithm.leetcode;

/**
 * [4] 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,5,9};
        int[] array2 = new int[]{1,6,9};
        double median = findMedianSortedArrays(array1, array2);
        System.out.println(median);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m1 = 0, m2 = 0;
        int i1 = 1, i2 = 1;
        int middleIndex = (nums1.length + nums2.length)/2;
        boolean isOdd = ((nums1.length + nums2.length) & 1) == 1;
        while((i1 + i2) <= middleIndex + 1){
            int currentValue = 0;
            if (nums1[i1 - 1] < nums2[i2 - 1]){
                currentValue = nums1[i1 - 1];
                i1 ++;
            }else {
                currentValue = nums2[i2 - 1];
                i2 ++;
            }

            if((i1 + i2) == middleIndex){
                m1 = currentValue;
                if(isOdd){
                    m2 = m1;
                }
            }else if((i1 + i2) == middleIndex + 1){
                if(!isOdd){
                    m2 = currentValue;
                }
            }
        }
        return (m1 + m2)/2;
    }
}
