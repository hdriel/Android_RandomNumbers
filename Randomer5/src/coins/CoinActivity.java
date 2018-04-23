package coins;

import hdriel.randomer.R;
import hdriel.randomer.R.drawable;
import hdriel.randomer.R.id;
import hdriel.randomer.R.layout;

import java.util.Random;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridLayout.Spec;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

@SuppressLint("NewApi") public class CoinActivity extends Activity{

	EditText et_numberCubes;
	Button Btn_randNumbers;
	int amountCubes, sizeImageViewCube = 200; 
	String amountCubeStr , numberOnRandom = "";
	//TextView tv_numbers;
	LinearLayout  main;
	//LinearLayout desplayCubesLayout;
	GridLayout desplayCubesGridLayout;
	ImageView[] imageView;
	Context c;
	InputMethodManager mgr;
	Vibrator v;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coin);
         
        et_numberCubes= (EditText)findViewById(R.id.Coin_NumberCube);
        Btn_randNumbers = (Button)findViewById(R.id.Coin_randNumbers);
        desplayCubesGridLayout = (GridLayout) findViewById(R.id.GridLayout_coins);
        main = (LinearLayout) findViewById(R.id.linearLayourMainCoin);
        c = this;
        v = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
        
        mgr = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        
        et_numberCubes.setOnEditorActionListener(new EditText.OnEditorActionListener() {

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
				
				v.vibrate(50);
				
				desplayCubesGridLayout.removeAllViews();
				
				if(et_numberCubes.getText().toString().trim().length() <= 0){
					et_numberCubes.setText("1");
				}
				
				amountCubeStr = et_numberCubes.getText().toString();
				if (amountCubeStr != "")
				{
					amountCubes = Integer.parseInt(amountCubeStr);
		 			if(amountCubes > 0)
		 			{
		 				Coin[] c = new Coin[amountCubes];
		 				imageView  = new ImageView[amountCubes];
		 				
		 				for(int i = 0 ; i < amountCubes ; i++)
						{
		 					c[i] = new Coin();
		 					imageView[i] = new ImageView(getBaseContext());
		 					
		 					switch(c[i].getNumber()){
		 					case 1:
		 						imageView[i].setImageResource(R.drawable.coin_a);
		 						break;
		 					case 2:
		 						imageView[i].setImageResource(R.drawable.coin_b);
		 						break;
		 					
		 					}
		 					
		 					imageView[i].setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		 					imageView[i].setPadding(10, 10, 10, 10);
		 					
		 					
		 					imageView[i].setLayoutParams(new GridView.LayoutParams(sizeImageViewCube, sizeImageViewCube));
		 					desplayCubesGridLayout.addView(imageView[i]);		 				 													
		 				}
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
