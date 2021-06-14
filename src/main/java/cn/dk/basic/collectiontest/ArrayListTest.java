package cn.dk.basic.collectiontest;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {
    public static void main(String[] args){
        List<String> employeeList = new ArrayList<>();
        int size = employeeList.size();
        List<String> employeeVector = new Vector<>();
        employeeList.add("s");
        employeeList.add(2, "s");
        System.out.println(employeeList.size());
    }
}
