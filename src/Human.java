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
