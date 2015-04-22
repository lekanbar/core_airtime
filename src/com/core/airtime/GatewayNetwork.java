package com.core.airtime;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class GatewayNetwork {
	private String iD, //Just an extra id, you can ignore
				   networkId, //Network ID
				   gatewayId, 
				   localcoeffvalue,
				   usdcoeffvalue,
				   countryid;
	
	public GatewayNetwork(){
	   iD = "";
	   networkId = "";
	   gatewayId = "";
	   localcoeffvalue = "";
	   usdcoeffvalue = "";
	   countryid = "";
	}
	
	// Insert a new airtime history
	public void insertGatewayNetwork(Context context) {
	   // Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
       
       String sql = "INSERT INTO " + DB.TABLE_NETWORK_GATEWAY + " (" + DB.KEY_NETWORK_ID2 + ", " + DB.KEY_GATEWAY_ID2 + ", " + DB.KEY_LOCAL_COEFF_VALUE +
    		        ", " + DB.KEY_USD_COEFF_VALUE + ", " + DB.KEY_COUNTRY_ID2 + ") VALUES('" + this.getNetworkID() + "','" 
                                                                 + this.getGatewayID() + "','"
                                                                 + this.getLocalCoeffValue() + "','"
                                                                 + this.getUSDCoeffValue() + "','" 
                                                                 + this.getCountryID() + "');";
       db.execSQL(sql);
       db.close();
   	}
	
	public void updateGatewayNetwork(Context context) {	
	   // Update the row.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update " + DB.TABLE_NETWORK_GATEWAY + " set " + DB.KEY_NETWORK_ID2 + " = '" + this.getNetworkID() 
    		                                     + "', " + DB.KEY_GATEWAY_ID2 + " = '" + this.getGatewayID() 
    		                                     + "', " + DB.KEY_LOCAL_COEFF_VALUE + " = '" + this.getLocalCoeffValue()
    		                                     + "', " + DB.KEY_USD_COEFF_VALUE + " = '" + this.getUSDCoeffValue()
    		                                     + "', " + DB.KEY_COUNTRY_ID2 + " = '" + this.getCountryID()
    		                                     + "' where _id = " + this.getID();
       db.execSQL(sql);
       db.close();
    }
		
	public GatewayNetwork getGatewayNetwork(Context context) {	
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor dbnetworks = db.query(true, DB.TABLE_NETWORK_GATEWAY,  null, DB.KEY_NETWORK_ID2 + " = ? and " + DB.KEY_GATEWAY_ID2 + " = ?", 
				                     new String[]{this.getNetworkID(), this.getGatewayID()}, null, null, null, null);
		   
	    if ((dbnetworks.getCount() == 0) || !dbnetworks.moveToFirst()) {
	    	dbnetworks.close();
	    	db.close();
		    return null;
	    }
	   
	    GatewayNetwork newItem = new GatewayNetwork();
	    newItem.setID(dbnetworks.getString(0));
	    newItem.setNetworkID(dbnetworks.getString(DB.NETWORK_ID2_COLUMN));
	    newItem.setGatewayID(dbnetworks.getString(DB.GATEWAY_ID2_COLUMN));
	    newItem.setLocalCoeffValue(dbnetworks.getString(DB.LOCAL_COEFF_VALUE_COLUMN));
	    newItem.setUSDCoeffValue(dbnetworks.getString(DB.USD_COEFF_VALUE_COLUMN));
	    newItem.setCountryID(dbnetworks.getString(DB.COUNTRY_ID2_COLUMN));
	    
	    dbnetworks.close();
	    db.close();
	    
	    return newItem;
    }
	
	public ArrayList<GatewayNetwork> getGatewayNetworks(Context context){
		//Initialize
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		
		Cursor dbnetworks = db.query(DB.TABLE_NETWORK_GATEWAY, null, DB.KEY_NETWORK_ID2 + " = ?", new String[]{this.getNetworkID()}, null, null, DB.KEY_LOCAL_COEFF_VALUE);
		
		ArrayList<GatewayNetwork> gates = null;
		if (dbnetworks.moveToFirst()){
			gates = new ArrayList<GatewayNetwork>();
		    do {
			   GatewayNetwork newItem = new GatewayNetwork();
			   newItem.setID(dbnetworks.getString(0));
			   newItem.setNetworkID(dbnetworks.getString(DB.NETWORK_ID2_COLUMN));
			   newItem.setGatewayID(dbnetworks.getString(DB.GATEWAY_ID2_COLUMN));
			   newItem.setLocalCoeffValue(dbnetworks.getString(DB.LOCAL_COEFF_VALUE_COLUMN));
			   newItem.setUSDCoeffValue(dbnetworks.getString(DB.USD_COEFF_VALUE_COLUMN));
			   newItem.setCountryID(dbnetworks.getString(DB.COUNTRY_ID2_COLUMN));
			   
			   gates.add(newItem);
		    } while(dbnetworks.moveToNext());
		}
		
		dbnetworks.close();
		db.close();
		
		return gates;
	}
	
	public boolean GetGatewayNetworksByCountryID(Context context){
		//Initialize
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		
		Cursor dbnetworks = db.query(DB.TABLE_NETWORK_GATEWAY, null, DB.KEY_COUNTRY_ID2 + " = ?", new String[]{this.getCountryID()}, null, null, DB.KEY_LOCAL_COEFF_VALUE);
		
		if (dbnetworks.moveToFirst()){
			dbnetworks.close();
			db.close();
		    return true;
		}
		
		dbnetworks.close();
		db.close();
		return false;
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
		countryid = value;
	}
	public String getCountryID(){
		return countryid;
	}
	
	public void setGatewayID(String value){
		gatewayId = value;
	}
	public String getGatewayID(){
		return gatewayId;
	}
	
	public void setUSDCoeffValue(String value){
		usdcoeffvalue = value;
	}
	public String getUSDCoeffValue(){
		return usdcoeffvalue;
	}
	
	public void setLocalCoeffValue(String value){
		localcoeffvalue = value;
	}
	public String getLocalCoeffValue(){
		return localcoeffvalue;
	}
	
	public String toString()
	{
		return networkId;
	}
}
