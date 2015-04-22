package com.core.airtime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

 public class TutorialMain extends Activity {
    
    /**
     * The thread to process splash screen events
     */
    private Thread mSplashThread;    

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final TutorialMain sPlashScreen = TutorialMain.this; 

        DB db = new DB(sPlashScreen);
        db.open();
    	UserPreferences pref = db.getPreference(1);
    	db.close();
    	
    	if(pref.getIsFirstTime().equals("true")){
	        // Splash screen view
	        Configuration conf = this.getResources().getConfiguration();    	
	    	if(conf.orientation == 2)
	    		setContentView(R.layout.tut);
	    	else
	    		setContentView(R.layout.tutport);
	    	
	    	Button cmdEnter_button = (Button)findViewById(R.id.cmdEnter);
	    	cmdEnter_button.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					Intent intent = new Intent(sPlashScreen, CoreAirTimeActivity.class);
	                Bundle b = new Bundle();
	            	b.putBoolean("new", false);
	            	intent.putExtras(b);
	                startActivity(intent);
	                finish();
				}
	    	});
	    	
	    	pref.setIsFirstTime("false");
    		db.open();
    		db.updatePreferences(1, pref);
    		db.close();
	        
	        // The thread to wait for splash screen events
	        mSplashThread =  new Thread(){
	            @Override
	            public void run(){
	                try {
	                    synchronized(this){
	                        // Wait given period of time or exit on touch
	                        wait(3000);
	                    }
	                }
	                catch(InterruptedException ex){                    
	                }
	                
	                // Run next activity
	                Intent intent = new Intent(sPlashScreen, CoreAirTimeActivity.class);
	                Bundle b = new Bundle();
	            	b.putBoolean("new", false);
	            	intent.putExtras(b);
	                startActivity(intent);
	                finish();
	                //stop();                    
	            }
	        };
	        //mSplashThread.start();
    	}
    	else{
    		// Run next activity
            Intent intent = new Intent(sPlashScreen, CoreAirTimeActivity.class);
            Bundle b = new Bundle();
        	b.putBoolean("new", false);
        	intent.putExtras(b);
            startActivity(intent);
            finish();
    	}
    }
        
    /**
     * Processes splash screen touch events
     */
    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized(mSplashThread){
                mSplashThread.notifyAll();
            }
        }
        return true;
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.tutport);
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.tut);
        }
    }
}
