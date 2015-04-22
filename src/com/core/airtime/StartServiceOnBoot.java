package com.core.airtime;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StartServiceOnBoot extends Service {
		
	int NEXTOPERATION = 1;
	UserPreferences pref;
	Currency curr;
	
    @Override
    public IBinder onBind(Intent intent) {
    	return null;
    }
    
    public int onStartCommand (Intent intent, int flags, int startId){
    	DB db = new DB(StartServiceOnBoot.this);
		db.open();
		pref = db.getPreference(1);
		db.close();
		
		//Start first operation
        startNextOperation();
        
        return START_STICKY;
    }
    
    @Override
    public void onCreate() {
    	
    }
    
    private void startNextOperation(){
    	List<NameValuePair> nameValuePairs;
    	API_Interact api;
    	
    	if(NEXTOPERATION == 1){//Get currencies
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "06"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            api = new API_Interact(API_Interact.TODO_GET_CURRENCIES, API_Interact.CLASSTYPE2, nameValuePairs, StartServiceOnBoot.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 2){//Get networks
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "09"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            if(curr != null){
            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
            }
            
            api = new API_Interact(API_Interact.TODO_GET_OPERATORS, API_Interact.CLASSTYPE2, nameValuePairs, StartServiceOnBoot.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 3){//Get products
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "08"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            if(curr != null){
            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
            }
            
            api = new API_Interact(API_Interact.TODO_GET_PRODUCTS, API_Interact.CLASSTYPE2, nameValuePairs, StartServiceOnBoot.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 4){//Get gateways
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "07"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            nameValuePairs.add(new BasicNameValuePair("AAPG", pref.getAuthToken().substring(0, 10) + "321_#@!.)"));
            
            api = new API_Interact(API_Interact.TODO_GET_GATEWAYS, API_Interact.CLASSTYPE2, nameValuePairs, StartServiceOnBoot.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 5){//Get ready gateways
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "07"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            api = new API_Interact(API_Interact.TODO_GET_READY_GATEWAYS, API_Interact.CLASSTYPE2, nameValuePairs, StartServiceOnBoot.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 6){//Update coeffs
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "02"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            if(curr != null){
            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
            }
            
            api = new API_Interact(API_Interact.TODO_UPDATE_COEFF, API_Interact.CLASSTYPE2, nameValuePairs, StartServiceOnBoot.this);
			api.execute("");
    	}
    }
    
    public void done(){    	
    	if(NEXTOPERATION == 1){
	    	ArrayList<Country> countries = CountryNetworkGateway.GetCountries(this);
	        curr = new Currency(StartServiceOnBoot.this);
	        String c = countries.get(Integer.parseInt(pref.getCountryIndex())).getName();
	        curr = curr.getCurrency(c);
	        
	        if(curr == null){
		    	return;
	        }
    	}
    	
    	//Increment to next operation
    	NEXTOPERATION++;
    	
    	if(NEXTOPERATION <= 6)
    		startNextOperation();
    }
}
