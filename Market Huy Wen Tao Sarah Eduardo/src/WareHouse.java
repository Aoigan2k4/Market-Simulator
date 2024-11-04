import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private List<ItemInventory> inventory;

    public WareHouse(){
        this.inventory = new ArrayList<>();
    }
    public void WarehouseAdd(ItemInventory item){
        inventory.add(item);
    }

    public List<ItemInventory> getInventory(){
        return inventory;
    }
    public void displayItems(){
        for(ItemInventory items : inventory){
            items.display();
        }
    }
}
