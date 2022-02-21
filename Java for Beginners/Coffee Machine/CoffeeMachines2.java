import java.util.Scanner;

public class CoffeeMachines2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("For " + n + " cups of coffee you will need:");
        System.out.println((200 * n) + " ml of water");
        System.out.println((50 * n) + " ml of milk");
        System.out.println((15 * n) + " g of coffee beans");
        sc.close();
    }
}
