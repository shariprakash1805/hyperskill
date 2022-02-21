import java.util.Scanner;

public class CoffeeMachines5{
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
        action();
    }
    
    public static void action(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String str = sc.nextLine();
            if(str.equals("exit")){
                return;
            }
            else if(str.equals("take")){
                take();
            }
            else if(str.equals("fill")){
                fill();
            }
            
            else if(str.equals("buy")){
                buy();
            }
            else if(str.equals("remaining")){
                machineState();
            }
        }
    }
    
    public static void buy(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        if(!(sc.hasNextInt())){
            String st = sc.nextLine();
            return;
        }
        int choice = sc.nextInt();
        if(choice == 1){
            if(isEnough(250, 0, 16)){
                System.out.println("I have enough resources, making you a coffee!\n");
                water -= 250;
                bean -= 16;
                money += 4;
                dcup--;
            }
        }
        else if(choice == 2){
            if(isEnough(250, 0, 16)){
                System.out.println("I have enough resources, making you a coffee!\n");
                water -= 350;
                milk -= 75;
                bean -= 20;
                money += 7;
                dcup--;
            }
        }
        else if(choice == 3){
            if(isEnough(250, 0, 16)){
                System.out.println("I have enough resources, making you a coffee!\n");
                water -= 200;
                milk -= 100;
                bean -= 12;
                money += 6;
                dcup--;
            }
        }
    }
    
    public static boolean isEnough(int wate, int mil, int bea){
        boolean a = true;
        if(water < wate){
            a = false;
            System.out.println("Sorry, not enough water!");
        }
        if(milk < mil){
            a = false;
            System.out.println("Sorry, not enough milk!");
        }
        if(bean < bea){
            a = false;
            System.out.println("Sorry, not enough coffee beans!");
        }
        if(dcup < 1){
            System.out.println("Sorry, not enough disposable cups");
            a = false;
        }
        return(a);
    }
    
    public static void fill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:"); 
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:"); 
        bean += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:"); 
        dcup += sc.nextInt();
    }
    
    public static void take(){
        System.out.println("\nI gave you $" + (money));
        money = 0;
    }
    
    public static void machineState(){
        System.out.println("\nThe coffee machine has:");
        System.out.println((water)+ " ml of water");
        System.out.println((milk) + " ml of milk");
        System.out.println((bean) + " g of coffee beans");
        System.out.println((dcup) + " disposable cups");
        System.out.println("$" +(money)+ " of money"); 
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