import java.lang.*;
import java.util.*;

public class Stage1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number in decimal system: ");
        int num = sc.nextInt();
        System.out.print("Enter target base: ");
        int base = sc.nextInt();
        if(base == 8){
            System.out.print("Conversion result: " + Integer.toOctalString(num));
        }
        else if(base == 16){
            System.out.println("Conversion result: " + Integer.toHexString(num));
        }
        else if(base == 2){
            System.out.println("Conversion result: " + Integer.toBinaryString(num));
        }
    }
}
