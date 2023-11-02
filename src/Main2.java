import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        boolean gameActive = true;
        char currentPlayer = 'X';
        Scanner inputValue = new Scanner(System.in);


        while (gameActive) {
            int row, col;
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = inputValue.nextInt() - 1;
            col = inputValue.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                Board.printMatrix();
                if (checkRowWin == true) {
                    System.out.println(currentPlayer + "you win!");
                    gameActive = false;
                } else if (checkColWin == true) {
                    System.out.println(currentPlayer + "you win!");
                    gameActive = false;
                } else {
                    System.out.println("It's a draw");
                }
            } else {
                System.out.println("Invalid move. Enter again row and column: ");
            }
            currentPlayer = currentPlayer ? 'X' : '0';
        }

        public boolean isValidMove(int row, int col){
            return row >= 0 && row < board.LENGTH && col >= 0 && col < board.LENGTH && board[row][col] == EMPTY;
        }

        public boolean checkRowWin(int row, char player) {
            for (int i = 0; i < board.LENGTH; i++) {
                if (board[row][i] == player) {
                    return true;
                }
            }
            return false;
        }
        public boolean checkColWin(int col, char player) {
            for (int i = 0; i < board.LENGTH; i++) {
                if (board[i][col] == player) {
                    return true;
                }
            }
            return false;
        }
        public boolean checkDiagonalWin(int row, int col, char player){
            for (int row = 0; row < board.LENGTH; row++) {
                for (int col = 0; col < board.LENGTH; col++) {
                    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                        return true;
                    }
                }
            }
            return false;

            for (int col = 2; col >= board.LENGTH; col--) {
                for (int row = 2; row >= board.LENGTH; row--) {
                    if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean checkDraw() {
            for (int row = 0; row < board.LENGTH; row++) {
                for (int col = 0; col < board.LENGTH; col++) {
                    if (board[row][col] == board.EMPTY) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

