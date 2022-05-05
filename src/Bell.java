/*
Задача 2.
Напишите класс Bell, имеющий всего один метод sound, если он был вызван, то метод должен напечатать в консоль ding
или dong. Первый звук всегда ding, второй — dong, третий — снова ding и так далее.
 */
public class Bell {
    private static boolean isDing = true;
    public void sound() {
        if (isDing) {
            System.out.println("ding");
            isDing = false;
        } else {
            System.out.println("dong");
            isDing = true;
        }
    }
}
