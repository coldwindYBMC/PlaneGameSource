package com.plane_ui;
import com.plane_test.GamingPlaneTest;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class Game_juqing {
	//public static float scaleWidth;
	//public static float scaleHeight;
	public static int scW;
	public static int scH;
	private Bitmap shezhi_fanhui;
	private Bitmap shezhi_fanhui_press;
	private Bitmap juqing_guanqia;
	private Bitmap juqing_tongguo;
	float tongguo1_W;
	float tongguo1_H;
	float tongguo2_W;
	float tongguo2_H;
	float tongguo3_W;
	float tongguo3_H;
	float tongguo4_W;
	float tongguo4_H;
	float tongguo5_W;
	float tongguo5_H;
	float tongguo6_W;
	float tongguo6_H;
	float tongguo7_W;
	float tongguo7_H;
	float tongguo8_W;
	float tongguo8_H;
	float tongguo9_W;
	float tongguo9_H;
	float tongguo10_W;
	float tongguo10_H;
	int juqing_tongguo_new_width;
	int juqing_tongguo_new_height;
	public  boolean isPress_shezhi_fanhui;
	public  boolean is_tongguan1;
	public  boolean is_tongguan2;
	public  boolean is_tongguan3;
	public  boolean is_tongguan4;
	public  boolean is_tongguan5;
	public  boolean is_tongguan6;
	public  boolean is_tongguan7;
	public  boolean is_tongguan8;
	public  boolean is_tongguan9;
	public  boolean is_tongguan10;
	Context context;
	 //设置界面中的返回按钮
	int shezhi_fanhui_new_butH;
	int shezhi_fanhui_new_butW;
	int shezhi_fanhui_weizhi_W;
	int shezhi_fanhui_weizhi_H;
	public Game_juqing(Bitmap shezhi_fanhui,Bitmap shezhi_fanhui_press,Bitmap juqing_guanqia, Bitmap juqing_tongguo,Context context) {
		this.shezhi_fanhui=shezhi_fanhui;
		this.shezhi_fanhui_press=shezhi_fanhui_press;
		this.juqing_guanqia=juqing_guanqia;
		this.juqing_tongguo=juqing_tongguo;
		this.context=context;
		isPress_shezhi_fanhui= false;
		 //数据读取
		SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
		is_tongguan1 =prefs.getBoolean("is_tongguan1",false);//是否通关
		is_tongguan2 =prefs.getBoolean("is_tongguan2",false);//是否通关
		is_tongguan3 =prefs.getBoolean("is_tongguan3",false);//是否通关
		is_tongguan4 =prefs.getBoolean("is_tongguan4",false);//是否通关
		is_tongguan5 =prefs.getBoolean("is_tongguan5",false);//是否通关
		is_tongguan6 =prefs.getBoolean("is_tongguan6",false);//是否通关
		is_tongguan7 =prefs.getBoolean("is_tongguan7",false);//是否通关
		is_tongguan8 =prefs.getBoolean("is_tongguan8",false);//是否通关
		is_tongguan9 =prefs.getBoolean("is_tongguan9",false);//是否通关
		is_tongguan10 =prefs.getBoolean("is_tongguan10",false);//是否通关
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;
	}//
	//菜单绘图函数
		public void draw(Canvas canvas, Paint paint) {
		     // 放入背景图
		     Matrix matrix = new Matrix();
		     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
		     //设置界面的返回按钮
			 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
		     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
		     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//图片的高度
		     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//图片的宽度
		     shezhi_fanhui_weizhi_W = GamingPlaneTest.screenW/18;
		     shezhi_fanhui_weizhi_H = GamingPlaneTest.screenH/16;
		    // 获得图片的宽高
		     int juqing_guanqia_width = juqing_guanqia.getWidth();
		     int juqing_guanqia_height = juqing_guanqia.getHeight();
		      ///新图片
		     Bitmap juqing_guanqia_new  = Bitmap.createBitmap(juqing_guanqia,0,0, juqing_guanqia_width, juqing_guanqia_height, matrix, true);
		     canvas.drawBitmap(juqing_guanqia_new,0,0, paint);
		     //通过关卡的图片
		     int juqing_tongguo_width = juqing_tongguo.getWidth();
		     int juqing_tongguo_height = juqing_tongguo.getHeight();
		      ///新图片
		     Bitmap juqing_tongguo_new  = Bitmap.createBitmap(juqing_tongguo,0,0, juqing_tongguo_width, juqing_tongguo_height, matrix, true);
		     juqing_tongguo_new_width = juqing_tongguo_new.getWidth();
		     juqing_tongguo_new_height = juqing_tongguo_new.getHeight();
		     tongguo1_W=(scW/10)*7;
			 tongguo1_H=(scH/10)*8;
			 tongguo2_W=(scW/10)*4;
			 tongguo2_H=(scH/10)*7;
			 tongguo3_W=0;
			 tongguo3_H=(scH/10)*6;
			 tongguo4_W=(scW/10)*2;
			 tongguo4_H=(scH/10)*5;
			 tongguo5_W=(scW/10)*4;
			 tongguo5_H=(scH/10)*6;
			 tongguo6_W=(scW/10)*7;
			 tongguo6_H=(scH/10)*5;
			 tongguo7_W=(scW/10)*6;
			 tongguo7_H=(scH/10)*4;
			 tongguo8_W=(scW/10)*3;
			 tongguo8_H=(scH/10)*3;
			 tongguo9_W=(scW/10)*6;
			 tongguo9_H=(scH/10)*2;
			 tongguo10_W=(scW/10)*5;
			 tongguo10_H=(scH/10)*1;
			//绘制未按下按钮图
				if (isPress_shezhi_fanhui) {
				//根据是否按下绘制不同状态的按钮图
					canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
				} else {
					canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
				}
		     if (is_tongguan1) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo1_W,tongguo1_H,paint);
				}
		     else
		     {}
		     if (is_tongguan2) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo2_W,tongguo2_H,paint);
				}
		     else
		     {}
		     if (is_tongguan3) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo3_W,tongguo3_H,paint);
				}
		     else
		     {}
		     if (is_tongguan4) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo4_W,tongguo4_H,paint);
				}
		     else
		     {}
		     if (is_tongguan5) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo5_W,tongguo5_H,paint);
				}
		     else
		     {}
		     if (is_tongguan6) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo6_W,tongguo6_H,paint);
				}
		     else
		     {}
		     if (is_tongguan7) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo7_W,tongguo7_H,paint);
				}
		     else
		     {}
		     if (is_tongguan8) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo8_W,tongguo8_H,paint);
				}
		     else
		     {}
		     if (is_tongguan9) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo9_W,tongguo9_H,paint);
				}
		     else
		     {}
		     if (is_tongguan10) 
				{
					  canvas.drawBitmap(juqing_tongguo_new,tongguo10_W,tongguo10_H,paint);
				}
		     else
		     {}
		     
		}
		//菜单触屏事件函数，主要用于处理按钮事件
				public void onTouchEvent1(MotionEvent event) {
					//获取用户当前触屏位置
					int pointX = (int) event.getX();
					int pointY = (int) event.getY();
					//当用户是按下动作或移动动作
					if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
						//判定用户是否点击了按钮
						//返回
						if (pointX >shezhi_fanhui_weizhi_W && pointX <shezhi_fanhui_weizhi_W + shezhi_fanhui_new_butW)
						{
							if (pointY >shezhi_fanhui_weizhi_H && pointY < shezhi_fanhui_weizhi_H+shezhi_fanhui_new_butH) 
							{   
								isPress_shezhi_fanhui= true;
							} else 
							{
								isPress_shezhi_fanhui= false;
							}
						}
						else 
						{   
							isPress_shezhi_fanhui= false;
						}
						//当用户是抬起动作
					} else if (event.getAction() == MotionEvent.ACTION_UP) {
						//抬起判断是否点击按钮，防止用户移动到别处
						if (pointX >shezhi_fanhui_weizhi_W && pointX <shezhi_fanhui_weizhi_W + shezhi_fanhui_new_butW)
						{
							if (pointY >shezhi_fanhui_weizhi_H && pointY < shezhi_fanhui_weizhi_H+shezhi_fanhui_new_butH) 
							{   
								isPress_shezhi_fanhui= false;
								GamingPlaneTest.gameState = GamingPlaneTest.GAME_MENU;	
								if(GamingPlaneTest.isSound)
								{    try
								  {
									GamingPlaneTest.mediaplayer.start();
								  }catch(Exception e){}
								 try
									{
									 GamingPlaneTest.mediaplayer4.pause();
									}catch(Exception e){}
								
								}	
							} 
						}		
					}
				}
		//菜单触屏事件函数，主要用于处理按钮事件
		public void onTouchEvent(MotionEvent event) {
			//获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//判定用户是否点击了按钮
				if (pointX >tongguo1_W&& pointX < tongguo1_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo1_H && pointY < tongguo1_H + juqing_tongguo_new_height) 
					{
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE1;
					} 
				}
				if (pointX >tongguo2_W&& pointX < tongguo2_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo2_H && pointY < tongguo2_H + juqing_tongguo_new_height) 
					{
			          	if(is_tongguan1)
			          	{
                        	 GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE2;
			          	}
					} 
				}
				if (pointX >tongguo3_W&& pointX < tongguo3_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo3_H && pointY < tongguo3_H + juqing_tongguo_new_height) 
					{    
						if(is_tongguan2)
			          	{
						   GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE3;
			          	}
					} 
				}
				if (pointX >tongguo4_W&& pointX < tongguo4_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo4_H && pointY < tongguo4_H + juqing_tongguo_new_height) 
					{    
						if(is_tongguan3)
			          	{
						 
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE4;
			          	}
					} 
				}
				if (pointX >tongguo5_W&& pointX < tongguo5_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo5_H && pointY < tongguo5_H + juqing_tongguo_new_height) 
					{
						if(is_tongguan4)
			          	{
						    GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE5;
			          	}
					} 
				}
				if (pointX >tongguo6_W&& pointX < tongguo6_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo6_H && pointY < tongguo6_H + juqing_tongguo_new_height) 
					{   

						if(is_tongguan5)
			          	{
						    GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE6;
			          	}
					} 
				}
				if (pointX >tongguo7_W&& pointX < tongguo7_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo7_H && pointY < tongguo7_H + juqing_tongguo_new_height) 
					{    
						if(is_tongguan6)
			          	{
						  GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE7;
			          	}
					} 
				}
				if (pointX >tongguo8_W&& pointX < tongguo8_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo8_H && pointY < tongguo8_H + juqing_tongguo_new_height) 
					{    
						if(is_tongguan7)
			          	{
						  GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE8;
			          	}
					} 
				}
				if (pointX >tongguo9_W&& pointX < tongguo9_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo9_H && pointY < tongguo9_H + juqing_tongguo_new_height) 
					{    
						if(is_tongguan8)
			          	{
						  GamingPlaneTest.gameState = GamingPlaneTest.GAME_STATE9;
			          	}
					} 
				}
				if (pointX >tongguo10_W&& pointX < tongguo10_W + juqing_tongguo_new_width)
				{
					if (pointY > tongguo10_H && pointY < tongguo10_H + juqing_tongguo_new_height) 
					{
						if(is_tongguan9)
			          	{}
					} 
				}
				
				//当用户是抬起动作
			} 
			else if (event.getAction() == MotionEvent.ACTION_UP)
			{}
		}
		
}
