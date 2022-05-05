/*
Задача 12.
Давайте напишем программу-помощник для игры в морской бой. Многие люди часто забывают отмечать клетки, в которые
они стреляли, не закрашивают клетки вокруг потопленных кораблей и так далее. Давайте попробуем реализовать класс
SeaBord, описывающий поле игры.

В этом классе реализуйте:

приватное поле field (поле игры, двумерный массив строка 10 на 10, заполненный точками);
метод getField(), возвращающий двумерный массив строк (10 на 10, поле игры);
метод void shoot(int line, int column, String issue), принимающий в себя координаты на поле (от 0 до 9,
другие числа туда подать не могут) и строку с исходом этого выстрела (m — miss/промах, h — hit/попадание и
d — destroy/уничтожение, гарантируется, что другие буквы туда подать не могут); метод check(int line, int column),
возвращающий . (точку), если в клетку [line][column] еще не стреляли, # — если стреляли, но не попали (или, например,
потопили корабль, а эта клетка соседняя), x — если в этой клетке было попадание.
Примечание:
Поле представляет собой двумерный массив строк 10 на 10. Все клетки, в которые еще не стреляли, — это . (точки).
Попадания и сбитые корабли — это x, а промахи — #.
 */

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

    private void hitLeftEnd(int line, int column) {
        int mostLeft = column;
        while (mostLeft >= 0 && this.field[line][mostLeft].equals("x")) {
            mostLeft--;
        }
        if (mostLeft >= 0) {
            this.field[line][mostLeft] = "#";
            if (line > 0) {
                this.field[line - 1][mostLeft] = "#";
            }
            if (line < 9) {
                this.field[line + 1][mostLeft] = "#";
            }
        }
    }

    private void hitRightEnd(int line, int column) {
        int mostRight = column;
        while (mostRight <= 9 && this.field[line][mostRight].equals("x")) {
            mostRight++;
        }
        if (mostRight <= 9) {
            this.field[line][mostRight] = "#";
            if (line > 0) {
                this.field[line - 1][mostRight] = "#";
            }
            if (line < 9) {
                this.field[line + 1][mostRight] = "#";
            }
        }
    }

    private void hitUpEnd(int line, int column) {
        int mostUp = line;
        while (mostUp >= 0 && this.field[mostUp][column].equals("x")) {
            mostUp--;
        }
        if (mostUp >= 0) {
            this.field[mostUp][column] = "#";
            if (column > 0) {
                this.field[mostUp][column - 1] = "#";
            }
            if (column < 9) {
                this.field[mostUp][column + 1] = "#";
            }
        }
    }

    private void hitDownEnd(int line, int column) {
        int mostDown = line;
        while (mostDown <= 9 && this.field[mostDown][column].equals("x")) {
            mostDown++;
        }
        if (mostDown <= 9) {
            this.field[mostDown][column] = "#";
            if (column > 0) {
                this.field[mostDown][column - 1] = "#";
            }
            if (column < 9) {
                this.field[mostDown][column + 1] = "#";
            }
        }
    }

    private void hitSingle(int line, int column) {
        if (line > 0 && column > 0)
            this.field[line - 1][column - 1] = "#";
        if (line > 0 && column < 9)
            this.field[line - 1][column + 1] = "#";
        if (line < 9 && column > 0)
            this.field[line + 1][column - 1] = "#";
        if (line < 9 && column < 9)
            this.field[line + 1][column + 1] = "#";
        if (line > 0)
            this.field[line - 1][column] = "#";
        if (line < 9)
            this.field[line + 1][column] = "#";
        if (column > 0)
            this.field[line][column - 1] = "#";
        if (column < 9)
            this.field[line][column + 1] = "#";
    }

    public void shoot(int line, int column, String issue) {
        if (issue.equals("m"))
            this.field[line][column] = "#";
        if (issue.equals("h") || issue.equals("d")) {
            this.field[line][column] = "x";
            boolean isHorizontal = checkLeftOf(line, column) || checkRightOf(line, column);
            boolean isVertical = checkUpOf(line, column) || checkDownOf(line, column);
            if (issue.equals("d")) {
                if (isHorizontal) {
                    this.hitLeftEnd(line, column);
                    this.hitRightEnd(line, column);
                }
                if (isVertical) {
                    this.hitUpEnd(line, column);
                    this.hitDownEnd(line, column);
                }
                if (!isHorizontal && !isVertical) {
                    this.hitSingle(line, column);
                }
            }
        }
    }

    public String check(int line, int column) {
        String result = ".";
        if (line < this.field[0].length && column < this.field.length)
            result = this.field[line][column];
        return result;
    }

    public static void main(String[] args) {
        SeaBoard board = new SeaBoard();
        board.shoot(0, 0, "m");
        board.shoot(2, 0, "h");
        board.shoot(6, 9, "h");
        board.shoot(2, 1, "d");
        board.shoot(9, 9, "d");
        board.shoot(5, 5, "h");
        board.shoot(4, 5, "d");
        String[][] field = board.getField();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }
}
