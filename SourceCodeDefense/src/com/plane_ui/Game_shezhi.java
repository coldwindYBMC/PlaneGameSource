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
	//�˵�����ͼ
	Bitmap shezhi_guanyu;
	Bitmap shezhi_shengming;
	Bitmap shezhi_bangzhu;
	Bitmap shezhi_fanhui;
	Bitmap shezhi_mengban;
	Bitmap shezhi_fanhui_press;
	Bitmap shezhi_duihao;
	//ͼƬ�ĸ������ԣ������߶ȣ���ȵ�
	//�ɰ�λ��
	int shezhi_mengban_new_butH;
	int shezhi_mengban_new_butW;
	int shezhi_mengban_weizhi_W;
	int shezhi_mengban_weizhi_H;
	 //���ý����еķ��ذ�ť
	int shezhi_fanhui_new_butH;
	int shezhi_fanhui_new_butW;
	int shezhi_fanhui_weizhi_W;
	int shezhi_fanhui_weizhi_H;
	//���ý���İ�����ť
	int shezhi_bangzhu_new_butH;
	int shezhi_bangzhu_new_butW;
	int shezhi_bangzhu_weizhi_W;
	int shezhi_bangzhu_weizhi_H;
	//���ù���
	int shezhi_guanyu_new_butH;
	int shezhi_guanyu_new_butW;
	int shezhi_guanyu_weizhi_W;
	int shezhi_guanyu_weizhi_H;
	//��������
	int shezhi_shengming_new_butH;
	int shezhi_shengming_new_butW;
	int shezhi_shengming_weizhi_W;
	int shezhi_shengming_weizhi_H;
	//����ȥ��״̬
	private boolean isPress_shezhi_fanhui;
	//���ֿ���
	private boolean isPress_shezhi_yinyue;
	//��������
	private boolean isPress_shezhi_zhongli;
	Context context;
	private boolean isPress_shezhi_zhendong;
	public Game_shezhi( Bitmap shezhi_fanhui,Bitmap shezhi_guanyu, Bitmap shezhi_bangzhu,Bitmap shezhi_shengming,
			Bitmap shezhi_mengban,	Bitmap shezhi_fanhui_press,Bitmap shezhi_duihao,Context context) {
		//X���У�Y������Ļ�ײ�
				this.shezhi_fanhui=shezhi_fanhui;
				this.shezhi_guanyu=shezhi_guanyu;
				this.shezhi_shengming=shezhi_shengming;
				this.shezhi_bangzhu=shezhi_bangzhu;
				this.shezhi_mengban=shezhi_mengban;
				this.shezhi_fanhui_press=shezhi_fanhui_press;
				this.shezhi_duihao=shezhi_duihao;
				this.context=context;
				isPress_shezhi_fanhui= false;
				  //���ݶ�ȡ
				SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
		        isPress_shezhi_yinyue =prefs.getBoolean("isPress_shezhi_yinyue",true);//�������ֿ���
		        isPress_shezhi_zhongli =prefs.getBoolean("isPress_shezhi_zhongli",false);//��������
		        isPress_shezhi_zhendong=prefs.getBoolean("isPress_shezhi_zhendong",false);//��������
		        scW=GamingPlaneTest.screenW;
				scH=GamingPlaneTest.screenH;
	}
	//�˵���ͼ����
	public void draw(Canvas canvas, Paint paint) {
		 // ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
		 //�ɰ����İڷ�
		 int shezhi_mengban_width = shezhi_mengban.getWidth();
	     int shezhi_mengban_height = shezhi_mengban.getHeight();
	     Bitmap shezhi_mengban_new  = Bitmap.createBitmap(shezhi_mengban,0,0,shezhi_mengban_width,shezhi_mengban_height, matrix, true);
	     shezhi_mengban_new_butH = shezhi_mengban_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_mengban_new_butW = shezhi_mengban_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_mengban_weizhi_W = (scW-shezhi_mengban_new_butW)/2;
	     shezhi_mengban_weizhi_H = (scH/16)*3;
	     canvas.drawBitmap(shezhi_mengban_new,shezhi_mengban_weizhi_W,shezhi_mengban_weizhi_H, paint);//�ɰ��λ��
		 //���ý���ķ��ذ�ť
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;
	     //���ý���İ�����ť
	     int shezhi_bangzhu_width = shezhi_bangzhu.getWidth();
	     int shezhi_bangzhu_height = shezhi_bangzhu.getHeight();
	     Bitmap shezhi_bangzhu_new  = Bitmap.createBitmap(shezhi_bangzhu,0,0,shezhi_bangzhu_width,shezhi_bangzhu_height, matrix, true);
	     shezhi_bangzhu_new_butH = shezhi_bangzhu_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_bangzhu_new_butW = shezhi_bangzhu_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_bangzhu_weizhi_W = scW/18;
	     shezhi_bangzhu_weizhi_H = (scH/8)*7;
	     //���ڵİ�ť
	     int shezhi_guanyu_width = shezhi_guanyu.getWidth();
	     int shezhi_guanyu_height = shezhi_guanyu.getHeight();
	     Bitmap shezhi_guanyu_new  = Bitmap.createBitmap(shezhi_guanyu,0,0,shezhi_guanyu_width,shezhi_guanyu_height, matrix, true);
	     shezhi_guanyu_new_butH = shezhi_guanyu_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_guanyu_new_butW = shezhi_guanyu_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_guanyu_weizhi_W = (scW/18)*7;
	     shezhi_guanyu_weizhi_H = (scH/8)*7;
	     //�����İ�ť
	     int shezhi_shengming_width = shezhi_shengming.getWidth();
	     int shezhi_shengming_height = shezhi_shengming.getHeight();
	     Bitmap shezhi_shengming_new  = Bitmap.createBitmap(shezhi_shengming,0,0,shezhi_shengming_width,shezhi_shengming_height, matrix, true);
	     shezhi_shengming_new_butH = shezhi_shengming_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_shengming_new_butW = shezhi_shengming_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_shengming_weizhi_W = (scW/18)*13;
	     shezhi_shengming_weizhi_H = (scH/8)*7;
	     //���ÿ����еĶԺ�
	     //���ֶԺ�
	     int shezhi_duihao_width = shezhi_duihao.getWidth();
	     int shezhi_duihao_height = shezhi_duihao.getHeight();
	     Bitmap shezhi_duihao_new  = Bitmap.createBitmap(shezhi_duihao,0,0,shezhi_duihao_width,shezhi_duihao_height, matrix, true);
	     float shezhi_yinyue_weizhi_W = shezhi_mengban_weizhi_W+(shezhi_mengban_new_butW/17)*12;
	     float shezhi_yinyue_weizhi_H = shezhi_mengban_weizhi_H+(shezhi_mengban_new_butH/220)*39;
	     //������Ӧ�ĶԺ�
	     float shezhi_zhongli_weizhi_W = (scW/36)*25;
	     float shezhi_zhongli_weizhi_H = (scH/320)*139;
	     //z�𶯷�����Ӧ�ĶԺ�
	     float shezhi_zhendong_weizhi_W = (scW/36)*25;
	     float shezhi_zhendong_weizhi_H = (scH/16)*9;
		//����δ���°�ťͼ
		if (isPress_shezhi_fanhui) {
		//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		} else {
			canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
		}
		//��������
		canvas.drawBitmap(shezhi_bangzhu_new ,shezhi_bangzhu_weizhi_W,shezhi_bangzhu_weizhi_H, paint);
		//���ڽ���
		canvas.drawBitmap(shezhi_guanyu_new ,shezhi_guanyu_weizhi_W,shezhi_guanyu_weizhi_H, paint);
		canvas.drawBitmap(shezhi_shengming_new ,shezhi_shengming_weizhi_W,shezhi_shengming_weizhi_H, paint);	
		//���ֿ���
		if (isPress_shezhi_yinyue) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			canvas.drawBitmap(shezhi_duihao_new,shezhi_yinyue_weizhi_W,shezhi_yinyue_weizhi_H, paint);
			
			}
		else { 
			
			}	
		//��������
		if (isPress_shezhi_zhongli) {
					//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			canvas.drawBitmap(shezhi_duihao_new,shezhi_zhongli_weizhi_W,shezhi_zhongli_weizhi_H, paint);
			}
		else { 
					
			}	
		if (isPress_shezhi_zhendong) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			canvas.drawBitmap(shezhi_duihao_new,shezhi_zhendong_weizhi_W,shezhi_zhendong_weizhi_H, paint);
	     }
        else { 
			
	      }	
	} 
	///��������
	//�˵���ͼ����
		public void draw1(Canvas canvas, Paint paint) {
			 // ȡ����Ҫ���ŵ�matrix����
		     Matrix matrix = new Matrix();
		     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
			 //���ý���ķ��ذ�ť
			 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
		     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
		     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
		     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
		     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
		     shezhi_fanhui_weizhi_W = scW/18;
		     shezhi_fanhui_weizhi_H = scH/16;
			//����δ���°�ťͼ
			if (isPress_shezhi_fanhui) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			}
			
			
		}
	//�˵������¼���������Ҫ���ڴ���ť�¼�
	public void onTouchEvent(MotionEvent event) {
		//��ȡ�û���ǰ����λ��
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//���û��ǰ��¶������ƶ�����
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			//�ж��û��Ƿ����˰�ť
			//����
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
			//���û���̧����
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
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
	//�˵������¼���������Ҫ���ڴ���ť�¼�
		public void onTouchEvent1(MotionEvent event) {
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {}
				//���û���̧����
			 else if (event.getAction() == MotionEvent.ACTION_UP) {
				//��������̧���Ƕ���
				if (pointX >shezhi_bangzhu_weizhi_W&& pointX <shezhi_bangzhu_weizhi_W+ shezhi_bangzhu_new_butW)
				{
					if (pointY >shezhi_bangzhu_weizhi_H&& pointY <shezhi_bangzhu_weizhi_H+ shezhi_bangzhu_new_butH ) 
					{   
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI_BANGZHU;	
					} 
				}
				//���ڽ�����л�
				if (pointX >shezhi_guanyu_weizhi_W&& pointX <shezhi_guanyu_weizhi_W+ shezhi_bangzhu_new_butW)
				{
					if (pointY >shezhi_guanyu_weizhi_H&& pointY <shezhi_guanyu_weizhi_H+ shezhi_bangzhu_new_butH ) 
					{   
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI_GUANYU;	
					} 
				}
				//������ť
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
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//���ֿ���
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
						//���ݴ洢
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
				//��������
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
				
				//�𶯿���
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
				//���û���̧����
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
			
		   }
		}
}
	
	
