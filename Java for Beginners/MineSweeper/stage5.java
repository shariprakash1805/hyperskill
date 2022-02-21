import java.util.*;

public class stage5 {
    
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
        printArray(array);
        mines(array,n);
        setFree(array, n);
        sc.close();
    }
    
    
    public static void setFree(char[][] array, int n){
        Scanner sc = new Scanner(System.in);
        int x, y;
        String str;
        while(n != 0){
            System.out.print("Set/unset mines marks or claim a cell as free: ");
            x = sc.nextInt();
            y = sc.nextInt();
            str = sc.next();
            
            if(isMine(array, x, y, str)){
                return;
            }

            else if(isCovered(array)){
                printMineArray(array);
                System.out.println("Congratulations! You found all the mines!");
                return;
            }

            else if(str.equals("mine") && array[y-1][x-1] == 'X'){
                array[y-1][x-1] = '$';
                n--;
            }

            else if(str.equals("mine")){
                if(array[y-1][x-1] == '.'){
                    array[y-1][x-1] = '*';
                }
                else if(array[y-1][x-1] == '*'){
                    array[y-1][x-1] = '.';
                }
                else if(array[y-1][x-1] == '$'){
                    array[y-1][x-1] = 'X';
                }
            }

            else if(str.equals("free")){
                setNumber(array, x, y);
            }

            printMineArray(array);
            
        }
        System.out.println("Congratulations! You found all the mines!");
    }

    public static void setNumber(char[][] array, int x, int y){
        int startI = getStartI(y - 1);
        int startJ = getStartJ(x - 1);
        int endI = getEndI(y - 1);
        int endJ = getEndJ(x - 1);
        int count = 0;
        for(int m = startI; m <= endI; m++){
            for(int n = startJ; n <= endJ; n++){
                if(array[m][n] == 'X'){
                    count++;
                }
            }
        }
        if(count != 0){
            array[y-1][x-1] = (char)(count + 48);
            return;
        }
        else if(count == 0){
            array[y-1][x-1] = '/';
            isPossible(array, x, y);
            for(int m = startI; m <= endI; m++){
                for(int n = startJ; n <= endJ; n++){
                    isPossible(array, n + 1, m + 1);
                    if(array[m][n] == '.' ){
                        setNumber(array, n + 1, m + 1);
                    }
                }
            }
        }
    }

    public static void isPossible(char[][] array, int x, int y){
        int startI = getStartI(y - 1);
        int startJ = getStartJ(x - 1);
        int endI = getEndI(y - 1);
        int endJ = getEndJ(x - 1);

        for(int m = startI; m <= endI; m++){
            for(int n = startJ; n <= endJ; n++){
                if(array[m][n] == '*' || array[m][n] == '.' || array[m][n] == '$'){
                    setNumber(array, n + 1, m + 1);
                }
            }
        }
    }

    public static boolean isCovered(char[][] array){
        int count = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(array[i][j] == '.'){
                    continue;
                }
                else{
                    count++;
                }
            }
        }
        if(count == 81){
            return(true);
        }
        return(false);
    }
    
    public static boolean isMine(char[][] array, int x, int y, String str){
        if(array[y - 1][x - 1] == 'X' && str.equals("free")){
            printArray(array);
            System.out.println("You stepped on a mine and failed!");
            return(true);
        }
        return(false);
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
    
    public static void printMineArray(char[][] array){
        System.out.println("\n |123456789|");
        System.out.println("-|---------|");
        for(int i = 0; i < 9; i++){
            System.out.print((i+1) + "|");
            for(int j = 0; j < 9; j++){
                if(array[i][j] == '$'){
                    System.out.print('*');
                }
                else if(array[i][j] == 'X'){
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
    
    public static void printArray(char[][] array){
        System.out.println("\n |123456789|");
        System.out.println("-|---------|");
        for(int i = 0; i < 9; i++){
            System.out.print((i+1) + "|");
            for(int j = 0; j < 9; j++){
                if(array[i][j] == '$'){
                    System.out.print('*');
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