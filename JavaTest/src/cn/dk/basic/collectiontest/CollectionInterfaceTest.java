package cn.dk.basic.collectiontest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class CollectionInterfaceTest {
    public static void main(String[] args){
        List<String> nameList = new ArrayList<String>();
        System.out.println("ArrayList RandomAccess:" + (nameList instanceof RandomAccess));

        nameList = new LinkedList<String>();
        System.out.println("LinkedList RandomAccess:" + (nameList instanceof RandomAccess));
    }
}
