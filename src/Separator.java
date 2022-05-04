public class Separator {
    int[] array;

    public Separator(int[] array) {
        this.array = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public int[] even() {
        int evenAmount = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] % 2 == 0)
                evenAmount++;
        }
        int[] result = new int[evenAmount];
        int j = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                result[j] = this.array[i];
                j++;
            }
        }
        return result;
    }

    public int[] odd() {
        int oddAmount = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] % 2 == 1)
                oddAmount++;
        }
        int[] result = new int[oddAmount];
        int j = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] % 2 == 1) {
                result[j] = this.array[i];
                j++;
            }
        }
        return result;
    }
}
