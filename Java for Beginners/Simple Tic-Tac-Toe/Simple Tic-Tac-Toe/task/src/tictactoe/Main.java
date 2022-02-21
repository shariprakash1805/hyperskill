package tictactoe;
import java.lang.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int k = 0;
        char[][] array = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        printGrid(array);
        getInput(array);

    }

    public static int getInput(char[][] array){
        // Scanner sc = new Scanner(System.in);
        char[] player = {'X','O'};
        // int x,y;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                ExceptionCase(array,i,j);
                printGrid(array);
                if(win(array, player[(i+j) % 2])){
                    System.out.println(player[(i+j) % 2] +" wins");
                    return(0);
                }
                else if(draw(array)){
                    System.out.println("Draw");
                    return 0;
                }
            }
        }
        return 0;
    }

    public static boolean draw(char[][] array){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(array[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean win(char[][] array, char ch){
        boolean flag;
        for(int i = 0; i < array.length; i++){
            flag = true;
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] != ch){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                return flag;
        }

        for(int i = 0; i < array.length; i++){
            flag = true;
            for(int j = 0; j < array[i].length; j++){
                if(array[j][i] != ch){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                return flag;
        }
        flag = true;
        for(int i = 0; i < array.length; i++){
            if(array[i][i] != ch){
                flag = false;
                break;
            }
        }
        if(flag == true)
            return flag;

        flag = true;
        for(int i = 0; i < array.length; i++){
            if(array[i][array.length - 1 -i] != ch){
                flag = false;
                break;
            }
        }
        if(flag == true)
            return flag;
        return false;
    }

    public static void ExceptionCase(char[][] array, int i, int j){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int x,y;
        char[] player = {'X','O'};
        while(flag){
            try{
                System.out.print("Enter the coordinates: ");
                x = sc.nextInt();
                y = sc.nextInt();
                if(x > 0 && x <= 3 && y > 0 && y <= 3){
                    if(array[x-1][y-1] == ' '){
                        flag = false;
                        array[x-1][y-1] = player[(i+j) % 2];
                    }
                    else{
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else{
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }catch(Exception e){
                System.out.println("You should enter numbers!");
                ExceptionCase(array,i,j);
                flag = false;
            }
        }
    }

    public static void printGrid(char[][] array){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("| ");
        }
        System.out.println("---------");
    }
}
