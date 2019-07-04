package cn.dk.basic.generictest;

import cn.dk.basic.generictest.Pair;

import javax.swing.*;
import java.util.Arrays;

public class GenericTest {
    public static void main(String[] args){
       String[] words = {"abc","abcd","bcd","bcde","cde","cd"};
//        Pair<String> result = minmax(words);
//        System.out.println("Max:" + result.getSecond());
//        System.out.println("Min:" + result.getFirst());
        System.out.println("Middle of:" + Arrays.deepToString(words) + "is:" + getMiddle(words));

        Integer[] intValues = {1,2,3,4,5};
        System.out.println("Middle of:" + Arrays.deepToString(intValues) + "is:" + getMiddle(intValues));

        Double[] doubleValues = {1.1, 2.2, 3.3, 4.0};
        System.out.println("Middle of:" + Arrays.deepToString(doubleValues) + "is:" + getMiddle(doubleValues));


        System.out.println("middle test:" + getMiddle(1.2222,0,"test",null));
    }

    /**
     * 测试泛型类Pair
     * @param a
     * @return
     */
    private static  <T extends Comparable> Pair<T> minmax(T[] a){
        if(a == null || a.length ==0){
            return null;
        }
        T min = a[0];
        T max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0){
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    /**
     * 测试泛型方法
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... arr){
        return arr[arr.length/2];
    }
}
