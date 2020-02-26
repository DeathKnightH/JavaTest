package cn.dk.basic.variables.array;

public class ArrayTest {
    private static int[] changeValueOfIndex(int[] arr, int index) {
        int[] arrTest = arr;
        if (arrTest.length > index) {
            arrTest[index] = 233;
        }
        return arrTest;
    }

    /**
     * 侧面证明了 Java 参数都是值传递而不是引用传递，这个方法并没有实现数组内容的交换，传入的参数是数组地址这个值而不是引用
     *
     * @param arr1
     * @param arr2
     */
    private static void exchangeArray(int[] arr1, int[] arr2) {
        int[] arrTemp = arr1;
        arr1 = arr2;
        arr2 = arrTemp;
    }

    /**
     * java 语言并不支持数组类型的协变和逆变
     *
     * @param intArr
     */
    private static void arrayType(int[] intArr) {
        Object[] objects = new String[5];
        // 编译无异常，运行报错 java.lang.ArrayStoreException
        objects[0] = 'd';
        objects[1] = "dk";
        // 编译无异常，运行报错 java.lang.ArrayStoreException
        objects[2] = intArr[2];
    }

    public static void main(String[] args) {
        int[] arrayTest1 = {1, 2, 3, 4, 5};
        int[] arrayTest2 = changeValueOfIndex(arrayTest1, 3);
        int[] arrayTest3 = {6, 7, 8, 9, 10};
        System.out.println(arrayTest1[3]);
        System.out.println(arrayTest2[3]);
        System.out.println(arrayTest3[3]);

        exchangeArray(arrayTest1, arrayTest3);

        System.out.println(arrayTest1[3]);
        System.out.println(arrayTest2[3]);
        System.out.println(arrayTest3[3]);

        arrayType(arrayTest1);
    }
}
