package com.core.airtime;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ScrollView;

public class About extends Activity{
	
	ScrollView mScrollView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.about);
    	
    	InitializeUI();
	}
	
	public void InitializeUI(){
		setTitle(getString(R.string.about));
		
		WebView mWebView2 = (WebView) findViewById(R.id.webviewAbout);		 		           
		mWebView2.loadUrl("file:///android_asset/about.html");
    }
	/*
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    // Create and add new menu items.
	    MenuItem itemLive = menu.add(0, Menu.FIRST, Menu.NONE, R.string.livechat);
	    itemLive.setShortcut('1', 'l'); itemLive.setIcon(R.drawable.livechat);
	    return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    super.onOptionsItemSelected(item);
	    switch (item.getItemId()) {
		    case (Menu.FIRST): {
		    	Intent i = new Intent(About.this, LiveChat.class);
				startActivity(i);
				finish();
		    	return true;
		    }
	    }
	    return false;
	}*/
	
	public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
		setContentView(R.layout.about);
		InitializeUI();
    }
	
	@Override
    public void onDestroy() {
    	super.onDestroy();
    }
}
