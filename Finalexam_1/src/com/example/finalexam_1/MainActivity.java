package com.example.finalexam_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	private TextView firstQuestionText;
	private TextView secondQuestionText;
	private TextView thirdQuestionText;
	private EditText firstQuestionEdit;
	private EditText secondQuestionEdit;
	private EditText thirdQuestionEdit;
	private Button submitButton;
	private Button resetButton;
	private TextView correctText;
	private ImageView star1;
	private ImageView star2;
	private ImageView star3;
	private int corrects;
	private int first;
	private int second;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		firstQuestionText = (TextView) findViewById(R.id.firstQuestionText);
		secondQuestionText = (TextView) findViewById(R.id.secoundQuestionText);
		thirdQuestionText = (TextView) findViewById(R.id.thirdQuestionText);
		
		firstQuestionEdit = (EditText) findViewById(R.id.firstQuestionEdit);
		secondQuestionText = (EditText) findViewById(R.id.secondQuesitonEdit);
		thirdQuestionText = (EditText) findViewById(R.id.thirdQuestionEdit);
		
		correctText = (TextView) findViewById(R.id.correctText);
		
		submitButton = (Button) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(submitButtonListener);
		
		star1 = (ImageView) findViewById(R.id.star1);
		star2 = (ImageView) findViewById(R.id.star2);
		star3 = (ImageView) findViewById(R.id.star3);
		
		resetButton = (Button) findViewById(R.id.submitButton);
		resetButton.setOnClickListener(resetButtonListener);
		startQuiz();
		
			
	}
	private void startQuiz(){
		Random rand = new Random(11);
		first = rand.nextInt();
		second = rand.nextInt();
		corrects = 0;
		
		firstQuestionText.setText(first+" + "+second+" =");
		secondQuestionText.setText(first+" - "+second+" =");
		thirdQuestionText.setText(first+" * "+second+" =");
		
		firstQuestionEdit.setText("");
		secondQuestionEdit.setText("");
		thirdQuestionEdit.setText("");
		correctText.setText("");
		star1.setVisibility(View.INVISIBLE);
		star2.setVisibility(View.INVISIBLE);
		star3.setVisibility(View.INVISIBLE);
	}
	private OnClickListener resetButtonListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			startQuiz();
		}
	};
	private OnClickListener submitButtonListener = new OnClickListener(){
		@Override
		public void onClick(View v){
			String firstquestion = firstQuestionEdit.getText().toString();
			String secondquestion = secondQuestionEdit.getText().toString();
			String thirdquestion = thirdQuestionEdit.getText().toString();
			
			if( (first+second)== Integer.parseInt(firstquestion)){
				corrects++;	
			}
			if( (first-second)== Integer.parseInt(secondquestion)){
				corrects++;	
			}
			if( (first*second)== Integer.parseInt(thirdquestion)){
				corrects++;	
			}
			correctText.setText("You got "+corrects+" questions correct!");
			
			if (corrects == 1){
				star1.setVisibility(View.VISIBLE);
			}
			if (corrects == 2){
				star1.setVisibility(View.VISIBLE);
				star2.setVisibility(View.VISIBLE);
			}
			if (corrects == 3){
				star1.setVisibility(View.VISIBLE);
				star2.setVisibility(View.VISIBLE);
				star3.setVisibility(View.VISIBLE);
			}
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
