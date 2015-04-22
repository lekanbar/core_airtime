package com.core.airtime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.AsyncTask;

public class API_Interact extends AsyncTask<String, Integer, Drawable>
{
	int todo, classType;
	private Drawable d;
    ArrayList<String> values = null;
    Context context;
    List<NameValuePair> params;
    
    String responseBody, extra;
    
    final int TIMEOUT_MILLISEC = 10000;
    
    public static final int TODO_AUTH = 0;
    public static final int TODO_TOPUP = 1;
    public static final int TODO_UPDATE_COEFF = 2;
    public static final int TODO_TRANSACTION_STATUS = 3;
    public static final int TODO_GET_AUTHTOKEN = 4;
    public static final int TODO_UNINSTALL = 5;
    public static final int TODO_GET_CURRENCIES = 6;
    public static final int TODO_GET_GATEWAYS = 7;
    public static final int TODO_GET_PRODUCTS = 8;
    public static final int TODO_GET_OPERATORS = 9;
    public static final int TODO_GET_READY_GATEWAYS = 10;
    public static final int TODO_CHECK_COUNTRY = 11;
    public static final int TODO_CORE_MERCHANT = 12;
    
    //Class Types for determining context callback function 
    public static final int CLASSTYPE1 = 1;//For discount code class
    public static final int CLASSTYPE2 = 2;//For service boot
    public static final int CLASSTYPE3 = 3;//For pay info
    public static final int CLASSTYPE4 = 4;//For core main activity
    public static final int CLASSTYPE5 = 5;//For after splash
    public static final int CLASSTYPE6 = 6;//For core main activity
    public static final int CLASSTYPE7 = 7;//For trans report
    public static final int CLASSTYPE8 = 8;//For history item
    
    final String BASE_URL = "https://quickairtime.com/webservices/api.php";
	
	public API_Interact(int todo, int classType, List<NameValuePair> params, Context context){
		this.params = params;
		this.context = context;
		this.todo = todo;
		this.classType = classType;
		d = null;
	}
	
	public API_Interact(int todo, int classType, List<NameValuePair> params, Context context, String extra){
		this.params = params;
		this.context = context;
		this.todo = todo;
		this.classType = classType;
		this.extra = extra;
		d = null;
	}

    public boolean isOnline() {
        try {
            ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    protected Drawable doInBackground(String... args) {
        try {
            if (isOnline()) {
    	        HttpParams httpParams = new BasicHttpParams();
    	        HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
    	        HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);

    	        // Instantiate an HttpClient
    	        HttpClient httpclient = new DefaultHttpClient();
    	        HttpPost httppost = new HttpPost(BASE_URL);
    	        httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");

    	        // Instantiate a HTTP POST method
	        	//Get response
	            httppost.setEntity(new UrlEncodedFormEntity(params));
	            ResponseHandler<String> responseHandler = new BasicResponseHandler();
	            responseBody = httpclient.execute(httppost, responseHandler);
            }// end of if isOnline
            else {
            	responseBody = "";
                return null;
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e)
        {        
        	responseBody = "";
            e.printStackTrace();
            return null;
        }// end of catch
        
        d = null;
        return d;
 	}

    @Override
    protected void onPostExecute(Drawable result){
    	JSONObject json = null;
    	String doneIsh = "";
    	
    	try {
    		if(!responseBody.equals("") || responseBody != null){
				json = new JSONObject(responseBody);
				
				if(todo == TODO_AUTH){
					if(json.getString("STATUS").equals("000")){
						DB db = new DB(context);
		    			db.open();
		    			UserPreferences pref = db.getPreference(1);
		    			pref.setAuthToken(json.getString("MESSAGE"));
			    		db.updatePreferences(1, pref);
			    		db.close();  		
			    		
			    		doneIsh = "good";
					}
		    	}
				else if(todo == TODO_TOPUP){
					if(json.getString("STATUS").equals("000")){
						((PayInfo)context).CallInAppBrowser(json.getString("MESSAGE"));  		
			    		
			    		doneIsh = "good";
					}
					else{
						((PayInfo)context).CallInAppBrowser("");
					}
		    	}
		    	else if(todo == TODO_UPDATE_COEFF){
		    		if(json.getString("STATUS").equals("000")){
			    		JSONArray operators = json.getJSONArray("MESSAGE");
			    		
			    		for (int i = 0; i < operators.length(); i++) {
			    			JSONObject operator = operators.getJSONObject(i);
			    			GatewayNetwork gnetwork = new GatewayNetwork();
			    			gnetwork.setNetworkID(operator.getString("OPERATOR_ID"));
			    			gnetwork.setGatewayID(operator.getString("PAYMENT_GATEWAY_ID"));
			    			gnetwork = gnetwork.getGatewayNetwork(context);
			    			
			    			if(gnetwork != null){
				    			gnetwork.setLocalCoeffValue(operator.getString("LOCAL_COEFFICIENT"));
				    			gnetwork.setUSDCoeffValue(operator.getString("USD_COEFFICIENT"));
				    			
				    			//update the network
				    			gnetwork.updateGatewayNetwork(context);
			    			}
			    			else{
			    				gnetwork = new GatewayNetwork();
			    				gnetwork.setNetworkID(operator.getString("OPERATOR_ID"));
				    			gnetwork.setGatewayID(operator.getString("PAYMENT_GATEWAY_ID"));
				    			gnetwork.setLocalCoeffValue(operator.getString("LOCAL_COEFFICIENT"));
				    			gnetwork.setUSDCoeffValue(operator.getString("USD_COEFFICIENT"));
				    			gnetwork.setCountryID(operator.getString("COUNTRY_ID"));
				    			
				    			gnetwork.insertGatewayNetwork(context);
			    			}
			    		}  		
			    		
			    		doneIsh = "good";
			    	}
		    	}
		        else if(todo == TODO_TRANSACTION_STATUS){
		        	if(json.getString("STATUS").equals("000")){
		        		JSONArray arr = json.getJSONArray("MESSAGE");
		        		JSONObject ret = arr.getJSONObject(0);
		        		
		        		DB db = new DB(context);
		            	db.open();
		            	AirTimeHistory hist = db.getHistory(ret.getString("TRANSACTION_ID"));
		            	hist.setTransactionStatus(ret.getString("PAYMENT_STATUS"));
		            	hist.setTopupStatus(ret.getString("TOPUP_STATUS"));
		            	hist.setServerTime(ret.getString("TRANSACTION_TIME"));
		            	db.updateHistory(Long.parseLong(hist.getID()), hist);
		        		db.close();	        		
		        		
		        		if(classType == CLASSTYPE7)
		        			((TransactionReport)context).done("success");
		        		else
		        			((HistoryItem)context).done("success");
					}
					else{
						if(classType == CLASSTYPE7)
		        			((TransactionReport)context).done("");
		        		else
		        			((HistoryItem)context).done("");
					}
		    	}
		        else if(todo == TODO_CORE_MERCHANT){
		        	if(json.getString("STATUS").equals("000")){
		        		((CoreMerchant)context).done("Successful");//json.getString("MESSAGE"));  		
			    		
			    		doneIsh = "good";
					}
					else{
						((CoreMerchant)context).done("");
					}
		    	}
			    else if(todo == TODO_UNINSTALL){
			    	
			    }
			    else if(todo == TODO_GET_CURRENCIES){
			    	if(json.getString("STATUS").equals("000")){
			    		JSONArray operators = json.getJSONArray("MESSAGE");
			    		
			    		for (int i = 0; i < operators.length(); i++) {
			    			JSONObject operator = operators.getJSONObject(i);
			    			Currency currency = new Currency(context);
			    			//currency.setCurrencyId(operator.getString("ID"));
			    			currency = currency.getCurrency(operator.getString("COUNTRY"));
			    			
			    			if(currency != null){
			    				currency.setCurrencycode(operator.getString("CURRENCY_VALUE"));
			    				currency.setNairaexrate(operator.getString("NAIRA_EXCHANGE_RATE"));
			    				currency.setUsdexrate(operator.getString("USD_EXCHANGE_RATE"));
				    			
				    			//update the network
			    				currency.updateCurrency(context);
			    			}
			    			else{
			    				currency = new Currency(context);
			    				currency.setCurrencycode(operator.getString("CURRENCY_VALUE"));
			    				currency.setCurrencyId(operator.getString("ID"));
				    			currency.setNairaexrate(operator.getString("NAIRA_EXCHANGE_RATE"));
			    				currency.setUsdexrate(operator.getString("USD_EXCHANGE_RATE"));
			    				currency.setCountryName(operator.getString("COUNTRY"));
				    			
			    				currency.insertCurrency();
			    			}
			    		}  		
			    		
			    		doneIsh = "good";
			    	}
			    }
			    else if(todo == TODO_GET_GATEWAYS){
			    	if(json.getString("STATUS").equals("000")){
			    		JSONArray gateways = json.getJSONArray("MESSAGE");
			    		
			    		for (int i = 0; i < gateways.length(); i++) {
			    			JSONObject gateway = gateways.getJSONObject(i);
			    			Gateway gate = new Gateway(context);
				    		gate = gate.getGateway(gateway.getString("ID"));
				    		
				    		if(gate == null){
				    			gate = new Gateway(context);
				    			gate.setGatewayID(gateway.getString("ID"));
				    			gate.setGatewayName(gateway.getString("PAYMENT_GATEWAY"));
				    			gate.setCurrency(gateway.getString("GATEWAY_CURRENCY"));
				    			gate.setIsGatewayReady("false");
				    			
				    			gate.insertGateway();
				    		}
			    		}
			    		
			    		//Create quick airtime gateway
			    		Gateway gate = new Gateway(context);
			    		gate = gate.getGateway("core");
			    		if(gate == null){
			    			gate = new Gateway(context);
			    			gate.setGatewayID("core");
			    			gate.setGatewayName("Quick Airtime Merchants");
			    			gate.setCurrency("NGN");
			    			gate.setIsGatewayReady("true");
			    			
			    			gate.insertGateway();
			    		}  		
			    		
			    		doneIsh = "good";
			    	}
			    }
			    else if(todo == TODO_GET_READY_GATEWAYS){
			    	if(json.getString("STATUS").equals("000")){
			    		JSONArray gateways = json.getJSONArray("MESSAGE");
			    		
			    		for (int i = 0; i < gateways.length(); i++) {
			    			JSONObject gateway = gateways.getJSONObject(i);
			    			Gateway gate = new Gateway(context);
				    		gate = gate.getGateway(gateway.getString("ID"));
				    		
				    		if(gate == null){
				    			gate = new Gateway(context);
				    			gate.setGatewayID(gateway.getString("ID"));
				    			gate.setGatewayName(gateway.getString("PAYMENT_GATEWAY"));
				    			gate.setCurrency(gateway.getString("GATEWAY_CURRENCY"));
				    			gate.setIsGatewayReady("true");
				    			
				    			gate.insertGateway();
				    		}
				    		else{
				    			if(gate.getIsGatewayReady().equals("false")){
				    				gate.setCurrency(gateway.getString("GATEWAY_CURRENCY"));
					    			gate.setIsGatewayReady("true");
					    			gate.updateGateway(Long.parseLong(gate.getID()), context);
				    			}
				    		}
			    		}  		
			    		
			    		doneIsh = "good";
			    	}
			    }
			    else if(todo == TODO_GET_PRODUCTS){
			    	if(json.getString("STATUS").equals("000")){
			    		JSONArray operators = json.getJSONArray("MESSAGE");
			    		
			    		for (int i = 0; i < operators.length(); i++) {
			    			JSONObject operator = operators.getJSONObject(i);
			    			Network network = new Network();
			    			network.setNetworkID(operator.getString("OPERATOR_ID"));
			    			network = network.getNetwork(context);
			    			
			    			if(network != null){
				    			network.setProductID(operator.getString("PRODUCT_ID"));
				    			network.setMin(!operator.has("LOCAL_LOWER_BOUND") ? "" : operator.getString("LOCAL_LOWER_BOUND"));
				    			network.setMax(!operator.has("LOCAL_UPPER_BOUND") ? "" : operator.getString("LOCAL_UPPER_BOUND"));
				    			network.setUSDMin(!operator.has("USD_LOWER_BOUND") ? "" : operator.getString("USD_LOWER_BOUND"));
				    			network.setUSDMax(!operator.has("USD_UPPER_BOUND") ? "" : operator.getString("USD_UPPER_BOUND"));
				    			
				    			if(operator.has("LOCAL_FACE_VALUE")){
				    				network.setIsFixed("false");
				    				
				    				NetworkFaceValue nfv = new NetworkFaceValue();
				    				nfv.setNetworkID(network.getNetworkID());
				    				nfv.setLocalValue(operator.getString("LOCAL_FACE_VALUE")); 
				    				nfv.setUSDValue(operator.getString("USD_FACE_VALUE"));
				    				nfv.insertNetworkFace(context);
				    			}
				    			else
				    				network.setIsFixed("true");
				    			
				    			//update the network
				    			network.updateNetwork(context);
			    			}
			    		}  		
			    		
			    		doneIsh = "good";
			    	}
			    }
			    else if(todo == TODO_GET_OPERATORS){
			    	if(json.getString("STATUS").equals("000")){
			    		JSONArray operators = json.getJSONArray("MESSAGE");
			    		
			    		for (int i = 0; i < operators.length(); i++) {
			    			JSONObject operator = operators.getJSONObject(i);
			    			Network network = new Network();
			    			network.setNetworkID(operator.getString("OPERATOR_ID"));
			    			network = network.getNetwork(context);
			    			
			    			if(network == null){
			    				network = new Network();
			    				network.setNetworkID(operator.getString("OPERATOR_ID"));
				    			network.setName(operator.getString("OPERATOR_NAME"));
				    			
				    			//Set country id
				    			Country count = CountryNetworkGateway.GetCountry(operator.getString("COUNTRY_NAME"), context);
				    			if(count != null)
				    				network.setCountryID(count.getCountryID());
				    			
				    			network.setProductID(""); network.setMin("");
				    			network.setMax(""); network.setUSDMin("");
				    			network.setUSDMax(""); network.setPhoneNumberLenght("");
				    			network.setIntlCallingCode(""); network.setCurrency("");
				    			network.setTopUpID(""); network.setIsUSDDenom("");
				    			network.setIsFixed("");
				    			network.insertNetwork(context);
			    			}
			    		}
			    	}  		
		    		
		    		doneIsh = "good";
			    }
    		}
    	} catch (JSONException e) {
			// TODO Auto-generated catch block
    		doneIsh = "";
			e.printStackTrace();
		}
    	catch (Exception e) {
			// TODO Auto-generated catch block
    		doneIsh = "";
			e.printStackTrace();
		}
    	finally{
    		//Alert caller of function exit
			if(classType == CLASSTYPE1)
    			((DiscountCode)context).done();
    		else if(classType == CLASSTYPE2)
    			((StartServiceOnBoot)context).done();
    		else if(classType == CLASSTYPE4)
    			((CoreAirTimeActivity)context).done(doneIsh);
    	}
    }
}
