package cn.dk.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] params = new int[]{3,2,2,3};
        int length = removeElementBetter(params, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(params));

        params = new int[]{0,1,2,2,3,0,4,2};
        length = removeElementBetter(params, 2);
        System.out.println(length);
        System.out.println(Arrays.toString(params));

        params = new int[]{3,3,3};
        length = removeElementBetter(params, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(params));

        params = new int[]{2,2,2,2};
        length = removeElementBetter(params, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(params));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(i == j){
            return nums[0] == val ? 0: 1;
        }
        while(i<j) {
            if(val == nums[i]){
                while (val == nums[j] && i<j){
                    j--;
                }
                nums[i] = nums[j];
                nums[j] = val;
            }
            if(val != nums[i]) {
                i++;
            }
        }

        return nums[j] == val ? i : i+1;
    }

    /**
     * 改进方法，双指针从头开始遍历，杜绝了空数组和全匹配、全不匹配的特殊情况
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementBetter(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
