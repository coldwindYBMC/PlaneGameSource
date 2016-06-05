package com.plane_test;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
public class GameingBg {
	//��Ϸ������ͼƬ��Դ
	//Ϊ��ѭ�����ţ����ﶨ������λͼ����
	//����Դ���õ���ͬһ��ͼƬ
	private Bitmap bmpBackGround1;
	private Bitmap bmpBackGround2;
	private Bitmap tuichu_queding;
	//��Ϸ��������
	private int bg1y, bg2y;
	//���������ٶ�
	private int speed = 10;

	//��Ϸ�������캯����
	public GameingBg(Bitmap bmpBackGround,Bitmap tuichu_queding) {
		this.bmpBackGround1 = bmpBackGround;
		this.bmpBackGround2 = bmpBackGround;
		this.tuichu_queding = tuichu_queding;
	//	��һ�Ŵ�0��ʼ���ڶ�����β���
		
		bg1y = 0;
	
		bg2y= bg1y+bmpBackGround1.getHeight();
	}
	//��Ϸ�����Ļ�ͼ����
	public void draw(Canvas canvas, Paint paint) {

		canvas.drawBitmap(bmpBackGround1, 0, bg1y, paint);
		canvas.drawBitmap(bmpBackGround2, 0,bg2y , paint);
	}
//��Ϸ�������߼�����

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




