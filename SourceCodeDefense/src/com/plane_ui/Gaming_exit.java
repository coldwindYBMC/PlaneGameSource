package com.plane_ui;
import com.plane_test.GamingBoss;
import com.plane_test.GamingPlaneTest;
import com.plane_test.GamingPlayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Gaming_exit {
	private int scH,scW;
	Bitmap gameing_back;//推出界面
	Bitmap button_continue;
	Bitmap button_back_menu;
    int gameing_back_new_butH;
    int gameing_back_new_butW;
    int gameing_back_weizhi_W;
    int gameing_back_weizhi_H;
    int button_continue_new_butH;
    int button_continue_new_butW;
    int button_continue_weizhi_W;
    int button_continue_weizhi_H;
    int button_back_menu_butH;
    int button_back_menu_butW;
    int button_back_menu_weizhi_W;
    int button_back_menu_weizhi_H;
	public Gaming_exit(Bitmap gameing_back,Bitmap button_continue,Bitmap button_back_menu) 
	{
		this.gameing_back =gameing_back;
		this.button_continue =button_continue;
		this.button_back_menu =button_back_menu;
		//X居中，Y紧接屏幕底部
		scH =  GamingPlaneTest.screenH ;//屏幕的高度
		scW =  GamingPlaneTest.screenW; //屏幕的宽度	
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;
	}
	//菜单绘图函数
	public void draw(Canvas canvas, Paint paint) {
	     // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);  
	    // 获得图片的宽高
	     int gameing_back_width = gameing_back.getWidth();
	     int gameing_back_height = gameing_back.getHeight();
	     // 得到新的图片 //退出透明框
	     Bitmap gameing_back_new  = Bitmap.createBitmap(gameing_back,0,0, gameing_back_width, gameing_back_height, matrix, true);
	     gameing_back_new_butH = gameing_back_new.getHeight();//图片的高度
	     gameing_back_new_butW = gameing_back_new.getWidth();//图片的宽度
	     gameing_back_weizhi_W = (scW-gameing_back_new_butW)/2;
	     gameing_back_weizhi_H = scH/3;
	     canvas.drawBitmap(gameing_back_new,gameing_back_weizhi_W,gameing_back_weizhi_H, paint);
		//透明框里面的按钮，
	     //继续按钮
	     // 获得图片的宽高
	     int button_continue_width = button_continue.getWidth();
	     int button_continue_height = button_continue.getHeight();
	     Bitmap button_continue_new  = Bitmap.createBitmap(button_continue,0,0,button_continue_width,button_continue_height, matrix, true);
	     button_continue_new_butH = button_continue_new.getHeight();//图片的高度
	     button_continue_new_butW = button_continue_new.getWidth();//图片的宽度
	     int button_zhongzhuan=(gameing_back_new_butH-(2*button_continue_new_butH))/4;
	     button_continue_weizhi_W = (scW-button_continue_new_butW)/2;
	     button_continue_weizhi_H = gameing_back_weizhi_H+button_zhongzhuan;
	   //透明框里面的按钮，
	     //按钮
	     // 获得图片的宽高
	     int button_back_menu_width = button_back_menu.getWidth();
	     int button_back_menu_height = button_back_menu.getHeight();
	     Bitmap button_back_menu_new  = Bitmap.createBitmap(button_back_menu,0,0, button_back_menu_width,button_back_menu_height, matrix, true);
	     button_back_menu_butH = button_back_menu_new.getHeight();//图片的高度
	     button_back_menu_butW = button_back_menu_new.getWidth();//图片的宽度
	     button_back_menu_weizhi_W = (scW-button_back_menu_butW)/2;;
	     button_back_menu_weizhi_H = gameing_back_weizhi_H+gameing_back_new_butH-2*button_zhongzhuan-button_back_menu_height;
		 canvas.drawBitmap(button_continue_new,button_continue_weizhi_W,button_continue_weizhi_H, paint);    
		 canvas.drawBitmap(button_back_menu_new,button_back_menu_weizhi_W, button_back_menu_weizhi_H, paint);
			
		 
	}
	//菜单触屏事件函数，主要用于处理按钮事件
	public void onTouchEvent(MotionEvent event) {
		//获取用户当前触屏位置
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//当用户是按下动作或移动动作
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//当用户是抬起动作
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			//抬起判断是否点击按钮，防止用户移动到别处
			
			if (pointX > button_continue_weizhi_W && pointX <button_continue_weizhi_W + button_continue_new_butW)
			{
				if (pointY >button_continue_weizhi_H && pointY <button_continue_weizhi_H + button_continue_new_butH) 
				{   
					GamingPlaneTest.gameState = GamingPlaneTest.GAMEING;
				} 
			}
			if (pointX >button_back_menu_weizhi_W && pointX <button_back_menu_weizhi_W +button_back_menu_butW )
			{
				if (pointY>button_back_menu_weizhi_H && pointY<button_back_menu_weizhi_H +button_back_menu_butH) 
				{ 
					//还原数据
					GamingPlayer.unbeatable=false;
					GamingPlaneTest.mark=0;
					GamingPlaneTest.enemyArrayIndex=0;
					GamingPlaneTest.player.setPlayerHp(3);
					GamingPlaneTest.bulletlv=1;
					GamingPlaneTest.isBoss=false;
				    GamingBoss.chuchang=false;
					GamingPlaneTest.lv=1;
					GamingPlaneTest.k=0;
					GamingPlaneTest.vcEnemy.removeAllElements();
					GamingPlaneTest.vcBullet.removeAllElements();
					GamingPlaneTest.vcBuff.removeAllElements();
					GamingPlaneTest.vcBulletBoss.removeAllElements();			
					GamingPlaneTest.vcBulletPlayer.removeAllElements();
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_MENU;
					if(GamingPlaneTest.isSound)
					{
						GameLoading.mediaplayer.stop();
						GameLoading.mediaplayer1.stop();
					}
				}
			}
		}
	}
}
