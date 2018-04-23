package one_tow_three;

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

public class CustomAdapterOTTH extends BaseAdapter /* implements OnClickListener*/ {
		private ArrayList<OneTwoThree> listData;

		private LayoutInflater layoutInflater;

		public CustomAdapterOTTH(Context context, ArrayList<OneTwoThree> listData) {
			this.listData = listData;
			layoutInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return listData.size();
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
				convertView = layoutInflater.inflate(R.layout.tab_item_one_two_three, null);
				
				holder = new ViewHolder();
				holder.num1 = (TextView) convertView.findViewById(R.id.tv_otth_1);
				holder.num2 = (TextView) convertView.findViewById(R.id.tv_otth_2);
				holder.num3 = (TextView) convertView.findViewById(R.id.tv_otth_3);
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
			holder.no.setText(""+ (position+1) + ")");			
			
			return convertView;
		}

		static class ViewHolder {
			TextView num1, num2, num3, no;
		}

	}