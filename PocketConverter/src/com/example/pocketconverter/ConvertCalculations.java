package com.example.pocketconverter;


public class ConvertCalculations {

	private int hexDivision;
	private String hexResultString;
	private String tempHexString;
	private int hexResultInt;
	private int tempRemain;
	private final int HEXDIVISOR = 16; 
	
	public ConvertCalculations(){
	    hexDivision = 0;
	    hexResultString = "";
	}
	
	public String convertHex(int decimalNumber){
		while(HEXDIVISOR <= decimalNumber)
		{
			//Find remainder of decimal number and 16
			tempRemain = decimalNumber%HEXDIVISOR;
			
			//Find decimalNumber divided by 16
			hexResultInt = decimalNumber/HEXDIVISOR;
			
			
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
			hexResultString = tempHexString + hexResultString;
			
			//Set the decimalNumber to be divided next to the previous result
			decimalNumber = hexResultInt;
			
		}
		//Add last remainder to the result string
		hexResultString = decimalNumber + hexResultString;
		
		return hexResultString;
		
	}
}