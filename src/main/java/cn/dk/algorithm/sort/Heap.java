package cn.dk.algorithm.sort;

public class Heap {
    /**
     * 使用最大堆的升序堆排序
     * @param intArray
     * @return 比较次数
     */
    public static int heapSortAesc(int[] intArray){
        int sumTimes = 0;
        for (int i = intArray.length/2; i > 0 ; i--) {
            sumTimes += adjustMaxHeap(intArray, i, intArray.length);
        }

        for (int i = intArray.length ; i > 1; i--) {         //此循环的时间复杂度为n*logn，所以整体的时间复杂度为nlogn
            int temp = intArray[i-1];
            intArray[i-1] = intArray[0];
            intArray[0] = temp;                                 // 交换堆顶和未排序数组末尾的元素，这样当前未排序的数组最后一位一定是最大的
            sumTimes += adjustMaxHeap(intArray, 1, i - 1);      //把剩余未排序的数组从头到尾再次调整为一个最大堆
        }
        return sumTimes;
    }

    /**
     * 将对应数组的未排序范围内的元素调整为最大堆
     * @param intArray 待排序的数组
     * @param start 需要调整的结点编号（和数组下标有区别，从1开始）
     * @param end 未排序的最后一个节点编号
     * @return 比较次数
     */
    public static int adjustMaxHeap(int[] intArray, int start, int end){
        int sumTimes = 0;
        int temp = intArray[start - 1];             //暂存需要调整的结点值
        for (int i = 2 * start; i <= end; i *= 2) {     //循环步长为 *=2 ，因为是在循环层级遍历一个二叉树，每次找的都是此结点的两个孩子节点，完全二叉树中结点k(i)的两个孩子为k(2i)和k(2i+1)
            if(i < end && intArray[i - 1] < intArray[i]){
                i ++;
            }
            if(temp >= intArray[i - 1]){
                break;
            }
            intArray[start - 1] = intArray[i - 1];      //将三者（结点本身、左右孩子）的最大值赋值给start父结点
            start = i;                          //start 标明现在节点被交换后应该在哪个下标位置
            sumTimes++;
        }
        intArray[start - 1] = temp;                 //把需要调整的结点值插入最后交换后的位置
        return sumTimes;
    }
}
