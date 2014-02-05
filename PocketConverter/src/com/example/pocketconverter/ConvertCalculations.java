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
	
	//Method for converting dec to hex
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
			switch(tempRemain){
			   case 10: tempHexString = "A";
						break;
						
			   case 11: tempHexString = "B";
			   			break;
			   			
			   case 12: tempHexString = "C";
			   			break;
			   
			   case 13: tempHexString = "D";
			   			break;
			   			
			   case 14: tempHexString = "E";
			   			break;
			   			
			   case 15: tempHexString = "F";
			   			break;
			   			
			   default: tempHexString = Integer.toString(tempRemain);
			   			break;
			}
						
			
			//Add remainder to the result string
			resultString += tempHexString;
			
			//Set the decimalNumber to be divided next to the previous result
			decimalNumber = resultInt;
			
		}
		//Add last remainder to the result string
		switch(decimalNumber){
		   case 10: tempHexString = "A";
		   			resultString += tempHexString;
					break;
					
		   case 11: tempHexString = "B";
		   			resultString += tempHexString;
		   			break;
		   			
		   case 12: tempHexString = "C";
		   			resultString += tempHexString;
		   			break;
		   
		   case 13: tempHexString = "D";
		   			resultString += tempHexString;
		   			break;
		   			
		   case 14: tempHexString = "E";
		   			resultString += tempHexString;
		   			break;
		   			
		   case 15: tempHexString = "F";
		   			resultString += tempHexString;
		   			break;
		   			
		   default: resultString += decimalNumber;
		   			break;
		}	
		
		return new StringBuilder(resultString).reverse().toString();
	}
	
	//Method for converting dec to bin
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
	
	//Method for converting dec to oct
	public String convertOct(int decimalNumber) {
		if(decimalNumber >7)
		{
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
		else
		{
			return Integer.toString(decimalNumber);
		}
	}
	
	//Method for converting bin to dec
	public int convertBinToDec(String binaryNumber) {
		resultString = "";
	    resultInt = Integer.parseInt(binaryNumber, 2);
	    tempRemain = 0;
		return resultInt;
	}
	
	//Method for converting hex to dec
	public int convertHexToDec(String hexNumber) {
		resultString = "";
	    resultInt = Integer.parseInt(hexNumber, 16);
	    tempRemain = 0;
		return resultInt;
	}
	
	//Method for converting oct to dec
	public int convertOctToDec(String octNumber) {
		resultString = "";
		resultInt = Integer.parseInt(octNumber, 8);
		tempRemain = 0;
		return resultInt;
	}
}