package kunal_kuswaha.backtracking;

// import java.util.Arrays;

public class sudoku2 {
    public static void main(String[] args) {
        char[][] board=new char[8][8];
        helper(board,0,0);
    //    for(char[] value:board){
    //     if()

    //    }
        

        
    }
    public void solveSudoku(char[][] board) {
           }
      public static boolean helper(char[][] board, int row, int col) {
          if(row==board.length){
              return true;
          }
         int nrow = 0;
         int ncol = 0;
         if (col != board.length-1) {
             ncol = col + 1;
             nrow = row;
         } else {
             ncol = 0;
             nrow = row + 1;
         }
         if (board[row][col] != '.') {
             if (helper(board, nrow, ncol)) {
                 return true; ////////
             }
         } else {
             for (int i = 1; i <=9; i++) {
                 if (issafe(board, row, col, i)) {
                     board[row][col] = (char) (i + '0');
                     if (helper(board, nrow, ncol)) {
                         return true;
                     } else {
                         board[row][col] = '.';
                     }
 
                 }
             }
         }
         return false; ////////////
     }
 
     public static boolean issafe(char board[][], int row, int col, int num) {
         for (int i = 0; i < board.length; i++) {
             if (board[i][col] == (char) (num + '0')) {
                 return false;
             }
             if (board[row][i] == (char) (num + '0')) {
                 return false;
             }
         }
         int sr = (row / 3) * 3;
         int sc = (col / 3) * 3;
         for (int i = sr; i < sr + 3; i++) {
             for (int k = sc; k < sc + 3; k++) {
                 if (board[i][k] == (char) (num + '0')) {
                     return false;
                 }
             }
         }
         return true;
    }
}
