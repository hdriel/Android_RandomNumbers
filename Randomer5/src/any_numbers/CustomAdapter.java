package any_numbers;

import hdriel.randomer.R;
import hdriel.randomer.R.id;
import hdriel.randomer.R.layout;

import java.util.ArrayList;


import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter /* implements OnClickListener*/ {
		 private Context context;
	     private final int[] textViewValues;
	     private int min;
	     private int sizeText;
	     private int sizeWidth_height;

	     public CustomAdapter(Context context, int[] textViewValues , int min, int st, int swh) {
	            this.context = context;
	            this.sizeText = st;
	            this.sizeWidth_height = swh;
	            this.min = min;
	            this.textViewValues = textViewValues;  
	            sortWithSpaceses(this.textViewValues);   
	            
         }
	     
	     public View getView(int position, View convertView, ViewGroup parent) {

	            View gridView;

	            if (convertView == null) // if it's not recycled, initialize some attributes
	            {

	                gridView = new View(context);
	                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                // get layout from mobile.xml
	                gridView = inflater.inflate(R.layout.tab_item_any, parent, false);	                
	            } 
	            else {
	                gridView = (View) convertView;
	            }

	            // set value into textview
                TextView textView = (TextView) gridView.findViewById(R.id.tv_tab_any);
                textView.setTextSize(sizeText);
                textView.setWidth(sizeWidth_height);
                textView.setHeight(sizeWidth_height);
                
               // Gets the layout params that will allow you to resize the layout
                android.view.ViewGroup.LayoutParams params = textView.getLayoutParams();
                // Changes the height and width to the specified *pixels*
                params.height = sizeWidth_height;
                params.width = sizeWidth_height;
                textView.setLayoutParams(params);
                
                
                
                if(textViewValues[position] != Integer.MAX_VALUE)
                	textView.setText("" + textViewValues[position]);  
                else
                	textView.setText(" "); 
                
	            return gridView;
	        }

	     
	     
	        @Override
	        public int getCount() {
	            return textViewValues.length;
	        }

	        @Override
	        public Object getItem(int position) {
	            return null;
	        }

	        @Override
	        public long getItemId(int position) {
	            return 0;
	        }
	        
	        private void sort(int arr[]){
	    		for(int i = 0; i < arr.length; i++)
	    		{
	    			for(int j = 0; j < arr.length; j++)
	    			{
	    				if(arr[i] < arr[j]){
	    					int temp = arr[i]; 
	    					arr[i] = arr[j];
	    					arr[j] = temp;
	    				}
	    			}
	    		}
	    	}
	        
	        private void sortWithSpaceses(int arr[]){
	        	
	        	int temp_arr[] = new int[arr.length];
	        	// initial the temp array with the order data
	        	for(int i = 0; i < temp_arr.length; i++)
	    		{
	        		temp_arr[i] = min + i;
	    		}
	        	
	        	int index;
	        	for(int i = 0 ; i < arr.length; i++)
	    		{
	        		index = binarySearch(arr[i], temp_arr);
	    			if(index != -1)
	    			{
	    					int temp = arr[i]; 
	    					arr[i] = arr[index];
	    					arr[index] = temp;
	    			}
	    		}
	        }
	        
	        public int binarySearch(int key, int temp_arr[]) 
	            {
	                 int low = 0;
	                 int high = temp_arr.length - 1;
	                  
	                 while(high >= low) {
	                     int middle = (low + high) / 2;
	                     if(temp_arr[middle] == key) 
	                         return middle;	                     
	                     if(temp_arr[middle] < key) 
	                         low = middle + 1;                   
	                     if(temp_arr[middle] > key) 
	                         high = middle - 1;
	                     
	                }
	                return -1;
	           }
	        
}