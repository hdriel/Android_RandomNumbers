package cube;

import java.util.Random;

import android.R;
import android.widget.ImageView;

public class Cube {

	private int number;
	private Random rand = new Random(); 
	
	Cube() {number = randomNumberCube();}
	private int randomNumberCube(){ return (rand.nextInt(6) + 1); }
	public int getNumber() {return number; } 
	public void playCubeAgaun(){number = randomNumberCube();}
}
