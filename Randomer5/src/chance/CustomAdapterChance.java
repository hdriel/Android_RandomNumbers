package chance;

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
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterChance extends BaseAdapter /* implements OnClickListener*/ {
		private ArrayList<Chance> listData;

		private LayoutInflater layoutInflater;

		public CustomAdapterChance(Context context, ArrayList<Chance> listData) {
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
				convertView = layoutInflater.inflate(R.layout.tab_item_chance, parent, false); 
				
				holder = new ViewHolder();
				holder.guar = (ImageView) convertView.findViewById(R.id.iv_guar);
				holder.lev  = (ImageView) convertView.findViewById(R.id.iv_lev);
				holder.dym  = (ImageView) convertView.findViewById(R.id.iv_dym);
				holder.clov = (ImageView) convertView.findViewById(R.id.iv_clov);
				holder.no   = (TextView)  convertView.findViewById(R.id.noOrder);
				convertView.setTag(holder);
			} 
			else 
			{
				holder = (ViewHolder) convertView.getTag();
			}
			
			
			// set value into imageViews
			switch(listData.get(position).getNumberIndex(0)){
			case 7:
				holder.guar.setBackgroundResource(R.drawable.guar7);
				break;
			case 8:
				holder.guar.setBackgroundResource(R.drawable.guar8);
				break;
			case 9:
				holder.guar.setBackgroundResource(R.drawable.guar9);
				break;
			case 10:
				holder.guar.setBackgroundResource(R.drawable.guar10);
				break;
			case 11:
				holder.guar.setBackgroundResource(R.drawable.guar11);
				break;
			case 12:
				holder.guar.setBackgroundResource(R.drawable.guar12);
				break;
			case 13:
				holder.guar.setBackgroundResource(R.drawable.guar13);
				break;
			case 14:
				holder.guar.setBackgroundResource(R.drawable.guar1);
				break;
			default:
				holder.clov.setBackgroundResource(R.drawable.card);
			}
			switch(listData.get(position).getNumberIndex(1)){
			case 7:
				holder.lev.setBackgroundResource(R.drawable.lev7);
				break;
			case 8:
				holder.lev.setBackgroundResource(R.drawable.lev8);
				break;
			case 9:
				holder.lev.setBackgroundResource(R.drawable.lev9);
				break;
			case 10:
				holder.lev.setBackgroundResource(R.drawable.lev10);
				break;
			case 11:
				holder.lev.setBackgroundResource(R.drawable.lev11);
				break;
			case 12:
				holder.lev.setBackgroundResource(R.drawable.lev12);
				break;
			case 13:
				holder.lev.setBackgroundResource(R.drawable.lev13);
				break;
			case 14:
				holder.lev.setBackgroundResource(R.drawable.lev1);
				break;
			default:
				holder.clov.setBackgroundResource(R.drawable.card);
			}
			switch(listData.get(position).getNumberIndex(2)){
			case 7:
				holder.dym.setBackgroundResource(R.drawable.dym7);
				break;
			case 8:
				holder.dym.setBackgroundResource(R.drawable.dym8);
				break;
			case 9:
				holder.dym.setBackgroundResource(R.drawable.dym9);
				break;
			case 10:
				holder.dym.setBackgroundResource(R.drawable.dym10);
				break;
			case 11:
				holder.dym.setBackgroundResource(R.drawable.dym11);
				break;
			case 12:
				holder.dym.setBackgroundResource(R.drawable.dym12);
				break;
			case 13:
				holder.dym.setBackgroundResource(R.drawable.dym13);
				break;
			case 14:
				holder.dym.setBackgroundResource(R.drawable.dym1);
				break;
			default:
				holder.clov.setBackgroundResource(R.drawable.card);
			}
			switch(listData.get(position).getNumberIndex(3)){
			case 7:
				holder.clov.setBackgroundResource(R.drawable.clov7);
				break;
			case 8:
				holder.clov.setBackgroundResource(R.drawable.clov8);
				break;
			case 9:
				holder.clov.setBackgroundResource(R.drawable.clov9);
				break;
			case 10:
				holder.clov.setBackgroundResource(R.drawable.clov10);
				break;
			case 11:
				holder.clov.setBackgroundResource(R.drawable.clov11);
				break;
			case 12:
				holder.clov.setBackgroundResource(R.drawable.clov12);
				break;
			case 13:
				holder.clov.setBackgroundResource(R.drawable.clov13);
				break;
			case 14:
				holder.clov.setBackgroundResource(R.drawable.clov1);
				break;
			default:
				holder.clov.setBackgroundResource(R.drawable.card);
			}
					
			holder.no.setText(""+ (position+1) + ")");
			
			return convertView;
		}

		static class ViewHolder {
			ImageView guar, lev, dym, clov ;
			TextView no;
		}

	}