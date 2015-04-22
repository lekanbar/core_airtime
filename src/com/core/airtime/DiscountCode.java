package com.core.airtime;

import java.util.ArrayList;
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

public class DiscountCode extends Activity {
	//private DB db;
	UserPreferences pref;
	static int NEXTOPERATION = 1;
	ProgressDialog dialog;
	ArrayList<Network> nets;
	Gateway gate;
	ArrayList<Gateway> gates;
	Currency curr;
	static boolean isfirsttime = true;
	//private int languageindex;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
        pref = db.getPreference(1);
        db.close();
        
        setContentView(R.layout.discountcode);
        
    	InitializeUI();
    }
    
    public void InitializeUI(){
    	Button cmdEnter_button = (Button)findViewById(R.id.cmdEnter);
    	cmdEnter_button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
				EditText txtDiscount = (EditText)findViewById(R.id.txtDiscountCode);
				
				if(txtEmail.getText().toString().equals("") || !isEmailValid(txtEmail.getText().toString())){
					AlertDialog.Builder alert = new AlertDialog.Builder(DiscountCode.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.chooseValidEmail);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				
				String disc = txtDiscount.getText().toString();
				if(disc.equals(""))
					disc = "1111111";
				
				//Set preferences
				pref.setEmail(txtEmail.getText().toString());				
				pref.setDiscountCode(disc);
				
				DB db = new DB(getApplicationContext());
		    	db.open();
		    	db.updatePreferences(1, pref);
		        db.close();
				
		        //intialize dialog
		        dialog = new ProgressDialog(DiscountCode.this);
		        dialog.setTitle(getString(R.string.firstusetitle));
		        dialog.setMessage(getString(R.string.firstuse));
		        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		        dialog.setProgress(0);
		        dialog.setMax(140);
		        dialog.show();
		        
		        //start app config
		        startNextConfigOperation();
			}
    	});
    	
    	EditText txtDiscount = (EditText)findViewById(R.id.txtDiscountCode);
    	String discount = pref.getDiscountCode();
    	if(!discount.equals("1111111"))
    		txtDiscount.setText(pref.getDiscountCode());
    	
    	EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
    	txtEmail.setText(pref.getEmail());
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	setContentView(R.layout.discountcode);
		InitializeUI();
    }
    
    private void startNextConfigOperation(){
    	List<NameValuePair> nameValuePairs;
    	API_Interact api;
    	
    	if(NEXTOPERATION == 1){
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "04")); 
            nameValuePairs.add(new BasicNameValuePair("os_code", "3"));
            nameValuePairs.add(new BasicNameValuePair("discount_code", pref.getDiscountCode()));
            
            api = new API_Interact(API_Interact.TODO_AUTH, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 2){//Get currencies
    		Currency curr2 = new Currency(DiscountCode.this);
    		ArrayList<Currency> currs = curr2.getAllCurrencies();
    		
    		if(currs == null){
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "06"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            
	            api = new API_Interact(API_Interact.TODO_GET_CURRENCIES, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
				api.execute("");
    		}
    		else
    			done();
    	}
    	else if(NEXTOPERATION == 3){//Get networks
    		nets = Network.getAllNetworks(DiscountCode.this);
    		
    		if(nets.size() <= 1){
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "09"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            
	            //if the country exists in the DB
	            if(curr != null){
	            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
	            }
	            
	            api = new API_Interact(API_Interact.TODO_GET_OPERATORS, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
				api.execute("");
    		}
    		else
    			done();
    	}
    	else if(NEXTOPERATION == 4){//Get gateways
    		gate = new Gateway(DiscountCode.this);
    		gates = gate.getAllGateways();
    		
    		if(gates == null){
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "07"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            nameValuePairs.add(new BasicNameValuePair("AAPG", pref.getAuthToken().substring(0, 10) + "321_#@!.)"));
	            
	            api = new API_Interact(API_Interact.TODO_GET_GATEWAYS, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
				api.execute("");
    		}
    		else
    			done();
    	}
    	else if(NEXTOPERATION == 5){//Get products    
    		nets = Network.getAllNetworks(DiscountCode.this);
    		if(nets.size() > 1){
	    		if(nets.get(1).getIsFixed().equals("")){
		    		nameValuePairs = new ArrayList<NameValuePair>();
		            nameValuePairs.add(new BasicNameValuePair("cmd", "08"));
		            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
		            
		            if(curr != null){
		            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
		            }
		            
		            api = new API_Interact(API_Interact.TODO_GET_PRODUCTS, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
					api.execute("");
    			}
	    		else
	    			done();
    		}
    		else
    			done();
    	}
    	else if(NEXTOPERATION == 6){//Get ready gateways
    		gates = gate.getAllGateways();
    		if(gates != null){
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "07"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            
	            api = new API_Interact(API_Interact.TODO_GET_READY_GATEWAYS, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
				api.execute("");
    		}
    		else
    			done();
    	}
    	else if(NEXTOPERATION == 7){//Update coeffs
    		GatewayNetwork gatenet = new GatewayNetwork();
    		ArrayList<GatewayNetwork> gatenets = gatenet.getGatewayNetworks(DiscountCode.this);
    		
    		if(gatenets == null){
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "02"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            
	            //if the country exists in the DB
	            if(curr != null){
	            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
	            }
	            
            	api = new API_Interact(API_Interact.TODO_UPDATE_COEFF, API_Interact.CLASSTYPE1, nameValuePairs, DiscountCode.this);
    			api.execute("");

    		}
    		else
    			done();
    	}
    }
    
    public void done(){
    	if(NEXTOPERATION == 1){
    		DB db = new DB(DiscountCode.this);
    		db.open();
    		pref = db.getPreference(1);
    		db.close();
    	}
    	
    	if(NEXTOPERATION == 2){
	    	ArrayList<Country> countries = CountryNetworkGateway.GetCountries(this);
	        curr = new Currency(DiscountCode.this);
	        String c = countries.get(Integer.parseInt(pref.getCountryIndex())).getName();
	        curr = curr.getCurrency(c);
	        
	        if(curr == null){
	        	dialog.setProgress(dialog.getProgress() + 20);
	        	
	        	dialog.dismiss();
	    		
	    		Intent i = new Intent(getApplicationContext(), TutorialMain.class);
				startActivity(i);
		    	finish();
		    	return;
	        }
    	}
    	
    	//Increment to next operation
    	NEXTOPERATION++;
    	
    	if(NEXTOPERATION <= 7){
    		dialog.setProgress(dialog.getProgress() + 20);
    		
    		startNextConfigOperation();
    	}
    	else{
    		dialog.dismiss();
    		
    		DB db = new DB(DiscountCode.this);
    		pref.setIsFirstTime("false");
    		db.open();
    		db.updatePreferences(1, pref);
    		db.close();
    		
    		/*Intent i = new Intent(getApplicationContext(), TutorialMain.class);
			startActivity(i);
	    	finish();*/
    		Intent intent = new Intent(DiscountCode.this, CoreAirTimeActivity.class);
            Bundle b = new Bundle();
        	b.putBoolean("new", false);
        	intent.putExtras(b);
            startActivity(intent);
            finish();
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