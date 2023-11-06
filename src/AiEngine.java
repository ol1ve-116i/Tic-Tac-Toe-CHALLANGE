public class AiEngine extends Player {
    public AiEngine() {
        super("AI", 'O');
    }

    public void aiMoveTurn (Board board, Player currentPlayer, AiEngine aiPlayer) {
        if (goForWin(board, aiPlayer)) { //goForwin
            //System.out.println("goforwin");
        } else {
            if (blockPlayer(board, currentPlayer, aiPlayer)) {
               // System.out.println("blockplayer");
            } else {
                if (chooseCenter(board, aiPlayer)) {
                   // System.out.println("choosecenter");
                } else {
                    randomMove(board, aiPlayer);
                      //  System.out.println("randommv");
                    }
                }
            }
        }

    private boolean goForWin(Board board, AiEngine aiPlayer) {
        boolean wasPlayed = false;
        if (aiPlayer.aiRowMove(board, aiPlayer, aiPlayer)){
            wasPlayed = true;
        } else {
            if (aiPlayer.aiColMove(board, aiPlayer, aiPlayer)) {
                wasPlayed = true;
            } else {
                if (aiPlayer.aiPrimaryDiagMove(board, aiPlayer, aiPlayer)) {
                    wasPlayed = true;
                } else {
                    if (aiPlayer.aiSecondDiagMove(board, aiPlayer, aiPlayer)) {
                        wasPlayed = true;
                    }
                }
            }
        }
        return wasPlayed;
    }

    private boolean blockPlayer(Board board, Player humanPlayer, AiEngine aiPlayer) {
        // here aiPlayer searchs if any cell blockable to avoid humanPlayer win
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
        if (aiPlayer.readCell(board,1,1) == board.EMPTY) {
            aiPlayer.setMove(board, aiPlayer, 1,1);
            wasPlayed = true;
        }
        return wasPlayed;
    }

    private void randomMove(Board board, AiEngine aiPlayer) {
        int row;
        int col;
        do {
            row = (int) (Math.random() * board.LENGTH-1);
            col = (int) (Math.random() * board.LENGTH-1);
        } while (aiPlayer.readCell(board, row, col) != board.EMPTY);
        aiPlayer.setMove(board, aiPlayer, row, col);
    }

    private boolean aiRowMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;
        for (int row = 0; row < board.LENGTH; row++) {
            if (board.getCell(row,0) == currentPlayer.getSymbol() && board.getCell(row, 1) == currentPlayer.getSymbol()) {
                if (board.getCell(row,2) == board.EMPTY) {
                    aiPlayer.setMove(board, aiPlayer, row, 2);
                    wasDone = true;
                    //System.out.println("airowmv1");
                    break;
                }
            }
            if (board.getCell(row,1) == currentPlayer.getSymbol() && board.getCell(row, 2) == currentPlayer.getSymbol()) {
                if (board.getCell(row,0) == board.EMPTY) {
                    aiPlayer.setMove(board, aiPlayer, row, 0);
                    //board.setCell(row, 0, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("airowmv2");
                    break;
                }
            }
            if (board.getCell(row,0) == currentPlayer.getSymbol() && board.getCell(row, 2) == currentPlayer.getSymbol()) {
                if (board.getCell(row,1) == board.EMPTY) {
                    aiPlayer.setMove(board,aiPlayer, row, 1);
                    //board.setCell(row, 1, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("airowmv3");
                    break;
                }
            }
        }
        return wasDone;
    }

    private boolean aiColMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        for (int col = 0; col < board.LENGTH; col++) {
            if (board.getCell(0, col) == currentPlayer.getSymbol() && board.getCell(1, col) == currentPlayer.getSymbol()) {
                if (board.getCell(2, col) == board.EMPTY) {
                    aiPlayer.setMove(board, aiPlayer, 2, col);
                    //board.setCell(2, col, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("aicolmv1");
                    break;
                }
            }
            if (board.getCell(1, col) == currentPlayer.getSymbol() && board.getCell(2, col) == currentPlayer.getSymbol()) {
                if (board.getCell(0, col) == board.EMPTY) {
                    aiPlayer.setMove(board, aiPlayer, 0, col);
                    //board.setCell(0, col, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("aicolmv2");
                    break;
                }
            }
            if (board.getCell(0, col) == currentPlayer.getSymbol() && board.getCell(2, col) == currentPlayer.getSymbol()) {
                if (board.getCell(1, col) == board.EMPTY) {
                    aiPlayer.setMove(board, aiPlayer, 1, col);
                    //board.setCell(1, col, aiPlayer.getSymbol());
                    wasDone = true;
                    //System.out.println("aicolmv3");
                    break;
                }
            }
        }
        return wasDone;
    }
    private boolean aiPrimaryDiagMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        if (board.getCell(0,0) == currentPlayer.getSymbol() && board.getCell(1, 1) == currentPlayer.getSymbol()) {
            if (board.getCell(2,2) == board.EMPTY) {
                aiPlayer.setMove(board, aiPlayer,2,2);
                //board.setCell(2, 2, aiPlayer.getSymbol());
                wasDone = true;
                //System.out.println("primdiamv1");
            } else {
                if (board.getCell(1,1) == currentPlayer.getSymbol() && board.getCell(2, 2) == currentPlayer.getSymbol()) {
                    if (board.getCell(0,0) == board.EMPTY) {
                        aiPlayer.setMove(board, aiPlayer, 0, 0);
                        //board.setCell(0, 0, aiPlayer.getSymbol());
                        wasDone = true;
                        //System.out.println("primdiamv2");
                    } else {
                        if (board.getCell(0,0) == currentPlayer.getSymbol() && board.getCell(2, 2) == currentPlayer.getSymbol()) {
                            if (board.getCell(1,1) == board.EMPTY) {
                                aiPlayer.setMove(board, aiPlayer, 1, 1);
                                //board.setCell(1, 1, aiPlayer.getSymbol());
                                wasDone = true;
                                //System.out.println("primdiamv3");
                            }
                        }
                    }
                }
            }

        }
        return wasDone;
    }

    private boolean aiSecondDiagMove (Board board, Player currentPlayer, AiEngine aiPlayer) {
        boolean wasDone = false;

        if (board.getCell(0, 2) == currentPlayer.getSymbol() && board.getCell(1, 1) == currentPlayer.getSymbol()) {
            if (board.getCell(2, 0) == board.EMPTY) {
                aiPlayer.setMove(board, aiPlayer, 2, 0);
                //board.setCell(2, 0, aiPlayer.getSymbol());
                wasDone = true;
                //System.out.println("seconddiamv1");
            } else {
                if (board.getCell(1, 1) == currentPlayer.getSymbol() && board.getCell(2, 0) == currentPlayer.getSymbol()) {
                    if (board.getCell(0, 2) == board.EMPTY) {
                        aiPlayer.setMove(board, aiPlayer, 0, 2);
                        //board.setCell(0, 2, aiPlayer.getSymbol());
                        wasDone = true;
                        //System.out.println("seconddiamv2");
                    //}
                } else {
                    if (board.getCell(0, 2) == currentPlayer.getSymbol() && board.getCell(2, 0) == currentPlayer.getSymbol()) {
                        if (board.getCell(1, 1) == board.EMPTY) {
                            aiPlayer.setMove(board, aiPlayer, 1, 1);
                            //board.setCell(1, 1, aiPlayer.getSymbol());
                            wasDone = true;
                            //System.out.println("seconddiamv3");
                        }
                    }
                }

            }
        }
    }
        return wasDone;
    }
}
