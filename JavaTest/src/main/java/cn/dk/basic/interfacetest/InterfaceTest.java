package cn.dk.basic.interfacetest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

public class InterfaceTest {
    public static void main(String []args){
        lambdaTest(1000);
    }

    private static void listenerTest(int time){
        ActionListener listerTest = new TimerPrinter();
        Timer t = new Timer(time, listerTest);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit?");
    }

    private static void stringSortTest(){
        String[] names = {"ABCD","BCD","EEEEEE"};
        System.out.println("Origin order:" + Arrays.deepToString(names));
        Arrays.sort(names);
        System.out.println("After sort, order:" + Arrays.deepToString(names));
        Arrays.sort(names, new LengthComparator());
        System.out.println("After comparator, order:" + Arrays.deepToString(names));
    }

    private static void lambdaTest(int time){
        Timer t = new Timer(time, event->System.out.println("lambda,the time is:" + new Date()));
        t.start();
        JOptionPane.showMessageDialog(null, "Quit?");

        String[] names = {"ABCD","BCD","EEEEEE"};
        System.out.println("Origin order:" + Arrays.deepToString(names));
        Arrays.sort(names);
        System.out.println("After sort, order:" + Arrays.deepToString(names));
        Arrays.sort(names, (first, second)-> first.length() - second.length());
        System.out.println("After comparator, order:" + Arrays.deepToString(names));
    }
}
