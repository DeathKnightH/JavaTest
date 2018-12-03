package cn.dk.concurrency.unsafe;

/**
 * 可变整数类
 */
public class MutableInteger {
    private int value;

    public int get(){
        return this.value;
    }
    public void set(int value){
        this.value = value;
    }
}
