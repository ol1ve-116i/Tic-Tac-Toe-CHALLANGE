import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        char[][] matrix = new char[Board.LENGTH][Board.LENGTH];
        boolean gameOver = false;
        char player = 'X';
        Scanner inputValue = new Scanner(System.in);

        while (!gameOver) {
            int row, col;
            Board.printMatrix();
            System.out.println("Player " + player + ", enter your move (row and column): ");
            row = inputValue.nextInt() - 1;
            col = inputValue.nextInt() - 1;

            if (row >= 0 && row < Board.LENGTH && col >= 0 && col < Board.LENGTH && matrix[row][col] == ' ') {
                matrix[row][col] = player;
                gameOver = Board.checkWin(matrix, player);
                if (gameOver) {
                    System.out.println("Player " + player + " you win!");
                } else {
                    if (player == 'X') {
                        player = '0';
                    } else {
                        player = 'X';
                    }
                }
                if (!Board.checkWin(matrix, player) && Board.checkDraw(matrix)) {
                    System.out.println("Game Draw !!!");
                    break;
                }
                Board.printMatrix();
            }
        }

    }

}