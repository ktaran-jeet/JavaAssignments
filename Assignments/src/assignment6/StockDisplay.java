package assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StockDisplay {
	
	
	//SORTING USING COMPARATOR IN ALPHABETICAL ORDER::
    public static Comparator<StockHolding> CompanyNameComparator = new Comparator<StockHolding>() {

		public int compare(StockHolding s1, StockHolding s2) {
		   String CompanyName1 = s1.getCompanyName().toUpperCase();
		   String CompanyName2 = s2.getCompanyName().toUpperCase();

		   //ascending order
		    return CompanyName1.compareTo(CompanyName2);
		    
	    }};
	
	    
	  //SORTING USING COMPARATOR IN REVERSE ALPHABETICAL ORDER::
	    public static Comparator<StockHolding> ReverseCompanyNameComparator = new Comparator<StockHolding>() {

			public int compare(StockHolding s1, StockHolding s2) {
			   String CompanyName1 = s1.getCompanyName().toUpperCase();
			   String CompanyName2 = s2.getCompanyName().toUpperCase();

			   //descending order
			    return CompanyName2.compareTo(CompanyName1);
			    
		    }};
	  
		    
		    
		 //DISPLAY THE MIN. VALUE OF STOCK:traversE the array to find the MIN value stock   
		    static void minValueStock (ForeignStockHolding array[])
		    {
				ForeignStockHolding temp = array[0];
				for(int i=1; i<array.length; i++)
				{
					if(temp.valueInDollars() > array[i].valueInDollars())
						temp = array[i];
				}
				temp.print();
			}
		    
		    
		    
		  //DISPLAY THE MAX. VALUE OF STOCK:traverse the array to find the MAX value stock
		    static void maxValueStock (ForeignStockHolding array[])
			{
				ForeignStockHolding temp = array[0];
				for(int i=1; i<array.length; i++)
				{
					if(temp.valueInDollars() < array[i].valueInDollars())
						temp = array[i];
				}
				temp.print();
			}
		    
		    
		    
		  //DISPLAY THE MIN. VALUE OF PROFITABLE STOCK:traverse the array to find the Min value of profitable stock
		    static void minProfitableStock(ForeignStockHolding array[])
		    {
				ForeignStockHolding temp = array[0];
				for(int i=1; i<array.length; i++)
				{
					if((temp.valueInDollars()-temp.costInDollars()) > (array[i].valueInDollars()-array[i].costInDollars()))
					temp = array[i];
				}
				temp.print();
			}
		    
		    
		    //DISPLAY THE MAX. VALUE OF PROFITABLE STOCK:traverse the array to find the Max value of profitable stock  
		    static void maxProfitableStock(ForeignStockHolding array[])
			{
				ForeignStockHolding temp = array[0];
				for(int i=1; i<array.length; i++)
				{
					if((temp.valueInDollars()-temp.costInDollars()) < (array[i].valueInDollars()-array[i].costInDollars()))
					    temp = array[i];
				}
				temp.print();
			}
		    
		    
		    ///DISPLAY THE ELEMENTS IN ASCENDING ORDER ACCORDING TO COMPANY NAME::
		    static void displayAscending(StockHolding array[])
			{
			for(int i=0; i<array.length; i++)
			{		StockHolding temp;
					for(int j=i+1; j<array.length; j++)
					{
						if((array[j].companyName.compareTo(array[i].companyName)) < 0)
						{
							temp = array[j];
							array[j]=array[i];
							array[i]=temp;
						}
					}
				}
				System.out.println("Display of stock in Ascending order by Company name : ");
				for(int i=0; i<array.length; i++)
					array[i].display();
				
			}
		    
		    
		    
		  ///DISPLAY THE ELEMENTS IN SORTED ORDER ACCORDING TO COMPANY VALUE::
		    static void displayInSortedValueOrder (ForeignStockHolding array[])
			{
				for(int i=0; i<array.length; i++)
				{
					ForeignStockHolding temp;
					for(int j=i+1; j<array.length; j++)
					{
						if(array[j].valueInDollars() < array[i].valueInDollars())
						{
							temp = array[j];
							array[j]=array[i];
							array[i]=temp;
						}
					}
				}
				System.out.println("Display of stock in ascending order by value : ");
				for(int i=0; i<array.length; i++)
				array[i].print();		
			}
			

		    
		    
		public static void main(String[] args) {

	    	 ArrayList<StockHolding> arr=new ArrayList<StockHolding>();
	    	 arr.add(new StockHolding(2.30f,4.50f,40,"companya"));
	    	 arr.add(new StockHolding(3.30f,5.50f,40,"companyc"));
	    	 arr.add(new StockHolding(4.30f,4.90f,40,"companyb"));
	    	
	    	 
	    	 Collections.sort(arr,CompanyNameComparator);
	    	
	    	 
	    	 for(StockHolding stock:arr) {
	    		 stock.display();
	    	 }
	    	 
	    	 
	    	 StockHolding s1=new ForeignStockHolding(6.30f,0.50f,10,"companyh",2.0f);
	    	 StockHolding s2=new ForeignStockHolding(6.50f,0.80f,60,"companyp",1.0f);
	    	 
	    	 arr.add(s1);
	    	 arr.add(s2);
	    	 
	    	 
	    	 Collections.sort(arr,ReverseCompanyNameComparator);
	    	 
	    	 System.out.print("\n\nReverse alphabetical order::::::\n");
	    	 for(StockHolding stock:arr) {
	    		 stock.display();
	    	 }
	    	 
	    	 
	    	 System.out.print("\n\nMenu::::::\n");
	    	//INPUT FROM USERS::
	    	 
	 		Scanner input = new Scanner(System.in);
	 		System.out.print("Enter no of stocks(not more than 8) : ");
	 		int noOfStocks = input.nextInt();
	 		
	 		
	 		
	 		ForeignStockHolding userStockHoldingArray[] = new ForeignStockHolding[noOfStocks];
	 		
	 		for(int i=0; i<noOfStocks; i++)
	 		{
	 			int typeOfStock;	 			
	 			System.out.print("Press 1 for StockHolding \n 2 for ForeignStockHolding \n");
	 			typeOfStock = input.nextInt();
	 			
	 			
	 			float purchasePrice,currentPrice, conRate;
	 			int noOfShare;
	 			String cname;
	 			
	 			//INPUT FROM USER FOR ABOVE VARIABLES:
	 			//taking input from user for each field specified in stock
	 			System.out.print("Enter the purchaseSharePrice for stock : ");
	 			purchasePrice = input.nextFloat();
	 			System.out.print("Enter the currentSharePrice for stock : ");
	 			currentPrice = input.nextFloat();
	 			System.out.print("Enter the noOfShares for stock : ");
	 			noOfShare = input.nextInt();
	 			System.out.print("Enter the companyName for stock : ");
	 			cname = input.next();
	 			
	 			
	 			
	 			//if the stock is of type StockHolding then conversion rate is 1 else take input from user
	 			if(typeOfStock == 1)
	 				conRate = 1;
	 			else 
	 			{
	 				System.out.print("Enter the conversion Rate for foreign stock");
	 				conRate = input.nextFloat();
	 			}
	 			
	 			
	 			//initialize the stock type as per user requirement
	 			userStockHoldingArray[i] = new ForeignStockHolding(purchasePrice, currentPrice, noOfShare, cname, conRate);
	 		}
	 		
	 		
	 		
	 		boolean ex = true;
	 	    //Infinte loop until exit::
	 		while(ex)
	 		{
	 			System.out.println("Enter your choice : \n    1) Display stock information with the lowest value\r\n" + 
	 					"    2) Display stock with the highest value\r\n" + 
	 					"    3) Display the most profitable stock\r\n" + 
	 					"    4) Display the least profitable stock\r\n" + 
	 					"    5) List all stocks sorted by company name (A-Z)\r\n" + 
	 					"    6) List all stocks sorted from the lowest value to the highest value\r\n" + 
	 					"    7) Exit");
	 			
	 			//variable to take choice of user
	 			int choice = input.nextInt();
	 			
	 			switch(choice)
	 			{
	 				case 1: 
	 				{
	 					minValueStock(userStockHoldingArray);
	 					break;
	 				}
	 				case 2:
	 				{
	 					maxValueStock(userStockHoldingArray);
	 					break;
	 				}
	 				case 3:
	 				{
	 					maxProfitableStock(userStockHoldingArray);
	 					break;
	 				}
	 				case 4:
	 				{
	 					minProfitableStock(userStockHoldingArray);
	 					break;
	 				}
	 				case 5:
	 				{
	 					displayAscending(userStockHoldingArray);
	 					break;
	 				}
	 				case 6:
	 				{
	 					displayInSortedValueOrder(userStockHoldingArray);
	 					break;
	 				}
	 				case 7:
	 				{
	 					ex = false;
	 				}
	 			}
	 			
	 		}
	      input.close();	 
	    	 
		}
}
