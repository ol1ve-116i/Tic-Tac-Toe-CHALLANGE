import java.awt.desktop.AboutEvent;

public class AiEngine extends Player {


    private Player currentPlayer;
    private String playerName;
    private char symbol;
    private boolean ai;

    public AiEngine (String playerName,char symbol, Boolean ai) {
        super(playerName,symbol,ai);
    }

    /*@Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }
    @Override
    public boolean isAi() {
        return ai;
    }
*/
    //board is checked for NOT_FULL or Winner in Main before any operation

    public void aiMoveTurn (Board board, Player currentPlayer, AiEngine aiPlayer) {
        if (goForWin(board, aiPlayer, aiPlayer)) {
        } else {
            if (blockPlayer(board, currentPlayer, aiPlayer)) {
            } else {
                if (chooseCenter(board, aiPlayer)) {
                }
            }
            randomMove(board, aiPlayer);
        }
    }


    private boolean goForWin(Board board, Player currentPlayer, AiEngine aiPlayer) {
        // here currentPlayer is equal to aiPlayer
        return ((aiPlayer.aiRowMove(board, currentPlayer, aiPlayer)
                || aiPlayer.aiColMove(board, currentPlayer, aiPlayer)
                || aiPlayer.aiPrimaryDiagMove(board, currentPlayer, aiPlayer))
                || aiPlayer.aiSecondDiagMove(board, currentPlayer, aiPlayer));
    }

    private boolean blockPlayer(Board board, Player currentPlayer, AiEngine aiPlayer) {
        // here currentPlayer is equal to aiPlayer
        return ((aiPlayer.aiRowMove(board, currentPlayer, aiPlayer)
                || aiPlayer.aiColMove(board, currentPlayer, aiPlayer)
                || aiPlayer.aiPrimaryDiagMove(board, currentPlayer, aiPlayer))
                || aiPlayer.aiSecondDiagMove(board, currentPlayer, aiPlayer));
    }

    private boolean chooseCenter(Board board, AiEngine aiPlayer) {
        boolean wasPlayed = false;
        board.setCell(1, 1, aiPlayer.getSymbol());
        wasPlayed = true;
        return wasPlayed;
    }

    private void randomMove(Board board, AiEngine aiPlayer) {
        int row;
        int col;
        do {
            row = (int) (Math.random() * board.LENGTH-1);
            col = (int) (Math.random() * board.LENGTH-1);
        } while (board.getCell(row,col) != board.EMPTY);
        board.setCell(row,col,aiPlayer.getSymbol());
    }

    private boolean aiRowMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;
        for (int row = 0; row < board.LENGTH; row++) {
            if (board.getCell(row,0) == currentPlayer.getSymbol() && board.getCell(row, 1) == currentPlayer.getSymbol()) {
                if (board.getCell(row,2)!= board.EMPTY) {
                    board.setCell(row, 2, aiPlayer.getSymbol());
                    wasDone = true;
                }
            }
            if (board.getCell(row,1) == currentPlayer.getSymbol() && board.getCell(row, 2) == currentPlayer.getSymbol()) {
                if (board.getCell(row,0)!= board.EMPTY) {
                    board.setCell(row, 0, aiPlayer.getSymbol());
                    wasDone = true;
                }
            }
            if (board.getCell(row,0) == currentPlayer.getSymbol() && board.getCell(row, 2) == currentPlayer.getSymbol()) {
                if (board.getCell(row,1)!= board.EMPTY) {
                    board.setCell(row, 1, aiPlayer.getSymbol());
                    wasDone = true;
                }
            }
        }
        return wasDone;
    }

    private boolean aiColMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        for (int col = 0; col < board.LENGTH; col++) {
            if (board.getCell(0, col) == currentPlayer.getSymbol() && board.getCell(1, col) == currentPlayer.getSymbol()) {
                if (board.getCell(2, col)!= board.EMPTY) {
                    board.setCell(2, col, aiPlayer.getSymbol());
                    wasDone = true;
                }
            }
            if (board.getCell(1, col) == currentPlayer.getSymbol() && board.getCell(2, col) == currentPlayer.getSymbol()) {
                if (board.getCell(0, col)!= board.EMPTY) {
                    board.setCell(0, col, aiPlayer.getSymbol());
                    wasDone = true;
                }
            }
            if (board.getCell(0, col) == currentPlayer.getSymbol() && board.getCell(2, col) == currentPlayer.getSymbol()) {
                if (board.getCell(1, col)!= board.EMPTY) {
                    board.setCell(1, col, aiPlayer.getSymbol());
                    wasDone = true;
                }
            }
        }
        return wasDone;
    }
    private boolean aiPrimaryDiagMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasPlayed = false;

        if (board.getCell(0,0) == currentPlayer.getSymbol() && board.getCell(1, 1) == currentPlayer.getSymbol()) {
            if (board.getCell(2,2)!= board.EMPTY) {
                board.setCell(2, 2, aiPlayer.getSymbol());
                wasPlayed = true;
            }
        }
        if (board.getCell(1,1) == currentPlayer.getSymbol() && board.getCell(2, 2) == currentPlayer.getSymbol()) {
            if (board.getCell(0,0)!= board.EMPTY) {
                board.setCell(0, 0, aiPlayer.getSymbol());
                wasPlayed = true;
            }
        }
        if (board.getCell(0,0) == currentPlayer.getSymbol() && board.getCell(2, 2) == currentPlayer.getSymbol()) {
            if (board.getCell(1,1)!= board.EMPTY) {
                board.setCell(1, 1, aiPlayer.getSymbol());
                wasPlayed = true;
            }
        }

        return wasPlayed;
    }

    private boolean aiSecondDiagMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        if (board.getCell(0,2) == currentPlayer.getSymbol() && board.getCell(1, 1) == currentPlayer.getSymbol()) {
            if (board.getCell(2,0)!= board.EMPTY) {
                board.setCell(2, 0, aiPlayer.getSymbol());
                wasDone = true;
            }
        }
        if (board.getCell(1,1) == currentPlayer.getSymbol() && board.getCell(2, 0) == currentPlayer.getSymbol()) {
            if (board.getCell(0,2)!= board.EMPTY) {
                board.setCell(0, 2, aiPlayer.getSymbol());
                wasDone = true;
            }
        }
        if (board.getCell(0,2) == currentPlayer.getSymbol() && board.getCell(2, 0) == currentPlayer.getSymbol()) {
            if (board.getCell(1,1)!= board.EMPTY) {
                board.setCell(1, 1, aiPlayer.getSymbol());
                wasDone = true;
            }
        }

        return wasDone;
    }
}
