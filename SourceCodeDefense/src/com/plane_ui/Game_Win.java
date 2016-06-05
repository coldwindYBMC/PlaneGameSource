package com.plane_ui;
import com.plane_test.GamingPlaneTest;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Game_Win {
	public static int scW;
	public static int scH;
	//public static float scaleWidth;
	//public static float scaleHeight;
	public Bitmap game_win;
	public Bitmap jiesuan_again;
	public Bitmap jiesuan_again_press;
	public Bitmap jiesuan_back;
	public Bitmap jiesuan_back_press;
	//再来一局
	int jiesuan_again_new_butH;
	int jiesuan_again_new_butW;
	int jiesuan_again_weizhi_W;
	int jiesuan_again_weizhi_H;
	//返回主界面
	int jiesuan_back_new_butH;
	int jiesuan_back_new_butW;
	int jiesuan_back_weizhi_W;
	int jiesuan_back_weizhi_H;
	//是否按下
    public boolean isPress_back;
    public boolean isPress_again;
	public Game_Win(Bitmap game_win,Bitmap jiesuan_again, Bitmap jiesuan_again_press, Bitmap jiesuan_back,
			Bitmap jiesuan_back_press ) 
	{   this.game_win=game_win;
		this.jiesuan_again=jiesuan_again;
		this.jiesuan_again_press=jiesuan_again_press;
		this.jiesuan_back=jiesuan_back;
		this.jiesuan_back_press=jiesuan_back_press;
		isPress_back=false;
		isPress_again=false;
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;
	}
	public void draw(Canvas canvas, Paint paint)
	{
		// 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //背景图片
	     // 获得图片的宽高
	     int game_win_width = game_win.getWidth();
	     int game_win_height = game_win.getHeight();
	     // 得到新的图片 
	     Bitmap game_win_new = Bitmap.createBitmap(game_win,0,0, game_win_width,game_win_height, matrix, true);
	     canvas.drawBitmap(game_win_new,0,0, paint);
	     //返回主界面
	     // 获得图片的宽高
	     int jiesuan_back_width = jiesuan_back.getWidth();
	     int jiesuan_back_height = jiesuan_back.getHeight();
	     // 得到新的图片 
	     Bitmap jiesuan_back_new = Bitmap.createBitmap(jiesuan_back,0,0, jiesuan_back_width,jiesuan_back_height, matrix, true);
	     jiesuan_back_new_butH = jiesuan_back_new.getHeight();//图片的高度
	     jiesuan_back_new_butW = jiesuan_back_new.getWidth();//图片的宽度
	     jiesuan_back_weizhi_W = scW/18;
	     jiesuan_back_weizhi_H = (scH/32)*27;
	     //再来一局
	     // 获得图片的宽高
	     int jiesuan_again_width = jiesuan_again.getWidth();
	     int jiesuan_again_height = jiesuan_again.getHeight();
	     // 得到新的图片 
	     Bitmap jiesuan_again_new = Bitmap.createBitmap(jiesuan_again,0,0,jiesuan_again_width,jiesuan_again_height,matrix,true);
	     jiesuan_again_new_butH = jiesuan_again_new.getHeight();//图片的高度
	     jiesuan_again_new_butW = jiesuan_again_new.getWidth();//图片的宽度
	     jiesuan_again_weizhi_W = (scW/18)*17-jiesuan_again_width;
	     jiesuan_again_weizhi_H = (scH/32)*27;
	     //按下去的效果
	     // 获得图片的宽高
	     //回到主界面的按下去的按钮
	     int jiesuan_back_press_width = jiesuan_back_press.getWidth();
	     int jiesuan_back_press_height = jiesuan_back_press.getHeight();
	     // 得到新的图片 
	     Bitmap jiesuan_back_press_new = Bitmap.createBitmap(jiesuan_back_press,0,0, jiesuan_back_press_width,jiesuan_back_press_height, matrix, true);
	     //再来一局的按下去的按钮
	     int jiesuan_again_press_width = jiesuan_again_press.getWidth();
	     int jiesuan_again_press_height = jiesuan_again_press.getHeight();
	     // 得到新的图片 
	     Bitmap jiesuan_again_press_new = Bitmap.createBitmap(jiesuan_again_press,0,0, jiesuan_again_press_width,jiesuan_again_press_height, matrix, true);
	     //判断是否按下
	     if (isPress_back) 
			{//根据是否按下绘制不同状态的按钮图
	    	    canvas.drawBitmap(jiesuan_back_press_new,jiesuan_back_weizhi_W,jiesuan_back_weizhi_H, paint);
			} else
			{
				canvas.drawBitmap(jiesuan_back_new,jiesuan_back_weizhi_W,jiesuan_back_weizhi_H, paint);
			}
	     if (isPress_again) 
			{//根据是否按下绘制不同状态的按钮图
	    	     canvas.drawBitmap(jiesuan_again_press_new,jiesuan_again_weizhi_W,jiesuan_again_weizhi_H, paint);	
			} else
			{
				 canvas.drawBitmap(jiesuan_again_new,jiesuan_again_weizhi_W,jiesuan_again_weizhi_H, paint);    	
			}
	     if(GamingPlaneTest.isSound)
			{ 
				GameLoading.mediaplayer.stop();
			}
	}
	//菜单触屏事件函数，主要用于处理按钮事件
		public void onTouchEvent(MotionEvent event) {
			//获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			
			//当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				if (pointX > jiesuan_back_weizhi_W && pointX < jiesuan_back_weizhi_W + jiesuan_back_new_butW)
				{
					if (pointY > jiesuan_back_weizhi_H && pointY < jiesuan_back_weizhi_H + jiesuan_back_new_butH) 
					{
						isPress_back = true;
					}
					else
					{
						isPress_back = false;
					}
				}
					else 
					{
						isPress_back = false;
					}
			 } 
			else if (event.getAction() == MotionEvent.ACTION_UP)
			{
	           //抬起判断是否点击按钮，防止用户移动到别处
				if (pointX > jiesuan_back_weizhi_W && pointX < jiesuan_back_weizhi_W + jiesuan_back_new_butW)
				{
					if (pointY > jiesuan_back_weizhi_H && pointY < jiesuan_back_weizhi_H + jiesuan_back_new_butH) 
					{
						isPress_back = false;
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_MENU;
					}
				}
			 }	
			}
		//菜单触屏事件函数，主要用于处理按钮事件
			public void onTouchEvent1(MotionEvent event) {
				//获取用户当前触屏位置
				int pointX = (int) event.getX();
				int pointY = (int) event.getY();
				
				//当用户是按下动作或移动动作
				if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
					if (pointX > jiesuan_again_weizhi_W && pointX < jiesuan_again_weizhi_W + jiesuan_again_new_butW)
					{
						if (pointY > jiesuan_again_weizhi_H && pointY < jiesuan_again_weizhi_H + jiesuan_again_new_butH) 
						{
							isPress_again = true;
							
						} else 
						{
							isPress_again= false;
						}
					}
						else 
						{
							isPress_again= false;
						}
				 } 
				else if (event.getAction() == MotionEvent.ACTION_UP)
				{
		//抬起判断是否点击按钮，防止用户移动到别处
					
					if (pointX > jiesuan_again_weizhi_W && pointX < jiesuan_again_weizhi_W + jiesuan_again_new_butW)
					{
						if (pointY > jiesuan_again_weizhi_H && pointY < jiesuan_again_weizhi_H + jiesuan_again_new_butH) 
						{
							isPress_again = false;
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_JUQING;
							
						} 
					}
					
				 }	
			}
}

