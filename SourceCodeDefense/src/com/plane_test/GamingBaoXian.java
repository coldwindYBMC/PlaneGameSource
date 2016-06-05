package com.plane_test;

import com.plane_activity.MainActivity;
import com.plane_database.DataBase_Player;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.MotionEvent;

public class GamingBaoXian {
	public static int c;
	Bitmap bp1,bp2;
	private   int baoxianx1=0;
	private int baoxianx2=GamingPlaneTest.screenW;
	public boolean bxkg;
	private int count;
	private Context context;
	int pframeW;
	int frameIndex;
 	public GamingBaoXian(Bitmap bp1,Bitmap bp2,Context context){
		this.bp1=bp1;
		this.bp2=bp2;		
		this.context=context;
		pframeW=bp2.getWidth()/3;
	}

	public void draw(Canvas canvas, Paint paint){
	
		
		if(GamingPlayer.type==5){
			canvas.save();
			canvas.clipRect(GamingPlaneTest.screenW/2-pframeW/2,GamingPlaneTest.screenH/2-bp2.getHeight()/2, 
					GamingPlaneTest.screenW/2+pframeW/2,GamingPlaneTest.screenH/2+bp2.getHeight()/2);
			canvas.drawBitmap(bp2,GamingPlaneTest.screenW/2-pframeW/2 - frameIndex * pframeW, GamingPlaneTest.screenH/2-bp2.getHeight()/2, paint);
			canvas.restore();	
		}
		else{
		canvas.drawBitmap(bp1, baoxianx1 ,0, paint);
		canvas.drawBitmap(bp1, baoxianx2,0, paint);
		}
}
	public void draw1(Canvas canvas, Paint paint){
		canvas.drawBitmap(GamingPlaneTest.cn,0,
				GamingPlaneTest.screenH-GamingPlaneTest.PlayerHp.getHeight()-GamingPlaneTest.bxb.getHeight()-GamingPlaneTest.cn.getHeight(),paint);
		canvas.drawBitmap(GamingPlaneTest.bxb, 0 ,GamingPlaneTest.screenH-GamingPlaneTest.PlayerHp.getHeight()-GamingPlaneTest.bxb.getHeight(), paint);		
}
	public void logic(){			
		baoxianx1+=20;
		baoxianx2-=20;	
		 
		if(GamingPlayer.type==5)
		{	   count++;
		    if(count>=30){
			  bxkg=false;
				 count=0;
		    }
		}
		
		if(baoxianx1>GamingPlaneTest.screenW&&baoxianx2+bp1.getWidth()<0)
		{			
			baoxianx1=0;
			baoxianx2=GamingPlaneTest.screenW;
			 count++;
			if(GamingPlayer.type!=5&&count==3){
			   bxkg=false;
			 count=0;
			}
		}
	}	
	//菜单触屏事件函数，主要用于处理按钮事件
		public void onTouchEvent(MotionEvent event) {
			//获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();		
			//当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN ) {
				//判定用户是否点击了按钮
				//q确定按钮////////////////////////////
				if (pointX > 0 && pointX < GamingPlaneTest.PlayerHp.getWidth())
				{
					if (pointY < GamingPlaneTest.screenH&& pointY> GamingPlaneTest.screenH-GamingPlaneTest.PlayerHp.getHeight()-GamingPlaneTest.bxb.getHeight()   ) 
					{  
						if(GamingBoss.chuchang==false){
						if(MainActivity.mac!=null)
					    {
						int effect2=DataBase_Player.effect2;
						if(effect2>0)
						{
							effect2 = effect2-1;
							new DataBase_Player(context).UpdateEffect1(effect2);
							DataBase_Player.effect2=effect2;
							bxkg=true;
			         	}
					}
					if(MainActivity.mac==null){
						 //数据读取
						SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;				       
						int effect2=DataBase_Player.effect2;
				        if(effect2>0){
				    	   effect2 = effect2-1;
				    	   SharedPreferences.Editor editor=prefs.edit();
			        	   editor.putInt("effect2",effect2);
			        	   editor.commit();
						   DataBase_Player.effect2=effect2;
				    	   bxkg=true;			      
				       }
					}
						}	
				} 
			}
		} 	
	}
		public void onTouchEvent1(MotionEvent event) {
			//获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();		
			//当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN ) {
				//判定用户是否点击了按钮
				//q确定按钮////////////////////////////
				if (pointX > 0 && pointX < GamingPlaneTest.PlayerHp.getWidth())
				{
					if (pointY < GamingPlaneTest.screenH-GamingPlaneTest.PlayerHp.getHeight()-GamingPlaneTest.bxb.getHeight() && pointY> GamingPlaneTest.screenH-GamingPlaneTest.PlayerHp.getHeight()-GamingPlaneTest.bxb.getHeight()-GamingPlaneTest.cn.getHeight()   ) 
					{  
					 //数据读取
					
						SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;	
						if(MainActivity.mac!=null){						
			         	
			         	int effect1=DataBase_Player.effect1;
			         	if(effect1>0){
			         		 c= GamingPlaneTest.bulletlv;
			         		 if(c<9){
							   GamingPlaneTest.bulletlv=100;	
							     effect1=effect1-1;
							    new DataBase_Player(context).UpdateEffect1(effect1);
							    DataBase_Player.effect1=effect1;
			         		 }
			         		 else{
			         			 c=1;
			         		 }
			         	}
					}																		
					
					if(MainActivity.mac==null){
						 //数据读取				
						  int effect1=DataBase_Player.effect1;
				       if(effect1>0){
				    	   effect1 = effect1-1;				       
				    	   c= GamingPlaneTest.bulletlv;
			         		 if(c<9){
							   GamingPlaneTest.bulletlv=100;	
							   effect1-=1;
							   SharedPreferences.Editor editor=prefs.edit();
				        	   editor.putInt("effect1",effect1);
				        	   editor.commit();
				        	   DataBase_Player.effect1=effect1;
			         		 }
			         		 else{
			         			 c=1;
			         		 }
				       }
				      
				      // effect2-=1;
				 	   //数据存储
		        		SharedPreferences.Editor editor=prefs.edit();
		        		editor.putInt("effect1",0);		        		
		        		editor.commit();		        	
						}
						
					} else 
					{
						
					}
				}
	
			} 
			
		}
	
}