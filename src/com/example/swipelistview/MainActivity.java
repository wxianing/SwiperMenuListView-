package com.example.swipelistview;

import java.util.ArrayList;
import java.util.List;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;

import com.example.swipelistview.adapter.SwiperListViewAdapter;
import com.example.swipelistview.widget.SwipeMenu;
import com.example.swipelistview.widget.SwipeMenuCreator;
import com.example.swipelistview.widget.SwipeMenuItem;
import com.example.swipelistview.widget.SwipeMenuListView;
import com.example.swipelistview.widget.SwipeMenuListView.OnMenuItemClickListener;

public class MainActivity extends ActionBarActivity {

	private SwipeMenuListView mListView;
	private List<String> data;
	private SwiperListViewAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		mListView = (SwipeMenuListView) findViewById(R.id.swipe_listView);
		data = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			data.add("name" + i);
		}
		mAdapter = new SwiperListViewAdapter(data, this);
		mListView.setAdapter(mAdapter);
		SwipeMenuCreator creator = new SwipeMenuCreator() {

			@Override
			public void create(SwipeMenu menu) {

				// create "open" item
				SwipeMenuItem openItem = new SwipeMenuItem(
						getApplicationContext());
				// set item background
				openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
						0xCE)));
				// set item width
				openItem.setWidth(dp2px(90));
				// set item title
				openItem.setTitle("已读");
				// set item title fontsize
				openItem.setTitleSize(18);
				// set item title font color
				openItem.setTitleColor(Color.WHITE);
				// add to menu
				menu.addMenuItem(openItem);

				// create "delete" item
				SwipeMenuItem deleteItem = new SwipeMenuItem(
						getApplicationContext());
				// set item background
				deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
						0x3F, 0x25)));
				// set item width
				deleteItem.setWidth(dp2px(90));
				// set a icon
				deleteItem.setIcon(R.drawable.ic_delete);
				// add to menu
				menu.addMenuItem(deleteItem);

			}
		};

		mListView.setMenuCreator(creator);

		mListView.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public void onMenuItemClick(int position, SwipeMenu menu, int index) {

				String item = data.get(position);
				switch (index) {
				case 0:
					break;
				case 1:
					data.remove(position);
					mAdapter.notifyDataSetChanged();
					break;
				}
			}
		});
	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getResources().getDisplayMetrics());
	}
}
