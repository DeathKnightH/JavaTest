package cn.dk.algorithm.sort;

import java.util.Random;

public final class ArrayToBeSort {
    /**
     * 按长度随机生成int数组，用于测试排序算法，随机种子为当前时间
     * @param length
     * @return
     */
    public static int[] generateNewArrayToBeSortRandom(int length){
        Random random = new Random(System.currentTimeMillis());
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    /**
     * 随机生成0~100 长度为100的int数组，用于测试排序算法，随机种子为当前时间
     * @return
     */
    public static int[] generateNewArrayToBeSortRandom(){
        Random random = new Random(System.currentTimeMillis());
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
