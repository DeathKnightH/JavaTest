package cn.dk.designpattern.factory;

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare Greek Pizza~");
    }

    @Override
    public void bake() {
        System.out.println("bake Greek Pizza~");
    }

    @Override
    public void cut() {
        System.out.println("cut Greek Pizza~");
    }

    @Override
    public void box() {
        System.out.println("box Greek Pizza~");
    }
}
