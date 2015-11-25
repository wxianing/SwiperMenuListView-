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
		holder.nameTv.setText(data.get(position));
		return convertView;
	}

	private static class ViewHolder {
		ImageView img;
		TextView nameTv;

		public ViewHolder(View view) {
			img = (ImageView) view.findViewById(R.id.iv_icon);
			nameTv = (TextView) view.findViewById(R.id.tv_name);
			view.setTag(this);
		}
	}
}
