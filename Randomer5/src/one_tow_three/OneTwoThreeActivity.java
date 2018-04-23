package one_tow_three;

import hdriel.randomer.R;
import hdriel.randomer.R.id;
import hdriel.randomer.R.layout;
import hdriel.randomer.R.string;

import java.util.ArrayList;
import java.util.Random;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

@SuppressLint("NewApi") public class OneTwoThreeActivity extends Activity{

	EditText et_numberPais;
	
	Button Btn_randNumbers;
	
	int amountPais;
	String amountStr;
	
	LinearLayout  main;
	
	ListView lv;
	ArrayList<OneTwoThree> alp;
	CustomAdapterOTTH adapter;
	
	Context CustomListView = null;
	
	InputMethodManager mgr;
	Vibrator v;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_one_two_three);
         
        et_numberPais= (EditText)findViewById(R.id.OneTwoThree_edit_text);
        Btn_randNumbers = (Button)findViewById(R.id.btn_one_two_three);
        main = (LinearLayout) findViewById(R.id.linearLayourMainOTTH);
        alp = new ArrayList<OneTwoThree>();
        CustomListView = this;       
        lv = (ListView) findViewById(R.id.listView_OTTH);
        v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        
        
        mgr = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        
        et_numberPais.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
            	 
                if (actionId == EditorInfo.IME_ACTION_DONE) { // when the key Enter press on the keyboard - check the number in the EditText
                	mgr.hideSoftInputFromWindow(v.getWindowToken(), 0);               	
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
        
        
        Btn_randNumbers.setOnClickListener(new OnClickListener() {
	            	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				alp.clear();
				v.vibrate(50);
				
				if(et_numberPais.getText().toString().trim().length() <= 0){
					et_numberPais.setText("5");
				}
				
				String strHint = getResources().getString(R.string.OneTwoThree_Hint); 			
				
				amountStr = et_numberPais.getText().toString();
				if (amountStr != null && amountStr != "" && amountStr != strHint)
				{
					amountPais = Integer.parseInt(amountStr);
					if(amountPais > 0)
		 			{
						OneTwoThree o;
						alp = new ArrayList<OneTwoThree>();		 				
		 				for(int i = 0 ; i < amountPais ; i++)  {
		 					o = new OneTwoThree();
		 					alp.add(o);
		 				}
		 				
		 				lv.setAdapter(new CustomAdapterOTTH(CustomListView, alp));
		 			}
					setContentView(main);
				}
			}			
		}); 
        
        
}
	
	
	private boolean checkNumberOfCubes(int n){
		if(n > 0 && n < 10)
		{
			return true;
		}
		else
		{ 
			return false;
		}
	}
	
	 
}
