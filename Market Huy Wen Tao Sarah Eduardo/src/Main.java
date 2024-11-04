import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SupermarketBuilder smBuilder = new SupermarketBuilder();
        SupermarketMange supermarketManger = smBuilder.build();
        ItemInventoryBuilder iBuilder = new ItemInventoryBuilder();
        // Hard-coded items
        final ItemInventory item1 = iBuilder.withName("Fruits").withIndex(1).withCost(1.99).withQuantity(100).build();
        final ItemInventory item2 = iBuilder.withName("Dairy products").withIndex(2).withCost(5.99).withQuantity(100).build();
        final ItemInventory item3 = iBuilder.withName("Beverages").withIndex(3).withCost(4.99).withQuantity(100).build();
        final ItemInventory item4 = iBuilder.withName("Vegetables").withIndex(4).withCost(2.99).withQuantity(100).build();
        final ItemInventory item5 = iBuilder.withName("Meats").withIndex(5).withCost(10.99).withQuantity(100).build();
        final ItemInventory item6 = iBuilder.withName("Bakery goods").withIndex(6).withCost(6.99).withQuantity(100).build();
        // Add to inventory via Builder
        smBuilder.addInventory(item1);
        smBuilder.addInventory(item2);
        smBuilder.addInventory(item3);
        smBuilder.addInventory(item4);
        smBuilder.addInventory(item5);
        smBuilder.addInventory(item6);
        //User's selection
        while (true) {
            System.out.println("Please select operation : ");
            System.out.println("1. Sell");
            System.out.println("2. Buy");
            System.out.println("3. Pay employee");
            System.out.println("4. Show current condition");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Item displayed using builder
                    sellInventory(supermarketManger, iBuilder, scanner);
                    break;
                case 2:
                    // Item displayed using builder
                    buyInventory(supermarketManger, iBuilder, scanner);
                    break;
                case 3:
                    supermarketManger.employeePay();
                    break;
                case 4:
                    supermarketManger.display();
                    break;
                case 5:
                    System.out.println("Exit.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Please do it again");
            }
        }
    }
    //The function uses the sellItem along with the Index and Name finder.
    private static void sellInventory(SupermarketMange manager , ItemInventoryBuilder builder, Scanner scanner){
        manager.getWareHouse().displayItems();
        //Name finder
        System.out.println("Please enter the item type: ");
        String itemName = scanner.nextLine();
        //Index finder
        System.out.println("Please enter the item index: ");
        int index = scanner.nextInt();

        System.out.println("Please enter the quantity you would like to sell: ");
        int quantity = scanner.nextInt();

        ItemInventory newItem = builder.withName(itemName).withIndex(index).build();
        System.out.println(manager.SellItem(newItem, quantity));
    }
    //The function uses the buyItem along with the Index and Name finder.
    private static void buyInventory(SupermarketMange manager ,ItemInventoryBuilder builder, Scanner scanner){
        manager.getWareHouse().displayItems();

        System.out.println("Please enter the item name: ");
        String itemName = scanner.nextLine();

        System.out.println("Please Enter the item index: ");
        int index = scanner.nextInt();

        System.out.println("Please enter the quantity you would like to buy: ");
        int quantity = scanner.nextInt();

        ItemInventory newItem = builder.withName(itemName).withIndex(index).build();
        System.out.println(manager.buyItem(newItem, quantity));
    }
}



