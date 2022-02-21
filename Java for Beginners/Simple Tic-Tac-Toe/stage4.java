import java.lang.*;
import java.util.Scanner;
public class stage4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        int k = 0;
        char[][] array = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                array[i][j] = temp.charAt(k);
                k++;
            }
        }

        printGrid(array);

        if(testCount(array))
            System.out.println("Impossible");

        getUser(array);
        printGrid(array);
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

    public static void getUser(char[][] array){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int x,y;
        try{
            do{
                System.out.print("Enter the coordinates: ");
                x = sc.nextInt();
                y = sc.nextInt();
                if(x <= 3 && x >= 0 && y <= 3 && y >=0){
                    if(array[x-1][y-1] == '_'){
                        array[x-1][y-1] = 'X';
                        flag = false;
                    }
                    else{
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else{
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }while(flag);
        }catch(Exception e){
            System.out.println("You should enter numbers!");
        }
    }


    public static boolean testCount(char[][] array){
        int countX = 0,countO = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(array[i][j] == 'X')
                    countX++;
                else if(array[i][j] == 'O')
                    countO++;
            }
        }

        if(Math.abs(countX - countO) > 1)
            return true;
        return false;
    }

    // public static int test(char[][] a, char ch){

    // }
}