package com.plane_ui;
import com.plane_activity.MainActivity;
import com.plane_database.DataBase_Player;
import com.plane_test.GamingPlaneTest;
import com.plane_test.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class Game_Querengoumai {
	Bitmap shop_queren;
    Bitmap tuichu_queding;//�˳�ȷ��
	Bitmap tuichu_quxiao;//�˳�ȡ��
	Bitmap shop_mengban;
    int shop_queren_new_butH;
    int shop_queren_new_butW;
    int shop_queren_weizhi_W;
    int shop_queren_weizhi_H;
    int tuichu_queding_new_butH;
    int tuichu_queding_new_butW;
    int tuichu_queding_weizhi_W;
    int tuichu_queding_weizhi_W1;
    int tuichu_queding_weizhi_H;
    int tuichu_quxiao_new_butH;
    int tuichu_quxiao_new_butW;
    int tuichu_quxiao_weizhi_W;
    int tuichu_quxiao_weizhi_H;
    Context context;
    DataBase_Player database_player;
    public static int goldcoin;
	public static Boolean plane1;
	public static Boolean plane2;
	public static int effect1;
	public static int effect2;
	public static String	get;
	
	public Game_Querengoumai(Bitmap shop_queren,Bitmap tuichu_queding,Bitmap tuichu_quxiao,Bitmap shop_mengban, Context context) 
	{   
		this.context=context;
		this.shop_queren=shop_queren;
		this.tuichu_queding =tuichu_queding;
		this.tuichu_quxiao =tuichu_quxiao;
		this.shop_mengban=shop_mengban;
		database_player=new DataBase_Player(context);
	}
	//�˵���ͼ����
	public void draw(Canvas canvas, Paint paint) {
	     // ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth,GamingPlaneTest. scaleHeight); 
	    // ���ͼƬ�Ŀ��
	     int shop_queren_width = shop_queren.getWidth();
	     int shop_queren_height = shop_queren.getHeight();
	     // �õ��µ�ͼƬ //tuichu �˳�͸����
	     Bitmap shop_queren_new  = Bitmap.createBitmap(shop_queren,0,0, shop_queren_width, shop_queren_height, matrix, true);
	     shop_queren_new_butH = shop_queren_new.getHeight();//ͼƬ�ĸ߶�
	     shop_queren_new_butW = shop_queren_new.getWidth();//ͼƬ�Ŀ��
	     shop_queren_weizhi_W = (GamingPlaneTest.screenW-shop_queren_new_butW)/2;
	     shop_queren_weizhi_H = GamingPlaneTest.screenH/3;
	     canvas.drawBitmap(shop_queren_new,shop_queren_weizhi_W,shop_queren_weizhi_H, paint);
		//͸��������İ�ť��
	     //ȷ����ť
	     // ���ͼƬ�Ŀ��
	     int tuichu_queding_width = tuichu_queding.getWidth();
	     int tuichu_queding_height = tuichu_queding.getHeight();
	     Bitmap tuichu_queding_new  = Bitmap.createBitmap(tuichu_queding,0,0, tuichu_queding_width, tuichu_queding_height, matrix, true);
	     tuichu_queding_new_butH = tuichu_queding_new.getHeight();//ͼƬ�ĸ߶�
	     tuichu_queding_new_butW = tuichu_queding_new.getWidth();//ͼƬ�Ŀ��
	     tuichu_queding_weizhi_W = shop_queren_weizhi_W+(shop_queren_new_butW/17)*2;
	     tuichu_queding_weizhi_H = shop_queren_weizhi_H+(shop_queren_new_butH/3)*2;
	     canvas.drawBitmap(tuichu_queding_new,tuichu_queding_weizhi_W,tuichu_queding_weizhi_H, paint);    
	   //͸��������İ�ť��
	     //ȡ����ť
	     // ���ͼƬ�Ŀ��
	     int tuichu_quxiao_width = tuichu_quxiao.getWidth();
	     int tuichu_quxiao_height = tuichu_quxiao.getHeight();
	     Bitmap tuichu_quxiao_new  = Bitmap.createBitmap(tuichu_quxiao,0,0, tuichu_quxiao_width, tuichu_quxiao_height, matrix, true);
	     tuichu_quxiao_new_butH = tuichu_quxiao_new.getHeight();//ͼƬ�ĸ߶�
	     tuichu_quxiao_new_butW = tuichu_quxiao_new.getWidth();//ͼƬ�Ŀ��
	     tuichu_quxiao_weizhi_W = shop_queren_weizhi_W+(shop_queren_new_butW/17)*15-tuichu_quxiao_new_butW;
	     tuichu_quxiao_weizhi_H = shop_queren_weizhi_H+(shop_queren_new_butH/3)*2;
		 canvas.drawBitmap(tuichu_quxiao_new,tuichu_quxiao_weizhi_W,tuichu_quxiao_weizhi_H, paint);
	}
	//////////////////�ɹ�Ѱ��/////////////////////////////
	//�˵���ͼ����
	public void draw2(Canvas canvas, Paint paint) {
	     // ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth,GamingPlaneTest. scaleHeight); 
	     // ���ͼƬ�Ŀ��
	     int shop_queren_width = shop_queren.getWidth();
	     int shop_queren_height = shop_queren.getHeight();
	     // �õ��µ�ͼƬ //tuichu �˳�͸����
	     Bitmap shop_mengban_new  = Bitmap.createBitmap(shop_mengban,0,0, shop_queren_width, shop_queren_height, matrix, true);
	     shop_queren_new_butH = shop_mengban_new.getHeight();//ͼƬ�ĸ߶�
	     shop_queren_new_butW = shop_mengban_new.getWidth();//ͼƬ�Ŀ��
	     shop_queren_weizhi_W = (GamingPlaneTest.screenW-shop_queren_new_butW)/2;
	     shop_queren_weizhi_H = GamingPlaneTest.screenH/3;
	     canvas.drawBitmap(shop_mengban_new,shop_queren_weizhi_W,shop_queren_weizhi_H, paint);
		//͸��������İ�ť��
	     //ȷ����ť
	     // ���ͼƬ�Ŀ��
	     int tuichu_queding_width = tuichu_queding.getWidth();
	     int tuichu_queding_height = tuichu_queding.getHeight();
	     Bitmap tuichu_queding_new  = Bitmap.createBitmap(tuichu_queding,0,0, tuichu_queding_width, tuichu_queding_height, matrix, true);
	     tuichu_queding_new_butH = tuichu_queding_new.getHeight();//ͼƬ�ĸ߶�
	     tuichu_queding_new_butW = tuichu_queding_new.getWidth();//ͼƬ�Ŀ��
	     tuichu_queding_weizhi_W1 = shop_queren_weizhi_W+(shop_queren_new_butW/17)*6;
	     tuichu_queding_weizhi_H = shop_queren_weizhi_H+(shop_queren_new_butH/3)*2;
	     canvas.drawBitmap(tuichu_queding_new,tuichu_queding_weizhi_W1,tuichu_queding_weizhi_H, paint);    
	     paint.setColor(context.getResources().getColor(R.color.ghostwhite));//��ɫ
		 paint.setTextSize(MainActivity.TEXT_SIZE_50);
		 canvas.drawText("��ϲ������� ",GamingPlaneTest.screenW/20*2,GamingPlaneTest.screenH/20*10,paint);	
		 paint.setColor(context.getResources().getColor(R.color.salmon)); 
		 canvas.drawText(get,GamingPlaneTest.screenW/20*11,GamingPlaneTest.screenH/20*10,paint);	
	}
	//�˵������¼���������Ҫ���ڴ���ť�¼�
	public void onTouchEvent(MotionEvent event) {
		//��ȡ�û���ǰ����λ��
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//���û��ǰ��¶������ƶ�����
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//�ж��û��Ƿ����˰�ť
			//qȷ����ť////////////////////////////
			if (pointX > tuichu_queding_weizhi_W && pointX < tuichu_queding_weizhi_W + tuichu_queding_new_butW)
			{
				if (pointY > tuichu_queding_weizhi_H && pointY < tuichu_queding_weizhi_H + tuichu_queding_new_butH ) 
				{
					
				} else 
				{
					
				}
			}
			//ȡ����ť
			if (pointX > tuichu_quxiao_weizhi_W && pointX < tuichu_quxiao_weizhi_W + tuichu_quxiao_new_butW)
			{
				if (pointY > tuichu_quxiao_weizhi_H && pointY < tuichu_quxiao_weizhi_H +tuichu_quxiao_new_butH) 
				{
					
				} else 
				{
					
				}
			}
			//���û���̧����
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
			
			if (pointX > tuichu_queding_weizhi_W && pointX < tuichu_queding_weizhi_W + tuichu_queding_new_butW)
			{
				if (pointY > tuichu_queding_weizhi_H && pointY < tuichu_queding_weizhi_H + tuichu_queding_new_butH ) 
				{   				
					 //���ݶ�ȡ
					SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
					if(Game_Shop.shangpin1)
					{
							goldcoin=DataBase_Player.goldcoin;
						    effect1=DataBase_Player.effect1;
							goldcoin=goldcoin-30;
							effect1=effect1+1;
							if(MainActivity.mac!=null){
								database_player.UpdateGoldCoin(goldcoin);
								database_player.UpdateEffect1(effect1);
								
								}
							if(MainActivity.mac==null)
								{
								  //���ݴ洢
						           SharedPreferences.Editor editor=prefs.edit();		
						           editor.putInt("goldcoin",goldcoin);
						           editor.putInt("effect1",effect1);
						           editor.commit();
						           
								 }
							DataBase_Player.goldcoin=goldcoin;
							DataBase_Player.effect1=effect1;
							Game_Shop.shangpin1=false;
							GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_DAOJU;
					}//s��Ʒ1
					/////////////
					if(Game_Shop.shangpin2)
					{	 
						  goldcoin=DataBase_Player.goldcoin;
						  effect2=DataBase_Player.effect2;
						  goldcoin=goldcoin-50;
						  effect2=effect2+1;
						 if(MainActivity.mac==null)
					        {   
					        	SharedPreferences.Editor editor=prefs.edit();
					        	editor.putInt("goldcoin",goldcoin);
					        	editor.putInt("effect2",effect2);
					        	editor.commit();					
					        }
						if(MainActivity.mac!=null)
						{   
							database_player.UpdateGoldCoin(goldcoin);
							database_player.UpdateEffect2(effect2);
							
						}
						DataBase_Player.goldcoin=goldcoin;
						DataBase_Player.effect2=effect2;
						Game_Shop.shangpin2=false;
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_DAOJU;
					}
					//��Ʒ3///////////
					if(Game_Shop.shangpin3)
					{
						goldcoin=DataBase_Player.goldcoin;
						plane1=DataBase_Player.plane1;
						goldcoin=goldcoin-999;
						plane1=true;
						if(MainActivity.mac==null)
					        {	
					        	SharedPreferences.Editor editor=prefs.edit();				 
					        	editor.putInt("goldcoin",goldcoin);
					        	editor.putBoolean("plane1",true);
					        	editor.commit();		  
					        }
						if(MainActivity.mac!=null)
						{   
							database_player.UpdateGoldCoin(goldcoin);
							database_player.UpdatePlane1(plane1);
							
						}
						DataBase_Player.goldcoin=goldcoin;
						DataBase_Player.plane1=true;
						Game_Shop.shangpin3=false;
						Game_Shop.plane1=true;
						Game_SelectPlane.plane1=true;
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_FEIJI;
						
					}
					//��Ʒ4///////////
					if(Game_Shop.shangpin4)
					{    
						goldcoin=DataBase_Player.goldcoin;
						plane2=DataBase_Player.plane2;
						goldcoin=goldcoin-1299;
						plane2=true;
						 if(MainActivity.mac==null)
					        {
								SharedPreferences.Editor editor=prefs.edit();
					        	editor.putInt("goldcoin",goldcoin);
					        	editor.putBoolean("plane2",true);
					            editor.commit();		
					        }
						if(MainActivity.mac!=null)
						{   
							database_player.UpdateGoldCoin(goldcoin);
							database_player.UpdatePlane2(plane2);							
						}
						DataBase_Player.goldcoin=goldcoin;
						DataBase_Player.plane2=true;
						Game_Shop.shangpin4=false;
						Game_Shop.plane2=true;
						Game_SelectPlane.plane2=true;
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_FEIJI;
					}
					//��Ʒ5///////////
					if(Game_Shop.shangpin5)
					{   
						goldcoin=DataBase_Player.goldcoin;
						plane2=DataBase_Player.plane2;
						goldcoin=goldcoin-100;						
						 if(MainActivity.mac==null)
					        {
								SharedPreferences.Editor editor=prefs.edit();	        	
					       int  k =(int)(Math.random()*99)+1;
					        	System.out.println(k);
					        int	 b=(int)(Math.random()*9)+1;
					        	System.out.println(b);
					        	{
					        		if(k<33)
					        		{
					        			//effect2+  b ����Ʒ
					        			effect2=DataBase_Player.effect2;				        									          
					        			 effect2=effect2+b;
					        			DataBase_Player.effect2= effect2;
					        			 editor.putInt("effect2",effect2);		
					        			get ="��ը����*"+b;
					        		}
					        		if(k>=33&&k<=95)
					        		{
					        			effect1=DataBase_Player.effect1;					        										          
					        			 effect1=effect1+b;
					        			 DataBase_Player.effect1= effect1;
					        			 editor.putInt("effect1",effect1);
					        			 get ="����ҩ��*"+b;
					        			
					        		}
					        		if(k>95&&k<98)
					        		{	
					        			DataBase_Player.plane1= true;
							        	editor.putBoolean("plane1",true);	
							        	Game_Shop.plane1=true;
							        	Game_SelectPlane.plane1=true;
							        	get="��ҹӣѩ";
					        		}
					        		if(k>=98)
					        		{
					        			DataBase_Player.plane2= true;
				        		      	editor.putBoolean("plane2",true);
				        		    	Game_Shop.plane2=true;
				        		    	Game_SelectPlane.plane2=true;
				        		    	get="İ������";
							      				        	 		  					        		
					        		}
					        	}
					        	 editor.putInt("goldcoin",goldcoin);
					              editor.commit();		
					        }
						if(MainActivity.mac!=null)
						{   
							int k =(int)(Math.random()*99)+1;
				        	int b=(int)(Math.random()*9)+1;
							if(k<33)
			        		{
			        			//effect2+  b ����Ʒ
								effect2=DataBase_Player.effect2;
								effect2=effect2+b;
								database_player.UpdateGoldCoin(goldcoin);
								database_player.UpdateEffect2(effect2);		
								DataBase_Player.effect2= effect2;
								get ="��ը����*"+b;
			        		}
			        		if(k>=33&&k<=95)
			        		{
			        		
			        			effect1=DataBase_Player.effect1;
								effect1=effect1+b;
								database_player.UpdateGoldCoin(goldcoin);
								database_player.UpdateEffect2(effect1);
								DataBase_Player.effect1= effect1;
								 get ="����ҩ��*"+b;
			        			
			        		}
			        		if(k>95&&k<98)
			        		{
			        			plane1=true;
			        			DataBase_Player.plane1= true;					        	
					        	Game_Shop.plane1=true;
					        	Game_SelectPlane.plane1=true;
			        			database_player.UpdatePlane1(plane1);	
			        			get="��ҹӣѩ";
			        		}
			        		if(k>=98)
			        		{
			        			plane2=true;
			        			DataBase_Player.plane2= true;					        	
					        	Game_Shop.plane2=true;
					        	Game_SelectPlane.plane2=true;
			        			database_player.UpdatePlane1(plane2);	
			        			get="İ������";
			        		}
			        		database_player.UpdateGoldCoin(goldcoin);
			        	
						}
						DataBase_Player.goldcoin=goldcoin;
						Game_Shop.shangpin5=false;
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_XUNBAOS;
													
						}
						
					}
				} 
		  
			if (pointX > tuichu_quxiao_weizhi_W&& pointX < tuichu_quxiao_weizhi_W + tuichu_quxiao_new_butW)
			{
				if (pointY > tuichu_quxiao_weizhi_H&& pointY < tuichu_quxiao_weizhi_H +tuichu_quxiao_new_butH ) 
				{   
					GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_DAOJU;
					
				}
			}
		}
	}
	//�˵������¼���������Ҫ���ڴ���ť�¼�
		public void onTouchEvent2(MotionEvent event) {
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//�ж��û��Ƿ����˰�ť
				//qȷ����ť////////////////////////////
				if (pointX > tuichu_queding_weizhi_W1 && pointX < tuichu_queding_weizhi_W1 + tuichu_queding_new_butW)
				{
					if (pointY > tuichu_queding_weizhi_H && pointY < tuichu_queding_weizhi_H + tuichu_queding_new_butH ) 
					{
						GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_XUNBAO;
					} 
				}
	
			} 
			else if (event.getAction() == MotionEvent.ACTION_UP)
			{
				
			}
		}
}
