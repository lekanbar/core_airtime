package com.core.airtime;

import java.util.ArrayList;

import com.core.airtime.SlideMenu.SlideMenuItem;
import com.core.airtime.SlideMenuInterface.OnSlideMenuItemClickListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class History extends Activity implements OnSlideMenuItemClickListener {
	//private DB db;
	private ArrayList<AirTimeHistory> airtimeHistory;
	private HistoryItemAdapter aa;
	public static final int DO_PAY = 1;
	String language; int languageindex;
	UserPreferences pref;
	private SlideMenu slidemenu;
	boolean isEditMode = false;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	//Instantiate the database
    	DB db = new DB(this);
    	db.open();
    	pref = db.getPreference(1);
    	db.close();
        
        setContentView(R.layout.history);
        
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
    		else
    			return true;
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
	
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);		
		menu.add(0, Menu.FIRST + 1, Menu.NONE, R.string.deleteall);
    }
	
	@Override
    public boolean onContextItemSelected(MenuItem item) {
    	super.onContextItemSelected(item);
    	switch (item.getItemId()) {
	    	case (Menu.FIRST + 1): {
	    		AlertDialog.Builder alert = new AlertDialog.Builder(this);
				alert.setTitle(R.string.deleteall);
				alert.setMessage(R.string.delAllHistory);
				alert.setPositiveButton(R.string.deleteall, new OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						DB db = new DB(getApplicationContext());
						db.open();
						db.removeAllHistory();
						db.close();
						
						finish();
					}
				});
				alert.setNegativeButton(R.string.goback, new OnClickListener(){
	
					public void onClick(DialogInterface arg0, int arg1) {
						
					}
				});
				alert.show();
	    		return true;
	    	}
	    	default: return false;
    	}
	}
	
	public void InitializeUI(){
		setTitle(getString(R.string.tranHis));
		
		//show on imgMenu
        ImageView imgMenu = (ImageView)findViewById(R.id.imgMenu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	slidemenu.show();
            }
        });
        
        Button cmdEdit = (Button)findViewById(R.id.cmdEdit);
        cmdEdit.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Button cmdEdit = (Button)findViewById(R.id.cmdEdit);
				if(isEditMode){
					isEditMode = false;
					cmdEdit.setText(getString(R.string.edit));
				}
				else{
					isEditMode = true;
					cmdEdit.setText(getString(R.string.done));
				}
				
				aa.notifyDataSetChanged();
			}
    	});
		
    	//Get 
		DB db = new DB(getApplicationContext());
		db.open();
		airtimeHistory = db.getAllHistory();
		db.close();
        
        if(airtimeHistory != null){
        	int size = airtimeHistory.size();
        	ListView historyList = (ListView)findViewById(R.id.listHistory);
        	if(size > 0)
        	{
        		int resID = R.layout.list_item3;
		        aa = new HistoryItemAdapter(History.this, resID, airtimeHistory);
		        historyList.setAdapter(aa);
		        
		        historyList.setOnItemClickListener(new OnItemClickListener() {
		            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
		            	
		            	final AirTimeHistory history = airtimeHistory.get(position);
		            	
		            	Intent i = new Intent(getApplicationContext(), HistoryItem.class);
    					Bundle b = new Bundle();
		    			b.putInt("index", Integer.parseInt(history.getID()));
		    			i.putExtras(b);
    					startActivity(i);
		            }
		        });
        	}
        	else{
        		AlertDialog.Builder alert = new AlertDialog.Builder(this);
    			alert.setTitle(R.string.errorTitle);
    			alert.setMessage(R.string.noTrans);
    			alert.setPositiveButton(R.string.ok, new OnClickListener(){

    				public void onClick(DialogInterface arg0, int arg1) {
    					finish();
    				}
    			});
    			alert.show();
        	}
        	registerForContextMenu(historyList);
        	
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
        }
        else{
        	AlertDialog.Builder alert = new AlertDialog.Builder(this);
			alert.setTitle("Oops");
			alert.setMessage(R.string.noTrans);
			alert.setPositiveButton(R.string.ok, new OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					finish();
				}
			});
			alert.show();
        }
    }
	
	public void deleteItem(int position){
		DB db = new DB(this);
		db.open();
		db.removeHistory(Long.parseLong(airtimeHistory.get(position).getID()));
		db.close();
		
		InitializeUI();
	}
	
	@Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
	    super.onActivityResult(reqCode, resCode, data);
	    switch(reqCode) {
		    case (DO_PAY) : {
			    if (resCode == Activity.RESULT_OK) {
			    	InitializeUI();
			    }
		    }
	    }
	}
	
	public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	setContentView(R.layout.history);
		InitializeUI();
    }
	
	@Override
    public void onDestroy() {
    	//db.close();
    	super.onDestroy();
    }
}
