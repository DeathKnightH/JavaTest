package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergingTest {

    @Test
    public void mergingSortRecursion() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        long times = Merging.mergingSortRecursion(case1);
        System.out.println("Merging-sort compare times:" + times);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        times = Merging.mergingSortRecursion(case2);
        long end = System.currentTimeMillis();
        System.out.println("Merging-sort compare times:" + times);
        System.out.println("10w耗时" + (end - start));

        int[] case3 = ArrayToBeSort.generateNewArrayToBeSortRandom(10000000);
        start = System.currentTimeMillis();
        times = Merging.mergingSortRecursion(case3);
        end = System.currentTimeMillis();
        System.out.println("Merging-sort compare times:" + times);
        System.out.println("1000w耗时" + (end - start));
    }

    @Test
    public void merge() {
        int[] case1 = new int[]{1,3,2};
        int[] case2 = new int[]{0,0,0};
        Merging.merge(case1,case2, 0, 1, 2);
        System.out.println(Arrays.toString(case2));
    }

    @Test
    public void tempSort(){
        int[] case1 = new int[]{1,3,2,8,9};
        long times = Merging.mergingSortRecursion(case1);
        System.out.println(Arrays.toString(case1));
    }
}