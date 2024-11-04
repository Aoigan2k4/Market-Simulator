public class ItemInventory {
    private String name;
    private int index;
    private double cost;

    private int quantity;

    public ItemInventory() {}

    public ItemInventory(String name, int index, double cost, int quantity){
        this.name = name ;
        this.index = index;
        this.cost = cost ;
        this.quantity = quantity;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }
    public double getCost() {
        return cost;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity){
        this.quantity += quantity;
    }
    public void display(){
        System.out.println(index + ".\tType:\t" + name + "\t$" + cost + "\tQuantity:\t" + quantity);
    }
}
