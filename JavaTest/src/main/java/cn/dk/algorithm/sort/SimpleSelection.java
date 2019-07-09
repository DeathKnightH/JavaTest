package cn.dk.algorithm.sort;

public class SimpleSelection {
    /**
     * 简单选择排序，与冒泡一样时间复杂度都是O(n²)，但是每次外层循环只交换一次，实际效率比冒泡略高
     * @param intArray
     * @return
     */
    public static int simpleSelectionSort(int[] intArray){
        int sumTimes = 0;
        for (int i = 0; i < intArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < intArray.length; j++) {
                if(intArray[i] > intArray[j]){
                    minIndex = j;
                }
                sumTimes++;
            }
            int temp = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = temp;
        }
        return sumTimes;
    }
}
