package com.core.airtime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;

 public class SplashScreen extends Activity {
	 
	 public SplashScreen(){

		 super();

     }
    
    /**
     * The thread to process splash screen events
     */
    private Thread mSplashThread;    

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Splash screen view
        Configuration conf = this.getResources().getConfiguration();    	
    	if(conf.orientation == 2)
    		setContentView(R.layout.splash);
    	else
    		setContentView(R.layout.splashport);   
        
        // The thread to wait for splash screen events
        //Toast.makeText(getApplicationContext(), getString(R.string.), duration)
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
                Intent intent = new Intent(SplashScreen.this, AfterSplash.class);
                startActivity(intent);
                finish();                   
            }
        };
        mSplashThread.start();
    }
        
    /**
     * Processes splash screen touch events
     */
    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN || evt.getAction() == MotionEvent.ACTION_UP ||
           evt.getAction() == MotionEvent.ACTION_POINTER_DOWN || evt.getAction() == MotionEvent.ACTION_POINTER_UP){
            synchronized(mSplashThread){
                mSplashThread.notifyAll();
            }
        }
        
        return true;
    }
    
    public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	if (_newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
    		setContentView(R.layout.splashport);
        }
    	if (_newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    		setContentView(R.layout.splash);
        }
    }
}
