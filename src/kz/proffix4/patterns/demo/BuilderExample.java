package kz.proffix4.patterns.demo;

/*
Если класс содержит большое количество конструкторов, то возникает проблема
- трудно запомнить порядок параметров при вызове класса. 
В таких случаях рекомендуется использовать шаблон Builder.

(!) Хитрость в использовании вложенного статического класса с доступом к классу-родителю
 */
class Person {

    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;

    public static class Builder {

        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder withName(String name) {
            person.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            person.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            person.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            person.weight = weight;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", height=" + height + ", weight=" + weight + '}';
    }

}

public class BuilderExample {

    public static void main(String[] args) {
        Person myPerson = new Person.Builder()
                .withName("Alex")
                .withSurname("Gebs")
                .withAge(32)
                .withHeight(165)
                .withWeight(70)
                .build();
        System.out.println(myPerson);
    }
}
