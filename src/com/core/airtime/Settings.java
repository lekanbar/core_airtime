package com.core.airtime;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.core.airtime.SlideMenu.SlideMenuItem;
import com.core.airtime.SlideMenuInterface.OnSlideMenuItemClickListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Settings extends Activity implements OnSlideMenuItemClickListener {
	UserPreferences pref;
	static boolean isfirsttime = true;
	private String country = "Select Country";
	private int countryindex, localusdindex;
	public static final int DO_CHOOSE_COUNTRY = 1;
	private SlideMenu slidemenu;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
        pref = db.getPreference(1);
        db.close();
        
        setContentView(R.layout.settings);
        
        int updateCountryIndex = Integer.parseInt(pref.getCountryIndex());
    	//int updateLanguageIndex = Integer.parseInt(pref.getLanguageIndex());
    	int updateLocalUsdIndex = Integer.parseInt(pref.getLocalUsdIndex());
    	
    	ArrayList<Country> countries = CountryNetworkGateway.GetCountries(this);
    	country = countries.get(updateCountryIndex).getName();
    	
    	localusdindex =  updateLocalUsdIndex;
        
    	InitializeUI();
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	
    	if(keyCode == KeyEvent.KEYCODE_BACK){
    		if(slidemenu.getVisibility() == View.VISIBLE)
    			if(slidemenu.getVisibility() == View.VISIBLE){
        			slidemenu.hide();
        			slidemenu.setVisibility(View.GONE);
        			return false;
        		}
        		else
        			return true;
    	}
		return true;
    }
    
    @Override
	public void onSlideMenuItemClick(int itemId) {
		switch(itemId) {
			case (Menu.FIRST + 1) : {
				Intent intent = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
	            Bundle b = new Bundle();
	        	b.putBoolean("new", false);
	        	intent.putExtras(b);
	        	CoreAirTimeActivity.isfirst = true;
	        	CoreAirTimeActivity.currnull = false;
	        	CoreAirTimeActivity.NEXTOPERATION = 1;
	            startActivity(intent);
	            finish();
				break;
			}
			case (Menu.FIRST + 2): {
		    	Intent i = new Intent(getApplicationContext(), LiveChat.class);
				startActivity(i);
				finish();
				break;
		    }
		    case (Menu.FIRST + 3): {
		    	Intent i = new Intent(getApplicationContext(), Terms.class);
				startActivity(i);
				finish();
				break;
		    }
		    case (Menu.FIRST + 4): {
		    	Intent i = new Intent(getApplicationContext(), About.class);
				startActivity(i);
				finish();
				break;
		    }
		    case (Menu.FIRST + 6) : {
				Intent i = new Intent(getApplicationContext(), History.class);
				startActivity(i);
				finish();
				break;
			}
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    //show side menu
	    if(slidemenu.getVisibility() == View.VISIBLE){
	    	slidemenu.show();//for Nexus tweak
			slidemenu.hide();
			slidemenu.setVisibility(View.GONE);
		}
		else{
		    slidemenu.show();
		    slidemenu.setVisibility(View.VISIBLE);
		}
	    return false;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    super.onOptionsItemSelected(item);
	    switch (item.getItemId()) {
		    case android.R.id.home: {// this is the app icon of the actionbar
				slidemenu.show();
				slidemenu.setVisibility(View.VISIBLE);
				break;
			}
	    }
	    return false;
    }
    
    public void InitializeUI(){
    	setTitle(getString(R.string.settings));
    	
    	Button cmdSend = (Button)findViewById(R.id.cmdSend);
    	cmdSend.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
				
				if(txtEmail.getText().toString().equals("") || !isEmailValid(txtEmail.getText().toString())){
					AlertDialog.Builder alert = new AlertDialog.Builder(Settings.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.chooseValidEmail);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				
				pref.setEmail(txtEmail.getText().toString());
				pref.setCountryIndex("" + countryindex);
				pref.setLocalUsdIndex("" + localusdindex);
				DB db = new DB(Settings.this);
		        db.open();
		        db.updatePreferences(1, pref);
		    	db.close();
		    	
		    	Toast.makeText(Settings.this, getString(R.string.setsaved), Toast.LENGTH_SHORT).show();
			}
    	});
    	
    	EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
    	txtEmail.setText(pref.getEmail());
    	
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
	            	i.putExtra("countryindex", (pref.getCountryIndex().equals("") ? 0 : pref.getCountryIndex()));
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
        
        //show on imgMenu
        ImageView imgMenu = (ImageView)findViewById(R.id.imgMenu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	slidemenu.show();
            }
        });
        
        //Slide menu setup
        slidemenu = (SlideMenu) findViewById(R.id.slideMenu);
		slidemenu.init(this, R.menu.slide, this, 333);
		
		// set optional header image
		slidemenu.setHeaderImage(getResources().getDrawable(R.drawable.header));
		
		// this demonstrates how to dynamically add menu items
		SlideMenuItem item = new SlideMenuItem();
		item.id = Menu.FIRST + 1; item.icon = getResources().getDrawable(R.drawable.topup);
		item.label = getString(R.string.topup2);
		slidemenu.addMenuItem(item);
		
		SlideMenuItem item6 = new SlideMenuItem();
		item6.id = Menu.FIRST + 6; item6.icon = getResources().getDrawable(R.drawable.transhistory);
		item6.label = getString(R.string.viewHis);
		slidemenu.addMenuItem(item6);
		
		SlideMenuItem itemLive2 = new SlideMenuItem();
		itemLive2.id = Menu.FIRST + 2; itemLive2.icon = getResources().getDrawable(R.drawable.livechat);
		itemLive2.label = getString(R.string.livechat);
		slidemenu.addMenuItem(itemLive2);
		
		SlideMenuItem itemLive3 = new SlideMenuItem();
		itemLive3.id = Menu.FIRST + 3; itemLive3.icon = getResources().getDrawable(R.drawable.terms);
		itemLive3.label = getString(R.string.tandC);
		slidemenu.addMenuItem(itemLive3);
		
		SlideMenuItem itemLive4 = new SlideMenuItem();
		itemLive4.id = Menu.FIRST + 4; itemLive4.icon = getResources().getDrawable(R.drawable.about);
		itemLive4.label = getString(R.string.about);
		slidemenu.addMenuItem(itemLive4);
    }
    
    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
	    super.onActivityResult(reqCode, resCode, data);
	    switch(reqCode) {
		    case (DO_CHOOSE_COUNTRY) : {
			    if (resCode == Activity.RESULT_OK) {
			    	if(Integer.parseInt(data.getStringExtra("countryid")) != 0){
				    	country = data.getStringExtra("country");
				    	countryindex = Integer.parseInt(data.getStringExtra("countryid"));
				    	
				    	InitializeUI();
			    	}
			    }
			    break;
		    }
	    }
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	setContentView(R.layout.settings);
		InitializeUI();
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