package com.cn.wechat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FindView extends LinearLayout{
	
	
	public FindView(Context context) {
		super(context);
		
		
		LinearLayout linear = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.view_find, null);
		
		this.addView(linear,new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		
		
	}
	
	
   

}
