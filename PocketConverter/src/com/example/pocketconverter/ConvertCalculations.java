package com.example.pocketconverter;


public class ConvertCalculations {

	//private int division;
	private String resultString;
	private String tempHexString;
	private int resultInt;
	private int tempRemain;
	private final int HEXDIVISOR = 16; 
	private final int BINDIVISOR = 2;
	private final int OCTDIVISOR = 8;
	
	public ConvertCalculations(){
	    //division = 0;
	    resultString = "";
	    resultInt = 0;
	    tempRemain = 0;
	}
	
	public String convertHex(int decimalNumber) {
		resultString = "";
	    resultInt = 0;
	    tempRemain = 0;
		while(HEXDIVISOR <= decimalNumber) {
			//Find remainder of decimal number modulo 16
			tempRemain = decimalNumber%HEXDIVISOR;
			
			//Find decimalNumber divided by 16
			resultInt = decimalNumber/HEXDIVISOR;
			
			
			//Setting the hex alphabet value to numbers 10 to 15
			if(tempRemain == 10)
			{
				tempHexString = "A";
			}
			else if(tempRemain == 11)
			{
				tempHexString = "B";
			}
			else if(tempRemain == 12)
			{
				tempHexString = "C";
			}
			else if(tempRemain == 13)
			{
			    tempHexString = "D";
			}
			else if(tempRemain == 14)
			{
				tempHexString = "E";
			}
			else if(tempRemain == 15)
			{
				tempHexString = "F";
			}
			else
			{
				tempHexString = Integer.toString(tempRemain);
			}
			
			//Add remainder to the result string
			resultString = tempHexString + resultString;
			
			//Set the decimalNumber to be divided next to the previous result
			decimalNumber = resultInt;
			
		}
		//Add last remainder to the result string
		if(decimalNumber == 10)
		{
			tempHexString = "A";
			resultString = tempHexString + resultString;
		}
		else if(decimalNumber == 11)
		{
			tempHexString = "B";
			resultString = tempHexString + resultString;
		}
		else if(decimalNumber == 12)
		{
			tempHexString = "C";
			resultString = tempHexString + resultString;
		}
		else if(decimalNumber == 13)
		{
		    tempHexString = "D";
		    resultString = tempHexString + resultString;
		}
		else if(decimalNumber == 14)
		{
			tempHexString = "E";
			resultString = tempHexString + resultString;
		}
		else if(decimalNumber == 15)
		{
			tempHexString = "F";
			resultString = tempHexString + resultString;
		}
		else 
		{
			resultString = decimalNumber + resultString;
		}
		
		
		
		return resultString;
	}
	
	public String convertBin(int decimalNumber) {
		resultString = "";
	    resultInt = 0;
	    tempRemain = 0;
		while(decimalNumber >= 1) {
			//Find the remainder of decimal number modulo 2
			tempRemain = decimalNumber%BINDIVISOR;
			
			//Find decimalNumber divided by 2
			resultInt = decimalNumber/BINDIVISOR;

			//Add remainder to result string
			resultString += tempRemain;
			
			//Set decimalNumber
			decimalNumber = resultInt;
		}
		
		return new StringBuilder(resultString).reverse().toString();
	}
	
	public String convertOct(int decimalNumber) {
		resultString = "";
	    resultInt = 0;
	    tempRemain = 0;
		while(decimalNumber >= OCTDIVISOR) {
			//Find the remainder of decimal number modulo 8
			tempRemain = decimalNumber%OCTDIVISOR;
			
			//Find decimalNumber divided by 8
			resultInt = decimalNumber/OCTDIVISOR;
			
			//Add remainder to result string
			resultString += tempRemain;
			
			//Set decimalNumber
			decimalNumber = resultInt;
		}
		
		//Add final remainder to result
		resultString += resultInt;
		
		return new StringBuilder(resultString).reverse().toString();
	}
}