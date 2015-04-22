package com.core.airtime;

import java.util.ArrayList;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Pay extends Activity implements OnSlideMenuItemClickListener {
	private String network, networkid, email, number, amount, transactionid, /*transactionstatus,*/ country, countryid, currency, language, formattedamount,
	               formattedphone, gatewayid, productid;
	private int networkindex, chosenamountindex, countryindex, languageindex;
	
	UserPreferences pref;
	ArrayList<Gateway> gateways;
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
    	        
        Configuration conf = this.getResources().getConfiguration();    	
    	if(conf.orientation == 2)
    		setContentView(R.layout.pay);
    	else
    		setContentView(R.layout.payport);    	
    	
    	//get from bundle
    	Bundle b = getIntent().getExtras();
    	number = b.getString("phone");
    	email = b.getString("email");
    	amount = b.getString("amount");
    	network = b.getString("network");
    	networkid = b.getString("networkid");
    	productid = b.getString("productid");
    	country = b.getString("country");
    	countryid = b.getString("countryid");
    	countryindex = b.getInt("countryindex");
    	networkindex = b.getInt("networkindex");
    	chosenamountindex = b.getInt("chosenamountindex");
    	transactionid = b.getString("transactionid");
    	currency = b.getString("currency");
    	//language = b.getString("language");
    	formattedamount = b.getString("formattedamount");
    	formattedphone = b.getString("formattedphone");
    	    	
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
    
    public void InitializeUI(){
    	setTitle(getString(R.string.vpay));
    	
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
    	    	
    	TextView transactionID = (TextView) findViewById(R.id.lblTransactionID);
    	transactionID.setText(transactionid);
    	
    	TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
    	lblEmail.setText(email);
    	
    	TextView lblnumber = (TextView) findViewById(R.id.lblPhone);
    	lblnumber.setText(formattedphone);
    	lblnumber.setClickable(true);
    	lblnumber.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				savePreferences();
				Intent i = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
				Bundle b = new Bundle();
				b.putBoolean("new", false);
				CoreAirTimeActivity.isfirst = true;
				i.putExtras(b);
				startActivity(i);
				finish();
			}        	
        });
    	
    	TextView lblnetwork = (TextView) findViewById(R.id.lblNetwork);
    	lblnetwork.setText(network);
    	lblnetwork.setClickable(true);
    	lblnetwork.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				savePreferences();
				Intent i = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
				Bundle b = new Bundle();
				b.putBoolean("new", true);
				CoreAirTimeActivity.isfirst = true;
				i.putExtras(b);
				startActivity(i);
				finish();
			}        	
        });
    	
    	TextView lblamount = (TextView) findViewById(R.id.lblAmount);
    	lblamount.setText(currency  + " " + formattedamount);
    	lblamount.setClickable(true);
    	lblamount.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				savePreferences();
				Intent i = new Intent(getApplicationContext(), CoreAirTimeActivity.class);
				Bundle b = new Bundle();
				b.putBoolean("new", true);
				CoreAirTimeActivity.isfirst = true;
				i.putExtras(b);
				startActivity(i);
				finish();
			}        	
        });
        
    	ImageButton cmdGoogleCheck = (ImageButton)findViewById(R.id.cmdGoogleCheck);
    	cmdGoogleCheck.setTag(getGatewayID("Google Checkout"));
    	cmdGoogleCheck.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdGoogleCheck = (ImageButton)findViewById(R.id.cmdGoogleCheck);
				if(cmdGoogleCheck.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdGoogleCheck.getTag().toString();
					callPayInfo(0);
				}
			}    	
        });
    	
    	ImageButton cmdVerve = (ImageButton)findViewById(R.id.cmdVerve);
    	cmdVerve.setTag(getGatewayID("Interswitch"));
    	cmdVerve.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdVerve = (ImageButton)findViewById(R.id.cmdVerve);
				if(cmdVerve.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdVerve.getTag().toString();
					callPayInfo(1);
				}
			}  	
        });
    	
    	ImageButton cmdVisaNaira = (ImageButton)findViewById(R.id.cmdVisanaira);
    	cmdVisaNaira.setTag(getGatewayID("VisaNigeria"));
    	cmdVisaNaira.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdVisanaira = (ImageButton)findViewById(R.id.cmdVisanaira);
				if(cmdVisanaira.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdVisanaira.getTag().toString();
					callPayInfo(2);
				}
			}  	
        });
    	
    	ImageButton cmdMastercardNaira = (ImageButton)findViewById(R.id.cmdMasterCardNaira);
    	cmdMastercardNaira.setTag(getGatewayID("MasterCardNigeria"));
    	cmdMastercardNaira.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdMasterCardNaira = (ImageButton)findViewById(R.id.cmdMasterCardNaira);
				if(cmdMasterCardNaira.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdMasterCardNaira.getTag().toString();
					callPayInfo(3);
				}
			}  	
        });
    	
    	ImageButton cmdGiftCodeX = (ImageButton)findViewById(R.id.cmdGiftCodeX);
    	cmdGiftCodeX.setTag("9");//getGatewayID("Giftcodex"));
    	cmdGiftCodeX.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdGiftCodeX = (ImageButton)findViewById(R.id.cmdGiftCodeX);
				if(cmdGiftCodeX.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdGiftCodeX.getTag().toString();
					callPayInfo(4);
				}
			}  	
        });
    	
    	ImageButton cmdDiscover = (ImageButton)findViewById(R.id.cmdDiscover);
    	cmdDiscover.setTag(getGatewayID("asdf"));
    	cmdDiscover.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdDiscover = (ImageButton)findViewById(R.id.cmdDiscover);
				if(cmdDiscover.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdDiscover.getTag().toString();
					callPayInfo(5);
				}
			}  	
        });
    	
    	ImageButton cmdVisa = (ImageButton)findViewById(R.id.cmdVisa);
    	cmdVisa.setTag(getGatewayID("VISACard"));
    	cmdVisa.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdVisa = (ImageButton)findViewById(R.id.cmdVisa);
				if(cmdVisa.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdVisa.getTag().toString();
					callPayInfo(6);
				}
			}      	
        });
    	
    	ImageButton cmdMasterCard = (ImageButton)findViewById(R.id.cmdMastercard);
    	cmdMasterCard.setTag(getGatewayID("MasterCard"));
    	cmdMasterCard.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdMastercard = (ImageButton)findViewById(R.id.cmdMastercard);
				if(cmdMastercard.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdMastercard.getTag().toString();
					callPayInfo(7);
				}
			}      	
        });
    	
    	ImageButton cmdEtranzact = (ImageButton)findViewById(R.id.cmdEtranzact);
    	cmdEtranzact.setTag(getGatewayID("Etranzact"));
    	cmdEtranzact.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdEtranzact = (ImageButton)findViewById(R.id.cmdEtranzact);
				if(cmdEtranzact.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdEtranzact.getTag().toString();
					callPayInfo(8);
				}
			}     	
        });
    	
    	ImageButton cmdCoremobile = (ImageButton)findViewById(R.id.cmdCoremobile);
    	cmdCoremobile.setTag(getGatewayID("Quick Airtime Merchants"));
    	cmdCoremobile.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdCoremobile = (ImageButton)findViewById(R.id.cmdCoremobile);
				if(cmdCoremobile.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdCoremobile.getTag().toString();
					callPayInfo(9);
				}
			}  	
        });
    	
    	ImageButton cmdAmazon = (ImageButton)findViewById(R.id.cmdAmazonCheck);
    	cmdAmazon.setTag(getGatewayID("Amazon Payments"));
    	cmdAmazon.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdAmazonCheck = (ImageButton)findViewById(R.id.cmdAmazonCheck);
				if(cmdAmazonCheck.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdAmazonCheck.getTag().toString();
					callPayInfo(10);
				}
			}    	
        });
    	
    	ImageButton cmdPaypal = (ImageButton)findViewById(R.id.cmdPaypal);
    	cmdPaypal.setTag(getGatewayID("Paypal"));
    	cmdPaypal.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				ImageButton cmdPaypal = (ImageButton)findViewById(R.id.cmdPaypal);
				if(cmdPaypal.getTag().toString().equals("")){
					AlertDialog.Builder alert = new AlertDialog.Builder(Pay.this);
	    			alert.setTitle(R.string.errorTitle);
	    			alert.setMessage(R.string.gatewayready);
	    			alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){

						public void onClick(DialogInterface arg0, int arg1) {
							
						}
	    			});
	    			alert.show();
					return;
				}
				else{
					gatewayid = cmdPaypal.getTag().toString();
					callPayInfo(11);
				}
			}        	
        });
    }
    
    private String getGatewayID(String gatewayName){
    	Gateway g = new Gateway(Pay.this);
    	g = g.getGateway2(gatewayName);
    	
    	if(g == null)
    		return "";
    	
    	return g.getGatewayID();
    }
    
    private void callPayInfo(int paygate){
    	Intent i;
    	
    	if(paygate != 9)
    		i = new Intent(Pay.this, PayInfo.class);
    	else
    		i = new Intent(Pay.this, CoreMerchant.class);
    		
		Bundle b = new Bundle();
		b.putInt("paygate", paygate);
		b.putString("gatewayid", gatewayid);
		b.putString("number", number);
		b.putString("email", email);
		b.putString("networkid", networkid);
		b.putString("productid", productid);
		b.putString("network", network);
		b.putInt("networkindex", networkindex);
		b.putString("amount", amount);
		b.putString("formattedamount", formattedamount);
		b.putString("formattedphone", formattedphone);
		b.putString("transactionid", transactionid);
		//b.putString("transactionstatus", transactionstatus);
		b.putString("country", country);
		b.putString("countryid", countryid);
		b.putString("currency", currency);
		b.putInt("countryindex", countryindex);
		b.putInt("chosenamountindex", chosenamountindex);
		b.putString("language", language);
		b.putInt("languageindex", languageindex);
		
		i.putExtras(b);
		startActivity(i);
		finish();
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.payport);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.pay);
    		InitializeUI();
        }
    }
    
    @Override
    public void onDestroy() {
    	//db.close();
    	super.onDestroy();
    }
}
