package kz.proffix4.patterns.demo;

interface IPrinter {
    IPrinter addText(String txt);
    void print();
}

/**
 * ШАБЛОН ДЕКОРАТОР (англ. Decorator) — структурный шаблон проектирования,
 * предназначенный для динамического подключения дополнительного поведения к
 * объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 * подклассов с целью расширения функциональности.
 *
 */
class Printer implements IPrinter {

    StringBuilder textData = new StringBuilder();

    public Printer(String txt) {
        textData.append(txt);
    }

    public Printer(Printer parent, String txt) {
        textData.append(parent.textData.toString()).append("; ").append(txt);
    }

    @Override
    public IPrinter addText(String txt) {
        return new Printer(this, txt);
    }

    @Override
    public void print() {
        System.out.println(textData.toString());
    }

}

public class DecoratorExample {

    public static void main(String[] args) {
        new Printer("0").addText("11").addText("222").addText("3333").addText("4444").print();
    }
}
