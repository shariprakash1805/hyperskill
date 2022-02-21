import java.util.*;

public class stage4 {
    
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
        clue(array);
        printArray(array);
        while(n == 0){
            int op = setMine(array);
            n = n - op;
        }
        System.out.println("Congratulations! You found all the mines!");
        sc.close();
    }
    
    public static int setMine(char[][] array){
        Scanner sc = new Scanner(System.in);
        System.out.print("Set/delete mines marks (x and y coordinates): ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(array[--y][--x] == '.'){
            array[y][x] = '*';
            return(1);
        }
        if(array[y][x] == '*'){
            array[y][x] = '.';
        }
        else if(array[y][x] != '.'){
            System.out.println("There is a number here!");
            return(0);
        }
        else if(array[y][x] == 'X'){
            array[y][x] = '*';
            return(-1);
        }
        return (-1);
    }

    public static void clue(char[][] array){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(array[i][j] == 'X'){
                    continue;
                }
                setClue(array, i, j);
            }
        }
    }
    
    public static int getStartI(int i){
        if(i == 0){
            return(i);
        }
        return(i - 1);
    }

    public static int getStartJ(int j){
        if(j == 0){
            return(j);
        }
        return(j - 1);
    }

    public static int getEndI(int i){
        if(i == 8){
            return(i);
        }
        return(i + 1);
    }

    public static int getEndJ(int j){
        if(j == 8){
            return(j);
        }
        return(j + 1);
    }

    public static void setClue(char[][] array, int i, int j){
        int startI = getStartI(i);
        int startJ = getStartJ(j);
        int endI = getEndI(i);
        int endJ = getEndJ(j);
        int count = 0;
        for(int m = startI; m <= endI; m++){
            for(int n = startJ; n <= endJ; n++){
                if(array[m][n] == 'X'){
                    count++;
                }
            }
        }
        if(count != 0){
            array[i][j] = (char)(count + 48);
        }
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
        System.out.println("\n |123456789|");
        System.out.println("-|---------|");
        for(int i = 0; i < 9; i++){
            System.out.print((i+1) + "|");
            for(int j = 0; j < 9; j++){
                if(array[i][j] == 'X'){
                    System.out.print('.');
                }
                else{
                    System.out.print(array[i][j]);
                }
            }
            System.out.println("|");
        }
        System.out.println("-|---------|");
    }
}