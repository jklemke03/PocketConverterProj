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
 * @authors: Jennifer Lemke and Curran Hamliton
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
		
		
		
		//Creates an intent object used to start another activity
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		
		//Finds the text value for decimal textfield
		EditText decimalText = (EditText) findViewById(R.id.dec_field);
		String decimalInput = decimalText.getText().toString();
		//Finds text value for binary textfield
		EditText binaryText = (EditText) findViewById(R.id.bin_field);
		String binaryInput = binaryText.getText().toString();
		//Finds text value for hexidecimal textfield
		EditText hexText = (EditText) findViewById(R.id.hex_field);
		String hexInput = hexText.getText().toString();
		//Finds text for value for octal textfield
		EditText octText = (EditText) findViewById(R.id.oct_field);
		String octInput = octText.getText().toString();
		//Find which textfield is not empty in order to create intent
		//May be simpler way to do this. Also need to check if fields empty or more than one filled
		if(!decimalInput.equals("")){
			intent.putExtra(EXTRA_MESSAGE, decimalInput);
		}
		else if(!binaryText.equals("")){
			intent.putExtra(EXTRA_MESSAGE, binaryInput);
		}
		else if(!hexInput.equals("")){
			intent.putExtra(EXTRA_MESSAGE, hexInput);
		}
		else if(!octInput.equals("")){
			intent.putExtra(EXTRA_MESSAGE, octInput);
		}
		else
		{
			//none have anything in them. Perhaps message inputted onto screen?
		}
	
		startActivity(intent);
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
		// TODO create method for opening the setting page.
		
	}
	
}
