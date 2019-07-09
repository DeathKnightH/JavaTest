package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleSelectionTest {

    @Test
    public void simpleSelectionSort() {
        int[] case1 = new int[]{1,3,2,4,5,6,7,8,9,10};
        int times = SimpleSelection.simpleSelectionSort(case1);
        System.out.println("Simple-Selection cycle times:" + times);
        System.out.println(Arrays.toString(case1));
    }
}