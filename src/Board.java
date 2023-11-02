public class Board {

    public static final int LENGTH = 3;
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
                if (getCell(i,j) == ' '){
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


    void printHeader(){
        System.out.print(" ");
        for (int i = 0; i < LENGTH; i++){
            System.out.print(" " + (i + 1) + "   ");
        }
        System.out.println();
    }
}
