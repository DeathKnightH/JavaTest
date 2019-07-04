package cn.dk.concurrency.unsafe;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class MutablePoint {
    // 这里x,y都是public的，表明这个类不是线程安全的
    public int x,y;
    public MutablePoint(){
        this.x = 0;
        this.y = 0;
    }

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}
