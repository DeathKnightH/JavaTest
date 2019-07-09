package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StraightInsertionTest {

    @Test
    public void straightInsertionSort() {
        int[] case1 = new int[]{1,3,2,4,5,6,7,8,9,10};
        int times = StraightInsertion.straightInsertionSort(case1);
        System.out.println("Simple-Selection cycle times:" + times);
        System.out.println(Arrays.toString(case1));
    }
}