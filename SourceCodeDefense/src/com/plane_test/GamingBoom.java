package com.plane_test;



import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GamingBoom {
	//��ըЧ����Դͼ
	private Bitmap Boom;
	private int boomX, boomY;
	private int FrameIndex;
	private int totleFrame;
	private int frameW, frameH;
	public boolean end;

	//��ըЧ���Ĺ��캯��
	public GamingBoom(Bitmap Boom, int x, int y, int totleFrame) {
		this.Boom = Boom;
		this.boomX = x;
		this.boomY = y;
		this.totleFrame = totleFrame;
		frameW = Boom.getWidth() / totleFrame;
		frameH = Boom.getHeight();
	}

	//��ըЧ������
	public void draw(Canvas canvas, Paint paint) {
		canvas.save();
		canvas.clipRect(boomX, boomY, boomX + frameW, boomY + frameH);
		canvas.drawBitmap(Boom, boomX - FrameIndex * frameW, boomY, paint);
		canvas.restore();
	}

	//��ըЧ�����߼�
	public void logic() {
		if (FrameIndex < totleFrame) {//��ը�������ŵ�ǰ��֡�±�<//��ըЧ������֡��
			FrameIndex++;
		} else {
			end = true;
		}
	}
}
