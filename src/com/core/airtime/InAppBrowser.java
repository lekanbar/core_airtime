package com.core.airtime;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class InAppBrowser extends Activity {
	private String url;
	static boolean isfirsttime = true;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.inappbrowser);
    	
    	url = getIntent().getStringExtra("url");
    	
    	InitializeUI();
    }
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	
    	if(keyCode == KeyEvent.KEYCODE_BACK){
    		AlertDialog.Builder alert = new AlertDialog.Builder(InAppBrowser.this);
			alert.setTitle(R.string.inappbrowser);
			alert.setMessage(R.string.canceltrans);
			alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					Intent i = new Intent();
		        	setResult(RESULT_OK, i);
		        	finish();
				}
			});
			alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener(){

				public void onClick(DialogInterface arg0, int arg1) {
					
				}
			});
			alert.show();
    		
    		return true;
    	}
		return false;
    }
    
    @SuppressLint("SetJavaScriptEnabled")
	@SuppressWarnings("deprecation")
	public void InitializeUI(){
    	setTitle(getString(R.string.inappbrowser));
    	
    	WebView engine = (WebView) findViewById(R.id.web_engine);
    	engine.setWebChromeClient(new InAppWebChromeClient());
    	engine.setWebViewClient(new InAppWebViewClient());
    	engine.getSettings().setJavaScriptEnabled(true);
    	engine.getSettings().setPluginsEnabled(true);
    	engine.getSettings().setAllowFileAccess(true);
    	engine.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    	
    	if(isfirsttime){
    		isfirsttime = false;
    		
    		EditText txtUrl = (EditText)findViewById(R.id.txtUrl);
            txtUrl.setText(url);
    		
    		//load quick air-time web-service url
    		engine.loadUrl(url);
    	}
    }
    
    private class InAppWebViewClient extends WebViewClient {
    	@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		EditText txtUrl = (EditText)findViewById(R.id.txtUrl);
            txtUrl.setText(url);
    		
            return false;
        }
    }
    
    private class InAppWebChromeClient extends WebChromeClient {
    	@Override
    	public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
    		// TODO Auto-generated method stub
    		super.onConsoleMessage(consoleMessage);
    		return true;
    	}
    	
        @Override
    	public boolean onJsAlert(WebView view, String url, String message, JsResult result)
        {
    		final JsResult finalRes = result;
            new AlertDialog.Builder(view.getContext())
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,
                        new AlertDialog.OnClickListener()
                        {
    						@Override
    						public void onClick(DialogInterface dialog, int which) {
    							finalRes.confirm();  
    						}
                        })
                .setCancelable(false)
                .create()
                .show();
            return true;
        }
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.inappbrowser);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.inappbrowser);
    		InitializeUI();
        }
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
}