package kz.proffix4.patterns.demo;

/*
 * ПАТТЕРН "СТРАТЕГИЯ" (Strategy)
 * Этот паттерн проектирования известен также под названием Policy. 
 * Суть его состоит в том, чтобы создать несколько моделей поведения (стратегий) для одного объекта
 * и вынести их в отдельные классы. 
 *
 * (!) Хитрость паттерна подсовывать в параметры вместо конкретного класса совместимого интерфейса класса
 */
interface IBattery {

    void power(boolean turn);
}

class NativeBattery implements IBattery {

    @Override
    public void power(boolean turn) {
        System.out.println("Native battery power is " + turn);
    }

}

class CompatibleBattery implements IBattery {

    @Override
    public void power(boolean turn) {
        System.out.println("Compatible battery power is " + turn);
    }
}

class Phone {

    private IBattery battery;

    public Phone(IBattery battery) {
        this.battery = battery;
    }

    public void setBattery(IBattery battery) {
        this.battery = battery;
    }

    public void turnPower(boolean turn) {
        battery.power(turn);
    }
}

/**
 * ПАТТЕРН "СТРАТЕГИЯ"
 *
 */
public class StrategyExample {

    public static void main(String[] args) {
        Phone phone = new Phone(new NativeBattery());
        phone.turnPower(true);
        phone.turnPower(false);
        phone.setBattery(new CompatibleBattery());
        phone.turnPower(true);
        phone.turnPower(false);
    }
}
