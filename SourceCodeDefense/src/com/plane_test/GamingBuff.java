package com.plane_test;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GamingBuff {
	private  Bitmap buff;
	private int speed=6;
	private int  buffx,buffy;
	public int type;
	boolean isDead;
	private int frameW,frameH;
	private int Index;
	//构造方法
	public GamingBuff(Bitmap buff,int enx,int eny,int type)
	{
		this.buff=buff;
		this.buffx=enx;
		this.buffy=eny;
		this.type=type;//buff类型
		frameW=buff.getWidth() / 5;
		frameH=buff.getHeight();
	}
	//绘制buff图
		public void draw(Canvas canvas,Paint paint) {
			//绘制buff图
			canvas.save();
			canvas.clipRect(buffx, buffy, buffx + frameW, buffy + frameH);
			canvas.drawBitmap(buff, buffx - Index * frameW, buffy, paint);
			canvas.restore();		
		}
  //buff逻辑
  public void logic()
  {
	  Index++;   //当前帧
		if (Index >= 5) {
			Index = 0;
		}
	  int a=GamingPlayer.pointX-buffx;
	  int b =GamingPlayer.pointY-buffy;
      buffx+=a/15;
	  buffy+=b/15;
      buffy+=speed;
  }  
  
//判断碰撞
	public boolean isCollsionWith(GamingBuff buff) {
	
		
		//   if(buffx>Player.pointX&&buffx<=Player.pointX+Player.bmpPlayer.getWidth()){
		//	      if(buffy>=Player.pointY&&buffx<=Player.pointX+Player.bmpPlayer.getHeight())
		//	    	  return true;
		//	      }    
		// return false;
		   
		int x2 = buff.buffx;  //子弹x,y坐标
		int y2 = buff.buffy;
		int w2 = buff.frameW;
		int h2 = buff.frameH;
		if (GamingPlayer.pointX >= x2 && GamingPlayer.pointX >= x2 + w2) {
			return false;
		} else if (GamingPlayer.pointX < x2 && GamingPlayer.player.getWidth()<=x2 ) {    //应当   Player.pointX < x2  &&  Player.pointx + bmpPlayer.getWidth<=x2
			return false;
		} else if (GamingPlayer.pointY >= y2 && GamingPlayer.pointY >= y2 + h2) {
			return false;
		} else if (GamingPlayer.pointY <= y2  && GamingPlayer.pointY + GamingPlayer.player.getHeight()<=y2) {   //应当Player.pointY <= y2 && Player.pointY + bmpPlayer.getHeigh<=y2
			return false;
		}		
		
	  
		return true;
		
		  
			
	

  }
  

  
  
  
}









