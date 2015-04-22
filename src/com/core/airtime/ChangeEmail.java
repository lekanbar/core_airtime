package com.core.airtime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeEmail extends Activity {
	private String email;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.emailchange);
    	
    	email = getIntent().getStringExtra("email");
    	
    	InitializeUI();
    }
    
    public void InitializeUI(){
    	setTitle(getString(R.string.cemail));
    	
    	EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtEmail.setText(email);
        
        Button cmdSend_button = (Button)findViewById(R.id.cmdOk);
    	cmdSend_button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				//email setting
				EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
				if(!isEmailValid(txtEmail.getText().toString())){
					TextView lblErrMsg = (TextView)findViewById(R.id.lblErrMessage);
					lblErrMsg.setVisibility(TextView.VISIBLE);
	    			return;
				}
				
				Intent i = new Intent();
            	i.putExtra("email", txtEmail.getText().toString());
            	setResult(RESULT_OK, i);
            	finish();
			}
    	});
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
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.emailchange);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.emailchange);
    		InitializeUI();
        }
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
}