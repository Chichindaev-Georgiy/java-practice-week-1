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
