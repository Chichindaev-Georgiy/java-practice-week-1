public class ToTable {
    private int[] data;
    private int x;
    private int y;
    public ToTable(int[] data, int x, int y) {
        this.x = x;
        this.y = y;
        this.data = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
    }

    public int[][] resize() {
        int[][] result = new int[this.x][this.y];
        for(int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                result[i][j] = data[i * this.y + j];
            }
        }
        return result;
    }
}
