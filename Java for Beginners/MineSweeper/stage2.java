import java.util.*;

public class stage2 {
    
    public static void initialize(char[][] array){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                array[i][j] = '.';
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] array = new char[9][9];
        initialize(array);
        System.out.print("How many mines do you want on the field? ");
        int n = sc.nextInt();
        mines(array,n);
        printArray(array);
    }
    
    public static void mines(char[][] array, int n){
        int i,j;
        Random rand = new Random();
        while(n != 0){
            i = rand.nextInt(9);
            j = rand.nextInt(9);
            if(array[i][j] == '.'){
                n--;
                array[i][j] = 'X';
            }
        }
    }
    
    public static void printArray(char[][] array){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
