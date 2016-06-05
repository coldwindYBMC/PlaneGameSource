package com.plane_ui;
import com.plane_test.GamingPlaneTest;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Game_Lost {
	public static int scW;
	public static int scH;
	//public static float scaleWidth;
	//public static float scaleHeight;
	public Bitmap game_lost;
	public Bitmap jiesuan_again;
	public Bitmap jiesuan_again_press;
	public Bitmap jiesuan_back;
	public Bitmap jiesuan_back_press;
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
	public Game_Lost(Bitmap game_lost,
			Bitmap jiesuan_again, Bitmap jiesuan_again_press, Bitmap jiesuan_back,
			Bitmap jiesuan_back_press ) 
	{   this.game_lost=game_lost;
		this.jiesuan_again=jiesuan_again;
		this.jiesuan_again_press=jiesuan_again_press;
		this.jiesuan_back=jiesuan_back;
		this.jiesuan_back_press=jiesuan_back_press;
		isPress_back=false;
		isPress_again=false;
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;
		
	}
	public void draw(Canvas canvas, Paint paint)
	{
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //����ͼƬ
	     // ���ͼƬ�Ŀ��
	     int game_lost_width = game_lost.getWidth();
	     int game_lost_height = game_lost.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap game_lost_new = Bitmap.createBitmap(game_lost,0,0, game_lost_width,game_lost_height, matrix, true);
	     canvas.drawBitmap(game_lost_new,0,0, paint);
	     //����������
	     // ���ͼƬ�Ŀ��
	     int jiesuan_back_width = jiesuan_back.getWidth();
	     int jiesuan_back_height = jiesuan_back.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_back_new = Bitmap.createBitmap(jiesuan_back,0,0, jiesuan_back_width,jiesuan_back_height, matrix, true);
	     jiesuan_back_new_butH = jiesuan_back_new.getHeight();//ͼƬ�ĸ߶�
	     jiesuan_back_new_butW = jiesuan_back_new.getWidth();//ͼƬ�Ŀ��
	     jiesuan_back_weizhi_W = scW/18;
	     jiesuan_back_weizhi_H = (scH/32)*27;
	     //����һ��
	     // ���ͼƬ�Ŀ��
	     int jiesuan_again_width = jiesuan_again.getWidth();
	     int jiesuan_again_height = jiesuan_again.getHeight();
	     // �õ��µ�ͼƬ 
	     Bitmap jiesuan_again_new = Bitmap.createBitmap(jiesuan_again,0,0,jiesuan_again_width,jiesuan_again_height,matrix,true);
	     jiesuan_again_new_butH = jiesuan_again_new.getHeight();//ͼƬ�ĸ߶�
	     jiesuan_again_new_butW = jiesuan_again_new.getWidth();//ͼƬ�Ŀ��
	     jiesuan_again_weizhi_W = (scW/18)*17-jiesuan_again_width;
	     jiesuan_again_weizhi_H = (scH/32)*27;
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
				GameLoading.mediaplayer1.stop();
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
							isPress_again = false;
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;
							
						} 
					}
					
				 }	
			}
	
}

