package com.cn.wechat;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author chengwenbo
 *
 */
public class MainActivity2 extends Activity {
	//布局控件
	private ViewPager wechatPagerContent;
	
	//数据源
	private ArrayList<ViewGroup>  linearSources;
	
	//底层导航集合
	private ArrayList<TextView>  linearTextViews;
	
	//底层导航事件
	private NativationClick  nativationClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
           //去掉Activity上面的状态栏
          getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,  
                         WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        
        //初始化页面
        initView();
        //初始化数据
        initSource();
        //处理底层和内容页面的对应显示
        dealView();
        //为底层导航TextView添加事件
        addClick();
    }
    
    /**
     * 初始化组件
     */
    public void initView(){
    	wechatPagerContent = (ViewPager)this.findViewById(R.id.wechatContentID);
    	
    }
    
    /**
     * 初始数据源
     */
    
    public void initSource(){
    	linearSources = new ArrayList<ViewGroup>();
    	
    	linearTextViews = new ArrayList<TextView>();
    	TextView tvWechat = (TextView)this.findViewById(R.id.wecatID);
    	TextView tvMaillist = (TextView)this.findViewById(R.id.mailListID);
    	TextView tvFind = (TextView)this.findViewById(R.id.findID);
    	TextView tvMe = (TextView)this.findViewById(R.id.meID);
    	//微信，通讯录，发现，我
    	linearTextViews.add(tvWechat);
    	linearTextViews.add(tvMaillist);
    	linearTextViews.add(tvFind);
    	linearTextViews.add(tvMe);
    	
    	
    	//微信
    	linearSources.add(new WecatView(this));
    	//通讯录
    	linearSources.add(new MailListView(this));
    	
    	//发现
    	linearSources.add(new FindView(this));
    	
    	//我
    	linearSources.add(new MeView(this));
    }
    
   /**
    * 数据处理
    */
    public void dealView(){
    	wechatPagerContent.setAdapter(new customPagerAdapter());
    	wechatPagerContent.setOnPageChangeListener(new CustomPagerChange());
    	wechatPagerContent.setCurrentItem(0);
    	dealNavigationTextView(0);
    }
    
    /**
     * 底层导航添加事件
     */
    private void addClick(){
    	nativationClick = new NativationClick();
    	//为每一个textview标签添加事件
    	for(TextView tv:linearTextViews){
    		tv.setOnClickListener(nativationClick);
    	}
    }
    
    /**
     * 
     * 页面改变的事件处理
     *
     */
    private class CustomPagerChange implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			dealNavigationTextView(arg0);
		}
    	
    }

    
    
    /**
     * viewpager适配器
     */
    
    private  class customPagerAdapter extends PagerAdapter{
    	

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return linearSources.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(linearSources.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(linearSources.get(position));
		     return linearSources.get(position);
		}
    	
    }
    
    /**
     * 处理底层显示
     */
    public void dealNavigationTextView(int index){
    	//全部处理
    	for(TextView tv:linearTextViews){
    		tv.setTextColor(Color.parseColor("#666666"));
    	}
    	
    	//针对于某一个进行处理
    	try{
    	linearTextViews.get(index).setTextColor(Color.parseColor("#33ff33"));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    
    private class NativationClick implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			int index = arg0.getId();
			switch (index) {
			case R.id.wecatID:
				//微信
				wechatPagerContent.setCurrentItem(0);
		    	dealNavigationTextView(0);
				break;
			case R.id.mailListID:
				//通讯录
				wechatPagerContent.setCurrentItem(1);
		    	dealNavigationTextView(1);
				break;
			case R.id.findID:
				//发现
				wechatPagerContent.setCurrentItem(2);
		    	dealNavigationTextView(2);
				break;
			case R.id.meID:
				//我
				wechatPagerContent.setCurrentItem(3);
		    	dealNavigationTextView(3);
				break;
			}
		}
    	
    }
    
    

 
    
}
