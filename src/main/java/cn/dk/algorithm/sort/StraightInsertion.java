package cn.dk.algorithm.sort;

public class StraightInsertion {
    /**
     * 直接插入排序
     * @param intArray
     * @return
     */
    public static int straightInsertionSort(int[] intArray){
        int sumTimes = 0;
        int[] sortIntArray = new int[intArray.length+1];
        System.arraycopy(intArray,0,sortIntArray,1,intArray.length);    // 直接插入排序需要一个额外的空间，所以这里创建一个比原数组大1的新数组，并把数组其中一个位置置为空

        for (int i = 1; i < sortIntArray.length; i++) {
            if(sortIntArray[i] < sortIntArray[i-1]){        // 需要插入到有序序列中
                sortIntArray[0] = sortIntArray[i];          //先把要插入的值保存到额外的0号空间中
                int j;
                for (j = i - 1; sortIntArray[j] > sortIntArray[0] ; j--) {  //循环前面已经有序的序列
                    sortIntArray[j + 1] = sortIntArray[j];                      //只要比待插入值大就向后移一位
                    sumTimes++;
                }
                sortIntArray[j + 1] = sortIntArray[0];      //循环结束，现在j处的元素是从后往前第一个比待插入元素小的（或者相等，这样就能保证稳定排序），所以待插入元素需要插入到j之后的一格
            }
        }
        System.arraycopy(sortIntArray,1,intArray,0,intArray.length);
        return sumTimes;
    }
}
