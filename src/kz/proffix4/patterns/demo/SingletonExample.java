package kz.proffix4.patterns.demo;

/*
 * Паттерны проектирования - это описание некоторых проблем, возникающих во время объектно-ориентированного 
 * проектирования, а также способов их решения (как практических, так и теоретических). 
 * Иными словами - это примеры правильных подходов к реению типичных задач проектирования.
 * Одним из самых распространенных паттернов является MyFather (Одиночка). 
 * Задача этого паттерна ограничить количество экземпляров некоторого класса. 
 */
/**
 * Паттерн MyFather (Одиночка)
 *
 */
final class MyFather {

    private static MyFather instance = null;

    private MyFather() { // Запрет на вызов конструктора извне (private-конструктор)
    }

    public String getName() { // Полезный метод класса
        return "Nikolay";
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
        System.out.println(MyFather.getInstance().getName());
    }

}
