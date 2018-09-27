package assignment6;

public class ForeignStockHolding  extends StockHolding{
	//New variable:
	float conversionRate;
	
	
	 //CONSTRUCTORS::
    ForeignStockHolding(float purchaseSharePrice,float currentSharePrice,int numberOfShares,String companyName,float conversionRate) {
    	
    	//passing values to superclass::
    	super(purchaseSharePrice,currentSharePrice,numberOfShares,companyName);
    	this.conversionRate=conversionRate;
    	
	}
    
    //default constructor::
    ForeignStockHolding() {
   	   super();
   	   this.conversionRate=1.0f;
	}
	
    //print function to display the values in subclass::
    void print() {
   	 System.out.println("STOCKS:::COMPANY: " + companyName +"  PurchaseSharePrice: " + purchaseSharePrice +" currentSharePrice:" + currentSharePrice+ " NumberOfShares: " + numberOfShares + " costInDollars: " + costInDollars() +"  ValueInDolars:: " + valueInDollars()+ "Conversion Rate::" + conversionRate);
    }
    
    
    ///overidden methods of superclass::
	  float costInDollars() {
	    	 return purchaseSharePrice*numberOfShares*conversionRate;
	     }
	  
	     float valueInDollars() {
	    	 return currentSharePrice*numberOfShares*conversionRate;
	     }
	 
}
