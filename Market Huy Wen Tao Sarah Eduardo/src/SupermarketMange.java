import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.ToDoubleFunction;

public class SupermarketMange implements InventoryMange , EmployeeManage{

    private WareHouse wareHouse;
    private int quantitySold;
    private int quantityBuy;
    private double benefits;
    private double spending;
    private long employeeCost;
    private long EmployeePayTime;
    private double total;

    public SupermarketMange(WareHouse warehouse){
        this.wareHouse = warehouse;
        this.quantityBuy = 0;
        this.quantitySold = 0;
        this.benefits = 0 ;
        this.spending = 0 ;
        this.employeeCost = 0 ;
        this.EmployeePayTime = System.currentTimeMillis();
    }
    // The function will be used via the buyInventory of the main
    public String SellItem(ItemInventory selected, int quantity)
    {
        List<ItemInventory> tempItems = wareHouse.getInventory();
        for(ItemInventory item : tempItems){
            String name = item.getName();
            int index = item.getIndex();
            if (name.equals(selected.getName()) || index == selected.getIndex()){
                if (item.getQuantity() < quantity){
                    return "You don't have enough items to sell for this quantity! Please try again...";
                }
                quantitySold += quantity;
                benefits += item.getCost() * quantity;
                item.setQuantity(-quantity);
                return "Item(s) successfully sold!\n You have " + item.getQuantity() + " " + item.getName() + " left.";
            }
        }
        return "Item was not found, please try again...\n";
    }
    // The function will be used via the SellInventory of the main
    public String buyItem(ItemInventory selected, int quantity)
    {
        List<ItemInventory> tempItems = wareHouse.getInventory();
        for(ItemInventory item : tempItems){
            String name = item.getName();
            int index = item.getIndex();
            if (name.equals(selected.getName()) || index == selected.getIndex()){
                quantityBuy += quantity;
                spending += item.getCost() * quantity;
                item.setQuantity(quantity);
                total += item.getCost() + quantity;
                return "Item successfully bought! You have now " + item.getQuantity() + " " + item.getName() + ".";
            }
        }
        return "Item was not found, please try again...\n";
    }
    // Pay employee
    public void employeePay() {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = TimeUnit.MILLISECONDS.toMinutes(currentTime - EmployeePayTime);
        long payment = 2600 * timeElapsed;
        employeeCost += payment;
        total += payment;
        System.out.println("Employees have been paid $" + payment);
        EmployeePayTime = System.currentTimeMillis();
    }
    public WareHouse getWareHouse(){
        return wareHouse;
    }
    // Status display
    public void display(){
        System.out.println(" Current stock:");
        List<ItemInventory> inventory = wareHouse.getInventory();
        for(ItemInventory item : inventory){
            System.out.println(item.getIndex() + ". Type:\t" + item.getName() + "\tQuantity:\t" + item.getQuantity());
        }
        System.out.println("Items Sold:" + quantitySold);
        System.out.println("Items Bought:" +quantityBuy);
        System.out.println("Earnings:" + benefits);
        System.out.println("Cost of all items purchased: " + spending);
        System.out.println("Employee's payment: " + employeeCost);
        System.out.println("Total expenses: " + total);
    }
}
