package com.plane_test;



import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GamingBoom {
	//爆炸效果资源图
	private Bitmap Boom;
	private int boomX, boomY;
	private int FrameIndex;
	private int totleFrame;
	private int frameW, frameH;
	public boolean end;

	//爆炸效果的构造函数
	public GamingBoom(Bitmap Boom, int x, int y, int totleFrame) {
		this.Boom = Boom;
		this.boomX = x;
		this.boomY = y;
		this.totleFrame = totleFrame;
		frameW = Boom.getWidth() / totleFrame;
		frameH = Boom.getHeight();
	}

	//爆炸效果绘制
	public void draw(Canvas canvas, Paint paint) {
		canvas.save();
		canvas.clipRect(boomX, boomY, boomX + frameW, boomY + frameH);
		canvas.drawBitmap(Boom, boomX - FrameIndex * frameW, boomY, paint);
		canvas.restore();
	}

	//爆炸效果的逻辑
	public void logic() {
		if (FrameIndex < totleFrame) {//爆炸动画播放当前的帧下标<//爆炸效果的总帧数
			FrameIndex++;
		} else {
			end = true;
		}
	}
}
