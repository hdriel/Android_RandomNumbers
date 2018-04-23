package coins;

import java.util.Random;

import android.R;
import android.widget.ImageView;

public class Coin {

	private int number;
	private Random rand = new Random(); 
	
	Coin() {number = randomNumberCube();}
	private int randomNumberCube(){ return (rand.nextInt(2) + 1); }
	public int getNumber() {return number; } 
	public void playCubeAgaun(){number = randomNumberCube();}
}
