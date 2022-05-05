/*
Задача 5.
Создайте класс Human со следующими полями:

name (имя, строка);
age (возраст, число);
weight (вес, число);
address (адрес, строка);
work (работа, строка).
Создайте 5 инициализаторов (конструкторов), принимающих:

name, age;
name, address;
name, age, weight;
name, age, work;
age, weight, address, work.
Задача конструктора — создать полноценный объект (сделать его валидным). То есть, если вес неизвестен, то нужно указать
хоть какой-нибудь средний вес, то же касается возраста и имени, а вот адреса и работы может и не быть (равны null).
 */
public class Human {
    String name, address, work;
    int age, weight;


    Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 70;
    }

    Human(String name, String address) {
        this.name = name;
        this.address = address;
        this.age = 30;
        this.weight = 70;
    }

    Human(String name, int age, int weight) {
        this(name, age);
        this.weight = weight;
    }

    Human(String name, int age, String work) {
        this(name, age);
        this.work = work;
    }

    Human(int age, int weight, String address, String work) {
        this("Person", age, weight);
        this.address = address;
        this.work = work;
    }
}
