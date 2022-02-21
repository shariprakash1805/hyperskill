import java.util.Scanner;

public class CoffeeMachines4{
    public static int water;
    public static int milk;
    public static int bean;
    public static int dcup;
    public static int money;
    
    public static void initialize(){
        water = 400;
        milk = 540;
        bean = 120;
        dcup = 9;
        money = 550;
    }
    
    public static void main(String[] args) {
        initialize();
        machineState();
        action();
        // System.out.println("Write how many ml of water the coffee machine has:");
        // int water = sc.nextInt();
        // System.out.println("Write how many ml of milk the coffee machine has: ");
        // int milk = sc.nextInt();
        // System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        // int coffee = sc.nextInt();
        // int cup = getCups(water, milk, coffee);
        // System.out.println("Write how many cups of coffee you will need: ");
        // int order = sc.nextInt();
        // printOrder(cup, order);
    }
    
    public static void action(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take): ");
        String str = sc.next();
        if(str.equals("take")){
            take();
        }
        else if(str.equals("fill")){
            fill();
        }
        
        else if(str.equals("buy")){
            buy();
        }
        machineState();
        sc.close();
    }
    
    public static void buy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = sc.nextInt();
        if(choice == 1){
            water -= 250;
            bean -= 16;
            money += 4;
            dcup--;
        }
        else if(choice == 2){
            water -= 350;
            milk -= 75;
            bean -= 20;
            money += 7;
            dcup--;
        }
        else if(choice == 3){
            water -= 200;
            milk -= 100;
            bean -= 12;
            money += 6;
            dcup--;
        }
    }
    
    public static void fill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:"); 
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:"); 
        bean += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:"); 
        dcup += sc.nextInt();
    }
    
    public static void take(){
        System.out.println("I gave you $" + (money));
        money = 0;
    }
    
    public static void machineState(){
        System.out.println("\nThe coffee machine has:");
        System.out.println((water)+ " ml of water");
        System.out.println((milk) + " ml of milk");
        System.out.println((bean) + " g of coffee beans");
        System.out.println((dcup) + " disposable cups");
        System.out.println("$" +(money)+ " of money\n"); 
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