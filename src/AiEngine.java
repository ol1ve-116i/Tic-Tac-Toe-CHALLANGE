//import java.awt.desktop.AboutEvent;

public class AiEngine extends Player {
    private String playerName = "AI";
    private char symbol = 'O';
    private boolean ai = false;
    public AiEngine() {
        super("AI", 'O',true);
    }
    public AiEngine (String playerName,char symbol, Boolean ai) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.ai = ai;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getSymbol() {
        return this.symbol;
    }
    public boolean isAi() {
        return ai;
    }

    public void aiMoveTurn (Board board, Player humanPlayer, AiEngine aiPlayer) {
        if (goForWin(board, aiPlayer, aiPlayer)) { //goForwin
            System.out.println("goforwin");
        } else {
            if (blockPlayer(board, humanPlayer, aiPlayer)) {
                System.out.println("blockplayer");
            } else {
                if (chooseCenter(board, aiPlayer)) {
                    System.out.println("choosecenter");
                } else {
                    randomMove(board, aiPlayer);
                        System.out.println("randommv");
                    }
                }
            }
        }

    private boolean goForWin(Board board, Player humanPlayer, AiEngine aiPlayer) {
        boolean wasPlayed = false;
        if (aiPlayer.aiRowMove(board, humanPlayer, aiPlayer)){
            wasPlayed = true;
        } else {
            if (aiPlayer.aiColMove(board, humanPlayer, aiPlayer)) {
                wasPlayed = true;
            } else {
                if (aiPlayer.aiPrimaryDiagMove(board, humanPlayer, aiPlayer)) {
                    wasPlayed = true;
                } else {
                    if (aiPlayer.aiSecondDiagMove(board, humanPlayer, aiPlayer)) {
                        wasPlayed = true;
                    }
                }
            }
        }
        return wasPlayed;
    }

    private boolean blockPlayer(Board board, Player humanPlayer, AiEngine aiPlayer) {
        // here humanPlayer is equal to aiPlayer
            boolean wasPlayed = false;
            if (aiPlayer.aiRowMove(board, humanPlayer, aiPlayer)){
                wasPlayed = true;
            } else {
                if (aiPlayer.aiColMove(board, humanPlayer, aiPlayer)) {
                    wasPlayed = true;
                } else {
                    if (aiPlayer.aiPrimaryDiagMove(board, humanPlayer, aiPlayer)) {
                        wasPlayed = true;
                    } else {
                        if (aiPlayer.aiSecondDiagMove(board, humanPlayer, aiPlayer)) {
                            wasPlayed = true;
                        }
                    }
                }
            }
        return wasPlayed;
    }

    private boolean chooseCenter(Board board, AiEngine aiPlayer) {
        boolean wasPlayed = false;
        if (board.getCell(1,1) == Board.EMPTY) {
            board.setCell(1, 1, aiPlayer.getSymbol());
            wasPlayed = true;
            //System.out.println("choose center");
        }
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
        //System.out.println("random mv");
    }

    private boolean aiRowMove (Board board, Player humanPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;
        for (int row = 0; row < board.LENGTH; row++) {
            if (board.getCell(row,0) == humanPlayer.getSymbol() && board.getCell(row, 1) == humanPlayer.getSymbol()) {
                if (board.getCell(row,2)!= board.EMPTY) {
                    board.setCell(row, 2, aiPlayer.getSymbol());
                    wasDone = true;
                    System.out.println("airowmv1");
                    break;
                }
            }
            if (board.getCell(row,1) == humanPlayer.getSymbol() && board.getCell(row, 2) == humanPlayer.getSymbol()) {
                if (board.getCell(row,0)!= board.EMPTY) {
                    board.setCell(row, 0, aiPlayer.getSymbol());
                    wasDone = true;
                    System.out.println("airowmv2");
                    break;
                }
            }
            if (board.getCell(row,0) == humanPlayer.getSymbol() && board.getCell(row, 2) == humanPlayer.getSymbol()) {
                if (board.getCell(row,1)!= board.EMPTY) {
                    board.setCell(row, 1, aiPlayer.getSymbol());
                    wasDone = true;
                    System.out.println("airowmv3");
                    break;
                }
            }
        }
        return wasDone;
    }

    private boolean aiColMove (Board board, Player humanPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        for (int col = 0; col < board.LENGTH; col++) {
            if (board.getCell(0, col) == humanPlayer.getSymbol() && board.getCell(1, col) == humanPlayer.getSymbol()) {
                if (board.getCell(2, col)!= board.EMPTY) {
                    board.setCell(2, col, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("aicolmv1");
                    break;
                }
            }
            if (board.getCell(1, col) == humanPlayer.getSymbol() && board.getCell(2, col) == humanPlayer.getSymbol()) {
                if (board.getCell(0, col)!= board.EMPTY) {
                    board.setCell(0, col, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("aicolmv2");
                    break;
                }
            }
            if (board.getCell(0, col) == humanPlayer.getSymbol() && board.getCell(2, col) == humanPlayer.getSymbol()) {
                if (board.getCell(1, col)!= board.EMPTY) {
                    board.setCell(1, col, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("aicolmv3");
                    break;
                }
            }
        }
        return wasDone;
    }
    private boolean aiPrimaryDiagMove (Board board, Player humanPlayer, AiEngine aiPlayer) {
        boolean wasPlayed = false;

        if (board.getCell(0,0) == humanPlayer.getSymbol() && board.getCell(1, 1) == humanPlayer.getSymbol()) {
            if (board.getCell(2,2)!= board.EMPTY) {
                board.setCell(2, 2, aiPlayer.getSymbol());
                wasPlayed = true;
            } else {
                if (board.getCell(1,1) == humanPlayer.getSymbol() && board.getCell(2, 2) == humanPlayer.getSymbol()) {
                    if (board.getCell(0,0)!= board.EMPTY) {
                        board.setCell(0, 0, aiPlayer.getSymbol());
                        wasPlayed = true;
                    } else {
                        if (board.getCell(0,0) == humanPlayer.getSymbol() && board.getCell(2, 2) == humanPlayer.getSymbol()) {
                            if (board.getCell(1,1)!= board.EMPTY) {
                                board.setCell(1, 1, aiPlayer.getSymbol());
                                wasPlayed = true;
                            }
                        }
                    }
                }
            }

        }
        return wasPlayed;
    }

    private boolean aiSecondDiagMove (Board board, Player humanPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        if (board.getCell(0, 2) == humanPlayer.getSymbol() && board.getCell(1, 1) == humanPlayer.getSymbol()) {
            if (board.getCell(2, 0) != board.EMPTY) {
                board.setCell(2, 0, aiPlayer.getSymbol());
                wasDone = true;
            } else {
                if (board.getCell(1, 1) == humanPlayer.getSymbol() && board.getCell(2, 0) == humanPlayer.getSymbol()) {
                    if (board.getCell(0, 2) != board.EMPTY) {
                        board.setCell(0, 2, aiPlayer.getSymbol());
                        wasDone = true;
                    }
                } else {
                    if (board.getCell(0, 2) == humanPlayer.getSymbol() && board.getCell(2, 0) == humanPlayer.getSymbol()) {
                        if (board.getCell(1, 1) != board.EMPTY) {
                            board.setCell(1, 1, aiPlayer.getSymbol());
                            wasDone = true;
                        }
                    }
                }

            }
        }

        return wasDone;
    }
}
