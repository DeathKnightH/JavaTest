package cn.dk.basic.generictest;


import cn.dk.basic.objecttest.Employee;

import java.util.ArrayList;
import java.util.Collection;

public class GenericArrayTest {
    public static void main(String[] args){
//        checkClass();
//        genericArrayTest();
//        genericArrayListTest();
//        Collection<Pair<String>> table = new ArrayList<>();
//        Pair<String> pair1 = new Pair<>("1","2");
//        Pair<String> pair2 = new Pair<>("DK","PIK");
//        Pair<Integer> pair3 = new Pair<>(1,2);
//        addAll(table,pair1,pair2);
        Pair<String> test = Pair.makePair(String::new);
        System.out.println(test.getFirst().length());
    }

    private static boolean checkClass(){
        Pair<String> a = new Pair<>("dk","dc");
        Pair<Integer> i = new Pair<>(1,2);

        System.out.println(a.getClass());
        System.out.println(i.getClass());
        return a instanceof Pair;
    }
    private static void genericArrayTest(){
        Pair<String>[] stringArr = (Pair<String>[]) new Pair<?>[10];
        Employee e1 = new Employee("DK");
        Employee e2 = new Employee("PPX");
        Pair temp = new Pair<Employee>(e1,e2);
        Pair<String> stringPair = new Pair<>("1","2");
        stringArr[0] = temp;
        stringArr[1] = stringPair;

        stringArr[0].getFirst().length();
    }

    private static void  genericArrayListTest(){
        ArrayList<Pair<String>> stringArray = new ArrayList<>();
        Employee e1 = new Employee("DK");
        Employee e2 = new Employee("PPX");
        Pair<Employee> temp = new Pair(e1,e2);
        Pair<String> stringPair = new Pair<>("1","2");
        stringArray.get(0).getFirst().length();
    }

    public static <T> void addAll(Collection<T> coll, T... ts){
        for(T t:ts){
            coll.add(t);
        }
    }
}
