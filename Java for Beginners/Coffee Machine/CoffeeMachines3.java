import java.util.Scanner;

public class CoffeeMachines3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffee = sc.nextInt();
        int cup = getCups(water, milk, coffee);
        System.out.println("Write how many cups of coffee you will need: ");
        int order = sc.nextInt();
        printOrder(cup, order);
        sc.close();
    }
    
    public static void printOrder(int cup, int order){
        if(cup == order){
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if(cup < order){
            System.out.println("No, I can make only " + (cup) + "cup(s) of coffee");
        }
        else{
            System.out.print("Yes, I can make that amount of coffee (and even " + (cup - order) + "more than that)");
        }
    }
    
    public static int getCups(int water, int milk, int coffee){
        int cup = 0;
        while(!(water < 1 && milk < 1 && coffee < 1)){
            water -= 200;
            milk -= 50;
            coffee -= 15;
            if(water >= 0 && milk >= 0 && coffee >= 0){
                cup++;
            }
        }
        return(cup);
    }
}