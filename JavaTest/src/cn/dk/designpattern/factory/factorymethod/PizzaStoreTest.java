package cn.dk.designpattern.factory.factorymethod;

import cn.dk.designpattern.factory.factorymethod.pizza.Pizza;
import cn.dk.designpattern.factory.factorymethod.store.ChicagoStylePizzaStore;
import cn.dk.designpattern.factory.factorymethod.store.NewYorkStylePizzaStore;
import cn.dk.designpattern.factory.factorymethod.store.PizzaStore;

public class PizzaStoreTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NewYorkStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("clam");

        pizza = chicagoStore.orderPizza("clam");

    }
}
