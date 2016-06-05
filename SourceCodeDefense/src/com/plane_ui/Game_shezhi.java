package com.plane_ui;
import com.plane_activity.MainActivity;
import com.plane_test.GamingPlaneTest;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class Game_shezhi {
	public static int scH;
	public static int scW;
	//菜单背景图
	Bitmap shezhi_guanyu;
	Bitmap shezhi_shengming;
	Bitmap shezhi_bangzhu;
	Bitmap shezhi_fanhui;
	Bitmap shezhi_mengban;
	Bitmap shezhi_fanhui_press;
	Bitmap shezhi_duihao;
	//图片的各种属性，包括高度，宽度等
	//蒙版位置
	int shezhi_mengban_new_butH;
	int shezhi_mengban_new_butW;
	int shezhi_mengban_weizhi_W;
	int shezhi_mengban_weizhi_H;
	 //设置界面中的返回按钮
	int shezhi_fanhui_new_butH;
	int shezhi_fanhui_new_butW;
	int shezhi_fanhui_weizhi_W;
	int shezhi_fanhui_weizhi_H;
	//设置界面的帮助按钮
	int shezhi_bangzhu_new_butH;
	int shezhi_bangzhu_new_butW;
	int shezhi_bangzhu_weizhi_W;
	int shezhi_bangzhu_weizhi_H;
	//设置关于
	int shezhi_guanyu_new_butH;
	int shezhi_guanyu_new_butW;
	int shezhi_guanyu_weizhi_W;
	int shezhi_guanyu_weizhi_H;
	//设置声明
	int shezhi_shengming_new_butH;
	int shezhi_shengming_new_butW;
	int shezhi_shengming_weizhi_W;
	int shezhi_shengming_weizhi_H;
	//按下去的状态
	private boolean isPress_shezhi_fanhui;
	//音乐开关
	private boolean isPress_shezhi_yinyue;
	//重力开关
	private boolean isPress_shezhi_zhongli;
	Context context;
	private boolean isPress_shezhi_zhendong;
	public Game_shezhi( Bitmap shezhi_fanhui,Bitmap shezhi_guanyu, Bitmap shezhi_bangzhu,Bitmap shezhi_shengming,
			Bitmap shezhi_mengban,	Bitmap shezhi_fanhui_press,Bitmap shezhi_duihao,Context context) {
		//X居中，Y紧接屏幕底部
				this.shezhi_fanhui=shezhi_fanhui;
				this.shezhi_guanyu=shezhi_guanyu;
				this.shezhi_shengming=shezhi_shengming;
				this.shezhi_bangzhu=shezhi_bangzhu;
				this.shezhi_mengban=shezhi_mengban;
				this.shezhi_fanhui_press=shezhi_fanhui_press;
				this.shezhi_duihao=shezhi_duihao;
				this.context=context;
				isPress_shezhi_fanhui= false;
				  //数据读取
				SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
		        isPress_shezhi_yinyue =prefs.getBoolean("isPress_shezhi_yinyue",true);//设置音乐开关
		        isPress_shezhi_zhongli =prefs.getBoolean("isPress_shezhi_zhongli",false);//重力开关
		        isPress_shezhi_zhendong=prefs.getBoolean("isPress_shezhi_zhendong",false);//重力开关
		        scW=GamingPlaneTest.screenW;
				scH=GamingPlaneTest.screenH;
	}
	//菜单绘图函数
	public void draw(Canvas canvas, Paint paint) {
		 // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
		 //蒙版界面的摆放
		 int shezhi_mengban_width = shezhi_mengban.getWidth();
	     int shezhi_mengban_height = shezhi_mengban.getHeight();
	     Bitmap shezhi_mengban_new  = Bitmap.createBitmap(shezhi_mengban,0,0,shezhi_mengban_width,shezhi_mengban_height, matrix, true);
	     shezhi_mengban_new_butH = shezhi_mengban_new.getHeight();//图片的高度
	     shezhi_mengban_new_butW = shezhi_mengban_new.getWidth();//图片的宽度
	     shezhi_mengban_weizhi_W = (scW-shezhi_mengban_new_butW)/2;
	     shezhi_mengban_weizhi_H = (scH/16)*3;
	     canvas.drawBitmap(shezhi_mengban_new,shezhi_mengban_weizhi_W,shezhi_mengban_weizhi_H, paint);//蒙版的位置
		 //设置界面的返回按钮
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//图片的高度
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//图片的宽度
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;
	     //设置界面的帮助按钮
	     int shezhi_bangzhu_width = shezhi_bangzhu.getWidth();
	     int shezhi_bangzhu_height = shezhi_bangzhu.getHeight();
	     Bitmap shezhi_bangzhu_new  = Bitmap.createBitmap(shezhi_bangzhu,0,0,shezhi_bangzhu_width,shezhi_bangzhu_height, matrix, true);
	     shezhi_bangzhu_new_butH = shezhi_bangzhu_new.getHeight();//图片的高度
	     shezhi_bangzhu_new_butW = shezhi_bangzhu_new.getWidth();//图片的宽度
	     shezhi_bangzhu_weizhi_W = scW/18;
	     shezhi_bangzhu_weizhi_H = (scH/8)*7;
	     //关于的按钮
	     int shezhi_guanyu_width = shezhi_guanyu.getWidth();
	     int shezhi_guanyu_height = shezhi_guanyu.getHeight();
	     Bitmap shezhi_guanyu_new  = Bitmap.createBitmap(shezhi_guanyu,0,0,shezhi_guanyu_width,shezhi_guanyu_height, matrix, true);
	     shezhi_guanyu_new_butH = shezhi_guanyu_new.getHeight();//图片的高度
	     shezhi_guanyu_new_butW = shezhi_guanyu_new.getWidth();//图片的宽度
	     shezhi_guanyu_weizhi_W = (scW/18)*7;
	     shezhi_guanyu_weizhi_H = (scH/8)*7;
	     //声明的按钮
	     int shezhi_shengming_width = shezhi_shengming.getWidth();
	     int shezhi_shengming_height = shezhi_shengming.getHeight();
	     Bitmap shezhi_shengming_new  = Bitmap.createBitmap(shezhi_shengming,0,0,shezhi_shengming_width,shezhi_shengming_height, matrix, true);
	     shezhi_shengming_new_butH = shezhi_shengming_new.getHeight();//图片的高度
	     shezhi_shengming_new_butW = shezhi_shengming_new.getWidth();//图片的宽度
	     shezhi_shengming_weizhi_W = (scW/18)*13;
	     shezhi_shengming_weizhi_H = (scH/8)*7;
	     //设置开关中的对号
	     //音乐对号
	     int shezhi_duihao_width = shezhi_duihao.getWidth();
	     int shezhi_duihao_height = shezhi_duihao.getHeight();
	     Bitmap shezhi_duihao_new  = Bitmap.createBitmap(shezhi_duihao,0,0,shezhi_duihao_width,shezhi_duihao_height, matrix, true);
	     float shezhi_yinyue_weizhi_W = shezhi_mengban_weizhi_W+(shezhi_mengban_new_butW/17)*12;
	     float shezhi_yinyue_weizhi_H = shezhi_mengban_weizhi_H+(shezhi_mengban_new_butH/220)*39;
	     //重力感应的对号
	     float shezhi_zhongli_weizhi_W = (scW/36)*25;
	     float shezhi_zhongli_weizhi_H = (scH/320)*139;
	     //z震动反馈感应的对号
	     float shezhi_zhendong_weizhi_W = (scW/36)*25;
	     float shezhi_zhendong_weizhi_H = (scH/16)*9;
		//绘制未按下按钮图
		if (isPress_shezhi_fanhui) {
		//根据是否按下绘制不同状态的按钮图
			canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		} else {
			canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		}
		//帮助界面
		canvas.drawBitmap(shezhi_bangzhu_new ,shezhi_bangzhu_weizhi_W,shezhi_bangzhu_weizhi_H, paint);
		//关于界面
		canvas.drawBitmap(shezhi_guanyu_new ,shezhi_guanyu_weizhi_W,shezhi_guanyu_weizhi_H, paint);
		canvas.drawBitmap(shezhi_shengming_new ,shezhi_shengming_weizhi_W,shezhi_shengming_weizhi_H, paint);	
		//音乐开关
		if (isPress_shezhi_yinyue) {
			//根据是否按下绘制不同状态的按钮图
			canvas.drawBitmap(shezhi_duihao_new,shezhi_yinyue_weizhi_W,shezhi_yinyue_weizhi_H, paint);
			
			}
		else { 
			
			}	
		//重力开关
		if (isPress_shezhi_zhongli) {
					//根据是否按下绘制不同状态的按钮图
			canvas.drawBitmap(shezhi_duihao_new,shezhi_zhongli_weizhi_W,shezhi_zhongli_weizhi_H, paint);
			}
		else { 
					
			}	
		if (isPress_shezhi_zhendong) {
			//根据是否按下绘制不同状态的按钮图
			canvas.drawBitmap(shezhi_duihao_new,shezhi_zhendong_weizhi_W,shezhi_zhendong_weizhi_H, paint);
	     }
        else { 
			
	      }	
	} 
	///帮助界面
	//菜单绘图函数
		public void draw1(Canvas canvas, Paint paint) {
			 // 取得想要缩放的matrix参数
		     Matrix matrix = new Matrix();
		     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
			 //设置界面的返回按钮
			 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
		     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
		     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//图片的高度
		     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//图片的宽度
		     shezhi_fanhui_weizhi_W = scW/18;
		     shezhi_fanhui_weizhi_H = scH/16;
			//绘制未按下按钮图
			if (isPress_shezhi_fanhui) {
			//根据是否按下绘制不同状态的按钮图
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
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
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {}
				//当用户是抬起动作
			 else if (event.getAction() == MotionEvent.ACTION_UP) {
				//帮助界面抬起是动作
				if (pointX >shezhi_bangzhu_weizhi_W&& pointX <shezhi_bangzhu_weizhi_W+ shezhi_bangzhu_new_butW)
				{
					if (pointY >shezhi_bangzhu_weizhi_H&& pointY <shezhi_bangzhu_weizhi_H+ shezhi_bangzhu_new_butH ) 
					{   
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI_BANGZHU;	
					} 
				}
				//关于界面的切换
				if (pointX >shezhi_guanyu_weizhi_W&& pointX <shezhi_guanyu_weizhi_W+ shezhi_bangzhu_new_butW)
				{
					if (pointY >shezhi_guanyu_weizhi_H&& pointY <shezhi_guanyu_weizhi_H+ shezhi_bangzhu_new_butH ) 
					{   
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI_GUANYU;	
					} 
				}
				//声明按钮
				if (pointX >shezhi_shengming_weizhi_W&& pointX <shezhi_shengming_weizhi_W+ shezhi_bangzhu_new_butW)
				{
					if (pointY >shezhi_shengming_weizhi_H&& pointY <shezhi_shengming_weizhi_H+ shezhi_bangzhu_new_butH ) 
					{   
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI_SHENGMING;	
					}
				}
		   }
		}
		public void onTouchEvent2(MotionEvent event) {
			//获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//音乐开关
				if (pointX >scW/8 && pointX <(scW/8)*7)
				{
					if (pointY >(scH/32)*9 && pointY <(scH/128)*49) 
					{   
						if(!GamingPlaneTest.isSound)
						  {
						    GamingPlaneTest.mediaplayer.start();
						  }
						if(GamingPlaneTest.isSound)
						  {
						    GamingPlaneTest.mediaplayer.pause();
						  }
						//数据存储
						SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
						SharedPreferences.Editor editor=prefs.edit();
						if(isPress_shezhi_yinyue)
						{
							editor.putBoolean("isPress_shezhi_yinyue",false);
							editor.putBoolean("isSound",false);
						}
						else if(!isPress_shezhi_yinyue)
						{
							editor.putBoolean("isPress_shezhi_yinyue",true);
							editor.putBoolean("isSound",true);
						}
						isPress_shezhi_yinyue=!isPress_shezhi_yinyue;
						editor.commit();
						GamingPlaneTest.isSound=!GamingPlaneTest.isSound;
					}
				}
				//重力开关
				if (pointX >scW/8 && pointX <(scW/8)*7)
				{
					if (pointY >(scH/128)*52 && pointY <(scH/128)*65) 
					{   
						isPress_shezhi_zhongli=!isPress_shezhi_zhongli;
						if(MainActivity.zlsz)
						{
							MainActivity.zlsz=false;					
						}
						else{
							MainActivity.zlsz=true;	
						}
						//MainActivity.zlsz=true;
					}
				}
				
				//震动开关
				if (pointX >scW/8 && pointX <(scW/8)*7)
				{
					if (pointY >(scH/128)*69 && pointY <(scH/128)*82) 
					{   
						isPress_shezhi_zhendong=!isPress_shezhi_zhendong;
						if(MainActivity.vikg){
						      MainActivity.vikg=false;					   
					      }
						else{
							MainActivity.vikg=true;					
				     }
				}
				}
				//当用户是抬起动作
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				//抬起判断是否点击按钮，防止用户移动到别处
			
		   }
		}
}
	
	
