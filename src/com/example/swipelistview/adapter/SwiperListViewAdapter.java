package com.example.swipelistview.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.swipelistview.R;

public class SwiperListViewAdapter extends BaseAdapter {

	private List<String> data;
	private Context context;
	private LayoutInflater inflater;

	public SwiperListViewAdapter(List<String> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item, null);
			new ViewHolder(convertView);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.tv_name.setText(data.get(position));
		return convertView;
	}

	class ViewHolder {
		ImageView iv_icon;
		TextView tv_name;

		public ViewHolder(View view) {
			iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
			tv_name = (TextView) view.findViewById(R.id.tv_name);
			view.setTag(this);
		}
	}
}
