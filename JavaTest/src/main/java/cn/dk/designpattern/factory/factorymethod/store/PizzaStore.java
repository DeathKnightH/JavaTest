package cn.dk.designpattern.factory.factorymethod.store;

import cn.dk.designpattern.factory.factorymethod.pizza.Pizza;

public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza = this.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
