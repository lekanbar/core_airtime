package com.core.airtime;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
 
import java.util.ArrayList;
 
public class DB {
 
   public static final String DATABASE_NAME = "coreairtime.db";
   private static final int DATABASE_VERSION = 2;
   
   private static final String TABLE_AIRTIME_HISTORY = "airtime_history";
   private static final String TABLE_PREFERENCES = "user_preferences";
   public static final String TABLE_NETWORK = "network";
   public static final String TABLE_CURRENCY = "currency";
   public static final String TABLE_NETWORK_FACE = "networkfacevalues";
   public static final String TABLE_GATEWAY = "gateway";
   public static final String TABLE_NETWORK_GATEWAY = "networkgateway";
   
   public static final String KEY_ID = "_id";
   
   //Columns for transactions table
   public static final String KEY_USER_EMAIL = "email";
   public static final int USER_EMAIL_COLUMN = 1;
   public static final String KEY_USER_NUMBER = "phonenumber";
   public static final int USER_NUMBER_COLUMN = 2;
   public static final String KEY_NETWORK = "network";
   public static final int NETWORK_COLUMN = 3;
   public static final String KEY_AMOUNT = "amount";
   public static final int AMOUNT_COLUMN = 4;
   public static final String KEY_DATE_TIME = "datetime";
   public static final int DATE_TIME_COLUMN = 5;
   public static final String KEY_NETWORK_INDEX = "networkindex";
   public static final int NETWORK_INDEX_COLUMN = 6;
   public static final String KEY_TRANSACTION_ID = "transactionid";
   public static final int TRANSACTION_ID_COLUMN = 7;
   public static final String KEY_TRANSACTION_STATUS = "transactionstatus";
   public static final int TRANSACTION_STATUS_COLUMN = 8;
   public static final String KEY_COUNTRY = "country";
   public static final int COUNTRY_COLUMN = 9;
   public static final String KEY_COUNTRY_INDEX = "countryindex";
   public static final int COUNTRY_INDEX_COLUMN = 10;
   public static final String KEY_CHOSEN_AMOUNT_INDEX = "chosenamountindex";
   public static final int CHOSEN_AMOUNT_INDEX_COLUMN = 11;
   public static final String KEY_CURRENCY = "currency";
   public static final int CURRENCY_COLUMN = 12;
   public static final String KEY_TOPUP_STATUS = "topupstatus";
   public static final int TOPUP_STATUS_COLUMN = 13;
   public static final String KEY_SERVER_TIME = "servertime";
   public static final int SERVER_TIME_COLUMN = 14;
   public static final String KEY_GATEWAY_ID3 = "gatewayid";
   public static final int GATEWAY_ID3_COLUMN = 15;
   public static final String KEY_AMOUNT_CHARGED = "amountcharged";
   public static final int AMOUNT_CHARGED_COLUMN = 16;
   public static final String KEY_PAY_URL = "payurl";
   public static final int PAY_URL_COLUMN = 17;
   
   //Columns for User prefs table
   public static final String KEY_LANGUAGE = "languageindex";
   public static final int LANGUAGE_COLUMN = 3;
   public static final String KEY_ISFIRSTTIME = "isfirsttime";
   public static final int ISFIRSTTIME_COLUMN = 5;
   public static final String KEY_LOCALUSD = "localusdindex";
   public static final int LOCALUSD_COLUMN = 6;
   public static final String KEY_COUNTRYINDEX = "countryindex";
   public static final int COUNTRYINDEX_COLUMN = 7;
   public static final String KEY_CHOSENAMOUNT = "chosenamountindex";
   public static final int CHOSENAMOUNT_COLUMN = 8;
   public static final String KEY_NETWORKINDEX = "networkindex";
   public static final int NETWORKINDEX_COLUMN = 9;
   public static final String KEY_DISCOUNTCODE = "discountcode";
   public static final int DISCOUNTCODE_COLUMN = 10;
   public static final String KEY_FORMATTED_PHONE = "formattedphone";
   public static final int FORMATTED_PHONE_COLUMN = 11;
   public static final String KEY_FORMATTED_AMOUNT = "formattedamount";
   public static final int FORMATTED_AMOUNT_COLUMN = 12;
   public static final String KEY_AUTHTOKEN = "authtoken";
   public static final int AUTHTOKEN_COLUMN = 13;
   public static final String KEY_CHECK_FOR_UPDATE = "checkforupdate";
   public static final int CHECK_FOR_UPDATE_COLUMN = 14;
   public static final String KEY_MERCHANT_EMAIL = "merchantemail";
   public static final int MERCHANT_EMAIL_COLUMN = 15;
   public static final String KEY_MERCHANT_PASSWORD = "merchantpassword";
   public static final int MERCHANT_PASSWORD_COLUMN = 16;
   
   //Networks
   public static final String KEY_NETWORK_ID = "operatorid";
   public static final int NETWORK_ID_COLUMN = 1;
   public static final String KEY_PRODUCT_ID = "productid";
   public static final int PRODUCT_ID_COLUMN = 2;
   public static final String KEY_NETWORK_NAME = "networkname";
   public static final int NETWORK_NAME_COLUMN = 3;
   public static final String KEY_LOCAL_MIN_VALUE = "localminvalue";
   public static final int LOCAL_MIN_VALUE_COLUMN = 4;
   public static final String KEY_LOCAL_MAX_VALUE = "localmaxvalue";
   public static final int LOCAL_MAX_VALUE_COLUMN = 5;
   public static final String KEY_USD_MIN_VALUE = "usdminvalue";
   public static final int USD_MIN_VALUE_COLUMN = 6;
   public static final String KEY_USD_MAX_VALUE = "usdmaxvalue";
   public static final int USD_MAX_VALUE_COLUMN = 7;
   public static final String KEY_PHONE_NUMBER_LENGHT = "phonenumberlenght";
   public static final int PHONE_NUMBER_LENGHT_COLUMN = 8;
   public static final String KEY_CALLING_CODE = "callingcode";
   public static final int CALLING_CODE_COLUMN = 9;
   public static final String KEY_NETWORK_CURRENCY = "currency";
   public static final int NETWORK_CURRENCY_COLUMN = 10;
   public static final String KEY_IS_FIXED = "isfixed";
   public static final int IS_FIXED_COLUMN = 11;
   public static final String KEY_COUNTRY_ID = "countryid";
   public static final int COUNTRY_ID_COLUMN = 12;
   public static final String KEY_IS_USD_DENOM = "isusddenom";
   public static final int IS_USD_DENOM_COLUMN = 13;
   
   //NetWork Local/USD Face Values
   public static final String KEY_LOCAL_VALUE = "localvalue";
   public static final int LOCAL_VALUE_COLUMN = 2;
   public static final String KEY_USD_VALUE = "usdvalue";
   public static final int USD_VALUE_COLUMN = 3;
   
   //Payment Gateways
   public static final String KEY_GATEWAY_ID = "gatewayid";
   public static final int GATEWAY_ID_COLUMN = 1;
   public static final String KEY_GATEWAY_CURRENCY2 = "gatewaycurrency";
   public static final int GATEWAY_CURRENCY2_COLUMN = 2;
   public static final String KEY_GATEWAY_NAME = "gatewayname";
   public static final int GATEWAY_NAME_COLUMN = 3;
   public static final String KEY_IS_GATEWAY_READY = "isgatewayready";
   public static final int IS_GATEWAY_READY_COLUMN = 4;
   
   //Payment Gateways and Network relationship
   public static final String KEY_GATEWAY_ID2 = "gatewayid";
   public static final int GATEWAY_ID2_COLUMN = 1;
   public static final String KEY_NETWORK_ID2 = "networkid";
   public static final int NETWORK_ID2_COLUMN = 2;
   public static final String KEY_LOCAL_COEFF_VALUE = "localcoeffvalue";
   public static final int LOCAL_COEFF_VALUE_COLUMN = 3;
   public static final String KEY_USD_COEFF_VALUE = "usdcoeffvalue";
   public static final int USD_COEFF_VALUE_COLUMN = 4;
   public static final String KEY_COUNTRY_ID2 = "countryid";
   public static final int COUNTRY_ID2_COLUMN = 5;
   
   //Currency Exchange Rates
   public static final String KEY_CURRENCY_ID = "currencyid";
   public static final int CURRENCY_ID_COLUMN = 1;
   public static final String KEY_CURRENCY_CODE = "currencycode";
   public static final int CURRENCY_CODE_COLUMN = 2;
   public static final String KEY_USD_EXRATE = "usdexrate";
   public static final int USD_EXRATE_COLUMN = 3;
   public static final String KEY_NAIRA_EXRATE = "nairaexrate";
   public static final int NAIRA_EXRATE_COLUMN = 4;
   public static final String KEY_COUNTRY_NAME = "countryname";
   public static final int COUNTRY_NAME_COLUMN = 5;
   
   //Columns for User table
   private Context context;
   private SQLiteDatabase db;
   private OpenHelper dbHelper;
 
   public DB(Context context) {
      this.context = context;
      dbHelper = new OpenHelper(this.context);
   }
   
   public DB open() throws SQLiteException {	   
	   try {
		   db = dbHelper.getWritableDatabase();
	   } catch (SQLiteException ex) {
		   db = dbHelper.getReadableDatabase();
	   }
	   return this;
   }
   
   public void close() {
	   db.close();
   }
 
   // Insert a new airtime history
   public void insertHistory(AirTimeHistory _airtime) {
	   // Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;
       db = SQLiteDatabase.openDatabase(context.getDatabasePath("coreairtime.db").getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "INSERT INTO airtime_history (email, phonenumber, network, amount, datetime, networkindex, transactionid, transactionstatus, " +
       		        "country, countryindex, chosenamountindex, currency, topupstatus, servertime, gatewayid, amountcharged, payurl) VALUES('" + _airtime.getEmail() + "','" 
                                                                                    + _airtime.getPhoneNumber() + "','"
                                                                                    + _airtime.getNetwork() + "','"
                                                                                    + _airtime.getAmount() + "','"
                                                                                    + _airtime.getDateTime() + "','"
                                                                                    + _airtime.getNetworkIndex() + "','"
                                                                                    + _airtime.getTransactionID() + "','"
                                                                                    + _airtime.getTransactionStatus() + "','"
                                                                                    + _airtime.getCountry() + "','"
                                                                                    + _airtime.getCountryIndex() + "','"
                                                                                    + _airtime.getChosenAmountIndex() + "','"
                                                                                    + _airtime.getCurrency() + "','"
                                                                                    + _airtime.getTopupStatus() + "','"
                                                                                    + _airtime.getServerTime() + "','"
                                                                                    + _airtime.getGatewayID() + "','"
                                                                                    + _airtime.getAmountCharged() + "','" 
                                                                                    + _airtime.getPayUrl() + "');";
       db.execSQL(sql);
       db.close();
   }
   
   // Insert a Preferences
   public void insertUserPreferences(UserPreferences _pref) {
	   // Create a new row of values to insert.
	   // Insert the row.
	   SQLiteDatabase db;//"/data/data/com.core.airtime/databases/coreairtime.db"
       db = SQLiteDatabase.openDatabase(context.getDatabasePath("coreairtime.db").getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "INSERT INTO user_preferences (email, phonenumber, languageindex, amount, isfirsttime, localusdindex, countryindex, chosenamountindex, " +
       		        "networkindex, discountcode, formattedphone, formattedamount, authtoken, checkforupdate, merchantemail, merchantpassword) VALUES('" 
                                                                                    + _pref.getEmail() + "','" 
                                                                                    + _pref.getPhoneNumber() + "','"
                                                                                    + _pref.getLanguageIndex() + "','"
                                                                                    + _pref.getAmount() + "','"
                                                                                    + _pref.getIsFirstTime() + "','"
                                                                                    + _pref.getLocalUsdIndex() + "','"
                                                                                    + _pref.getCountryIndex() + "','"
                                                                                    + _pref.getChosenAmount() + "','" 
                                                                                    + _pref.getNetworkIndex() + "','" 
                                                                                    + _pref.getDiscountCode() + "','" 
                                                                                    + _pref.getFormattedPhoneNumber() + "','" 
                                                                                    + _pref.getFormattedAmount() + "','" 
                                                                                    + _pref.getAuthToken() + "','" 
                                                                                    + _pref.getCheckforUpdate() + "','" 
                                                                                    + _pref.getMerchantEmail() + "','" 
                                                                                    + _pref.getMerchantPassword() + "');";
       db.execSQL(sql);
       db.close();
   }
   
   // Update airtime History
   public void updateHistory(long _rowIndex, AirTimeHistory ah) {	
	   // Update the row.
	   SQLiteDatabase db;
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update airtime_history set email = '" + ah.getEmail() + "', phonenumber = '" 
	                        + ah.getPhoneNumber() + "', network = '" + ah.getNetwork()
	                        + "', amount = '" + ah.getAmount()
	                        + "', datetime = '" + ah.getDateTime()
	                        + "', networkindex = '" + ah.getNetworkIndex()
	                        + "', transactionid = '" + ah.getTransactionID()
	                        + "', transactionstatus = '" + ah.getTransactionStatus()
	                        + "', country = '" + ah.getCountry()
	                        + "', countryindex = '" + ah.getCountryIndex()
	                        + "', chosenamountindex = '" + ah.getChosenAmountIndex()
	                        + "', currency = '" + ah.getCurrency()
	                        + "', topupstatus = '" + ah.getTopupStatus()
	                        + "', servertime = '" + ah.getServerTime()
	                        + "', gatewayid = '" + ah.getGatewayID()
	                        + "', amountcharged = '" + ah.getAmountCharged()
	                        + "', payurl = '" + ah.getPayUrl()
	                        + "' where _id = " + _rowIndex;
       db.execSQL(sql);
       db.close();
   }
   
   // Update Preferences
   public void updatePreferences(long _rowIndex, UserPreferences pref) {	
	   // Update the row.
	   SQLiteDatabase db;
       db = SQLiteDatabase.openDatabase(context.getDatabasePath(DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Update user_preferences set email = '" + pref.getEmail() + "', phonenumber = '" 
	                        + pref.getPhoneNumber() + "', languageindex = '" + pref.getLanguageIndex()
	                        + "', amount = '" + pref.getAmount()
	                        + "', isfirsttime = '" + pref.getIsFirstTime()
	                        + "', localusdindex = '" + pref.getLocalUsdIndex()
	                        + "', countryindex = '" + pref.getCountryIndex()
	                        + "', chosenamountindex = '" + pref.getChosenAmount()
	                        + "', networkindex = '" + pref.getNetworkIndex()
	                        + "', discountcode = '" + pref.getDiscountCode()
	                        + "', formattedphone = '" + pref.getFormattedPhoneNumber()
	                        + "', formattedamount = '" + pref.getFormattedAmount()
	                        + "', checkforupdate = '" + pref.getCheckforUpdate()
	                        + "', authtoken = '" + pref.getAuthToken()
	                        + "', merchantemail = '" + pref.getMerchantEmail()
	                        + "', merchantpassword = '" + pref.getMerchantPassword()
	                        + "' where _id = " + _rowIndex;
       db.execSQL(sql);
       db.close();
   }
 
   // Remove history based on its index
   public void removeHistory(long _rowIndex) {
	// Delete the row.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Delete from airtime_history where _id = " + _rowIndex; 
       db.execSQL(sql);
       db.close();
   }
   
   // Remove all history
   public void removeAllHistory() {
	   // Delete all.
	   SQLiteDatabase db = SQLiteDatabase.openDatabase(context.getDatabasePath(DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.CREATE_IF_NECESSARY);
                
       String sql = "Delete from airtime_history"; 
       db.execSQL(sql);
       db.close();
   }
    
   //Get All stored History
   public ArrayList<AirTimeHistory> getAllHistory() {
	   Cursor histories = db.query(TABLE_AIRTIME_HISTORY, null, null, null, null, null, KEY_ID + " DESC");
	   
	   ArrayList<AirTimeHistory> result = new ArrayList<AirTimeHistory>();
	    if (histories.moveToFirst()){
		   do {
			   AirTimeHistory newItem = new AirTimeHistory();
			   newItem.setID(histories.getString(0));
			   newItem.setEmail(histories.getString(USER_EMAIL_COLUMN));
			   newItem.setPhoneNumber(histories.getString(USER_NUMBER_COLUMN));
			   newItem.setNetwork(histories.getString(NETWORK_COLUMN));
			   newItem.setAmount(histories.getString(AMOUNT_COLUMN));
			   newItem.setDateTime(histories.getString(DATE_TIME_COLUMN));
			   newItem.setNetworkIndex(histories.getString(NETWORK_INDEX_COLUMN));
			   newItem.setTransactionID(histories.getString(TRANSACTION_ID_COLUMN));
			   newItem.setTransactionStatus(histories.getString(TRANSACTION_STATUS_COLUMN));
			   newItem.setCountry(histories.getString(COUNTRY_COLUMN));
			   newItem.setCountryIndex(histories.getString(COUNTRY_INDEX_COLUMN));
			   newItem.setChosenAmountIndex(histories.getString(CHOSEN_AMOUNT_INDEX_COLUMN));
			   newItem.setCurrency(histories.getString(CURRENCY_COLUMN));
			   newItem.setTopupStatus(histories.getString(TOPUP_STATUS_COLUMN));
			   newItem.setGatewayID(histories.getString(GATEWAY_ID3_COLUMN));
			   newItem.setServerTime(histories.getString(SERVER_TIME_COLUMN));
			   newItem.setAmountCharged(histories.getString(AMOUNT_CHARGED_COLUMN));
			   newItem.setPayUrl(histories.getString(PAY_URL_COLUMN));
			   
			   result.add(newItem);
		   } while(histories.moveToNext());
	    }
	    
	    histories.close();
	    
	   return result;
	}
   
   public AirTimeHistory getHistory(String transid) throws SQLException {
	   Cursor history = db.query(true, TABLE_AIRTIME_HISTORY,  null, KEY_TRANSACTION_ID + " = '" + transid + "'", null, null, null, null, null);
	   
	   if ((history.getCount() == 0) || !history.moveToFirst()) {
		   history.close();
		   return null;
	   }
	   
	   AirTimeHistory newItem = new AirTimeHistory();
	   newItem.setID(history.getString(0));
	   newItem.setEmail(history.getString(USER_EMAIL_COLUMN));
	   newItem.setPhoneNumber(history.getString(USER_NUMBER_COLUMN));
	   newItem.setNetwork(history.getString(NETWORK_COLUMN));
	   newItem.setAmount(history.getString(AMOUNT_COLUMN));
	   newItem.setDateTime(history.getString(DATE_TIME_COLUMN));
	   newItem.setNetworkIndex(history.getString(NETWORK_INDEX_COLUMN));
	   newItem.setTransactionID(history.getString(TRANSACTION_ID_COLUMN));
	   newItem.setTransactionStatus(history.getString(TRANSACTION_STATUS_COLUMN));
	   newItem.setCountry(history.getString(COUNTRY_COLUMN));
	   newItem.setCountryIndex(history.getString(COUNTRY_INDEX_COLUMN));
	   newItem.setChosenAmountIndex(history.getString(CHOSEN_AMOUNT_INDEX_COLUMN));
	   newItem.setCurrency(history.getString(CURRENCY_COLUMN));
	   newItem.setTopupStatus(history.getString(TOPUP_STATUS_COLUMN));
	   newItem.setGatewayID(history.getString(GATEWAY_ID3_COLUMN));
	   newItem.setServerTime(history.getString(SERVER_TIME_COLUMN));
	   newItem.setAmountCharged(history.getString(AMOUNT_CHARGED_COLUMN));
	   newItem.setPayUrl(history.getString(PAY_URL_COLUMN));
	   
	   history.close();
	   
	   return newItem;
	}
   
   public AirTimeHistory getHistory(long _rowindex) throws SQLException {
	   Cursor history = db.query(true, TABLE_AIRTIME_HISTORY,  null, KEY_ID + " = " + _rowindex, null, null, null, null, null);
	   
	   if ((history.getCount() == 0) || !history.moveToFirst()) {
		   history.close();
		   return null;
	   }
	   
	   AirTimeHistory newItem = new AirTimeHistory();
	   newItem.setID(history.getString(0));
	   newItem.setEmail(history.getString(USER_EMAIL_COLUMN));
	   newItem.setPhoneNumber(history.getString(USER_NUMBER_COLUMN));
	   newItem.setNetwork(history.getString(NETWORK_COLUMN));
	   newItem.setAmount(history.getString(AMOUNT_COLUMN));
	   newItem.setDateTime(history.getString(DATE_TIME_COLUMN));
	   newItem.setNetworkIndex(history.getString(NETWORK_INDEX_COLUMN));
	   newItem.setTransactionID(history.getString(TRANSACTION_ID_COLUMN));
	   newItem.setTransactionStatus(history.getString(TRANSACTION_STATUS_COLUMN));
	   newItem.setCountry(history.getString(COUNTRY_COLUMN));
	   newItem.setCountryIndex(history.getString(COUNTRY_INDEX_COLUMN));
	   newItem.setChosenAmountIndex(history.getString(CHOSEN_AMOUNT_INDEX_COLUMN));
	   newItem.setCurrency(history.getString(CURRENCY_COLUMN));
	   newItem.setTopupStatus(history.getString(TOPUP_STATUS_COLUMN));
	   newItem.setGatewayID(history.getString(GATEWAY_ID3_COLUMN));
	   newItem.setServerTime(history.getString(SERVER_TIME_COLUMN));
	   newItem.setAmountCharged(history.getString(AMOUNT_CHARGED_COLUMN));
	   newItem.setPayUrl(history.getString(PAY_URL_COLUMN));
	   
	   history.close();
	   
	   return newItem;
	}
   
   public UserPreferences getPreference(long _rowIndex) throws SQLException {
	   Cursor history = db.query(true, TABLE_PREFERENCES,  null, KEY_ID + "=" + _rowIndex, null, null, null, null, null);
	   
	   if ((history.getCount() == 0) || !history.moveToFirst()) {
		   history.close();
		   return null;
	   }
	   
	   UserPreferences newItem = new UserPreferences();
	   newItem.setID(history.getString(0));
	   newItem.setEmail(history.getString(USER_EMAIL_COLUMN));
	   newItem.setPhoneNumber(history.getString(USER_NUMBER_COLUMN));
	   newItem.setLanguageIndex(history.getString(LANGUAGE_COLUMN));
	   newItem.setAmount(history.getString(AMOUNT_COLUMN));
	   newItem.setIsFirstTime(history.getString(ISFIRSTTIME_COLUMN));
	   newItem.setLocalUsdIndex(history.getString(LOCALUSD_COLUMN));
	   newItem.setCountryIndex(history.getString(COUNTRYINDEX_COLUMN));
	   newItem.setChosenAmount(history.getString(CHOSENAMOUNT_COLUMN));
	   newItem.setNetworkIndex(history.getString(NETWORKINDEX_COLUMN));
	   newItem.setDiscountCode(history.getString(DISCOUNTCODE_COLUMN));
	   newItem.setFormattedPhoneNumber(history.getString(FORMATTED_PHONE_COLUMN));
	   newItem.setFormattedAmount(history.getString(FORMATTED_AMOUNT_COLUMN));
	   newItem.setAuthToken(history.getString(AUTHTOKEN_COLUMN));
	   newItem.setCheckforUpdate(history.getString(CHECK_FOR_UPDATE_COLUMN));
	   newItem.setMerchantEmail(history.getString(MERCHANT_EMAIL_COLUMN));
	   newItem.setMerchantPassword(history.getString(MERCHANT_PASSWORD_COLUMN));
	   
	   history.close();
	   
	   return newItem;
	}
   
   public boolean checkForTransID(String transid) throws SQLException {
	   Cursor history = db.query(true, TABLE_AIRTIME_HISTORY,  new String[] {KEY_ID, KEY_TRANSACTION_ID},
			   KEY_TRANSACTION_ID + "='" + transid + "'", null, null, null, null, null);
	   
	   if ((history.getCount() == 0) || !history.moveToFirst()){
		   history.close();
		   return false;
	   }
	   else{
		   history.close();
		   return true;
	   }
   }
   
   public String getTransDBID(String transid) throws SQLException {
	   Cursor history = db.query(true, TABLE_AIRTIME_HISTORY,  new String[] {KEY_ID, KEY_TRANSACTION_ID},
			   KEY_TRANSACTION_ID + "='" + transid + "'", null, null, null, null, null);
	   
	   String ret = null;
	   if ((history.getCount() == 0) || !history.moveToFirst()){
	   }
	   else
		   ret = history.getString(0);
	   
	   history.close();
	   return ret;
	}
 
   public static class OpenHelper extends SQLiteOpenHelper {
 
      OpenHelper(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
      }
      
      private static final String DATABASE_CREATE = "create table " + TABLE_AIRTIME_HISTORY + " (" + KEY_ID + " integer primary key autoincrement, " + 
    		  KEY_USER_EMAIL + " text not null, " + KEY_USER_NUMBER + " text not null, " + KEY_NETWORK + " text not null, " +
    		  KEY_AMOUNT + " text not null, " + KEY_DATE_TIME + " text not null, " + KEY_NETWORK_INDEX + " text not null, " + 
    		  KEY_TRANSACTION_ID + " text not null, " + KEY_TRANSACTION_STATUS + " text not null, " + KEY_COUNTRY + " text not null, " + 
    		  KEY_COUNTRY_INDEX + " text not null, " + KEY_CHOSEN_AMOUNT_INDEX + " text not null, " + KEY_CURRENCY + " text not null, " + 
    		  KEY_TOPUP_STATUS + " text not null, " + KEY_SERVER_TIME + " text not null, " + KEY_GATEWAY_ID3 + " text not null, " + 
    		  KEY_AMOUNT_CHARGED + " text not null, " + KEY_PAY_URL + " text not null);";
      
      private static final String DATABASE_CREATE2 = "create table " + TABLE_PREFERENCES + " (" + KEY_ID + " integer primary key autoincrement, " + 
     		  KEY_USER_EMAIL + " text not null, " + KEY_USER_NUMBER + " text not null, " + KEY_LANGUAGE + " text not null, " +
     		  KEY_AMOUNT + " text not null, " + KEY_ISFIRSTTIME + " text not null, " + KEY_LOCALUSD + " text not null, " + 
     		  KEY_COUNTRY_INDEX + " text not null, " + KEY_CHOSENAMOUNT + " text not null, " + KEY_NETWORKINDEX + " text not null, " +
     		  KEY_DISCOUNTCODE + " text not null, " + KEY_FORMATTED_PHONE + " text not null, " + KEY_FORMATTED_AMOUNT + " text not null, " + 
     		  KEY_AUTHTOKEN + " text not null, " + KEY_CHECK_FOR_UPDATE + " text not null, " + KEY_MERCHANT_EMAIL + " text not null, " + 
     		  KEY_MERCHANT_PASSWORD + " text not null);";
      
      private static final String DATABASE_CREATE3 = "create table " + TABLE_NETWORK + " (" + KEY_ID + " integer primary key autoincrement, " + 
    		  KEY_NETWORK_ID + " text not null, " + KEY_PRODUCT_ID + " text not null, " + KEY_NETWORK_NAME + " text not null, " +
    		  KEY_LOCAL_MIN_VALUE + " text not null, " + KEY_LOCAL_MAX_VALUE + " text not null, " + KEY_USD_MIN_VALUE + " text not null, " + 
    		  KEY_USD_MAX_VALUE + " text not null, " + KEY_PHONE_NUMBER_LENGHT + " text not null, " + KEY_CALLING_CODE + " text not null, " +
    		  KEY_NETWORK_CURRENCY + " text not null, " + KEY_IS_FIXED + " text not null, " + KEY_COUNTRY_ID + " text not null, " + 
    		  KEY_IS_USD_DENOM + " text not null);";
                              
      private static final String DATABASE_CREATE4 = "create table " + TABLE_GATEWAY + " (" + KEY_ID + " integer primary key autoincrement, " + 
    		  KEY_GATEWAY_ID + " text not null, " + KEY_GATEWAY_CURRENCY2 + " text not null, " + KEY_GATEWAY_NAME + " text not null, " + 
    		  KEY_IS_GATEWAY_READY + " text not null);";
      
      private static final String DATABASE_CREATE5 = "create table " + TABLE_NETWORK_FACE + " (" + KEY_ID + " integer primary key autoincrement, " + 
    		  KEY_NETWORK_ID + " text not null, " + KEY_LOCAL_VALUE + " text not null, " + KEY_USD_VALUE + " text not null);";
      
      private static final String DATABASE_CREATE6 = "create table " + TABLE_NETWORK_GATEWAY + " (" + KEY_ID + " integer primary key autoincrement, " + 
    		  KEY_GATEWAY_ID2 + " text not null, " + KEY_NETWORK_ID2 + " text not null, " + KEY_LOCAL_COEFF_VALUE + " text not null, " +
    		  KEY_USD_COEFF_VALUE + " text not null, " + KEY_COUNTRY_ID2 + " text not null);";
      
      private static final String DATABASE_CREATE7 = "create table " + TABLE_CURRENCY + " (" + KEY_ID + " integer primary key autoincrement, " + 
    		  KEY_CURRENCY_ID + " text not null, " + KEY_CURRENCY_CODE + " text not null, " + KEY_USD_EXRATE + " text not null, " +
    		  KEY_NAIRA_EXRATE + " text not null, " + KEY_COUNTRY_NAME + " text not null);";
 
      @Override
      public void onCreate(SQLiteDatabase db) {
         db.execSQL(DATABASE_CREATE);
         db.execSQL(DATABASE_CREATE2);
         db.execSQL(DATABASE_CREATE3);
         db.execSQL(DATABASE_CREATE4);
         db.execSQL(DATABASE_CREATE5);
         db.execSQL(DATABASE_CREATE6);
         db.execSQL(DATABASE_CREATE7);
      }
 
      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_AIRTIME_HISTORY);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREFERENCES);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_NETWORK);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_GATEWAY);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_NETWORK_FACE);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_NETWORK_GATEWAY);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURRENCY);
         onCreate(db);
      }
   }
}
