package com.plane_ui;
import com.plane_database.DataBase_Player;
import com.plane_test.GamingJsNum;
import com.plane_test.GamingPlaneTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Game_Shop {
	Bitmap shezhi_fanhui;
	Bitmap shezhi_fanhui_press;
	Bitmap shop_daoju;

	Bitmap shop_shangpin;
	Bitmap shop_buy;
	Bitmap shop_nobuy;
	Bitmap shop_xunbao;
	private GamingJsNum jsum;
	Bitmap	score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11;
	public static int scH;
	public static int scW;
	Context context;
    //道具
	int value,value1;
    int shop_daoju_butH;
    int shop_daoju_butW;
    int daoju_weizhi_W;
    int daoju_weizhi_H;
    int daoju_height ;
    int daoju_width;
    int daoju_H;
    int daoju_W;
    int shop_mengban_new_butH;
    int shop_mengban_new_butW;
    int shop_mengban_weizhi_W;
    int shop_mengban_weizhi_H;
    int shezhi_fanhui_weizhi_H;
    int shezhi_fanhui_new_butW ;
    int shezhi_fanhui_new_butH ;
    public static int goldcoin;
    private boolean isPress_shezhi_fanhui;
    DataBase_Player database_player;
    public static boolean plane1, plane2;
    public static boolean shangpin1, shangpin2, shangpin3 , shangpin4,shangpin5;
	public Game_Shop(Bitmap shezhi_fanhui,Bitmap shezhi_fanhui_press,Bitmap shop_daoju,
			Bitmap shop_shangpin,Bitmap shop_buy,Bitmap shop_nobuy,
			Bitmap shop_xunbao,  Context context) 
	{   
		this.shezhi_fanhui_press=shezhi_fanhui_press;
		this.shezhi_fanhui=shezhi_fanhui;
		this.context=context;
		this.shop_daoju=shop_daoju;
	
		this.shop_shangpin=shop_shangpin;
		this.shop_buy=shop_buy;
		this.shop_nobuy=shop_nobuy;
		this.shop_xunbao=shop_xunbao;
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;	
		isPress_shezhi_fanhui= false;
		database_player=new DataBase_Player(context);
		plane1=DataBase_Player.plane1;
		plane2=DataBase_Player.plane2;
	}
	//菜单绘图函数
	public void draw1(Canvas canvas, Paint paint) {
	     // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);
	     // 得到新的图片
	     int jsm_width1=GamingPlaneTest.jsm.getWidth();
		 int jsm_height1=GamingPlaneTest.jsm.getHeight();
		Bitmap jsm_new1  = Bitmap.createBitmap(GamingPlaneTest.jsm,0,0,jsm_width1,jsm_height1, matrix, true);
	    	int jsm_new_width1=jsm_new1.getWidth();
	     	int  jsm_new_height1=jsm_new1.getHeight();
		int  jsm_new_value1=jsm_new_width1/11;
	    score1 = Bitmap.createBitmap(jsm_new1,0,0,jsm_new_value1,jsm_new_height1); 
		score2 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*1,0,jsm_new_value1,jsm_new_height1); 
		score3 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*2,0,jsm_new_value1,jsm_new_height1); 
		score4 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*3,0,jsm_new_value1,jsm_new_height1); 
		score5 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*4,0,jsm_new_value1,jsm_new_height1); 
		score6 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*5,0,jsm_new_value1,jsm_new_height1); 
		score7 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*6,0,jsm_new_value1,jsm_new_height1); 
		score8 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*7,0,jsm_new_value1,jsm_new_height1); 
		score9 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*8,0,jsm_new_value1,jsm_new_height1); 
	    score10 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*9,0,jsm_new_value1,jsm_new_height1); 
		score11 = Bitmap.createBitmap(jsm_new1,jsm_new_value1*10,0,jsm_new_value1,jsm_new_height1); 
	   //TODO 获取金币	
		jsum = new GamingJsNum(score1,score2,score3,score4,score5,
				score6,score7,score8,score9,score10,
				score11);	
	   //设置界面的返回按钮
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//图片的高度
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//图片的宽度
	      shezhi_fanhui_weizhi_H = scH/16;
	  
	     //道具
	     // 获得图片的宽高
	     int shop_daoju_width = shop_daoju.getWidth();
	     int shop_daoju_height = shop_daoju.getHeight();
	     // 得到新的图片
	     Bitmap shop_daoju_new  = Bitmap.createBitmap(shop_daoju,0,0, shop_daoju_width, shop_daoju_height, matrix, true);
	     int shop_daoju_new_width = shop_daoju_new.getWidth();
	     int shop_daoju_new_height = shop_daoju_new.getHeight();
	     value =shop_daoju_new_height/3;
	     // surce：用来剪裁的图片源;
		    //   x：剪裁x方向的起始位置;
		    //   y：剪裁y方向的起始位置;
		     //  width：剪裁的宽度;
		    //   height：剪裁的高度
	     Bitmap feiji = Bitmap.createBitmap(shop_daoju_new,0,0,shop_daoju_new_width,value); 
	     Bitmap daoju = Bitmap.createBitmap(shop_daoju_new,0,value *1,shop_daoju_new_width,value ); 
	     Bitmap xunbao = Bitmap.createBitmap(shop_daoju_new,0,value*2,shop_daoju_new_width,value); 
	     daoju_width = daoju.getWidth();
	     daoju_height = daoju.getHeight();
	     daoju_weizhi_W=(scW-daoju_width*3)/2;
	     daoju_weizhi_H=shezhi_fanhui_weizhi_H +(shezhi_fanhui_new_butH/2)*3;
	     canvas.drawBitmap(daoju, daoju_weizhi_W, daoju_weizhi_H, paint);
	     canvas.drawBitmap(feiji, daoju_weizhi_W+daoju_width, daoju_weizhi_H, paint);
	     canvas.drawBitmap(xunbao, daoju_weizhi_W+daoju_width*2, daoju_weizhi_H, paint);
	  // 获得图片的宽高
	     int shop_shangpin_width = shop_shangpin.getWidth();
	     int shop_shangpin_height = shop_shangpin.getHeight();
	     // 得到新的图片
	     Bitmap shop_shangpin_new  = Bitmap.createBitmap(shop_shangpin,0,0,shop_shangpin_width, 
	    		 shop_shangpin_height, matrix, true);
	     int shop_shangpin_new_width = shop_shangpin_new.getWidth();
	     int shop_shangpin_new_height = shop_shangpin_new.getHeight();
	     value1 =shop_shangpin_new_height/4;
	     // surce：用来剪裁的图片源;
		    //   x：剪裁x方向的起始位置;
		    //   y：剪裁y方向的起始位置;
		     //  width：剪裁的宽度;
		    //   height：剪裁的高度
	     Bitmap chaonengyaoji = Bitmap.createBitmap(shop_shangpin_new,0,value1*2,shop_shangpin_new_width,value1); 
	     Bitmap baozhahexin = Bitmap.createBitmap(shop_shangpin_new,0,value1 *1,shop_shangpin_new_width,value1);  
	     daoju_H=chaonengyaoji.getHeight();
	     daoju_W=chaonengyaoji.getWidth();
	     canvas.drawBitmap(chaonengyaoji, daoju_weizhi_W, daoju_weizhi_H+daoju_height, paint);
	     canvas.drawBitmap(baozhahexin, daoju_weizhi_W, daoju_weizhi_H+daoju_height+daoju_H, paint);
	     if (isPress_shezhi_fanhui) {
	 		//根据是否按下绘制不同状态的按钮图
	 			canvas.drawBitmap(shezhi_fanhui_press_new ,daoju_weizhi_W,shezhi_fanhui_weizhi_H, paint);
	 		} else {
	 			canvas.drawBitmap(shezhi_fanhui_new ,daoju_weizhi_W,shezhi_fanhui_weizhi_H, paint);
	 		} 
	     canvas.drawBitmap(GamingPlaneTest.coinb,scW-GamingPlaneTest.coinb.getWidth()-jsm_new_value1*1,shezhi_fanhui_weizhi_H, paint);
	     jsum.draw(canvas, paint,scW-jsm_new_value1*9, shezhi_fanhui_weizhi_H,DataBase_Player.goldcoin,jsm_new_value1);		
	     jsum.draw(canvas, paint,daoju_weizhi_W,daoju_weizhi_H+daoju_height+daoju_H+value1-jsm_new_height1,DataBase_Player.effect2,jsm_new_value1);  
	     jsum.draw(canvas, paint,daoju_weizhi_W, daoju_weizhi_H+daoju_height+value1-jsm_new_height1,DataBase_Player.effect1,jsm_new_value1);  
	}
	
	//菜单绘图函数
		public void draw2(Canvas canvas, Paint paint) {
		     // 取得想要缩放的matrix参数
		     Matrix matrix = new Matrix();
		     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);
		     // 得到新的图片
		     int jsm_width1=GamingPlaneTest.jsm.getWidth();
			 int jsm_height1=GamingPlaneTest.jsm.getHeight();
			 Bitmap jsm_new1  = Bitmap.createBitmap(GamingPlaneTest.jsm,0,0,jsm_width1,jsm_height1, matrix, true);
		     int jsm_new_width1=jsm_new1.getWidth();
			 int  jsm_new_value1=jsm_new_width1/11;			
		   //设置界面的返回按钮
			 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
		     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
		     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//图片的高度
		     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//图片的高度
		     shezhi_fanhui_weizhi_H = scH/16;
		     //道具
		     // 获得图片的宽高
		     int shop_daoju_width = shop_daoju.getWidth();
		     int shop_daoju_height = shop_daoju.getHeight();
		     // 得到新的图片
		     Bitmap shop_daoju_new  = Bitmap.createBitmap(shop_daoju,0,0, shop_daoju_width, shop_daoju_height, matrix, true);
		     int shop_daoju_new_width = shop_daoju_new.getWidth();
		     int shop_daoju_new_height = shop_daoju_new.getHeight();
		     value =shop_daoju_new_height/3;
		     // surce：用来剪裁的图片源;
			    //   x：剪裁x方向的起始位置;
			    //   y：剪裁y方向的起始位置;
			     //  width：剪裁的宽度;
			    //   height：剪裁的高度
		     Bitmap feiji = Bitmap.createBitmap(shop_daoju_new,0,0,shop_daoju_new_width,value); 
		     Bitmap daoju = Bitmap.createBitmap(shop_daoju_new,0,value *1,shop_daoju_new_width,value ); 
		     Bitmap xunbao = Bitmap.createBitmap(shop_daoju_new,0,value*2,shop_daoju_new_width,value); 
		     daoju_width = daoju.getWidth();
		     daoju_height = daoju.getHeight();
		     daoju_weizhi_W=(scW-daoju_width*3)/2;
		     daoju_weizhi_H=shezhi_fanhui_weizhi_H +(shezhi_fanhui_new_butH/2)*3;
		     canvas.drawBitmap(daoju, daoju_weizhi_W, daoju_weizhi_H, paint);
		     canvas.drawBitmap(feiji, daoju_weizhi_W+daoju_width, daoju_weizhi_H, paint);
		     canvas.drawBitmap(xunbao, daoju_weizhi_W+daoju_width*2, daoju_weizhi_H, paint);
		  // 获得图片的宽高
		     int shop_shangpin_width = shop_shangpin.getWidth();
		     int shop_shangpin_height = shop_shangpin.getHeight();
		     // 得到新的图片
		     Bitmap shop_shangpin_new  = Bitmap.createBitmap(shop_shangpin,0,0,shop_shangpin_width, 
		    		 shop_shangpin_height, matrix, true);
		     int shop_shangpin_new_width = shop_shangpin_new.getWidth();
		     int shop_shangpin_new_height = shop_shangpin_new.getHeight();
		     value1 =shop_shangpin_new_height/4;
		     // surce：用来剪裁的图片源;
			  //   x：剪裁x方向的起始位置;
			  //   y：剪裁y方向的起始位置;
		    //  width：剪裁的宽度;
			   //   height：剪裁的高度
		     Bitmap anye = Bitmap.createBitmap(shop_shangpin_new,0,0,shop_shangpin_new_width,value1); 
		     Bitmap moshang = Bitmap.createBitmap(shop_shangpin_new,0,value1 *3,shop_shangpin_new_width,value1);  
		     int daoju_w=anye.getHeight();
		    canvas.drawBitmap(anye, daoju_weizhi_W, daoju_weizhi_H+daoju_height, paint);
		    canvas.drawBitmap(moshang, daoju_weizhi_W, daoju_weizhi_H+daoju_height+daoju_w, paint);
		    //商品的购买与未购买
		     // 获得图片的宽高
		     int shop_buy_width = shop_buy.getWidth();
		     int shop_buy_height = shop_buy.getHeight();
		     Bitmap shop_buy_new  = Bitmap.createBitmap(shop_buy,0,0, shop_buy_width, shop_buy_height, matrix, true);
		     Bitmap shop_nobuy_new  = Bitmap.createBitmap(shop_nobuy,0,0, shop_buy_width, shop_buy_height, matrix, true);
		     if (isPress_shezhi_fanhui) {
		 		//根据是否按下绘制不同状态的按钮图
		 			canvas.drawBitmap(shezhi_fanhui_press_new ,daoju_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		 		} else {
		 			canvas.drawBitmap(shezhi_fanhui_new ,daoju_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		 		}
		     
		     if(plane1)
		     {
		    	 //第一飞机
		    	 canvas.drawBitmap(shop_buy_new, daoju_weizhi_W, daoju_weizhi_H+daoju_height, paint);
			    
		     }else
		     {
		    	 //第一飞机
			     canvas.drawBitmap(shop_nobuy_new, daoju_weizhi_W, daoju_weizhi_H+daoju_height, paint);
		     }
		     if(plane2)
		     {
		    	 //第二飞机
			     canvas.drawBitmap(shop_buy_new, daoju_weizhi_W, daoju_weizhi_H+daoju_height+daoju_w, paint);
		     }else
		     {
		    	//第二飞机
			     canvas.drawBitmap(shop_nobuy_new, daoju_weizhi_W, daoju_weizhi_H+daoju_height+daoju_w, paint);
		     }
		     canvas.drawBitmap(GamingPlaneTest.coinb,scW-GamingPlaneTest.coinb.getWidth()-jsm_new_value1*1,shezhi_fanhui_weizhi_H, paint);
		     jsum.draw(canvas, paint,scW-jsm_new_value1*9, shezhi_fanhui_weizhi_H,DataBase_Player.goldcoin,jsm_new_value1);  
		     
		}
		public void draw3(Canvas canvas, Paint paint) {
		     // 取得想要缩放的matrix参数
		     Matrix matrix = new Matrix();
		     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);		 
		     // 得到新的图片
		     int jsm_width1=GamingPlaneTest.jsm.getWidth();
			 int jsm_height1=GamingPlaneTest.jsm.getHeight();
			 Bitmap jsm_new1  = Bitmap.createBitmap(GamingPlaneTest.jsm,0,0,jsm_width1,jsm_height1, matrix, true);
		     int jsm_new_width1=jsm_new1.getWidth();
			 int  jsm_new_value1=jsm_new_width1/11;		
		   //设置界面的返回按钮
			 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
		     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
		     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//图片的高度
		     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//图片的高度
		     shezhi_fanhui_weizhi_H = scH/16;
		     //道具
		     // 获得图片的宽高
		     int shop_daoju_width = shop_daoju.getWidth();
		     int shop_daoju_height = shop_daoju.getHeight();
		     // 得到新的图片
		     Bitmap shop_daoju_new  = Bitmap.createBitmap(shop_daoju,0,0, shop_daoju_width, shop_daoju_height, matrix, true);
		     int shop_daoju_new_width = shop_daoju_new.getWidth();
		     int shop_daoju_new_height = shop_daoju_new.getHeight();
		     value =shop_daoju_new_height/3;
		     Bitmap feiji = Bitmap.createBitmap(shop_daoju_new,0,0,shop_daoju_new_width,value); 
		     Bitmap daoju = Bitmap.createBitmap(shop_daoju_new,0,value *1,shop_daoju_new_width,value ); 
		     Bitmap xunbao = Bitmap.createBitmap(shop_daoju_new,0,value*2,shop_daoju_new_width,value); 
		     daoju_width = daoju.getWidth();
		     daoju_height = daoju.getHeight();
		     daoju_weizhi_W=(scW-daoju_width*3)/2;
		     daoju_weizhi_H=shezhi_fanhui_weizhi_H +(shezhi_fanhui_new_butH/2)*3;
		     canvas.drawBitmap(daoju, daoju_weizhi_W, daoju_weizhi_H, paint);
		     canvas.drawBitmap(feiji, daoju_weizhi_W+daoju_width, daoju_weizhi_H, paint);
		     canvas.drawBitmap(xunbao, daoju_weizhi_W+daoju_width*2, daoju_weizhi_H, paint);
		     if (isPress_shezhi_fanhui) {
		 		//根据是否按下绘制不同状态的按钮图
		 			canvas.drawBitmap(shezhi_fanhui_press_new ,daoju_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		 		} else {
		 			canvas.drawBitmap(shezhi_fanhui_new ,daoju_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		 		}  
		     canvas.drawBitmap(GamingPlaneTest.coinb,scW-GamingPlaneTest.coinb.getWidth()-jsm_new_value1*1,shezhi_fanhui_weizhi_H, paint);
		     jsum.draw(canvas, paint,scW-jsm_new_value1*9, shezhi_fanhui_weizhi_H,DataBase_Player.goldcoin,jsm_new_value1);    
		     // 获得图片的宽高
		     int shop_xunbao_width = shop_xunbao.getWidth();
		     int shop_xunbao_height = shop_xunbao.getHeight();
		     // 得到新的图片
		     Bitmap shop_xunbao_new  = Bitmap.createBitmap(shop_xunbao,0,0,shop_xunbao_width,shop_xunbao_height, matrix, true);
		     canvas.drawBitmap(shop_xunbao_new, daoju_weizhi_W, daoju_weizhi_H+daoju_height, paint);	     
		}
	//菜单触屏事件函数，主要用于处理按钮事件
	public void onTouchEvent(MotionEvent event) {
		//获取用户当前触屏位置
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		
		//当用户是按下动作或移动动作
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//判定用户是否点击了按钮
			if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+shezhi_fanhui_new_butW)
			{
				if (pointY >shezhi_fanhui_weizhi_H && pointY <shezhi_fanhui_weizhi_H+shezhi_fanhui_new_butH) 
				{
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_MENU;	
				}
			}
			if (pointX > daoju_weizhi_W+daoju_width && pointX < daoju_weizhi_W+daoju_width*2)
			{
				if (pointY >daoju_weizhi_H&& pointY <daoju_weizhi_H+value) 
				{   
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHOP_FEIJI;	
				}
			}
			if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_width)
			{
				if (pointY >daoju_weizhi_H&& pointY <daoju_weizhi_H+value) 
				{   
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHOP_DAOJU;	
				}
			}
			if (pointX > daoju_weizhi_W+daoju_width*2 && pointX < daoju_weizhi_W+daoju_width*3)
			{
				if (pointY >daoju_weizhi_H&& pointY <daoju_weizhi_H+value) 
				{   
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHOP_XUNBAO;	
				}
			}
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP) {
			//抬起判断是否点击按钮，防止用户移动到别处	
		}	
	}
	//购买道具
	public void onTouchEvent1(MotionEvent event) {
		//获取用户当前触屏位置
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//当用户是按下动作或移动动作
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//判定用户是否点击了按钮
			if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
			{
				if (pointY >daoju_weizhi_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H) 
				{       
					if(DataBase_Player.goldcoin>=30){
						shangpin1=true;
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_QUEREN;
						
					}
					if(DataBase_Player.goldcoin<30)
					{
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_NOMONEY;
					}
				}
			}
			if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
			{
				if (pointY >daoju_weizhi_H+daoju_height+daoju_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H*2) 
				{
						if(DataBase_Player.goldcoin>=50){
							shangpin2=true;
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_QUEREN;
				         }
						if(DataBase_Player.goldcoin<50)
						{
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_NOMONEY;
						}
				}
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			//抬起判断是否点击按钮，防止用户移动到别处
			if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
			{
				if (pointY >daoju_weizhi_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H) 
				{   
				}
			}
			if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
			{
				if (pointY >daoju_weizhi_H+daoju_height+daoju_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H*2) 
				{
				}
			}
		}
	}
	//购买飞机
		public void onTouchEvent2(MotionEvent event) {
			//获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//判定用户是否点击了按钮
				if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
				{
					if (pointY >daoju_weizhi_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H) 
					{  
						if(DataBase_Player.goldcoin>=999){
							shangpin3=true;
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_QUEREN;
						
						}
						if(DataBase_Player.goldcoin<999)
						{
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_NOMONEY;
						}
					}
				}
				if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
				{
					if (pointY >daoju_weizhi_H+daoju_height+daoju_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H*2) 
					{
						if(DataBase_Player.goldcoin>=1299){	
							shangpin4=true;
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_QUEREN;
						}
						if(DataBase_Player.goldcoin<1299)
						{
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_NOMONEY;
						}
					}
				}
			} 
			else if (event.getAction() == MotionEvent.ACTION_UP) {
				//抬起判断是否点击按钮，防止用户移动到别处
				if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
				{
					if (pointY >daoju_weizhi_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H) 
					{	}
				}
				if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
				{
					if (pointY >daoju_weizhi_H+daoju_height+daoju_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H*2) 
					{		}
				}
			}
		}
		//寻宝
		//
				public void onTouchEvent3(MotionEvent event) {
					//获取用户当前触屏位置
					int pointX = (int) event.getX();
					int pointY = (int) event.getY();
					//当用户是按下动作或移动动作
					if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
						//判定用户是否点击了按钮
						if (pointX > daoju_weizhi_W && pointX < daoju_weizhi_W+daoju_W)
						{
							if (pointY >daoju_weizhi_H+daoju_height && pointY <daoju_weizhi_H+daoju_height+daoju_H) 
							{  
								if(DataBase_Player.goldcoin>=100){
									shangpin5=true;
									GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_QUEREN;
									
								}
								if(DataBase_Player.goldcoin<100)
								{
									GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_NOMONEY;
								}
								
							}
						}
						
					} 
					else if (event.getAction() == MotionEvent.ACTION_UP) {}
				}
}
