public class SeaBoard {
    private final String[][] field;

    public SeaBoard() {
        this.field = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.field[i][j] = ".";
            }
        }
    }

    public String[][] getField() {
        return this.field;
    }

    private boolean checkLeftOf(int line, int column) {
        String checker;
        boolean isHorizontal = false;
        if (column > 0) {
            checker = this.check(line, column - 1);
            if (checker.equals("x")) {
                isHorizontal = true;
                if (line > 0) {
                    this.field[line - 1][column] = "#";
                    this.field[line - 1][column - 1] = "#";
                }
                if (line < 9) {
                    this.field[line + 1][column] = "#";
                    this.field[line + 1][column - 1] = "#";
                }
            }
        }
        return isHorizontal;
    }

    private boolean checkRightOf(int line, int column) {
        String checker;
        boolean isHorizontal = false;
        if (column < 9) {
            checker = this.check(line, column + 1);
            if (checker.equals("x")) {
                isHorizontal = true;
                if (line > 0) {
                    this.field[line - 1][column] = "#";
                    this.field[line - 1][column + 1] = "#";
                }
                if (line < 9) {
                    this.field[line + 1][column] = "#";
                    this.field[line + 1][column + 1] = "#";
                }
            }
        }
        return isHorizontal;
    }

    private boolean checkUpOf(int line, int column) {
        String checker;
        boolean isVertical = false;
        if (line > 0) {
            checker = this.check(line - 1, column);
            if (checker.equals("x")) {
                isVertical = true;
                if (column > 0) {
                    this.field[line][column - 1] = "#";
                    this.field[line - 1][column - 1] = "#";
                }
                if (column < 9) {
                    this.field[line][column + 1] = "#";
                    this.field[line - 1][column + 1] = "#";
                }
            }
        }
        return isVertical;
    }

    private boolean checkDownOf(int line, int column) {
        String checker;
        boolean isVertical = false;
        if (line < 9) {
            checker = this.check(line + 1, column);
            if (checker.equals("x")) {
                isVertical = true;
                if (column > 0) {
                    this.field[line][column - 1] = "#";
                    this.field[line + 1][column - 1] = "#";
                }
                if (column < 9) {
                    this.field[line][column + 1] = "#";
                    this.field[line + 1][column + 1] = "#";
                }
            }
        }
        return isVertical;
    }

    private void checkLeftEnd(int line, int column) {
        int mostLeft;
        mostLeft = column;
        while (mostLeft >= 0 && this.field.equals("x")) {
            mostLeft--;
        }
        if (mostLeft >= 0) {
            this.field[line][mostLeft] = "x";
            if (line > 0) {
                this.field[line - 1][mostLeft] = "x";
            }
            if (line < 9) {
                this.field[line + 1][mostLeft] = "x";
            }
        }
    }

    public void shoot(int line, int column, String issue) {
        if (issue.equals("m"))
            this.field[line][column] = "#";
        if (issue.equals("h") || issue.equals("d")) {
            this.field[line][column] = "x";
            boolean isHorizontal = checkLeftOf(line, column) || checkRightOf(line, column);
            boolean isVertical = checkUpOf(line, column) || checkDownOf(line, column);
            if (isHorizontal) {
                this.checkLeftEnd(line, column);
            }
        }
    }

    public String check(int line, int column) {
        String result = ".";
        if (line < this.field[0].length && column < this.field.length)
            result = this.field[line][column];
        return result;
    }
}
