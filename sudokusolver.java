import java.util.Scanner;

public class sudokusolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  take a puzzle as input
        int sudoku[][] = new int[9][9];
        for(int i =0 ; i<9; i++){
            for(int j=0; j <9 ; j++){
                sudoku[i][j] = sc.nextInt();
            }
        }
        //  input done
        solve(sudoku, 0, 0);
        // 
        // printing sudoku
        for(int i= 0 ; i <9 ; i++){
            for(int j =0 ; j<9 ; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println("");
        }
        // validate if it is correct or not
        if(validation(sudoku)){
            System.out.println("Correct");
        }
        else{
            System.out.println("false");
        }
    }
    // backtrack function
    public static void solve(int[][] sudoku, int i, int j){
        if(i==8 && j ==9){
            return;
        }
        if(j==9){
            i = i+1;
            j=0;
        }
        if(sudoku[i][j] != 0){
            solve(sudoku, i, j+1);
        }
        if(sudoku[i][j] == 0){
            for(int v= 1 ; v<10 ; v++){
                // System.out.println("post");
                if(check(sudoku,i,j,v)){
                    sudoku[i][j] = v;
                    solve(sudoku, i, j+1);
                } 
            }
        }
        return;
    }
    public static boolean check(int[][] sudoku, int i , int j, int v){
        int val = v;
        // check row
        for(int x =0 ; x<9 ; x++){
            if(val == sudoku[i][x]){
                return false;
            }
        }
        // System.out.println("post");
        // check cols
        for(int x =0 ; x<9 ; x++){
            if(val == sudoku[x][j]){
                return false;
            }
        }
        return true;
    }
    public static boolean validation(int[][] sudoku){
        for(int i=0 ; i<9 ; i++){
            for(int j =0 ; j<9 ; j++){
                // cheking
                int val = sudoku[i][j];
                // check row
                for(int x =0 ; x<9 ; x++){
                    if(x!= j && val == sudoku[i][x]){
                        return false;
                    }
                }
                // System.out.println("post");
                // check cols
                for(int x =0 ; x<9 ; x++){
                    if(x != i && val == sudoku[x][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
