package com.example.pocketconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

/* PocketConverter
 * Program receives a number from user input as well as which type of
 * numeral system the number is formatted. The program then converts
 * the given number into the other formats
 * 
 * Formats include: decimal, binary, hex
 * 
 * @authors: Jennifer Lemke and Curran Hamilton
 * @version: 2/12/2014 
 */

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.pocketconverter.MESSAGE";
	private EditText decText;
	private EditText octText;
	private EditText hexText;
	private EditText binText;
	private String binInput;
	private String decInput;
	private String hexInput;
	private String octInput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    //Called when the user clicks the Send Button
	public void convertNumber(View view) {
		//Data Fields
		ConvertCalculations calc = new ConvertCalculations();
		String decToHex;
		String decToBin;
		String decToOct;
		
		//Finds the text value for decimal text field
	    decText = (EditText) findViewById(R.id.dec_field);
		decInput = decText.getText().toString();
		int decimalNumber = 0;
				
		//Finds text value for binary text field
		binText = (EditText) findViewById(R.id.bin_field);
		binInput = binText.getText().toString();
		
		//Finds text value for hexadecimal text field
		hexText = (EditText) findViewById(R.id.hex_field);
		hexInput = hexText.getText().toString();
		
		//Finds text for value for octal text field
		octText = (EditText) findViewById(R.id.oct_field);
		octInput = octText.getText().toString();
		
		//Find which text field is not empty in order to create intent
		//May be simpler way to do this. Also need to check if fields empty or more than one filled
		
		if(!decInput.equals("")){
			try {
				decimalNumber = Integer.parseInt(decInput);
			} 
			catch (final NumberFormatException e) {
				
			}
			//Call method that will convert the other forms
			decToHex = calc.convertHex(decimalNumber);
			decToBin = calc.convertBin(decimalNumber);
			decToOct = calc.convertOct(decimalNumber);
			//Sets the text "converted numbers" to the text fields
			
			binText.setText(decToBin);
			hexText.setText(decToHex);
			octText.setText(decToOct);
		}
		else if(!binInput.equals("")){
			int binToDec;
			binToDec = calc.convertBinToDec(binInput);
			decToHex = calc.convertHex(binToDec);
			decToOct = calc.convertOct(binToDec);
			decText.setText(Integer.toString(binToDec));
			hexText.setText(decToHex);
			octText.setText(decToOct);
			
		}
		else if(!hexInput.equals("")){
			int hexToDec;
			hexToDec = calc.convertHexToDec(hexInput);
			decToBin = calc.convertBin(hexToDec);
			decToOct = calc.convertOct(hexToDec);
			decText.setText(Integer.toString(hexToDec));
			octText.setText(decToOct);
			binText.setText(decToBin);
		}
		else if(!octInput.equals("")){
			int octToDec;
			octToDec = calc.convertOctToDec(octInput);
			decToBin = calc.convertBin(octToDec);
			decToHex = calc.convertHex(octToDec);
			decText.setText(Integer.toString(octToDec));
			binText.setText(decToBin);
			hexText.setText(decToHex);
		}
	
	}
	
	public void resetNumber(View view){
		
		String emptyString = "";
		this.decInput = "";
		this.binInput = "";
		this.hexInput = "";
		this.octInput = "";
		this.binText.setText(emptyString);
		this.hexText.setText(emptyString);
		this.octText.setText(emptyString);
		this.decText.setText(emptyString);
		
	}
	

}
