package cn.dk.designpattern.factory.store;

import cn.dk.designpattern.factory.pizza.*;

public class NewYorkStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")){
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("greek")){
            pizza = new NYStyleGreekPizza();
        } else if (type.equals("clam")){
            pizza = new NYStyleClamPizza();
        }
        return pizza;
    }
}
