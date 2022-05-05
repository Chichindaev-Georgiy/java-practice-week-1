/*
Задача 3.
Опишите класс Payer. В классе должны быть следующие поля:

surname (фамилия, строка);
name (имя, строка);
address (адрес, строка);
cardNumber (номер карты, строка).
Реализуйте конструктор, принимающий эти параметры (surname, name, address, cardNumber) и метод public toString(),
возвращающий строку вида Payer: surname name, address: address, card: cardNumber.
 */
public class Payer {
    private String surname;
    private String name;
    private String address;
    private String cardName;

    public Payer(String aSurname, String aName, String aAddress, String aCardName) {
        this.surname = aSurname;
        this.name = aName;
        this.address = aAddress;
        this.cardName = aCardName;
    }

    public String toString() {
        return String.format("Payer: %s %s, address: %s, card: %s", this.surname, this.name, this.address, this.cardName);
    }
}
