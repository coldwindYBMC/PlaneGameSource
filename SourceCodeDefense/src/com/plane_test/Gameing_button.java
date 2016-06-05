package com.plane_test;
import com.plane_activity.MainActivity;
import com.plane_ui.GameMenu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Gameing_button {
	public static int scW;
	public static int scH;
	public Bitmap pause;
	Bitmap pause_new;
	public Bitmap lock_zhongli;
	int lock_zhongli_new_butH;
	int lock_zhongli_new_butW;
	int lock_zhongli_weizhi_W;
	int lock_zhongli_weizhi_H;
	int pause_new_W,pause_new_H;
	int pause_W,pause_H;
	public Gameing_button(Bitmap lock_zhongli,Bitmap pause) 
	{
		this.lock_zhongli=lock_zhongli;
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;
		this.pause=pause;
	}
	public void draw(Canvas canvas, Paint paint)
	{
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     scW=GamingPlaneTest.screenW;
			scH=GamingPlaneTest.screenH;
	    // ���ͼƬ�Ŀ��
	     int lock_zhongli_width = lock_zhongli.getWidth();
	     int lock_zhongli_height = lock_zhongli.getHeight();
	     // �õ��µ�ͼƬ //tuichu �˳�͸����
	     Bitmap lock_zhongli_new = Bitmap.createBitmap(lock_zhongli,0,0, lock_zhongli_width,lock_zhongli_height, matrix, true);
	     lock_zhongli_new_butH = lock_zhongli_new.getHeight();//ͼƬ�ĸ߶�
	     lock_zhongli_new_butW = lock_zhongli_new.getWidth();//ͼƬ�Ŀ��
	     lock_zhongli_weizhi_W = scW-lock_zhongli_new_butW-scW/20;
	     lock_zhongli_weizhi_H = scH/3;
	     //��������ʱ����ͼ
	     if(MainActivity.zlsz&&MainActivity.zlkg){
	        canvas.drawBitmap(lock_zhongli_new,lock_zhongli_weizhi_W,lock_zhongli_weizhi_H, paint);
	     }
	     //��ͣ
	   pause_W=pause.getWidth();
	   pause_H=pause.getHeight();
	    pause_new=Bitmap.createBitmap(pause,0,0,  pause_W, pause_H, matrix, true);
	   pause_new_W=pause_new.getWidth();
	   pause_new_H= pause_new.getHeight();
	   
	   canvas.drawBitmap(pause,scW-pause_new.getWidth()-pause_new.getWidth(),0, paint);
	   
	}
	public void onTouchEvent(MotionEvent event) {
		//��ȡ�û���ǰ����λ��
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//���û��ǰ��¶������ƶ�����
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//�ж��û��Ƿ����˰�ť
			if (pointX > lock_zhongli_weizhi_W && pointX < lock_zhongli_weizhi_W + lock_zhongli_new_butW)
			{
				if (pointY > lock_zhongli_weizhi_H && pointY < lock_zhongli_weizhi_H +lock_zhongli_new_butH) 
				{
					//����������
				    if(MainActivity.zlsz){
				    	//ȷ��λ��
				    	GameMenu.x=MainActivity.xValue;
				    	GameMenu.y=MainActivity.yValue;
				    	GameMenu.z=MainActivity.zValue;
				    	//toast();
				    }
				} 
			}
			
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
			
		}
	}
  //��ͣ����	
	public void onTouchEvent1(MotionEvent event) {
		//��ȡ�û���ǰ����λ��
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//���û��ǰ��¶������ƶ�����
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//�ж��û��Ƿ����˰�ť
			if (pointX > scW- pause_new.getWidth()-pause_new.getWidth() && pointX < scW-pause_new.getWidth())
			{
				if (pointY > 0 && pointY <pause_new.getHeight()) 
				{
					
				    GamingPlaneTest.gameState= GamingPlaneTest.GAMEING_EXIT;
				    
				} 
			}
			
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
			
		}
	}
	
}

