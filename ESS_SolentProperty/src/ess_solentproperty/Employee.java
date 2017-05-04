package ess_solentproperty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dean Leszman - 1LESZD34
 */

public class Employee {
    private String id;
    private Account account;
    private String jobTitle;
    private String name;
    private String mobile;
    private String email;
    private String shift;
    
    public Employee() {
        id = "EMPLOYEE ID";
        account = new Account();
        jobTitle = "JOB TITLE";
        name = "EMPLOYEE NAME";
        mobile = "EMPLOYEE MOBILE";
        email = "EMPLOYEE EMAIL";
        shift = "SHIFT TYPE";
    }
    
    public Employee(String idIn, Account accountIn, String jobTitleIn, String nameIn, String mobileIn, String emailIn, String shiftIn) {
        id = idIn;
        account = accountIn;
        jobTitle = jobTitleIn;
        name = nameIn;
        mobile = mobileIn;
        email = emailIn;
        shift = shiftIn;
    }
    
    public String getID() { return id; }
    public String getTitle() { return jobTitle; }
    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email;}
    
    public void setID(String idIn) throws ValidationException { 
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = p.matcher(idIn);
        if (m.matches()) {
            id = idIn;
        } else {
            throw new ValidationException("ID is invalid");
        }
    }
    
    public void setTitle(String titleIn) throws ValidationException {
        Pattern p = Pattern.compile("[A-Z][a-z]+");
        Matcher m = p.matcher(titleIn);
        if (m.matches()) {
            jobTitle = titleIn;
        } else {
            throw new ValidationException("Job Title Invalid");
        }
    }
    
    public void setName(String nameIn) throws ValidationException { 
        Pattern p = Pattern.compile("\\w+ \\w+"); // Two words (e.g. John Johnson, John Doe, Joe Bloggs)
        Matcher m = p.matcher(nameIn);
        if (m.matches()) {
            name = nameIn;
        } else {
            throw new ValidationException("Name is invalid");
        }
    }
    public void setMobile(String mobileIn) throws ValidationException { 
        Pattern p = Pattern.compile("0[0-9]{10}"); // e.g. 01234567890
        Matcher m = p.matcher(mobileIn);
        if (m.matches()) {
            mobile = mobileIn;
        } else {
            throw new ValidationException("Phone is invalid");
        }
    }
    public void setEmail(String emailIn) throws ValidationException { 
        Pattern p = Pattern.compile("([\\w\\.]+)@([\\w\\.]+)\\.(\\w+)"); // e.g. email@domain.com, email.address@domain.com, email@sub.domain.com
        Matcher m = p.matcher(emailIn);
        if (m.matches()) {
            email = emailIn;
        } else {
            throw new ValidationException("Email is invalid");
        }
    }
}
