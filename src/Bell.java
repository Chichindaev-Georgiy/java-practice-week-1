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
