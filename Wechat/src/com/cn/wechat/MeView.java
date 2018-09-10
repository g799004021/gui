package com.cn.wechat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MeView extends LinearLayout{
	private TextView tv;
	public MeView(Context context) {
		super(context);
		RelativeLayout  relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.activity_content, null);
		this.addView(relativeLayout,new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		tv = (TextView) this.findViewById(R.id.contentID);
		
		tv.setText(R.string.me);
	}


   

}

