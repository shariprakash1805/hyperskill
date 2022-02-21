import java.util.*;
public class Cinema {
    static int purchasedTicket;
    static int totalIncome;
    static int currentIncome;
    
    public static void setCinema(int row,int col){
        purchasedTicket = 0;
        currentIncome = 0;
        if(row * col <= 60){
            totalIncome = row * col * 10; 
        }
        else{
            totalIncome = (row/2) * col * 10;
            totalIncome += (row - (row/2)) * col * 8;
        }
    }
    
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = sc.nextInt();
        char[][] array = new char[row][col];
        initialize(array,row,col); 
        do{
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            choice = sc.nextInt();
            if(choice == 0){
                break;
            }
            else if(choice == 1){
                printArray(array);
            }
            else if(choice == 2){
                bookSeat(array, row, col);  
            }
            
            else if(choice == 3){
                statistics(row, col);
            }
        } while(true);
        sc.close();
    }
    
    public static void statistics(int row, int col){
        System.out.println("\nNumber of purchased tickets: "+purchasedTicket);
        System.out.printf("Percentage: %.2f%%\n",(float)((float)purchasedTicket/(float)(row*col)) * 100);
        System.out.println("Current income: "+"$"+currentIncome);
        System.out.println("Total income: "+"$"+totalIncome);
    }
    
    public static void bookSeat(char[][] array, int row, int col){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a row number:");
        int crow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int ccol = sc.nextInt();
        if(row < crow || col < ccol){
            System.out.println("\nWrong input!");
            bookSeat(array, row, col);
        }        
        else if(book(array, crow, ccol)){
            System.out.println("\nThat ticket has already been purchased!\n");
            bookSeat(array, row, col);
        }
        else{
            System.out.print("\nTicket price: ");
            if(row * col <= 60){
                currentIncome += 10;
                System.out.println("$"+ 10);
            }
            else{
                if((row/2) >= crow){
                    currentIncome += 10;
                    System.out.println("$"+10);
                }
                else{
                    System.out.println("$"+8);
                    currentIncome += 8;
                }
            }
            purchasedTicket++;
        }
    }
    
    public static boolean book(char[][] array, int row, int col){
        if(array[row - 1][col - 1] == 'B'){
            return true;
        }
        else{
            array[row - 1][col - 1] = 'B';
            return false;
        }
    }
    
    public static void initialize(char[][] array, int row, int col){
        for(int i = 0; i < array.length; i++){
            for(int j =0; j < array[i].length; j++){
                array[i][j] = 'S';
            }
        }
        setCinema(row, col);
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