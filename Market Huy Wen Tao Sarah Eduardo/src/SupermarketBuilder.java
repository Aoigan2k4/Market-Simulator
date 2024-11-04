import java.util.ArrayList;
import java.util.List;

public class SupermarketBuilder {

    WareHouse wareHouse;

    public SupermarketBuilder(){
        wareHouse = new WareHouse();
    }
    public void addInventory(ItemInventory item) {
        wareHouse.WarehouseAdd(item);
    }
    public SupermarketMange build(){
        return new SupermarketMange(wareHouse);
    }

}
