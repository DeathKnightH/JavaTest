package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellTest {

    @Test
    public void shellSort() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        int times = Shell.shellSort(case1);
        long end = System.currentTimeMillis();
        System.out.println("Shell move times:" + times);
        System.out.println("10w耗时:"+ ( end - start));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        times = Shell.shellSort(case2);
        System.out.println("Shell move times:" + times);
        System.out.println(Arrays.toString(case2));
    }
}