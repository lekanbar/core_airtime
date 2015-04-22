package com.core.airtime;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Currency {
	private String iD,
	               currencyId, //Also serves as the country ID
	               currencycode,
	               usdexrate,
	               nairaexrate,
	               countryname;
	
	public ArrayList<Currency> currencies;
	Context context;
	
	public Currency(Context context){
		iD = "";
		currencyId = "";
		currencycode = "";
		usdexrate = "";
		nairaexrate = "";
		countryname = "";
		this.context = context;
	}
	
	public Currency() {
		// TODO Auto-generated constructor stub
	}

	public void insertCurrency(){
		// Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;//"/data/data/com.core.airtime/databases/coreairtime.db"
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "INSERT INTO "+ DB.TABLE_CURRENCY + "(currencyid, currencycode, usdexrate, nairaexrate, countryname) VALUES('" 
                                                                                + this.getCurrencyId() + "','" 
                                                                                + this.getCurrencycode() + "','"
                                                                                + this.getUsdexrate() + "','"
                                                                                + this.getNairaexrate() + "','" 
                                                                                + this.getCountryName() + "');";
       db.execSQL(sql);
       db.close();
	}
	
	public void updateCurrency(Context context) {	
	   // Update the row.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update " + DB.TABLE_CURRENCY + " set currencyid = '" + this.getCurrencyId() + "', usdexrate = '" 
	                                                    + this.getUsdexrate() + "', nairaexrate = '" 
	                                                    + this.getNairaexrate() + "' where _id = " + this.getiD();
       db.execSQL(sql);
       db.close();
    }
	
	public Currency getCurrencyByCode(String currncycode) {
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor history = db.query(true, DB.TABLE_CURRENCY, null, DB.KEY_CURRENCY_CODE + " = '" + currncycode + "'", null, null, null, null, null);
		   
	    if ((history.getCount() == 0) || !history.moveToFirst()) {
		    history.close();
		    db.close();
		    return null;
	    }
	   
	    Currency newItem = new Currency();
	    newItem.setiD(history.getString(0));
	    newItem.setCurrencyId(history.getString(DB.CURRENCY_ID_COLUMN));
		newItem.setCurrencycode(history.getString(DB.CURRENCY_CODE_COLUMN));
		newItem.setUsdexrate(history.getString(DB.USD_EXRATE_COLUMN));
		newItem.setNairaexrate(history.getString(DB.NAIRA_EXRATE_COLUMN));
		newItem.setCountryName(history.getString(DB.COUNTRY_NAME_COLUMN));
	    
	    history.close();
	    db.close();
	    
	    return newItem;
    }
	
	public Currency getCurrency(String countryname) {
		SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
		Cursor history = db.query(true, DB.TABLE_CURRENCY, null, DB.KEY_COUNTRY_NAME + " like '%" + countryname + "%'", null, null, null, null, null);
		   
	    if ((history.getCount() == 0) || !history.moveToFirst()) {
		    history.close();
		    db.close();
		    return null;
	    }
	   
	    Currency newItem = new Currency();
	    newItem.setiD(history.getString(0));
	    newItem.setCurrencyId(history.getString(DB.CURRENCY_ID_COLUMN));
		newItem.setCurrencycode(history.getString(DB.CURRENCY_CODE_COLUMN));
		newItem.setUsdexrate(history.getString(DB.USD_EXRATE_COLUMN));
		newItem.setNairaexrate(history.getString(DB.NAIRA_EXRATE_COLUMN));
		newItem.setCountryName(history.getString(DB.COUNTRY_NAME_COLUMN));
	    
	    history.close();
	    db.close();
	    
	    return newItem;
    }
	
	public ArrayList<Currency> getAllCurrencies() {	
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DB.DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
	   Cursor history = db.query(DB.TABLE_CURRENCY, null, DB.KEY_CURRENCY_CODE + " = 'USD'", null, null, null, DB.KEY_COUNTRY_NAME);
		   
	   if (history.moveToFirst()){
		  currencies = new ArrayList<Currency>();
		  do {
			  Currency newItem = new Currency();
			  newItem.setiD(history.getString(0));
			  newItem.setCurrencyId(history.getString(DB.CURRENCY_ID_COLUMN));
			  newItem.setCurrencycode(history.getString(DB.CURRENCY_CODE_COLUMN));
			  newItem.setUsdexrate(history.getString(DB.USD_EXRATE_COLUMN));
			  newItem.setNairaexrate(history.getString(DB.NAIRA_EXRATE_COLUMN));
			  newItem.setCountryName(history.getString(DB.COUNTRY_NAME_COLUMN));
			  
			  currencies.add(newItem);
		  } while(history.moveToNext());
	   }
	   
	   history.close();
	   db.close();
	   
	   return currencies;
    }

	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	
	public String getCountryName() {
		return countryname;
	}
	public void setCountryName(String countryname) {
		this.countryname = countryname;
	}

	public String getUsdexrate() {
		return usdexrate;
	}
	public void setUsdexrate(String usdexrate) {
		this.usdexrate = usdexrate;
	}

	public String getNairaexrate() {
		return nairaexrate;
	}
	public void setNairaexrate(String nairaexrate) {
		this.nairaexrate = nairaexrate;
	}
}
