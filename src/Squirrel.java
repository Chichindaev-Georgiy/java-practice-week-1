/*
Задача 13.
Все мы знаем, что белочки любят собирать орешки и нести их себе домой (ведь знаем?). Так вот, одной белочке сначала
очень не везло, и она не нашла ни одного орешка, как вдруг, по дороге домой, она увидела много пеньков, на некоторых
лежали орешки. Но некоторые пеньки были кривыми, если белочка прыгнет на такой пенек, то точно потеряет несколько орешков.

Ваша задача — написать программу, которая будет считать, какое максимальное количество орешков белочка сможет донести
до домика, если пропрыгает по всем этим пенькам.

Белочка — не супермен, поэтому прыгать она может либо на каждый пенек, либо через один. Также не обязательно начинать
с первого пенька, можно сразу прыгнуть на второй, то же самое касается и последних двух. Белочка может остановиться и
на предпоследнем пеньке.

Напишите класс Squirrel, в нем должно быть следующее:

поле nuts (массив целых чисел);
конструктор, в который подают массив nuts ( в каждой ячейке которого хранится значение n, если n — положительное, то на пеньке с таким индексом белочка найдет n орешков, если отрицательное, то на этом пеньке белочка потеряет n орешков);
метод getNuts(int index), возвращает число — сколько найдет или потеряет белочка на пеньке с индексом n;
метод maxNuts(), также возвращает число — какое максимальное число орешков белочка донесет до дома.
 */

public class Squirrel {
    private int[] nuts;
    private int maxValue;

    private boolean isValidSequence(boolean[] skips) {
        int numOfSkips = 0;
        for (int i = 0; i < skips.length; i++) {
            if (skips[i]) {
                numOfSkips++;
                if (numOfSkips > 1)
                    return false;
            } else {
                numOfSkips = 0;
            }
        }
        return true;
    }

    public Squirrel(int[] nuts) {
        this.nuts = new int[nuts.length];
        for (int i = 0; i < nuts.length; i++)
            this.nuts[i] = nuts[i];
    }

    public int getNuts(int index) {
        return this.nuts[index];
    }

    public int maxNuts() {
        int result = 0;
        for (int i = 0; i < this.nuts.length; i++) {
            if (this.nuts[i] >= 0) {
                result += this.nuts[i];
            } else {
                boolean[] skipSequence = new boolean[negativeSequenceLength(i)];
                for (int j = 1; j < skipSequence.length; j++) {
                    skipSequence[j] = false;
                }
                int skipLength = (int) Math.pow(2, skipSequence.length);
                int initial = trySequence(skipSequence, i, result);
                for (int j = 0; j < skipLength; j++) {
                    skipSequence = changeSequence(skipSequence);
                    if (isValidSequence(skipSequence)) {
                        int iterationValue = trySequence(skipSequence, i, result);
                        if (iterationValue > initial) {
                            initial = iterationValue;
                        }
                    }
                }
                i += skipSequence.length - 1;
                result = initial;
            }
        }
        return result;
    }

    private int negativeSequenceLength(int i) {
        int result = 0;
        while (i < this.nuts.length && this.nuts[i] < 0) {
            result++;
            i++;
        }
        return result;
    }

    private int acquireNuts(int value, int position) {
        if (value <= (-this.nuts[position])) {
            return 0;
        }
        return value + this.nuts[position];
    }

    private int trySequence(boolean[] sequence, int index, int value) {
        for (int i = 0; i < sequence.length; i++) {
            if (!sequence[i]) {
                value = acquireNuts(value, i + index);
            }
        }
        return value;
    }

    private boolean[] changeSequence(boolean[] oldSequence) {
        boolean[] sequence = new boolean[oldSequence.length];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = oldSequence[i];
        }
        boolean carry = false;
        if (!sequence[0]) {
            sequence[0] = true;
        } else {
            sequence[0] = false;
            carry = true;
        }
        for (int i = 1; i < sequence.length; i++) {
            if (carry) {
                if (sequence[i]) {
                    sequence[i] = false;
                } else {
                    sequence[i] = true;
                    break;
                }
            } else {
                break;
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        Squirrel s1 = new Squirrel(new int[]{2, 5, -3, -1});
        System.out.println(s1.maxNuts());
        Squirrel s2 = new Squirrel(new int[]{1, -2, 3, 1, -1, -4, 2, 3});
        System.out.println(s2.maxNuts());
    }
}
