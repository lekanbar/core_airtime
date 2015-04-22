package com.core.airtime;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NetworkFaceValue {
	private String iD, //Just an extra id, you can ignore
				   networkId, //Network ID
				   local, 
				   usd;
	
	public NetworkFaceValue(){
	   iD = "";
	   networkId = "";
	   local = "";
	   usd = "";
	}
	
	// Insert a new airtime history
	public void insertNetworkFace(Context context) {
	   // Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
       
       String sql = "INSERT INTO " + DB.TABLE_NETWORK_FACE + " (" + DB.KEY_NETWORK_ID + ", " + DB.KEY_LOCAL_VALUE + ", " + DB.KEY_USD_VALUE +") VALUES('" 
    		                                                                        + this.getNetworkID() + "','" 
                                                                                    + this.getLocalValue() + "','"
                                                                                    + this.getUSDValue() + "');";
       db.execSQL(sql);
       db.close();
   	}
	
	public void updateGateway(Context context) {	
	   // Update the row.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update " + DB.TABLE_NETWORK_FACE + " set " + DB.KEY_NETWORK_ID + " = '" + this.getNetworkID() 
    		                                     + "', " + DB.KEY_LOCAL_VALUE + " = '" + this.getLocalValue() 
    		                                     + "', " + DB.KEY_USD_VALUE + " = '" + this.getUSDValue()
    		                                     + "' where _id = " + this.getID();
       db.execSQL(sql);
       db.close();
    }
		
	public void getSingleNetworkValue(Context context) {	
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor history = db.query(true, DB.TABLE_NETWORK_FACE,  null, DB.KEY_ID + " = ?", new String[]{this.getID()}, null, null, null, null);
		   
	    if ((history.getCount() == 0) || !history.moveToFirst()) {
		    history.close();
			db.close();
		    return;
	    }
	   
	    this.setID(history.getString(0));
	    this.setNetworkID(history.getString(DB.NETWORK_ID_COLUMN));
	    this.setLocalValue(history.getString(DB.LOCAL_VALUE_COLUMN));
	    this.setUSDValue(history.getString(DB.USD_VALUE_COLUMN));
	    
	    history.close();
	    db.close();
    }
	
	public ArrayList<NetworkFaceValue> GetFaceValues(Context context){
		//Initialize
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		
		ArrayList<NetworkFaceValue> networkfacevalues = new ArrayList<NetworkFaceValue>();
		Cursor dbnetworks = db.query(DB.TABLE_NETWORK_FACE, null, DB.KEY_NETWORK_ID + " = ?", new String[]{this.getNetworkID()}, null, null, DB.KEY_LOCAL_VALUE);
		
		if (dbnetworks.moveToFirst()){
		   do {
			   NetworkFaceValue newItem = new NetworkFaceValue();
			   newItem.setID(dbnetworks.getString(0));
			   newItem.setNetworkID(dbnetworks.getString(DB.NETWORK_ID_COLUMN));
			   newItem.setLocalValue(dbnetworks.getString(DB.LOCAL_VALUE_COLUMN));
			   newItem.setUSDValue(dbnetworks.getString(DB.USD_VALUE_COLUMN));
			   
			   networkfacevalues.add(newItem);
		   } while(dbnetworks.moveToNext());
		}
		
		dbnetworks.close();
		db.close();
		
		return networkfacevalues;
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
	
	public void setLocalValue(String value){
		local = value;
	}
	public String getLocalValue(){
		return local;
	}
	
	public void setUSDValue(String value){
		usd = value;
	}
	public String getUSDValue(){
		return usd;
	}
	
	public String toString()
	{
		return networkId;
	}
}
