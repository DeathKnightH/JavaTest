package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void heapSortAesc() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        int times = Heap.heapSortAesc(case1);
        System.out.println("Heap-sort compare times:" + times);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        times = Heap.heapSortAesc(case2);
        long end = System.currentTimeMillis();
        System.out.println("Heap-sort compare times:" + times);
        System.out.println("10w耗时" + (end - start));

        int[] case3 = ArrayToBeSort.generateNewArrayToBeSortRandom(10000000);
        start = System.currentTimeMillis();
        times = Heap.heapSortAesc(case3);
        end = System.currentTimeMillis();
        System.out.println("Heap-sort compare times:" + times);
        System.out.println("1000w耗时" + (end - start));
    }
}