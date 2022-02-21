
import java.lang.*;
import java.util.*;

public class Stage2 {
    
    public static void main(String[] args) {
        start();
        
    }
    
    public static void start(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            String str = sc.nextLine();
            if(str.equals("/exit")){
                return;
            }
            else if(str.equals("/to")){
                toDecimal();
            }
            else if(str.equals("/from")){
                fromDecimal();
            }
        }
    }
    
    public static void toDecimal(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source number: ");
        String source = sc.nextLine();
        System.out.print("Enter source base: ");
        int base = sc.nextInt();
        int result = 1;
        if(base == 16){
            result = Integer.parseInt(source, 16);
        }
        else if(base == 8){
            result = Integer.parseInt(source, 8);
        }
        else if(base == 2){
            result = Integer.parseInt(source, 2);
        }
        System.out.println("Conversion to decimal result: " + result + "\n");
    }
    
    public static void fromDecimal(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        int source = sc.nextInt();
        System.out.print("Enter target base: ");
        int target = sc.nextInt();
        String result = "";
        if(target == 16){
            result = Integer.toHexString(source);
        }
        else if(target == 8){
            result = Integer.toOctalString(source);
        }
        else if(target == 2){
            result = Integer.toBinaryString(source);
        }
        System.out.println("Conversion to decimal result: " + result + "\n");
    }
}