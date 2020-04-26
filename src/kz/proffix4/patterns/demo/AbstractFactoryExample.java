package kz.proffix4.patterns.demo;

/*
 * Абстрактная фабрика предоставляет интерфейс для создания целых семейств объектов
 * без указания конкретных классов. Объекты каждого семейства должны быть логически связаны между собой. 
 */
interface ICoffeeMachine {
    public ICoffeModule makeCoffee();
    public IChocolateModule makeChocolate();
}

interface ICoffeModule {
    public void makeCappicino();
    public void makeAmericano();
}

interface IChocolateModule {
    public void make();
}

class CoffeModule implements ICoffeModule {

    @Override
    public void makeCappicino() {
        System.out.println("take Cappicino");
    }

    @Override
    public void makeAmericano() {
        System.out.println("take Americano");
    }
}

class ChocolateModule implements IChocolateModule {

    @Override
    public void make() {
        System.out.println("take Chocolate");
    }

}

class CoffeeMachine implements ICoffeeMachine {
    ICoffeModule coffeModule = new CoffeModule();
    IChocolateModule chocolateModule = new ChocolateModule();

    @Override
    public ICoffeModule makeCoffee() {
        return coffeModule;
    }

    @Override
    public IChocolateModule makeChocolate() {
        return chocolateModule;
    }
}

/**
 * ПАТТЕРН "АБСТРАКТНАЯ ФАБРИКА" (Abstract Factory)
 *
 */
public class AbstractFactoryExample {
    public static void main(String[] args) {
        ICoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.makeCoffee().makeCappicino();
        coffeeMachine.makeCoffee().makeAmericano();
        coffeeMachine.makeChocolate().make();
    }
}
