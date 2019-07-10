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
            increment = increment/3 + 1;
            for (int i = increment; i < intArray.length; i++) {
                if(intArray[i] < intArray[i - increment]){
                    int temp = intArray[i];
                    int j;
                    for (j = i - increment; j >= 0 && intArray[j] > temp ; j -= increment) {
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
