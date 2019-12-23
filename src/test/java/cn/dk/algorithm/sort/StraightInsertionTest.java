package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StraightInsertionTest {

    @Test
    public void straightInsertionSort() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        int times = StraightInsertion.straightInsertionSort(case1);
        System.out.println("Straight-Insert cycle times:" + times);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        times = StraightInsertion.straightInsertionSort(case2);
        long end = System.currentTimeMillis();
        System.out.println("Straight-Insert cycle times:" + times);
        System.out.println("10w耗时" + (end - start));
    }
}