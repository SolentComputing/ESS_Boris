package ess_solentproperty;

public class Address {
    // Attributes
    protected String line1;
    protected String line2;
    protected String town;
    protected String county;
    protected String country;
    protected String postcode;
    
    // Constructors
    public Address() {
        line1 = "ADDRESS LINE 1";
        line2 = "ADDRESS LINE 2";
        town = "TOWN";
        county = "COUNTY";
        country = "COUNTRY";
        postcode = "POSTCODE";
    }
    
    public Address(String line1, String line2, String town, String county, String country, String postcode) {
        this.line1 = line1;
        this.line2 = line2;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }
    
    // Get methods
    public String getLine1() { return line1; }
    public String getLine2() { return line2; }
    public String getTown() { return town; }
    public String getCounty() { return county; }
    public String getCountry() { return country; }
    public String getPostcode() { return postcode; }
    
    // Set methods
    public void setLine1(String line1) { this.line1 = line1; }
    public void setLine2(String line2) { this.line2 = line2; }
    public void setTown(String town) { this.town = town; }
    public void setCounty(String county) { this.county = county; }
    public void setCountry(String country) { this.country = country; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    
    // Other methods
    @Override
    public String toString() {
        String address =
            line1 + ", " +
            line2 + ", " +
            town + ", " +
            county + ", " +
            country + ", " +
            postcode;
        
        return address;
    }
    
    public String toStringLine() {
        String address =
            line1 + "\n" +
            line2 + "\n" +
            town + "\n" +
            county + "\n" +
            country + "\n" +
            postcode;
        
        return address;
    }
    
    public void print() {
        System.out.println(this.toStringLine());
    }
}
