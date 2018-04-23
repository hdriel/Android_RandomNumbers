package pais;

import java.util.Random;

import android.R;
import android.widget.ImageView;

public class Pais {

	private int SIZE = 7;
	private int MAX = 70;
	
	private int[] numbers;
	private Random rand = new Random(); 
	
	
	Pais() {
		numbers = new int[SIZE];
		for(int i = 0 ; i < SIZE; i++){
			numbers[i] = 0;
		}
		randomNumbers();
		sort();
	}
	
	private void randomNumbers(){ 
		for(int i = 0 ; i < SIZE; i++){
			do{
				numbers[i] = (rand.nextInt(MAX) + 1);	
			}while(existed(i, numbers[i]));
		}
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
	
	public void playAgain(){ randomNumbers(); sort();}
}
