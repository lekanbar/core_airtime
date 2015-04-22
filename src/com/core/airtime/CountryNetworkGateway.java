package com.core.airtime;

import java.util.ArrayList;

import android.content.Context;

public class CountryNetworkGateway{
	
	private static ArrayList<Country> countries;
	//private static ArrayList<Network> networks;
	//private static ArrayList<Gateway> gateways;
	
	//private static SQLiteDatabase db;

	//For Getting countries this returns a list of Country objects
	public static ArrayList<Country> GetCountries(Context context){
		
		countries = new ArrayList<Country>();
		Country country = new Country();
		country.setCountryID("000");
		country.setName(context.getString(R.string.selectCountry));
		countries.add(country);
		
		country = new Country();
		country.setID("1");
		country.setCountryID("001");
		country.setName("Afghanistan");
		country.setIntlCallingCode("93");
		country.setCurrency("AFN");
		countries.add(country);
		
		country = new Country();
		country.setID("4");
		country.setCountryID("002");
		country.setName("Algeria");
		country.setIntlCallingCode("213");
		country.setCurrency("DZD");
		countries.add(country);
		
		country = new Country();
		country.setID("8");
		country.setCountryID("003");
		country.setName("Anguilla");
		country.setIntlCallingCode("1264");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("10");
		country.setCountryID("004");
		country.setName("Antigua and Barbuda");
		country.setIntlCallingCode("1268");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("11");
		country.setCountryID("115");
		country.setName("Argentina");
		country.setIntlCallingCode("54");
		country.setCurrency("ARS");
		countries.add(country);
		
		country = new Country();
		country.setID("12");
		country.setCountryID("005");
		country.setName("Armenia");
		country.setIntlCallingCode("7");
		country.setCurrency("RUB");
		countries.add(country);
		
		country = new Country();
		country.setID("13");
		country.setCountryID("006");
		country.setName("Aruba");
		country.setIntlCallingCode("1268");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("20");
		country.setCountryID("007");
		country.setName("Bangladesh");
		country.setIntlCallingCode("880");
		country.setCurrency("BDT");
		countries.add(country);
		
		country = new Country();
		country.setID("21");
		country.setCountryID("008");
		country.setName("Barbados");
		country.setIntlCallingCode("1246");
		country.setCurrency("BBD");
		countries.add(country);
		
		country = new Country();
		country.setID("25");
		country.setCountryID("009");
		country.setName("Belize");
		country.setIntlCallingCode("501");
		country.setCurrency("BZD");
		countries.add(country);
		
		country = new Country();
		country.setID("26");
		country.setCountryID("010");
		country.setName("Benin");
		country.setIntlCallingCode("229");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("27");
		country.setCountryID("011");
		country.setName("Bermuda");
		country.setIntlCallingCode("1441");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("29");
		country.setCountryID("012");
		country.setName("Bolivia");
		country.setIntlCallingCode("591");
		country.setCurrency("BOB");
		countries.add(country);
		
		country = new Country();
		country.setID("");
		country.setCountryID("013");
		country.setName("Bonaire");
		country.setIntlCallingCode("599");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("33");
		country.setCountryID("014");
		country.setName("Brazil");
		country.setIntlCallingCode("55");
		country.setCurrency("BRL");
		countries.add(country);
		
		country = new Country();
		country.setID("35");
		country.setCountryID("015");
		country.setName("British Virgin Islands");
		country.setIntlCallingCode("1284");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("40");
		country.setCountryID("016");
		country.setName("Burundi");
		country.setIntlCallingCode("257");
		country.setCurrency("BIF");
		countries.add(country);
		
		country = new Country();
		country.setID("41");
		country.setCountryID("017");
		country.setName("Cambodia");
		country.setIntlCallingCode("855");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("42");
		country.setCountryID("018");
		country.setName("Cameroon");
		country.setIntlCallingCode("237");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("45");
		country.setCountryID("019");
		country.setName("Cayman Islands");
		country.setIntlCallingCode("257");
		country.setCurrency("KYD");
		countries.add(country);
		
		country = new Country();
		country.setID("46");
		country.setCountryID("020");
		country.setName("Central African  Republic");
		country.setIntlCallingCode("236");
		country.setCurrency("XAF");
		countries.add(country);
		
		country = new Country();
		country.setID("48");
		country.setCountryID("021");
		country.setName("Chile");
		country.setIntlCallingCode("56");
		country.setCurrency("CLP");
		countries.add(country);
		
		country = new Country();
		country.setID("49");
		country.setCountryID("022");
		country.setName("China");
		country.setIntlCallingCode("86");
		country.setCurrency("CNY");
		countries.add(country);
		
		country = new Country();
		country.setID("53");
		country.setCountryID("023");
		country.setName("Colombia");
		country.setIntlCallingCode("57");
		country.setCurrency("COP");
		countries.add(country);
		
		country = new Country();
		country.setID("56");
		country.setCountryID("024");
		country.setName("Congo, Republic Of");
		country.setIntlCallingCode("242");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("59");
		country.setCountryID("025");
		country.setName("Costarica");
		country.setIntlCallingCode("506");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("62");
		country.setCountryID("026");
		country.setName("Cuba");
		country.setIntlCallingCode("53");
		country.setCurrency("CUC");
		countries.add(country);
		
		country = new Country();
		country.setID("");
		country.setCountryID("027");
		country.setName("Curacao");
		country.setIntlCallingCode("599");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("63");
		country.setCountryID("028");
		country.setName("Cyprus");
		country.setIntlCallingCode("357");
		country.setCurrency("EUR");
		countries.add(country);
		
		country = new Country();
		country.setID("55");
		country.setCountryID("029");
		country.setName("Democratic Republic of Congo");
		country.setIntlCallingCode("243");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("68");
		country.setCountryID("030");
		country.setName("Dominlca");
		country.setIntlCallingCode("1767");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("69");
		country.setCountryID("031");
		country.setName("Dominican Republic");
		country.setIntlCallingCode("1809");
		country.setCurrency("DOP");
		countries.add(country);
		
		country = new Country();
		country.setID("70");
		country.setCountryID("032");
		country.setName("Ecuador");
		country.setIntlCallingCode("593");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("71");
		country.setCountryID("033");
		country.setName("Egypt");
		country.setIntlCallingCode("20");
		country.setCurrency("EGP");
		countries.add(country);
		
		country = new Country();
		country.setID("72");
		country.setCountryID("034");
		country.setName("El Salvador");
		country.setIntlCallingCode("503");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("73");
		country.setCountryID("035");
		country.setName("Equitorial Guinea");
		country.setIntlCallingCode("240");
		country.setCurrency("XAF");
		countries.add(country);
		
		country = new Country();
		country.setID("80");
		country.setCountryID("036");
		country.setName("Fiji");
		country.setIntlCallingCode("679");
		country.setCurrency("FJD");
		countries.add(country);
		
		country = new Country();
		country.setID("83");
		country.setCountryID("037");
		country.setName("French Guinea");
		country.setIntlCallingCode("594");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("86");
		country.setCountryID("038");
		country.setName("Gabon");
		country.setIntlCallingCode("241");
		country.setCurrency("XAF");
		countries.add(country);
		
		country = new Country();
		country.setID("87");
		country.setCountryID("039");
		country.setName("Gambia");
		country.setIntlCallingCode("220");
		country.setCurrency("GMD");
		countries.add(country);
		
		country = new Country();
		country.setID("89");
		country.setCountryID("040");
		country.setName("Georgia");
		country.setIntlCallingCode("995");
		country.setCurrency("EUR");
		countries.add(country);
		
		country = new Country();
		country.setID("91");
		country.setCountryID("041");
		country.setName("Ghana");
		country.setIntlCallingCode("233");
		country.setCurrency("GHS");
		countries.add(country);
		
		country = new Country();
		country.setID("96");
		country.setCountryID("042");
		country.setName("Grenada");
		country.setIntlCallingCode("1473");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("97");
		country.setCountryID("043");
		country.setName("Guadelope");
		country.setIntlCallingCode("590");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("99");
		country.setCountryID("044");
		country.setName("Guatemala");
		country.setIntlCallingCode("502");
		country.setCurrency("GTQ");
		countries.add(country);
		
		country = new Country();
		country.setID("101");
		country.setCountryID("045");
		country.setName("Guinea");
		country.setIntlCallingCode("224");
		country.setCurrency("GNF");
		countries.add(country);
		
		country = new Country();
		country.setID("102");
		country.setCountryID("046");
		country.setName("Guinea Bissau");
		country.setIntlCallingCode("245");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("103");
		country.setCountryID("047");
		country.setName("Guyana");
		country.setIntlCallingCode("592");
		country.setCurrency("GYD");
		countries.add(country);
		
		country = new Country();
		country.setID("104");
		country.setCountryID("048");
		country.setName("Haiti");
		country.setIntlCallingCode("509");
		country.setCurrency("HTG");
		countries.add(country);
		
		country = new Country();
		country.setID("107");
		country.setCountryID("049");
		country.setName("Honduras");
		country.setIntlCallingCode("504");
		country.setCurrency("HNL");
		countries.add(country);
		
		country = new Country();
		country.setID("111");
		country.setCountryID("050");
		country.setName("India");
		country.setIntlCallingCode("91");
		country.setCurrency("INR");
		countries.add(country);
		
		country = new Country();
		country.setID("112");
		country.setCountryID("051");
		country.setName("Indonesia");
		country.setIntlCallingCode("62");
		country.setCurrency("IDR");
		countries.add(country);
		
		country = new Country();
		country.setID("114");
		country.setCountryID("052");
		country.setName("Iraq");
		country.setIntlCallingCode("964");
		country.setCurrency("IQD");
		countries.add(country);
		
		country = new Country();
		country.setID("115");
		country.setCountryID("053");
		country.setName("Ireland");
		country.setIntlCallingCode("353");
		country.setCurrency("EUR");
		countries.add(country);
		
		country = new Country();
		country.setID("60");
		country.setCountryID("054");
		country.setName("Ivory Coast");
		country.setIntlCallingCode("225");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("119");
		country.setCountryID("055");
		country.setName("Jamaica");
		country.setIntlCallingCode("1876");
		country.setCurrency("JMD");
		countries.add(country);
		
		country = new Country();
		country.setID("123");
		country.setCountryID("056");
		country.setName("Jordan");
		country.setIntlCallingCode("962");
		country.setCurrency("JOD");
		countries.add(country);
		
		country = new Country();
		country.setID("125");
		country.setCountryID("057");
		country.setName("Kazakhstan");
		country.setIntlCallingCode("7");
		country.setCurrency("KZT");
		countries.add(country);
		
		country = new Country();
		country.setID("126");
		country.setCountryID("058");
		country.setName("Kenya");
		country.setIntlCallingCode("254");
		country.setCurrency("KES");
		countries.add(country);
		
		country = new Country();
		country.setID("132");
		country.setCountryID("059");
		country.setName("Laos");
		country.setIntlCallingCode("856");
		country.setCurrency("LAK");
		countries.add(country);
		
		country = new Country();
		country.setID("136");
		country.setCountryID("060");
		country.setName("Liberia");
		country.setIntlCallingCode("231");
		country.setCurrency("LRD");
		countries.add(country);
		
		country = new Country();
		country.setID("139");
		country.setCountryID("061");
		country.setName("Lithuania");
		country.setIntlCallingCode("370");
		country.setCurrency("LTL");
		countries.add(country);
		
		country = new Country();
		country.setID("143");
		country.setCountryID("062");
		country.setName("Madagascar");
		country.setIntlCallingCode("261");
		country.setCurrency("MGA");
		countries.add(country);
		
		country = new Country();
		country.setID("145");
		country.setCountryID("063");
		country.setName("Malaysia");
		country.setIntlCallingCode("60");
		country.setCurrency("MYR");
		countries.add(country);
		
		country = new Country();
		country.setID("147");
		country.setCountryID("064");
		country.setName("Mali");
		country.setIntlCallingCode("223");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("154");
		country.setCountryID("065");
		country.setName("Mexico");
		country.setIntlCallingCode("52");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("156");
		country.setCountryID("066");
		country.setName("Moldova");
		country.setIntlCallingCode("373");
		country.setCurrency("MDL");
		countries.add(country);
		
		country = new Country();
		country.setID("159");
		country.setCountryID("067");
		country.setName("Montserrat");
		country.setIntlCallingCode("1664");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("160");
		country.setCountryID("068");
		country.setName("Morocco");
		country.setIntlCallingCode("212");
		country.setCurrency("MAD");
		countries.add(country);
		
		country = new Country();
		country.setID("163");
		country.setCountryID("069");
		country.setName("Nauru");
		country.setIntlCallingCode("674");
		country.setCurrency("AUD");
		countries.add(country);
		
		country = new Country();
		country.setID("165");
		country.setCountryID("070");
		country.setName("Nepal");
		country.setIntlCallingCode("977");
		country.setCurrency("NPR");
		countries.add(country);
		
		country = new Country();
		country.setID("170");
		country.setCountryID("071");
		country.setName("Nicaragua");
		country.setIntlCallingCode("505");
		country.setCurrency("NIO");
		countries.add(country);
		
		country = new Country();
		country.setID("171");
		country.setCountryID("072");
		country.setName("Niger");
		country.setIntlCallingCode("2279");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("172");
		country.setCountryID("073");
		country.setName("Nigeria");
		country.setIntlCallingCode("234");
		country.setCurrency("NGN");
		countries.add(country);
		
		country = new Country();
		country.setID("178");
		country.setCountryID("074");
		country.setName("Pakistan");
		country.setIntlCallingCode("92");
		country.setCurrency("PKR");
		countries.add(country);
		
		country = new Country();
		country.setID("");
		country.setCountryID("075");
		country.setName("Palestine");
		country.setIntlCallingCode("970");
		country.setCurrency("ILS");
		countries.add(country);
		
		country = new Country();
		country.setID("180");
		country.setCountryID("076");
		country.setName("Panama");
		country.setIntlCallingCode("507");
		country.setCurrency("PAB");
		countries.add(country);
		
		country = new Country();
		country.setID("181");
		country.setCountryID("077");
		country.setName("Papua New Guinea");
		country.setIntlCallingCode("675");
		country.setCurrency("PGK");
		countries.add(country);
		
		country = new Country();
		country.setID("183");
		country.setCountryID("078");
		country.setName("Paraguay");
		country.setIntlCallingCode("595");
		country.setCurrency("PYG");
		countries.add(country);
		
		country = new Country();
		country.setID("184");
		country.setCountryID("079");
		country.setName("Peru");
		country.setIntlCallingCode("51");
		country.setCurrency("PEN");
		countries.add(country);
		
		country = new Country();
		country.setID("185");
		country.setCountryID("080");
		country.setName("Philippines");
		country.setIntlCallingCode("63");
		country.setCurrency("PHP");
		countries.add(country);
		
		country = new Country();
		country.setID("187");
		country.setCountryID("081");
		country.setName("Poland");
		country.setIntlCallingCode("48");
		country.setCurrency("PLN");
		countries.add(country);
		
		country = new Country();
		country.setID("244");
		country.setCountryID("082");
		country.setName("Puerto Rico");
		country.setIntlCallingCode("1");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("192");
		country.setCountryID("083");
		country.setName("Romania");
		country.setIntlCallingCode("40");
		country.setCurrency("EUR");
		countries.add(country);
		
		country = new Country();
		country.setID("193");
		country.setCountryID("084");
		country.setName("Russia");
		country.setIntlCallingCode("7");
		country.setCurrency("RUB");
		countries.add(country);
		
		country = new Country();
		country.setID("194");
		country.setCountryID("085");
		country.setName("Rwanda");
		country.setIntlCallingCode("250");
		country.setCurrency("RWF");
		countries.add(country);
		
		country = new Country();
		country.setID("200");
		country.setCountryID("086");
		country.setName("Samoa");
		country.setIntlCallingCode("685");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("204");
		country.setCountryID("087");
		country.setName("Senegal");
		country.setIntlCallingCode("221");
		country.setCurrency("XOF");
		countries.add(country);
		
		country = new Country();
		country.setID("212");
		country.setCountryID("088");
		country.setName("Somalia");
		country.setIntlCallingCode("252");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("213");
		country.setCountryID("089");
		country.setName("South Africa");
		country.setIntlCallingCode("27");
		country.setCurrency("ZAR");
		countries.add(country);
		
		country = new Country();
		country.setID("215");
		country.setCountryID("090");
		country.setName("Spain");
		country.setIntlCallingCode("34");
		country.setCurrency("EUR");
		countries.add(country);
		
		country = new Country();
		country.setID("217");
		country.setCountryID("091");
		country.setName("Sri Lanka");
		country.setIntlCallingCode("94");
		country.setCurrency("LKR");
		countries.add(country);
		
		country = new Country();
		country.setID("196");
		country.setCountryID("092");
		country.setName("St. Kitts and Nevis");
		country.setIntlCallingCode("1869");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("197");
		country.setCountryID("093");
		country.setName("St. Lucia");
		country.setIntlCallingCode("1758");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("199");
		country.setCountryID("094");
		country.setName("St. Vincent and Grenadines");
		country.setIntlCallingCode("1784");
		country.setCurrency("XCD");
		countries.add(country);
		
		country = new Country();
		country.setID("");
		country.setCountryID("095");
		country.setName("Sudan");
		country.setIntlCallingCode("249");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("219");
		country.setCountryID("096");
		country.setName("Suriname");
		country.setIntlCallingCode("597");
		country.setCurrency("SRD");
		countries.add(country);
		
		country = new Country();
		country.setID("221");
		country.setCountryID("097");
		country.setName("Swaziland");
		country.setIntlCallingCode("268");
		country.setCurrency("SZL");
		countries.add(country);
		
		country = new Country();
		country.setID("224");
		country.setCountryID("098");
		country.setName("Syria");
		country.setIntlCallingCode("963");
		country.setCurrency("SYP");
		countries.add(country);
		
		country = new Country();
		country.setID("227");
		country.setCountryID("099");
		country.setName("Tanzania");
		country.setIntlCallingCode("255");
		country.setCurrency("TZS");
		countries.add(country);
		
		country = new Country();
		country.setID("228");
		country.setCountryID("100");
		country.setName("Thailand");
		country.setIntlCallingCode("66");
		country.setCurrency("THB");
		countries.add(country);
		
		country = new Country();
		country.setID("232");
		country.setCountryID("101");
		country.setName("Tonga");
		country.setIntlCallingCode("963");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("233");
		country.setCountryID("102");
		country.setName("Trinadad and Tobago");
		country.setIntlCallingCode("1868");
		country.setCurrency("TTD");
		countries.add(country);
		
		country = new Country();
		country.setID("235");
		country.setCountryID("103");
		country.setName("Tunisia");
		country.setIntlCallingCode("216");
		country.setCurrency("TND");
		countries.add(country);
		
		country = new Country();
		country.setID("236");
		country.setCountryID("104");
		country.setName("Turkey");
		country.setIntlCallingCode("90");
		country.setCurrency("TRY");
		countries.add(country);
		
		country = new Country();
		country.setID("238");
		country.setCountryID("105");
		country.setName("Turks and Caicos");
		country.setIntlCallingCode("1649");
		country.setCurrency("TTD");
		countries.add(country);
		
		country = new Country();
		country.setID("240");
		country.setCountryID("106");
		country.setName("Uganda");
		country.setIntlCallingCode("256");
		country.setCurrency("UGX");
		countries.add(country);
		
		country = new Country();
		country.setID("241");
		country.setCountryID("107");
		country.setName("Ukraine");
		country.setIntlCallingCode("380");
		country.setCurrency("UAH");
		countries.add(country);
		
		country = new Country();
		country.setID("244");
		country.setCountryID("108");
		country.setName("United States");
		country.setIntlCallingCode("1");
		country.setCurrency("USD");
		countries.add(country);
		
		country = new Country();
		country.setID("245");
		country.setCountryID("109");
		country.setName("Uruguay");
		country.setIntlCallingCode("586");
		country.setCurrency("UYU");
		countries.add(country);
		
		country = new Country();
		country.setID("248");
		country.setCountryID("110");
		country.setName("Venezuela");
		country.setIntlCallingCode("58");
		country.setCurrency("VEF");
		countries.add(country);
		
		country = new Country();
		country.setID("249");
		country.setCountryID("111");
		country.setName("Vietnam");
		country.setIntlCallingCode("74");
		country.setCurrency("VND");
		countries.add(country);
		
		country = new Country();
		country.setID("255");
		country.setCountryID("112");
		country.setName("Yemen");
		country.setIntlCallingCode("967");
		country.setCurrency("YER");
		countries.add(country);
		
		country = new Country();
		country.setID("256");
		country.setCountryID("113");
		country.setName("Zambia");
		country.setIntlCallingCode("260");
		country.setCurrency("ZMK");
		countries.add(country);
		
		country = new Country();
		country.setID("257");
		country.setCountryID("114");
		country.setName("Zimbabwe");
		country.setIntlCallingCode("263");
		country.setCurrency("USD");
		countries.add(country);
		
		return countries;
	}

	public static Country GetCountry(String countryName, Context context){
		ArrayList<Country> countries = GetCountries(context);
		
		for(Country country : countries){
			if(country.getName().contains(countryName)){
				return country;
			}
		}
		
		return null;
	}
	
	/*public static String[] GetGatewayCoefficients(String networkID, String gatewayID){
		Cursor gway = db.query(true, DB.TABLE_NETWORK_GATEWAY, null, DB.KEY_NETWORK_ID2 + " = ? and " + DB.KEY_GATEWAY_ID2 + " = ?", 
				               new String[]{networkID, gatewayID}, null, null, null, null);
		 
	    if ((gway.getCount() == 0) || !gway.moveToFirst()){
		   return null;
	    }
	    else{
	       return new String[] {gway.getString(DB.LOCAL_COEFF_VALUE_COLUMN), gway.getString(DB.USD_COEFF_VALUE_COLUMN)};
	    }
	}
	
	
	//For Getting all the Networks that belong to a country; pass in the CountryID parameter
	public static ArrayList<Network> GetNetworks(String CountryID, Context context){
		
		networks = new ArrayList<Network>();
		Network network = new Network();
		network.setNetworkID("000");
		network.setName(context.getString(R.string.netOperator));
		network.setIsFixed("");
		network.setMin("");
		network.setMax("");
		networks.add(network);
		
		if(CountryID.equals("001")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Etisalat");
			network.setIsFixed("true");
			network.setPhoneNumberLenght("10");
			network.setMin("500");
			network.setMax("4000");
			network.setIntlCallingCode("93");
			network.setCurrency("AFN");
			network.setTopUpID("A001B002");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			//Coefficients are arranged in this manner:
			//Interswitch, Coremobile, Etranzact, Verve, Paypal, Google, Amazon, Mastercard, Visacard
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Roshan");
			network.setIsFixed("true");
			network.setPhoneNumberLenght("10");
			network.setMin("500.00");
			network.setMax("5000.00");
			network.setIntlCallingCode("93");
			network.setCurrency("AFN");
			network.setTopUpID("A001B001");
			network.setUSDMin("5.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("93");
			network.setPhoneNumberLenght("10");
			network.setCurrency("AFN");
			network.setTopUpID("A001B003");
			network.setMin("500.00");
			network.setMax("4000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.975"); cf.add("0.975"); cf.add("0.975"); cf.add("0.975");
			cf.add("1.02"); cf.add("1.01"); cf.add("1.02"); cf.add("1.01"); cf.add("1.01");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("002")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Djezzy");
			network.setIsFixed("true");
			network.setIntlCallingCode("213");
			network.setPhoneNumberLenght("11");
			network.setCurrency("DZD");
			network.setTopUpID("A002B004");
			network.setMin("400.00");
			network.setMax("5000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("003")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1264");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A003B006");
			network.setMin("10.00");
			network.setMax("180.00");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1264");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A003B005");
			network.setMin("6.00");
			network.setMax("200.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("004")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1268");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A004B009");
			network.setMin("10.00");
			network.setMax("180.00");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1268");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A004B008");
			network.setMin("6.00");
			network.setMax("200.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("005")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Vivecell-MTS");
			network.setIsFixed("true");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setCurrency("RUB");
			network.setTopUpID("A006B014");
			network.setMin("15.00");
			network.setMax("2050.00");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("006")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1268");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A007B017");
			network.setMin("10.00");
			network.setMax("180.00");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("007")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Robi");
			network.setIsFixed("false");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setIntlCallingCode("880");
			network.setCurrency("BDT");
			network.setTopUpID("A013B001");
			ArrayList<String> h = new ArrayList<String>();
			h.add("BDT 50"); h.add("BDT 100"); h.add("BDT 200"); h.add("BDT 400");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 0.625"); h.add("USD 1.25"); h.add("USD 2.50"); h.add("USD 5.00");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.14"); cf.add("1.14"); cf.add("1.14"); cf.add("1.14");
			cf.add("1.185"); cf.add("1.175"); cf.add("1.185"); cf.add("1.175"); cf.add("1.175");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Banglalink");
			network.setIsFixed("false");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setIntlCallingCode("880");
			network.setCurrency("BDT");
			network.setTopUpID("A013B002");
			h = new ArrayList<String>();
			h.add("BDT 50"); h.add("BDT 100"); h.add("BDT 200"); h.add("BDT 400");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 0.625"); h.add("USD 1.25"); h.add("USD 2.50"); h.add("USD 5.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.14"); cf.add("1.14"); cf.add("1.14"); cf.add("1.14");
			cf.add("1.185"); cf.add("1.175"); cf.add("1.185"); cf.add("1.175"); cf.add("1.175");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Airtel");
			network.setIsFixed("false");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setIntlCallingCode("880");
			network.setCurrency("BDT");
			network.setTopUpID("A013B003");
			h = new ArrayList<String>();
			h.add("BDT 50"); h.add("BDT 100"); h.add("BDT 200"); h.add("BDT 400");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 0.625"); h.add("USD 1.25"); h.add("USD 2.50"); h.add("USD 5.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.11"); cf.add("1.11"); cf.add("1.11"); cf.add("1.11");
			cf.add("1.155"); cf.add("1.145"); cf.add("1.155"); cf.add("1.145"); cf.add("1.145");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("GrameenPhone");
			network.setIsFixed("false");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setIntlCallingCode("880");
			network.setCurrency("BDT");
			network.setTopUpID("A013B004");
			h = new ArrayList<String>();
			h.add("BDT 50"); h.add("BDT 100"); h.add("BDT 200"); h.add("BDT 400");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 0.625"); h.add("USD 1.25"); h.add("USD 2.50"); h.add("USD 5.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.11"); cf.add("1.11"); cf.add("1.11"); cf.add("1.11");
			cf.add("1.155"); cf.add("1.145"); cf.add("1.155"); cf.add("1.145"); cf.add("1.145");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("008")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1246");
			network.setPhoneNumberLenght("8");
			network.setCurrency("BBD");
			network.setTopUpID("A014B043");
			network.setMin("8.00");
			network.setMax("140.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1246");
			network.setPhoneNumberLenght("8");
			network.setCurrency("BBD");
			network.setTopUpID("A014B042");
			network.setMin("6.00");
			network.setMax("140.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("009")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Smart");
			network.setIsFixed("true");
			network.setIntlCallingCode("501");
			network.setPhoneNumberLenght("11");
			network.setCurrency("BZD");
			network.setTopUpID("A017B053");
			network.setMin("7.00");
			network.setMax("140.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Telemedia");
			network.setIsFixed("true");
			network.setIntlCallingCode("501");
			network.setPhoneNumberLenght("11");
			network.setCurrency("BZD");
			network.setTopUpID("A017B054");
			network.setMin("7.00");
			network.setMax("140.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("010")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Moov");
			network.setIsFixed("false");
			network.setIntlCallingCode("229");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A018B056");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 500"); h.add("XOF 900"); h.add("XOF 1000"); h.add("XOF 2000");
			h.add("XOF 2500"); h.add("XOF 2600"); h.add("XOF 2700"); h.add("XOF 3900");
			h.add("XOF 4000"); h.add("XOF 4150"); h.add("XOF 4200"); h.add("XOF 4400");
			h.add("XOF 5000"); h.add("XOF 5400"); h.add("XOF 5580"); h.add("XOF 6000");
			h.add("XOF 6300"); h.add("XOF 8400"); h.add("XOF 8500"); h.add("XOF 8800");
			h.add("XOF 10000"); h.add("XOF 20000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 8"); h.add("USD 10"); h.add("USD 12"); h.add("USD 14");
			h.add("USD 16"); h.add("USD 18"); h.add("USD 20"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.0194"); cf.add("1.0194"); cf.add("1.0194"); cf.add("1.0194");
			cf.add("1.0644"); cf.add("1.0544"); cf.add("1.0644"); cf.add("1.0544"); cf.add("1.0544");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("229");
			network.setPhoneNumberLenght("9");
			network.setCurrency("XOF");
			network.setTopUpID("A018B055");
			network.setMin("300.00");
			network.setMax("40000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("011")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1441");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A019B060");
			network.setMin("2.00");
			network.setMax("75.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("012")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Viva");
			network.setIsFixed("true");
			network.setIntlCallingCode("591");
			network.setPhoneNumberLenght("9");
			network.setCurrency("BOB");
			network.setTopUpID("A021B065");
			network.setMin("40.00");
			network.setMax("500.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.94"); cf.add("0.94"); cf.add("0.94"); cf.add("0.94");
			cf.add("0.985"); cf.add("0.975"); cf.add("0.985"); cf.add("0.975"); cf.add("0.975");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Entel");
			network.setIsFixed("true");
			network.setIntlCallingCode("591");
			network.setPhoneNumberLenght("9");
			network.setCurrency("BOB");
			network.setTopUpID("A021B064");
			network.setMin("40.00");
			network.setMax("500.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Tigo");
			network.setIsFixed("true");
			network.setIntlCallingCode("591");
			network.setPhoneNumberLenght("9");
			network.setCurrency("BOB");
			network.setTopUpID("A021B066");
			network.setMin("40.00");
			network.setMax("500.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("013")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("599");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A022B068");
			network.setMin("5.00");
			network.setMax("75.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("014")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Tim");
			network.setIsFixed("false");
			network.setIntlCallingCode("55");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A025B078");
			network.setMin("");
			network.setMax("");
			network.setCurrency("BRL");
			ArrayList<String> h = new ArrayList<String>();
			h.add("BRL 17"); h.add("BRL 26"); h.add("BRL 35"); h.add("BRL 50");
			h.add("BRL 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.75"); h.add("USD 16.25"); h.add("USD 21.90"); h.add("USD 31.25");
			h.add("USD 62.50");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Vivo");
			network.setIsFixed("false");
			network.setIntlCallingCode("55");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A025B077");
			network.setMin("");
			network.setMax("");
			network.setCurrency("BRL");
			h = new ArrayList<String>();
			h.add("BRL 12"); h.add("BRL 18"); h.add("BRL 25"); h.add("BRL 35");
			h.add("BRL 50"); h.add("BRL 100"); h.add("BRL 200"); h.add("BRL 300");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 7.5"); h.add("USD 11.25"); h.add("USD 12.50");
			h.add("USD 15.63"); h.add("USD 18.75"); h.add("USD 21.9"); h.add("USD 31.25");
			h.add("USD 62.50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Claro");
			network.setIsFixed("false");
			network.setIntlCallingCode("55");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A025B079");
			network.setMin("");
			network.setMax("");
			network.setCurrency("BRL");
			h = new ArrayList<String>();
			h.add("BRL 12"); h.add("BRL 17"); h.add("BRL 22"); h.add("BRL 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 7.50"); h.add("USD 10.75"); h.add("USD 13.75"); h.add("USD 18.75");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Oi");
			network.setIsFixed("false");
			network.setIntlCallingCode("55");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A025B080");
			network.setMin("");
			network.setMax("");
			network.setCurrency("BRL");
			h = new ArrayList<String>();
			h.add("BRL 15"); h.add("BRL 20");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 9.40"); h.add("USD 12.50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Nextel");
			network.setIsFixed("false");
			network.setIntlCallingCode("55");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A025B081");
			network.setMin("");
			network.setMax("");
			network.setCurrency("BRL");
			h = new ArrayList<String>();
			h.add("BRL 8"); h.add("BRL 12"); h.add("BRL 20"); h.add("BRL 30");
			h.add("BRL 50"); h.add("BRL 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 7.50"); h.add("USD 12.50"); h.add("USD 18.75");
			h.add("USD 31.25"); h.add("USD 62.50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("015")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1284");
			network.setPhoneNumberLenght("8");
			network.setCurrency("USD");
			network.setTopUpID("A026B086");
			network.setMin("5.00");
			network.setMax("75.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1284");
			network.setPhoneNumberLenght("8");
			network.setCurrency("USD");
			network.setTopUpID("A026B085");
			network.setMin("5.00");
			network.setMax("75.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("016")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("UCOM");
			network.setIsFixed("true");
			network.setIntlCallingCode("257");
			network.setPhoneNumberLenght("11");
			network.setCurrency("BIF");
			network.setTopUpID("A029B095");
			network.setMin("1000.00");
			network.setMax("20000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Econet");
			network.setIsFixed("true");
			network.setIntlCallingCode("257");
			network.setPhoneNumberLenght("11");
			network.setCurrency("BIF");
			network.setTopUpID("A029B098");
			network.setMin("1000.00");
			network.setMax("20000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("14.00");
			cf = new ArrayList<String>();
			cf.add("1.09"); cf.add("1.09"); cf.add("1.09"); cf.add("1.09");
			cf.add("1.135"); cf.add("1.125"); cf.add("1.135"); cf.add("1.125"); cf.add("1.125");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("017")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("qbCube");
			network.setIsFixed("false");
			network.setIntlCallingCode("855");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			network.setTopUpID("A030B107");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Smart");
			network.setIsFixed("false");
			network.setIntlCallingCode("855");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A030B102");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Mobitel CamGSM");
			network.setIsFixed("false");
			network.setIntlCallingCode("855");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A030B101");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1"); cf.add("1"); cf.add("1"); cf.add("1");
			cf.add("1.045"); cf.add("1.035"); cf.add("1.045"); cf.add("1.035"); cf.add("1.035");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Mfone");
			network.setIsFixed("false");
			network.setIntlCallingCode("855");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A030B103");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1"); cf.add("1"); cf.add("1"); cf.add("1");
			cf.add("1.045"); cf.add("1.035"); cf.add("1.045"); cf.add("1.035"); cf.add("1.035");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Metfone");
			network.setIsFixed("false");
			network.setIntlCallingCode("855");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A030B109");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.99"); cf.add("0.99"); cf.add("0.99"); cf.add("0.99");
			cf.add("1.035"); cf.add("1.025"); cf.add("1.035"); cf.add("1.025"); cf.add("1.025");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("018")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("237");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A031B111");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 6000"); h.add("XOF 12000"); h.add("XOF 24000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23.00"); h.add("USD 46.00");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.8"); cf.add("0.8"); cf.add("0.8"); cf.add("0.8");
			cf.add("0.845"); cf.add("0.835"); cf.add("0.845"); cf.add("0.835"); cf.add("0.835");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("257");
			network.setPhoneNumberLenght("11");
			network.setCurrency("XOF");
			network.setTopUpID("A031B110");
			network.setMin("300.00");
			network.setMax("40000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("019")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("257");
			network.setPhoneNumberLenght("11");
			network.setCurrency("KYD");
			network.setTopUpID("A034B124");
			network.setMin("4.00");
			network.setMax("57.00");
			network.setUSDMin("4.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1345");
			network.setPhoneNumberLenght("8");
			network.setCurrency("KYD");
			network.setTopUpID("A034B123");
			network.setMin("5.00");
			network.setMax("60.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("020")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Moov");
			network.setIsFixed("false");
			network.setIntlCallingCode("236");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A035B126");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XAF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XAF 500"); h.add("XAF 900"); h.add("XAF 1000"); h.add("XAF 2000");
			h.add("XAF 2500"); h.add("XAF 2600"); h.add("XAF 2700"); h.add("XAF 3900");
			h.add("XAF 4000"); h.add("XAF 4150"); h.add("XAF 4400"); h.add("XAF 5000");
			h.add("XAF 5400"); h.add("XAF 5580"); h.add("XAF 6000"); h.add("XAF 6300");
			h.add("XAF 8400"); h.add("XAF 8500"); h.add("XAF 8800"); h.add("XAF 10000");
			h.add("XAF 20000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 8"); h.add("USD 10"); h.add("USD 12"); h.add("USD 14");
			h.add("USD 16"); h.add("USD 18"); h.add("USD 20"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Telcel");
			network.setIsFixed("false");
			network.setIntlCallingCode("236");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A035B125");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XAF");
			h = new ArrayList<String>();
			h.add("XAF 500"); h.add("XAF 900"); h.add("XAF 1000"); h.add("XAF 2000");
			h.add("XAF 2500"); h.add("XAF 2600"); h.add("XAF 2700"); h.add("XAF 3900");
			h.add("XAF 4000"); h.add("XAF 4150"); h.add("XAF 4400"); h.add("XAF 5000");
			h.add("XAF 5400"); h.add("XAF 5580"); h.add("XAF 6000"); h.add("XAF 6300");
			h.add("XAF 8400"); h.add("XAF 8500"); h.add("XAF 8800"); h.add("XAF 10000");
			h.add("XAF 20000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 8"); h.add("USD 10"); h.add("USD 12"); h.add("USD 14");
			h.add("USD 16"); h.add("USD 18"); h.add("USD 20"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("021")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Movistar");
			network.setIsFixed("false");
			network.setIntlCallingCode("56");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A037B132");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CLP");
			ArrayList<String> h = new ArrayList<String>();
			h.add("CLP 2000"); h.add("CLP 3600"); h.add("CLP 5000"); h.add("CLP 10000"); 
			h.add("CLP 15000"); h.add("CLP 25000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 10"); h.add("USD 20"); h.add("USD 30");
			network.setUSDDenominations(h);
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Claro");
			network.setIsFixed("false");
			network.setIntlCallingCode("56");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A037B134");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CLP");
			h = new ArrayList<String>();
			h.add("CLP 2000"); h.add("CLP 3600"); h.add("CLP 5000"); h.add("CLP 10000"); 
			h.add("CLP 15000"); h.add("CLP 25000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 8"); h.add("USD 10"); h.add("USD 20");
			h.add("USD 30"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Entel");
			network.setIsFixed("false");
			network.setIntlCallingCode("56");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A037B133");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CLP");
			h = new ArrayList<String>();
			h.add("CLP 2000"); h.add("CLP 3500"); h.add("CLP 5000"); h.add("CLP 10000"); 
			h.add("CLP 15000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 8"); h.add("USD 10"); h.add("USD 20");
			h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("022")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("China Mobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("86");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A038B136");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CNY");
			ArrayList<String> h = new ArrayList<String>();
			h.add("CNY 30"); h.add("CNY 50"); h.add("CNY 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.13"); cf.add("1.13"); cf.add("1.13"); cf.add("1.13");
			cf.add("1.175"); cf.add("1.165"); cf.add("1.175"); cf.add("1.165"); cf.add("1.165");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("China Telecom");
			network.setIsFixed("false");
			network.setIntlCallingCode("86");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A038B137");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CNY");
			h = new ArrayList<String>();
			h.add("CNY 30"); h.add("CNY 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.12"); cf.add("1.12"); cf.add("1.12"); cf.add("1.12");
			cf.add("1.165"); cf.add("1.155"); cf.add("1.165"); cf.add("1.155"); cf.add("1.155");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("China Unicom");
			network.setIsFixed("false");
			network.setIntlCallingCode("86");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A038B138");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CNY");
			h = new ArrayList<String>();
			h.add("CNY 30"); h.add("CNY 50"); h.add("CNY 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("023")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("57");
			network.setPhoneNumberLenght("11");
			network.setCurrency("COP");
			network.setTopUpID("A039B140");
			network.setMin("10000.00");
			network.setMax("135000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Tigo");
			network.setIsFixed("true");
			network.setIntlCallingCode("57");
			network.setPhoneNumberLenght("11");
			network.setCurrency("COP");
			network.setTopUpID("A039B141");
			network.setMin("10000.00");
			network.setMax("135000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Uff Movil");
			network.setIsFixed("false");
			network.setIntlCallingCode("57");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A039B142");
			network.setMin("");
			network.setMax("");
			network.setCurrency("COP");
			ArrayList<String> h = new ArrayList<String>();
			h.add("COP 1000"); h.add("COP 5000"); h.add("COP 7500"); h.add("COP 10000");
			h.add("COP 15000"); h.add("COP 20000"); h.add("COP 22500"); h.add("COP 25000");
			h.add("COP 50000"); h.add("COP 70000"); h.add("COP 75000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2.50"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 8"); h.add("USD 10"); h.add("USD 12"); h.add("USD 14");
			h.add("USD 28"); h.add("USD 40"); h.add("USD 42");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1"); cf.add("1"); cf.add("1"); cf.add("1");
			cf.add("1.045"); cf.add("1.035"); cf.add("1.045"); cf.add("1.035"); cf.add("1.035");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Comcel");
			network.setIsFixed("false");
			network.setIntlCallingCode("57");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A039B139");
			network.setMin("");
			network.setMax("");
			network.setCurrency("COP");
			h = new ArrayList<String>();
			h.add("COP 1000"); h.add("COP 5000"); h.add("COP 7500"); h.add("COP 10000");
			h.add("COP 15000"); h.add("COP 20000"); h.add("COP 22500"); h.add("COP 25000");
			h.add("COP 50000"); h.add("COP 70000"); h.add("COP 75000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 6"); h.add("USD 11"); h.add("USD 22"); h.add("USD 28");
			h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("024")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("242");
			network.setPhoneNumberLenght("10");
			network.setCurrency("XOF");
			network.setTopUpID("A042B156");
			network.setMin("250.00");
			network.setMax("40000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("025")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Kolbi");
			network.setIsFixed("false");
			network.setIntlCallingCode("506");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A043B160");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 4"); h.add("USD 5"); h.add("USD 6");
			h.add("USD 7"); h.add("USD 8"); h.add("USD 9"); h.add("USD 10");
			h.add("USD 11"); h.add("USD 12"); h.add("USD 13"); h.add("USD 14");
			h.add("USD 15"); h.add("USD 16"); h.add("USD 17"); h.add("USD 18");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 4"); h.add("USD 5"); h.add("USD 6");
			h.add("USD 7"); h.add("USD 8"); h.add("USD 9"); h.add("USD 10");
			h.add("USD 11"); h.add("USD 12"); h.add("USD 13"); h.add("USD 14");
			h.add("USD 15"); h.add("USD 16"); h.add("USD 17"); h.add("USD 18");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1"); cf.add("1"); cf.add("1"); cf.add("1");
			cf.add("1.045"); cf.add("1.035"); cf.add("1.045"); cf.add("1.035"); cf.add("1.035");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("026")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Cubacel");
			network.setIsFixed("false");
			network.setIntlCallingCode("53");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A046B173");
			network.setMin("");
			network.setMax("");
			network.setCurrency("CUC");
			ArrayList<String> h = new ArrayList<String>();
			h.add("CUC 10"); h.add("CUC 15"); h.add("CUC 20"); h.add("CUC 25");
			h.add("CUC 30"); h.add("CUC 35"); h.add("CUC 40"); h.add("CUC 45");
			h.add("CUC 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 13.00"); h.add("USD 19.50"); h.add("USD 26.00"); h.add("USD 32.50");
			h.add("USD 39.00"); h.add("USD 45.50"); h.add("USD 52.00"); h.add("USD 58.50");
			h.add("USD 65.00");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("027")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("599");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A047B174");
			network.setMin("5.00");
			network.setMax("75.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("028")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("357");
			network.setPhoneNumberLenght("9");
			network.setCurrency("EUR");
			network.setTopUpID("A048B177");
			network.setMin("1.00");
			network.setMax("40.00");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("029")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Vodacom");
			network.setIsFixed("true");
			network.setIntlCallingCode("243");
			network.setPhoneNumberLenght("11");
			network.setCurrency("XOF");
			network.setTopUpID("A041B149");
			network.setMin("500.00");
			network.setMax("15000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("30.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Airtel");
			network.setIsFixed("true");
			network.setIntlCallingCode("243");
			network.setPhoneNumberLenght("11");
			network.setCurrency("XOF");
			network.setTopUpID("A041B148");
			network.setMin("500.00");
			network.setMax("15000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("30.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("030")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1767");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A052B188");
			network.setMin("11.00");
			network.setMax("180.00");
			network.setUSDMin("4.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1767");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A052B189");
			network.setMin("6.00");
			network.setMax("200.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("031")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("1809");
			network.setPhoneNumberLenght("8");
			network.setTopUpID("A053B191");
			network.setMin("");
			network.setMax("");
			network.setCurrency("DOP");
			ArrayList<String> h = new ArrayList<String>();
			h.add("DOP 195"); h.add("DOP 390"); h.add("DOP 585"); h.add("DOP 780");
			h.add("DOP 1170"); h.add("DOP 1560");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 30"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Viva");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("8");
			network.setCurrency("DOP");
			network.setTopUpID("A053B192");
			network.setMin("80.00");
			network.setMax("2800.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.94"); cf.add("0.94"); cf.add("0.94"); cf.add("0.94");
			cf.add("0.985"); cf.add("0.975"); cf.add("0.985"); cf.add("0.975"); cf.add("0.975");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("8");
			network.setCurrency("DOP");
			network.setTopUpID("A053B190");
			network.setMin("200.00");
			network.setMax("2800.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.935"); cf.add("0.935"); cf.add("0.935"); cf.add("0.935");
			cf.add("0.98"); cf.add("0.97"); cf.add("0.98"); cf.add("0.97"); cf.add("0.97");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Tricom");
			network.setIsFixed("false");
			network.setIntlCallingCode("1809");
			network.setPhoneNumberLenght("8");
			network.setTopUpID("A053B193");
			network.setMin("");
			network.setMax("");
			network.setCurrency("DOP");
			h = new ArrayList<String>();
			h.add("DOP 200"); h.add("DOP 300"); h.add("DOP 400"); h.add("DOP 500");
			h.add("DOP 1000"); h.add("DOP 2000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5.00"); h.add("USD 7.50"); h.add("USD 10.00"); h.add("USD 12.50");
			h.add("USD 25.00"); h.add("USD 50.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("032")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("false");
			network.setIntlCallingCode("593");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A054B194");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 20");
			h.add("USD 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 6"); h.add("USD 10"); h.add("USD 20");
			h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Alegro");
			network.setIsFixed("false");
			network.setIntlCallingCode("593");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A054B196");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 20"); h.add("USD 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 20"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.89"); cf.add("0.89"); cf.add("0.89"); cf.add("0.89");
			cf.add("0.935"); cf.add("0.925"); cf.add("0.935"); cf.add("0.925"); cf.add("0.925");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("593");
			network.setPhoneNumberLenght("9");
			network.setCurrency("USD");
			network.setTopUpID("A054B195");
			network.setMin("1.00");
			network.setMax("75.00");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.89"); cf.add("0.89"); cf.add("0.89"); cf.add("0.89");
			cf.add("0.935"); cf.add("0.925"); cf.add("0.935"); cf.add("0.925"); cf.add("0.925");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("033")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Etisalat");
			network.setIsFixed("true");
			network.setIntlCallingCode("20");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EGP");
			network.setTopUpID("A055B199");
			network.setMin("6.00");
			network.setMax("150.00");
			network.setUSDMin("1.00");
			network.setUSDMax("25.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Mobinil");
			network.setIsFixed("true");
			network.setIntlCallingCode("20");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EGP");
			network.setTopUpID("A055B198");
			network.setMin("7.00");
			network.setMax("300.00");
			network.setUSDMin("1.00");
			network.setUSDMax("50.00");
			cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Vodafone");
			network.setIsFixed("true");
			network.setIntlCallingCode("20");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EGP");
			network.setTopUpID("A055B197");
			network.setMin("20.00");
			network.setMax("120.00");
			network.setUSDMin("3.00");
			network.setUSDMax("20.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("034")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("503");
			network.setPhoneNumberLenght("9");
			network.setCurrency("USD");
			network.setTopUpID("A056B201");
			network.setMin("1.00");
			network.setMax("75.00");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("503");
			network.setPhoneNumberLenght("9");
			network.setCurrency("USD");
			network.setTopUpID("A056B203");
			network.setMin("1.00");
			network.setMax("75.00");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("503");
			network.setPhoneNumberLenght("9");
			network.setCurrency("USD");
			network.setTopUpID("A055B202");
			network.setMin("1.00");
			network.setMax("75.00");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Tigo");
			network.setIsFixed("false");
			network.setIntlCallingCode("503");
			network.setPhoneNumberLenght("9");
			network.setCurrency("USD");
			network.setTopUpID("A055B200");
			network.setMin("");
			network.setMax("");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 20"); h.add("USD 40");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 20"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("035")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Hits");
			network.setIsFixed("false");
			network.setIntlCallingCode("240");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XAF");
			network.setTopUpID("A057B206");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XAF 500"); h.add("XAF 900"); h.add("XAF 1000"); h.add("XAF 2000");
			h.add("XAF 2500"); h.add("XAF 2600"); h.add("XAF 2700"); h.add("XAF 3900");
			h.add("XAF 4000"); h.add("XAF 4150"); h.add("XAF 4200"); h.add("XAF 4400");
			h.add("XAF 5000"); h.add("XAF 5400"); h.add("XAF 5580"); h.add("XAF 6000");
			h.add("XAF 6300"); h.add("XAF 8400"); h.add("XAF 8500"); h.add("XAF 8800");
			h.add("XAF 10000"); h.add("XAF 20000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 8"); h.add("USD 10"); h.add("USD 12"); h.add("USD 14");
			h.add("USD 16"); h.add("USD 18"); h.add("USD 20"); h.add("USD 22");
			h.add("USD 24"); h.add("USD 26"); h.add("USD 28"); h.add("USD 30");
			h.add("USD 32"); h.add("USD 34"); h.add("USD 36"); h.add("USD 38");
			h.add("USD 40");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("036")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("false");
			network.setIntlCallingCode("679");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setCurrency("FJD");
			network.setTopUpID("A063B215");
			ArrayList<String> h = new ArrayList<String>();
			h.add("FJD 5"); h.add("FJD 7"); h.add("FJD 10"); h.add("FJD 14");
			h.add("FJD 20"); h.add("FJD 22"); h.add("FJD 50"); h.add("FJD 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 4"); h.add("USD 6"); h.add("USD 9");
			h.add("USD 12"); h.add("USD 15"); h.add("USD 30"); h.add("USD 60");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Vodafone");
			network.setIsFixed("false");
			network.setIntlCallingCode("679");
			network.setPhoneNumberLenght("11");
			network.setMin("");
			network.setMax("");
			network.setCurrency("FJD");
			network.setTopUpID("A063B216");
			h = new ArrayList<String>();
			h.add("FJD 5"); h.add("FJD 7"); h.add("FJD 10"); h.add("FJD 14");
			h.add("FJD 20"); h.add("FJD 22"); h.add("FJD 50"); h.add("FJD 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 4"); h.add("USD 6"); h.add("USD 8");
			h.add("USD 12"); h.add("USD 15"); h.add("USD 30"); h.add("USD 60");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.04"); cf.add("1.04"); cf.add("1.04"); cf.add("1.04");
			cf.add("1.085"); cf.add("1.075"); cf.add("1.085"); cf.add("1.075"); cf.add("1.075");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("037")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("594");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A066B230");
			network.setMin("5.00");
			network.setMax("75.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("038")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Azur");
			network.setIsFixed("true");
			network.setIntlCallingCode("241");
			network.setPhoneNumberLenght("11");
			network.setCurrency("XAF");
			network.setTopUpID("A068B234");
			network.setMin("250.00");
			network.setMax("40000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("039")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("QCell");
			network.setIsFixed("true");
			network.setIntlCallingCode("220");
			network.setPhoneNumberLenght("8");
			network.setCurrency("GMD");
			network.setTopUpID("A069B238");
			network.setMin("30.00");
			network.setMax("2200.00");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("040")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Beeline");
			network.setIsFixed("true");
			network.setIntlCallingCode("995");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A070B241");
			network.setMin("1.00");
			network.setMax("50.00");
			network.setUSDMin("2.00");
			network.setUSDMax("60.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("041")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Airtel");
			network.setIsFixed("true");
			network.setIntlCallingCode("233");
			network.setPhoneNumberLenght("11");
			network.setCurrency("GHS");
			network.setTopUpID("A072B250");
			network.setMin("6.00");
			network.setMax("100.00");
			network.setUSDMin("3.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("233");
			network.setPhoneNumberLenght("11");
			network.setCurrency("GHS");
			network.setTopUpID("A072B247");
			network.setMin("6.00");
			network.setMax("100.00");
			network.setUSDMin("3.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Tigo");
			network.setIsFixed("true");
			network.setIntlCallingCode("233");
			network.setPhoneNumberLenght("11");
			network.setCurrency("GHS");
			network.setTopUpID("A072B249");
			network.setMin("6.00");
			network.setMax("100.00");
			network.setUSDMin("3.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Vodafone");
			network.setIsFixed("false");
			network.setIntlCallingCode("233");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A072B001");
			network.setMin("");
			network.setMax("");
			network.setCurrency("GHS");
			ArrayList<String> h = new ArrayList<String>();
			h.add("GHS 1"); h.add("GHS 2"); h.add("GHS 3"); h.add("GHS 4");
			h.add("GHS 5"); h.add("GHS 6"); h.add("GHS 7"); h.add("GHS 10");
			h.add("GHS 11"); h.add("GHS 12"); h.add("GHS 15"); h.add("GHS 18");
			h.add("GHS 20"); h.add("GHS 22"); h.add("GHS 25"); h.add("GHS 30");
			h.add("GHS 40");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 12"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 30"); h.add("USD 35");
			h.add("USD 40");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("1.18"); cf.add("1.18"); cf.add("1.18"); cf.add("1.18");
			cf.add("1.225"); cf.add("1.215"); cf.add("1.225"); cf.add("1.215"); cf.add("1.215");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("042")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1473");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A076B260");
			network.setMin("12.00");
			network.setMax("200.00");
			network.setUSDMin("4.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1473");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A076B259");
			network.setMin("6.00");
			network.setMax("200.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("043")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("590");
			network.setPhoneNumberLenght("11");
			network.setCurrency("XCD");
			network.setTopUpID("A077B262");
			network.setMin("12.00");
			network.setMax("200.00");
			network.setUSDMin("4.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("044")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Tigo");
			network.setIsFixed("false");
			network.setIntlCallingCode("502");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A079B269");
			network.setMin("");
			network.setMax("");
			network.setCurrency("GTQ");
			ArrayList<String> h = new ArrayList<String>();
			h.add("GTQ 50"); h.add("GTQ 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 7"); h.add("USD 14");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("502");
			network.setPhoneNumberLenght("9");
			network.setCurrency("GTQ");
			network.setTopUpID("A079B270");
			network.setMin("8.00");
			network.setMax("570.00");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("502");
			network.setPhoneNumberLenght("9");
			network.setCurrency("GTQ");
			network.setTopUpID("A079B271");
			network.setMin("40.00");
			network.setMax("570.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("045")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Cellcom");
			network.setIsFixed("false");
			network.setIntlCallingCode("224");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A081B281");
			network.setMin("40000.00");
			network.setMax("500000.00");
			network.setCurrency("GNF");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("224");
			network.setPhoneNumberLenght("11");
			network.setCurrency("GNF");
			network.setTopUpID("A081B001");
			network.setUSDMin("3.00");
			network.setUSDMax("100.00");
			network.setMin("20000.00");
			network.setMax("700000.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("224");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A081B278");
			network.setMin("");
			network.setMax("");
			network.setCurrency("GNF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("GNF 71600"); h.add("GNF 143200");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23.00"); h.add("USD 46.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.79"); cf.add("0.79"); cf.add("0.79"); cf.add("0.79");
			cf.add("0.835"); cf.add("0.825"); cf.add("0.835"); cf.add("0.825"); cf.add("0.825");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("046")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("false");
			network.setIntlCallingCode("245");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A082B283");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 500"); h.add("XOF 900"); h.add("XOF 1000"); h.add("XOF 2000");
			h.add("XOF 2500"); h.add("XOF 2600"); h.add("XOF 2700"); h.add("XOF 3900");
			h.add("XOF 4000"); h.add("XOF 4150"); h.add("XOF 4200"); h.add("XOF 4400");
			h.add("XOF 5000"); h.add("XOF 5400"); h.add("XOF 5580"); h.add("XOF 6000");
			h.add("XOF 6300"); h.add("XOF 8400"); h.add("XOF 8500"); h.add("XOF 8800");
			h.add("XOF 9840"); h.add("XOF 10000"); h.add("XOF 20000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 8"); h.add("USD 10"); h.add("USD 12"); h.add("USD 14");
			h.add("USD 16"); h.add("USD 18"); h.add("USD 20"); h.add("USD 22");
			h.add("USD 24"); h.add("USD 26"); h.add("USD 28"); h.add("USD 30");
			h.add("USD 32"); h.add("USD 34"); h.add("USD 36"); h.add("USD 38");
			h.add("USD 40");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("047")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("CellLink GT&T");
			network.setIsFixed("true");
			network.setIntlCallingCode("592");
			network.setPhoneNumberLenght("8");
			network.setCurrency("GYD");
			network.setTopUpID("A083B288");
			network.setMin("40.00");
			network.setMax("500.00");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("592");
			network.setPhoneNumberLenght("8");
			network.setCurrency("GYD");
			network.setTopUpID("A083B286");
			network.setMin("400.00");
			network.setMax("15000.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("048")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("509");
			network.setPhoneNumberLenght("9");
			network.setCurrency("HTG");
			network.setTopUpID("A084B289");
			network.setMin("85.00");
			network.setMax("2800.00");
			network.setUSDMin("2.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.91"); cf.add("0.91"); cf.add("0.91"); cf.add("0.91");
			cf.add("0.955"); cf.add("0.945"); cf.add("0.955"); cf.add("0.945"); cf.add("0.945");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Voila");
			network.setIsFixed("true");
			network.setIntlCallingCode("509");
			network.setPhoneNumberLenght("9");
			network.setCurrency("HTG");
			network.setTopUpID("A084B290");
			network.setMin("200.00");
			network.setMax("3000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("049")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("504");
			network.setPhoneNumberLenght("9");
			network.setCurrency("HNL");
			network.setTopUpID("A085B294");
			network.setMin("56.00");
			network.setMax("1400.00");
			network.setUSDMin("4.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("504");
			network.setPhoneNumberLenght("9");
			network.setCurrency("HNL");
			network.setTopUpID("A085B296");
			network.setMin("20.00");
			network.setMax("1300.00");
			network.setUSDMin("4.00");
			network.setUSDMax("70.00");
			cf = new ArrayList<String>();
			cf.add("0.91"); cf.add("0.91"); cf.add("0.91"); cf.add("0.91");
			cf.add("0.955"); cf.add("0.945"); cf.add("0.955"); cf.add("0.945"); cf.add("0.945");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Tigo");
			network.setIsFixed("false");
			network.setIntlCallingCode("504");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A085B293");
			network.setMin("");
			network.setMax("");
			network.setCurrency("HNL");
			ArrayList<String> h = new ArrayList<String>();
			h.add("HNL 112"); h.add("HNL 224"); h.add("HNL 336"); h.add("HNL 448");
			h.add("HNL 560"); h.add("HNL 672"); h.add("HNL 784"); h.add("HNL 896");
			h.add("HNL 1008"); h.add("HNL 1120"); h.add("HNL 1232"); h.add("HNL 1400");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 6"); h.add("USD 12"); h.add("USD 18"); h.add("USD 24");
			h.add("USD 30"); h.add("USD 36"); h.add("USD 42"); h.add("USD 48");
			h.add("USD 54"); h.add("USD 60"); h.add("USD 66"); h.add("USD 75");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("050")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Aircel");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B318");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 6");
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Airtel");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B310");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 6");
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Big TV");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B002");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("BSNL");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B314");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 1.25"); h.add("USD 2.50");
			h.add("USD 5.00"); h.add("USD 7.00"); h.add("USD 12.00"); h.add("USD 22.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Idea");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B313");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Loop");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B324");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 2");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.975"); cf.add("0.975"); cf.add("0.975"); cf.add("0.975");
			cf.add("1.02"); cf.add("1.01"); cf.add("1.02"); cf.add("1.01"); cf.add("1.01");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("007");
			network.setName("MTNL");
			network.setIsFixed("false");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B313");
			network.setMin("");
			network.setMax("");
			h = new ArrayList<String>();
			h.add("INR 400"); h.add("INR 600");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 7.50"); h.add("USD 12.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("008");
			network.setName("MTS");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B320");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.975"); cf.add("0.975"); cf.add("0.975"); cf.add("0.975");
			cf.add("1.02"); cf.add("1.01"); cf.add("1.02"); cf.add("1.01"); cf.add("1.01");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("009");
			network.setName("Reliance");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B311");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 6");
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("010");
			network.setName("Tata Indicom");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B316");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 5");
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("011");
			network.setName("Tata Docomo");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B317");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("012");
			network.setName("Vodafone");
			network.setIsFixed("true");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setCurrency("INR");
			network.setTopUpID("A089B312");
			network.setMin("300.00");
			network.setMax("4000.00");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 6.50");
			h.add("USD 10");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("013");
			network.setName("Videocon");
			network.setIsFixed("false");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A089B321");
			network.setMin("");
			network.setMax("");
			network.setCurrency("INR");
			h = new ArrayList<String>();
			h.add("INR 50"); h.add("INR 100"); h.add("INR 200"); h.add("INR 300");
			h.add("INR 500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 6.50"); h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.13"); cf.add("1.13"); cf.add("1.13"); cf.add("1.13");
			cf.add("1.175"); cf.add("1.165"); cf.add("1.175"); cf.add("1.165"); cf.add("1.165");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("014");
			network.setName("Virgin Mobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A089B001");
			network.setMin("");
			network.setMax("");
			network.setCurrency("INR");
			h = new ArrayList<String>();
			h.add("INR 50"); h.add("INR 100"); h.add("INR 200"); h.add("INR 300");
			h.add("INR 500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 6");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("015");
			network.setName("Uninor");
			network.setIsFixed("false");
			network.setIntlCallingCode("91");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A089B319");
			network.setMin("");
			network.setMax("");
			network.setCurrency("INR");
			h = new ArrayList<String>();
			h.add("INR 50"); h.add("INR 100"); h.add("INR 200"); h.add("INR 300");
			h.add("INR 500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 6");
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("051")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Indosat Mentari");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B3301");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			ArrayList<String> h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 25000"); h.add("IDR 50000");
			h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Indosat IM3");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B330");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 25000"); h.add("IDR 50000");
			h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Indosat Starone");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B3302");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 25000"); h.add("IDR 50000");
			h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Telkom Flexi");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B332");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 10000"); h.add("IDR 20000"); h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Telkomsel Simpati");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B3332");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 20000"); h.add("IDR 25000");
			h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Telkomsel KartuAS");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B3331");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 20000"); h.add("IDR 25000");
			h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
		    h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("007");
			network.setName("Esia Bakrie");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B328");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 25000");
			h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("008");
			network.setName("3");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B3371");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 30000");
			h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("009");
			network.setName("Axis");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B327");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 20000"); h.add("IDR 25000");
			h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("010");
			network.setName("Excelcom");
			network.setIsFixed("false");
			network.setIntlCallingCode("62");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A090B334");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IDR");
			h = new ArrayList<String>();
			h.add("IDR 5000"); h.add("IDR 10000"); h.add("IDR 25000");
			h.add("IDR 50000"); h.add("IDR 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.50"); h.add("USD 5");
			h.add("USD 10");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("052")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Asia Cell");
			network.setIsFixed("false");
			network.setIntlCallingCode("964");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A092B346");
			network.setMin("");
			network.setMax("");
			network.setCurrency("IQD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("IQD 5000"); h.add("IQD 10000"); h.add("IQD 25000"); h.add("IQD 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2.5"); h.add("USD 5"); h.add("USD 10");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.01"); cf.add("1.01"); cf.add("1.01"); cf.add("1.01");
			cf.add("1.055"); cf.add("1.045"); cf.add("1.055"); cf.add("1.045"); cf.add("1.045");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("053")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MaxRoam");
			network.setIsFixed("false");
			network.setIntlCallingCode("");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("");
			network.setMin("");
			network.setMax("");
			network.setCurrency("EUR");
			ArrayList<String> h = new ArrayList<String>();
			h.add("EUR 10"); h.add("EUR 30"); h.add("EUR 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12.50"); h.add("USD 37.50"); h.add("USD 68.75");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("054")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("225");
			network.setPhoneNumberLenght("9");
			network.setCurrency("XOF");
			network.setTopUpID("A044B163");
			network.setMin("1000.00");
			network.setMax("40000.00");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("225");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A044B164");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 5900"); h.add("XOF 11800"); h.add("XOF 23600");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23");
			h.add("USD 46");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.81"); cf.add("0.81"); cf.add("0.81"); cf.add("0.81");
			cf.add("0.855"); cf.add("0.845"); cf.add("0.855"); cf.add("0.845"); cf.add("0.845");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("055")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("1876");
			network.setPhoneNumberLenght("8");
			network.setCurrency("JMD");
			network.setTopUpID("A097B365");
			network.setMin("427.365");
			network.setMax("5555.745");
			network.setUSDMin("5.00");
			network.setUSDMax("65.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1876");
			network.setPhoneNumberLenght("8");
			network.setCurrency("JMD");
			network.setTopUpID("A097B363");
			network.setMin("341.892");
			network.setMax("6410.475");
			network.setUSDMin("4.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.91"); cf.add("0.91"); cf.add("0.91"); cf.add("0.91");
			cf.add("0.955"); cf.add("0.945"); cf.add("0.955"); cf.add("0.945"); cf.add("0.945");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1876");
			network.setPhoneNumberLenght("8");
			network.setCurrency("JMD");
			network.setTopUpID("A097B364");
			network.setMin("85.473");
			network.setMax("6410.475");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("056")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Umniah");
			network.setIsFixed("false");
			network.setIntlCallingCode("962");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A1002B375");
			network.setMin("");
			network.setMax("");
			network.setCurrency("JOD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("JOD 1"); h.add("JOD 2"); h.add("JOD 3"); h.add("JOD 4");
			h.add("JOD 5"); h.add("JOD 6"); h.add("JOD 7"); h.add("JOD 8");
			h.add("JOD 9"); h.add("JOD 10"); h.add("JOD 11"); h.add("JOD 12");
			h.add("JOD 13"); h.add("JOD 14"); h.add("JOD 15"); h.add("JOD 20");
			h.add("JOD 25"); h.add("JOD 30"); h.add("JOD 35");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 4"); h.add("USD 6"); h.add("USD 8");
			h.add("USD 10"); h.add("USD 12"); h.add("USD 14"); h.add("USD 16");
			h.add("USD 18"); h.add("USD 20"); h.add("USD 22"); h.add("USD 24");
			h.add("USD 26"); h.add("USD 28"); h.add("USD 30"); h.add("USD 35");
			h.add("USD 40"); h.add("USD 45"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.47"); cf.add("1.47"); cf.add("1.47"); cf.add("1.47");
			cf.add("1.515"); cf.add("1.505"); cf.add("1.515"); cf.add("1.505"); cf.add("1.505");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("057")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Beeline");
			network.setIsFixed("false");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A101B378");
			network.setMin("");
			network.setMax("");
			network.setCurrency("KZT");
			ArrayList<String> h = new ArrayList<String>();
			h.add("KZT 150"); h.add("KZT 200"); h.add("KZT 300"); h.add("KZT 400");
			h.add("KZT 500"); h.add("KZT 1000"); h.add("KZT 2000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 1.50"); h.add("USD 2"); h.add("USD 3");
			h.add("USD 3.5"); h.add("USD 7"); h.add("USD 14");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.11"); cf.add("1.11"); cf.add("1.11"); cf.add("1.11");
			cf.add("1.155"); cf.add("1.145"); cf.add("1.155"); cf.add("1.145"); cf.add("1.145");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Activ");
			network.setIsFixed("false");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A101B377");
			network.setMin("");
			network.setMax("");
			network.setCurrency("KZT");
			h = new ArrayList<String>();
			h.add("KZT 150"); h.add("KZT 200"); h.add("KZT 300"); h.add("KZT 400");
			h.add("KZT 500"); h.add("KZT 1000"); h.add("KZT 2000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 1.50"); h.add("USD 2"); h.add("USD 3");
			h.add("USD 3.5"); h.add("USD 7"); h.add("USD 14");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.11"); cf.add("1.11"); cf.add("1.11"); cf.add("1.11");
			cf.add("1.155"); cf.add("1.145"); cf.add("1.155"); cf.add("1.145"); cf.add("1.145");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Neo");
			network.setIsFixed("false");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A101B379");
			network.setMin("");
			network.setMax("");
			network.setCurrency("KZT");
			h = new ArrayList<String>();
			h.add("KZT 150"); h.add("KZT 200"); h.add("KZT 300"); h.add("KZT 400");
			h.add("KZT 500"); h.add("KZT 1000"); h.add("KZT 2000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 1.50"); h.add("USD 2"); h.add("USD 3");
			h.add("USD 3.5"); h.add("USD 7"); h.add("USD 14");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.14"); cf.add("1.14"); cf.add("1.14"); cf.add("1.14");
			cf.add("1.185"); cf.add("1.175"); cf.add("1.185"); cf.add("1.175"); cf.add("1.175");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else{
			networks = GetNetworks2(CountryID, context);
		}
		
		return networks;
	}

	public static ArrayList<Network> GetNetworks2(String CountryID, Context context){
		
		networks = new ArrayList<Network>();
		Network network = new Network();
		network.setNetworkID("000");
		network.setName(context.getString(R.string.netOperator));
		network.setIsFixed("");
		network.setMin("");
		network.setMax("");
		networks.add(network);
		
		if(CountryID.equals("058")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Airtel");
			network.setIsFixed("false");
			network.setIntlCallingCode("254");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A102B383");
			network.setMin("");
			network.setMax("");
			network.setCurrency("KES");
			ArrayList<String> h = new ArrayList<String>();
			h.add("KES 100"); h.add("KES 130"); h.add("KES 250"); h.add("KES 300");
			h.add("KES 400"); h.add("KES 600"); h.add("KES 800"); h.add("KES 900");
			h.add("KES 1100"); h.add("KES 1200"); h.add("KES 1500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 6"); h.add("USD 8"); h.add("USD 10"); h.add("USD 12");
			h.add("USD 14"); h.add("USD 16");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Yu");
			network.setIsFixed("false");
			network.setIntlCallingCode("254");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A102B385");
			network.setMin("");
			network.setMax("");
			network.setCurrency("KES");
			h = new ArrayList<String>();
			h.add("KES 100"); h.add("KES 130"); h.add("KES 250"); h.add("KES 300");
			h.add("KES 400"); h.add("KES 600"); h.add("KES 800"); h.add("KES 900");
			h.add("KES 1100"); h.add("KES 1200"); h.add("KES 1500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 6"); h.add("USD 8"); h.add("USD 10"); h.add("USD 12");
			h.add("USD 14"); h.add("USD 16"); h.add("USD 18");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.02"); cf.add("1.02"); cf.add("1.02"); cf.add("1.02");
			cf.add("1.065"); cf.add("1.055"); cf.add("1.065"); cf.add("1.055"); cf.add("1.055");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Safaricom");
			network.setIsFixed("false");
			network.setIntlCallingCode("254");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A102B382");
			network.setMin("");
			network.setMax("");
			network.setCurrency("KES");
			h = new ArrayList<String>();
			h.add("KES 100"); h.add("KES 130"); h.add("KES 250"); h.add("KES 300");
			h.add("KES 400"); h.add("KES 600"); h.add("KES 800"); h.add("KES 900");
			h.add("KES 1100"); h.add("KES 1200"); h.add("KES 1500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 6"); h.add("USD 8"); h.add("USD 10"); h.add("USD 12");
			h.add("USD 14"); h.add("USD 16"); h.add("USD 18");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.05"); cf.add("1.05"); cf.add("1.05"); cf.add("1.05");
			cf.add("1.095"); cf.add("1.085"); cf.add("1.095"); cf.add("1.085"); cf.add("1.085");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("059")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Beeline");
			network.setIsFixed("false");
			network.setIntlCallingCode("856");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A107B404");
			network.setMin("");
			network.setMax("");
			network.setCurrency("LAK");
			ArrayList<String> h = new ArrayList<String>();
			h.add("LAK 5000"); h.add("LAK 10000"); h.add("LAK 20000"); h.add("LAK 50000");
			h.add("LAK 100000"); h.add("LAK 200000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 8");
			h.add("USD 12"); h.add("USD 24");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("060")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Cellcom");
			network.setIsFixed("true");
			network.setIntlCallingCode("231");
			network.setPhoneNumberLenght("10");
			network.setCurrency("LRD");
			network.setTopUpID("A111B418");
			network.setMin("200");
			network.setMax("4000");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Lonestar");
			network.setIsFixed("true");
			network.setIntlCallingCode("231");
			network.setPhoneNumberLenght("10");
			network.setCurrency("LRD");
			network.setTopUpID("A111B001");
			network.setMin("200");
			network.setMax("4000");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("231");
			network.setPhoneNumberLenght("10");
			network.setCurrency("LRD");
			network.setTopUpID("A111B419");
			network.setMin("200");
			network.setMax("4000");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("061")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Tele2");
			network.setIsFixed("true");
			network.setIntlCallingCode("370");
			network.setPhoneNumberLenght("11");
			network.setCurrency("LTL");
			network.setTopUpID("A114B429");
			network.setMin("10");
			network.setMax("100");
			network.setUSDMin("5.00");
			network.setUSDMax("50.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("062")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("261");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A118B440");
			network.setMin("");
			network.setMax("");
			network.setCurrency("MGA");
			ArrayList<String> h = new ArrayList<String>();
			h.add("MGA 20000"); h.add("MGA 40000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23.00"); h.add("USD 46.00");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.83"); cf.add("0.83"); cf.add("0.83"); cf.add("0.83");
			cf.add("0.875"); cf.add("0.865"); cf.add("0.875"); cf.add("0.865"); cf.add("0.865");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("063")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Celcom");
			network.setIsFixed("false");
			network.setIntlCallingCode("60");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A120B449");
			network.setMin("");
			network.setMax("");
			network.setCurrency("MYR");
			ArrayList<String> h = new ArrayList<String>();
			h.add("MYR 10"); h.add("MYR 30"); h.add("MYR 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 12"); h.add("USD 20"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("DiGi");
			network.setIsFixed("false");
			network.setIntlCallingCode("60");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A120B450");
			network.setMin("");
			network.setMax("");
			network.setCurrency("MYR");
			h = new ArrayList<String>();
			h.add("MYR 10"); h.add("MYR 30"); h.add("MYR 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 12"); h.add("USD 20"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Maxis");
			network.setIsFixed("false");
			network.setIntlCallingCode("60");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A120B451");
			network.setMin("");
			network.setMax("");
			network.setCurrency("MYR");
			h = new ArrayList<String>();
			h.add("MYR 10"); h.add("MYR 30"); h.add("MYR 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 9"); h.add("USD 15");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.05"); cf.add("1.05"); cf.add("1.05"); cf.add("1.05");
			cf.add("1.095"); cf.add("1.085"); cf.add("1.095"); cf.add("1.085"); cf.add("1.085");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("064")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("223");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A122B457");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 6000"); h.add("XOF 12000"); h.add("XOF 24000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23.00"); h.add("USD 46.00");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.81"); cf.add("0.81"); cf.add("0.81"); cf.add("0.81");
			cf.add("0.855"); cf.add("0.845"); cf.add("0.855"); cf.add("0.845"); cf.add("0.845");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("065")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Nextel");
			network.setIsFixed("false");
			network.setIntlCallingCode("52");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A128B476");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 30"); h.add("USD 50"); h.add("USD 100"); h.add("USD 200");
			h.add("USD 500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 30"); h.add("USD 50"); h.add("USD 100"); h.add("USD 200");
			h.add("USD 500");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.2"); cf.add("1.2"); cf.add("1.2"); cf.add("1.2");
			cf.add("1.245"); cf.add("1.235"); cf.add("1.245"); cf.add("1.235"); cf.add("1.235");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("52");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A128B473");
			network.setMin("2.00");
			network.setMax("75.00");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Iusacell");
			network.setIsFixed("true");
			network.setIntlCallingCode("52");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A128B474");
			network.setMin("4.00");
			network.setMax("75.00");
			network.setUSDMin("4.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Telcel Mexico USD");
			network.setIsFixed("false");
			network.setIntlCallingCode("52");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A128B472");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 3"); h.add("USD 5"); h.add("USD 10");
			h.add("USD 15"); h.add("USD 20"); h.add("USD 30"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 3"); h.add("USD 5"); h.add("USD 10");
			h.add("USD 15"); h.add("USD 20"); h.add("USD 30"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Unefon Mexico USD");
			network.setIsFixed("false");
			network.setIntlCallingCode("52");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A128B475");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); 
			h.add("USD 30"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); 
			h.add("USD 30"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("066")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Moldcell");
			network.setIsFixed("true");
			network.setIntlCallingCode("373");
			network.setPhoneNumberLenght("11");
			network.setCurrency("MDL");
			network.setTopUpID("A130B479");
			network.setMin("50");
			network.setMax("500");
			network.setUSDMin("5.00");
			network.setUSDMax("50.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("067")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1664");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A134B490");
			network.setMin("6");
			network.setMax("200");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("068")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Maroc Telecom");
			network.setIsFixed("false");
			network.setIntlCallingCode("212");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A135B492");
			network.setMin("");
			network.setMax("");
			network.setCurrency("MAD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("MAD 10"); h.add("MAD 20"); h.add("MAD 30"); h.add("MAD 50");
			h.add("MAD 75"); h.add("MAD 100"); h.add("MAD 150"); h.add("MAD 200");
			h.add("MAD 300");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 6"); h.add("USD 8"); h.add("USD 10");
			h.add("USD 15"); h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			h.add("USD 35");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.05"); cf.add("1.05"); cf.add("1.05"); cf.add("1.05");
			cf.add("1.095"); cf.add("1.085"); cf.add("1.095"); cf.add("1.085"); cf.add("1.085");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("069")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("674");
			network.setPhoneNumberLenght("11");
			network.setCurrency("AUD");
			network.setTopUpID("A139B500");
			network.setMin("5");
			network.setMax("50");
			network.setUSDMin("5.00");
			network.setUSDMax("50.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("070")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("NCell");
			network.setIsFixed("false");
			network.setIntlCallingCode("977");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A140B501");
			network.setMin("");
			network.setMax("");
			network.setCurrency("NPR");
			ArrayList<String> h = new ArrayList<String>();
			h.add("NPR 50"); h.add("NPR 100"); h.add("NPR 200"); h.add("NPR 300");
			h.add("NPR 500"); h.add("NPR 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 4"); h.add("USD 6"); h.add("USD 8"); 
			h.add("USD 10"); h.add("USD 12");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.13"); cf.add("1.13"); cf.add("1.13"); cf.add("1.13");
			cf.add("1.175"); cf.add("1.165"); cf.add("1.175"); cf.add("1.165"); cf.add("1.165");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("NTC GSM");
			network.setIsFixed("false");
			network.setIntlCallingCode("977");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A140B502");
			network.setMin("");
			network.setMax("");
			network.setCurrency("NPR");
			h = new ArrayList<String>();
			h.add("NPR 50"); h.add("NPR 100"); h.add("NPR 200");
			h.add("NPR 500"); h.add("NPR 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 4"); h.add("USD 8"); h.add("USD 10");
			h.add("USD 12");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.09"); cf.add("1.09"); cf.add("1.09"); cf.add("1.09");
			cf.add("1.135"); cf.add("1.125"); cf.add("1.135"); cf.add("1.125"); cf.add("1.125");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("NTC CDMA");
			network.setIsFixed("false");
			network.setIntlCallingCode("977");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A140B503");
			network.setMin("");
			network.setMax("");
			network.setCurrency("NPR");
			h = new ArrayList<String>();
			h.add("NPR 200"); h.add("NPR 500"); h.add("NPR 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 6"); h.add("USD 10"); h.add("USD 12");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.09"); cf.add("1.09"); cf.add("1.09"); cf.add("1.09");
			cf.add("1.135"); cf.add("1.125"); cf.add("1.135"); cf.add("1.125"); cf.add("1.125");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("071")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("505");
			network.setPhoneNumberLenght("9");
			network.setCurrency("NIO");
			network.setTopUpID("A143B512");
			network.setMin("25");
			network.setMax("1700");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("505");
			network.setPhoneNumberLenght("9");
			network.setCurrency("NIO");
			network.setTopUpID("A143B513");
			network.setMin("115");
			network.setMax("1700");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("072")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("2279");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A144B517");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 6000"); h.add("XOF 12000"); h.add("XOF 24000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23.00"); h.add("USD 46.00");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.81"); cf.add("0.81"); cf.add("0.81"); cf.add("0.81");
			cf.add("0.855"); cf.add("0.845"); cf.add("0.855"); cf.add("0.845"); cf.add("0.845");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Airtel");
			network.setIsFixed("false");
			network.setIntlCallingCode("2279");
			network.setPhoneNumberLenght("9");
			network.setTopUpID("A144B514");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			h = new ArrayList<String>();
			h.add("XOF 260"); h.add("XOF 520"); h.add("XOF 1050");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23.00"); h.add("USD 46.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("073")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Airtel");
			network.setIsFixed("true");
			network.setIntlCallingCode("234");
			network.setPhoneNumberLenght("11");
			network.setCurrency("NGN");
			network.setTopUpID("A145B520");
			network.setMin("400");
			network.setMax("1000000");
			network.setUSDMin("2.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Etisalat");
			network.setIsFixed("true");
			network.setIntlCallingCode("234");
			network.setPhoneNumberLenght("11");
			network.setCurrency("NGN");
			network.setTopUpID("A145B001");
			network.setMin("400");
			network.setMax("1000000");
			network.setUSDMin("4.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Glo");
			network.setIsFixed("true");
			network.setIntlCallingCode("234");
			network.setPhoneNumberLenght("11");
			network.setCurrency("NGN");
			network.setTopUpID("A145B519");
			network.setMin("400");
			network.setMax("1000000");
			network.setUSDMin("4.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("234");
			network.setPhoneNumberLenght("11");
			network.setCurrency("NGN");
			network.setTopUpID("A145B518");
			network.setMin("400");
			network.setMax("1000000");
			network.setUSDMin("3.00");
			network.setUSDMax("100.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("074")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Telenor");
			network.setIsFixed("true");
			network.setIntlCallingCode("92");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PKR");
			network.setTopUpID("A152B539");
			network.setMin("90");
			network.setMax("6800");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Jazz");
			network.setIsFixed("true");
			network.setIntlCallingCode("92");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PKR");
			network.setTopUpID("A152B543");
			network.setMin("90");
			network.setMax("6800");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Mobilink");
			network.setIsFixed("false");
			network.setIntlCallingCode("92");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A152B538");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PKR");
			ArrayList<String> h = new ArrayList<String>();
			h.add("PKR 100"); h.add("PKR 150"); h.add("PKR 250"); h.add("PKR 500");
			h.add("PKR 1000"); h.add("PKR 1500"); h.add("PKR 2000"); h.add("PKR 2500");
			h.add("PKR 3000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3.75"); h.add("USD 5.75"); h.add("USD 10.75"); h.add("USD 15.75");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Ufone");
			network.setIsFixed("true");
			network.setIntlCallingCode("92");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A152B540");
			network.setMin("90");
			network.setMax("6800");
			network.setCurrency("PKR");
			network.setUSDMin("1");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Warid");
			network.setIsFixed("true");
			network.setIntlCallingCode("92");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A152B541");
			network.setMin("90");
			network.setMax("6800");
			network.setCurrency("PKR");
			network.setUSDMin("5");
			network.setUSDMax("70");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Zong");
			network.setIsFixed("true");
			network.setIntlCallingCode("92");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PKR");
			network.setTopUpID("A152B542");
			network.setMin("90");
			network.setMax("6800");
			network.setUSDMin("");
			network.setUSDMax("");
			network.setIsUSDDenom("true");
			h = new ArrayList<String>();
			h.add("USD 4.55"); h.add("USD 7.25"); h.add("USD 12.55"); h.add("USD 17.00");
			h.add("USD 21.00");
			network.setUSDDenominations(h);
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("075")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Wataniya");
			network.setIsFixed("false");
			network.setIntlCallingCode("970");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A153B545");
			network.setMin("");
			network.setMax("");
			network.setCurrency("ILS");
			ArrayList<String> h = new ArrayList<String>();
			h.add("ILS 15"); h.add("ILS 25"); h.add("ILS 50"); h.add("ILS 100");
			h.add("ILS 200");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20"); h.add("USD 30"); h.add("USD 40");
			h.add("USD 50");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.08"); cf.add("1.08"); cf.add("1.08"); cf.add("1.08");
			cf.add("1.125"); cf.add("1.115"); cf.add("1.125"); cf.add("1.115"); cf.add("1.115");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("076")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("507");
			network.setPhoneNumberLenght("9");
			network.setCurrency("PAB");
			network.setTopUpID("A154B549");
			network.setMin("5");
			network.setMax("70");
			network.setUSDMin("3.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("507");
			network.setPhoneNumberLenght("9");
			network.setCurrency("PAB");
			network.setTopUpID("A154B547");
			network.setMin("5");
			network.setMax("70");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("077")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("675");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PGK");
			network.setTopUpID("A155B550");
			network.setMin("10");
			network.setMax("140");
			network.setUSDMin("5.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("078")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Personal");
			network.setIsFixed("true");
			network.setIntlCallingCode("595");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PYG");
			network.setTopUpID("A156B553");
			network.setMin("15000");
			network.setMax("300000");
			network.setUSDMin("3.00");
			network.setUSDMax("70.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Tigo");
			network.setIsFixed("true");
			network.setIntlCallingCode("595");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PYG");
			network.setTopUpID("A156B552");
			network.setMin("15000");
			network.setMax("300000");
			network.setUSDMin("3.00");
			network.setUSDMax("70.00");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("VOX");
			network.setIsFixed("true");
			network.setIntlCallingCode("595");
			network.setPhoneNumberLenght("11");
			network.setCurrency("PYG");
			network.setTopUpID("A156B555");
			network.setMin("15000");
			network.setMax("300000");
			network.setUSDMin("3.00");
			network.setUSDMax("70.00");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.9675"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("079")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("true");
			network.setIntlCallingCode("51");
			network.setPhoneNumberLenght("10");
			network.setCurrency("PEN");
			network.setTopUpID("A157B001");
			network.setMin("3");
			network.setMax("200");
			network.setUSDMin("1.00");
			network.setUSDMax("75.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("America Movil");
			network.setIsFixed("true");
			network.setIntlCallingCode("51");
			network.setPhoneNumberLenght("10");
			network.setCurrency("PEN");
			network.setTopUpID("A157B002");
			network.setMin("15");
			network.setMax("200");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("51");
			network.setPhoneNumberLenght("10");
			network.setCurrency("PEN");
			network.setTopUpID("A157B556");
			network.setMin("15");
			network.setMax("200");
			network.setUSDMin("5.00");
			network.setUSDMax("75.00");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("080")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Globe");
			network.setIsFixed("false");
			network.setIntlCallingCode("63");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A158B560");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PHP");
			ArrayList<String> h = new ArrayList<String>();
			h.add("PHP 150"); h.add("PHP 300"); h.add("PHP 500"); h.add("PHP 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 5"); h.add("USD 10");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Smart");
			network.setIsFixed("false");
			network.setIntlCallingCode("63");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A158B559");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PHP");
			h = new ArrayList<String>();
			h.add("PHP 200"); h.add("PHP 300"); h.add("PHP 500"); h.add("PHP 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 7"); h.add("USD 12"); h.add("USD 27");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.97"); cf.add("0.97"); cf.add("0.97"); cf.add("0.97");
			cf.add("1.015"); cf.add("1.005"); cf.add("1.015"); cf.add("1.005"); cf.add("1.005");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Sun Cellular");
			network.setIsFixed("false");
			network.setIntlCallingCode("63");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A158B561");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PHP");
			h = new ArrayList<String>();
			h.add("PHP 150"); h.add("PHP 300"); h.add("PHP 500"); h.add("PHP 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 4"); h.add("USD 7"); h.add("USD 12"); h.add("USD 27");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Smart Talk n Text");
			network.setIsFixed("false");
			network.setIntlCallingCode("63");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A158B563");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PHP");
			h = new ArrayList<String>();
			h.add("PHP 60"); h.add("PHP 100"); h.add("PHP 200"); h.add("PHP 300");
			h.add("PHP 500"); h.add("PHP 1000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 4"); h.add("USD 8"); h.add("USD 10");
			h.add("USD 15"); h.add("USD 20");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("081")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Plus");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B566");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			ArrayList<String> h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22"); h.add("PLN 25");
			h.add("PLN 40"); h.add("PLN 43"); h.add("PLN 50"); h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.99"); cf.add("0.99"); cf.add("0.99"); cf.add("0.99");
			cf.add("1.035"); cf.add("1.025"); cf.add("1.035"); cf.add("1.025"); cf.add("1.025");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B564");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 25"); h.add("PLN 40"); h.add("PLN 50");
			h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.99"); cf.add("0.99"); cf.add("0.99"); cf.add("0.99");
			cf.add("1.035"); cf.add("1.025"); cf.add("1.035"); cf.add("1.025"); cf.add("1.025");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Tak Tak");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B572");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22"); h.add("PLN 25");
			h.add("PLN 40"); h.add("PLN 43"); h.add("PLN 50"); h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15"); h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.99"); cf.add("0.99"); cf.add("0.99"); cf.add("0.99");
			cf.add("1.035"); cf.add("1.025"); cf.add("1.035"); cf.add("1.025"); cf.add("1.025");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Heyah");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B570");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22"); h.add("PLN 25");
			h.add("PLN 40"); h.add("PLN 43"); h.add("PLN 50"); h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15"); h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.99"); cf.add("0.99"); cf.add("0.99"); cf.add("0.99");
			cf.add("1.035"); cf.add("1.025"); cf.add("1.035"); cf.add("1.025"); cf.add("1.025");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Sami Swoi");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B571");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22"); h.add("PLN 25");
			h.add("PLN 40"); h.add("PLN 43");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1"); cf.add("1"); cf.add("1"); cf.add("1");
			cf.add("1.045"); cf.add("1.035"); cf.add("1.045"); cf.add("1.035"); cf.add("1.035");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Play");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B565");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22"); h.add("PLN 25");
			h.add("PLN 40"); h.add("PLN 43"); h.add("PLN 50"); h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15"); h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("007");
			network.setName("GGAir");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B569");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22");
			h.add("PLN 43"); h.add("PLN 50"); h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.99"); cf.add("0.99"); cf.add("0.99"); cf.add("0.99");
			cf.add("1.035"); cf.add("1.025"); cf.add("1.035"); cf.add("1.025"); cf.add("1.025");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("008");
			network.setName("Diallo");
			network.setIsFixed("false");
			network.setIntlCallingCode("48");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A159B568");
			network.setMin("");
			network.setMax("");
			network.setCurrency("PLN");
			h = new ArrayList<String>();
			h.add("PLN 10"); h.add("PLN 11"); h.add("PLN 22"); h.add("PLN 25");
			h.add("PLN 40"); h.add("PLN 43"); h.add("PLN 50"); h.add("PLN 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15"); h.add("USD 18"); h.add("USD 20"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1"); cf.add("1"); cf.add("1"); cf.add("1");
			cf.add("1.045"); cf.add("1.035"); cf.add("1.045"); cf.add("1.035"); cf.add("1.035");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("082")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Claro");
			network.setIsFixed("false");
			network.setIntlCallingCode("40");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A161B578");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			h.add("USD 60");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			h.add("USD 60");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("083")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Vodafone");
			network.setIsFixed("false");
			network.setIntlCallingCode("40");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A164B591");
			network.setMin("");
			network.setMax("");
			network.setCurrency("EUR");
			ArrayList<String> h = new ArrayList<String>();
			h.add("EUR 5"); h.add("EUR 10"); h.add("EUR 20"); h.add("EUR 30");
			h.add("EUR 40"); h.add("EUR 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 6"); h.add("USD 12"); h.add("USD 24"); h.add("USD 36");
			h.add("USD 48"); h.add("USD 60");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("40");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A164B590");
			network.setMin("");
			network.setMax("");
			network.setCurrency("EUR");
			h = new ArrayList<String>();
			h.add("EUR 5"); h.add("EUR 10"); h.add("EUR 20"); h.add("EUR 30");
			h.add("EUR 40"); h.add("EUR 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 6"); h.add("USD 12"); h.add("USD 24"); h.add("USD 30");
			h.add("USD 48"); h.add("USD 60");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("084")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Megafon");
			network.setIsFixed("true");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setCurrency("RUB");
			network.setTopUpID("A165B593");
			network.setMin("15");
			network.setMax("2050");
			network.setUSDMin("2");
			network.setUSDMax("70");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Tele 2");
			network.setIsFixed("true");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setCurrency("RUB");
			network.setTopUpID("A165B600");
			network.setMin("15");
			network.setMax("2050");
			network.setUSDMin("2");
			network.setUSDMax("70");
			cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("MTS");
			network.setIsFixed("true");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setCurrency("RUB");
			network.setTopUpID("A165B594");
			network.setMin("15");
			network.setMax("2050");
			network.setUSDMin("2");
			network.setUSDMax("70");
			cf = new ArrayList<String>();
			cf.add("0.98"); cf.add("0.98"); cf.add("0.98"); cf.add("0.98");
			cf.add("1.025"); cf.add("1.015"); cf.add("1.025"); cf.add("1.015"); cf.add("1.015");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Beeline");
			network.setIsFixed("true");
			network.setIntlCallingCode("7");
			network.setPhoneNumberLenght("11");
			network.setCurrency("RUB");
			network.setTopUpID("A165B592");
			network.setMin("15");
			network.setMax("2050");
			network.setUSDMin("2");
			network.setUSDMax("70");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("085")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("250");
			network.setPhoneNumberLenght("10");
			network.setCurrency("RWF");
			network.setTopUpID("A166B635");
			network.setMin("500");
			network.setMax("40000");
			network.setUSDMin("1.00");
			network.setUSDMax("100.00");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("086")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("685");
			network.setPhoneNumberLenght("11");
			network.setCurrency("XCD");
			network.setTopUpID("A167B640");
			network.setMin("10");
			network.setMax("200");
			network.setUSDMin("5");
			network.setUSDMax("70");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("087")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("221");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A171B647");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("XOF 4920"); h.add("XOF 9840");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.825"); cf.add("0.825"); cf.add("0.825"); cf.add("0.825");
			cf.add("0.87"); cf.add("0.86"); cf.add("0.87"); cf.add("0.86"); cf.add("0.86");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Tigo");
			network.setIsFixed("false");
			network.setIntlCallingCode("221");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A171B648");
			network.setMin("");
			network.setMax("");
			network.setCurrency("XOF");
			h = new ArrayList<String>();
			h.add("XOF 500"); h.add("XOF 900"); h.add("XOF 1000"); h.add("XOF 2000");
			h.add("XOF 2500"); h.add("XOF 2600"); h.add("XOF 2700"); h.add("XOF 3900");
			h.add("XOF 4000"); h.add("XOF 4150"); h.add("XOF 4200"); h.add("XOF 4400");
			h.add("XOF 5000"); h.add("XOF 5400"); h.add("XOF 5580"); h.add("XOF 6000");
			h.add("XOF 6300"); h.add("XOF 8400"); h.add("XOF 8500"); h.add("XOF 8800");
			h.add("XOF 9840"); h.add("XOF 10000"); h.add("XOF 20000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 5");
			h.add("USD 10"); h.add("USD 20"); h.add("USD 30"); h.add("USD 40");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("088")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("NationLink Mogadishu");
			network.setIsFixed("false");
			network.setIntlCallingCode("252");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A178B001");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.01"); cf.add("1.01"); cf.add("1.01"); cf.add("1.01");
			cf.add("1.055"); cf.add("1.045"); cf.add("1.055"); cf.add("1.045"); cf.add("1.045");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("NationLink Puntland");
			network.setIsFixed("false");
			network.setIntlCallingCode("252");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A178B002");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.01"); cf.add("1.01"); cf.add("1.01"); cf.add("1.01");
			cf.add("1.055"); cf.add("1.045"); cf.add("1.055"); cf.add("1.045"); cf.add("1.045");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("089")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("27");
			network.setPhoneNumberLenght("10");
			network.setCurrency("ZAR");
			network.setTopUpID("A179B674");
			network.setMin("80");
			network.setMax("1000");
			network.setUSDMin("1");
			network.setUSDMax("100");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("090")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B688");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Vodafone");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B689");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Orange");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B690");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Yoigo");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B691");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Carrefour");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B692");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Lebara");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B693");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("007");
			network.setName("MasMovil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B694");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("008");
			network.setName("Euskaltel");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B695");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("009");
			network.setName("DigiMobil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B696");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("010");
			network.setName("SimYo");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B697");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("011");
			network.setName("Orbitel Movil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B698");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("012");
			network.setName("LlamaYa");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B699");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("013");
			network.setName("Hits Mobile");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B700");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("014");
			network.setName("Hond Da Mobile");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B701");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("013");
			network.setName("Talk da Movil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B702");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("014");
			network.setName("Mondi Movil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B703");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("015");
			network.setName("Habla Facil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B704");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("016");
			network.setName("Cellular Line Movil");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B705");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("017");
			network.setName("Blau");
			network.setIsFixed("true");
			network.setIntlCallingCode("34");
			network.setPhoneNumberLenght("11");
			network.setCurrency("EUR");
			network.setTopUpID("A182B706");
			network.setMin("5");
			network.setMax("60");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("091")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Airtel");
			network.setIsFixed("true");
			network.setIntlCallingCode("94");
			network.setPhoneNumberLenght("11");
			network.setCurrency("LKR");
			network.setTopUpID("A183B710");
			network.setMin("150");
			network.setMax("9000");
			network.setUSDMin("3");
			network.setUSDMax("75");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Dialog");
			network.setIsFixed("true");
			network.setIntlCallingCode("94");
			network.setPhoneNumberLenght("11");
			network.setCurrency("LKR");
			network.setTopUpID("A183B707");
			network.setMin("150");
			network.setMax("9000");
			network.setUSDMin("3");
			network.setUSDMax("70");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Etisalat");
			network.setIsFixed("true");
			network.setIntlCallingCode("94");
			network.setPhoneNumberLenght("11");
			network.setCurrency("LKR");
			network.setTopUpID("A183B709");
			network.setMin("150");
			network.setMax("9000");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Hutch");
			network.setIsFixed("true");
			network.setIntlCallingCode("94");
			network.setPhoneNumberLenght("11");
			network.setCurrency("LKR");
			network.setTopUpID("A183B711");
			network.setMin("150");
			network.setMax("9000");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Mobitel");
			network.setIsFixed("true");
			network.setIntlCallingCode("94");
			network.setPhoneNumberLenght("11");
			network.setCurrency("LKR");
			network.setTopUpID("A183B708");
			network.setMin("150");
			network.setMax("9000");
			network.setUSDMin("3");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("092")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1869");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A184B714");
			network.setMin("12");
			network.setMax("180");
			network.setUSDMin("4");
			network.setUSDMax("70");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1869");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A184B713");
			network.setMin("6");
			network.setMax("200");
			network.setUSDMin("2");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("093")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1758");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A185B717");
			network.setMin("12");
			network.setMax("200");
			network.setUSDMin("4");
			network.setUSDMax("75");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1758");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A185B716");
			network.setMin("6");
			network.setMax("200");
			network.setUSDMin("2");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("094")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1784");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A186B719");
			network.setMin("12");
			network.setMax("180");
			network.setUSDMin("4");
			network.setUSDMax("75");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1784");
			network.setPhoneNumberLenght("8");
			network.setCurrency("XCD");
			network.setTopUpID("A186B718");
			network.setMin("6");
			network.setMax("200");
			network.setUSDMin("2");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("095")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("249");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A181B684");
			network.setMin("10");
			network.setMax("70");
			network.setUSDMin("10");
			network.setUSDMax("70");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("096")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("597");
			network.setPhoneNumberLenght("8");
			network.setCurrency("SRD");
			network.setTopUpID("A188B725");
			network.setMin("7");
			network.setMax("227");
			network.setUSDMin("2");
			network.setUSDMax("70");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.93"); cf.add("0.93"); cf.add("0.93"); cf.add("0.93");
			cf.add("0.975"); cf.add("0.965"); cf.add("0.975"); cf.add("0.965"); cf.add("0.965");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("097")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("268");
			network.setPhoneNumberLenght("9");
			network.setCurrency("SZL");
			network.setTopUpID("A189B727");
			network.setMin("5");
			network.setMax("500");
			network.setUSDMin("1");
			network.setUSDMax("100");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("098")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("963");
			network.setPhoneNumberLenght("10");
			network.setCurrency("SYP");
			network.setTopUpID("A192B738");
			network.setMin("40");
			network.setMax("1950");
			network.setUSDMin("1");
			network.setUSDMax("100");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("099")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Zantel");
			network.setIsFixed("false");
			network.setIntlCallingCode("255");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A195B760");
			network.setMin("");
			network.setMax("");
			network.setCurrency("TZS");
			ArrayList<String> h = new ArrayList<String>();
			h.add("TZS 500"); h.add("TZS 1000"); h.add("TZS 2000"); h.add("TZS 3000");
			h.add("TZS 5000"); h.add("TZS 7000"); h.add("TZS 10000"); h.add("TZS 20000");
			h.add("TZS 50000"); h.add("TZS 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 8");
			h.add("USD 16"); h.add("USD 32"); h.add("USD 64");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.15"); cf.add("1.15"); cf.add("1.15"); cf.add("1.15");
			cf.add("1.195"); cf.add("1.185"); cf.add("1.195"); cf.add("1.185"); cf.add("1.185");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Vodacom");
			network.setIsFixed("false");
			network.setIntlCallingCode("255");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A195B757");
			network.setMin("");
			network.setMax("");
			network.setCurrency("TZS");
			h = new ArrayList<String>();
			h.add("TZS 500"); h.add("TZS 1000"); h.add("TZS 2000"); h.add("TZS 3000");
			h.add("TZS 5000"); h.add("TZS 7000"); h.add("TZS 10000"); h.add("TZS 20000");
			h.add("TZS 50000"); h.add("TZS 100000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 4"); h.add("USD 8");
			h.add("USD 16"); h.add("USD 32"); h.add("USD 64");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.15"); cf.add("1.15"); cf.add("1.15"); cf.add("1.15");
			cf.add("1.195"); cf.add("1.185"); cf.add("1.195"); cf.add("1.185"); cf.add("1.185");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("100")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("AIS");
			network.setIsFixed("false");
			network.setIntlCallingCode("66");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A197B769");
			network.setMin("");
			network.setMax("");
			network.setCurrency("THB");
			ArrayList<String> h = new ArrayList<String>();
			h.add("THB 50"); h.add("THB 100"); h.add("THB 300"); h.add("THB 500");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 2"); h.add("USD 4"); h.add("USD 8"); h.add("USD 16");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.11"); cf.add("1.11"); cf.add("1.11"); cf.add("1.11");
			cf.add("1.155"); cf.add("1.145"); cf.add("1.155"); cf.add("1.145"); cf.add("1.145");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("101")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("963");
			network.setPhoneNumberLenght("10");
			network.setCurrency("USD");
			network.setTopUpID("A200B783");
			network.setMin("4");
			network.setMax("75");
			network.setUSDMin("4");
			network.setUSDMax("75");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("102")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1868");
			network.setPhoneNumberLenght("8");
			network.setCurrency("TTD");
			network.setTopUpID("A201B786");
			network.setMin("15");
			network.setMax("470");
			network.setUSDMin("2");
			network.setUSDMax("75");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("BMobile");
			network.setIsFixed("true");
			network.setIntlCallingCode("1868");
			network.setPhoneNumberLenght("8");
			network.setCurrency("TTD");
			network.setTopUpID("A201B785");
			network.setMin("40");
			network.setMax("470");
			network.setUSDMin("5");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.94"); cf.add("0.94"); cf.add("0.94"); cf.add("0.94");
			cf.add("0.985"); cf.add("0.975"); cf.add("0.985"); cf.add("0.975"); cf.add("0.975");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("103")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("216");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A202B789");
			network.setMin("");
			network.setMax("");
			network.setCurrency("TND");
			ArrayList<String> h = new ArrayList<String>();
			h.add("TND 15"); h.add("TND 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.5"); h.add("USD 23"); h.add("USD 46");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Tunisiana");
			network.setIsFixed("false");
			network.setIntlCallingCode("216");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A202B788");
			network.setMin("");
			network.setMax("");
			network.setCurrency("TND");
			h = new ArrayList<String>();
			h.add("TND 5"); h.add("TND 7"); h.add("TND 10"); h.add("TND 13");
			h.add("TND 14"); h.add("TND 15"); h.add("TND 23"); h.add("TND 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 5"); h.add("USD 6"); h.add("USD 8");
			h.add("USD 10"); h.add("USD 12"); h.add("USD 16"); h.add("USD 20");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("104")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Vodafone");
			network.setIsFixed("false");
			network.setIntlCallingCode("90");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A203B791");
			network.setMin("");
			network.setMax("");
			network.setCurrency("TRY");
			ArrayList<String> h = new ArrayList<String>();
			h.add("TRY 5"); h.add("TRY 6"); h.add("TRY 10"); h.add("TRY 12");
			h.add("TRY 18"); h.add("TRY 20"); h.add("TRY 30"); h.add("TRY 40");
			h.add("TRY 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 3"); h.add("USD 6"); h.add("USD 9"); h.add("USD 12");
			h.add("USD 15"); h.add("USD 18"); h.add("USD 20"); h.add("USD 25");
			h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.03"); cf.add("1.03"); cf.add("1.03"); cf.add("1.03");
			cf.add("1.075"); cf.add("1.065"); cf.add("1.075"); cf.add("1.065"); cf.add("1.065");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("105")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Digicel");
			network.setIsFixed("true");
			network.setIntlCallingCode("1649");
			network.setPhoneNumberLenght("8");
			network.setCurrency("TTD");
			network.setTopUpID("A205B797");
			network.setMin("40");
			network.setMax("470");
			network.setUSDMin("4");
			network.setUSDMax("70");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Lime");
			network.setIsFixed("true");
			network.setIntlCallingCode("1649");
			network.setPhoneNumberLenght("8");
			network.setCurrency("TTD");
			network.setTopUpID("A205B798");
			network.setMin("40");
			network.setMax("470");
			network.setUSDMin("5");
			network.setUSDMax("75");
			cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("106")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Warid");
			network.setIsFixed("true");
			network.setIntlCallingCode("256");
			network.setPhoneNumberLenght("10");
			network.setCurrency("UGX");
			network.setTopUpID("A207B803");
			network.setMin("500");
			network.setMax("200000");
			network.setUSDMin("1");
			network.setUSDMax("100");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Orange");
			network.setIsFixed("true");
			network.setIntlCallingCode("256");
			network.setPhoneNumberLenght("10");
			network.setCurrency("UGX");
			network.setTopUpID("A207B804");
			network.setMin("500");
			network.setMax("200000");
			network.setUSDMin("1");
			network.setUSDMax("100");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("256");
			network.setPhoneNumberLenght("10");
			network.setCurrency("UGX");
			network.setTopUpID("A207B800");
			network.setMin("500");
			network.setMax("200000");
			network.setUSDMin("1");
			network.setUSDMax("100");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("107")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTS");
			network.setIsFixed("false");
			network.setIntlCallingCode("380");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A208B807");
			network.setMin("");
			network.setMax("");
			network.setCurrency("UAH");
			ArrayList<String> h = new ArrayList<String>();
			h.add("UAH 5"); h.add("UAH 10"); h.add("UAH 15"); h.add("UAH 20");
			h.add("UAH 25"); h.add("UAH 30"); h.add("UAH 35"); h.add("UAH 40");
			h.add("UAH 45"); h.add("UAH 50"); h.add("UAH 55"); h.add("UAH 60");
			h.add("UAH 65"); h.add("UAH 70"); h.add("UAH 75"); h.add("UAH 80");
			h.add("UAH 85"); h.add("UAH 90"); h.add("UAH 95"); h.add("UAH 100");
			h.add("UAH 125"); h.add("UAH 150"); h.add("UAH 200"); h.add("UAH 250");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 5"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.12"); cf.add("1.12"); cf.add("1.12"); cf.add("1.12");
			cf.add("1.165"); cf.add("1.155"); cf.add("1.165"); cf.add("1.155"); cf.add("1.155");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Beeline");
			network.setIsFixed("false");
			network.setIntlCallingCode("380");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A208B808");
			network.setMin("");
			network.setMax("");
			network.setCurrency("UAH");
			h = new ArrayList<String>();
			h.add("UAH 5"); h.add("UAH 10"); h.add("UAH 15"); h.add("UAH 20");
			h.add("UAH 25"); h.add("UAH 30"); h.add("UAH 35"); h.add("UAH 40");
			h.add("UAH 45"); h.add("UAH 50"); h.add("UAH 55"); h.add("UAH 60");
			h.add("UAH 65"); h.add("UAH 70"); h.add("UAH 75"); h.add("UAH 80");
			h.add("UAH 85"); h.add("UAH 90"); h.add("UAH 95"); h.add("UAH 100");
			h.add("UAH 125"); h.add("UAH 150"); h.add("UAH 200"); h.add("UAH 250");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 5"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.12"); cf.add("1.12"); cf.add("1.12"); cf.add("1.12");
			cf.add("1.165"); cf.add("1.155"); cf.add("1.165"); cf.add("1.155"); cf.add("1.155");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("108")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Airvoice");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B002");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20"); h.add("USD 30"); h.add("USD 35");
			h.add("USD 40"); h.add("USD 50"); h.add("USD 60");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20"); h.add("USD 30"); h.add("USD 35");
			h.add("USD 40"); h.add("USD 50"); h.add("USD 60");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Alltel");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B001");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); h.add("USD 25");
			h.add("USD 35"); h.add("USD 40"); h.add("USD 45"); h.add("USD 50");
			h.add("USD 55"); h.add("USD 60");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); h.add("USD 25");
			h.add("USD 30"); h.add("USD 40"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("ATT");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A211B003");
			network.setMin("15");
			network.setMax("100");
			network.setUSDMin("15");
			network.setUSDMax("100");
			cf = new ArrayList<String>();
			cf.add("0.915"); cf.add("0.915"); cf.add("0.915"); cf.add("0.915");
			cf.add("0.96"); cf.add("0.95"); cf.add("0.96"); cf.add("0.95"); cf.add("0.95");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("Boost Mobile $10-19");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A211B003");
			network.setMin("10");
			network.setMax("19");
			network.setUSDMin("10");
			network.setUSDMax("19");
			cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Boost Mobile $20-99 RTR");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A211B003");
			network.setMin("20");
			network.setMax("99");
			network.setUSDMin("20");
			network.setUSDMax("99");
			cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Cricket PayGo");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B006");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 15"); h.add("USD 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 15"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("007");
			network.setName("Express Airvoice");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B007");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20"); h.add("USD 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("008");
			network.setName("H20");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B008");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); 
			h.add("USD 50"); h.add("USD 60"); h.add("USD 100");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 25"); h.add("USD 30"); h.add("USD 40"); 
			h.add("USD 50"); h.add("USD 60"); h.add("USD 100");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("009");
			network.setName("I-Wireless");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B008");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); 
			h.add("USD 45"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); 
			h.add("USD 45"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("010");
			network.setName("Locus Platinum");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B009");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("011");
			network.setName("Movida");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B020");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 20"); h.add("USD 35"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 20"); h.add("USD 35"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("012");
			network.setName("Net 10");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B020");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 20"); h.add("USD 30"); h.add("USD 45"); h.add("USD 60");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 20"); h.add("USD 30"); h.add("USD 45"); h.add("USD 60");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("013");
			network.setName("Orange");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B010");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23"); h.add("USD 46");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.50"); h.add("USD 23"); h.add("USD 46");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("014");
			network.setName("PagePlus");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B011");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 12.00"); h.add("USD 25.00"); h.add("USD 29.95"); 
			h.add("USD 39.95"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 12.00"); h.add("USD 25.00"); h.add("USD 29.95"); 
			h.add("USD 39.95"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("015");
			network.setName("Paytoo");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B012");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 11.00"); h.add("USD 27.00"); h.add("USD 52.00"); h.add("USD 104.50"); 
			h.add("USD 154.50"); h.add("USD 204.50"); h.add("USD 254.50"); h.add("USD 504.50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 11.00"); h.add("USD 27.00"); h.add("USD 52.00"); h.add("USD 104.50"); 
			h.add("USD 154.50"); h.add("USD 204.50"); h.add("USD 254.50"); h.add("USD 504.50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("016");
			network.setName("Platinum Tel");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B022");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 20.00"); h.add("USD 50.00");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 20.00"); h.add("USD 50.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("017");
			network.setName("Powerlink Unlimited");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B023");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 20.00"); h.add("USD 30.00"); h.add("USD 50.00");
			h.add("USD 70.00"); h.add("USD 100.00");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 20.00"); h.add("USD 30.00"); h.add("USD 50.00");
			h.add("USD 70.00"); h.add("USD 100.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("018");
			network.setName("Ready Mobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B024");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 20.00"); h.add("USD 30.00");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 20.00"); h.add("USD 30.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("019");
			network.setName("Red Pocket");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B025");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 13.99"); h.add("USD 19.99"); h.add("USD 22.99");
			h.add("USD 25.00"); h.add("USD 29.99"); h.add("USD 39.99"); h.add("USD 49.99");
			h.add("USD 50.00"); h.add("USD 54.99");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 13.99"); h.add("USD 19.99"); h.add("USD 22.99");
			h.add("USD 25.00"); h.add("USD 29.99"); h.add("USD 39.99"); h.add("USD 49.99");
			h.add("USD 50.00"); h.add("USD 54.99");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("020");
			network.setName("SimpleMobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B014");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 25"); h.add("USD 40"); h.add("USD 50");
			h.add("USD 60");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 25"); h.add("USD 40"); h.add("USD 50");
			h.add("USD 60");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("021");
			network.setName("STI");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B026");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("022");
			network.setName("TC Unlimited");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B015");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 25"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 25"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("023");
			network.setName("T-Mobile");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setCurrency("USD");
			network.setTopUpID("A211B016");
			network.setMin("10");
			network.setMax("100");
			network.setUSDMin("10");
			network.setUSDMax("100");
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("024");
			network.setName("Total Call");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B027");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 5.00"); h.add("USD 10.00"); h.add("USD 25.00");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 5.00"); h.add("USD 10.00"); h.add("USD 25.00");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("025");
			network.setName("Tracfone");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B017");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 19.99"); h.add("USD 29.99"); h.add("USD 39.99"); h.add("USD 79.99");
			h.add("USD 99.99");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 19.99"); h.add("USD 29.99"); h.add("USD 39.99"); h.add("USD 79.99");
			h.add("USD 99.99");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.945"); cf.add("0.945"); cf.add("0.945"); cf.add("0.945");
			cf.add("0.99"); cf.add("0.98"); cf.add("0.99"); cf.add("0.98"); cf.add("0.98");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("026");
			network.setName("Verizon Wireless");
			network.setIsFixed("true");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B018");
			network.setMin("15");
			network.setMax("100");
			network.setCurrency("USD");
			network.setUSDMin("15");
			network.setUSDMax("100");
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("027");
			network.setName("Virgin Mobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B019");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); h.add("USD 25");
			h.add("USD 30"); h.add("USD 40"); h.add("USD 50"); h.add("USD 60");
			h.add("USD 70"); h.add("USD 90");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 15"); h.add("USD 20"); h.add("USD 25");
			h.add("USD 30"); h.add("USD 40"); h.add("USD 50"); h.add("USD 60");
			h.add("USD 70"); h.add("USD 90");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("028");
			network.setName("Xtreme");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B028");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			h.add("USD 30"); h.add("USD 50");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			h.add("USD 30"); h.add("USD 50");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("029");
			network.setName("Zapp");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A211B029");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 15.00"); h.add("USD 39.99"); h.add("USD 44.99");
			h.add("USD 49.99"); h.add("USD 59.99");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10.00"); h.add("USD 15.00"); h.add("USD 39.99"); h.add("USD 44.99");
			h.add("USD 49.99"); h.add("USD 59.99");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("109")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Movistar");
			network.setIsFixed("true");
			network.setIntlCallingCode("586");
			network.setPhoneNumberLenght("11");
			network.setCurrency("UYU");
			network.setTopUpID("A212B845");
			network.setMin("220");
			network.setMax("1500");
			network.setUSDMin("10");
			network.setUSDMax("70");
			networks.add(network);
		}
		else if(CountryID.equals("110")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Movilnet");
			network.setIsFixed("true");
			network.setIntlCallingCode("58");
			network.setPhoneNumberLenght("11");
			network.setCurrency("VEF");
			network.setTopUpID("A215B855");
			network.setMin("43");
			network.setMax("86");
			network.setUSDMin("10");
			network.setUSDMax("20");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.975"); cf.add("0.975"); cf.add("0.975"); cf.add("0.975");
			cf.add("1.02"); cf.add("1.01"); cf.add("1.02"); cf.add("1.01"); cf.add("1.01");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("Digitel");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A215B857");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VEF");
			ArrayList<String> h = new ArrayList<String>();
			h.add("VEF 43"); h.add("VEF 86");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 10"); h.add("USD 20");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.975"); cf.add("0.975"); cf.add("0.975"); cf.add("0.975");
			cf.add("1.02"); cf.add("1.01"); cf.add("1.02"); cf.add("1.01"); cf.add("1.01");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("Movistar");
			network.setIsFixed("false");
			network.setIntlCallingCode("1");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A215B856");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VEF");
			h = new ArrayList<String>();
			h.add("VEF 35");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 8");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("1.02"); cf.add("1.02"); cf.add("1.02"); cf.add("1.02");
			cf.add("1.065"); cf.add("1.055"); cf.add("1.065"); cf.add("1.055"); cf.add("1.055");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("111")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Beeline (Gtel)");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B860");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			ArrayList<String> h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 200000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("EVN");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B861");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 200000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("003");
			network.setName("MobiFone");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B862");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 200000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("004");
			network.setName("SFone");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B864");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 200000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("005");
			network.setName("Vietnam Mobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B865");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 20000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.955"); cf.add("0.955"); cf.add("0.955"); cf.add("0.955");
			cf.add("1"); cf.add("0.99"); cf.add("1"); cf.add("0.99"); cf.add("0.99");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("006");
			network.setName("Viettel Mobile");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B858");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 200000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("007");
			network.setName("VinaPhone");
			network.setIsFixed("false");
			network.setIntlCallingCode("84");
			network.setPhoneNumberLenght("11");
			network.setTopUpID("A216B859");
			network.setMin("");
			network.setMax("");
			network.setCurrency("VND");
			h = new ArrayList<String>();
			h.add("VND 100000"); h.add("VND 200000"); h.add("VND 300000"); h.add("VND 500000");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 12"); h.add("USD 18"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			cf = new ArrayList<String>();
			cf.add("0.96"); cf.add("0.96"); cf.add("0.96"); cf.add("0.96");
			cf.add("1.005"); cf.add("0.995"); cf.add("1.005"); cf.add("0.995"); cf.add("0.995");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("112")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Sabafon");
			network.setIsFixed("false");
			network.setIntlCallingCode("967");
			network.setPhoneNumberLenght("10");
			network.setTopUpID("A217B867");
			network.setMin("");
			network.setMax("");
			network.setCurrency("YER");
			ArrayList<String> h = new ArrayList<String>();
			h.add("YER 115"); h.add("YER 230"); h.add("YER 345"); h.add("YER 575");
			h.add("YER 1150"); h.add("YER 2300"); h.add("YER 3450"); h.add("YER 5750");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 5"); h.add("USD 10"); h.add("USD 15");
			h.add("USD 20"); h.add("USD 22"); h.add("USD 24"); h.add("USD 26");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("1.1"); cf.add("1.1"); cf.add("1.1"); cf.add("1.1");
			cf.add("1.145"); cf.add("1.135"); cf.add("1.145"); cf.add("1.135"); cf.add("1.135");
			network.setCoefficients(cf);
			networks.add(network);
			
			network = new Network();
			network.setNetworkID("002");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("967");
			network.setPhoneNumberLenght("10");
			network.setCurrency("YER");
			network.setTopUpID("A217B870");
			network.setMin("120");
			network.setMax("4000");
			network.setUSDMin("10");
			network.setUSDMax("100");
			cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("113")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("MTN");
			network.setIsFixed("true");
			network.setIntlCallingCode("260");
			network.setPhoneNumberLenght("10");
			network.setCurrency("ZMK");
			network.setTopUpID("A217B870");
			network.setMin("4000");
			network.setMax("400000");
			network.setUSDMin("10");
			network.setUSDMax("100");
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		else if(CountryID.equals("114")){
			
			network = new Network();
			network.setNetworkID("001");
			network.setName("Telecel");
			network.setIsFixed("false");
			network.setIntlCallingCode("263");
			network.setPhoneNumberLenght("10");
			network.setTopUpID("A219B875");
			network.setMin("");
			network.setMax("");
			network.setCurrency("USD");
			ArrayList<String> h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30");
			network.setDenominations(h);
			
			h = new ArrayList<String>();
			h.add("USD 1"); h.add("USD 2"); h.add("USD 3"); h.add("USD 4");
			h.add("USD 5"); h.add("USD 6"); h.add("USD 7"); h.add("USD 8");
			h.add("USD 9"); h.add("USD 10"); h.add("USD 15"); h.add("USD 20");
			h.add("USD 25"); h.add("USD 30");
			network.setUSDDenominations(h);
			
			ArrayList<String> cf = new ArrayList<String>();
			cf.add("0.95"); cf.add("0.95"); cf.add("0.95"); cf.add("0.95");
			cf.add("0.995"); cf.add("0.985"); cf.add("0.995"); cf.add("0.985"); cf.add("0.985");
			network.setCoefficients(cf);
			networks.add(network);
		}
		
		return networks;
	}
	
	public static String GetGatewayLocal(String currency){
		GetGateways();
		
		for(Gateway g : gateways){
			if(g.getCurrency().equals(currency))
				return g.getMinValue();
		}
		
		return "";
	}
	
	public static String GetGatewayUSD(String currency){
		GetGateways();
		
		for(Gateway g : gateways){
			if(g.getCurrency().equals(currency))
				return g.getUSDMinValue();
		}
		
		return "";
	}
	
	public static ArrayList<Gateway> GetGateways(){//int gid
		gateways = new ArrayList<Gateway>();
		
		//if(gid == 0){
			Gateway gateway = new Gateway("AFN", "500", "10"); gateways.add(gateway);
			gateway = new Gateway("AUD", "10", "10"); gateways.add(gateway);
			gateway = new Gateway("BBD", "20", "10"); gateways.add(gateway);			
			gateway = new Gateway("BDT", "820", "10"); gateways.add(gateway);			
			gateway = new Gateway("BIF", "13750", "10"); gateways.add(gateway);			
			gateway = new Gateway("BOB", "70", "10"); gateways.add(gateway);			
			gateway = new Gateway("BRL", "19", "10"); gateways.add(gateway);			
			gateway = new Gateway("BZD", "19", "10"); gateways.add(gateway);			
			gateway = new Gateway("CLP", "4800", "10"); gateways.add(gateway);			
			gateway = new Gateway("CNY", "65", "10"); gateways.add(gateway);			
			gateway = new Gateway("COP", "17600", "10"); gateways.add(gateway);			
			gateway = new Gateway("CUC", "10", "10"); gateways.add(gateway);			
			gateway = new Gateway("DOP", "390", "10"); gateways.add(gateway);			
			gateway = new Gateway("DZD", "740", "10"); gateways.add(gateway);			
			gateway = new Gateway("EGP", "60", "10"); gateways.add(gateway);			
			gateway = new Gateway("EUR", "8", "10"); gateways.add(gateway);			
			gateway = new Gateway("FJD", "18", "10"); gateways.add(gateway);			
			gateway = new Gateway("GHS", "18", "10"); gateways.add(gateway);			
			gateway = new Gateway("GMD", "300", "10"); gateways.add(gateway);			
			gateway = new Gateway("GNF", "69200", "10"); gateways.add(gateway);			
			gateway = new Gateway("GTQ", "75", "10"); gateways.add(gateway);			
			gateway = new Gateway("GYD", "2000", "10"); gateways.add(gateway);			
			gateway = new Gateway("HNL", "190", "10"); gateways.add(gateway);			
			gateway = new Gateway("HTG", "400", "10"); gateways.add(gateway);			
			gateway = new Gateway("IDR", "92000", "10"); gateways.add(gateway);
			gateway = new Gateway("ILS", "40", "10"); gateways.add(gateway);
			gateway = new Gateway("INR", "500", "10"); gateways.add(gateway);
			gateway = new Gateway("IQD", "11600", "10"); gateways.add(gateway);
			gateway = new Gateway("JMD", "850", "10"); gateways.add(gateway);			
			gateway = new Gateway("JOD", "7", "10"); gateways.add(gateway);			
			gateway = new Gateway("KES", "820", "10"); gateways.add(gateway);			
			gateway = new Gateway("KYD", "8", "10"); gateways.add(gateway);			
			gateway = new Gateway("KZT", "1450", "10"); gateways.add(gateway);			
			gateway = new Gateway("LAK", "79600", "10"); gateways.add(gateway);			
			gateway = new Gateway("LKR", "1300", "10"); gateways.add(gateway);			
			gateway = new Gateway("LRD", "735", "10"); gateways.add(gateway);			
			gateway = new Gateway("LTL", "25", "10"); gateways.add(gateway);			
			gateway = new Gateway("MAD", "85", "10"); gateways.add(gateway);			
			gateway = new Gateway("MDL", "115", "10"); gateways.add(gateway);			
			gateway = new Gateway("MGA", "20400", "10"); gateways.add(gateway);			
			gateway = new Gateway("MYR", "30", "10"); gateways.add(gateway);			
			gateway = new Gateway("NGN", "1600", "10"); gateways.add(gateway);			
			gateway = new Gateway("NIO", "230", "10"); gateways.add(gateway);			
			gateway = new Gateway("NPR", "830", "10"); gateways.add(gateway);			
			gateway = new Gateway("PEN", "26", "10"); gateways.add(gateway);			
			gateway = new Gateway("PGK", "20", "10"); gateways.add(gateway);			
			gateway = new Gateway("PHP", "450", "10"); gateways.add(gateway);			
			gateway = new Gateway("PKR", "900", "10"); gateways.add(gateway);			
			gateway = new Gateway("PLN", "35", "10"); gateways.add(gateway);			
			gateway = new Gateway("PYG", "42500", "10"); gateways.add(gateway);			
			gateway = new Gateway("RUB", "300", "10"); gateways.add(gateway);			
			gateway = new Gateway("RWF", "6000", "10"); gateways.add(gateway);			
			gateway = new Gateway("SRD", "35", "10"); gateways.add(gateway);			
			gateway = new Gateway("SYP", "580", "10"); gateways.add(gateway);			
			gateway = new Gateway("SZL", "80", "10"); gateways.add(gateway);			
			gateway = new Gateway("THB", "320", "10"); gateways.add(gateway);			
			gateway = new Gateway("TND", "15", "10"); gateways.add(gateway);			
			gateway = new Gateway("TRY", "20", "10"); gateways.add(gateway);			
			gateway = new Gateway("TTD", "65", "10"); gateways.add(gateway);			
			gateway = new Gateway("TZS", "16000", "10"); gateways.add(gateway);			
			gateway = new Gateway("UAH", "80", "10"); gateways.add(gateway);			
			gateway = new Gateway("UGX", "25000", "10"); gateways.add(gateway);			
			gateway = new Gateway("USD", "10", "10"); gateways.add(gateway);			
			gateway = new Gateway("UYU", "200", "10"); gateways.add(gateway);			
			gateway = new Gateway("VEF", "45", "10"); gateways.add(gateway);			
			gateway = new Gateway("VND", "210000", "10"); gateways.add(gateway);			
			gateway = new Gateway("XAF", "5000", "10"); gateways.add(gateway);			
			gateway = new Gateway("XCD", "30", "10"); gateways.add(gateway);			
			gateway = new Gateway("XOF", "5000", "10"); gateways.add(gateway);			
			gateway = new Gateway("YER", "2200", "10"); gateways.add(gateway);			
			gateway = new Gateway("ZAR", "80", "10"); gateways.add(gateway);			
			gateway = new Gateway("ZMK", "52000", "10"); gateways.add(gateway);
		//}
		
		return gateways;
	}
	*/
}
