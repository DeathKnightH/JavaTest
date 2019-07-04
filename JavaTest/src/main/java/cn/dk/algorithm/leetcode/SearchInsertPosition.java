package cn.dk.algorithm.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int result = searchInsert(nums,1);
//        int[] nums = new int[]{1,3,5,6};
//        int result = searchInsert(nums, 5);
//        System.out.println(result);
//
//        result = searchInsert(nums, 2);
//        System.out.println(result);
//
//        result = searchInsert(nums, 7);
//        System.out.println(result);
//
//        result = searchInsert(nums, 0);
//        System.out.println(result);


    }

    public static int searchInsert(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            if (nums[(high + low)/2] == target){
                return (high + low)/2;
            }else if (nums[(high + low)/2] > target){
                high = (high + low)/2 - 1;
            }else {
                low = (high + low)/2 + 1;
            }
        }
        return nums[low] >= target ? low : low + 1;
    }
}
