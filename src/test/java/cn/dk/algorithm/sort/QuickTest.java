package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickTest {
    @Test
    public void quickSortRecursion() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        Quick.quickSort(case1, 0, case1.length - 1);

        System.out.println(Arrays.toString(case1));

//        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
//        long start = System.currentTimeMillis();
//        Quick.quickSort(case2, 0, case2.length - 1);
//        long end = System.currentTimeMillis();
//        System.out.println("10w耗时" + (end - start));

//        int[] case3 = ArrayToBeSort.generateNewArrayToBeSortRandom(10000000);
//        start = System.currentTimeMillis();
//        Quick.quickSort(case3, 0, case3.length - 1);
//        end = System.currentTimeMillis();
//        System.out.println("1000w耗时" + (end - start));
    }
}