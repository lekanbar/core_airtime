package com.core.airtime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.core.airtime.SlideMenu.SlideMenuItem;
import com.core.airtime.SlideMenuInterface.OnSlideMenuItemClickListener;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TransactionReport extends Activity implements OnSlideMenuItemClickListener {
	private String network, email, number, amount, transactionid, country, countryid, currency, 
	               formattedamount, formattedphone;
	private int networkindex, countryindex, chosenamountindex;
	
	private SlideMenu slidemenu;
	UserPreferences pref;
	ProgressDialog dialog;
	AirTimeHistory hist;
	static boolean isfirsttime = true;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                   	
        setContentView(R.layout.transactionreport);
    	
        if(isfirsttime){
        	isfirsttime = false;
        	
	    	//get from bundle
	    	Bundle b = getIntent().getExtras();
	    	number = b.getString("number");
	    	email = b.getString("email");
	    	amount = b.getString("amount");
	    	network = b.getString("network");
	    	networkindex = b.getInt("networkindex");
	    	country = b.getString("country");
	    	countryid = b.getString("countryid");
	    	countryindex = b.getInt("countryindex");
	    	chosenamountindex = b.getInt("chosenamountindex");
	    	transactionid = b.getString("transactionid");
	    	formattedamount = b.getString("formattedamount");
	    	formattedphone = b.getString("formattedphone");
	    	currency = b.getString("currency");
	    	
	    	//Instantiate the database
	    	DB db = new DB(this);
	    	db.open();
	    	pref = db.getPreference(1);
	    	hist = db.getHistory(transactionid);
	    	db.close();
	    	
	    	if(hist.getTransactionStatus().equals("0")){
		    	dialog = ProgressDialog.show(TransactionReport.this, getString(R.string.pingtitle), getString(R.string.checkstat), false);
		    	
		    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		            nameValuePairs.add(new BasicNameValuePair("cmd", "03"));
		            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
		            nameValuePairs.add(new BasicNameValuePair("tranx_id", hist.getTransactionID()));
		        API_Interact api = new API_Interact(API_Interact.TODO_TRANSACTION_STATUS, API_Interact.CLASSTYPE7, nameValuePairs, TransactionReport.this);
					api.execute("");
	    	}
	    	else
	    		InitializeUI();
        }
        else
			InitializeUI();
    }
    
    public void done(String res){
    	dialog.dismiss();
    	
    	if(!res.equals("")){
    		DB db = new DB(this);
        	db.open();
    		hist = db.getHistory(transactionid);
    		db.close();
    	}
    	
    	InitializeUI();
    } 
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	
    	if(keyCode == KeyEvent.KEYCODE_BACK){
    		if(slidemenu.getVisibility() == View.VISIBLE){
    			slidemenu.hide();
    			slidemenu.setVisibility(View.GONE);
    			return false;
    		}
    		else{
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
    	}
		return false;
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
    	setTitle(getString(R.string.tranReport));
    	
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
    	
    	TextView transactionID = (TextView) findViewById(R.id.lblTransactionID);
    	transactionID.setText(transactionid);
    	
    	TextView lblnumber = (TextView) findViewById(R.id.lblPhone);
    	lblnumber.setText(formattedphone);
    	
    	TextView lblnetwork = (TextView) findViewById(R.id.lblNetwork);
    	lblnetwork.setText(network);
    	
    	TextView lblemail = (TextView) findViewById(R.id.lblEmail);
    	lblemail.setText(email);
    	
    	TextView lblamount = (TextView) findViewById(R.id.lblAmount);
    	lblamount.setText(currency + " " + formattedamount);
    	
    	Gateway gate = new Gateway(TransactionReport.this);
    	gate = gate.getGateway(hist.getGatewayID());
    	TextView lblPaymentGateway = (TextView) findViewById(R.id.lblPaymentGateway);
    	lblPaymentGateway.setText(gate.getGatewayName());
    	
    	LinearLayout laytop = (LinearLayout) findViewById(R.id.laytop);
    	if(!gate.getGatewayID().equals("core")){
	    	if(hist.getTransactionStatus().equals("0") || hist.getTopupStatus().equals("0"))
	    		laytop.setBackgroundColor(Color.BLUE);
	    	else if(hist.getTransactionStatus().equals("1") && hist.getTopupStatus().equals("1"))
	    		laytop.setBackgroundColor(Color.GREEN);
	    	else
	    		laytop.setBackgroundColor(Color.RED);
	    	
	    	TextView lblPaymentStatus = (TextView) findViewById(R.id.lblPaymentStatus);
	    	lblPaymentStatus.setText(getTransactionStatus());
	    	if(hist.getTransactionStatus().equals("0"))
	    		lblPaymentStatus.setTextColor(Color.BLUE);
	    	else if(hist.getTransactionStatus().equals("1"))
	    		lblPaymentStatus.setTextColor(Color.GREEN);
	    	else
	    		lblPaymentStatus.setTextColor(Color.RED);
	    	
	    	TextView lblTopupStatus = (TextView) findViewById(R.id.lblTopupStatus);
	    	lblTopupStatus.setText(getTopupStatus());
	    	if(hist.getTopupStatus().equals("0"))
	    		lblTopupStatus.setTextColor(Color.BLUE);
	    	else if(hist.getTransactionStatus().equals("1"))
	    		lblTopupStatus.setTextColor(Color.GREEN);
	    	else
	    		lblTopupStatus.setTextColor(Color.RED);
    	}
    	else{
    		LinearLayout laypaystatus = (LinearLayout) findViewById(R.id.laypaystatus);
    		LinearLayout laytopupstatus = (LinearLayout) findViewById(R.id.laytopupstatus);
    		LinearLayout laytransreport = (LinearLayout) findViewById(R.id.laytransreport);
    		
    		laypaystatus.setVisibility(View.GONE);
    		laytopupstatus.setVisibility(View.GONE);
    		laytransreport.setVisibility(View.VISIBLE);
    		
    		TextView lblTransReport = (TextView) findViewById(R.id.lblTransReport);
    		lblTransReport.setText(getTransactionStatus());
    		
    		if(hist.getTransactionStatus().equals("0")){
	    		laytop.setBackgroundColor(Color.BLUE);
	    		lblTransReport.setTextColor(Color.BLUE);
    		}
	    	else if(hist.getTransactionStatus().equals("-1")){
	    		laytop.setBackgroundColor(Color.GREEN);
	    		lblTransReport.setTextColor(Color.GREEN);
	    	}
	    	else{
	    		laytop.setBackgroundColor(Color.RED);
	    		lblTransReport.setTextColor(Color.RED);
	    	}
    	}
        
    	Button cmdSameTransaction = (Button)findViewById(R.id.cmdSameTransaction);
    	cmdSameTransaction.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), Pay.class);
				Bundle b = new Bundle();
    			b.putString("network", network);
    			b.putInt("networkindex", networkindex);
    			b.putString("email", email);
    			b.putString("phone", number);
    			b.putString("amount", amount);
    			b.putString("transactionid", GetUniqueID(number).toUpperCase());
    			b.putString("country", country);
    			b.putString("countryid", countryid);
    			b.putInt("countryindex", countryindex);
    			b.putInt("chosenamountindex", chosenamountindex);
    			b.putString("formattedamount", formattedamount);
    			b.putString("formattedphone", formattedphone);
    			b.putString("currency", currency);
    			i.putExtras(b);		
				startActivity(i);
				finish();
			}        	
        });
    	
    	Button cmdNewTransaction = (Button)findViewById(R.id.cmdNewTransaction);
    	cmdNewTransaction.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
				Bundle b = new Bundle();
    			b.putBoolean("new", false);
				CoreAirTimeActivity.isfirst = true;
    			i.putExtras(b);
				startActivity(i);
				finish();
			}        	
        });
    }
    
    private String getTransactionStatus(){
    	if(hist.getTransactionStatus().equals("0"))
    		return getString(R.string.pending);
    	else if(hist.getTransactionStatus().equals("1"))
    		return getString(R.string.p1);
    	else if(hist.getTransactionStatus().equals("2"))
    		return getString(R.string.p2);
    	else if(hist.getTransactionStatus().equals("3"))
    		return getString(R.string.p3);
    	else if(hist.getTransactionStatus().equals("4"))
    		return getString(R.string.p4);
    	else if(hist.getTransactionStatus().equals("5"))
    		return getString(R.string.p5);
    	else if(hist.getTransactionStatus().equals("-1"))
    		return getString(R.string.success);
    	else if(hist.getTransactionStatus().equals("-2"))
    		return getString(R.string.unsuccess);
    	else
    		return getString(R.string.p6);
    }
    
    private String getTopupStatus(){
    	if(hist.getTopupStatus().equals("0"))
    		return getString(R.string.pending);
    	else if(hist.getTransactionStatus().equals("1"))
    		return getString(R.string.t1);
    	else if(hist.getTransactionStatus().equals("2"))
    		return getString(R.string.t2);
    	else
    		return getString(R.string.t3);
    }
    
    private String GetUniqueID(String phoneNumber){
    	Calendar c = Calendar.getInstance();
    	String hour = (String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY))); 
    	String minute = (String.valueOf(c.get(Calendar.MINUTE)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE)));
    	
    	int len = phoneNumber.length();
    	String ph = phoneNumber.substring(1, len);
    	if(ph.length() == 7) ph += "000";
    	else if(ph.length() == 8) ph += "00";
    	else if(ph.length() == 9) ph += "0";
    	
    	String uniqueID = hour + minute + ph +
    			          computeTotalDays(c.get(Calendar.DATE), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
    	return uniqueID;
    }
	
	public static String computeTotalDays(int day, int month, int year){
        int daysPassed = 0;
        
        for(int i = 1; i < month; i++)
        {
            daysPassed += daysInMonth(day,i,year);
        }
        
        String ret = String.valueOf(daysPassed + day + 1);
        
        if(ret.length() == 2)
        	ret = "0" + ret;
        
        return ret;
	}
	
	public static int daysInMonth(int day, int month, int year){
	
	    if ( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
	        return 31;
	
	    if ( month == 4 || month == 6 || month == 9 || month == 11 )
	        return 30;
	
	    if ( month == 2 ) return isLeapYear(year) ? 29 : 28;
	
	    return 0;
	
	}
	
	public static boolean isLeapYear(int year) {    	
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, year);
	    return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	//setLanguage();
    	
    	setContentView(R.layout.transactionreport);
		InitializeUI();
    }
    
    @Override
    public void onDestroy() {
    	//db.close();
    	super.onDestroy();
    }
}
