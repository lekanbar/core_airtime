package com.core.airtime;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CoreMerchant extends Activity {
	private String network, email, number, amount, transactionid, country, currency, 
	    		   countryid, calcamount, gatewayid, formattedamount, formattedphone, productid;
	private int networkindex, countryindex, chosenamountindex;
	
	//private DB db;
	UserPreferences pref;
	static int NEXTOPERATION = 1;
	ProgressDialog dialog;
	ArrayList<Network> nets;
	Gateway gate;
	ArrayList<Gateway> gates;
	Currency curr;
	AirTimeHistory history;
	static boolean isfirsttime = true;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
        pref = db.getPreference(1);
        db.close();
        
        setContentView(R.layout.coremerchant);
        
        //get from bundle
    	Bundle b = getIntent().getExtras();
    	gatewayid = b.getString("gatewayid");
    	number = b.getString("number");
    	email = b.getString("email");
    	amount = b.getString("amount");
    	network = b.getString("network");
    	countryid = b.getString("countryid");
    	productid = b.getString("productid");
    	networkindex = b.getInt("networkindex");
    	country = b.getString("country");
    	countryindex = b.getInt("countryindex");
    	chosenamountindex = b.getInt("chosenamountindex");
    	transactionid = b.getString("transactionid");
    	formattedamount = b.getString("formattedamount");
    	formattedphone = b.getString("formattedphone");
    	currency = b.getString("currency");
        
    	InitializeUI();
    }
    
    private void savePreferences() {
    	//Instantiate the database
    	DB db = new DB(this);
    	db.open();
        pref = db.getPreference(1);
    	pref.setEmail(email);
    	pref.setPhoneNumber(number);
    	pref.setAmount(amount);
    	pref.setChosenAmount("" + chosenamountindex);
    	pref.setNetworkIndex("" + networkindex);
		pref.setMerchantEmail(((EditText)findViewById(R.id.txtEmail)).getText().toString());				
		pref.setMerchantPassword(((EditText)findViewById(R.id.txtPassword)).getText().toString());
    	db.updatePreferences(1, pref);
    	db.close();
    }
    
    public void InitializeUI(){
    	Button cmdEnter_button = (Button)findViewById(R.id.cmdEnter);
    	cmdEnter_button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				dialog = ProgressDialog.show(CoreMerchant.this, getString(R.string.pingtitle), getString(R.string.ping), true);
				
				EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
				EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
				
				if(txtEmail.getText().toString().equals("") || !isEmailValid(txtEmail.getText().toString())){
					AlertDialog.Builder alert = new AlertDialog.Builder(CoreMerchant.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.chooseValidEmail);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							dialog.dismiss();
						}
	    			});
	    			alert.show();
					return;
				}
				
				Gateway gate = new Gateway(CoreMerchant.this);
				gate = gate.getGateway(gatewayid);
				
				//Check the DB
				DB db = new DB(getApplicationContext());
		    	db.open();
		    	if(!db.checkForTransID(transactionid)){
		    		history = new AirTimeHistory();
					history.setTransactionID(transactionid);
					history.setNetwork(network);
					history.setEmail(email);
					history.setPhoneNumber(number);
					history.setAmount(amount);
					history.setNetworkIndex(String.valueOf(networkindex));
					Calendar c = Calendar.getInstance();
					String hour = (String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY))); 
			    	String minute = (String.valueOf(c.get(Calendar.MINUTE)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE)));
					String datetime = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH + 1) + "/" +
							                         c.get(Calendar.YEAR) + " " + hour + ":" + 
							                         minute + (c.get(Calendar.AM_PM) == 0 ? " AM" : " PM"));
					history.setDateTime(datetime);
					history.setCurrency(currency);
					history.setTransactionStatus("0");
					history.setTopupStatus("0");
					history.setGatewayID(gate.getGatewayID());
					history.setAmountCharged(calcamount);
					history.setCountry(country);
					history.setCountryIndex(String.valueOf(countryindex));
					history.setChosenAmountIndex(String.valueOf(chosenamountindex));
					history.setPayUrl("");
					
					//Instantiate the database
					db.insertHistory(history);
					savePreferences();
		    	}
		    	
		    	db.close();
				
				//Get currency info
				Currency curr = new Currency(CoreMerchant.this);
				curr = curr.getCurrency(country);
				
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "10")); 
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            nameValuePairs.add(new BasicNameValuePair("merchant_email", txtEmail.getText().toString()));
	            nameValuePairs.add(new BasicNameValuePair("merchant_password", MD5(txtPassword.getText().toString())));
	            nameValuePairs.add(new BasicNameValuePair("tranx_id", transactionid));
	            nameValuePairs.add(new BasicNameValuePair("topup_amount", formattedamount));
	            nameValuePairs.add(new BasicNameValuePair("topup_currency", curr.getCurrencyId()));
	            nameValuePairs.add(new BasicNameValuePair("phone", formattedphone.replaceAll("-", "")));	            	
	            nameValuePairs.add(new BasicNameValuePair("customer_email", email));
	            nameValuePairs.add(new BasicNameValuePair("product_id", productid));
	            nameValuePairs.add(new BasicNameValuePair("os_code", "3"));
	            
	            API_Interact api = new API_Interact(API_Interact.TODO_CORE_MERCHANT, API_Interact.CLASSTYPE7, nameValuePairs, CoreMerchant.this);
				api.execute("");
			}
    	});
    	
    	EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
    	txtPassword.setText(pref.getMerchantPassword());
    	
    	EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
    	txtEmail.setText(pref.getMerchantEmail());
    	
    	ImageView payImg = (ImageView) findViewById(R.id.imgPaymentGateway);
    	TextView lblServiceby = (TextView) findViewById(R.id.lblServiceby);
    	
    	payImg.setImageDrawable(getResources().getDrawable(R.drawable.coremobile_logo));
    	lblServiceby.setText(getString(R.string.coremobile) + getString(R.string.andpowered));
    }

    public static String MD5(String text){
    	try{
    		MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
     
            byte byteData[] = md.digest();
     
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
            	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
	        
	        return sb.toString();
    	} catch(NoSuchAlgorithmException nsaex){
    		
    	}
    	
    	return text;
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	setContentView(R.layout.coremerchant);
    	InitializeUI();
    }
    
    public void done(String message){
		dialog.dismiss();
		
		if(!message.equals("")){
			DB db = new DB(getApplicationContext());
	    	db.open();
			history = db.getHistory(transactionid);
					
			if(message.toLowerCase().startsWith("suc"))
				history.setTransactionStatus("-1");
			else
				history.setTransactionStatus("-2");
			
			db.updateHistory(Long.parseLong(history.getID()), history);
			db.close();
			
			Intent i = new Intent(getApplicationContext(), TransactionReport.class);
			Bundle b = new Bundle();
			b.putString("number", number);
			b.putString("email", email);
			b.putString("network", network);
			b.putInt("networkindex", networkindex);
			b.putString("amount", amount);
			b.putString("transactionid", transactionid);
			b.putString("formattedamount", formattedamount);
			b.putString("formattedphone", formattedphone);
			b.putString("country", country);
			b.putString("currency", currency);
			b.putString("countryid", countryid);
			b.putInt("countryindex", countryindex);
			b.putInt("chosenamountindex", chosenamountindex);
			i.putExtras(b);
			startActivity(i);
			finish();
		}
		else{
    		AlertDialog.Builder alert = new AlertDialog.Builder(CoreMerchant.this);
			alert.setTitle(R.string.errorTitle);
			alert.setMessage(R.string.apierror);
			alert.setPositiveButton(R.string.tryag, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					
				}
			});
			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					Intent intent = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
		            Bundle b = new Bundle();
		        	b.putBoolean("new", false);
		        	intent.putExtras(b);
		        	CoreAirTimeActivity.isfirst = true;
		            startActivity(intent);
		            finish();
				}
			});
			alert.show();
	    }
    }
    
    public boolean isEmailValid(String email){
        String regExpn =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                  +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                  +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                  +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                  +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

	     CharSequence inputStr = email;
	
	     Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
	     Matcher matcher = pattern.matcher(inputStr);
	
	     if(matcher.matches())
	        return true;
	     else
	        return false;
   }
    
    @Override
    public void onDestroy() {
    	//db.close();
    	super.onDestroy();
    }
}