class ItemInventoryBuilder {
    private String name ;
    private int index;
    private double cost;
    private int quantity;

    public ItemInventoryBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ItemInventoryBuilder withIndex(int index){
        this.index = index;
        return this;
    }

    public ItemInventoryBuilder withCost(double cost){
        this.cost = cost;
        return this;
    }

    public ItemInventoryBuilder withQuantity(int quantity){
        this.quantity = quantity;
        return this;
    }
    public ItemInventory build(){
        return new ItemInventory(name,index,cost,quantity);
    }



}
