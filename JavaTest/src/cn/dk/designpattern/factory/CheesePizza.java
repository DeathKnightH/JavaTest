package cn.dk.designpattern.factory;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare Cheese Pizza~");
    }

    @Override
    public void bake() {
        System.out.println("bake Cheese Pizza~");
    }

    @Override
    public void cut() {
        System.out.println("cut Cheese Pizza~");
    }

    @Override
    public void box() {
        System.out.println("box Cheese Pizza~");
    }
}
