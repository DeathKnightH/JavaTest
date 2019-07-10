package cn.dk.algorithm.sort;

public class Shell {
    /**
     * 希尔排序，增量步长为 n/3 + 1
     * @param intArray
     * @return
     */
    public static int shellSort(int[] intArray){
        int sumTimes = 0;
        int increment = intArray.length;
        do {
            increment = increment/3 + 1;        // 增量步长设为n/3 + 1，也有设置为 n/2的，具体没有固定的公式和结论
            for (int i = increment; i < intArray.length; i++) { // 从下标为 increment处开始循环，因为前increment个元素在内部循环中会比较到
                if(intArray[i] < intArray[i - increment]){      // 因为把整个数组分为了 increment 个子数组进行插入排序，所以比较和递增的步长为 increment
                    int temp = intArray[i];
                    int j;
                    for (j = i - increment; j >= 0 && intArray[j] > temp ; j -= increment) {    //向前比较，直到找到此元素在子数组的位置，将其插入
                        intArray[j + increment] = intArray[j];
                        sumTimes ++;
                    }
                    intArray[j + increment] = temp;
                }
            }
        } while (increment > 1);
        return sumTimes;
    }
}
