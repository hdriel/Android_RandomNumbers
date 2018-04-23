package lottery;

import java.util.Random;

import android.R;
import android.widget.ImageView;

public class Lottery {

	private int MAXS = 7;
	
	private int SIZE = 6;
	private int MAX = 37;
	
	private int[] numbers;
	
	
	private int strongNumber;
	
	
	private Random rand = new Random(); 
	
	
	Lottery() {
		numbers = new int[SIZE];
		
		
		for(int i = 0 ; i < SIZE; i++){
			numbers[i] = 0;
		}
		strongNumber = 0;
		
		randomNumbers();
		sort();
	}
	
	private void randomNumbers(){ 
		for(int i = 0 ; i < SIZE; i++){
			do{
				numbers[i] = (rand.nextInt(MAX) + 1);	
			}while(existed(i, numbers[i]));
		}
		strongNumber = (rand.nextInt(MAXS) + 1);
	}
		
	private boolean existed(int j,int num){
		for(int i = 0; i < j; i++){
			if(numbers[i] == num)
				return true;
		}
		return false;
	};
	
	private void sort(){
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(numbers[i] < numbers[j]){
					int temp = numbers[i]; 
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}
	
	public int[] getNumbers() {return numbers; } 
	public int getNumberIndex(int i) {return numbers[i]; } 
	
	public int getStrongNumber() {return strongNumber; } 
	
	public void playAgain(){ randomNumbers();}
	
}
