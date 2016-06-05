package com.plane_ui;
import com.plane_activity.MainActivity;
import com.plane_test.GamingPlaneTest;
import com.plane_test.GamingPlayer;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class GameMenu {
	//菜单背景图
	//private Bitmap bmpMenu;
	//按钮图片资源
	//按钮的坐标
	private int scH,scW;
	private Bitmap button_jingdian;////经典模式
	private Bitmap button_shangdian;
	//按钮是否按下标识位
	private Boolean isPress_jingdian;//j经典
	private Boolean isPress_wujin;//无尽
	private Boolean isPress_juqing;//剧情
	float button_jingdian_butH;
    float button_jingdian_butW;
    float button_jingdian_weizhi_W;//经典按钮的摆放位置W
    float button_jingdian_weizhi_H;//经典按钮的摆放位置H
    float button_jingdian_weizhi_zhongzhuan;
    
    private Bitmap button_wujin;//无尽模式
    float button_wujin_butH;
    float button_wujin_butW;
    float button_wujin_weizhi_H;//经典按钮的摆放位置H
    float button_wujin_weizhi_zhongzhuan;
	private Bitmap button_juqing;//剧情模式
	float button_juqing_butH;
	float button_juqing_weizhi_H;//剧情按钮的摆放位置H
	float button_juqing_weizhi_zhongzhuan;
	private Bitmap button_shezhi;//设置按钮
	float button_shezhi_butH;
	float button_shezhi_butW;
	float button_shezhi_weizhi_H;//经典按钮的摆放位置H
	float button_shezhi_weizhi_zhongzhuan;
	private Bitmap button_zhanjiqiehuan;//战机切换
	float button_zhanjiqiehuan_butH;
	float button_zhanjiqiehuan_weizhi_W;//经典按钮的摆放位置W
	float button_zhanjiqiehuan_weizhi_zhongzhuan;
	private Bitmap button_jingdian_press;////经典模式按下去
	private Bitmap button_juqing_press;//剧情模式按下去
	private Bitmap button_wujin_press;//无尽按钮按下去
	public static  float scaleWidth;
    public static  float scaleHeight;
    //商店
   int button_shangdian_W;
   int button_shangdian_H;
  //飞机状态
  	private boolean is_plane1;//飞机1
  	private boolean is_plane2;//飞机2
  	private boolean is_plane3;//飞机3
  	private boolean is_plane4;//飞机4
  	private boolean is_plane5;//飞机5
	//菜单初始化
	GamingPlaneTest mys;
	MediaPlayer mediaplayer;
	Bitmap newbm;	
	Bitmap ams_xingxing;
	public static int game;
	public static float x;
	public static float y;
	public static float z;
	int button_zhanjiqiehuan_W;
	int button_zhanjiqiehuan_H;
	Context context;
	public GameMenu(Bitmap ams_xingxing,Bitmap button_jingdian,
			Bitmap button_juqing,Bitmap button_shezhi,Bitmap button_wujin,
			Bitmap button_zhanjiqiehuan,Bitmap button_jingdian_press,
			Bitmap button_juqing_press,Bitmap button_wujin_press,Bitmap button_shangdian,Context context) 
	{   
		this.button_shangdian=button_shangdian;
		this.context=context;
		this.ams_xingxing =ams_xingxing;
		this.button_jingdian= button_jingdian;
		this.button_juqing =button_juqing;
		this.button_shezhi =button_shezhi;
		this.button_wujin=button_wujin;
		this.button_zhanjiqiehuan=button_zhanjiqiehuan;
		this.button_jingdian_press= button_jingdian_press;
		this.button_juqing_press =button_juqing_press;
		this.button_wujin_press =button_wujin_press;
		//X居中，Y紧接屏幕底部
		scH =  GamingPlaneTest.screenH ;//屏幕的高度
		scW =  GamingPlaneTest.screenW; //屏幕的宽度
		
		//bmpH = bmpMenu.getHeight();//图片的高度
		//bmpW = bmpMenu.getWidth();//图片的宽度
		isPress_jingdian = false;
		isPress_wujin = false;
		isPress_juqing = false;
		scaleWidth=0;
		scaleHeight=0;
	}
	//菜单绘图函数
	public void draw(Canvas canvas, Paint paint) {
	     // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(scaleWidth, scaleHeight);
	    
	   
	  //经典按钮   ///////////////////////////////////////   
	  // 获得图片的宽高
	     int button_jingdian_width = button_jingdian.getWidth();//获取经典按钮的宽度
	     int button_jingdian_height = button_jingdian.getHeight();//获取经典按钮的高度
	     // 得到新的图片
	     Bitmap button_jingdian_new  = Bitmap.createBitmap(button_jingdian,0,0, button_jingdian_width, button_jingdian_height, matrix, true);
	     button_jingdian_butH = button_jingdian_new.getHeight();//图片的高度
	     button_jingdian_butW= button_jingdian_new.getWidth();//图片的宽度
	     button_jingdian_weizhi_W=(scW-button_jingdian_butW)/2;//计算经典按钮的摆放位置W
	     button_jingdian_weizhi_zhongzhuan=4*button_jingdian_butH;
	     button_jingdian_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*3/7;//计算经典按钮的摆放位置H  //绘制菜单背景图
	   
	     Bitmap button_jingdian_press_new  = Bitmap.createBitmap(button_jingdian_press,0,0, button_jingdian_width, button_jingdian_height, matrix, true);
	  //无尽按钮//////////////////////////////////////////  
	      int button_wujin_width = button_wujin.getWidth();//获取经典按钮的宽度
		  int button_wujin_height = button_wujin.getHeight();//获取经典按钮的高度
		  Bitmap button_wujin_new  = Bitmap.createBitmap(button_wujin,0,0, button_wujin_width, button_wujin_height, matrix, true);//缩放
		  button_wujin_butH = button_wujin_new.getHeight();//图片的高度
		  button_wujin_butW = button_wujin_new.getWidth();//图片的高度
		  button_wujin_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*4/7+button_wujin_butH;
		  Bitmap button_wujin_press_new  = Bitmap.createBitmap(button_wujin_press,0,0, button_wujin_width, button_wujin_height, matrix, true);//缩放
	 //剧情按钮//////////////////////////////////////////
		  int button_juqing_width = button_juqing.getWidth();//获取经典按钮的宽度
		  int button_juqing_height = button_juqing.getHeight();//获取经典按钮的高度
		  Bitmap button_juqing_new  = Bitmap.createBitmap(button_juqing,0,0, button_juqing_width, button_juqing_height, matrix, true);//缩放
		  button_juqing_butH = button_wujin_new.getHeight();//图片的高度
		  button_juqing_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*5/7+2*button_juqing_butH;
		  Bitmap button_juqing_press_new  = Bitmap.createBitmap(button_juqing_press,0,0, button_juqing_width, button_juqing_height, matrix, true);//缩放
	 //设置按钮	  ////////////////////////////////////////
		  int button_shezhi_width = button_shezhi.getWidth();//获取经典按钮的宽度
		  int button_shezhi_height = button_shezhi.getHeight();//获取经典按钮的高度
		  Bitmap button_shezhi_new  = Bitmap.createBitmap(button_shezhi,0,0, button_shezhi_width, button_shezhi_height, matrix, true);//缩放
		  button_shezhi_butH = button_shezhi_new.getHeight();//图片的高度
		  button_shezhi_butW = button_shezhi_new.getWidth();
		  button_shezhi_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*6/7+3*button_jingdian_butH;
		  canvas.drawBitmap(button_shezhi_new,button_jingdian_weizhi_W,button_shezhi_weizhi_H,paint);
	 //战机切换//////////////////////////////////////////////////////////////////////  
		  int button_zhanjiqiehuan_width = button_zhanjiqiehuan.getWidth();//获取zhanji按钮的宽度
		  int button_zhanjiqiehuan_height = button_zhanjiqiehuan.getHeight();//获取zhanji按钮的高度
		  Bitmap button_zhanjiqiehuan_new  = Bitmap.createBitmap(button_zhanjiqiehuan,0,0, button_zhanjiqiehuan_width, button_zhanjiqiehuan_height, matrix, true);//缩放
		  button_zhanjiqiehuan_W=button_zhanjiqiehuan_new.getWidth();
		  button_zhanjiqiehuan_H=button_zhanjiqiehuan_new.getHeight();
		  button_zhanjiqiehuan_weizhi_W=button_jingdian_weizhi_W+button_jingdian_butW-button_zhanjiqiehuan_W;
		  canvas.drawBitmap(button_zhanjiqiehuan_new,button_zhanjiqiehuan_weizhi_W,button_shezhi_weizhi_H,paint); 
	 //商店//////////////////////////////////////////////////////////////////////////	  
		  int button_shangdian_width = button_shangdian.getWidth();//获取zhanji按钮的宽度
		  int button_shangdian_height = button_shangdian.getHeight();//获取zhanji按钮的高度
		  Bitmap button_shangdian_new  = Bitmap.createBitmap(button_shangdian,0,0, button_shangdian_width, button_shangdian_height, matrix, true);//缩放
		  button_shangdian_W=button_shangdian_new.getWidth();
		  button_shangdian_H=button_shangdian_new.getHeight();
		// int button_zhanjiqiehuan_weizhi_W=button_shangdian_weizhi_W+button_jingdian_butW-button_zhanjiqiehuan_W;
		  canvas.drawBitmap(button_shangdian_new,button_jingdian_weizhi_W+button_jingdian_butW-button_shangdian_W,
				  button_jingdian_weizhi_H/3,paint); 
     //星星
		  canvas.drawBitmap(ams_xingxing, 0, 0, paint);		  
		//经典//////////
		if (isPress_jingdian) 
		{//根据是否按下绘制不同状态的按钮图
			 canvas.drawBitmap(button_jingdian_press_new,button_jingdian_weizhi_W,button_jingdian_weizhi_H,paint);
			
		} else
		{
			 canvas.drawBitmap(button_jingdian_new,button_jingdian_weizhi_W,button_jingdian_weizhi_H,paint);
		}
		
		//剧情检测//////////
		 if (isPress_juqing) 
		{//根据是否按下绘制不同状态的按钮图
			canvas.drawBitmap(button_juqing_press_new,button_jingdian_weizhi_W,button_juqing_weizhi_H,paint);
					
		} else
		{
			canvas.drawBitmap(button_juqing_new,button_jingdian_weizhi_W,button_juqing_weizhi_H,paint);
		}
		//无尽检测//////////
		 if (isPress_wujin) 
		{//根据是否按下绘制不同状态的按钮图
			 //无尽按钮
			  canvas.drawBitmap(button_wujin_press_new,button_jingdian_weizhi_W,button_wujin_weizhi_H,paint);
		} else
		{
			 //无尽按钮
			  canvas.drawBitmap(button_wujin_new,button_jingdian_weizhi_W,button_wujin_weizhi_H,paint);
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
			//经典模式/////////////////////////////////////
			if (pointX > button_jingdian_weizhi_W && pointX < button_jingdian_weizhi_W + button_jingdian_butW)
			{
				if (pointY > button_jingdian_weizhi_H && pointY < button_jingdian_weizhi_H + button_jingdian_butH) 
				{
					isPress_jingdian = true;
					if(GamingPlaneTest.isSound)
					{
						GamingPlaneTest.mediaplayer2.start();
					}
				} else 
				{
					isPress_jingdian = false;
				}
			}
			//无尽模式/////////////////////////////////////
			if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW)
			{
				if (pointY > button_wujin_weizhi_H && pointY < button_wujin_weizhi_H + button_wujin_butH) 
				{
					isPress_wujin = true;
					if(GamingPlaneTest.isSound)
					{
						GamingPlaneTest.mediaplayer2.start();
					}
				} else 
				{
					isPress_wujin = false;
				}
			}
			/////////////剧情/////////
			if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW)
			{
				if (pointY > button_juqing_weizhi_H && pointY < button_juqing_weizhi_H + button_juqing_butH) 
				{
					isPress_juqing = true;
					if(GamingPlaneTest.isSound)
					{
						GamingPlaneTest.mediaplayer2.start();
					}
				}
				else 
				{
					isPress_juqing = false;
				}
			}
			 //战机切换
			 if(pointX > button_zhanjiqiehuan_weizhi_W && pointX <button_zhanjiqiehuan_weizhi_W +button_zhanjiqiehuan_W)
				{
					if(pointY >button_shezhi_weizhi_H&& pointY < button_shezhi_weizhi_H+button_zhanjiqiehuan_H)
					{
					
					}else
					{
						
					}
				}
			else 
			{
				isPress_jingdian = false;
				isPress_juqing = false;
				isPress_wujin = false;
			}
			//当用户是抬起动作
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			//抬起判断是否点击按钮，防止用户移动到别处
			//经典模式。。。。。//////////////////////////////
			if (pointX > button_jingdian_weizhi_W && pointX < button_jingdian_weizhi_W + button_jingdian_butW) 
			{
				if (pointY > button_jingdian_weizhi_H && pointY < button_jingdian_weizhi_H + button_jingdian_butH) 
				{			
					//还原Button状态为未按下状态
					isPress_jingdian = false;
					//改变当前游戏状态为开始游戏
					//  获取姿势
					MainActivity.zlkg=true;
					x=MainActivity.xValue;
					y=MainActivity.yValue;
					z=MainActivity.zValue;
					 //数据读取
					SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
					is_plane1 =prefs.getBoolean("is_plane1",true);
					is_plane2 =prefs.getBoolean("is_plane2",false);
					is_plane3 =prefs.getBoolean("is_plane3",false);
					is_plane4 =prefs.getBoolean("is_plane4",false);
					is_plane5 =prefs.getBoolean("is_plane5",false);
					if(is_plane1){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player, GamingPlaneTest.PlayerHp, 1);
					}
					if(is_plane2){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player3, GamingPlaneTest.PlayerHp, 4);
					}
					if(is_plane3){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player1, GamingPlaneTest.PlayerHp, 2);
					}
					if(is_plane4){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player2, GamingPlaneTest.PlayerHp, 3);
					}
					if(is_plane5){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player5, GamingPlaneTest.PlayerHp, 5);
					}
					//获取战机type;										
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;		
  					 game=1;
				}
			}
			////////////无尽模式///////////////////////////////////////////////
			 if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW) 
			{
				if (pointY > button_wujin_weizhi_H && pointY < button_wujin_weizhi_H + button_wujin_butH) 
				{
					//还原Button状态为未按下状态
					isPress_wujin = false;		
					MainActivity.zlkg=true;
					x=MainActivity.xValue;
					y=MainActivity.yValue;
					z=MainActivity.zValue;
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;				
				// 获取战机type,获取飞机机型图片bmpPlayer1
					SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
					is_plane1 =prefs.getBoolean("is_plane1",true);
					is_plane2 =prefs.getBoolean("is_plane2",false);
					is_plane3 =prefs.getBoolean("is_plane3",false);
					is_plane4 =prefs.getBoolean("is_plane4",false);
					is_plane5 =prefs.getBoolean("is_plane5",false);
					if(is_plane1){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player, GamingPlaneTest.PlayerHp, 1);
					}
					if(is_plane2){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player3, GamingPlaneTest.PlayerHp, 4);
					}
					if(is_plane3){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player1, GamingPlaneTest.PlayerHp, 2);
					}
					if(is_plane4){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player2, GamingPlaneTest.PlayerHp, 3);
					}
					if(is_plane5){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player5, GamingPlaneTest.PlayerHp, 5);
					}
                    game=2;					
				}
			}
	/////////////剧情/////////
				if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW)
				{
					if (pointY > button_juqing_weizhi_H && pointY < button_juqing_weizhi_H + button_juqing_butH) 
					{
						isPress_juqing = false;		
						//还原Button状态为未按下状态		
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_JUQING;							
					} 
				}
			//////////////////////////设置按钮/////////////////////////////////////
			 if(pointX > button_jingdian_weizhi_W && pointX < button_jingdian_weizhi_W + button_shezhi_butW)
			{
				if(pointY > button_shezhi_weizhi_H && pointY < button_shezhi_weizhi_H + button_shezhi_butH)
				{				
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI;	
				}
			}	
			//战机切换
			 if(pointX > button_zhanjiqiehuan_weizhi_W && pointX <button_zhanjiqiehuan_weizhi_W +button_zhanjiqiehuan_W)
				{
					if(pointY >button_shezhi_weizhi_H&& pointY < button_shezhi_weizhi_H+button_zhanjiqiehuan_H)
					{   				
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;																		
					}
				}
			 //商店
			 if(pointX >button_jingdian_weizhi_W+button_jingdian_butW-button_shangdian_W && pointX <button_jingdian_weizhi_W+button_jingdian_butW)
				{
					if(pointY >button_jingdian_weizhi_H/3&& pointY < button_jingdian_weizhi_H/3+button_shangdian_H)
					{   				
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHOP_DAOJU;																		
					}
				}
		}
	}
}
