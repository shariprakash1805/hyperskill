import java.util.*;
public class Cinemas2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for(int i = 0; i < 7; i++){
            System.out.print((i+1)+" ");
            for(int j = 0; j < 8; j++){
                System.out.print("S ");
            }
            System.out.println();
        }
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = sc.nextInt();
        System.out.println("Total income:");
        if(row * col <= 50){
            System.out.println("$"+(row*col*10));
        }
        else{
            System.out.println("$"+(((row/2)*col*10)+((row - (row/2))*col*8)));
        }
        
        
    }
}