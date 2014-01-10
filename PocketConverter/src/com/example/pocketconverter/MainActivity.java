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
 * @version: 1/6/2013 6:28pm
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
		EditText editText = (EditText) findViewById(R.id.dec_field);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
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
