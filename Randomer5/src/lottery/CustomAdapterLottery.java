package lottery;

import hdriel.randomer.R;
import hdriel.randomer.R.id;
import hdriel.randomer.R.layout;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapterLottery extends BaseAdapter /* implements OnClickListener*/ {
		private ArrayList<Lottery> listData;
		private LayoutInflater layoutInflater;

		public CustomAdapterLottery(Context context, ArrayList<Lottery> listData) {
			this.listData = listData;
			layoutInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return listData.size();
		}
		
		@Override
	    public int getItemViewType(int position) {
		  // return a value between 0 and (getViewTypeCount - 1)
		  return position % 2;
	    }
		
		@Override
		public Object getItem(int position) {
			return listData.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			
			if (convertView == null)
			{
				
				int viewType = getItemViewType(position);   
				switch (viewType) 
				{
				  case 0:
					  convertView = layoutInflater.inflate(R.layout.tab_item_lottery_odd, null);
				      break;
	
				  case 1:
					  convertView = layoutInflater.inflate(R.layout.tab_item_lottery_even, null);
				      break;
			    }
			  
			
					
				holder = new ViewHolder();
				holder.num1 = (TextView) convertView.findViewById(R.id.tv_lo_1);
				holder.num2 = (TextView) convertView.findViewById(R.id.tv_lo_2);
				holder.num3 = (TextView) convertView.findViewById(R.id.tv_lo_3);
				holder.num4 = (TextView) convertView.findViewById(R.id.tv_lo_4);
				holder.num5 = (TextView) convertView.findViewById(R.id.tv_lo_5);
				holder.num6 = (TextView) convertView.findViewById(R.id.tv_lo_6);
				holder.strong = (TextView) convertView.findViewById(R.id.tv_lo_7);
				holder.no   = (TextView) convertView.findViewById(R.id.noOrder);
				
				convertView.setTag(holder);
			} 
			else 
			{
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.num1.setText("" + listData.get(position).getNumberIndex(0));
			holder.num2.setText("" + listData.get(position).getNumberIndex(1));
			holder.num3.setText("" + listData.get(position).getNumberIndex(2));
			holder.num4.setText("" + listData.get(position).getNumberIndex(3));
			holder.num5.setText("" + listData.get(position).getNumberIndex(4));
			holder.num6.setText("" + listData.get(position).getNumberIndex(5));
			holder.strong.setText("" + listData.get(position).getStrongNumber());
			holder.no.setText(""+ (position+1) + ")");
			
			return convertView;
		}

		static class ViewHolder {
			TextView num1, num2,num3 , num4 , num5 , num6 , strong, no;
		}

	}