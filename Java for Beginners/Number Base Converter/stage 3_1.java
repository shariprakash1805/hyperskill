package converter;

import java.lang.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        start();       
    }
    
    public static void start(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        if(!(sc.hasNextInt())){
            String str = sc.next();
            if(str.equals("/exit")){
                return;
            }
        }
        int source = sc.nextInt();
        int dest = sc.nextInt();
        if(source == 10){
            fromDecimal(source, dest);
            return;
        }
        else{
            toDecimal(source, dest);
            return;
        }
    }
    
    public static void fromDecimal(int source, int dest){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter number in base 10 to convert to base "+ dest +" (To go back type /back) ");
            if(!(sc.hasNextInt())){
                String str = sc.next();
                if(str.equals("/back")){
                    start();
                    return;
                }
                return;
            }
            int num = sc.nextInt();
            String result = Integer.toString(num, dest);
            System.out.println("Conversion result: " + result + "\n");
        }
    }
    
    public static void toDecimal(int source, int dest){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter number in base " + source +" to convert to base " + dest + " (To go back type /back) ");
            String num = sc.nextLine();
            if(num.equals("/back")){
                start();
                return;
            }
            int result = Integer.parseInt(num, source);
            if(dest == 10)
                System.out.println("Conversion result: " + result + "\n");
            else{
                String ans = Integer.toString(result, dest);
                System.out.println("Conversion result: " + ans + "\n");
            }
        }
    }
}