package com.zzcm.locker.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzcm.locker.R;

public class WidgetFrament2 extends BaseFrament<MainActivity> {

	ImageView appLink1;
	ImageView appLink2;
	ImageView appLink3;
	ImageView appLink4;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.widget_left, container, false);
		initViews();
		return root;
		
	}

	private void initViews() {
		((TextView)getView(R.id.tv_test)).setText("sksks哈全");
	}

}
