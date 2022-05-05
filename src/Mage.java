/*
Задача 10.
Опишите класс Mage. В нем пропишите:

поле name (имя, строка);
поле level (уровень мага, число);
поле damage (урон, число);
поле type (тип магии, строка, может быть равен fire, ice, earth);
конструктор, инициализирующий данные поля (name, level, damage, type);
метод getInfo(), возвращающий строку вида {name, level, damage, type};
метод fight(Mage mage), этот метод должен вернуть имя мага-победителя. Кто из них победит решается следующем образом:
⚡ Маг огня побеждает мага льда, но проигрывает магу земли.
⚡ Маг льда побеждает мага земли, но проигрывает магу огня.
⚡ Маг земли побеждает мага огня, но проигрывает магу льда.
⚡Если же стихия магов одинаковая, то выигрывает более высокоуровневый маг, если же и уровни одинаковы, то тот, у
которого больший урон, если же и урон одинаковый, то вернуть строку draw (ничья).
 */
public class Mage {
    protected String name;
    protected int level;
    protected int damage;
    protected String type;

    public Mage(String name, int level, int damage, String type) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.type = type;
    }

    public String getInfo() {
        return String.format("{%s, %d, %d, %s}", this.name, this.level, this.damage, this.type);
    }

    private String evenCase(Mage mage) {
        if (mage.level > this.level)
            return mage.name;
        else if (mage.level < this.level)
            return this.name;
        else if (mage.damage > this.damage)
            return mage.name;
        else if (mage.damage < this.damage)
            return this.name;
        return "draw";
    }

    public String fight(Mage mage) {
        switch(this.type) {
            case "fire":
                switch(mage.type) {
                    case "ice":
                        return this.name;
                    case "earth":
                        return mage.name;
                    default:
                        return this.evenCase(mage);
                }
            case "ice":
                switch(mage.type) {
                    case "earth":
                        return this.name;
                    case "fire":
                        return mage.name;
                    default:
                        return this.evenCase(mage);
                }
            case "earth":
                switch(mage.type) {
                    case "fire":
                        return this.name;
                    case "ice":
                        return mage.name;
                    default:
                        return this.evenCase(mage);
                }
        }
        return "error";
    }
}
