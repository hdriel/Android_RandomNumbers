package any_numbers;

import hdriel.randomer.R;
import hdriel.randomer.R.drawable;
import hdriel.randomer.R.id;
import hdriel.randomer.R.layout;

import java.util.ArrayList;
import java.util.Random;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.DrawableRes;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

@SuppressLint("NewApi") public class AnyActivity extends Activity{

	EditText et_max, et_min, et_colums;
	Button Btn_randNumbers;
	
	int max, min, size, arr[], sizeItem = 100, temp_max, temp_min, sizeColums, number; 
	int w_and_h ;
	int sizeText ;
	
	String maxStr , minStr;
	TextView tv_rand_number, titleNumCol;
	
	LinearLayout  main;
	CheckBox repetition;
	
	GridView desplayNumbersGrid;
	
	SharedPreferences sharedPref;
	
	boolean repit //  = false // עם חזרות
		  , start; //  = true; // תחום מספרים מחדש
	int i = 0;
	
	InputMethodManager imm;
	Context c;
	Vibrator v;
	
	final String SAVE = "save data", 
			     MAX = "max",
			     MIN = "min", 
			     SIZE_COL = "the size of colom in gridview", 
			     ARR = "the array of random number", 
			     REPIT = "repit" , 
			     START = "start from begining array", 
			     NUM_RAND = "the number of rand curr";
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_any_number);
         
        sharedPref = getSharedPreferences(SAVE, MODE_PRIVATE);        
        et_max                = (EditText)findViewById(R.id.any_max_et);
        et_min                = (EditText)findViewById(R.id.any_min_et);
        et_colums             = (EditText)findViewById(R.id.any_norow_et);
        repetition            = (CheckBox) findViewById(R.id.any_check_box);
        Btn_randNumbers       = (Button)findViewById(R.id.btn_any_rand);
        tv_rand_number        = (TextView) findViewById(R.id.any_rand_text);
        titleNumCol           = (TextView) findViewById(R.id.any_no_row);
        main                  = (LinearLayout) findViewById(R.id.linearLayourMainAny);
        desplayNumbersGrid    = (GridView) findViewById(R.id.gridView_any_numbers);
        
        c = this;       
        imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        v = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        
        max = temp_max = sharedPref.getInt(MAX, Integer.parseInt(et_max.getText().toString()));
        min = temp_min = sharedPref.getInt(MIN, Integer.parseInt(et_min.getText().toString()));
        sizeColums     = sharedPref.getInt(SIZE_COL, Integer.parseInt(et_colums.getText().toString()));
        number         = sharedPref.getInt(NUM_RAND, -1);
        size = max - min + 1;
        repit          = sharedPref.getBoolean(REPIT, false);
        start          = sharedPref.getBoolean(START, true);
        repetition.setChecked(repit);
        
        arr = getFromPrefs();
        if(arr.length != size)
        	arr = new int[size];
        else {
        	if(!repetition.isChecked()){
        		desplayNumbersGrid.setNumColumns(sizeColums);
            	w_and_h = 500/sizeColums;
    			sizeText = 100 / sizeColums;
            	desplayNumbersGrid.setAdapter(new CustomAdapter(c, arr , min, sizeText, w_and_h));
            	et_colums.setEnabled(true);
            	titleNumCol.setEnabled(true);
        	}
        	else 
        	{
        		et_colums.setEnabled(false);
            	titleNumCol.setEnabled(false);
        	}
        }
        
        et_max.setText("" + max);
        et_min.setText("" + min);
        et_colums.setText("" + sizeColums);
        if(number >= 0)
        	tv_rand_number.setText("" + number);
        else 
        	tv_rand_number.setText("");
        
        /*
        temp_max = max = Integer.parseInt(et_max.getText().toString());
        temp_min = min = Integer.parseInt(et_min.getText().toString());
        sizeColums = Integer.parseInt(et_colums.getText().toString());
        size = max - min + 1;
        arr = new int[size];
        */
        
        
        et_max.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
            	 
                if (actionId == EditorInfo.IME_ACTION_DONE) { // when the key Enter press on the keyboard - check the number in the EditText
                	imm.hideSoftInputFromWindow(v.getWindowToken(), 0);               	
                    return true;
                }
                return false;
            }
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				Btn_randNumbers.performClick();
				return false;
			}
        });
        et_min.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
            	 
                if (actionId == EditorInfo.IME_ACTION_DONE) { // when the key Enter press on the keyboard - check the number in the EditText
                	imm.hideSoftInputFromWindow(v.getWindowToken(), 0);               	
                    return true;
                }
                return false;
            }
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				Btn_randNumbers.performClick();
				return false;
			}
        });
        et_colums.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
            	 
                if (actionId == EditorInfo.IME_ACTION_DONE) { // when the key Enter press on the keyboard - check the number in the EditText
                	imm.hideSoftInputFromWindow(v.getWindowToken(), 0);               	
                    return true;
                }
                return false;
            }
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				Btn_randNumbers.performClick();
				return false;
			}
        });
        
        
        
        
        et_colums.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                // you can call or do what you want with your EditText here
	        	if (et_colums.getText().toString().trim().length() > 0)
	        		sizeColums = Integer.parseInt(et_colums.getText().toString());
	    		if(sizeColums <= 0){
	    			Toast.makeText(c, getResources().getString(R.string.any_invalid_input), Toast.LENGTH_SHORT).show();
	    		}
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
         });
        et_max.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                // you can call or do what you want with your EditText here
	        	if (et_max.getText().toString().trim().length() > 0)
	        			temp_max = Integer.parseInt(et_max.getText().toString());
	    		if(temp_max <= temp_min){
	    			Toast.makeText(c, getResources().getString(R.string.any_invalid_input), Toast.LENGTH_SHORT).show();
	    		}
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
         });
        et_min.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

              // you can call or do what you want with your EditText here
            	if (et_min.getText().toString().trim().length() > 0)
            		temp_min = Integer.parseInt(et_min.getText().toString());
        		if(temp_max <= temp_min){
        			Toast.makeText(c, getResources().getString(R.string.any_invalid_input), Toast.LENGTH_SHORT).show();
        		}
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
         });
         
        repetition.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                if(repetition.isChecked())
                {
                	repetition.setText(getResources().getString(R.string.any_checked));
                	repit = true;
                	desplayNumbersGrid.setAdapter(null);
                	et_colums.setEnabled(false);
                	titleNumCol.setEnabled(false);
                	desplayNumbersGrid.setVisibility(View.GONE);
                	tv_rand_number.setText("");
                	
                }
                else
                {
                	repetition.setText(getResources().getString(R.string.any_unchecked));
                	repit = false;
                	start = true;
                	et_colums.setEnabled(true);
                	titleNumCol.setEnabled(true);
                	desplayNumbersGrid.setVisibility(View.VISIBLE);
                	tv_rand_number.setText("");
                }
            }
        });
        
        Btn_randNumbers.setOnClickListener(new OnClickListener() {
	            	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				if(!repit){	
					desplayNumbersGrid.setAdapter(null);
				}
				
				if (et_min.getText().toString().trim().length() <= 0){
					et_min.setText("1");
					temp_min = 1;
				}
				if (et_max.getText().toString().trim().length() <= 0){
					et_max.setText("10");
					temp_max = 10;
				}
				
				if (et_colums.getText().toString().trim().length() <= 0){
					et_colums.setText("5");
					sizeColums = 5;
				}
				else 
					sizeColums = Integer.parseInt(et_colums.getText().toString());
				
				
				if(max != temp_max || min != temp_min) 
					start = true;
				
				max = temp_max;
				min = temp_min;
				
				if (maxStr != "" && minStr != "" && max > min)
				{
					
					size = max - min + 1;
					if(sizeColums > size){
						sizeColums = 5;
						et_colums.setText("5");
					}
					desplayNumbersGrid.setNumColumns(sizeColums);
					
					w_and_h = 500/sizeColums;
					sizeText = 100 / sizeColums;
					
					
					
					// reset the range balls to start from beginning
					if(start){
						i = 0;
						arr = new int[size];
						for(int j = 0; j < size; j++)
						{
							arr[j] = Integer.MAX_VALUE;
						}
						start = false;
					}
					
					
					i = checkFull(arr);
					if( i != -1 && !repit)
					{
						v.vibrate(50);
						
						tv_rand_number.setText("" + i);				
						do
						{
	 						number = min + (int)(Math.random() * ((max - min) + 1));
	 				    }while(existed_fullSize(number, arr));
						
						arr[i] = number;
												
						tv_rand_number.setText("" + number);
						desplayNumbersGrid.setAdapter(new CustomAdapter(c, arr , min, sizeText, w_and_h));	
						
					}
					else if(i == -1 && !repit){
						
						Toast.makeText(c, getResources().getString(R.string.any_full), Toast.LENGTH_SHORT).show();
						desplayNumbersGrid.setAdapter(new CustomAdapter(c, arr , min, sizeText, w_and_h));
						
					}
					
					else if(repit){	
						v.vibrate(50);
						number =  min + (int)(Math.random() * ((max - min) + 1));
						tv_rand_number.setText("" + number);
						desplayNumbersGrid.setAdapter(null);
					}
														
	 			}
				else{
					Toast.makeText(c, getResources().getString(R.string.any_invalid_input), Toast.LENGTH_SHORT).show();
				}
	 			
	 			}
		}); 
	
	
	}// end onCreate method
	
	
	
	
	private boolean existed_fullSize(int num, int[] temp_arr){
		for(int i = 0; i < temp_arr.length ; i++){
			if(temp_arr[i] == num)
				return true;
		}
		return false;
	};
	private boolean existed(int j ,int num, int[] temp_arr){
		for(int i = 0; i < j; i++){
			if(temp_arr[i] == num)
				return true;
		}
		return false;
	};
	private int checkFull(int temp_arr[]){
		for(int i = 0; i < temp_arr.length; i++){
			if(temp_arr[i] == Integer.MAX_VALUE)
				return i;
		}
		return -1;
	}
	
	
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("MAX", max);
		outState.putInt("MIN", min);
		outState.putInt("CURR", number);
		outState.putInt("COL", sizeColums);
		outState.putInt("SIZE_ITEM", sizeItem);
		outState.putIntArray("ARRAY", arr);
		outState.putBoolean("REPIT", repit);
		outState.putBoolean("START", start);
		outState.putInt("WIDTH", w_and_h);
		outState.putInt("STEXT", sizeText);
		
	}	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		
		max = savedInstanceState.getInt("MAX");
		min = savedInstanceState.getInt("MIN");
		number = savedInstanceState.getInt("CURR");
		sizeColums = savedInstanceState.getInt("COL");
		sizeItem = savedInstanceState.getInt("SIZE_ITEM");
		arr = savedInstanceState.getIntArray("ARRAY");
		repit = savedInstanceState.getBoolean("REPIT");
		start = savedInstanceState.getBoolean("START");
		w_and_h = savedInstanceState.getInt("WIDTH");
		sizeText = savedInstanceState.getInt("STEXT");
		
		desplayNumbersGrid.setNumColumns(sizeColums);
		tv_rand_number.setText("" + number);
		
		if(!repit){
			desplayNumbersGrid.setAdapter(new CustomAdapter(c, arr , min, sizeText, w_and_h));
		}	
			
	}

	public int[] getFromPrefs(){
	    int[] ret;
	    sharedPref = getSharedPreferences(SAVE, MODE_PRIVATE); 
	    int count = sharedPref.getInt("Count", 0);
	    ret = new int[count];
	    for (int i = 0; i < count; i++){
	        ret[i] = sharedPref.getInt("IntValue_"+ i, i);
	    }
	    return ret;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		SharedPreferences sharedPref = getSharedPreferences(SAVE, MODE_PRIVATE);
	    SharedPreferences.Editor editor = sharedPref.edit();
	    
	    editor.putInt(MAX, max);
	    editor.putInt(MAX, temp_max);
	    editor.putInt(MIN, min);
	    editor.putInt(MIN, temp_min);
	    editor.putInt(NUM_RAND, number);
	    editor.putInt(SIZE_COL, sizeColums);
	    editor.putBoolean(REPIT, repit);
	    editor.putBoolean(START, start);  
	    
	    editor.putInt("Count", arr.length);
	    int count = 0;
	    for (int i: arr)
	    	editor.putInt("IntValue_" + count++, i);
	     
	    
	    editor.commit();
	}
	
}
