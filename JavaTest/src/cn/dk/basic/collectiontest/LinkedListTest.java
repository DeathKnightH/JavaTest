package cn.dk.basic.collectiontest;

import cn.dk.basic.objecttest.Employee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args){
        List<Employee> employeeList = new LinkedList<>();
        Employee e1 = new Employee("DK","1",10);
        Employee e2 = new Employee("PPX","2",20);
        Employee e3 = new Employee("Fair", "3",30);
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        ListIterator employeeIterator = employeeList.listIterator();
        //printIterator(employeeIterator);
        Employee e4 = new Employee("Clear", "4",40);
        employeeIterator.add(e4);
        employeeIterator = employeeList.listIterator();
        printIterator(employeeIterator);
    }

    public static void printIterator(Iterator iterator){
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
