package ess_solentproperty;

/**
 * @author Dean Leszman - 1LESZD34
 */

public class User {
    // Attributes
    protected Account account;
    protected Address address;
    
    // Constructor
    public User() {
        this.account = new Account();
        this.address = new Address();
    }
    
    public User(Account account, Address address) {
        this.account = account;
        this.address = address;
    }
    
    
    public Account getAccount() { return account; }
    public Address getAddress() { return address; }
}
