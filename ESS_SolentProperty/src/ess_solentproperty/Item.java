package ess_solentproperty;

/**
 * @author Dean Leszman - 1LESZD34
 */
class Item {
    private String id;
    private String name;
    private int quantity;
    private float price;
    
    public Item() {
        id = "ITEM ID";
        name = "ITEM NAME";
        quantity = 0;
        price = 0;
    }
    
    public Item(String idIn, String nameIn, int quantityIn, float priceIn) {
        id = idIn;
        name = nameIn;
        quantity = quantityIn;
        price = priceIn;
    }
    
    /*
        Get Methods
    */
    public String getID() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public float getPrice() { return price; }
    
    /*
        Set methods
    */
    public void setID(String idIn) { id = idIn; }
    public void setName(String nameIn) { name = nameIn; }
    public void setQuantity(int quantityIn) { quantity = quantityIn; }
    public void setPrice(float priceIn) { price = priceIn; }
    
    /*
        Other methods
    */
    public void add(int amount) { quantity += amount; }
    public boolean sell(int amount) { 
        if (quantity - amount >= 0) {
            quantity -= amount;
            return true;
        } else {
            return false;
        }
    }
}
