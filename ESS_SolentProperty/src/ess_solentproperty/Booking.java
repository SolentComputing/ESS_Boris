package ess_solentproperty;

import java.util.Calendar;

/**
 * @author Dean Leszman - 1LESZD34
 */

public class Booking {
    // Attributes
    protected Address address;
    private String service;
    private Calendar datetime;
    
    // Constructors
    public Booking() {
        this.address = new Address();
        this.service = "SERVICE";
        this.datetime = Calendar.getInstance();
    }
    
    public Booking(Address address, String service, Calendar datetime) {
        this.address = address;
        this.service = service;
        this.datetime = datetime;
    }
    
    public Booking(Address address, String service, int year, int month, int day, int hour, int minute) {
        this.address = address;
        this.service = service;
        datetime.set(year, month, day, hour, minute, 0);
    }
    
    // Get methods
    public Address getAddress() { return address; }
    public String getService() { return service; }
    public Calendar getDateTime() { return datetime; }
    
    // Set methods
    public void setAddress(Address address) { this.address = address; }
    public void setService(String service) { this.service = service; }
    public void setDateTime(Calendar datetime) { this.datetime = datetime; }
    
    // Other methods
    public void setYear(int year) { datetime.set(Calendar.YEAR, year); }
    public void setMonth(int month) { datetime.set(Calendar.MONTH, month + 1); } // Months are 0-11
    public void setDay(int day) { datetime.set(Calendar.DAY_OF_MONTH, day); }
    public void setHour(int hour) { datetime.set(Calendar.HOUR, hour); }
    public void setMinute(int minute) { datetime.set(Calendar.MINUTE, minute); }
    
    public void setDate(int year, int month, int day) {
        datetime.set(Calendar.YEAR, year);
        datetime.set(Calendar.MONTH, month);
        datetime.set(Calendar.DAY_OF_MONTH, day);
    }
    
    public void setTime(int hour, int minute) {
        datetime.set(Calendar.HOUR_OF_DAY, hour);
        datetime.set(Calendar.MINUTE, minute);
    }
    
    @Override
    public String toString() {
        int year = datetime.get(Calendar.YEAR);
        int month = datetime.get(Calendar.MONTH);
        int day = datetime.get(Calendar.DAY_OF_MONTH);
        int hour = datetime.get(Calendar.HOUR_OF_DAY);
        int minute = datetime.get(Calendar.MINUTE);
        int second = datetime.get(Calendar.SECOND);
        
        // e.g. 2001/01/31 15:45:00
        String datetimeString = 
                String.format("%04d", year) + "/" + 
                String.format("%02d", month) + "/" +
                String.format("%02d", day) + " " +
                String.format("%02d", hour) + ":" +
                String.format("%02d", minute) + ":" +
                String.format("%02d", second);
        
        return datetimeString;
    }
    
    public void printDateTime() {
        System.out.println(toString()); // Get the string version of the datetime and print it to console
    }
}
