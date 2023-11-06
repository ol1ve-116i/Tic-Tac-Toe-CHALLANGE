import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        boolean anotherRound = false;
        int roundNum = 1;

        do {
            int gameMode;
            Scanner inputValue = new Scanner(System.in);
            Board board = new Board();
            String p1, p2;
            System.out.println("Welcome to <<TIC-TAC-TOE>> Game!");
            do {
                System.out.print("Select '1' for 2-player VS. or '2' for 1-player VS.AI: ");
                gameMode = inputValue.nextInt();
            } while (gameMode!=1 && gameMode!=2);
            if (gameMode == 1) {
                System.out.println("Loading '2-player' Vs.mode..");
                System.out.print("* type 1st player's name: ");
                p1 = inputValue.next();
                System.out.print("* now 2nd player's name: ");
                p2 = inputValue.next();
                System.out.println("Game STARTS!\n");
            } else {
                System.out.println("Loading 1Vs.AI mode..");
                System.out.print("* type 1st player's name: ");
                p1 = inputValue.next();
                System.out.println("Game STARTS!");
                System.out.println("..Here comes an AI challenger!\n");
                p2 = "AI";
            }
            System.out.println("(- Round n. " + roundNum + " -)");
            Player player1 = new Player(p1, 'X');
            if (gameMode == 1) {
                Player player2 = new Player(p2, 'O');
                versusGame(gameOver, board, player1, player2);
            } else {
                // playerName and symbol values are fixed by default on AiEngine's constructor
                AiEngine aiPlayer = new AiEngine();
                aiGame(gameOver, board, player1, aiPlayer);
            }

            System.out.print("Want another round? (y/n): ");
            anotherRound = (inputValue.next().toLowerCase().charAt(0) == 'y');
            System.out.println();
            roundNum = roundNum + 1;

        } while (gameOver || anotherRound);
    } // END OF MAIN PROGRAM

    private static void versusGame(boolean gameOver, Board board, Player player1, Player player2) {
        int row, col;
        int gameTurn = 0;
        Scanner inputValue = new Scanner(System.in);
        Player currentPlayer = new Player();
        while (!gameOver) {
            boolean checkValues = true;
            board.printMatrix();
            if (gameTurn % 2 == 0) {   // player 'X' turn
                currentPlayer = player1;
            } else { //player 'O' turn
                currentPlayer = player2;
            }
            do { // checking if it is in a correct position and not taken too
                System.out.println("Turn #" + (gameTurn + 1) + ", for player (" + currentPlayer.getPlayerName() + ")");
                System.out.println("* Type [1-3]");
                System.out.print("row: ");
                row = inputValue.nextInt() - 1;
                System.out.print("col: ");
                col = inputValue.nextInt() - 1;
                checkValues = (row >= 0 && row < board.LENGTH && col >= 0 && col < board.LENGTH);


                    if (checkValues) {
                        if (board.getCell(row, col) == Board.EMPTY) {
                            currentPlayer.setMove(board, currentPlayer, row, col);
                            //board.setCell(row, col, currentPlayer.getSymbol());
                            gameTurn = gameTurn + 1;
                        } else {
                            System.out.println("Position just taken, type again!");
                        }
                    } else {
                        System.out.println("Number(s) out the range, type again!");
                    }
                System.out.println("(" + currentPlayer.getPlayerName() + ") moved to (" + (row + 1) + ", " + (col + 1) + ")");
            } while (checkValues && board.getCell(row, col) == Board.EMPTY);


            if (board.checkWin(currentPlayer)) {
                board.printMatrix();
                System.out.println("Player (" + currentPlayer.getPlayerName() + ") wins!");
                gameOver = true;
            } else {
                if (board.checkFull()) {
                    board.printMatrix();
                    System.out.println("Game Draw !!!");
                    gameOver = true;
                }
            }
        }
    } //END OF versusGame

    private static void aiGame(boolean gameOver, Board board, Player humanPlayer, AiEngine aiPlayer) {
        int row, col;
        int gameTurn = 0;
        Scanner inputValue = new Scanner(System.in);
        Player currentPlayer = humanPlayer;
        AiEngine currentAi = aiPlayer;
        while (!gameOver) {
            boolean checkValues = true;
            board.printMatrix();
            if (gameTurn % 2 == 0) {   // player 'X' turn
                do { // checking if it is in a correct position and not taken too
                    System.out.println("Turn #" + (gameTurn + 1) + ", for player (" + currentPlayer.getPlayerName() + ")");
                    System.out.println("* Type [1-3]");
                    System.out.print("row: ");
                    row = inputValue.nextInt() - 1;
                    System.out.print("col: ");
                    col = inputValue.nextInt() - 1;
                    checkValues = (row >= 0 && row < board.LENGTH && col >= 0 && col < board.LENGTH);


                    if (checkValues) {
                        if (board.getCell(row, col) == Board.EMPTY) {
                            currentPlayer.setMove(board, currentPlayer, row, col);
                            //board.setCell(row, col, currentPlayer.getSymbol());
                            gameTurn = gameTurn + 1;
                        } else {
                            System.out.println("Position just taken, type again!");
                        }
                    } else {
                        System.out.println("Number(s) out the range, type again!");
                    }
                    System.out.println("(" + currentPlayer.getPlayerName() + ") moved to (" + (row + 1) + ", " + (col + 1) + ")");
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
                currentAi.aiMoveTurn(board, currentPlayer, currentAi); // the only public method from AiEngine
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
                gameTurn = gameTurn + 1;
            }
        }
    } //END OF aiGame
}