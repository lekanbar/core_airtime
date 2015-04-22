package com.core.airtime;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HistoryItem extends Activity{
	
	//private DB db;
	private int index;
	private AirTimeHistory item;
	SharedPreferences prefs;
	String language; int languageindex;
	UserPreferences pref;
	ProgressDialog dialog;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
    	pref = db.getPreference(1);
        
        setContentView(R.layout.historyitem);
    	
    	Bundle b = getIntent().getExtras();
    	index = b.getInt("index");
    	item = db.getHistory(index);
    	db.close();
    	
    	if(item.getTransactionStatus().equals("0")){
	    	dialog = ProgressDialog.show(HistoryItem.this, getString(R.string.pingtitle), getString(R.string.checkstat), false);
	    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		    	nameValuePairs.add(new BasicNameValuePair("cmd", "03"));
	            nameValuePairs.add(new BasicNameValuePair("authtoken", pref.getAuthToken()));
	            nameValuePairs.add(new BasicNameValuePair("tranx_id", item.getTransactionID()));
	        API_Interact api = new API_Interact(API_Interact.TODO_TRANSACTION_STATUS, API_Interact.CLASSTYPE8, nameValuePairs, HistoryItem.this);
				api.execute("");
    	}
    	else{
    		InitializeUI();
    	}
	}
	
	public void done(String res){
    	dialog.dismiss();
    	
    	if(!res.equals("")){
    		DB db = new DB(this);
        	db.open();
    		item = db.getHistory(index);
    		db.close();
    	}
    	
    	InitializeUI();
    }
	
	public void InitializeUI(){
		setTitle(getString(R.string.historyItem));
		
		Button cmdBack = (Button)findViewById(R.id.cmdBack);
    	cmdBack.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				finish();
			}
    	});
    	
    	Button cmdDelete = (Button)findViewById(R.id.cmdDelete);
    	cmdDelete.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				AlertDialog.Builder alert = new AlertDialog.Builder(HistoryItem.this);
				alert.setTitle(R.string.delTitle);
				alert.setMessage(R.string.delItem);
				alert.setPositiveButton(R.string.delete, new AlertDialog.OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						DB db = new DB(getApplicationContext());
						db.open();
						db.removeHistory(Long.parseLong(item.getID()));
						db.close();
						finish();
					}
				});
				alert.setNegativeButton(R.string.goback, new AlertDialog.OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						
					}
				});
				alert.show();
			}
    	});
    	
    	Button cmdReload = (Button)findViewById(R.id.cmdReload);
    	cmdReload.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), Pay.class);
				Bundle b = new Bundle();
    			b.putString("network", item.getNetwork());
    			b.putInt("networkindex", Integer.parseInt(item.getNetworkIndex()));
    			b.putString("email", item.getEmail());
    			b.putString("phone", item.getPhoneNumber());
    			b.putString("amount", item.getAmount());
    			b.putString("transactionid", UniqueID.GetUniqueID(item.getPhoneNumber()).toUpperCase());
    			b.putString("country", item.getCountry());
    			b.putString("countryid", item.getCountryIndex());
    			b.putInt("countryindex", Integer.parseInt(item.getCountryIndex()));
    			b.putInt("chosenamountindex", Integer.parseInt(item.getChosenAmountIndex()));
    			b.putString("currency", item.getCurrency());
    			b.putString("language", language);
    			b.putInt("languageindex", languageindex);
    			i.putExtras(b);		
				startActivity(i);
				finish();
			}
    	});
    	
    	TextView transactionID = (TextView) findViewById(R.id.lblTransactionID);
    	transactionID.setText(item.getTransactionID());
    	
    	TextView network = (TextView) findViewById(R.id.lblNetwork);
    	network.setText(item.getNetwork());
    	
    	TextView amount = (TextView) findViewById(R.id.lblAmount);
    	amount.setText(item.getCurrency() + " " + item.getAmount());
    	
    	TextView phoneNumber = (TextView) findViewById(R.id.lblPhone);
    	phoneNumber.setText(item.getPhoneNumber());
    	
    	TextView email = (TextView) findViewById(R.id.lblEmail);
    	email.setText(item.getEmail());
    	
    	TextView date = (TextView) findViewById(R.id.lblDateTime);
    	date.setText(item.getDateTime());
    	
    	Gateway gate = new Gateway(this);
    	gate = gate.getGateway(item.getGatewayID());
    	TextView lblPaymentGateway = (TextView) findViewById(R.id.lblPaymentGateway);
    	lblPaymentGateway.setText(gate.getGatewayName());
    	
    	LinearLayout laytop = (LinearLayout) findViewById(R.id.laytop);
    	if(!gate.getGatewayID().equals("core")){
	    	if(item.getTransactionStatus().equals("0") || item.getTopupStatus().equals("0"))
	    		laytop.setBackgroundColor(Color.BLUE);
	    	else if(item.getTransactionStatus().equals("1") && item.getTopupStatus().equals("1"))
	    		laytop.setBackgroundColor(Color.GREEN);
	    	else
	    		laytop.setBackgroundColor(Color.RED);
	    	
	    	TextView lblPaymentStatus = (TextView) findViewById(R.id.lblPaymentStatus);
	    	lblPaymentStatus.setText(getTransactionStatus());
	    	if(item.getTransactionStatus().equals("0"))
	    		lblPaymentStatus.setTextColor(Color.BLUE);
	    	else if(item.getTransactionStatus().equals("1"))
	    		lblPaymentStatus.setTextColor(Color.GREEN);
	    	else
	    		lblPaymentStatus.setTextColor(Color.RED);
	    	
	    	TextView lblTopupStatus = (TextView) findViewById(R.id.lblTopupStatus);
	    	lblTopupStatus.setText(getTopupStatus());
	    	if(item.getTopupStatus().equals("0"))
	    		lblTopupStatus.setTextColor(Color.BLUE);
	    	else if(item.getTransactionStatus().equals("1"))
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
    		
    		if(item.getTransactionStatus().equals("0")){
	    		laytop.setBackgroundColor(Color.BLUE);
	    		lblTransReport.setTextColor(Color.BLUE);
    		}
	    	else if(item.getTransactionStatus().equals("-1")){
	    		laytop.setBackgroundColor(Color.GREEN);
	    		lblTransReport.setTextColor(Color.GREEN);
	    	}
	    	else{
	    		laytop.setBackgroundColor(Color.RED);
	    		lblTransReport.setTextColor(Color.RED);
	    	}
    	}
    }
	
	private String getTransactionStatus(){
    	if(item.getTransactionStatus().equals("0"))
    		return getString(R.string.pending);
    	else if(item.getTransactionStatus().equals("1"))
    		return getString(R.string.p1);
    	else if(item.getTransactionStatus().equals("2"))
    		return getString(R.string.p2);
    	else if(item.getTransactionStatus().equals("3"))
    		return getString(R.string.p3);
    	else if(item.getTransactionStatus().equals("4"))
    		return getString(R.string.p4);
    	else if(item.getTransactionStatus().equals("5"))
    		return getString(R.string.p5);
    	else
    		return getString(R.string.p6);
    }
    
    private String getTopupStatus(){
    	if(item.getTopupStatus().equals("0"))
    		return getString(R.string.pending);
    	else if(item.getTransactionStatus().equals("1"))
    		return getString(R.string.t1);
    	else if(item.getTransactionStatus().equals("2"))
    		return getString(R.string.t2);
    	else
    		return getString(R.string.t3);
    }
	
	public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	setContentView(R.layout.historyitem);
		InitializeUI();
    }
	
	@Override
    public void onDestroy() {
    	//db.close();
    	super.onDestroy();
    }
}
