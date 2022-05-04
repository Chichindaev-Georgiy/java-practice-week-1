public class LimitingRectangle {
    private int[][] points;
    private int x0, x1, y0, y1;
    private int width, height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public LimitingRectangle(int[][] points) {
        this.points = new int[points.length][];
        if (points.length > 0)
            if (points[0].length > 0) {
                x0 = x1 = points[0][0];
                y0 = y1 = points[0][1];
            }
        for (int i = 0; i < points.length; i++) {
            if (points[i].length == 2) {
                this.points[i] = new int[2];
                this.points[i][0] = points[i][0];
                this.points[i][1] = points[i][1];
                if (this.points[i][0] < x0)
                    this.x0 = points[i][0];
                if (this.points[i][0] > x1)
                    this.x1 = this.points[i][0];
                if (this.points[i][1] < y0)
                    this.y0 = this.points[i][1];
                if (this.points[i][1] > y1)
                    this.y1 = this.points[i][1];
            }
        }
        this.width = x1 - x0;
        this.height = y1 - y0;
    }

    public String getBorders() {
        return String.format("%d, %d, %d, %d", y0, y1, x0, x1);
    }

    public static void main(String[] args) {
        LimitingRectangle r = new LimitingRectangle(new int[][]{{-1, -2}, {3, 4}});
        System.out.println(r.getWidth() + " " + r.getHeight());
        System.out.println(r.getBorders());
    }
}