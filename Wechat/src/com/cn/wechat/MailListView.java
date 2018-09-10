package com.cn.wechat;

import java.util.ArrayList;
import java.util.HashMap;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MailListView extends LinearLayout {

	

	public MailListView(Context context) {
		super(context);
		LinearLayout linear = (LinearLayout) LayoutInflater.from(context)
				.inflate(R.layout.view_list, null);

		this.addView(linear, new RelativeLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

		
	}

	


}
