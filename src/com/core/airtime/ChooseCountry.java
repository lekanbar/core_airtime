package com.core.airtime;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ChooseCountry extends Activity {
	private String country, countryid, fromafter;
	private ArrayList<Country> countries;
	int countryindex;
	EditText countrySearch;
	ArrayAdapter<Country> adapter;
	ListView lstCountry;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.countries);
        
        String cou = getIntent().getExtras().getString("countryindex");
        if(cou != null)
        	countryindex = Integer.parseInt(cou);
        else
        	countryindex = 0;
        
        fromafter = getIntent().getExtras().getString("fromafter");
    	
    	InitializeUI();
    }
    
    private TextWatcher filterTextWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            adapter.getFilter().filter(s);
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
        }
    };
    
    public void InitializeUI(){
    	setTitle(getString(R.string.chooseCountry));
    	
    	/*countries = CountryNetworkGateway.GetCountries(this);
        Spinner spinner = (Spinner) findViewById(R.id.spinCountry);
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(currentid, true);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());*/
    	
    	countrySearch = (EditText) findViewById(R.id.countrysearch_box);
        countrySearch.addTextChangedListener(filterTextWatcher);
        if(country != null)
        	countrySearch.setText(country);
        
    	countries = CountryNetworkGateway.GetCountries(this);
    	lstCountry = (ListView)findViewById(R.id.listCountry);
    	adapter = new ArrayAdapter<Country>(this, android.R.layout.simple_list_item_1, countries){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.BLACK);

                return view;
            }
        };
    	lstCountry.setAdapter(adapter);
    	lstCountry.setSelection(countryindex);
    	lstCountry.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int pos, long arg3) {
				// TODO Auto-generated method stub
				Country count = (Country)adapter.getItemAtPosition(pos);				
				country = count.getName();
				if(!country.startsWith("Select")){
					if(fromafter == null || fromafter.equals("")){
				        Currency curr = new Currency(ChooseCountry.this);
				        curr = curr.getCurrency(country);
				        
				        if(curr == null){
				        	AlertDialog.Builder alert = new AlertDialog.Builder(ChooseCountry.this);
							alert.setTitle(R.string.errorTitle);
							alert.setMessage(R.string.countnotsupp);
							alert.setNegativeButton(R.string.goback, new DialogInterface.OnClickListener(){
		
								public void onClick(DialogInterface arg0, int arg1) {
									
								}
							});
							alert.show();
							
							return;
				        }
					}
					
					//do the normal stuff
					countryid = count.getCountryID();
					
					int cot = 0;
					for(Country c : countries){
						if(c.getCountryID().equals(countryid)){
							break;
						}
						cot++;
					}
		        	
					//countrySearch.setText(country);
					Intent i = new Intent();
		        	i.putExtra("country", country);
		        	i.putExtra("countryid", countryid);
		        	i.putExtra("countryindex", cot);
		        	i.putExtra("countrycode", count.getIntlCallingCode());
		        	i.putExtra("currency", count.getCurrency());
		        	setResult(RESULT_OK, i);
		        	finish();
				}
			}
    	});
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.countries);
    		InitializeUI();
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.countries);
    		InitializeUI();
        }
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
}