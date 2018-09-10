package com.cn.wechat;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private ArrayList<LinearLayout> linearList;
	
	private GestureDetector  gestureDetector;
	
	private static int index = 0;
	
	/**
	 * ������Ϣ�Ĳ���
	 */
	
	private LinearLayout linear_content;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
           //ȥ��Activity�����״̬��
          getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,  
                         WindowManager.LayoutParams. FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_main);
        
        initView();
        
        gestureDetector = new GestureDetector(this, new CustomChange());
      
    }

    /**
     * ��ʼ����Ϣ
     */
    public void initView(){
    	
    	linearList = new ArrayList<LinearLayout>();
    	
    	linear_content = (LinearLayout)this.findViewById(R.id.contex);
    	
    	//΢��
    	LinearLayout linearW = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.activity_content, null);
    	//ͨѶ¼
    	LinearLayout linearM = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.activity_content, null);
    	//����
    	LinearLayout linearF = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.activity_content, null);
    	//��
    	LinearLayout linearI = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.activity_content, null);
    	//΢��
    	linearList.add(new WecatView(this));
    	//ͨѶ¼
    	linearList.add(new MailListView(this));
    	//����
    	linearList.add(new FindView(this));
    	//��
    	linearList.add(new MeView(this));
    	
    	dealView(index);
    }
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	return gestureDetector.onTouchEvent(event);
    }
    
    
    /**
     * �����¼���ȡ
     */
    private class CustomChange implements GestureDetector.OnGestureListener{

		@Override
		public boolean onDown(MotionEvent arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float arg2,
				float arg3) {
			// TODO Auto-generated method stub
			float x = e2.getX() - e1.getX();  
            float y = e2.getY() - e1.getY();  
  
            if (x > 0) {  
                //���һ���
            	if(index == linearList.size()-1){
            		index = 0;
            	}
            	dealView(index);
            } else if (x < 0) {  
               //���󻬶�
            	if(index == 0){
            		index = linearList.size()-1;
            	}
            	dealView(index);
            	
            }  
            return true;  
		}

		@Override
		public void onLongPress(MotionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
				float arg3) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent arg0) {
			// TODO Auto-generated method stub
			return false;
		}
    	
    }
    
    /**
     * ���洦��
     */
    
    public void dealView(int index){
    	if(linearList.size()>=index+1){
    		linear_content.removeAllViews();
    		linear_content.addView(linearList.get(index));
    	}
    }
    
    
    
    
    
    

 
    
}
