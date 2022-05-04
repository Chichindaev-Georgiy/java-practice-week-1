public class ToLine {
    private int[][] data;
    private int length;
    public ToLine(int [][] data) {
        this.length = 0;
        this.data = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = new int[data[i].length];
            for (int j = 0; j < data[i].length; j++) {
                this.data[i][j] = data[i][j];
                length++;
            }
        }
    }
    public int[] resize() {
        int[] result = new int[this.length];
        int len = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                result[len] = this.data[i][j];
                len++;
            }
        }
        return result;
    }
}
