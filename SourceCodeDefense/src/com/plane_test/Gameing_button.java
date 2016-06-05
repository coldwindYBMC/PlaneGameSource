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
		// 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     scW=GamingPlaneTest.screenW;
			scH=GamingPlaneTest.screenH;
	    // 获得图片的宽高
	     int lock_zhongli_width = lock_zhongli.getWidth();
	     int lock_zhongli_height = lock_zhongli.getHeight();
	     // 得到新的图片 //tuichu 退出透明框
	     Bitmap lock_zhongli_new = Bitmap.createBitmap(lock_zhongli,0,0, lock_zhongli_width,lock_zhongli_height, matrix, true);
	     lock_zhongli_new_butH = lock_zhongli_new.getHeight();//图片的高度
	     lock_zhongli_new_butW = lock_zhongli_new.getWidth();//图片的宽度
	     lock_zhongli_weizhi_W = scW-lock_zhongli_new_butW-scW/20;
	     lock_zhongli_weizhi_H = scH/3;
	     //开启重力时，绘图
	     if(MainActivity.zlsz&&MainActivity.zlkg){
	        canvas.drawBitmap(lock_zhongli_new,lock_zhongli_weizhi_W,lock_zhongli_weizhi_H, paint);
	     }
	     //暂停
	   pause_W=pause.getWidth();
	   pause_H=pause.getHeight();
	    pause_new=Bitmap.createBitmap(pause,0,0,  pause_W, pause_H, matrix, true);
	   pause_new_W=pause_new.getWidth();
	   pause_new_H= pause_new.getHeight();
	   
	   canvas.drawBitmap(pause,scW-pause_new.getWidth()-pause_new.getWidth(),0, paint);
	   
	}
	public void onTouchEvent(MotionEvent event) {
		//获取用户当前触屏位置
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//当用户是按下动作或移动动作
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//判定用户是否点击了按钮
			if (pointX > lock_zhongli_weizhi_W && pointX < lock_zhongli_weizhi_W + lock_zhongli_new_butW)
			{
				if (pointY > lock_zhongli_weizhi_H && pointY < lock_zhongli_weizhi_H +lock_zhongli_new_butH) 
				{
					//开启了重力
				    if(MainActivity.zlsz){
				    	//确定位置
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
			//抬起判断是否点击按钮，防止用户移动到别处
			
		}
	}
  //暂停界面	
	public void onTouchEvent1(MotionEvent event) {
		//获取用户当前触屏位置
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//当用户是按下动作或移动动作
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//判定用户是否点击了按钮
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
			//抬起判断是否点击按钮，防止用户移动到别处
			
		}
	}
	
}

