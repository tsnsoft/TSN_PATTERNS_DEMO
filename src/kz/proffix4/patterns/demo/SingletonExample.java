package kz.proffix4.patterns.demo;

/*
 * Паттерн Singleton (Одиночка)
 * Паттерны проектирования - это описание некоторых проблем, возникающих во время объектно-ориентированного 
 * проектирования, а также способов их решения (как практических, так и теоретических). 
 * Иными словами - это примеры правильных подходов к реению типичных задач проектирования.
 * Одним из самых распространенных паттернов является MyFather (Одиночка). 
 * 
 * (!) Фишка паттерна не дать возможности создать несколько экземпляров класса
 */

final class MyFather {

    private static MyFather instance = null;
    private String name; // полезное поле синглтона (имя отца)

    private MyFather() { // Запрет на вызов конструктора извне (private-конструктор)
    }

    public String getName() { // Полезный метод класса
        return name;
    }

    public void setName(String name) { // Полезный метод класса, срабатывает один раз
        if (this.name == null) {
            this.name = name;
        }
    }

    // Метод доступа к классу с первичной инициализацией
    public static synchronized MyFather getInstance() {
        if (instance == null) {
            instance = new MyFather();
        }
        return instance;
    }
}

public class SingletonExample {

    public static void main(String[] args) {
        //MyFather singleton = new MyFather(); // Так нельзя изза защиты синглтона
        MyFather.getInstance().setName("Nikolay");
        MyFather.getInstance().setName("Nikolay2");
        System.out.println(MyFather.getInstance().getName());
    }

}
