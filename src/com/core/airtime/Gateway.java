package com.core.airtime;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Gateway {
	private String iD,
				   gatewayID,
				   currency,
				   gatewayName,
				   isgatewayReady;
	
	private Context context;
	private ArrayList<Gateway> gateways;
	
	public Gateway(){
	   iD = "";
	   gatewayID = "";
	   currency = "";
	   gatewayName = "";
	   isgatewayReady = "";
	}
	
	public Gateway(Context context){
		this.context = context;
	    iD = "";
	    gatewayID = "";
	    currency = "";
	    gatewayName = "";
	    isgatewayReady = "";
	}

	public String getID(){
		return iD;
	}
	public void setID(String value){
		iD = value;
	}
	
	public String getIsGatewayReady(){
		return isgatewayReady;
	}
	public void setIsGatewayReady(String value){
		isgatewayReady = value;
	}
	
	public String getGatewayID(){
		return gatewayID;
	}
	public void setGatewayID(String value){
		gatewayID = value;
	}
	
	public String getCurrency(){
		return currency;
	}
	public void setCurrency(String value){
		currency = value;
	}
	
	public String getGatewayName(){
		return gatewayName;
	}
	public void setGatewayName(String value){
		gatewayName = value;
	}
	
	public ArrayList<Gateway> getGateways(){
		return gateways;
	}
	
	public void insertGateway(){
		// Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;//"/data/data/com.core.airtime/databases/coreairtime.db"
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "INSERT INTO gateway (gatewayid, gatewaycurrency, gatewayname, isgatewayready) VALUES('" 
    		   																				 + this.getGatewayID() + "','" 
                                                                                             + this.getCurrency() + "','" 
    		                                                                                 + this.getGatewayName() + "','" 
    		                                                                                 + this.getIsGatewayReady() + "');";
       db.execSQL(sql);
       db.close();
	}
	
	public void updateGateway(long _rowIndex, Context context) {	
	   // Update the row.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update gateway set gatewayid = '" + this.getGatewayID() + "', gatewaycurrency = '" 
	                                                   + this.getCurrency() + "', gatewayname = '" 
	    	                                           + this.getGatewayName() + "', isgatewayready = '"
	    	                                           + this.getIsGatewayReady() + "' where _id = " + _rowIndex;
       db.execSQL(sql);
       db.close();
    }
	
	public Gateway getGateway(String gatewayid) {	
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor history = db.query(true, DB.TABLE_GATEWAY,  null, DB.KEY_GATEWAY_ID + " = ?", new String[]{gatewayid}, null, null, null, null);
		   
	    if ((history.getCount() == 0) || !history.moveToFirst()) {
		    history.close();
		    db.close();
		    return null;
	    }
	   
	    Gateway newItem = new Gateway();
	    newItem.setID(history.getString(0));
	    newItem.setGatewayID(history.getString(DB.GATEWAY_ID_COLUMN));
	    newItem.setCurrency(history.getString(DB.GATEWAY_CURRENCY2_COLUMN));
	    newItem.setGatewayName(history.getString(DB.GATEWAY_NAME_COLUMN));
	    newItem.setIsGatewayReady(history.getString(DB.IS_GATEWAY_READY_COLUMN));
	    
	    history.close();
	    db.close();
	    
	    return newItem;
    }
	
	public Gateway getGateway2(String gatewayname) {	
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor history = db.query(true, DB.TABLE_GATEWAY,  null, DB.KEY_GATEWAY_NAME + " like '%" + gatewayname + "%' and " + DB.KEY_IS_GATEWAY_READY + " = 'true'", null, null, null, null, null);
		   
	    if ((history.getCount() == 0) || !history.moveToFirst()) {
		    history.close();
		    db.close();
		    return null;
	    }
	   
	    Gateway newItem = new Gateway();
	    newItem.setID(history.getString(0));
	    newItem.setGatewayID(history.getString(DB.GATEWAY_ID_COLUMN));
	    newItem.setCurrency(history.getString(DB.GATEWAY_CURRENCY2_COLUMN));
	    newItem.setGatewayName(history.getString(DB.GATEWAY_NAME_COLUMN));
	    newItem.setIsGatewayReady(history.getString(DB.IS_GATEWAY_READY_COLUMN));
	    
	    history.close();
	    db.close();
	    
	    return newItem;
    }
	
	public ArrayList<Gateway> getAllReadyGateways() {	
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
	   
	   Cursor histories = db.query(DB.TABLE_GATEWAY, null, DB.KEY_IS_GATEWAY_READY + " = ?", new String[]{"true"}, null, null, DB.KEY_GATEWAY_ID);
		   
	   if (histories.moveToFirst()){
		  gateways = new ArrayList<Gateway>();
		  do {
			  Gateway newItem = new Gateway();
			  newItem.setID(histories.getString(0));
			  newItem.setGatewayID(histories.getString(DB.GATEWAY_ID_COLUMN));
			  newItem.setCurrency(histories.getString(DB.GATEWAY_CURRENCY2_COLUMN));
			  newItem.setGatewayName(histories.getString(DB.GATEWAY_NAME_COLUMN));
			  newItem.setIsGatewayReady(histories.getString(DB.IS_GATEWAY_READY_COLUMN));
			  
			  gateways.add(newItem);
		  } while(histories.moveToNext());
		  
		  histories.close();
		  db.close();
		  return gateways;
	   }
	   
	   histories.close();
	   db.close();
	   return null;
    }
	
	public ArrayList<Gateway> getAllGateways() {	
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
	   Cursor histories = db.query(DB.TABLE_GATEWAY, null, null, null, null, null, DB.KEY_GATEWAY_ID);
		   
	   if (histories.moveToFirst()){
		  gateways = new ArrayList<Gateway>();
		  do {
			  Gateway newItem = new Gateway();
			  newItem.setID(histories.getString(0));
			  newItem.setGatewayID(histories.getString(DB.GATEWAY_ID_COLUMN));
			  newItem.setCurrency(histories.getString(DB.GATEWAY_CURRENCY2_COLUMN));
			  newItem.setGatewayName(histories.getString(DB.GATEWAY_NAME_COLUMN));
			  newItem.setIsGatewayReady(histories.getString(DB.IS_GATEWAY_READY_COLUMN));
			  
			  gateways.add(newItem);
		  } while(histories.moveToNext());
		  
		  histories.close();
		  db.close();
		  return gateways;
	   }
	   
	   histories.close();
	   db.close();
	   return null;
	}
}
