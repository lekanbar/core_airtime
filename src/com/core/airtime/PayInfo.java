package com.core.airtime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

 public class PayInfo extends Activity {
	 
	 private String network, networkid, email, number, amount, transactionid, /*transactionstatus,*/ country, countryid, currency, 
	                calcamount, gatewayid, formattedamount, formattedphone, productid;
	 private int networkindex, countryindex, chosenamountindex, paygate;
	
	 AirTimeHistory history;
	 UserPreferences pref;
	 ProgressDialog dialog;
	 API_Interact api;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
        pref = db.getPreference(1);
    	db.close();
        
        Configuration conf = this.getResources().getConfiguration();    	
    	if(conf.orientation == 2)
    		setContentView(R.layout.payinfo);
    	else
    		setContentView(R.layout.payinfoport);    	
    	
    	//get from bundle
    	Bundle b = getIntent().getExtras();
    	//calcamount = b.getString("calcamount");
    	paygate = b.getInt("paygate");
    	gatewayid = b.getString("gatewayid");
    	number = b.getString("number");
    	email = b.getString("email");
    	amount = b.getString("amount");
    	network = b.getString("network");
    	networkid = b.getString("networkid");
    	productid = b.getString("productid");
    	networkindex = b.getInt("networkindex");
    	country = b.getString("country");
    	countryid = b.getString("countryid");
    	countryindex = b.getInt("countryindex");
    	chosenamountindex = b.getInt("chosenamountindex");
    	transactionid = b.getString("transactionid");
    	//transactionstatus = b.getString("transactionstatus");
    	formattedamount = b.getString("formattedamount");
    	formattedphone = b.getString("formattedphone");
    	currency = b.getString("currency");
    	//language = b.getString("language");
    	
    	//int updateLocalUsdIndex = Integer.parseInt(pref.getLocalUsdIndex());
    	//Resources r = getResources();
    	//localusd = r.getStringArray(R.array.localusd_options)[updateLocalUsdIndex];
    	//localusdindex =  updateLocalUsdIndex;
    	
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
    	db.updatePreferences(1, pref);
    	db.close();
    }
    
    public void InitializeUI(){
    	setTitle(getString(R.string.vpay));
    	
    	TextView lblTopupAmount = (TextView) findViewById(R.id.lblTopupAmt);
    	lblTopupAmount.setText(currency + " " + amount);
    	
    	TextView lblTransId = (TextView) findViewById(R.id.lblTransactionID);
    	lblTransId.setText(transactionid);
    	
    	TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
    	lblEmail.setText(email);
    	
    	TextView lblAmount = (TextView) findViewById(R.id.lblAmount);
    	GatewayNetwork gaten = new GatewayNetwork();
    	gaten.setNetworkID(networkid);
    	gaten.setGatewayID(gatewayid);
    	gaten = gaten.getGatewayNetwork(PayInfo.this);
    	
    	//Gateway gate = new Gateway(PayInfo.this);
		//gate = gate.getGateway(gatewayid);
    	//Currency gatecurr = new Currency(PayInfo.this);
    	//gatecurr = gatecurr.getCurrencyByCode(gate.getCurrency());
    	
    	if(gaten != null){
	    	if(currency.equals("USD")){
	    		calcamount = String.valueOf(Double.parseDouble(formattedamount) * Double.parseDouble(gaten.getUSDCoeffValue()));
	    	}
	    	else{
	    		calcamount = String.valueOf(Double.parseDouble(formattedamount) * Double.parseDouble(gaten.getLocalCoeffValue()));
	    	}
	    	
	    	java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
    		calcamount = df.format(Double.parseDouble(calcamount));
	    	lblAmount.setText(currency + " " + calcamount);
	    	/*if(gatecurr.getCurrencycode().equals("USD")){
    			calcamount = String.valueOf(Double.parseDouble(calcamount) * Double.parseDouble(gatecurr.getUsdexrate()));
    			
    			java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        		calcamount = df.format(Double.parseDouble(calcamount));
    	    	lblAmount.setText(currency + " " + calcamount);
    		}
    		else{
    			calcamount = String.valueOf(Double.parseDouble(calcamount) * Double.parseDouble(gatecurr.getNairaexrate()));
    			
    			java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        		calcamount = df.format(Double.parseDouble(calcamount));
    	    	lblAmount.setText("NGN " + calcamount);
    		}*/
    	}
    	else{
    		calcamount = formattedamount;
    		lblAmount.setText(currency + " " + calcamount);
    	}
    	
    	ImageView payImg = (ImageView) findViewById(R.id.imgPaymentGateway);
    	TextView lblServiceby = (TextView) findViewById(R.id.lblServiceby);
    	
    	if(paygate == 0){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.googlecheck_logo));
    		lblServiceby.setText(getString(R.string.google) + getString(R.string.andpowered));
    	}
    	else if(paygate == 1){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.verve_logo));
	    	lblServiceby.setText(getString(R.string.interswitch) + getString(R.string.andpowered));
		}
    	else if(paygate == 2){
	    	payImg.setImageDrawable(getResources().getDrawable(R.drawable.visanaira_logo));
    		lblServiceby.setText(getString(R.string.verifiedvisa) + getString(R.string.andpowered));
		}
    	else if(paygate == 3){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.mastercardnaira_logo));
	    	lblServiceby.setText(getString(R.string.stanbic) + getString(R.string.andpowered));
		}
    	else if(paygate == 4){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.giftcodex_logo));
    		lblServiceby.setText(getString(R.string.giftcode) + getString(R.string.andpowered));
    	}
    	else if(paygate == 5){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.discover_logo));
    		lblServiceby.setText(getString(R.string.discover) + getString(R.string.andpowered));
		}
    	else if(paygate == 6){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.visa_logo));
	    	lblServiceby.setText(getString(R.string.visa) + getString(R.string.andpowered));
		}
    	else if(paygate == 7){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.mastercard_logo));
    		lblServiceby.setText(getString(R.string.mastercard) + getString(R.string.andpowered));
		}
    	else if(paygate == 8){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.etranzact_logo));
    		lblServiceby.setText(getString(R.string.etranzact) + getString(R.string.andpowered));
		}
    	else if(paygate == 9){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.coremobile_logo));
    		lblServiceby.setText(getString(R.string.coremobile) + getString(R.string.andpowered));
		}
    	else if(paygate == 10){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.amazoncheck_logo));
    		lblServiceby.setText(getString(R.string.amazon) + getString(R.string.andpowered));
		}
    	else if(paygate == 11){
    		payImg.setImageDrawable(getResources().getDrawable(R.drawable.paypal_logo));
    		lblServiceby.setText(getString(R.string.paypal) + getString(R.string.andpowered));
		}
    	
    	Button cmdProceed = (Button)findViewById(R.id.cmdPay);
    	cmdProceed.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				dialog = ProgressDialog.show(PayInfo.this, getString(R.string.pingtitle), getString(R.string.ping), true);
				
				Gateway gate = new Gateway(PayInfo.this);
				gate = gate.getGateway(gatewayid);
				
				DB db = new DB(getApplicationContext());
		    	db.open();
		    	if(!db.checkForTransID(transactionid)){
		    		history = new AirTimeHistory();
					history.setTransactionID(transactionid);
					history.setNetwork(network);
					history.setEmail(email);
					history.setPhoneNumber(formattedphone.replaceAll("-", ""));//number
					history.setAmount(amount);
					history.setNetworkIndex(String.valueOf(networkindex));
					Calendar c = Calendar.getInstance();
					String hour = (String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY))); 
			    	String minute = (String.valueOf(c.get(Calendar.MINUTE)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE)));
					String datetime = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" +
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
				Currency curr = new Currency(PayInfo.this);
				curr = curr.getCurrency(country);
				
				//Call quick airtime API
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "01")); 
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            nameValuePairs.add(new BasicNameValuePair("tranx_id", transactionid));
	            nameValuePairs.add(new BasicNameValuePair("phone", formattedphone.replaceAll("-", "")));
	            nameValuePairs.add(new BasicNameValuePair("product_id", productid));
	            nameValuePairs.add(new BasicNameValuePair("topup_amount", formattedamount));//
	            nameValuePairs.add(new BasicNameValuePair("topup_currency", curr.getCurrencyId()));
	            nameValuePairs.add(new BasicNameValuePair("payment_amount", calcamount));//
	            
	            //get gateway currency id
	            curr = new Currency(PayInfo.this);	            
	            if(gate.getCurrency().equals("USD"))
	            	curr = curr.getCurrency("United States");
	            else
	            	curr = curr.getCurrencyByCode(gate.getCurrency());
	            	
	            nameValuePairs.add(new BasicNameValuePair("payment_currency", curr.getCurrencyId()));
	            nameValuePairs.add(new BasicNameValuePair("payment_gateway", gate.getGatewayID()));
	            nameValuePairs.add(new BasicNameValuePair("os_code", "3"));
	            nameValuePairs.add(new BasicNameValuePair("discount_code", pref.getDiscountCode()));
	            nameValuePairs.add(new BasicNameValuePair("email", email));
	            
				api = new API_Interact(API_Interact.TODO_TOPUP, API_Interact.CLASSTYPE3, nameValuePairs, PayInfo.this);
				api.execute("");
			}        	
        });    	
    }
    
    public void CallInAppBrowser(String url){
    	if(url.equals("")){
    		dialog.dismiss();
    		AlertDialog.Builder alert = new AlertDialog.Builder(PayInfo.this);
			alert.setTitle(R.string.errorTitle);
			alert.setMessage(R.string.apierror);
			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					Intent intent = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
		            Bundle b = new Bundle();
		        	b.putBoolean("new", false);
		        	intent.putExtras(b);
		        	CoreAirTimeActivity.isfirst = true;
		        	CoreAirTimeActivity.currnull = false;
		        	CoreAirTimeActivity.NEXTOPERATION = 1;
		            startActivity(intent);
		            finish();
				}
			});
			alert.show();
    	}
    	else{
	    	//Update history entry with url
	    	history.setPayUrl(url);
	    	DB db = new DB(getApplicationContext());
	    	db.open();
	    	long id = Long.parseLong(db.getTransDBID(history.getTransactionID()));
			db.updateHistory(id, history);
			db.close();
	    	
			//close dialog
	  		dialog.dismiss();
	  		
	    	//Call browser and wait for response
			Intent i = new Intent(getApplicationContext(), InAppBrowser.class);
			Bundle b = new Bundle();
			b.putString("url", url);
			b.putLong("transdbid", id);
			i.putExtras(b);
			startActivityForResult(i, 0);
			//finish();
    	}
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	
    	if(keyCode == KeyEvent.KEYCODE_BACK){
    		Intent intent = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
            Bundle b = new Bundle();
        	b.putBoolean("new", false);
        	intent.putExtras(b);
        	CoreAirTimeActivity.isfirst = true;
        	CoreAirTimeActivity.currnull = false;
        	CoreAirTimeActivity.NEXTOPERATION = 1;
            startActivity(intent);
            finish();
    		return true;
    	}
		return false;
    }
    
    public void onActivityResult(int reqCode, int resCode, Intent data) {
	    super.onActivityResult(reqCode, resCode, data);
	    
	    if(resCode == Activity.RESULT_OK){
		    //Call status
	    	Intent i = new Intent(PayInfo.this, TransactionReport.class);
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
    		AlertDialog.Builder alert = new AlertDialog.Builder(PayInfo.this);
			alert.setTitle(R.string.errorTitle);
			alert.setMessage(R.string.apierror);
			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					/*Intent intent = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
		            Bundle b = new Bundle();
		        	b.putBoolean("new", false);
		        	intent.putExtras(b);
		        	CoreAirTimeActivity.isfirst = true;
		            startActivity(intent);
		            finish();*/
				}
			});
			alert.show();
	    }
    }
    	
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.payinfo);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.payinfoport);
    		InitializeUI();
        }
    }
}
