package cn.dk.basic.reflectiontest;

import cn.dk.basic.objecttest.Employee;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyArrayTest {

    public static void main(String[] args){
        int[] numbers = {1, 2, 3};
        numbers = (int[])goodCopyOf(numbers, 2);
        System.out.println(Arrays.toString(numbers));

        String[] strings = {"PKP", "MG5", "MG4"};
        strings = (String[]) goodCopyOf(strings,2);
        System.out.println(Arrays.toString(strings));

    }
    public static Object[] badCopyOf(Object[] objects, int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(objects, 0, newArray, 0, Math.min(objects.length,newLength));
        return newArray;
    }

    public static Object goodCopyOf(Object o, int newLength){
        Class clazz = o.getClass();
        if(clazz.isArray()) {
            Class componentType = clazz.getComponentType();
            int length = Array.getLength(o);
            Object newArray = Array.newInstance(componentType, newLength);
            System.arraycopy(o, 0, newArray, 0, Math.min(length, newLength));
            return newArray;
        }else{
            return null;
        }
    }
}
