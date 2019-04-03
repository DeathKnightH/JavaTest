package cn.dk.designpattern.factory.store;

import cn.dk.designpattern.factory.pizza.*;

public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")){
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("greek")){
            pizza = new ChicagoStyleGreekPizza();
        } else if (type.equals("clam")){
            pizza = new ChicagoStyleClamPizza();
        }
        return pizza;
    }
}
