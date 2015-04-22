package com.core.airtime;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.core.airtime.SlideMenu.SlideMenuItem;
import com.core.airtime.SlideMenuInterface.OnSlideMenuItemClickListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.telephony.*;

public class CoreAirTimeActivity extends Activity implements OnSlideMenuItemClickListener {
	//private DB db;
	private String network, networkid, country, countryid, min, max, chosenamount, isfixed, /*isusddenom,*/  /*language,*/ localusd, topupid, 
	               currency, phonenumber = "", amount = "", countrycode, formattedphone, formattedamount, productid;
	private ArrayList<Network> networks;
	private ArrayList<String> network_values;
	private int networkindex, chosenamountindex, countryindex, networkcount, amountcount, /*languageindex,*/ 
	            localusdindex, currentpos/*, phonelenght*/;
	private boolean isnew;
	public static final int DO_CHOOSE_COUNTRY = 1;
	public static final int DO_CHOOSE_LOCALUSD = 2;
	//public static final int DO_CHOOSE_LANGUAGE = 3;
	public static final int DO_CHANGE_EMAIL = 4;
	
	static int NEXTOPERATION = 1;
	Currency curr;
	ArrayList<Country> countries;
	
	ProgressDialog dialog;
	
	static boolean isfirst = true;
	static boolean currnull = false;
	UserPreferences pref;
	
	private SlideMenu slidemenu;
	QuickAction quickAction;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Configuration conf = this.getResources().getConfiguration();    	
    	if(conf.orientation == 2)
    		setContentView(R.layout.main);
    	else
    		setContentView(R.layout.mainport);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
    	pref = db.getPreference(1);
    	db.close();
    	
    	int updateCountryIndex = Integer.parseInt(pref.getCountryIndex());
    	int updateLocalUsdIndex = Integer.parseInt(pref.getLocalUsdIndex());
    	
    	countries = CountryNetworkGateway.GetCountries(this);
    	country = countries.get(updateCountryIndex).getName();
    	countryid = countries.get(updateCountryIndex).getCountryID();
    	countryindex = updateCountryIndex;
    	countrycode = countries.get(updateCountryIndex).getIntlCallingCode();
    	
    	Resources r = getResources();
    	
    	localusd = r.getStringArray(R.array.localusd_options)[updateLocalUsdIndex];
    	localusdindex =  updateLocalUsdIndex;
    	if(localusdindex == 1)
    		currency = countries.get(updateCountryIndex).getCurrency();
    	else
    		currency = "USD";
    	
    	if(pref.getAuthToken().equals("")){
    		AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
			alert.setTitle(R.string.errorTitle);
			alert.setMessage(R.string.internetish);
			alert.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					NEXTOPERATION = 1;
					apiRetrievals();
				}
			});
			alert.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					Intent intent = new Intent(Intent.ACTION_MAIN);
					intent.addCategory(Intent.CATEGORY_HOME);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
					finish();
				}
			});
			alert.show();
    	}
    	else{
	    	if(isfirst){
		    	chosenamount = "";
		    	Bundle b = getIntent().getExtras();
		    	isnew = b.getBoolean("new");
		    	
		        curr = new Currency(CoreAirTimeActivity.this);
		        curr = curr.getCurrency(countries.get(Integer.parseInt(pref.getCountryIndex())).getName());
		        
		    	isfirst = false;
	    	}
	    	
	    	//check if curr exists
	    	if(curr == null){
	    		currnull = true;
	    		
	    		AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
				alert.setTitle(R.string.errorTitle);
				alert.setMessage(R.string.countnotsupp);
				alert.setNegativeButton(R.string.ok, new DialogInterface.OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						Intent i = new Intent(getApplicationContext(), ChooseCountry.class);
			        	i.putExtra("currentid", countryindex);
						startActivityForResult(i, DO_CHOOSE_COUNTRY);
					}
				});
				alert.show();
	    	}
	    	
	    	networks = Network.GetNetworksFromDB(countryid, this);
	    	if(networks.size() <= 1){
	    		NEXTOPERATION = 2;
	    		apiRetrievals();
	    	}
	    	else{
		    	InitializeUI();
		    	updateUIFromPreferences();
	    	}
    	}
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	
    	if(keyCode == KeyEvent.KEYCODE_BACK){
    		if(slidemenu.getVisibility() == View.VISIBLE){
    			slidemenu.hide();
    			slidemenu.setVisibility(View.GONE);
    			return false;
    		}
    		else
    			return true;
    	}
		return false;
    }
    
    @Override
	public void onSlideMenuItemClick(int itemId) {

		switch(itemId) {
			case (Menu.FIRST + 1) : {
				Intent i = new Intent(getApplicationContext(), History.class);
				startActivity(i);
				break;
			}
			case (Menu.FIRST + 2): {
		    	Intent i = new Intent(getApplicationContext(), LiveChat.class);
				startActivity(i);
				break;
		    }
		    case (Menu.FIRST + 3): {
		    	Intent i = new Intent(getApplicationContext(), Terms.class);
				startActivity(i);
				break;
		    }
		    case (Menu.FIRST + 4): {
		    	Intent i = new Intent(getApplicationContext(), About.class);
				startActivity(i);
				break;
		    }
		    case (Menu.FIRST + 5): {
		    	Intent i = new Intent(getApplicationContext(), Settings.class);
				startActivity(i);
				break;
		    }
		}
	}    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    // Create and add new menu items.
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
    
    private void updateUIFromPreferences() {
    	int updateNetworkIndex = (pref.getNetworkIndex().equals("") ? 0 : Integer.parseInt(pref.getNetworkIndex()));
    	String airtimeAmount = pref.getAmount();
    	int updateChosenAmountIndex = (pref.getChosenAmount().equals("") ? 0 : Integer.parseInt(pref.getChosenAmount()));
    	String phoneNumber = pref.getPhoneNumber();
    	
    	Spinner spinner = (Spinner) findViewById(R.id.spinNetworks);    	
    	if(updateNetworkIndex > networkcount){
    		spinner.setSelection(0);
    	}
    	else{
	    	spinner.setSelection(updateNetworkIndex);
    	}
    	
    	Spinner spinner2 = (Spinner) findViewById(R.id.spinAmount);
    	if(updateChosenAmountIndex > amountcount){
	    	spinner2.setSelection(0);
    	}
    	else{
	    	spinner2.setSelection(updateChosenAmountIndex);
    	}
    	
    	if(!isnew){
	    	if(!airtimeAmount.equals("")){
	    		EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
	    		txtAmount.setText(airtimeAmount);
	    		amount = airtimeAmount;
	    	}
	    	if(!phoneNumber.equals("")){
	    		EditText txtPhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
	    		txtPhoneNumber.setText(phoneNumber);
	    		phonenumber = phoneNumber;
	    	}
    	}
    }
    
    public void apiRetrievals(){
    	dialog = new ProgressDialog(CoreAirTimeActivity.this);
        dialog.setTitle(getString(R.string.firstusetitle));
        dialog.setMessage(getString(R.string.countryish));
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setProgress(0);
        dialog.setMax(120);
        dialog.show();
        
        //start
        startNextConfigOperation();
    }
    
    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
	    super.onActivityResult(reqCode, resCode, data);
	    switch(reqCode) {
		    case (DO_CHOOSE_COUNTRY) : {
			    if (resCode == Activity.RESULT_OK) {
			    	if(Integer.parseInt(data.getStringExtra("countryid")) != 0){
				    	country = data.getStringExtra("country");
				    	countryid = data.getStringExtra("countryid");
				    	countryindex = data.getIntExtra("countryindex", 0);
				    	countrycode = data.getStringExtra("countrycode");
				    	currency = data.getStringExtra("currency");
				    	
				    	pref.setCountryIndex("" + countryindex);
				    	//Instantiate the database
				    	DB db = new DB(getApplicationContext());
				    	db.open();
				    	db.updatePreferences(1, pref);
				    	db.close();
				    	
				        curr = new Currency(CoreAirTimeActivity.this);
				        curr = curr.getCurrency(countries.get((countryindex)).getName());
				        
				    	//Check if network is in DB or not
				    	networks = Network.GetNetworksFromDB(countryid, this);
				    	if(networks.size() <= 1){
				    		//if not in DB get from API
				    		NEXTOPERATION = 1;
				    		apiRetrievals();
				    	}
				    	else{
					    	InitializeUI();
					    	
					    	if(currnull){
					    		currnull = false;
						        
					    		updateUIFromPreferences();
					    	}
					    	else{
						    	EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
						        txtAmount.setText("");
					    	}
				    	}
			    	}
			    }
			    break;
		    }
		    case (DO_CHOOSE_LOCALUSD) : {
			    if (resCode == Activity.RESULT_OK) {
			    	if(data.getIntExtra("localusdid", 0) != 0){
				    	localusd = data.getStringExtra("localusd");
				    	localusdindex = data.getIntExtra("localusdid", 0);
				    	
				    	pref.setLocalUsdIndex("" + localusdindex);
				    	
				    	if(localusdindex == 2)
				    		currency = "USD";
				    	else{
				    		int updateCountryIndex = Integer.parseInt(pref.getCountryIndex());
				        	ArrayList<Country> countries = CountryNetworkGateway.GetCountries(this);
				    		currency = countries.get(updateCountryIndex).getCurrency();
				    	}
				    		
				    	//Instantiate the database
				    	DB db = new DB(getApplicationContext());
				    	db.open();
				    	db.updatePreferences(1, pref);
				    	db.close();
				    	
				    	InitializeUI();
				    	
				    	EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
				        txtAmount.setText("");
			    	}
			    }
			    break;
		    }
		    /*case (DO_CHOOSE_LANGUAGE) : {
			    if (resCode == Activity.RESULT_OK) {
			    	if(data.getIntExtra("languageid", 0) != 0){
				    	language = data.getStringExtra("language");
				    	languageindex = data.getIntExtra("languageid", 0);
				    	
				    	pref.setLanguageIndex("" + languageindex);
				    	//Instantiate the database
				    	DB db = new DB(getApplicationContext());
				    	db.open();
				    	db.updatePreferences(1, pref);
				    	db.close();
				    	
				    	setLanguage();
				    	
				    	Configuration conf = this.getResources().getConfiguration();    	
				    	if(conf.orientation == 2)
				    		setContentView(R.layout.main);
				    	else
				    		setContentView(R.layout.mainport);
				    	
				    	InitializeUI();
			    	}
			    }
			    break;
		    }*/
		    case (DO_CHANGE_EMAIL) : {
			    if (resCode == Activity.RESULT_OK) {
			    	if(!data.getStringExtra("email").equals("")){
				    	pref.setEmail(data.getStringExtra("email"));
				    	//Instantiate the database
				    	DB db = new DB(getApplicationContext());
				    	db.open();
				    	db.updatePreferences(1, pref);
				    	db.close();
				    	
				    	Configuration conf = this.getResources().getConfiguration();    	
				    	if(conf.orientation == 2)
				    		setContentView(R.layout.main);
				    	else
				    		setContentView(R.layout.mainport);
				    	
				    	InitializeUI();
			    	}
			    }
			    break;
		    }
	    }
    }
    
    public void InitializeUI(){
    	//setTitle(getString(R.string.mainone));
    	      
    	TextView txtCurrency = (TextView)findViewById(R.id.txtCurrency);
    	txtCurrency.setText(getString(R.string.vcurrency) + " - " + currency);
    	
        EditText txtPhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
        if(!phonenumber.equals("")){
        	txtPhoneNumber.setText(phonenumber);
		}
        txtPhoneNumber.addTextChangedListener(new TextWatcher(){
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
			
            @Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
            	EditText txtPhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
            	TextView lblPhoneFormat = (TextView)findViewById(R.id.lblPhoneFormat);
            	if(txtPhoneNumber.getText().toString().equals("")){
            		lblPhoneFormat.setVisibility(TextView.GONE);
            	}
            	else{
            		String otherpart = (txtPhoneNumber.getText().toString().startsWith("0") ? 
                                         txtPhoneNumber.getText().toString().substring(1) : txtPhoneNumber.getText().toString());
            		
	            	formattedphone = countrycode + "-" + PhoneNumberUtils.formatNumber(otherpart);
	            	lblPhoneFormat.setText(getString(R.string.phoneformat) + formattedphone);
	            	lblPhoneFormat.setVisibility(TextView.VISIBLE);
            	}
			}
        }); 
        
        EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
        if(!amount.equals("")){
        	txtAmount.setText(amount);
		}
        txtAmount.addTextChangedListener(new TextWatcher(){
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
			
            @Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
            	TextView lblValueFormat = (TextView)findViewById(R.id.lblValueFormat);
            	EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
            	
            	if(txtAmount.getText().toString().equals("")){
            		lblValueFormat.setVisibility(TextView.GONE);
            	}
            	else{
	            	java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
	            	formattedamount = df.format(Double.parseDouble(txtAmount.getText().toString()));
	            	chosenamount = txtAmount.getText().toString();
	            	lblValueFormat.setText(getString(R.string.valueformat) + currency + " " + formattedamount);
	        		lblValueFormat.setVisibility(TextView.VISIBLE);
            	}
			}
        });
		
        //Slide menu setup
        slidemenu = (SlideMenu) findViewById(R.id.slideMenu);
		slidemenu.init(this, R.menu.slide, this, 333);
		
		// set optional header image
		slidemenu.setHeaderImage(getResources().getDrawable(R.drawable.header));
		
		// this demonstrates how to dynamically add menu items
		SlideMenuItem item = new SlideMenuItem();
		item.id = Menu.FIRST + 1; item.icon = getResources().getDrawable(R.drawable.transhistory);
		item.label = getString(R.string.viewHis);
		slidemenu.addMenuItem(item);
		
		SlideMenuItem itemLive2 = new SlideMenuItem();
		itemLive2.id = Menu.FIRST + 2; itemLive2.icon = getResources().getDrawable(R.drawable.livechat);
		itemLive2.label = getString(R.string.livechat);
		slidemenu.addMenuItem(itemLive2);
		
		SlideMenuItem itemLive5 = new SlideMenuItem();
		itemLive5.id = Menu.FIRST + 5; itemLive5.icon = getResources().getDrawable(R.drawable.globe);
		itemLive5.label = getString(R.string.settings);
		slidemenu.addMenuItem(itemLive5);
		
		SlideMenuItem itemLive3 = new SlideMenuItem();
		itemLive3.id = Menu.FIRST + 3; itemLive3.icon = getResources().getDrawable(R.drawable.terms);
		itemLive3.label = getString(R.string.tandC);
		slidemenu.addMenuItem(itemLive3);
		
		SlideMenuItem itemLive4 = new SlideMenuItem();
		itemLive4.id = Menu.FIRST + 4; itemLive4.icon = getResources().getDrawable(R.drawable.about);
		itemLive4.label = getString(R.string.about);
		slidemenu.addMenuItem(itemLive4);
        
        //Quick action things
        Configuration conf = this.getResources().getConfiguration();    	
    	if(conf.orientation == 2)
    		quickAction = new QuickAction(this, QuickAction.HORIZONTAL);
    	else
    		quickAction = new QuickAction(this, QuickAction.VERTICAL);
        
        ActionItem countriesItem = new ActionItem(0, getString(R.string.vcountries), getResources().getDrawable(R.drawable.countries));
        //ActionItem langItem = new ActionItem(1, getString(R.string.vlang), getResources().getDrawable(R.drawable.languages));
        ActionItem currencyItem = new ActionItem(2, getString(R.string.vcurrency), getResources().getDrawable(R.drawable.localusd));
        ActionItem emailItem = new ActionItem(3, getString(R.string.vemail), getResources().getDrawable(R.drawable.email));
        
        quickAction.addActionItem(countriesItem);
        //quickAction.addActionItem(langItem);
        quickAction.addActionItem(currencyItem);
        quickAction.addActionItem(emailItem);
        
        //Set listener for action item clicked
        quickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {          
            @Override
            public void onItemClick(QuickAction source, int pos, int actionId) {
                //here we can filter which action item was clicked with pos or actionId parameter
            	quickAction.dismiss();
            	
                if(actionId == 0){
                	Intent i = new Intent(getApplicationContext(), ChooseCountry.class);
                	i.putExtra("currentid", countryindex);
    				startActivityForResult(i, DO_CHOOSE_COUNTRY);
                }
                /*else if(actionId == 1){
    				Intent i = new Intent(getApplicationContext(), ChooseLanguage.class);
    				i.putExtra("currentid", languageindex);
    				startActivityForResult(i, DO_CHOOSE_LANGUAGE);
                }*/
                else if(actionId == 2){
                	Intent i = new Intent(getApplicationContext(), ChooseLocalUSD.class);
    				i.putExtra("currentid", localusdindex);
    				startActivityForResult(i, DO_CHOOSE_LOCALUSD);
                }
                else{
                	Intent i = new Intent(getApplicationContext(), ChangeEmail.class);
    				i.putExtra("email", pref.getEmail());
    				startActivityForResult(i, DO_CHANGE_EMAIL);
                }
            }
        });
        
        //show on imgGlobe
        ImageView imgGlobe = (ImageView)findViewById(R.id.imgGlobe);
        imgGlobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quickAction.show(v);
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
        
        TextView txtCountry = (TextView)findViewById(R.id.txtCountry);
        txtCountry.setText(country);
        txtCountry.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ChooseCountry.class);
				i.putExtra("currentid", countryindex);
				startActivityForResult(i, DO_CHOOSE_COUNTRY);
			}        	
        });
        
        Spinner spinner = (Spinner) findViewById(R.id.spinNetworks);
    	networkcount = networks.size() - 1;
        ArrayAdapter<Network> adapter = new ArrayAdapter<Network>(this, android.R.layout.simple_spinner_item, networks);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if(networkcount >= currentpos)
        	spinner.setSelection(currentpos);
        else
        	spinner.setSelection(1);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        		currentpos = pos;
        		
        		TextView lblValueFormat = (TextView)findViewById(R.id.lblValueFormat);            	
            	lblValueFormat.setVisibility(TextView.GONE);
        		
        		if(pos == 0)
        			return;
        		else
        			refreshPage(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
              // Do nothing.
            }
        });
        
    	Button cmdSend_button = (Button)findViewById(R.id.cmdSend);
    	cmdSend_button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {	
				String phonenum = ((EditText)findViewById(R.id.txtPhoneNumber)).getText().toString();				
				if(phonenum.equals("")/* || phonenum.length() < phonelenght*/){
					AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.enterValidPhone);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
	    			return;
				}
				
				if(!verifyPhoneNumber(phonenum)){
					AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.validPhoneNetwork);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
	    			return;
				}
				
				if(isfixed.equals("true")){
					//if(!isusddenom.equals("true")){
						amount = ((EditText)findViewById(R.id.txtAmount)).getText().toString();
						if(amount.equals("")){
							AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
			    			alert.setTitle(R.string.errorTitle);
			    			alert.setMessage(R.string.enterMinMax);
			    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){
		
								public void onClick(DialogInterface arg0, int arg1) {
									
								}
			    			});
			    			alert.show();
			    			return;
						}
						else{
							double amt = 0.0d, minamt = 0.0d, maxamt = 0.0d;
							try{
								amt = Double.parseDouble(formattedamount);
								minamt = Double.parseDouble(min);
								maxamt = Double.parseDouble(max);
							}catch(Exception ex){
								AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
				    			alert.setTitle(R.string.errorTitle);
				    			alert.setMessage(R.string.enterMinMax);
				    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){
			
									public void onClick(DialogInterface arg0, int arg1) {
										
									}
				    			});
				    			alert.show();
				    			return;
							}
							if(amt < minamt || amt > maxamt){
								AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
				    			alert.setTitle(R.string.errorTitle);
				    			alert.setMessage(R.string.enterMinMax);
				    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){
			
									public void onClick(DialogInterface arg0, int arg1) {
										
									}
				    			});
				    			alert.show();
				    			return;
							}
							/*if(!verifyMultiples(amount)){
								AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
				    			alert.setTitle(R.string.errorTitle);
				    			alert.setMessage(getString(R.string.amountmultiple) + mult + ".");
				    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){
			
									public void onClick(DialogInterface arg0, int arg1) {
										
									}
				    			});
				    			alert.show();
				    			return;
							}*/
						}
				}
				
				if(network.equalsIgnoreCase(getString(R.string.netOperator))){
					AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.chooseValidNetwork);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
	    			return;
				}
				else{
					goToPay();
				}
			}        	
        });
    }
    
    public void goToPay(){
    	Intent i = new Intent(CoreAirTimeActivity.this, Pay.class);
		Bundle b = new Bundle();
		b.putString("network", network);
		b.putString("networkid", networkid);
		b.putInt("networkindex", networkindex);
		b.putInt("chosenamountindex", chosenamountindex);
		b.putString("email", pref.getEmail());
		b.putString("country", country);
		b.putString("countryid", countryid);
		b.putString("productid", productid);
		b.putInt("countryindex", countryindex);
		//b.putString("language", language);
		//b.putInt("languageindex", languageindex);
		b.putString("localusd", localusd);
		b.putInt("localusdindex", localusdindex);
		b.putString("topupid", topupid);
		b.putString("currency", currency);
		b.putString("formattedamount", formattedamount);
		b.putString("formattedphone", formattedphone);
		b.putString("phone", ((EditText)findViewById(R.id.txtPhoneNumber)).getText().toString());
		
		Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
		Matcher m = p.matcher(chosenamount);
		m.find();
		
		b.putString("amount", (isfixed.equals("true") ? amount : m.group()));
		b.putString("transactionid", UniqueID.GetUniqueID(((EditText)findViewById(R.id.txtPhoneNumber)).getText().toString()).toUpperCase());
		i.putExtras(b);				
		startActivity(i);
    }
    
    private void startNextConfigOperation(){
    	List<NameValuePair> nameValuePairs;
    	API_Interact api;
    	
    	if(NEXTOPERATION == 1){
    		if(pref.getAuthToken().equals("")){
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "04")); 
	            nameValuePairs.add(new BasicNameValuePair("os_code", "3"));
	            nameValuePairs.add(new BasicNameValuePair("discount_code", pref.getDiscountCode()));
	            
	            api = new API_Interact(API_Interact.TODO_AUTH, API_Interact.CLASSTYPE4, nameValuePairs, CoreAirTimeActivity.this);
				api.execute("");
    		}
    		else{
    			NEXTOPERATION++;
    			done("");
    		}
    	}
    	if(NEXTOPERATION == 2){//Get networks
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "09"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            //if the country exists in the DB
            if(curr != null){
            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
            }
            
            api = new API_Interact(API_Interact.TODO_GET_OPERATORS, API_Interact.CLASSTYPE4, nameValuePairs, CoreAirTimeActivity.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 3){//Get gateways
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "07"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            nameValuePairs.add(new BasicNameValuePair("AAPG", pref.getAuthToken().substring(0, 10) + "321_#@!.)"));
            
            api = new API_Interact(API_Interact.TODO_GET_GATEWAYS, API_Interact.CLASSTYPE4, nameValuePairs, CoreAirTimeActivity.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 4){//Get products
	    		nameValuePairs = new ArrayList<NameValuePair>();
	            nameValuePairs.add(new BasicNameValuePair("cmd", "08"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            
	            if(curr != null){
	            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
	            }
	            
	            api = new API_Interact(API_Interact.TODO_GET_PRODUCTS, API_Interact.CLASSTYPE4, nameValuePairs, CoreAirTimeActivity.this);
				api.execute("");
    	}
    	else if(NEXTOPERATION == 5){//Get ready gateways
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "07"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            api = new API_Interact(API_Interact.TODO_GET_READY_GATEWAYS, API_Interact.CLASSTYPE4, nameValuePairs, CoreAirTimeActivity.this);
			api.execute("");
    	}
    	else if(NEXTOPERATION == 6){//Update coeffs
    		nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("cmd", "02"));
            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
            
            //if the country exists in the DB
            if(curr != null){
            	nameValuePairs.add(new BasicNameValuePair("country_id", curr.getCurrencyId()));
            }
            
        	api = new API_Interact(API_Interact.TODO_UPDATE_COEFF, API_Interact.CLASSTYPE4, nameValuePairs, CoreAirTimeActivity.this);
			api.execute("");
    	}
    }
    
    public void done(String token){
    	if(token.equals("")){
    		AlertDialog.Builder alert = new AlertDialog.Builder(CoreAirTimeActivity.this);
			alert.setTitle(R.string.errorTitle);
			alert.setMessage(R.string.internetish);
			alert.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					dialog.dismiss();
					NEXTOPERATION = 1;
					apiRetrievals();
				}
			});
			alert.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					dialog.dismiss();
					
					if(pref.getAuthToken().equals("") || country.equals("")){
						Intent intent = new Intent(Intent.ACTION_MAIN);
						intent.addCategory(Intent.CATEGORY_HOME);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(intent);
						finish();
					}
				}
			});
			alert.show();
			return;
		}
    	
    	if(NEXTOPERATION == 1){
    		DB db = new DB(CoreAirTimeActivity.this);
    		db.open();
    		pref = db.getPreference(1);
    		db.close();
    	}
    	
    	//Increment to next operation
    	NEXTOPERATION++;
    	
    	if(NEXTOPERATION <= 6){
    		dialog.setProgress(dialog.getProgress() + 20);
    		
    		startNextConfigOperation();
    	}
    	else{
    		NEXTOPERATION = 1;
    		
    		dialog.dismiss();
    		
    		InitializeUI();
	    	
	    	if(currnull){
	    		currnull = false;
	    		updateUIFromPreferences();
	    	}
	    	else{
		    	EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
		        txtAmount.setText("");
	    	}
    	}
    }
    
    public void refreshPage(int pos){
    	EditText minMaxAmount = (EditText)findViewById(R.id.txtAmount);
    	Spinner spinAmount = (Spinner)findViewById(R.id.spinAmount);
    	
    	if(pos == 0){
    		minMaxAmount.setVisibility(View.GONE);
    		spinAmount = (Spinner)findViewById(R.id.spinAmount);
    		spinAmount.setVisibility(View.GONE);
    		return;
    	}
    	
    	Network network_object = networks.get(pos);
    	network = network_object.getName();
    	networkid = network_object.getNetworkID();
    	productid = network_object.getProductID();
    	topupid = network_object.getTopUpID();
    	networkindex = pos;
    	min = ""; max = "";
    	
    	if(localusdindex == 1){
    		network_values = network_object.getDenominations();
    	}
    	else{
    		network_values = network_object.getUSDDenominations();
    	}
    	
    	amountcount = (network_values != null ? (network_values.size() - 1) : 0);
    	isfixed = network_object.getIsFixed();
    	if(isfixed.equals("true")){
			minMaxAmount = (EditText)findViewById(R.id.txtAmount);
			minMaxAmount.requestFocus();
			
    		if(localusdindex == 1){
        		min = network_object.getMin();
        		max = network_object.getMax();
        		
        		minMaxAmount.setHint(network_object.getCurrency() + min + " (min) - " + network_object.getCurrency() + max + " (max)");
    		}
    		else{
    			min = network_object.getUSDMin();
        		max = network_object.getUSDMax();
        		
        		minMaxAmount.setHint("USD" + min + " (min) - USD" + max + " (max)");
    		}
    		
    		minMaxAmount = (EditText)findViewById(R.id.txtAmount);
    		minMaxAmount.setVisibility(View.VISIBLE);
    		spinAmount = (Spinner)findViewById(R.id.spinAmount);
    		spinAmount.setVisibility(View.GONE);
    		
    		EditText txtPhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
    		
    		if(!amount.equals(""))
    			minMaxAmount.setText(amount);
    		if(!phonenumber.equals(""))
    			txtPhoneNumber.setText(phonenumber);
    	}
    	else if(isfixed.equals("false")){
    		if(currency.equals("USD")){
    			network_values = network_object.getUSDDenominations();
    		}
    		
    		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(CoreAirTimeActivity.this, android.R.layout.simple_spinner_item, network_values);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            spinAmount = (Spinner) findViewById(R.id.spinAmount);
            spinAmount.setAdapter(adapter2);
            spinAmount.setOnItemSelectedListener(new OnItemSelectedListener(){
            	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            		chosenamount = network_values.get(pos);
            		chosenamountindex = pos;
            		
            		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
	            	formattedamount = df.format(chosenamount);
	            	
	            	EditText minMaxAmount = (EditText)findViewById(R.id.txtAmount);
	            	minMaxAmount.setText(formattedamount);
	            	
	            	EditText txtPhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
	        		if(!phonenumber.equals(""))
	        			txtPhoneNumber.setText(phonenumber);
            	}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
            });
    		
    		minMaxAmount = (EditText)findViewById(R.id.txtAmount);
    		minMaxAmount.setVisibility(View.GONE);
    		spinAmount = (Spinner)findViewById(R.id.spinAmount);
    		spinAmount.setVisibility(View.VISIBLE);
    	}
    	else{
    		minMaxAmount = (EditText)findViewById(R.id.txtAmount);
    		minMaxAmount.setVisibility(View.GONE);
    		spinAmount = (Spinner)findViewById(R.id.spinAmount);
    		spinAmount.setVisibility(View.GONE);
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
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	//Set language
    	//setLanguage();
    	
    	EditText txtPhone = (EditText)findViewById(R.id.txtPhoneNumber);
    	phonenumber = txtPhone.getText().toString();
    	if(!phonenumber.equals("")){
    		TextView lblPhoneFormat = (TextView)findViewById(R.id.lblPhoneFormat);
    		lblPhoneFormat.setVisibility(View.VISIBLE);
    	}
    	
    	EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
    	amount = txtAmount.getText().toString();
    	if(!amount.equals("")){
    		TextView lblValueFormat = (TextView)findViewById(R.id.lblValueFormat);
    		lblValueFormat.setVisibility(View.VISIBLE);
    	}
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.mainport);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.main);
    		InitializeUI();
        }
    }
    
    public boolean verifyPhoneNumber(String phonenumber){
    	if(country.equals("Afghanistan")){
	    	if(phonenumber.startsWith("07") && !network.equalsIgnoreCase("MTN")){
	    		return false;
	    	}
    	}
    	else if(country.equals("Benin")){
	    	if((phonenumber.startsWith("066") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("067") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("096") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("097") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Benin")){
	    	if((phonenumber.startsWith("066") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("067") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("096") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("097") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Cameroon")){
	    	if((phonenumber.startsWith("070") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("071") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("072") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("073") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("074") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("075") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("076") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("077") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("078") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("079") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Congo, Republic Of")){
	    	if((phonenumber.startsWith("0065") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0066") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("0068") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0069") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Cyprus")){
	    	if((phonenumber.startsWith("095") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("096") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("097") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("099") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Democratic Republic of Congo")){
	    	if((phonenumber.startsWith("809") && !network.equalsIgnoreCase("Claro")) || (phonenumber.startsWith("829") && !network.equalsIgnoreCase("Claro")) ||
	    			(phonenumber.startsWith("849") && !network.equalsIgnoreCase("Claro"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Ghana")){
	    	if((phonenumber.startsWith("024") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("054") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Guinea")){
	    	if((phonenumber.startsWith("024") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("064") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Ivory Coast")){
	    	if((phonenumber.startsWith("004") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("005") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("006") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("044") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("045") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("046") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("054") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("055") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Liberia")){
	    	if(phonenumber.startsWith("088") && !network.equalsIgnoreCase("MTN")){
	    		return false;
	    	}
    	}
    	else if(country.equals("Nigeria")){
	    	if((phonenumber.startsWith("0802") && !network.equalsIgnoreCase("Airtel")) || (phonenumber.startsWith("0808") && !network.equalsIgnoreCase("Airtel")) ||
				(phonenumber.startsWith("0708") && !network.equalsIgnoreCase("Airtel")) || (phonenumber.startsWith("0812") && !network.equalsIgnoreCase("Airtel")))
	    			return false;
	    	
	    	else if((phonenumber.startsWith("0803") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0703") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("0806") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0706") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("0810") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0813") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("0816") && !network.equalsIgnoreCase("MTN")))
	        		return false;
	    	
	    	else if((phonenumber.startsWith("0705") && !network.equalsIgnoreCase("Globacom")) || (phonenumber.startsWith("0805") && !network.equalsIgnoreCase("Globacom")) ||
	    		    (phonenumber.startsWith("0807") && !network.equalsIgnoreCase("Globacom")) || (phonenumber.startsWith("0815") && !network.equalsIgnoreCase("Globacom")))
	        		return false;
	    	
	    	else if((phonenumber.startsWith("0809") && !network.equalsIgnoreCase("Etisalat")) || (phonenumber.startsWith("0817") && !network.equalsIgnoreCase("Etisalat")) ||
	    		    (phonenumber.startsWith("0818") && !network.equalsIgnoreCase("Etisalat")))
	        		return false;
	    	
	    	else if((phonenumber.startsWith("07025") && !network.equalsIgnoreCase("Visafone")) || (phonenumber.startsWith("07026") && !network.equalsIgnoreCase("Visafone")) ||
	    		    (phonenumber.startsWith("0704") && !network.equalsIgnoreCase("Visafone")))
	        		return false;
	    	
	    	else if((phonenumber.startsWith("07029") && !network.equalsIgnoreCase("Multilinks")) || (phonenumber.startsWith("0709") && !network.equalsIgnoreCase("Multilinks")))
	            	return false;
    	}
    	else if(country.equals("Rwanda")){
	    	if((phonenumber.startsWith("078") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0280") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("South Africa")){
	    	if((phonenumber.startsWith("073") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("083") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Swaziland")){
	    	if((phonenumber.startsWith("076") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("078") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Syria")){
	    	if((phonenumber.startsWith("095") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Uganda")){
	    	if((phonenumber.startsWith("031") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("032") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("033") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("034") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("035") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("036") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("037") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("038") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("039") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("077") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("078") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Yemen")){
	    	if((phonenumber.startsWith("07") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else if(country.equals("Zambia")){
	    	if((phonenumber.startsWith("0966") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0967") && !network.equalsIgnoreCase("MTN")) ||
	    			(phonenumber.startsWith("0968") && !network.equalsIgnoreCase("MTN")) || (phonenumber.startsWith("0969") && !network.equalsIgnoreCase("MTN"))){
	    		return false;
	    	}
    	}
    	else
    		return true;
    	
		return true;
    }
    
    /*public boolean verifyMultiples(String amount){
    	double amt = Double.parseDouble(amount);
    	String mult = "";
    	
    	if(country.equals("Afghanistan")){
    		if(currency.equals("AFN")){
		    	if((network.equalsIgnoreCase("Etisalat") && (amt % 100 != 0)) || (network.equalsIgnoreCase("Roshan") && (amt % 100 != 0)) ||
		    			(network.equalsIgnoreCase("MTN") && (amt % 100 != 0))){
		    		mult = "100";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Algeria")){
    		if(currency.equals("DZD")){
		    	if((network.equalsIgnoreCase("Djezzy") && (amt % 100 != 0))){
		    		mult = "100";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Benin")){
    		if(currency.equals("XOF")){
		    	if((network.equalsIgnoreCase("MTN") && (amt % 100 != 0))){
		    		mult = "100";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Burundi")){
    		if(currency.equals("BIF")){
		    	if((network.equalsIgnoreCase("UCOM") && (amt % 1000 != 0)) || (network.equalsIgnoreCase("Econet") && (amt % 1000 != 0))){
		    		mult = "1000";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Cameroon")){
    		if(currency.equals("XOF")){
		    	if((network.equalsIgnoreCase("MTN") && (amt % 100 != 0))){
		    		mult = "100";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Guinea")){
    		if(currency.equals("NGN")){
		    	if((network.equalsIgnoreCase("MTN") && (amt % 1000 != 0))){
		    		mult = "1000";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Ivory Coast")){
    		if(currency.equals("XOF")){
		    	if((network.equalsIgnoreCase("MTN") && (amt % 1000 != 0))){
		    		mult = "1000";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Liberia")){
    		if(currency.equals("LRD")){
		    	if((network.equalsIgnoreCase("Cellcom") && (amt % 100 != 0)) || (network.equalsIgnoreCase("Lonestar") && (amt % 100 != 0)) ||
		    			(network.equalsIgnoreCase("MTN") && (amt % 100 != 0))){
		    		mult = "100";
		    		return false;
		    	}
    		}
    	}
    	else if(country.equals("Nigeria")){
    		if(currency.equals("NGN")){
		    	if((network.equalsIgnoreCase("MTN") && (amt % 100 != 0)) || (network.equalsIgnoreCase("Glo") && (amt % 100 != 0)) ||
		    			(network.equalsIgnoreCase("Etisalat") && (amt % 100 != 0)) || (network.equalsIgnoreCase("Airtel") && (amt % 100 != 0))){
		    		mult = "100";
		    		return false;
		    	}
    		}
    	}
    	else
    		return true;
    	
		return true;
    }*/
    
    @Override
    public void onDestroy() {
    	//db.close();
    	super.onDestroy();
    }
}