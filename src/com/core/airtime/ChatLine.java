		package com.core.airtime;

public class ChatLine {
	private String date,
				   name,
				   message,
				   isuser;

	public ChatLine(String date, String name, String message, String isuser){
		this.date = date;
		this.name = name;
		this.message = message;
		this.isuser = isuser;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getIsUser(){
		return isuser;
	}
}
