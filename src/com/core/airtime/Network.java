package com.core.airtime;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Network {
	private String iD, //Just an extra id, you can ignore
				   networkId, //Network ID
				   productId, //Product ID
				   countryId, //Country ID
	   			   name,//Network name
	   			   min,//This is for the minimum value in a network - networks that don't have denominations
	   			   max,//This is for maximum value in a network - networks that don't have denominations
	   			   usdmin,//This is for the USD minimum value in a network - networks that don't have denominations
	   			   usdmax,//This is for USD maximum value in a network - networks that don't have denominations
	   			   phonenumberlenght,//This is for the particular network's phone number lenght e.g. 10, 11
	   			   intlcallingcode, //International Calling Code
	   			   currency,//This is country's currency e.g. NGN, USD, DZD
	   			   topupid,//Unique Top up ID
	   			   isusddenom,
	   			   isfixed; //This is for determining if the network has denominations or not; true if it has, false otherwise
	private ArrayList<String> denominations; //This is a list for holding the network denominations e.g. Claro network in brazil 12 Reals, 14 Reals
	private ArrayList<String> usddenominations; //This is a list for holding the network denominations in USD
	private ArrayList<String> coefficients;
	
	public Network(){
	   iD = "";
	   networkId = "";
	   productId = "";
	   countryId = "";
	   name = "";
	   min = "";
	   max = "";
	   usdmin = "";
	   usdmax = "";
	   isfixed = "";
	   currency = "";
	   denominations = null;
	   usddenominations = null;
	   coefficients = null;
	   phonenumberlenght = "";
	   intlcallingcode = "";
	   topupid = "";
	   isusddenom = "";
	}
	
	// Insert a new airtime history
	public void insertNetwork(Context context) {
	   // Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
       
       String sql = "INSERT INTO " + DB.TABLE_NETWORK + " (operatorid, productid, networkname, localminvalue, localmaxvalue, usdminvalue, usdmaxvalue, " +
       		                                            "phonenumberlenght, callingcode, currency, isfixed, countryid, isusddenom) VALUES('" 
    		                                                                        + this.getNetworkID() + "','" 
                                                                                    + this.getProductID() + "','"
                                                                                    + this.getName() + "','"
                                                                                    + this.getMin() + "','"
                                                                                    + this.getMax() + "','"
                                                                                    + this.getUSDMin() + "','"
                                                                                    + this.getUSDMax() + "','"
                                                                                    + this.getPhoneNumberLenght() + "','"
                                                                                    + this.getIntlCallingCode() + "','"
                                                                                    + this.getCurrency() + "','"
                                                                                    + this.getIsFixed() + "','"
                                                                                    + this.getCountryID() + "','"
                                                                                    + this.getIsUSDDenom() + "');";
       db.execSQL(sql);
       db.close();
   	}
	
	public void updateNetwork(Context context) {	
	   // Update the row.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update " + DB.TABLE_NETWORK + " set operatorid = '" + this.getNetworkID() 
    		                                     + "', productid = '" + this.getProductID() 
    		                                     + "', networkname = '" + this.getName() 
    		                                     + "', localminvalue = '" + this.getMin()
    		                                     + "', localmaxvalue = '" + this.getMax()
    		                                     + "', usdminvalue = '" + this.getUSDMin()
    		                                     + "', usdmaxvalue = '" + this.getUSDMax()
    		                                     + "', phonenumberlenght = '" + this.getPhoneNumberLenght()
    		                                     + "', callingcode = '" + this.getIntlCallingCode()
    		                                     + "', currency = '" + this.getCurrency()
    		                                     + "', isfixed = '" + this.getIsFixed()
    		                                     + "', countryid = '" + this.getCountryID()
    		                                     + "', isusddenom = '" + this.getIsUSDDenom()
    		                                     + "' where _id = " + this.getID();
       db.execSQL(sql);
       db.close();
    }
		
	public Network getNetwork(Context context) {	
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor dbnetworks = db.query(true, DB.TABLE_NETWORK,  null, "operatorid = ?", new String[]{this.getNetworkID()}, null, null, null, null);
		   
	    if ((dbnetworks.getCount() == 0) || !dbnetworks.moveToFirst()) {
	    	dbnetworks.close();
	    	db.close();
		    return null;
	    }
	   
	    Network newItem = new Network();
	    newItem.setID(dbnetworks.getString(0));
	    newItem.setNetworkID(dbnetworks.getString(DB.NETWORK_ID_COLUMN));
	    newItem.setCountryID(dbnetworks.getString(DB.COUNTRY_ID_COLUMN));
	    newItem.setProductID(dbnetworks.getString(DB.PRODUCT_ID_COLUMN));
	    newItem.setCurrency(dbnetworks.getString(DB.NETWORK_CURRENCY_COLUMN));
	    newItem.setIntlCallingCode(dbnetworks.getString(DB.CALLING_CODE_COLUMN));
	    newItem.setIsFixed(dbnetworks.getString(DB.IS_FIXED_COLUMN));
	    newItem.setMin(dbnetworks.getString(DB.LOCAL_MIN_VALUE_COLUMN));
	    newItem.setMax(dbnetworks.getString(DB.LOCAL_MAX_VALUE_COLUMN));
	    newItem.setName(dbnetworks.getString(DB.NETWORK_NAME_COLUMN));
	    newItem.setPhoneNumberLenght(dbnetworks.getString(DB.PHONE_NUMBER_LENGHT_COLUMN));
	    newItem.setUSDMin(dbnetworks.getString(DB.USD_MIN_VALUE_COLUMN));
	    newItem.setUSDMax(dbnetworks.getString(DB.USD_MAX_VALUE_COLUMN));
	    newItem.setIsUSDDenom(dbnetworks.getString(DB.IS_USD_DENOM_COLUMN));
	   
	    //Set up denominations
	    if(dbnetworks.getString(DB.IS_FIXED_COLUMN).equals("false")){
		   Cursor fvs = db.query(DB.TABLE_NETWORK_FACE, null, DB.KEY_NETWORK_ID + " = ?", new String[]{newItem.getNetworkID()}, null, null, DB.KEY_LOCAL_VALUE);
		   
		   if (fvs.moveToFirst()){
			   ArrayList<String> locals = new ArrayList<String>();
			   ArrayList<String> usds = new ArrayList<String>();
			   
			   do{
				   locals.add(newItem.getCurrency() + " " + fvs.getString(DB.LOCAL_VALUE_COLUMN));
				   usds.add("USD " +fvs.getString(DB.USD_VALUE_COLUMN));
			   } while(fvs.moveToNext());
			   
			   newItem.setDenominations(locals);
			   newItem.setUSDDenominations(usds);
		   }
		   fvs.close();
	    }
	    
	    dbnetworks.close();
	    db.close();
	    
	    return newItem;
    }
	
	public static ArrayList<Network> GetNetworksFromDB(String CountryID, Context context){
		//Initialize
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		
		//Fill in the networks
		ArrayList<Network> networks = new ArrayList<Network>();
		Network network = new Network();
		network.setNetworkID("000");
		network.setName(context.getString(R.string.netOperator));
		network.setIsFixed("");
		network.setMin("");
		network.setMax("");
		networks.add(network);
		
		Cursor dbnetworks = db.query(DB.TABLE_NETWORK, null, DB.KEY_COUNTRY_ID + " = ?", new String[]{CountryID}, null, null, DB.KEY_NETWORK_NAME);
		
		if (dbnetworks.moveToFirst()){
		   do {
			   Network newItem = new Network();
			   newItem.setID(dbnetworks.getString(0));
			   newItem.setNetworkID(dbnetworks.getString(DB.NETWORK_ID_COLUMN));
			   newItem.setCountryID(dbnetworks.getString(DB.COUNTRY_ID_COLUMN));
			   newItem.setProductID(dbnetworks.getString(DB.PRODUCT_ID_COLUMN));
			   newItem.setCurrency(dbnetworks.getString(DB.NETWORK_CURRENCY_COLUMN));
			   newItem.setIntlCallingCode(dbnetworks.getString(DB.CALLING_CODE_COLUMN));
			   newItem.setIsFixed(dbnetworks.getString(DB.IS_FIXED_COLUMN));
			   newItem.setMin(dbnetworks.getString(DB.LOCAL_MIN_VALUE_COLUMN));
			   newItem.setMax(dbnetworks.getString(DB.LOCAL_MAX_VALUE_COLUMN));
			   newItem.setName(dbnetworks.getString(DB.NETWORK_NAME_COLUMN));
			   newItem.setPhoneNumberLenght(dbnetworks.getString(DB.PHONE_NUMBER_LENGHT_COLUMN));
			   newItem.setUSDMin(dbnetworks.getString(DB.USD_MIN_VALUE_COLUMN));
			   newItem.setUSDMax(dbnetworks.getString(DB.USD_MAX_VALUE_COLUMN));
			   newItem.setIsUSDDenom(dbnetworks.getString(DB.IS_USD_DENOM_COLUMN));
			   
			   //Set up denominations
			   if(newItem.getIsFixed().equals("false")){
				   Cursor fvs = db.query(DB.TABLE_NETWORK_FACE, null, DB.KEY_NETWORK_ID + " = ?", new String[]{newItem.getNetworkID()}, null, null, DB.KEY_LOCAL_VALUE);
				   
				   if (fvs.moveToFirst()){
					   ArrayList<String> locals = new ArrayList<String>();
					   ArrayList<String> usds = new ArrayList<String>();
					   
					   do{
						   locals.add(newItem.getCurrency() + " " + fvs.getString(DB.LOCAL_VALUE_COLUMN));
						   usds.add("USD " +fvs.getString(DB.USD_VALUE_COLUMN));
					   } while(fvs.moveToNext());
					   
					   newItem.setDenominations(locals);
					   newItem.setUSDDenominations(usds);
				   }
				   
				   fvs.close();
			   }
			   
			   networks.add(newItem);
		   } while(dbnetworks.moveToNext());
		}
		
		dbnetworks.close();
		db.close();
		
		return networks;
	}
	
	public static ArrayList<Network> getAllNetworks(Context context){
		//Initialize
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		
		//Fill in the networks
		ArrayList<Network> networks = new ArrayList<Network>();
		Network network = new Network();
		network.setNetworkID("000");
		network.setName(context.getString(R.string.netOperator));
		network.setIsFixed("");
		network.setMin("");
		network.setMax("");
		networks.add(network);
		
		Cursor dbnetworks = db.query(DB.TABLE_NETWORK, null, null, null, null, null, DB.KEY_NETWORK_NAME);
		
		if (dbnetworks.moveToFirst()){
		   do {
			   Network newItem = new Network();
			   newItem.setID(dbnetworks.getString(0));
			   newItem.setNetworkID(dbnetworks.getString(DB.NETWORK_ID_COLUMN));
			   newItem.setCountryID(dbnetworks.getString(DB.COUNTRY_ID_COLUMN));
			   newItem.setProductID(dbnetworks.getString(DB.PRODUCT_ID_COLUMN));
			   newItem.setCurrency(dbnetworks.getString(DB.NETWORK_CURRENCY_COLUMN));
			   newItem.setIntlCallingCode(dbnetworks.getString(DB.CALLING_CODE_COLUMN));
			   newItem.setIsFixed(dbnetworks.getString(DB.IS_FIXED_COLUMN));
			   newItem.setMin(dbnetworks.getString(DB.LOCAL_MIN_VALUE_COLUMN));
			   newItem.setMax(dbnetworks.getString(DB.LOCAL_MAX_VALUE_COLUMN));
			   newItem.setName(dbnetworks.getString(DB.NETWORK_NAME_COLUMN));
			   newItem.setPhoneNumberLenght(dbnetworks.getString(DB.PHONE_NUMBER_LENGHT_COLUMN));
			   newItem.setUSDMin(dbnetworks.getString(DB.USD_MIN_VALUE_COLUMN));
			   newItem.setUSDMax(dbnetworks.getString(DB.USD_MAX_VALUE_COLUMN));
			   newItem.setIsUSDDenom(dbnetworks.getString(DB.IS_USD_DENOM_COLUMN));
			   
			   networks.add(newItem);
		   } while(dbnetworks.moveToNext());
		}
		
		dbnetworks.close();
		db.close();
		
		return networks;
	}

	public void setID(String value){
		iD = value;
	}
	public String getID(){
		return iD;
	}
	
	public void setNetworkID(String value){
		networkId = value;
	}
	public String getNetworkID(){
		return networkId;
	}
	
	public void setCountryID(String value){
		countryId = value;
	}
	public String getCountryID(){
		return countryId;
	}
	
	public void setProductID(String value){
		productId = value;
	}
	public String getProductID(){
		return productId;
	}
	
	public void setIsUSDDenom(String value){
		isusddenom = value;
	}
	public String getIsUSDDenom(){
		return isusddenom;
	}
	
	public void setTopUpID(String value){
		topupid = value;
	}
	public String getTopUpID(){
		return topupid;
	}
	
	public void setPhoneNumberLenght(String value){
		phonenumberlenght = value;
	}
	public String getPhoneNumberLenght(){
		return phonenumberlenght;
	}
	
	public void setIntlCallingCode(String value){
		intlcallingcode = value;
	}
	public String getIntlCallingCode(){
		return intlcallingcode;
	}
	
	public void setCurrency(String value){
		currency = value;
	}
	public String getCurrency(){
		return currency;
	}
	
	public void setName(String value){
		name = value;
	}
	public String getName(){
		return name;
	}
	
	public void setMin(String value){
		min = value;
	}
	public String getMin(){
		return min;
	}
	
	public void setMax(String value){
		max = value;
	}
	public String getMax(){
		return max;
	}
	
	public void setUSDMin(String value){
		usdmin = value;
	}
	public String getUSDMin(){
		return usdmin;
	}
	
	public void setUSDMax(String value){
		usdmax = value;
	}
	public String getUSDMax(){
		return usdmax;
	}
	
	public void setIsFixed(String value){
		isfixed = value;
	}
	public String getIsFixed(){
		return isfixed;
	}
	
	public void setDenominations(ArrayList<String> value){
		denominations = value;
	}
	public ArrayList<String> getDenominations(){
		return denominations;
	}
	
	public void setUSDDenominations(ArrayList<String> value){
		usddenominations = value;
	}
	public ArrayList<String> getUSDDenominations(){
		return usddenominations;
	}
	
	public void setCoefficients(ArrayList<String> value){
		coefficients = value;
	}
	public ArrayList<String> getCoefficients(){
		return coefficients;
	}
	
	public String toString()
	{
		return name;
	}
}
