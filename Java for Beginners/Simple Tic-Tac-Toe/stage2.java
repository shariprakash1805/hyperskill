import java.util.Scanner;
public class stage2 {
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
    }
}