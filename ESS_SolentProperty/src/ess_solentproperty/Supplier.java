package ess_solentproperty;

/**
 * @author Dean Leszman - 1LESZD34
 */
import java.util.ArrayList;

public class Supplier {
    private String id;
    private String name;
    private ArrayList<Item> items;
    private String email;
    private String phone;
    
    public Supplier() {
        id = "SUPPLIER ID";
        name = "SUPPLIER NAME";
        items = new ArrayList<>();
        email = "EMAIL@DOMAIN.COM";
        phone = "+441234567890";
    }
    
    public Supplier(String idIn, String nameIn, ArrayList<Item> itemsIn, String emailIn, String phoneIn) {
        id = idIn;
        name = nameIn;
        items = itemsIn;
        email = emailIn;
        phone = phoneIn;
    }
    
    public String getID() { return id; }
    public String getName() { return name; }
    public ArrayList<Item> getItems() { return items; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    
    public void setID(String idIn) { id = idIn; }
    public void setName(String nameIn) { name = nameIn; }
    public void setItems(ArrayList<Item> itemsIn) { items = itemsIn; }
    public void setEmail(String emailIn) { email = emailIn; }
    public void setPhone(String phoneIn) { phone = phoneIn; }
    
    public void addItem(Item itemIn) { items.add(itemIn); }
    public void removeItem(Item itemIn) { items.remove(itemIn); }
}
