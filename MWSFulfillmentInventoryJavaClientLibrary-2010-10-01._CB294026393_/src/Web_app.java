import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.amazonservices.mws.*;
import com.sun.org.apache.*;
import com.sun.security.auth.login.ConfigFile;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
//import com.amazonaws.mws.samples;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.*;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.mock.*;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.model.*;
import com.amazonservices.mws.FulfillmentInventory._2010_10_01.samples.*;
public class Web_app {
	  public static void invokeGetServiceStatus(FBAInventoryServiceMWS service, GetServiceStatusRequest request) 
	 {        
		 try {
         GetServiceStatusResponse response = service.getServiceStatus(request);
         System.out.println ("GetServiceStatus Action Response");            
         System.out.println ("=============================================================================");         
         System.out.println ();
         System.out.println("    GetServiceStatusResponse");     
         System.out.println();  
         if (response.isSetGetServiceStatusResult()) 
         {    
        	 System.out.println("        GetServiceStatusResult");         
        	 System.out.println(); 
        	 GetServiceStatusResult  getServiceStatusResult = response.getGetServiceStatusResult();      
        	 if (getServiceStatusResult.isSetStatus()) {         
        		 System.out.println("            ServiceStatusInfo"); 
        		 System.out.println();  
        		 System.out.println("                " + getServiceStatusResult.getStatus());                    
        		 System.out.println();            
        		 }    
        	 }           
         if (response.isSetResponseMetadata()) 
         {                
        	 System.out.println("        ResponseMetadata");
        	 System.out.println(); 
        	 ResponseMetadata  responseMetadata = response.getResponseMetadata();     
        	 if (responseMetadata.isSetRequestId()) 
        	 {  
        		 System.out.println("            RequestId");
        		 System.out.println(); 
        		 System.out.println("                " + responseMetadata.getRequestId());      
        		 System.out.println();
        	 }            }            System.out.println();
	        } catch (FBAInventoryServiceMWSException ex) {
	            System.out.println("Caught Exception: " + ex.getMessage());  
	            System.out.println("Response Status Code: " + ex.getStatusCode());
	            System.out.println("Error Code: " + ex.getErrorCode());
	            System.out.println("Error Type: " + ex.getErrorType());
	            System.out.println("Request ID: " + ex.getRequestId());
	            System.out.print("XML: " + ex.getXML());
	            }
		 }
	  	public static void invokeListInventorySupply(FBAInventoryServiceMWS service, ListInventorySupplyRequest request) {  
	  		try {
	  			ListInventorySupplyResponse response = service.listInventorySupply(request);
	  			System.out.println ("ListInventorySupply Action Response");            
	  			System.out.println ("=============================================================================");
	  			System.out.println ();
	  			System.out.println("    ListInventorySupplyResponse");
	  			System.out.println();
	  			if (response.isSetListInventorySupplyResult()) 
	  			{                
	  				System.out.println("        ListInventorySupplyResult");                
	  				System.out.println();                
	  				ListInventorySupplyResult listInventorySupplyResult = response.getListInventorySupplyResult(); 
//	  				System.out.println(listInventorySupplyResult);
	  				if (listInventorySupplyResult.isSetInventorySupplyList()) 
	  				{                    
	  					System.out.println("            InventorySupplyList");                    
	  					System.out.println();                    
	  					InventorySupplyList  inventorySupplyList = listInventorySupplyResult.getInventorySupplyList();                   
	  					java.util.List<InventorySupply> memberList = inventorySupplyList.getMember();
	  					if(!inventorySupplyList.isSetMember())
  						{System.out.println("		Empty List");}
	  					for (InventorySupply member : memberList) {
	  						System.out.println("                member");                        
	  						System.out.println();     
	  						System.out.println(member);
	  					if (member.isSetSellerSKU()) {  
	  						System.out.println("                    SellerSKU");
	  						System.out.println();
	  						System.out.println("                        " + member.getSellerSKU());                        
	  						System.out.println();       
	  						}                        
	  					if (member.isSetFNSKU()) 
	  						{
	  						System.out.println("                    FNSKU");
	  						 System.out.println();         
	  						 System.out.println("                        " + member.getFNSKU()); 
	  						 System.out.println();
	  						 }
	  					if (member.isSetASIN()) { 
	  						System.out.println("                    ASIN");
	  						System.out.println(); 
	  						System.out.println("                        " + member.getASIN());  
	  						System.out.println();
	  						}
	  					if (member.isSetCondition()) { 
	  						System.out.println("                    Condition");					
	                            System.out.println();                           
	                            System.out.println("                        " + member.getCondition());
	                            System.out.println();
	                            }
	  					if (member.isSetTotalSupplyQuantity()) {
	  						System.out.println("                    TotalSup plyQuantity");
	  						System.out.println();
	  						System.out.println("                        " + member.getTotalSupplyQuantity()); 
	  						System.out.println();     
	  						}
	  					if (member.isSetInStockSupplyQuantity()) {  
	  						System.out.println("                    InStockSup plyQuantity");
	  						System.out.println();
	  						System.out.println("                        " + member.getInStockSupplyQuantity());    
	  						System.out.println();     
	  						}
	  					if (member.isSetEarliestAvailability()) {
	  						System.out.println("                    EarliestAvail ability");
	  						System.out.println();
	  						Timepoint earliestAvailability = member.getEarliestAvailability();    
	  						if (earliestAvailability.isSetTimepointType()) { 
	  							System.out.println("                        TimepointType");
	  							System.out.println();
	  							System.out.println("                            " + earliestAvailability.getTimepointType()); 
	  							System.out.println(); 
	  							}
	  						if (earliestAvailability.isSetDateTime())
	  						{
	  							System.out.println("                        DateTime");
	  							System.out.println();   
	  							System.out.println("                            " + earliestAvailability.getDateTime());
	  							System.out.println();  
	  							}
	  						}
	  					 if (member.isSetSupplyDetail()) {   
	  						 System.out.println("                    SupplyDetail"); 
	  						 System.out.println();
	  						 InventorySupplyDetailList  supplyDetail = member.getSupplyDetail();
	  						 java.util.List<InventorySupplyDetail> member1List = supplyDetail.getMember();
	  						 for (InventorySupplyDetail member1 : member1List) {
	  							 System.out.println("                        member");  
	  							 System.out.println();
	  							 System.out.println(member1);
	  							 if (member1.isSetQuantity()) 
	  							 {
	  								 System.out.println("                            Quantity");   
	  								 System.out.println(); 
	  								 System.out.println("                                " + member1.getQuantity());   
	  								 System.out.println(); 
	  								 }
	  							 if (member1.isSetSupplyType()) {
	  								 System.out.println("                            SupplyType");
	  								 System.out.println();
	  								 System.out.println("                                " + member1.getSupplyType());
	  								 System.out.println();
	  								 }
	  							 if (member1.isSetEarliestAvailableToPick()) {
	  								 System.out.println("                            EarliestAvailableToPick");
	  								 System.out.println();
	  								 Timepoint  earliestAvailableToPick = member1.getEarliestAvailableToPick();
	  								 if (earliestAvailableToPick.isSetTimepointType())
	  								 {
	  									 System.out.println("                                TimepointType");                                        
	  									 System.out.println();
	  									 System.out.println("                                    " + earliestAvailableToPick.getTimepointType()); 
	  									 System.out.println();
	  									 }
	  								 if (earliestAvailableToPick.isSetDateTime()) { 
	  									 System.out.println("                                DateTime");
	  									 System.out.println(); 
	  									 System.out.println("                                    " + earliestAvailableToPick.getDateTime());  
	  									 System.out.println(); 
	  									 }
	  								 }
	  							 if (member1.isSetLatestAvailableToPick()) {
	  								 System.out.println("                            LatestAvailableToPick");
	  								 System.out.println();
	  								 Timepoint  latestAvailableToPick = member1.getLatestAvailableToPick();
	  								  if (latestAvailableToPick.isSetTimepointType()) {
	  									  System.out.println("                                TimepointType");
	  									  System.out.println();            
	  									  System.out.println("                                    " + latestAvailableToPick.getTimepointType());
	  									  System.out.println();
	  									  }
	  								  if (latestAvailableToPick.isSetDateTime()) {
	  									  System.out.println("                                DateTime"); 
	  									  System.out.println();
	  									  System.out.println("                                    " + latestAvailableToPick.getDateTime());
	  									  System.out.println();
	  									  }
	  								  }
	  							 }
	  						 }          
	  					 }
	  					}
	  				if (listInventorySupplyResult.isSetNextToken())
	  					{
	  					System.out.println("            NextToken");
	  					System.out.println();  
	  					System.out.println("                " + listInventorySupplyResult.getNextToken());
	  					System.out.println();  
	  					}
	  				}
	  			if (response.isSetResponseMetadata()) { 
	  				System.out.println("        ResponseMetadata");
	  				System.out.println();
	  				ResponseMetadata  responseMetadata = response.getResponseMetadata();
	  				if (responseMetadata.isSetRequestId()) {
	  					System.out.println("            RequestId");  
	  					System.out.println();
	  					System.out.println("                " + responseMetadata.getRequestId()); 
	  					System.out.println();
	  					}
	  				}
	  			System.out.println();
	        } catch (FBAInventoryServiceMWSException ex) {
	            System.out.println("Caught Exception: " + ex.getMessage()); 
	            System.out.println("Response Status Code: " + ex.getStatusCode());
	            System.out.println("Error Code: " + ex.getErrorCode());    
	            System.out.println("Error Type: " + ex.getErrorType());   
	            System.out.println("Request ID: " + ex.getRequestId());   
	            System.out.print("XML: " + ex.getXML());
	            } 
	  		}
	  					
	public static void main(String[] args)throws Exception
	{
		 int choice;
		 //LocalDateTime now = LocalDateTime.now(); 
		 Date date=new Date();
		 GregorianCalendar c = new GregorianCalendar();
		 c.setTime(date);
		 XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		 final String accessKeyId;
		 final String secretKey;
		 final String appName="FBA Inventory Handling";
		 final String appVersion="�2010-10-01�";
		 final String MarketplaceId;
		 final String MerchantId;
		 System.out.println("Welcome User Please Enter the Following Information:-");
		 System.out.print("1)	AccessKeyId :- ");
		 Scanner s=new Scanner(System.in);
		 accessKeyId=s.nextLine();
		 System.out.print("2)	secretKey :- ");
		 secretKey=s.nextLine();
		 System.out.print("3)	MarketplaceId :- ");
		 MarketplaceId=s.nextLine();
		 System.out.print("4)	MerchantId :- ");
		 MerchantId=s.nextLine();
		 FBAInventoryServiceMWSConfig config = new FBAInventoryServiceMWSConfig();
		 config.setServiceURL("https://mws.amazonservices.com/FulfillmentInventory/2010-10-01/");

		 //config.setServiceURL("https://mws.amazonservices.in/FulfillmentInventory/2010-10-01/");
		 FBAInventoryServiceMWS service = new FBAInventoryServiceMWSClient(accessKeyId, secretKey, appName, appVersion, config);
		 GetServiceStatusRequest request = new GetServiceStatusRequest(); 
		 request.setMarketplace(MarketplaceId);
	     request.setSellerId(MerchantId);
	     request.setMarketplace(MarketplaceId);
	     ListInventorySupplyRequest request1 = new ListInventorySupplyRequest();
	     //ListInventorySupplyResult list=new ListInventorySupplyResult();
	     request1.setMarketplace(MarketplaceId);
	     request1.setSellerId(MerchantId);
	     request1.setMarketplace(MarketplaceId);
	     request1.setMWSAuthToken(null);
	     request1.setQueryStartDateTime(date2);
	     System.out.println ("=============================================================================");
	     System.out.println();
	     while(true) {
	     System.out.println("Please Choose an appropriate Choise...... "+ date.toString());
	     System.out.println("1)		Get your Service Status");
	     System.out.println("2)		List of Inventory Supply");
	     System.out.println("3)		Quit");
	     choice=s.nextInt();
	     switch(choice)
	     {
	     case 1:
	    	 new Web_app().invokeGetServiceStatus(service, request);break;
	     case 2:
	    	 new Web_app().invokeListInventorySupply(service, request1);break;
	     case 3:
	    	 System.exit(0);break;
	    	 default:
	    		 System.out.println("Please enter a valid Input");
	    
	     }
	   }
	}
}
