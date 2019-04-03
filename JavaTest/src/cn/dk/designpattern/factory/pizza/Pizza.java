package cn.dk.designpattern.factory.pizza;

public abstract class Pizza {
    protected String name;
    protected String size;
    protected String time;
    public void prepare() {
        System.out.println("preparing " + this.name + " Pizza~");
    }

    public void bake() {
        System.out.println("bake " + this.name + " Pizza for " + this.time);
    }

    public void cut() {
        System.out.println("cut Pizza into " + this.size);
    }

    public void box() {
        System.out.println("box " + this.name + " Pizza~");
    }
}
