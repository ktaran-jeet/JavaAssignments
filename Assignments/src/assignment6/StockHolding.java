package assignment6;

public class StockHolding {
     float  purchaseSharePrice;
     float  currentSharePrice;
     int numberOfShares;
     String companyName;
     
     //CONSTRUCTORS::
     StockHolding(float purchaseSharePrice,float currentSharePrice,int numberOfShares,String companyName) {
    	 this.purchaseSharePrice=purchaseSharePrice;
    	 this.currentSharePrice=currentSharePrice;
    	 this.numberOfShares=numberOfShares;
    	 this.companyName=companyName;
	}
     StockHolding() {
    	 purchaseSharePrice=0.0f;
    	 currentSharePrice=0.0f;
    	 numberOfShares=0;
    	 companyName=null;
	}
     
     ///GETTER METHODS OF INSTANCE VARIABLES
     float getPurchaseSharePrice() {
    	 return purchaseSharePrice;
     }
     float getCurrentSharePrice() {
    	return currentSharePrice;
     }
     int getNumberOfShares() {
    	 return  numberOfShares;
     }
     String getCompanyName() {
    	 return companyName;
     }
    
     ///OTHER METHODS
     float costInDollars() {
    	 return purchaseSharePrice*numberOfShares;
     }
     float valueInDollars() {
    	 return currentSharePrice*numberOfShares;
     }
     
     //DISPLAY FN:
     void display() {
    	 System.out.println("STOCKS:::COMPANY: " + companyName +"  PurchaseSharePrice: " + purchaseSharePrice +" currentSharePrice:" + currentSharePrice+ " NumberOfShares: " + numberOfShares + " costInDollars: " + costInDollars() +"  ValueInDolars:: " + valueInDollars());
     }
     
 
}
