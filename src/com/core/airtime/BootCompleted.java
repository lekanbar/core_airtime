package com.core.airtime;

import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;

// here is the OnRevieve method which will be called when boot completed
public class BootCompleted extends BroadcastReceiver{
     
	@Override
     public void onReceive(Context context, Intent intent) {
		 //we double check here for only boot complete event
		 if(intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)){
		     //here we start the service             
		     Intent serviceIntent = new Intent(context, StartServiceOnBoot.class);
		     serviceIntent.putExtra("todo", "");
		     context.startService(serviceIntent);
		 }
     }
}