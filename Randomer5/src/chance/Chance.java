package chance;

import java.util.Random;

import android.R;
import android.widget.ImageView;

public class Chance {

	private int SIZE = 4;
	private int MAX = 14;
	private int MIN = 7;

	
	private int[] numbers;
	private Random rand = new Random(); 
	
	
	Chance() {
		numbers = new int[SIZE];
		for(int i = 0 ; i < SIZE; i++){
			numbers[i] = 0;
		}
		randomNumbers();
		
	}
	
	private void randomNumbers(){ 
		for(int i = 0 ; i < SIZE; i++){
				numbers[i] = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
		}
	}
	
	public int[] getNumbers() {return numbers; } 
	
	public int getNumberIndex(int i) {return numbers[i]; } 
	
	public void playAgain(){ randomNumbers();}
}
