package com.plane_ui;
import com.plane_test.GamingPlaneTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Game_NoMoney {
	Bitmap shop_nomoney;
    Bitmap tuichu_queding;//�˳�ȷ��
	Bitmap tuichu_quxiao;//�˳�ȡ��
    int shop_nomoney_new_butH;
    int shop_nomoney_new_butW;
    int shop_nomoney_weizhi_W;
    int shop_nomoney_weizhi_H;
    int tuichu_queding_new_butH;
    int tuichu_queding_new_butW;
    int tuichu_queding_weizhi_W;
    int tuichu_queding_weizhi_H;
    int tuichu_quxiao_new_butH;
    int tuichu_quxiao_new_butW;
    int tuichu_quxiao_weizhi_W;
    int tuichu_quxiao_weizhi_H;
    Context context;
	public Game_NoMoney(Bitmap shop_nomoney,Bitmap tuichu_queding,Bitmap tuichu_quxiao,Context context) 
	{   
		this.context=context;
		this.shop_nomoney=shop_nomoney;
		this.tuichu_queding =tuichu_queding;
		this.tuichu_quxiao =tuichu_quxiao;
	}
	//�˵���ͼ����
	public void draw(Canvas canvas, Paint paint) {
	     // ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth,GamingPlaneTest. scaleHeight); 
	    // ���ͼƬ�Ŀ��
	     int shop_nomoney_width = shop_nomoney.getWidth();
	     int shop_nomoney_height = shop_nomoney.getHeight();
	     // �õ��µ�ͼƬ //tuichu �˳�͸����
	     Bitmap shop_nomoney_new  = Bitmap.createBitmap(shop_nomoney,0,0, shop_nomoney_width, shop_nomoney_height, matrix, true);
	     shop_nomoney_new_butH = shop_nomoney_new.getHeight();//ͼƬ�ĸ߶�
	     shop_nomoney_new_butW = shop_nomoney_new.getWidth();//ͼƬ�Ŀ��
	     shop_nomoney_weizhi_W = (GamingPlaneTest.screenW-shop_nomoney_new_butW)/2;
	     shop_nomoney_weizhi_H = GamingPlaneTest.screenH/3;
	     canvas.drawBitmap(shop_nomoney_new,shop_nomoney_weizhi_W,shop_nomoney_weizhi_H, paint);
		//͸��������İ�ť��
	     //ȷ����ť
	     // ���ͼƬ�Ŀ��
	     int tuichu_queding_width = tuichu_queding.getWidth();
	     int tuichu_queding_height = tuichu_queding.getHeight();
	     Bitmap tuichu_queding_new  = Bitmap.createBitmap(tuichu_queding,0,0, tuichu_queding_width, tuichu_queding_height, matrix, true);
	     tuichu_queding_new_butH = tuichu_queding_new.getHeight();//ͼƬ�ĸ߶�
	     tuichu_queding_new_butW = tuichu_queding_new.getWidth();//ͼƬ�Ŀ��
	     tuichu_queding_weizhi_W = shop_nomoney_weizhi_W+(shop_nomoney_new_butW/17)*2;
	     tuichu_queding_weizhi_H = shop_nomoney_weizhi_H+(shop_nomoney_new_butH/3)*2;
	     canvas.drawBitmap(tuichu_queding_new,tuichu_queding_weizhi_W,tuichu_queding_weizhi_H, paint);    
	   //͸��������İ�ť��
	     //ȡ����ť
	     // ���ͼƬ�Ŀ��
	     int tuichu_quxiao_width = tuichu_quxiao.getWidth();
	     int tuichu_quxiao_height = tuichu_quxiao.getHeight();
	     Bitmap tuichu_quxiao_new  = Bitmap.createBitmap(tuichu_quxiao,0,0, tuichu_quxiao_width, tuichu_quxiao_height, matrix, true);
	     tuichu_quxiao_new_butH = tuichu_quxiao_new.getHeight();//ͼƬ�ĸ߶�
	     tuichu_quxiao_new_butW = tuichu_quxiao_new.getWidth();//ͼƬ�Ŀ��
	     tuichu_quxiao_weizhi_W = shop_nomoney_weizhi_W+(shop_nomoney_new_butW/17)*15-tuichu_quxiao_new_butW;
	     tuichu_quxiao_weizhi_H = shop_nomoney_weizhi_H+(shop_nomoney_new_butH/3)*2;
		 canvas.drawBitmap(tuichu_quxiao_new,tuichu_quxiao_weizhi_W,tuichu_quxiao_weizhi_H, paint);
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
				     GamingPlaneTest.gameState=GamingPlaneTest.GAME_SHOP_DAOJU;
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
}
