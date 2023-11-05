import java.util.Scanner;
public class Main9 {
    public static void main(String[] args) {
        boolean gameOver = false;
        int gameTurn = 0;
        int gameMode;
        Scanner inputValue = new Scanner(System.in);
        Board board = new Board();

        System.out.println("Welcome to TICTACTOE Game!");
        System.out.print("Enter (1) for 1vs1, and (2) for 1vsAI: ");
        gameMode = inputValue.nextInt();

        Player player1 = new Player("P1", 'X', false);
        //Player player2 = new Player("P2", 'O', false);
        //AiEngine aiPlayer = new AiEngine();
        if (gameMode == 1) {
            Player player2 = new Player("P2", 'O', false);
            versusGame(gameOver, board, gameTurn, player1, player2, inputValue);
        } else {
            AiEngine aiPlayer = new AiEngine();
            aiGame(gameOver, board, gameTurn, player1, aiPlayer, inputValue);
        }


    }

    private static void versusGame(boolean gameOver, Board board, int gameTurn, Player player1, Player player2, Scanner inputValue) {
        System.out.println("Entering 2 player Vs. mode//");
        Player currentPlayer = new Player();
        gameTurn = 0;
        while (!gameOver) {
            int row, col;
            boolean checkValues = true;
            board.printMatrix();
            if (gameTurn % 2 == 0) {   // player 'X' turn
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            do { // checking if it is in a correct position and not taken too
                System.out.println("Round " + (gameTurn + 1) + "!");
                System.out.println("Player " + currentPlayer.getPlayerName() + ", type number");
                System.out.print("row: ");
                row = inputValue.nextInt() - 1;
                System.out.print("col: ");
                col = inputValue.nextInt() - 1;
                checkValues = (row >= 0 && row <= board.LENGTH && col >= 0 && col <= board.LENGTH);

                if (checkValues) {
                    if (board.getCell(row, col) == Board.EMPTY) {
                        board.setCell(row, col, currentPlayer.getSymbol());
                        gameTurn = gameTurn + 1;
                    } else {
                        System.out.println("Position just taken, type again!");
                    }
                } else {
                    System.out.println("Number(s) out the range, type again!");
                }
            } while (checkValues && board.getCell(row, col) == Board.EMPTY);

            if (board.checkWin(currentPlayer)) {
                board.printMatrix();
                System.out.println("Player " + currentPlayer.getPlayerName() + " wins!");
                gameOver = true;
            } else {
                if (board.checkFull()) {
                    board.printMatrix();
                    System.out.println("Game Draw !!!");
                    gameOver = true;
                }
            }
        }
    }

    private static void aiGame(boolean gameOver, Board board, int gameTurn, Player humanPlayer, AiEngine aiPlayer, Scanner inputValue) {
        System.out.println("Entering Player Vs. AI mode//");
        int row, col;
        gameTurn = 0;
        //int row = 0;
        //int col = 0;
        Player currentPlayer = humanPlayer;
        AiEngine currentAi = aiPlayer;
        while (!gameOver) {
            boolean checkValues = true;
            board.printMatrix();
            if (gameTurn % 2 == 0) {   // player 'X' turn
                do { // checking if it is in a correct position and not taken too
                    System.out.println("Round " + (gameTurn + 1) + "!");
                    System.out.println("Player " + currentPlayer.getPlayerName() + ", type number");
                    System.out.print("col: ");
                    row = inputValue.nextInt() - 1;
                    System.out.print("row: ");
                    col = inputValue.nextInt() - 1;
                    checkValues = (row >= 0 && row <= board.LENGTH && col >= 0 && col <= board.LENGTH);

                    if (checkValues) {
                        if (checkValues) {
                            if (board.getCell(row, col) == Board.EMPTY) {
                                board.setCell(row, col, currentPlayer.getSymbol());
                                gameTurn = gameTurn + 1;
                            } else {
                                System.out.println("Position just taken, type again!");
                            }
                        } else {
                            System.out.println("Number(s) out the range, type again!");
                        }
                    }
                    System.out.println(currentPlayer.getPlayerName() + " moved to (" + row + ", " + col + ")");
                    if (board.checkWin(currentPlayer)) {
                        board.printMatrix();
                        System.out.println("Player " + currentPlayer.getPlayerName() + " wins!");
                        gameOver = true;
                    } else {
                        if (board.checkFull()) {
                            board.printMatrix();
                            System.out.println("Game Draw !!!");
                            gameOver = true;
                        }
                    }
                } while (checkValues && board.getCell(row, col) == Board.EMPTY);

            } else { // AI's turn
                currentAi.aiMoveTurn(board, currentPlayer, currentAi);
                System.out.println(currentAi.getPlayerName() + " played its turn!");
                if (board.checkWin(currentAi)) {
                    board.printMatrix();
                    System.out.println(currentAi.getPlayerName() + " wins!");
                    gameOver = true;
                } else {
                    if (board.checkFull()) {
                        board.printMatrix();
                        System.out.println("Game Draw !!!");
                        gameOver = true;
                    }
                }
                gameTurn = gameTurn +1;
            }

        }
    }
}