package cn.dk.basic.objecttest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PolymorphismTest {
    public static void main(String[] args){
        polymorphismArrayTest();
    }

    public static void polymorphismSingleTest(){
        Employee employeeTest1 = new Employee("DK","HEH223", 10, 2017, 12,
                31);
        Employee employeeTest2 = new Manager("pkp", "HEP001", 20, 2000, 2,
                28);

        System.out.println("getClass:" + employeeTest1.getClass());
        System.out.println("getClass:" + employeeTest2.getClass());

        System.out.println("instanceof:" + (employeeTest1 instanceof Employee));
        System.out.println("instanceof:" + (employeeTest2 instanceof Manager));
    }

    public static void polymorphismArrayTest(){
        Employee[] staff = new Employee[3];
        Manager boss = new Manager("boss","Boss01",100, 2000, 1, 1);
        staff[0] = boss;
        staff[1] = new Employee("DK","HEH223", 10, 2017, 12, 31);
        staff[2] = new Manager("pkp", "HEP001", 20, 2000, 2, 28);

        System.out.println(Arrays.deepToString(staff));

        Manager[] managers = new Manager[3];
        //managers[0] = staff[0];//编译报错
        //staff = managers;
        //staff[0] = new Employee("DK","HEH223", 10, 2017, 12, 31);//java.lang.ArrayStoreException
    }
}
