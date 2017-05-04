package ess_solentproperty;

/**
 * @author Dean Leszman - 1LESZD34
 */

public class Subscription {
    protected Address address; // address to be worked at (e.g. 1 Road Lane, Town, Countyshire, AA11 1AA)
    private String day; // day for work to be done
    private String time; // time period for work to be done (e.g. 9am-12pm)
    private String type; // type of work to be done
    
    public Subscription() {
        this.address = new Address();
        this.day = "DAY";
        this.time = "TIME";
        this.type = "TYPE";
    }
    
    public Subscription(Address address, String day, String time, String type) {
        this.address = address;
        this.day = day;
        this.time = time;
        this.type = type;
    }
    
    // Get methods
    public Address getAddress() { return address; }
    public String getDay() { return day; }
    public String getTime() { return time; }
    public String getType() { return type; }
    
    // Set methods
    public void setAddress(Address address) { this.address = address; }
    public void setDay(String day) { this.day = day; }
    public void setTime(String time) { this.time = time; }
    public void setType(String type) { this.type = type; }
    
    // Other methods
    @Override
    public String toString() {
        String message = "";
        message += address.toString();
        message += "  |  " + day + "  |  " + time + "  |   " + type;
        
        return message;
    }
}
