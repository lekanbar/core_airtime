package com.core.airtime;

public class Country {
	private String iD,//You can Ignore this
				   countryId,//The country Id
	   			   name,
	   			   intlcallingcode, //International Calling Code
	   			   currency;//This is country's currency e.g. NGN, USD, DZD;//Country name
	
	public Country(){
	   iD = "";
	   countryId = "";
	   name = "";
	   intlcallingcode = "";
	   currency = "";
	}
	
	public Country(String  countryid, String cname){
	   iD = "";
	   countryId = countryid;
	   name = cname;
	}

	public void setID(String value){
		iD = value;
	}
	public String getID(){
		return iD;
	}
	
	public void setIntlCallingCode(String value){
		intlcallingcode = value;
	}
	public String getIntlCallingCode(){
		return intlcallingcode;
	}
	
	public void setCurrency(String value){
		currency = value;
	}
	public String getCurrency(){
		return currency;
	}
	
	public void setCountryID(String value){
		countryId = value;
	}
	public String getCountryID(){
		return countryId;
	}
	
	public void setName(String value){
		name = value;
	}
	public String getName(){
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}
