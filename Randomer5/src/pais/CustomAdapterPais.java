package pais;

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

public class CustomAdapterPais extends BaseAdapter /* implements OnClickListener*/ {
		private ArrayList<Pais> listData;

		private LayoutInflater layoutInflater;

		public CustomAdapterPais(Context context, ArrayList<Pais> listData) {
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
				convertView = layoutInflater.inflate(R.layout.tab_item_pais, null);
				
				holder = new ViewHolder();
				holder.num1 = (TextView) convertView.findViewById(R.id.tv1);
				holder.num2 = (TextView) convertView.findViewById(R.id.tv2);
				holder.num3 = (TextView) convertView.findViewById(R.id.tv3);
				holder.num4 = (TextView) convertView.findViewById(R.id.tv4);
				holder.num5 = (TextView) convertView.findViewById(R.id.tv5);
				holder.num6 = (TextView) convertView.findViewById(R.id.tv6);
				holder.num7 = (TextView) convertView.findViewById(R.id.tv7);
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
			holder.num7.setText("" + listData.get(position).getNumberIndex(6));
			holder.no.setText(""+ (position+1) + ")");
			
			return convertView;
		}

		static class ViewHolder {
			TextView num1, num2,num3 , num4 , num5 , num6 , num7 , no;
		}

	}