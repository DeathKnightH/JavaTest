package cn.dk.designpattern.factory;

public class PizzaStore {
    private SimplePizzaFactory simplePizzaFactory;
    public PizzaStore (SimplePizzaFactory simplePizzaFactory){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = this.simplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
