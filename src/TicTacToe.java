/*
Задача 11.
Напишите класс TicTacToe (крестики-нолики).

В этом классе должны быть следующие методы:

newGame() — ничего не возвращающий метод, должен создать новую игру;
getField() — метод должен вернуть двумерный массив — поле игры;
checkGame() — метод должен определить есть ли победитель в игре, если да, то вернуть X/0 в зависимости от того,
кто победил, если победителя нет, то метод должен вернуть D (ничья), если игра ещё продолжается, то вернуть строку null;
makeMove(int x, int y), принимающий два параметра — ряд и столбик, куда игрок хочет сделать ход. Если ход невозможен
(клетка уже занята), то метод должен вернуть строку вида {Cell x, y is already occupied}. Если же ход возможен, то в
поле следует поставить X или 0 (зависит от того, кто сейчас ходил), и вернуть строку Move completed, если после этого
хода игра не заканчивается. Если же этим ходом победил один из игроков, то метод должен вернуть строку вида {Player X/0
won}. Если же после этого хода свободных клеток не осталось, а победителя нет, то метод должен вернуть Draw. Если игра
уже завершена (выявлен победитель или ничья), но кто-то хочет походить дальше, то метод должен вернуть Game was ended.
Примечание:
Первым всегда ходит игрок X, потом 0.
 */
public class TicTacToe {
    private String[][] field;
    private String symbol;
    private boolean gameIsOnGoing;

    public TicTacToe() {
        this.field = new String[3][3];
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++)
                this.field[i][j] = "-";
        }
        this.symbol = "X";
        this.gameIsOnGoing = true;
    }

    public String[][] getField() {
        return this.field;
    }

    public String checkGame() {
        String check;
        for (int i = 0; i < this.field[0].length; i++) {
            check = checkVert(i);
            if (check.equals("0") || check.equals("X"))
                return check;
        }
        for (int i = 0; i < this.field.length; i++) {
            check = checkHoriz(i);
            if (check.equals("0") || check.equals("X"))
                return check;
        }
        check = checkDiags();
        if (check.equals("0") || check.equals("X"))
            return check;
        check = "D";
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                if (this.field[i][j].equals("-"))
                    check = "0";
            }
        }
        if (check.equals("D"))
            return check;
        return null;
    }
    
    private String checkVert(int number) {
        String ch = this.field[0][number];
        for (int i = 1; i < this.field.length; i++) {
            if (!this.field[i][number].equals(ch)) {
                ch = "n";
                break;
            }
        }
        return ch;
    }
    
    private String checkHoriz(int number) {
        String ch = this.field[number][0];
        for (int i = 1; i < this.field.length; i++) {
            if (!this.field[number][i].equals(ch)) {
                ch = "n";
                break;
            }
        }
        return ch;
    }
    
    private String checkDiags() {
        String ch = this.field[0][0];
        int min = this.field.length;
        boolean isNotSquare = false;
        if (this.field[0].length < min) {
            isNotSquare = true;
        }
        if (isNotSquare)
            return "n";
        else {
            for (int i = 1; i < this.field.length; i++) {
                if (!this.field[i][i].equals(ch)) {
                    ch = "n";
                    break;
                }
            }
            if (ch.equals("n")) {
                ch = this.field[0][this.field[0].length - 1];
                for (int i = 1; i < this.field.length; i++) {
                    if (!this.field[i][this.field.length - 1 - i].equals(ch)) {
                        ch = "n";
                        break;
                    }
                }
            }
        }
        return ch;
    }

    public String makeMove(int x, int y) {
        if (this.gameIsOnGoing) {
            if (this.field[x - 1][y - 1].equals("-")) {
                this.field[x - 1][y - 1] = this.symbol;
                if (this.symbol.equals("X"))
                    this.symbol = "0";
                else
                    this.symbol = "X";
                String winner = this.checkGame();
                if (winner == null) {
                    return "Move completed";
                }
                else if (winner.equals("D")) {
                    gameIsOnGoing = false;
                    return "Draw";
                }
                else {
                    gameIsOnGoing = false;
                    return String.format("Player %s won", winner);
                }
            } else
                return String.format("Cell %d, %d is already occupied", x, y);
        }
            return "Game was ended";
    }

    public void newGame() {
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                this.field[i][j] = "-";
            }
        }
        this.gameIsOnGoing = true;
        this.symbol = "X";
    }
}
