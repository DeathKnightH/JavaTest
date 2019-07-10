package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {
    @Test
    public void bubbleSort(){
        int[] case1 = new int[]{1,3,2,4,5,6,7,8,9,10};
        int times = Bubble.bubbleSort(case1);
        System.out.println("Normal cycle times:" + times);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        times = Bubble.bubbleSort(case2);
        long end = System.currentTimeMillis();
        System.out.println("Better cycle times:" + times);
        System.out.println("10w耗时" + (end - start));
    }

    @Test
    public void bubbleBetterSort() {
        int[] case1 = ArrayToBeSort.generateNewArrayToBeSortRandom();
        int times = Bubble.bubbleBetterSort(case1);
        System.out.println("Better cycle times:" + times);
        System.out.println(Arrays.toString(case1));

        int[] case2 = ArrayToBeSort.generateNewArrayToBeSortRandom(100000);
        long start = System.currentTimeMillis();
        times = Bubble.bubbleBetterSort(case2);
        long end = System.currentTimeMillis();
        System.out.println("Better cycle times:" + times);
        System.out.println("10w耗时" + (end - start));
    }
}