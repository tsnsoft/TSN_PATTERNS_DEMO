package kz.proffix4.patterns.demo;

/*
 * Паттерн "Abstract Factory"
 * Абстрактная фабрика предоставляет интерфейс для создания целых семейств объектов
 * без указания конкретных классов. Объекты каждого семейства должны быть логически связаны между собой. 
 *
 * (!) Фишка в использовании интерфейсов в интерфейсах в структуре классов
 */
interface ICoffeeMachine {
    public ICoffeModule coffee();
    public IChocolateModule chocolate();
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
        System.out.println("Take your Cappicino");
    }
    @Override
    public void makeAmericano() {
        System.out.println("Take your Americano");
    }
}

class ChocolateModule implements IChocolateModule {
    @Override
    public void make() {
        System.out.println("Take your Chocolate");
    }
}

class CoffeeMachine implements ICoffeeMachine {
    ICoffeModule coffeModule = new CoffeModule();
    IChocolateModule chocolateModule = new ChocolateModule();

    @Override
    public ICoffeModule coffee() {
        return coffeModule;
    }

    @Override
    public IChocolateModule chocolate() {
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
        coffeeMachine.coffee().makeCappicino();
        coffeeMachine.coffee().makeAmericano();
        coffeeMachine.chocolate().make();
    }
}
