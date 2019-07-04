package cn.dk.basic.arraytest;

public class ArrayTest {
    private static int[] changeValueOfIndex(int[] arr, int index){
        int[] arrTest = arr;
        if(arrTest.length>index){
            arrTest[index] = 233;
        }
        return arrTest;
    }

    private static void exchangeArray(int[] arr1, int[] arr2){
        int[] arrTemp = arr1;
        arr1 = arr2;
        arr2 = arrTemp;
    }
    public static void main(String[] args){
        int[] arrayTest1 = {1,2,3,4,5};
        int[] arrayTest2 = changeValueOfIndex(arrayTest1,3);
        int[] arrayTest3 = {6,7,8,9,10};
        System.out.println(arrayTest1[3]);
        System.out.println(arrayTest2[3]);
        System.out.println(arrayTest3[3]);

        exchangeArray(arrayTest1,arrayTest3);

        System.out.println(arrayTest1[3]);
        System.out.println(arrayTest2[3]);
        System.out.println(arrayTest3[3]);
    }
}
