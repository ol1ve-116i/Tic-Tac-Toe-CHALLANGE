public class Board {

    public static final int LENGTH = 3;
    public static final int EMPTY = ' ';
    private char[][] matrix = new char[LENGTH][LENGTH];

    public Board() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                matrix[i][j] = ' ';
            }
        }
    }

    public void printMatrix() {  //sirve para imprimir directamente, no necesita un sout en Main
        printHeader();
        for (int i = 0; i < matrix.length; i++){
            System.out.print((i + 1));
            for (int j = 0; j < matrix.length; j++){
                if (getCell(i,j) == EMPTY){
                    System.out.print(" ");
                }else{
                    System.out.print(getCell(i,j));
                }
                System.out.print(matrix[i][j]);
                if (j < 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if ( i < 2){
                System.out.println("---------------");
            }
        }
    }


    public char getCell(int row, int col){
        return matrix[row][col];
    }

    public void setCell (int row, int col, Player player){
        matrix[row][col] = player.getSymbol();
    }


    void printHeader(){
        System.out.print(" ");
        for (int i = 0; i < LENGTH; i++){
            System.out.print(" " + (i + 1) + "   ");
        }
        System.out.println();
    }

    public static boolean checkWin(char[][] matrix, char player) {
        //check Row
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == player && matrix[row][1] == player && matrix[row][2] == player) {
                return true;
            }
        }
        // check Col
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[0][col] == player && matrix[1][col] == player && matrix[2][col] == player) {
                return true;
            }
        }
        // check Diagonal
        if (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player) {
            return true;
        }
        if (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean checkDraw(char[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix.length; col++){
                if(matrix[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
