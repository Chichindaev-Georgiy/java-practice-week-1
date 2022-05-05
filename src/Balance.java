/*
Задача 1.
Напишите класс Balance для описания весов с двумя чашами, которые будут балансировать.

В этом классе должны быть следующие методы:

addRight(int n) — добавить на правую чашу (метод ничего не возвращает);
addLeft(int n) — добавить на левую чашу (метод также ничего не возвращает);
getSituation() — метод вернет =, если вес на обеих чашах равен, R — если вес на правой больше, L — на левой больше.
 */
public class Balance {
    private int rightWeight;
    private int leftWeight;

    Balance() {
        rightWeight = 0;
        leftWeight = 0;
    }
    public void addRight(int weight) {
        rightWeight += weight;
    }

    public void addLeft(int weight) {
        leftWeight += weight;
    }

    public char getSituation() {
        if (rightWeight > leftWeight) {
            return 'R';
        } else if(rightWeight < leftWeight) {
            return 'L';
        }
        return '=';
    }
}
