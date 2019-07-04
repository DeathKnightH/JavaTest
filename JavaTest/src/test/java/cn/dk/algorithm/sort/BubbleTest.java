package cn.dk.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void bubbleSort(){
        int[] case1 = new int[]{1,3,2,4,5,6,7,8,9,10};
        int times = Bubble.bubbleSort(case1);
        System.out.println("Normal cycle times:" + times);
        System.out.println(Arrays.toString(case1));
    }

    @Test
    public void bubbleBetterSort() {
        int[] case1 = new int[]{1,3,2,4,5,6,7,8,9,10};
        int times = Bubble.bubbleBetterSort(case1);
        System.out.println("Better cycle times:" + times);
        System.out.println(Arrays.toString(case1));
    }
}