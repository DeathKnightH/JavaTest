package cn.dk.basic.reflectiontest;

import cn.dk.basic.objecttest.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethodsTest {

    public static void main(String[] args){
        Employee e = new Employee("PKP","123",1000);
        try {
            Method getSalary = Employee.class.getMethod("getSalary");
            double salary = (Double) getSalary.invoke(e);
            System.out.println(salary);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }

        try {
            Method getDamageTotal = ReflectMethodsTest.class.getMethod("getDamageTotal", double.class, double.class, double.class);
            double damage = (Double) getDamageTotal.invoke(null,2100,3, 0.4);
            System.out.println("Damage:" + damage);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }
    public static double getDamageTotal(double base, double crits, double defenceRate) throws Exception {
        if (defenceRate > 1 || defenceRate < 0){
            throw new Exception();
        }
        return base * crits * (1 - defenceRate);
    }
}
