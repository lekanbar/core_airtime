package com.core.airtime;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;

import org.xmlpull.v1.XmlPullParserException;

import com.core.airtime.SlideMenu.SlideMenuItem;
import com.core.airtime.SlideMenuInterface.OnSlideMenuItemClickListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class LiveChat extends Activity implements OnSlideMenuItemClickListener {
	
	// Debugging
    private static final String TAG = "LivePersonChat";
    private static final boolean D = true;

    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    
    private SlideMenu slidemenu;
    
    ArrayList<ChatLine> lines;
    // Array adapter for the conversation thread
    //private ArrayAdapter<String> mConversationArrayAdapter;
    ChatLineItemAdapter mConversationArrayAdapter;
    
    private ListView mConversationView;
    //private TextView txtMessage;
    // String buffer for outgoing messages
    private StringBuffer mOutStringBuffer;
    // LivePerson ChatActivity Service
    private LivePersonChatService mChatService;

    private String server = "dev.liveperson.net";//"server.iad.liveperson.net";//"lpwebdemo.liveperson.com";//
    private String siteID = "P72726170";//82122162
	
	//private DB db;
	SharedPreferences prefs;
	String language; int languageindex;
	ProgressDialog dialog;
	UserPreferences pref;
	static boolean isfirst = true;
	String transid = "", message = "";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Instantiate the database
    	DB db = new DB(this);
    	db.open();
    	pref = db.getPreference(1);
    	db.close();
        
    	setContentView(R.layout.livechat);
    	
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
    		else{
    			stopChat();
    			finish();
	    		return true;
    		}
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
		    case (Menu.FIRST + 3): {
		    	Intent i = new Intent(getApplicationContext(), Terms.class);
				startActivity(i);
				finish();
				break;
		    }
		    case (Menu.FIRST + 4): {
		    	Intent i = new Intent(getApplicationContext(), About.class);
				startActivity(i);
				finish();
				break;
		    }
		    case (Menu.FIRST + 5): {
		    	Intent i = new Intent(getApplicationContext(), Settings.class);
				startActivity(i);
				finish();
				break;
		    }
		    case (Menu.FIRST + 6) : {
				Intent i = new Intent(getApplicationContext(), History.class);
				startActivity(i);
				finish();
				break;
			}
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
	    super.onCreateOptionsMenu(menu);
	    // Create and add new menu items.
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
	
	public void InitializeUI(){
		setTitle(getString(R.string.liveLabel));
		
		//show on imgMenu
        ImageView imgMenu = (ImageView)findViewById(R.id.imgMenu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	slidemenu.show();
            }
        });
		
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
		
		SlideMenuItem item6 = new SlideMenuItem();
		item6.id = Menu.FIRST + 6; item6.icon = getResources().getDrawable(R.drawable.transhistory);
		item6.label = getString(R.string.viewHis);
		slidemenu.addMenuItem(item6);
		
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
		
		Button cmdOpen = (Button)findViewById(R.id.cmdOpen);
    	cmdOpen.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				EditText txtTransID = (EditText)findViewById(R.id.txtTransID);
				
				if(txtTransID.isEnabled()){
					dialog = ProgressDialog.show(LiveChat.this, getString(R.string.pingtitle), getString(R.string.ping), false);
					
					DB db = new DB(LiveChat.this);
			    	db.open();
			    	boolean isexisting = db.checkForTransID(transid);
			    	db.close();
			    	txtTransID.setEnabled(false);
					
					if(isexisting){
						EditText txtMessage = (EditText)findViewById(R.id.txtMessage);
						txtMessage.setEnabled(true);
						
						if (mChatService == null || mChatService.getState() != LivePersonChatService.STATE_IN_CHAT) {
			                startChat();
			            } else {
			                stopChat();
			            }
					}
					else{
						dialog.dismiss();
						
						AlertDialog.Builder alert = new AlertDialog.Builder(LiveChat.this);
						alert.setTitle(R.string.errorTitle);
						alert.setMessage(R.string.transExist);
						alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
			
							public void onClick(DialogInterface arg0, int arg1) {
								
							}
						});
						alert.show();
					}
				}
			}
    	});
    	
    	Button cmdSend = (Button)findViewById(R.id.cmdSend);
    	cmdSend.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				EditText txtMessage = (EditText)findViewById(R.id.txtMessage);
				sendMessage(txtMessage.getText().toString());
			}
    	});
    	
    	EditText txtMessage = (EditText)findViewById(R.id.txtMessage);
    	txtMessage.addTextChangedListener(new TextWatcher(){
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
			
            @Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
            	EditText txtMessage = (EditText)findViewById(R.id.txtMessage);
            	message = txtMessage.getText().toString();
			}
        }); 
    	if(!message.equals(""))
    		txtMessage.setText(message);
    	
    	EditText txtTransID = (EditText)findViewById(R.id.txtTransID);
    	txtTransID.addTextChangedListener(new TextWatcher(){
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
			
            @Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
            	EditText txtTransID = (EditText)findViewById(R.id.txtTransID);
            	transid = txtTransID.getText().toString();
			}
        }); 
    	if(!transid.equals(""))
    		txtTransID.setText(transid);
    }
	
	private void startChat() {
        // Initialize the array adapter for the conversation thread
		mConversationArrayAdapter = new ChatLineItemAdapter(this, R.layout.list_item2, new ArrayList<ChatLine>());
        mConversationView = (ListView) findViewById(R.id.in);
        mConversationView.setAdapter(mConversationArrayAdapter);

        mChatService = new LivePersonChatService(this, mHandler);
        mOutStringBuffer = new StringBuffer("");
        try {
            mChatService.initSession(server, siteID);
            mChatService.startChat();
            
            EditText txtTransID = (EditText)findViewById(R.id.txtTransID);
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(txtTransID.getWindowToken(), 0);
        } catch (IOException e) {
            if (D)
                Log.e(TAG, "Couldn't initiate chat", e);
            
            notInSession(getString(R.string.initchat));
        } catch (ChatApiException e) {
            if (D)
                Log.e(TAG, "Couldn't initiate chat", e);
            
            notInSession(getString(R.string.initchat));
        }
        catch (URISyntaxException e) {
            if (D)
                Log.e(TAG, "Couldn't initiate chat", e);
            
            notInSession(getString(R.string.initchat));
        } catch (IllegalStateException e) {
            if (D)
                Log.e(TAG, "Couldn't initiate chat", e);
            
            notInSession(getString(R.string.initchat));
        } catch (XmlPullParserException e) {
            if (D)
                Log.e(TAG, "Couldn't initiate chat", e);
            
            notInSession(getString(R.string.initchat));
        }
        finally{
        	dialog.dismiss();
        }
    }
	
	/**
     * Sends a message.
     * 
     * @param message
     *            A string of text to send.
     */
    private void sendMessage(String message) {
        // Check that we're actually connected before trying anything
        if (mChatService.getState() != LivePersonChatService.STATE_IN_CHAT) {
            notInSession(getString(R.string.chatoff));
            return;
        }

        // Check that there's actually something to send
        if (message.length() > 0) {
            try {
                mChatService.sendMessage(message);
                // Reset out string buffer to zero and clear the edit text field
                mOutStringBuffer.setLength(0);
                
                TextView txtMessage = (TextView)findViewById(R.id.txtMessage);
                txtMessage.setText("");
                
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(txtMessage.getWindowToken(), 0);
            } catch (IllegalStateException e) {
                if (D)
                    Log.e(TAG, "Couldn't send message", e);
                
                notInSession(getString(R.string.chatmsgnah));                
            } catch (IOException e) {
                if (D)
                    Log.e(TAG, "Couldn't send message", e);
                
                notInSession(getString(R.string.chatmsgnah));
            } catch (ChatApiException e) {
                if (D)
                    Log.e(TAG, "Couldn't send message", e);
                
                notInSession(getString(R.string.chatmsgnah));
            } catch (URISyntaxException e) {
                if (D)
                    Log.e(TAG, "Couldn't send message", e);
                
                notInSession(getString(R.string.chatmsgnah));
            } catch (XmlPullParserException e) {
                if (D)
                    Log.e(TAG, "Couldn't send message", e);
                
                notInSession(getString(R.string.chatmsgnah));
            }
        }
    }
	
	// The Handler that gets information from the LivePersonChatService
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
        	Calendar c = Calendar.getInstance();
        	String hour = (String.valueOf(c.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY))); 
	    	String minute = (String.valueOf(c.get(Calendar.MINUTE)).length() == 1 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE)));
			String datetime = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH + 1) + "/" +
					                         c.get(Calendar.YEAR) + " " + hour + ":" + 
					                         minute + (c.get(Calendar.AM_PM) == 0 ? " AM" : " PM"));
			ChatLine cl;
			
            switch (msg.what) {
	            case MESSAGE_STATE_CHANGE:
	                // figure out if in a chat or not in a chat
	                break;
	            case MESSAGE_WRITE:
	                String sentMessage = (String) msg.obj;
	                cl = new ChatLine(datetime, pref.getEmail(), sentMessage, "true");
	                mConversationArrayAdapter.add(cl);
	                break;
	            case MESSAGE_READ:
	                ChatLineEvent readMessage = (ChatLineEvent) msg.obj;
	                if (!readMessage.senderName.equalsIgnoreCase("You")) {
	                	cl = new ChatLine(datetime, readMessage.senderName, readMessage.content, "false");
	 	                mConversationArrayAdapter.add(cl);
	 	                
	 	                if(readMessage.content.startsWith("Chat session has been terminated")){
	 	            	    TextView txtTransID = (TextView)findViewById(R.id.txtTransID);
	 	            	    txtTransID.setEnabled(true);
		 	 				
	 	            	    TextView txtMessage = (TextView)findViewById(R.id.txtMessage);
	 	            	    txtMessage.setText("");
	 	            	    txtMessage.setEnabled(false);
		 	 				
	 	            	    mChatService = null;
	 	                }
	                }
	                break;
            }
        }
    };
    
    private void notInSession(String msg){
    	AlertDialog.Builder alert = new AlertDialog.Builder(LiveChat.this);
		alert.setTitle(R.string.livechat);
		alert.setMessage(msg);
		alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){

			public void onClick(DialogInterface arg0, int arg1) {
				TextView txtTransID = (TextView)findViewById(R.id.txtTransID);
		    	txtTransID.setEnabled(true);
				
				TextView txtMessage = (TextView)findViewById(R.id.txtMessage);
				txtMessage.setText("");
				txtMessage.setEnabled(false);
				
				mChatService = null;
			}
		});
		alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener(){

			public void onClick(DialogInterface arg0, int arg1) {
				TextView txtTransID = (TextView)findViewById(R.id.txtTransID);
		    	txtTransID.setEnabled(true);
				
				TextView txtMessage = (TextView)findViewById(R.id.txtMessage);
				txtMessage.setText("");
				txtMessage.setEnabled(false);
				
				mChatService = null;
			}
		});
		alert.show();
    }
	
	private void stopChat() {
        try {
        	dialog.dismiss();
            mChatService.stop();
        } catch (URISyntaxException e) {
        	e.printStackTrace();
        }
    }
	
	public void onConfigurationChanged(Configuration _newConfig) {
    	super.onConfigurationChanged(_newConfig);
    	
    	//setLanguage();
		setContentView(R.layout.livechat);
		InitializeUI();
    }
	
	@Override
    public void onDestroy() {
    	//db.close();
    	
    	if (mChatService != null)
            try {
                mChatService.stop();
            } catch (URISyntaxException e) {
                if (D)
                    Log.e(TAG, "Problem destroying chat service");
            }
    	
    	super.onDestroy();
    }
}
