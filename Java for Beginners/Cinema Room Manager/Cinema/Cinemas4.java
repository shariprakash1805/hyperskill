import java.util.*;
public class Cinemas4 {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = sc.nextInt();
        char[][] array = new char[row][col];
        initialize(array); 
        do{
            System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
            choice = sc.nextInt();
            if(choice == 0){
                break;
            }
            else if(choice == 1){
                printArray(array);
            }
            else if(choice == 2){
                System.out.println("\nEnter a row number:");
                int crow = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                int ccol = sc.nextInt();
                getInput(array, crow, ccol);
                System.out.print("\nTicket price: ");
                if(row * col <= 60){
                    System.out.println("$"+ 10);
                }
                else{
                    if((row/2) >= crow)
                        System.out.println("$"+10);
                    else
                        System.out.println("$"+8);
                }  
            }
        } while(true);
        
    }
    
    public static void initialize(char[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j =0; j < array[i].length; j++){
                array[i][j] = 'S';
            }
        }
    }
    
    public static void getInput(char[][] array, int row, int col){
        array[row - 1][col - 1] = 'B';
    }
    
    public static void printArray(char[][] array){
        System.out.println("\nCinema:");
        System.out.print("  ");
        for(int i = 0; i < array[0].length; i++){
            System.out.print((i+1) + " ");
        }
        System.out.println();
        for(int i = 0; i < array.length; i++){
            System.out.print((i+1)+" ");
            for(int j =0; j < array[i].length; j++){
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
    }
    
}