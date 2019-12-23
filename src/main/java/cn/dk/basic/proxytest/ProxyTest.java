package cn.dk.basic.proxytest;

import cn.dk.basic.objecttest.Employee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args){
        testCGlibProxy();
    }

    public static void testJDKProxy(){
        Object[] elements = new Object[1000];
        for (int i = 0; i< elements.length; i++){
            Integer value = i + 1;
            InvocationHandler handler = new JDKTraceHandler(value);
            Class[] clazz = value.getClass().getInterfaces();
            Object proxy = Proxy.newProxyInstance(null, clazz, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);
        if (result >= 0){
            System.out.println(elements[result]);
            System.out.println(Proxy.isProxyClass(elements[result].getClass()));
        }
    }

    public static void testCGlibProxy(){
        Object[] elements = new Object[100];
        for (int i = 0; i< elements.length; i++){
            Employee employee = new Employee("DK" + i, String.valueOf(i),i * 100);
            CGlibTraceHandler handler = new CGlibTraceHandler();
            Object proxy = handler.getProxyInstance(Employee.class);

            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length);
        System.out.println(elements[key]);
        System.out.println(Proxy.isProxyClass(elements[key].getClass()));
    }
}
