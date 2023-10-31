public class Board {
    private char[][] matrix = new char[3][3];



    public Board() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                matrix[i][j] = ' ';
            }
        }
    }


    public void printMatrix() {  //sirve para imprimir directamente, no necesita un sout en Main
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if ( i < 2){
                System.out.println("----------");
            }
        }
    }


    while (Board = ) {

    }

}
