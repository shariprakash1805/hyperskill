import java.util.Scanner;
public class stage3 {
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
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("| ");
        }
        System.out.println("---------");
        
        if(count(array)){
            System.out.println("Impossible");
        }
        else if(TwoWin(array)){
            System.out.println("Impossible");
        }
        else if(win(array, 'X')){
            System.out.println("X wins");
        }
        else if(win(array, 'O')){
            System.out.println("O wins");
        }
        else if(draw(array)){
            System.out.println("Draw");
        }
        else{
            System.out.println("Game not finished");
        }
    }
    
    public static boolean count(char[][] array){
        int countX=0,countY=0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == 'X')
                    countX++;
                if(array[i][j] == 'O'){
                    countY++;
                }
            }
        }
        if(Math.abs(countX - countY) > 1)
            return true;
        return false;
    }
    
    public static boolean draw(char[][] array){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == 'X' || array[i][j] == 'O'){
                    count++;
                }
            }
        }
        if(count == array.length * array[0].length)
            return true;
        return false;
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
    
    public static boolean TwoWin(char[][] array){
        if(win(array,'X') == true && (win(array,'O') == true)){
            return true;
        }
        return false;
    }
}