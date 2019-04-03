package cn.dk.designpattern.factory;

public class ClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare Clam Pizza~");
    }

    @Override
    public void bake() {
        System.out.println("bake Clam Pizza~");
    }

    @Override
    public void cut() {
        System.out.println("cut Clam Pizza~");
    }

    @Override
    public void box() {
        System.out.println("box Clam Pizza~");
    }
}
