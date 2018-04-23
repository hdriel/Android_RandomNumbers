package hdriel.randomer;

import coins.CoinActivity;
import chance.ChanceActivity;
import one_tow_three.OneTwoThreeActivity;
import lottery.LotteryActivity;
import cube.CubeActivity;
import pais.PaisActivity;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import any_numbers.AnyActivity;


@SuppressLint("NewApi") public class MainActivity extends ActionBarActivity {

	ImageButton loto, pais, chance, b123, cubes, randomNumbers, coin;
	Intent i;
	Context c;
	
	boolean doubleBackToExitPressedOnce;
	Handler mHandler = new Handler();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
        loto         = (ImageButton)findViewById(R.id.ImageBotton_lotto);
        pais         = (ImageButton)findViewById(R.id.ImageBotton_pais);
        chance       = (ImageButton)findViewById(R.id.ImageBotton_chance);
        b123         = (ImageButton)findViewById(R.id.ImageBotton_b123);
        cubes        = (ImageButton)findViewById(R.id.ImageBotton_cubes);
        coin         = (ImageButton)findViewById(R.id.ImageBotton_coin);
        randomNumbers= (ImageButton)findViewById(R.id.ImageBotton_randomNumber);
        c = this;
        
        
        loto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , LotteryActivity.class);
				startActivity(i);
			}
		});
        
        
        pais.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , PaisActivity.class);
				startActivity(i);
			}
		});
        
        chance.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , ChanceActivity.class);
				startActivity(i);
			}
		});
        
        b123.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , OneTwoThreeActivity.class);
				startActivity(i);
			}
		});
        
        cubes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , CubeActivity.class);
				startActivity(i);
			}
		});
        
        coin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , CoinActivity.class);
				startActivity(i);
			}
		});
        
        randomNumbers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i = new Intent(MainActivity.this , AnyActivity.class);
				startActivity(i);
			}
		});
        
        
    }

    
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;                       
        }
    };

    @Override 
    protected void onDestroy() 
    { 
        super.onDestroy();

        if (mHandler != null) { mHandler.removeCallbacks(mRunnable); }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "לחץ על הכפתור BACK שוב כדי לצאת.", Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(mRunnable, 2000);
    }
    
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
        	Toast.makeText(c, getResources().getString(R.string.about_toast) , Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
