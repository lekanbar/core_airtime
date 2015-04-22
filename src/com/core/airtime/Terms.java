package com.core.airtime;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;

public class Terms extends Activity{
	
	ScrollView mScrollView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.terms);
    	
    	InitializeUI();
	}
	
	public void InitializeUI(){
		setTitle(getString(R.string.tandC));
		
		WebView mWebView1 = (WebView) findViewById(R.id.webviewTerms);		 		           
		mWebView1.loadUrl("file:///android_asset/terms.html");
		
		Button cmdTop_button = (Button)findViewById(R.id.cmdTop);
		cmdTop_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mScrollView = (ScrollView)findViewById(R.id.scrollView2);
				mScrollView.post(new Runnable() { 
			        public void run() { 
			             mScrollView.fullScroll(View.FOCUS_UP);
			        } 
				});
			}
    		
    	});
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
	    	Intent i = new Intent(Terms.this, LiveChat.class);
			startActivity(i);
			finish();
	    	return true;
	    }
	    }
	    return false;
	}
	*/
	
	public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
		setContentView(R.layout.terms);
		InitializeUI();
    }
	
	@Override
    public void onDestroy() {
    	super.onDestroy();
    }
}
