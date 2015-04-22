		package com.core.airtime;

public class AirTimeHistory {
	private String iD,
				   email,
				   phonenumber,
				   network,
				   amount,
				   datetime,
				   networkindex,
				   transactionid,
				   countryindex,
				   country,
				   transactionstatus,
				   chosenamountindex,
				   currency,
				   topupstatus,
				   servertime,
				   gatewayid,
				   amountcharged,
				   payurl;

	public AirTimeHistory(){
		iD = "";
		email = "";
		phonenumber = "";
		network = "";
		networkindex = "";
		amount = "";
		datetime = "";
		transactionid = "";
		transactionstatus = "";
		country = "";
		currency = "";
		countryindex = "";
		chosenamountindex = "";
		topupstatus = "";
		servertime = "";
		gatewayid = "";
		amountcharged = "";
		payurl = "";
	}
	
	public void setID(String value){
		iD = value;
	}
	public String getID(){
		return iD;
	}
	
	public void setGatewayID(String value){
		gatewayid = value;
	}
	public String getGatewayID(){
		return gatewayid;
	}
	
	public void setAmountCharged(String value){
		amountcharged = value;
	}
	public String getAmountCharged(){
		return amountcharged;
	}
	
	public void setPayUrl(String value){
		payurl = value;
	}
	public String getPayUrl(){
		return payurl;
	}
	
	public void setTopupStatus(String value){
		topupstatus = value;
	}
	public String getTopupStatus(){
		return topupstatus;
	}
	
	public void setServerTime(String value){
		servertime = value;
	}
	public String getServerTime(){
		return servertime;
	}
	
	public void setTransactionID(String value){
		transactionid = value;
	}
	public String getTransactionID(){
		return transactionid;
	}
	
	public void setTransactionStatus(String value){
		transactionstatus = value;
	}
	public String getTransactionStatus(){
		return transactionstatus;
	}
	
	public void setEmail(String value){
		email = value;
	}
	public String getEmail(){
		return email;
	}
	
	public void setCurrency(String value){
		currency = value;
	}
	public String getCurrency(){
		return currency;
	}
	
	public void setPhoneNumber(String value){
		phonenumber = value;
	}
	public String getPhoneNumber(){
		return phonenumber;
	}
	
	public void setNetwork(String value){
		network = value;
	}
	public String getNetwork(){
		return network;
	}
	
	public void setNetworkIndex(String value){
		networkindex = value;
	}
	public String getNetworkIndex(){
		return networkindex;
	}
	
	public void setChosenAmountIndex(String value){
		chosenamountindex = value;
	}
	public String getChosenAmountIndex(){
		return chosenamountindex;
	}
	
	public void setCountry(String value){
		country = value;
	}
	public String getCountry(){
		return country;
	}
	
	public void setCountryIndex(String value){
		countryindex = value;
	}
	public String getCountryIndex(){
		return countryindex;
	}
	
	public void setDateTime(String value){
		datetime = value;
	}
	public String getDateTime(){
		return datetime;
	}
	
	public void setAmount(String value){
		amount = value;
	}
	public String getAmount(){
		return amount;
	}
}
