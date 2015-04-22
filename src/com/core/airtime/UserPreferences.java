		package com.core.airtime;

public class UserPreferences {
	private String iD,
				   countryindex,
				   languageindex,
				   localusdindex,
				   isfirsttime,
				   email,
				   phonenumber,
				   amount,
				   chosenamount,
				   networkindex,
				   discountcode,
				   formattedamount,
				   formattedphone,
				   authtoken,
				   checkforupdate,
				   merchantemail,
				   merchantpassword;

	public UserPreferences(){
		iD = "";
		localusdindex = "";
		isfirsttime = "";
		countryindex = "";
		languageindex = "";
		networkindex = "";
		email = ""; 
		phonenumber = ""; 
		amount = "";
		chosenamount = "";
		discountcode = "";
		formattedamount = "";
		formattedphone = "";
		authtoken = "";
		checkforupdate = "";
		merchantemail = "";
		merchantpassword = "";
	}
	
	public void setID(String value){
		iD = value;
	}
	public String getID(){
		return iD;
	}
	
	public void setEmail(String value){
		email = value;
	}
	public String getEmail(){
		return email;
	}
	
	public void setMerchantEmail(String value){
		merchantemail = value;
	}
	public String getMerchantEmail(){
		return merchantemail;
	}
	
	public void setMerchantPassword(String value){
		merchantpassword = value;
	}
	public String getMerchantPassword(){
		return merchantpassword;
	}
	
	public void setCheckforUpdate(String value){
		checkforupdate = value;
	}
	public String getCheckforUpdate(){
		return checkforupdate;
	}
	
	public void setDiscountCode(String value){
		discountcode = value;
	}
	public String getDiscountCode(){
		return discountcode;
	}
	
	public void setAmount(String value){
		amount = value;
	}
	public String getAmount(){
		return amount;
	}
	
	public void setAuthToken(String value){
		authtoken = value;
	}
	public String getAuthToken(){
		return authtoken;
	}
	
	public void setChosenAmount(String value){
		chosenamount = value;
	}
	public String getChosenAmount(){
		return chosenamount;
	}
	
	public void setPhoneNumber(String value){
		phonenumber = value;
	}
	public String getPhoneNumber(){
		return phonenumber;
	}
	
	public void setLanguageIndex(String value){
		languageindex = value;
	}
	public String getLanguageIndex(){
		return languageindex;
	}
	
	public void setLocalUsdIndex(String value){
		localusdindex = value;
	}
	public String getLocalUsdIndex(){
		return localusdindex;
	}
	
	public void setIsFirstTime(String value){
		isfirsttime = value;
	}
	public String getIsFirstTime(){
		return isfirsttime;
	}
	
	public void setCountryIndex(String value){
		countryindex = value;
	}
	public String getCountryIndex(){
		return countryindex;
	}
	
	public void setNetworkIndex(String value){
		networkindex = value;
	}
	public String getNetworkIndex(){
		return networkindex;
	}
	
	public void setFormattedPhoneNumber(String value){
		formattedphone = value;
	}
	public String getFormattedPhoneNumber(){
		return formattedphone;
	}
	
	public void setFormattedAmount(String value){
		formattedamount = value;
	}
	public String getFormattedAmount(){
		return formattedamount;
	}
}
