package cn.dk.basic.reflectiontest;

import cn.dk.basic.objecttest.Employee;

public class ReflectClassTest {
    static class test{
        static {System.out.println("Loading inner class test");}
    }
    public static void main(String[] args){
        System.out.println("inside main");
//        classLoadingTest();
        classNameTest();
//        usingClassTest();

    }

    public static void classLoadingTest(){
        System.out.println("inside classLoadingTest method");
        Class clazz = Employee.class;
        new Employee("DK","HEH223", 10, 2017, 12, 31);
        System.out.println("After creating Employee");
        try {
            Class.forName("cn.dk.basic.objecttest.Manager");
        } catch(ClassNotFoundException e) {
            System.out.println("Couldn't find Manager");
        }
        System.out.println("After Class.forName(\"cn.dk.basic.objecttest.Manager\")");
        new test();
        System.out.println("After creating inner class test");
    }

    public static void classNameTest(){
        Employee employee = new Employee("DK","HEH223", 10, 2017, 12,
                31);
        Class employeeCl = employee.getClass();
        System.out.println("getName():" + employeeCl.getName());
        System.out.println("getCanonicalName():" + employeeCl.getCanonicalName());
        System.out.println("getSimpleName():" + employeeCl.getSimpleName());
        System.out.println("getTypeName():" + employeeCl.getTypeName());
        System.out.println("Class.getClass():" + employeeCl.getClass());
        System.out.println("getClass():" + employee.getClass());
        System.out.println("class字面量:" + Employee.class);
        System.out.println(int.class);
        System.out.println(Integer.class);

        System.out.println("getClass()与class字面量比较：" + (employee.getClass() == Employee.class));

    }

    public static void usingClassTest(){
        try {
            Class clazz = Class.forName("cn.dk.basic.objecttest.Manager");
            Employee.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
