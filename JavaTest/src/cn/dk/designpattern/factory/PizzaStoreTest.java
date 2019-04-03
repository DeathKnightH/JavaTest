package cn.dk.designpattern.factory;

import cn.dk.designpattern.factory.pizza.Pizza;
import cn.dk.designpattern.factory.store.ChicagoStylePizzaStore;
import cn.dk.designpattern.factory.store.NewYorkStylePizzaStore;
import cn.dk.designpattern.factory.store.PizzaStore;

public class PizzaStoreTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NewYorkStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("clam");

        pizza = chicagoStore.orderPizza("clam");

    }
}
