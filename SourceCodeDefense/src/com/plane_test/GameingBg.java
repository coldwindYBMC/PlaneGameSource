package com.plane_test;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
public class GameingBg {
	//游戏背景的图片资源
	//为了循环播放，这里定义两个位图对象，
	//其资源引用的是同一张图片
	private Bitmap bmpBackGround1;
	private Bitmap bmpBackGround2;
	private Bitmap tuichu_queding;
	//游戏背景坐标
	private int bg1y, bg2y;
	//背景滚动速度
	private int speed = 10;

	//游戏背景构造函数。
	public GameingBg(Bitmap bmpBackGround,Bitmap tuichu_queding) {
		this.bmpBackGround1 = bmpBackGround;
		this.bmpBackGround2 = bmpBackGround;
		this.tuichu_queding = tuichu_queding;
	//	第一张从0开始，第二张首尾相接
		
		bg1y = 0;
	
		bg2y= bg1y+bmpBackGround1.getHeight();
	}
	//游戏背景的绘图函数
	public void draw(Canvas canvas, Paint paint) {

		canvas.drawBitmap(bmpBackGround1, 0, bg1y, paint);
		canvas.drawBitmap(bmpBackGround2, 0,bg2y , paint);
	}
//游戏背景的逻辑函数

public void logic() {

	bg1y += speed;
	bg2y += speed;	
	if(GamingBullet.bulletlv>=9){
		bg1y += speed*3;
		bg2y += speed*3;	
	}
	if (bg1y >bmpBackGround1.getHeight()) {
		bg1y = bg2y - bmpBackGround1.getHeight() ;
	
	}

	if (bg2y>bmpBackGround1.getHeight()) {
		bg2y = bg1y - bmpBackGround1.getHeight() ;

	}
	
  }
}




