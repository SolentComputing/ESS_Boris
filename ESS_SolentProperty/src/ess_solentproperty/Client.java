package ess_solentproperty;

/**
 *
 * @author Fraser Provan
 */
public class Client {
    
    private String title;
    private String username;
    private String password;
    private String name;
    private String mobile;
    private String email;

    public Client(String titleIn, String usernameIn, String passwordIn, String nameIn, String mobileIn, String emailIn) {
        this.title = titleIn;
        this.username = usernameIn;
        this.password = passwordIn;
        this.name = nameIn;
        this.mobile = mobileIn;
        this.email = emailIn;
    }
    
    // Creates String of text fields for List view
    @Override
    public String toString(){
        return "     Title: " + this.title + 
               "     Name: " + this.name + 
               "     Username: " + this.username + 
               "     Password: " + this.password + 
               "     Email: " + this.email +
               "     Mobile: " + this.mobile;
               
    }
}
