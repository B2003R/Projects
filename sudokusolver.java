import java.util.Random;
import java.util.Scanner;

public class sudokusolver {
    public static void main(String[] args) {
        //  take a puzzle as input
        int sudoku[][] = generatesudoku();
        // printing puzzle
        System.out.println("THE SUDOKU");
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println(" ");
        // 
        // solving sudoku
        solve(sudoku, 0, 0);
        // 
        // printing sudoku
        System.out.println("SOLUTION");
        for(int i= 0 ; i <9 ; i++){
            for(int j =0 ; j<9 ; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println("");
        }
        // validate if it is correct or not
        // if(validation(sudoku)){
        //     System.out.println("Correct");
        // }
        // else{
        //     System.out.println("false");
        // }
    }
    // backtrack function
    public static int solve(int[][] sudoku, int i, int j){
        if(i==8 && j ==9){
            return 1;
        }
        if(j==9){
            i = i+1;
            j=0;
        }
        if(sudoku[i][j] != 0){
            return solve(sudoku, i, j+1);
        }
        if(sudoku[i][j] == 0){
            for(int v= 1 ; v<11 ; v++){
                // System.out.println("post");
                if(v == 10){
                    sudoku[i][j]=0;
                    return 0;
                }
                boolean c = check(sudoku, i, j, v);
                int a  = 0;
                if(c){
                    sudoku[i][j] = v;
                    a = solve(sudoku, i, j+1);
                }
                if(a == 1){
                    return a;
                }
            }
        }
        return 0;
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
        //  checking boxes
        int x = (i/3)*3;
        int y = (j/3)*3;
        int x1 = x +3;
        int y1 = y+3;
        while(x < x1){
            while(y<y1){
                if(sudoku[x][y] == val){
                    return false;
                }
                y++;
            }
            x++;
            y = (j/3)*3;
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
    public static int[][] generatesudoku(){
        Random r = new Random();
        int sudoku[][] = new int[9][9];
        // fixing numbers in the gird
        // fixing number in row
        boolean check[] = new boolean[10];
        for(int i=0 ; i<9 ; i++){
            int n = r.nextInt(10);
            if(!check[n]){
                check[n] = true;
                sudoku[0][i] = n;
            }
        }
        solve(sudoku, 0, 0);
        // we have solved sudoku and now we need to remove numbers
        // removing numbers
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ;j++){
                int n = r.nextInt(2);
                if(n==0){
                    sudoku[i][j] = 0;
                }
            }
        }
        
        return sudoku;
    }
}