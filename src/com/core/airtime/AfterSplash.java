package com.core.airtime;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class AfterSplash extends Activity {
	private String country = "Select Country";
	private int countryindex, localusdindex;
	UserPreferences pref;
	EditText countrySearch;
	ArrayAdapter<Country> adapter;
	ListView lstCountry;
	public static final int DO_CHOOSE_COUNTRY = 1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	if(updateUIFromPreferences()){
	        Configuration conf = this.getResources().getConfiguration();    	
	    	if(conf.orientation == 2)
	    		setContentView(R.layout.aftersplash);
	    	else
	    		setContentView(R.layout.aftersplashport);
	    	
	    	InitializeUI();
    	}
    }
    
    private boolean updateUIFromPreferences() {
        DB db = new DB(this);
        db.open();
    	pref = db.getPreference(1);
    	db.close();
    	
    	if(pref != null){ 
    		if(pref.getIsFirstTime().equals("true")){
	        	Intent i = new Intent(getApplicationContext(), DiscountCode.class);
				startActivity(i);
				finish();
    		}
    		else{
    			/*Intent i = new Intent(getApplicationContext(), TutorialMain.class);
				startActivity(i);
				finish();*/
        		Intent intent = new Intent(AfterSplash.this, CoreAirTimeActivity.class);
                Bundle b = new Bundle();
            	b.putBoolean("new", false);
            	intent.putExtras(b);
                startActivity(intent);
                finish();
    		}
    		return false;
    	}
    	else
    		return true;
    }
    
    private void savePreferences() {    	
    	pref = new UserPreferences();
    	pref.setCountryIndex("" + countryindex);
    	pref.setLanguageIndex("");
    	pref.setLocalUsdIndex("" + localusdindex); 
    	pref.setIsFirstTime("true");
    	pref.setEmail("");
    	pref.setPhoneNumber("");
    	pref.setAmount("");
    	pref.setChosenAmount("");
    	pref.setNetworkIndex("");
    	pref.setDiscountCode("");
    	pref.setFormattedAmount("");
    	pref.setFormattedPhoneNumber("");
    	pref.setAuthToken("");
    	pref.setCheckforUpdate("");
    	pref.setMerchantEmail("");
    	pref.setMerchantPassword("");
    	DB db = new DB(this);
        db.open();
        db.insertUserPreferences(pref);
    	db.close();
    	
    	//insert dummy
    	//insertDummyData();
    }
    
    private void insertDummyData(){
		AirTimeHistory history;
		DB db = new DB(getApplicationContext());
    	db.open();
		for(int i = 0; i < 5; i++){
			history = new AirTimeHistory();
			history.setTransactionID("0100802123456120");
			history.setNetwork("Airtel");
			history.setEmail("lexyb12@yahoo.com");
			history.setPhoneNumber((i%2 == 0 ? "2348027672219" : "2348027620332"));
			history.setAmount((i%2 == 0 ? "1000" : "500"));
			history.setNetworkIndex("1");
			Calendar c = Calendar.getInstance();
			String hour = (String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY))); 
	    	String minute = (String.valueOf(c.get(Calendar.MINUTE)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE)));
			String datetime = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" +
					                         c.get(Calendar.YEAR) + " " + hour + ":" + 
					                         minute + (c.get(Calendar.AM_PM) == 0 ? " AM" : " PM"));
			history.setDateTime(datetime);
			history.setCurrency("NGN");
			history.setTransactionStatus("0");
			history.setTopupStatus("0");
			history.setGatewayID("2");
			history.setAmountCharged("500");
			history.setCountry("Nigeria");
			history.setCountryIndex("74");
			history.setChosenAmountIndex("0");
			history.setPayUrl("");
			
			//Instantiate the database
			db.insertHistory(history);
		}
		db.close();
	}
    
    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
	    super.onActivityResult(reqCode, resCode, data);
	    switch(reqCode) {
		    case (DO_CHOOSE_COUNTRY) : {
			    if (resCode == Activity.RESULT_OK) {
			    	if(Integer.parseInt(data.getStringExtra("countryid")) != 0){
				    	country = data.getStringExtra("country");
				    	countryindex = data.getIntExtra("countryindex", 0);
				    	
				    	InitializeUI();
			    	}
			    }
			    break;
		    }
	    }
    }
    
    public void InitializeUI(){
    	setTitle(getString(R.string.welcome));
    	
    	if(country.startsWith("Select"))
    		country = getString(R.string.selectCountry);
    	String[] theList = {country};
        Spinner spinner = (Spinner) findViewById(R.id.spinCountry);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, theList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent evt) {
				// TODO Auto-generated method stub
				if(evt.getAction() == MotionEvent.ACTION_DOWN || evt.getAction() == MotionEvent.ACTION_POINTER_DOWN){
					Intent i = new Intent(getApplicationContext(), ChooseCountry.class);
	            	i.putExtra("fromafter", "true");
					startActivityForResult(i, DO_CHOOSE_COUNTRY);
				}
				return true;
			}
        	
        });
        spinner.setOnKeyListener(new View.OnKeyListener(){

			@Override
			public boolean onKey(View arg0, int keyCode, KeyEvent arg2) {
				// TODO Auto-generated method stub
				if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
					Intent i = new Intent(getApplicationContext(), ChooseCountry.class);
	            	i.putExtra("currentid", countryindex);
					startActivityForResult(i, DO_CHOOSE_COUNTRY);
				}
				return true;
			}
        });
        
        Spinner spinnerLocalUsd = (Spinner) findViewById(R.id.spinLocalUSD);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.localusd_options, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocalUsd.setAdapter(adapter3);
        spinnerLocalUsd.setSelection(localusdindex, true);
        spinnerLocalUsd.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            	localusdindex = pos;
            }

            public void onNothingSelected(AdapterView<?> parent) {
              // Do nothing.
            }
        });
        
    	Button cmdSend_button = (Button)findViewById(R.id.cmdSend);
    	cmdSend_button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				if(country.equals(getString(R.string.chooseCurrency))){// || language.equals("Select Language")
					AlertDialog.Builder alert = new AlertDialog.Builder(AfterSplash.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.chooseCountryLang);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
	    			return;
				}
				
				if(localusdindex <= 0){
					AlertDialog.Builder alert = new AlertDialog.Builder(AfterSplash.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.chooseCurr);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
	    			return;
				}
				
				CheckBox chkTerms = (CheckBox) findViewById(R.id.chkTerms);
				if(!chkTerms.isChecked()){
					AlertDialog.Builder alert = new AlertDialog.Builder(AfterSplash.this);
	    			alert.setTitle(R.string.tandC);
	    			alert.setMessage(R.string.agreeTandC);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){
	
						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
	    			return;
				}
				
				savePreferences();
				
				Intent i = new Intent(getApplicationContext(), DiscountCode.class);
				startActivity(i);
				finish();
			}
        });
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.aftersplashport);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.aftersplash);
    		InitializeUI();
        }
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
}