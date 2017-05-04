package ess_solentproperty;

/**
 * 
 * @author Denils Kronberg - c1elobear
 */
public class Stock {
    
    private String item;
    private String supplier;
    private String count;

    public Stock (String itemIn, String supplierIn, String countIn) {
        this.item = itemIn;
        this.supplier = supplierIn;
        this.count = countIn;
    }
    
    //Creates String of text fields for List view
    @Override
    public String toString(){
        return  this.item + 
               "__________________________" + this.supplier + 
               "__________________________" + this.count; 
             
    }
}