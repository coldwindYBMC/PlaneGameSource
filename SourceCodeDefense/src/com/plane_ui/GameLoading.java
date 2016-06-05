package com.plane_ui;
import com.plane_test.GamingPlaneTest;
import com.plane_test.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;
public class GameLoading {
	//菜单背景图
	private Bitmap jindu1;
	public static int  frameindex;
	//按钮图片资源(按下和未按下图)
	//菜单初始化
	public static MediaPlayer mediaplayer;
	public static MediaPlayer mediaplayer1;
	Paint paint;//画笔
	int process = 0;//0到100表示进度
	int startX = 90;
	int startY = 150;
	int type;//当前加载的是哪个View
	int k = 0;//加载中的点点
    int game_loading_wujin_W;
    int game_loading_wujin_H;
	public static  int scH,scW;
	//public static float scaleWidth;//比例
	//public static float scaleHeight;//比例
	int jindu1_width ;
	int jindu1_height ;
	Context context;
	public  boolean circu ;
	public GameLoading(Bitmap jindu1,Context context) {
		this.jindu1=jindu1;
		
		this.context=context;
		circu =false;
		jindu1_width = jindu1.getWidth();
	    jindu1_height = jindu1.getHeight();
	    scW=GamingPlaneTest.screenW;
	    scH=GamingPlaneTest.screenH;
	}
	//第一幅图片
	public void draw1(Canvas canvas,Paint paint) {
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);     
	     mediaplayer = MediaPlayer.create(context,R.raw.bgm_zhandou1);
	     mediaplayer.setLooping(true);
	     mediaplayer1 = MediaPlayer.create(context,R.raw.bgm_jizhanboss1);
	     mediaplayer1.setLooping(true);
	     Bitmap jindu1_new  = Bitmap.createBitmap(jindu1,0,0,jindu1_width,jindu1_height, matrix, true);
	     //进度的位置
	     int jindu1_new_width = jindu1_new.getWidth();
	     int jindu_W=(scW-jindu1_new_width)/2;
	     int jindu_H=(scH/3)*2;
	
		 canvas.save();
			canvas.clipRect(jindu_W,jindu_H, jindu_W+jindu1_new.getWidth(), jindu_H+ jindu1_new.getHeight()/6);
			canvas.drawBitmap(jindu1_new,jindu_W ,jindu_H -frameindex*jindu1_new.getHeight()/6, paint);
			canvas.restore();
	}
	
	
	
	
	
	    

			 
			 
}

