package com.example.finalexam_2;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends Activity {
	
	private TextView resultText;
	private TextView formulaDisplay;
	private EditText numEdit;
	private RadioButton fButton1;
	private RadioButton fButton2;
	private RadioButton cButton1;
	private RadioButton cButton2;
	private RadioButton kButton1;
	private RadioButton kButton2;
	private Button convertButton;
	private Button resetButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		numEdit = (EditText) findViewById(R.id.numEdit);
		resultText = (TextView) findViewById(R.id.result);
		formulaDisplay = (TextView) findViewById(R.id.formulaDisplay);
		fButton1 = (RadioButton) findViewById(R.id.fButton1);
		fButton2 = (RadioButton) findViewById(R.id.fButton2);
		cButton1 = (RadioButton) findViewById(R.id.cButton1);
		cButton2 = (RadioButton) findViewById(R.id.cButton2);
		kButton1 = (RadioButton) findViewById(R.id.kButton1);
		kButton2 = (RadioButton) findViewById(R.id.kButton2);
		convertButton = (Button) findViewById(R.id.convertButton);
		convertButton.setOnClickListener(convertButtonListener);
		resetButton = (Button) findViewById(R.id.resetButton);
		resetButton.setOnClickListener(resetButtonListener);
		
	}
	private OnClickListener resetButtonListener = new OnClickListener(){
		@Override
		public void onClick(View v){
			numEdit.setText("");
			resetRadios();
			resultText.setText("");
			formulaDisplay.setText("");
		}
	};
	private OnClickListener convertButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			int num = Integer.parseInt(numEdit.getText().toString());
			String from;
			String to;
			double cal;
			
			if (fButton1.isChecked() && cButton2.isChecked()){
				from = "Fahrenheit";
				to = "Celsius";
				cal = (num-32)*(5/9);
				resultText.setText(num+" "+from+" = "+cal+ " "+to);
				formulaDisplay.setText(to+" = ("+from+"-32)*5/9");
			}
			else if (fButton1.isChecked() && kButton2.isChecked()){
				from = "Fahrenheit";
				to = "Kelvin";
				cal =(num+459)*(5/9);
				resultText.setText(num+" "+from+" = "+cal+ " "+to);
				formulaDisplay.setText(to+" = ("+from+"-32)*5/9+273.15");
			}
			else if (cButton1.isChecked() && fButton2.isChecked()){
				from = "Celsius";
				to = "Fahrenheit";
				cal = num*9/5+32;
				resultText.setText(num+" "+from+" = "+cal+ " "+to);
				formulaDisplay.setText(to+" = "+from+"*9/5+32");
			}
			else if (cButton1.isChecked() && kButton2.isChecked()){
				from = "Celsius";
				to = "Kelvin";
				cal = num+237.15;
				resultText.setText(num+" "+from+" = "+cal+ " "+to);
				formulaDisplay.setText(to+" = "+from+" + 237.15");
			}
			else if (kButton1.isChecked() && fButton2.isChecked()){
				from = "Kelvin";
				to = "Fahrenheit";
				cal = ((num-237.15)*(9/5)+32);
				resultText.setText(num+" "+from+" = "+cal+" "+to);
				formulaDisplay.setText(to+" = ("+from+"-237.15)*9/5+32");
			}
			else if(kButton1.isChecked() && cButton2.isChecked()){
				from = "Kelvin";
				to = "Celsius";
				cal = (num-237.15);
				resultText.setText(num+" "+from+" = "+cal+ " "+to);
				formulaDisplay.setText(to+" = "+from+" - 237.15");
				
			}
			else{
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				builder.setMessage("ERROR Please chosse different units and different columns!");
				builder.setPositiveButton("Reset",null);
				AlertDialog errorDialog = builder.create();
				errorDialog.show();	
			
				resetRadios();
			}
		}
	};
	
	private void resetRadios(){
		fButton1.setChecked(false);
		fButton2.setChecked(false);
		cButton1.setChecked(false);
		cButton2.setChecked(false);
		kButton1.setChecked(false);
		kButton2.setChecked(false);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

