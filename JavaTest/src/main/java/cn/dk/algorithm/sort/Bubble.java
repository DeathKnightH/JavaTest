package cn.dk.algorithm.sort;

public class Bubble {
    /**
     * 标准的冒泡排序
     * @param intArray
     * @return
     */
    public static int bubbleSort(int[] intArray){
        int sumTimes = 0;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = intArray.length - 1; j >i; j--) {
                if (intArray[j] < intArray[j - 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j - 1];
                    intArray[j - 1] = temp;
                }
                sumTimes++;
            }
        }
        return sumTimes;
    }

    /**
     * 改进的冒泡排序，当后续元素已经有序的情况下直接返回，节省一部分时间
     * @param intArray
     * @return
     */
    public static int bubbleBetterSort(int[] intArray){
        int sumTimes = 0;
        for (int i = 0; i < intArray.length; i++) {
            boolean isSort = true;
            for (int j = intArray.length - 1; j >i; j--) {
                if (intArray[j] < intArray[j - 1]){
                    int temp = intArray[j];
                    intArray[j] = intArray[j - 1];
                    intArray[j - 1] = temp;
                    isSort = false;
                }
                sumTimes ++;
            }
            if (isSort){
                break;
            }
        }
        return sumTimes;
    }
}
