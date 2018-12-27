package cn.dk.concurrency.safe;

import com.sun.corba.se.pept.transport.ReaderThread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;

public class FinalStates {

    public static void main(String[] args){
        List<IntValue> objectList = generateIntValueList(1000000);

        final CountDownLatch countDownLatch = new CountDownLatch(objectList.size());
        System.out.println("数量："+objectList.size());
        // LinkedBlockingDeque<IntValue> deque = new LinkedBlockingDeque<IntValue>(objectList);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i< 10; i++) {
            Thread temp = new Thread(() -> {
                while (true){
                    IntValue intObject;
                    synchronized (objectList) {
                        if (objectList.size() > 0) {
                            intObject = objectList.get(0);
                            objectList.remove(0);
                        }else{
                            break;
                        }
                    }
                    if(intObject != null) {
                        String key = intObject.getKey();
                    }

//                        try {
//                            Thread.sleep(4);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    //System.out.println(key);
                    countDownLatch.countDown();
                }
                Thread.yield();
            });
            temp.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("时间:" + (endTime - startTime));
    }

    private static List<IntValue> generateIntValueList(int size){
        List<IntValue> objectList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            objectList.add(new IntValue(i,"0"+i));
        }
        return objectList;
    }
}
class IntValue{
    private Integer value;
    private String key;

    IntValue(Integer value, String key) {
        this.value = value;
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
