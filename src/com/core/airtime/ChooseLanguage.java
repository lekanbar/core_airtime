package com.core.airtime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class ChooseLanguage extends Activity {
	private String language; int languageid;
	private int currentid;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.languages);
    	
    	currentid = getIntent().getIntExtra("currentid", 0);
    	
    	InitializeUI();
    }
    
    public void InitializeUI(){
    	setTitle(getString(R.string.chooseLang));
    	
        Spinner spinner = (Spinner) findViewById(R.id.spinLanguage);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.language_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(currentid, true);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
        	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        		Resources r = getResources();
            	language = r.getStringArray(R.array.language_options)[pos];
            	languageid = pos;
            	Intent i = new Intent();
            	i.putExtra("language", language);
            	i.putExtra("languageid", languageid);
            	setResult(RESULT_OK, i);
            	finish();
            }

            public void onNothingSelected(AdapterView<?> parent) {
              // Do nothing.
            }
        });
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.languages);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.languages);
    		InitializeUI();
        }
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
}