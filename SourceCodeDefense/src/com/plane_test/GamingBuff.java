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
	//���췽��
	public GamingBuff(Bitmap buff,int enx,int eny,int type)
	{
		this.buff=buff;
		this.buffx=enx;
		this.buffy=eny;
		this.type=type;//buff����
		frameW=buff.getWidth() / 5;
		frameH=buff.getHeight();
	}
	//����buffͼ
		public void draw(Canvas canvas,Paint paint) {
			//����buffͼ
			canvas.save();
			canvas.clipRect(buffx, buffy, buffx + frameW, buffy + frameH);
			canvas.drawBitmap(buff, buffx - Index * frameW, buffy, paint);
			canvas.restore();		
		}
  //buff�߼�
  public void logic()
  {
	  Index++;   //��ǰ֡
		if (Index >= 5) {
			Index = 0;
		}
	  int a=GamingPlayer.pointX-buffx;
	  int b =GamingPlayer.pointY-buffy;
      buffx+=a/15;
	  buffy+=b/15;
      buffy+=speed;
  }  
  
//�ж���ײ
	public boolean isCollsionWith(GamingBuff buff) {
	
		
		//   if(buffx>Player.pointX&&buffx<=Player.pointX+Player.bmpPlayer.getWidth()){
		//	      if(buffy>=Player.pointY&&buffx<=Player.pointX+Player.bmpPlayer.getHeight())
		//	    	  return true;
		//	      }    
		// return false;
		   
		int x2 = buff.buffx;  //�ӵ�x,y����
		int y2 = buff.buffy;
		int w2 = buff.frameW;
		int h2 = buff.frameH;
		if (GamingPlayer.pointX >= x2 && GamingPlayer.pointX >= x2 + w2) {
			return false;
		} else if (GamingPlayer.pointX < x2 && GamingPlayer.player.getWidth()<=x2 ) {    //Ӧ��   Player.pointX < x2  &&  Player.pointx + bmpPlayer.getWidth<=x2
			return false;
		} else if (GamingPlayer.pointY >= y2 && GamingPlayer.pointY >= y2 + h2) {
			return false;
		} else if (GamingPlayer.pointY <= y2  && GamingPlayer.pointY + GamingPlayer.player.getHeight()<=y2) {   //Ӧ��Player.pointY <= y2 && Player.pointY + bmpPlayer.getHeigh<=y2
			return false;
		}		
		
	  
		return true;
		
		  
			
	

  }
  

  
  
  
}









