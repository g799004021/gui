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
	//���ֿؼ�
	private ViewPager wechatPagerContent;
	
	//����Դ
	private ArrayList<ViewGroup>  linearSources;
	
	//�ײ㵼������
	private ArrayList<TextView>  linearTextViews;
	
	//�ײ㵼���¼�
	private NativationClick  nativationClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
           //ȥ��Activity�����״̬��
          getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,  
                         WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        
        //��ʼ��ҳ��
        initView();
        //��ʼ������
        initSource();
        //����ײ������ҳ��Ķ�Ӧ��ʾ
        dealView();
        //Ϊ�ײ㵼��TextView����¼�
        addClick();
    }
    
    /**
     * ��ʼ�����
     */
    public void initView(){
    	wechatPagerContent = (ViewPager)this.findViewById(R.id.wechatContentID);
    	
    }
    
    /**
     * ��ʼ����Դ
     */
    
    public void initSource(){
    	linearSources = new ArrayList<ViewGroup>();
    	
    	linearTextViews = new ArrayList<TextView>();
    	TextView tvWechat = (TextView)this.findViewById(R.id.wecatID);
    	TextView tvMaillist = (TextView)this.findViewById(R.id.mailListID);
    	TextView tvFind = (TextView)this.findViewById(R.id.findID);
    	TextView tvMe = (TextView)this.findViewById(R.id.meID);
    	//΢�ţ�ͨѶ¼�����֣���
    	linearTextViews.add(tvWechat);
    	linearTextViews.add(tvMaillist);
    	linearTextViews.add(tvFind);
    	linearTextViews.add(tvMe);
    	
    	
    	//΢��
    	linearSources.add(new WecatView(this));
    	//ͨѶ¼
    	linearSources.add(new MailListView(this));
    	
    	//����
    	linearSources.add(new FindView(this));
    	
    	//��
    	linearSources.add(new MeView(this));
    }
    
   /**
    * ���ݴ���
    */
    public void dealView(){
    	wechatPagerContent.setAdapter(new customPagerAdapter());
    	wechatPagerContent.setOnPageChangeListener(new CustomPagerChange());
    	wechatPagerContent.setCurrentItem(0);
    	dealNavigationTextView(0);
    }
    
    /**
     * �ײ㵼������¼�
     */
    private void addClick(){
    	nativationClick = new NativationClick();
    	//Ϊÿһ��textview��ǩ����¼�
    	for(TextView tv:linearTextViews){
    		tv.setOnClickListener(nativationClick);
    	}
    }
    
    /**
     * 
     * ҳ��ı���¼�����
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
     * viewpager������
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
     * ����ײ���ʾ
     */
    public void dealNavigationTextView(int index){
    	//ȫ������
    	for(TextView tv:linearTextViews){
    		tv.setTextColor(Color.parseColor("#666666"));
    	}
    	
    	//�����ĳһ�����д���
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
				//΢��
				wechatPagerContent.setCurrentItem(0);
		    	dealNavigationTextView(0);
				break;
			case R.id.mailListID:
				//ͨѶ¼
				wechatPagerContent.setCurrentItem(1);
		    	dealNavigationTextView(1);
				break;
			case R.id.findID:
				//����
				wechatPagerContent.setCurrentItem(2);
		    	dealNavigationTextView(2);
				break;
			case R.id.meID:
				//��
				wechatPagerContent.setCurrentItem(3);
		    	dealNavigationTextView(3);
				break;
			}
		}
    	
    }
    
    

 
    
}
