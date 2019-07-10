package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class SimpleSelectionTest {

    @Test
    public void simpleSelectionSort() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        int times = SimpleSelection.simpleSelectionSort(case1);
        System.out.println("Simple-Selection cycle times:" + times);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        times = SimpleSelection.simpleSelectionSort(case2);
        long end = System.currentTimeMillis();
        System.out.println("Simple-Selection cycle times:" + times);
        System.out.println("10w耗时" + (end - start));
    }
}