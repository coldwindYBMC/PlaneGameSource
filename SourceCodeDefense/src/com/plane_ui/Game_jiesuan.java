package com.plane_ui;
import com.plane_activity.MainActivity;
import com.plane_database.DataBase_Player;
import com.plane_database.DataBase_Score;
import com.plane_test.GamingPlaneTest;
import com.plane_test.GamingPlayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class Game_jiesuan {
	//public static int scW;
	//public static int scH;
	//public static float scaleWidth;
	//public static float scaleHeight;
	public Bitmap jiesuan_again;
	public Bitmap jiesuan_again_press;
	public Bitmap jiesuan_back;
	public Bitmap jiesuan_back_press;
	public Bitmap jiesuan_mengban;
	//�ɰ�
	public static int jiesuan_mengban_new_butH;
	public static int jiesuan_mengban_new_butW;
	public static int jiesuan_mengban_weizhi_W;
	public static  int jiesuan_mengban_weizhi_H;
	//����һ��
	int jiesuan_again_new_butH;
	int jiesuan_again_new_butW;
	int jiesuan_again_weizhi_W;
	int jiesuan_again_weizhi_H;
	//����������
	int jiesuan_back_new_butH;
	int jiesuan_back_new_butW;
	int jiesuan_back_weizhi_W;
	int jiesuan_back_weizhi_H;
	//�Ƿ���
	private boolean isPress_back;
	private boolean isPress_again;
	DataBase_Score database_score;
	DataBase_Player database_player;
	Context context;
	public int goldcoin,gold_this;
	public Game_jiesuan(Bitmap jiesuan_again, Bitmap jiesuan_again_press, Bitmap jiesuan_back,
			Bitmap jiesuan_back_press, Bitmap jiesuan_mengban,Context context) 
	{   
		this.context=context;
		this.jiesuan_again=jiesuan_again;
		this.jiesuan_again_press=jiesuan_again_press;
		this.jiesuan_back=jiesuan_back;
		this.jiesuan_back_press=jiesuan_back_press;
		this.jiesuan_mengban=jiesuan_mengban;
		isPress_back=false;
		isPress_again=false;
	}
	public void draw(Canvas canvas, Paint paint)
	{    
		database_player = new DataBase_Player(context);
		database_score= new DataBase_Score(context);
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //���������ɰ�
	    // ���ͼƬ�Ŀ��
	     int jiesuan_mengban_width = jiesuan_mengban.getWidth();
	     int jiesuan_mengban_height = jiesuan_mengban.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_mengban_new = Bitmap.createBitmap(jiesuan_mengban,0,0, jiesuan_mengban_width,jiesuan_mengban_height, matrix, true);
	     jiesuan_mengban_new_butH = jiesuan_mengban_new.getHeight();//ͼƬ�ĸ߶�
	     jiesuan_mengban_new_butW = jiesuan_mengban_new.getWidth();//ͼƬ�Ŀ��
	     jiesuan_mengban_weizhi_W = (GamingPlaneTest.screenW-jiesuan_mengban_new_butW)/2;
	     jiesuan_mengban_weizhi_H = (GamingPlaneTest.screenH/64)*5;
	     canvas.drawBitmap(jiesuan_mengban_new,jiesuan_mengban_weizhi_W,jiesuan_mengban_weizhi_H, paint);
	     //����������
	     // ���ͼƬ�Ŀ��
	     int jiesuan_back_width = jiesuan_back.getWidth();
	     int jiesuan_back_height = jiesuan_back.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_back_new = Bitmap.createBitmap(jiesuan_back,0,0, jiesuan_back_width,jiesuan_back_height, matrix, true);
	     jiesuan_back_new_butH = jiesuan_back_new.getHeight();//ͼƬ�ĸ߶�
	     jiesuan_back_new_butW = jiesuan_back_new.getWidth();//ͼƬ�Ŀ��
	     jiesuan_back_weizhi_W = (GamingPlaneTest.screenW-jiesuan_mengban_new_butW)/2;
	     jiesuan_back_weizhi_H = (GamingPlaneTest.screenH/32)*27;
	     //����һ��
	     // ���ͼƬ�Ŀ��
	     int jiesuan_again_width = jiesuan_again.getWidth();
	     int jiesuan_again_height = jiesuan_again.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_again_new = Bitmap.createBitmap(jiesuan_again,0,0,jiesuan_again_width,jiesuan_again_height,matrix,true);
	     jiesuan_again_new_butH = jiesuan_again_new.getHeight();//ͼƬ�ĸ߶�
	     jiesuan_again_new_butW = jiesuan_again_new.getWidth();//ͼƬ�Ŀ��
	     jiesuan_again_weizhi_W = (jiesuan_mengban_weizhi_W+jiesuan_mengban_new_butW)-jiesuan_again_width;
	     jiesuan_again_weizhi_H = (GamingPlaneTest.screenH/32)*27;
	     //����ȥ��Ч��
	     // ���ͼƬ�Ŀ��
	     //�ص�������İ���ȥ�İ�ť
	     int jiesuan_back_press_width = jiesuan_back_press.getWidth();
	     int jiesuan_back_press_height = jiesuan_back_press.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_back_press_new = Bitmap.createBitmap(jiesuan_back_press,0,0, jiesuan_back_press_width,jiesuan_back_press_height, matrix, true);
	     //����һ�ֵİ���ȥ�İ�ť
	     int jiesuan_again_press_width = jiesuan_again_press.getWidth();
	     int jiesuan_again_press_height = jiesuan_again_press.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_again_press_new = Bitmap.createBitmap(jiesuan_again_press,0,0, jiesuan_again_press_width,jiesuan_again_press_height, matrix, true);
	     //�ж��Ƿ���
	     if (isPress_back) 
			{//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
	    	 canvas.drawBitmap(jiesuan_back_press_new,jiesuan_back_weizhi_W,jiesuan_back_weizhi_H, paint);
			} else
			{
				canvas.drawBitmap(jiesuan_back_new,jiesuan_back_weizhi_W,jiesuan_back_weizhi_H, paint);
			}
	     if (isPress_again) 
			{//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
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
	//�˵������¼���������Ҫ���ڴ���ť�¼�
		public void onTouchEvent(MotionEvent event) {
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			
			//���û��ǰ��¶������ƶ�����
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
	           //̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
				if (pointX > jiesuan_back_weizhi_W && pointX < jiesuan_back_weizhi_W + jiesuan_back_new_butW)
				{
					if (pointY > jiesuan_back_weizhi_H && pointY < jiesuan_back_weizhi_H + jiesuan_back_new_butH) 
					{
						isPress_back = false;
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_MENU;
						//jiesuan����
						goldcoin=DataBase_Player.goldcoin;
						gold_this=GamingPlaneTest.mark/1000;
						goldcoin=goldcoin+gold_this;
						if(MainActivity.mac!=null){
						database_player.UpdateGoldCoin(goldcoin);
						}
						if(MainActivity.mac==null){
							 SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
				        		//���ݴ洢
				        		SharedPreferences.Editor editor=prefs.edit();
				        		editor.putInt("goldcoin",goldcoin);
				        		editor.commit();
						}
						DataBase_Player.goldcoin=goldcoin;
						//�ύ��ǰ����
						database_score.insert_score();
						//����
						GamingPlaneTest.isBoss=false;
						GamingPlayer.unbeatable=false;
						GamingPlaneTest.mark=0;
						GamingPlaneTest.	vcEnemy.removeAllElements();
						GamingPlaneTest.	vcBullet.removeAllElements();
						GamingPlaneTest.	vcBuff.removeAllElements();	
						GamingPlaneTest.	vcBulletPlayer.removeAllElements();
						GamingPlaneTest.	 kill=0;
						GamingPlaneTest.	 hurt=0;
						GamingPlaneTest.	 gold=0;
						GamingPlaneTest.	enemyArrayIndex=0;
						GamingPlaneTest.   player.setPlayerHp(3);
						GamingPlaneTest.	bulletlv=1;
						//TODO λ�����ò���ȷ
						GamingPlayer.pointX = GamingPlaneTest. screenW / 2 -GamingPlaneTest. Player.getWidth() / 2;
				     	GamingPlayer.pointY = GamingPlaneTest.screenH - GamingPlaneTest.Player.getHeight();
				     	GamingPlaneTest.	vcEnemy.removeAllElements();
				     	GamingPlaneTest.	vcBullet.removeAllElements();
				     	GamingPlaneTest.	vcBuff.removeAllElements();	
				     	GamingPlaneTest.	lv=1;
					}
				}
			 }	
			}
		//�˵������¼���������Ҫ���ڴ���ť�¼�
			public void onTouchEvent1(MotionEvent event) {
				//��ȡ�û���ǰ����λ��
				int pointX = (int) event.getX();
				int pointY = (int) event.getY();
				
				//���û��ǰ��¶������ƶ�����
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
		//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
					
					if (pointX > jiesuan_again_weizhi_W && pointX < jiesuan_again_weizhi_W + jiesuan_again_new_butW)
					{
						if (pointY > jiesuan_again_weizhi_H && pointY < jiesuan_again_weizhi_H + jiesuan_again_new_butH) 
						{   
							//����
							goldcoin=DataBase_Player.goldcoin;
							gold_this=GamingPlaneTest.mark/1000;
							goldcoin=goldcoin+gold_this;
							if(MainActivity.mac!=null){
							database_player.UpdateGoldCoin(goldcoin);
							}
							if(MainActivity.mac==null){
								 SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
					        		//���ݴ洢
					        		SharedPreferences.Editor editor=prefs.edit();
					        		editor.putInt("goldcoin",goldcoin);
					        		editor.commit();
							}
							DataBase_Player.goldcoin=goldcoin;
							
							database_score.insert_score();
							isPress_again = false;
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;
							GamingPlaneTest.isBoss=false;
							GamingPlayer.unbeatable=false;
							GamingPlaneTest.mark=0;
							GamingPlaneTest.	vcEnemy.removeAllElements();
							GamingPlaneTest.	vcBullet.removeAllElements();
							GamingPlaneTest.	vcBuff.removeAllElements();	
							GamingPlaneTest.	vcBulletPlayer.removeAllElements();
							GamingPlaneTest.	 kill=0;
							GamingPlaneTest.	 hurt=0;
							GamingPlaneTest.	 gold=0;
							GamingPlaneTest.	enemyArrayIndex=0;
							GamingPlaneTest.   player.setPlayerHp(3);
							GamingPlaneTest.	bulletlv=1;
							//TODO λ�����ò���ȷ
							GamingPlayer.pointX = GamingPlaneTest. screenW / 2 -GamingPlaneTest. Player.getWidth() / 2;
					     	GamingPlayer.pointY = GamingPlaneTest.screenH - GamingPlaneTest.Player.getHeight();
					     	GamingPlaneTest.	vcEnemy.removeAllElements();
					     	GamingPlaneTest.	vcBullet.removeAllElements();
					     	GamingPlaneTest.	vcBuff.removeAllElements();	
					     	GamingPlaneTest.	lv=1;
							
						} 
					}
					
				 }	
			}
	
}

