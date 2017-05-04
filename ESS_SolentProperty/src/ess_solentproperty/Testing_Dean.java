package ess_solentproperty;

import java.util.Calendar;

/**
 * @author Dean Leszman - 1LESZD34
 */

public class Testing_Dean {

    public Testing_Dean() {
        //testAccount();
        //testAddress();
        //testBooking();
    }
    
    // Testing the Account class
    public void testAccount() {
        
        System.out.println("\n\n*****     testAccount()     *****");
        
        // Test default constructor
        System.out.println("\n\n** Test default constructor");
        Account account = new Account();
        System.out.println(account.getUsername() + " : " + account.getPassword() + " : " + account.isAdmin());
        
        // Test constructor
        System.out.println("\n\n** Test constructor");
        String username = "User1", password = "Pass123";
        account = new Account(username, password);
        System.out.println(account.getUsername() + " : " + account.getPassword() + " : " + account.isAdmin());
        
        // Test constructor
        System.out.println("\n\n** Test constructor");
        boolean isadmin = true;
        account = new Account(username, password, isadmin);
        System.out.println(account.getUsername() + " : " + account.getPassword() + " : " + account.isAdmin());
        
        
        // Test get methods
        // Already done in constructor stage
        
        // Test set methods
        System.out.println("\n\n** Test set methods");
        account.setUsername("TestSetUser");
        account.setPassword("TestSetPassword");
        account.setAdminStatus(false);
        System.out.println(account.getUsername() + " : " + account.getPassword() + " : " + account.isAdmin());
        
        // Test isValid()
        System.out.println("\n\n** Test isValid()");
        account = new Account();
        Account account2 = new Account("user", "pass");
        System.out.println("Username: " + account.getUsername() + " Valid: "+ account.isValid("username", account.getUsername()));
        System.out.println("Password: " + account.getPassword() + " Valid: "+ account.isValid("password", account.getPassword()));
        
        System.out.println("Username: " + account2.getUsername() + " Valid: "+ account2.isValid("username", account.getUsername()));
        System.out.println("Password: " + account2.getPassword() + " Valid: "+ account2.isValid("password", account2.getPassword()));
        account2.setPassword("\n");
        System.out.println("Password: " + account2.getPassword() + " Valid: "+ account2.isValid("password", account2.getPassword()));
        
    }
 
    // Testing the Address class
    public void testAddress() {
        System.out.println("\n\n*****     testAddress()     *****");
        
        // Test default constructor
        System.out.println("\n\n** Test default constructor");
        Address address = new Address();
        address.print();
        
        // Test constructor
        System.out.println("\n\n** Test constructor");
        String line1 = "Line1Test", line2 = "Line2Test", town = "TownTest", county = "CountyTest", country = "CountryTest", postcode = "PostcodeTest";
        address = new Address(line1, line2, town, county, country, postcode);
        address.print();
        
        // Test get methods
        System.out.println("\n\n** Test get methods");
        address = new Address();
        System.out.println(address.getLine1());
        System.out.println(address.getLine2());
        System.out.println(address.getTown());
        System.out.println(address.getCounty());
        System.out.println(address.getCountry());
        System.out.println(address.getPostcode());
        
        // Test set methods
        System.out.println("\n\n** Test set methods");
        address.setLine1("Line1Test");
        address.setLine2("Line2Test");
        address.setTown("TownTest");
        address.setCounty("CountyTest");
        address.setCountry("CountryTest");
        address.setPostcode("PostcodeTest");
        address.print();
        
        // Test toString()
        System.out.println("\n\n** Test toString()");
        address = new Address();
        System.out.println(address.toString());
        
        // Test toStringLine()
        System.out.println("\n\n** Test toStringLine()");
        System.out.println(address.toStringLine());
        
        // Test print() already done in the class
    }
    
    // Testing the Booking class
    public void testBooking() {
        System.out.println("\n\n*****     testBooking()     *****");
        
        // Test default constructor
        System.out.println("\n\n** Test default constructor");
        Booking booking = new Booking();
        System.out.println(booking.toString());
        
        // Test constructor
        System.out.println("\n\n** Test constructor");
        booking = new Booking(new Address(), "TestService", Calendar.getInstance());
        System.out.println(booking.toString());
        
        // Test constructor
        System.out.println("\n\n** Test constructor");
        booking = new Booking(new Address(), "TestService", 2001, 01, 31, 12, 30);
        System.out.println(booking.toString());
        
        // Test get methods
        System.out.println("\n\n** Test get methods");
        System.out.println(booking.getAddress().toString());
        System.out.println(booking.getService());
        System.out.println(booking.getDateTime());
        
        // Test set methods
        System.out.println("\n\n** Test set methods");
        booking.setAddress(new Address());
        booking.setService("ElectricalTest");
        booking.setDateTime(Calendar.getInstance());
        System.out.println(booking.getAddress().toStringLine());
        System.out.println(booking.getService());
        System.out.println(booking.getDateTime());
        
        // Test other methods
        booking.setYear(1999);
        booking.setMonth(9);
        booking.setDay(9);
        booking.setHour(1);
        booking.setMinute(1);
        booking.printDateTime();
        
        booking.setDate(2010, 10, 10);
        booking.printDateTime();
    }
}
