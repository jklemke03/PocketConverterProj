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
 * @version: 1/9/2014 7:57pm
 */

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.pocketconverter.MESSAGE";
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
		EditText decimalText = (EditText) findViewById(R.id.dec_field);
		String decInput = decimalText.getText().toString();
		int decimalNumber = 0;
		
		//Test the input of the decimal field
		final StringBuilder errorMessage = new StringBuilder("Bad Input Value: ");
		try {
			decimalNumber = Integer.parseInt(decInput);
		} catch (final NumberFormatException e) {
			errorMessage.append("Failed to parse decimal number" + e.getMessage());
		}
				
		//Finds text value for binary text field
		EditText binText = (EditText) findViewById(R.id.bin_field);
		String binInput = binText.getText().toString();
		
		//Finds text value for hexadecimal text field
		EditText hexText = (EditText) findViewById(R.id.hex_field);
		String hexInput = hexText.getText().toString();
		
		//Finds text for value for octal text field
		EditText octText = (EditText) findViewById(R.id.oct_field);
		String octInput = octText.getText().toString();
		
		//Find which text field is not empty in order to create intent
		//May be simpler way to do this. Also need to check if fields empty or more than one filled
		
		if(!decInput.equals("")){
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
			decimalText.setText(Integer.toString(binToDec));
			hexText.setText(decToHex);
			octText.setText(decToOct);
			
		}
		else if(!hexInput.equals("")){
			int hexToDec;
			hexToDec = calc.convertHexToDec(hexInput);
			decToBin = calc.convertBin(hexToDec);
			decToOct = calc.convertOct(hexToDec);
			decimalText.setText(Integer.toString(hexToDec));
			octText.setText(decToOct);
			binText.setText(decToBin);
		}
		else if(!octInput.equals("")){
			int octToDec;
			octToDec = calc.convertHexToDec(octInput);
			decToBin = calc.convertBin(octToDec);
			decToHex = calc.convertOct(octToDec);
			decimalText.setText(Integer.toString(octToDec));
			binText.setText(decToBin);
			hexText.setText(decToHex);
		}
		else
		{
			//none have anything in them. Perhaps message inputed onto screen?
		}
	
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void openSettings() {
		Intent intent = new Intent(this, SettingsActivity.class);
		//String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		startActivity(intent);
	}
	
}
