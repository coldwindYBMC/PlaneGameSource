package com.plane_test;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
public class GamingBullet extends Thread{
     //�ӵ�ͼƬ��Դ
	public Bitmap Bullet;
	//public Bitmap Bullet1;
	//�ӵ�������
	public  int bulletX, bulletY;
	//�����ӵ�����
	public   int bulletX1;
	public  int bulletY1;
	//���Ƿɻ�������
	public int pointx,pointy;

	//�ӵ�ÿ֡�Ŀ��
	public int eframeW, eframeH;
	//�ӵ���ǰ֡�±�
	private int frameIndex;
	//�ӵ����ٶ�
	public int speed;
	private int c;
	//�ӵ��������Լ�����
	public int bulletType;
	//���ǵ�
	public static final int BULLET_PLAYER = -1;
	
	public static final int BULLET_F2 = 1;

	public static final int BULLET_F1 = 2;
	public static final int BULLET_liaoji = 7;
	
	public static final int BULLET_F3 = 3;
	//Boss��
	public static final int BULLET_BOSS = 10;
	//�л�4
	public static final int BULLET_A = 4;
	public static final int BULLET_B = 5;
	public static final int BULLET_C = 6;
	public static final int BULLET_D = 7;
	//�ӵ��Ƿ����� �Ż�����
	public boolean isDead;   
   
    //Boss���״̬���ӵ���س�Ա����
	private int dir;
	public static int bulletlv;  
	//crazy �ӵ�
	public static final int DIR1_A = -1;
	public static final int DIR1_B = 2;
	public static final int DIR1_C = 3;
	public static final int DIR1_D = 4;
	public static final int DIR1_E = 5;
	public static final int DIR1_F = 6;
	public static final int DIR1_G = 7;
	public static final int DIR1_H = 8;
	
	public static final int DIR_A= 10;
	public static final int DIR_B = 11;
	public static final int DIR_C = 12;
	public static final int DIR_D = 13;
	public static final int DIR_E = 14;
	public static final int DIR_F = 15;
	public static final int DIR_G = 16;
	public static final int DIR_H = 17;
	public static final int DIR_Z= 34;
	public static final int DIR_I= 18;
	public static final int DIR_J = 19;
	public static final int DIR_R = 20;
	public static final int DIR_S = 21;
	public static final int DIR_P = 30;
	public static final int DIR_Q = 31;
	public static final int DIR_U = 32;
	public static final int DIR_V = 32;
	//BOSS�е�
	public static final int DIR_M = 50;
	//enemy4 ������
	public static final int A_1 = 18;
	public static final int A_2 = 19;
	public static final int A_3 = 20;
	public static final int A_4 = 21;
	public static final int A_5 = 22;
	//������
		public static final int D_1 = 18;
		public static final int D_2 = 19;
		public static final int D_3 = 20;
		public static final int D_4 = 21;
		public static final int D_5 = 22;
	
	//�ӵ���ǰ����
	public GamingBullet(Bitmap Bullet, int bulletX, int bulletY,int pointx,int pointy ,int bulletType,int bulletlv) {
		this.Bullet = Bullet;
		this.bulletX = bulletX;  //�ӵ�λ�ã�һ��Ϊ�ɻ�λ�ã���л�λ��
		this.bulletY = bulletY;
		this.bulletX1 = bulletX;  //�ӵ�λ�ã�һ��Ϊ�ɻ�λ�ã���л�λ��
		this.bulletY1 = bulletY;
		this.bulletType = bulletType;
		this.pointx=pointx; //����λ��
		this.pointy=pointy;
		this.bulletlv=bulletlv;		
		//��ͬ���ӵ������ٶȲ�һ
		switch (bulletType) {
		case BULLET_PLAYER:									
			 speed = 60;		
			 if(GamingPlaneTest.bulletlv>=9){
				 speed=15;
			 }
			break;
		case BULLET_F3:
			speed = 20;
			break;
		case BULLET_F2:
			speed = 20;
			break;
		case BULLET_F1:
			speed = 20;
			break;
		case BULLET_BOSS:
			speed = 20;
			break;
		case BULLET_A:
			speed = 30;
			break;
		case BULLET_B:
			speed = 10;
			break;
		
		
		}
	}
	/**
	 * ר���ڴ���С�ɻ��ӵ�
	 * 
	 */
	public GamingBullet(Bitmap Bullet, int bulletX, int bulletY, int bulletType) {
		this.Bullet = Bullet;
		this.bulletX = bulletX;
		this.bulletY = bulletY;
		this.bulletType = bulletType;
		eframeW = Bullet.getWidth() / 3;
		eframeH = Bullet.getHeight();
		speed=15;
		
	}	
	/**
	 * ר���ڴ���Boss���״̬�´������ӵ�
	 */
	public GamingBullet(Bitmap Bullet, int bulletX, int bulletY, int bulletType, int dir) {
		this.Bullet = Bullet;
		this.bulletX = bulletX;
		this.bulletY = bulletY;
		this.bulletType = bulletType;
		eframeW = Bullet.getWidth() / 3;
		eframeH = Bullet.getHeight();
		speed=15;
		this.dir = dir;	
	}
	
	

	//�ӵ��Ļ���
    //����л�����ͬһ���Ʒ�������ʹ��������ʱ���л��ӵ�������ǿ
	//��ǿ���������ݲ�ͬ�ĵл����࣬���û��Ʒ���������ʱ�������ڵл�����ʱǿ�з����ӵ�������draw������
	public void pdraw(Canvas canvas, Paint paint) {		
		if(bulletlv==1||bulletlv==4)
		canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4) ,bulletY1, paint);	
        if(bulletlv==2){
		canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4)+20 ,bulletY1, paint);	
		canvas.drawBitmap(Bullet, bulletX1 +(GamingPlayer.pframeW/4)-20,bulletY1, paint);	
		}
        if(bulletlv==5||bulletlv==6){
        canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4)-30 ,bulletY1, paint);	
		canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4) +30,bulletY1, paint);	
        }
		if(bulletlv==3)
		{
			canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4)+20 ,bulletY1, paint);	
			canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4)+10 ,bulletY1, paint);	
			canvas.drawBitmap(Bullet, bulletX1 +(GamingPlayer.pframeW/4)-10,bulletY1, paint);	
			canvas.drawBitmap(Bullet, bulletX1 +(GamingPlayer.pframeW/4)-20,bulletY1, paint);
		}
		if(bulletlv==7||bulletlv==8)
		{
			canvas.drawBitmap(Bullet, bulletX1+(GamingPlayer.pframeW/4)-GamingPlaneTest.Bullet2.getWidth()/4 ,bulletY1, paint);	
		}
		if(bulletlv>=9)
		{			 
			 canvas.drawBitmap(Bullet, GamingPlayer.pointX-Bullet.getWidth()/4 ,bulletY1-Bullet.getHeight(), paint);				
		}		
	}	
	public void ebdraw(Canvas canvas, Paint paint) {		
		canvas.save();
		canvas.clipRect(bulletX, bulletY, bulletX + eframeW, bulletY + eframeH);
		canvas.drawBitmap(Bullet, bulletX - frameIndex * eframeW, bulletY, paint);
		canvas.restore();
	}
	//�ӵ����߼�,���ݲ�ͬ�������в�ͬ���߼�
	public void logic() {
		//����ѭ������֡�γɶ���
	frameIndex++;   //��ǰ֡
	if (frameIndex >= 3) {
			frameIndex = 0;
	}
		//��ͬ���ӵ������߼���һ		
				switch (bulletType) {	
				
				
		case BULLET_PLAYER:						
				bulletY1-=speed;						
				if (bulletY1< 0) {   //�ӵ���Y����
					isDead = true;    //������Ļ
				}					
			break;					
		case BULLET_F1:
			bulletY+=speed;
		break;
	
		case BULLET_F3:
		     bulletY+=speed;
		     bulletX+=speed;
		     break;
		case BULLET_F2:
		     bulletY+=speed;
		     bulletX-=speed;
		     break;
		case BULLET_B:
			if(GamingPlayer.pointX>GamingPlaneTest.screenW/2+10){
			    bulletX +=20;
				bulletY +=30;
			}
			if(GamingPlayer.pointX<GamingPlaneTest.screenW/2-10){
				 bulletX -=20;
			     bulletY +=30;				
				}	
			else{
				 bulletY +=20;	
			}
			break;
		case BULLET_C:
			
			speed-=1;	
			if(speed>=0)
			  bulletY +=speed;	
			else{	   
			  bulletY-=speed*3;
			}
		    break;	
			
		case BULLET_D:
		  switch(dir){
		case D_1:
		      bulletX+=5;
		      bulletY+=5;
		case D_2:
	      bulletX-=5;
	      bulletY+=5;
		case D_3:
	      bulletX+=5;
	      bulletY-=5;
		case D_4:
	      bulletX-=5;
	      bulletY-=5;
		case D_5:    
	      bulletY+=5;
		    break;		
		  }
		  //���ٵ���
	/*		int ydx=	bulletX-pointx;//�ӵ�-��������  ����0 Ϊ�ӵ��ڷɻ��Ҳ࣬С��0Ϊ�ӵ��ڷɻ����
			int ydy=    bulletY-pointy;
	
		if(ydx==0)    //�ӵ���ɻ���ֱ
		{		
			if(bulletY<pointy)   //�ӵ��ڷɻ��Ϸ�
			    bulletY+=speed;	
			else
				isDead=true;
			if(bulletY>=pointy)                      //�·�
				bulletY-=speed;   
			else
				isDead=true;
		}
		if(ydy==0)
		{
			if(bulletX<pointx)
			    bulletX+=speed;
			else 
			{
				
				isDead=true;
			
			}
			if(bulletX>=pointx)
			    bulletX-=speed;
			else
			{
				
				isDead=true;
			
			}
		}
		
		if(ydx<0 &&bulletY<pointy)//�ӵ��ڷɻ������,�ӵ��ڷɻ��Ϸ�
		{
			
			bulletX+=(speed-2);
			bulletY+=speed;
			if(ydx>=0||bulletY>=pointy)   //���������������ӵ�����
			{
				
				isDead = true; 
				
			}
		
		}
		if(ydx>0&&bulletY<pointy)//�ӵ��ڷɻ����Ҳ�,�ӵ��ڷɻ��Ϸ�
		{
			bulletX-=(speed-2);
			bulletY+=speed;
		    if(ydx<=0||bulletY>=pointy)
		    {	    	
		    	isDead = true;		    	
		    }
		
		}
		if(ydx<0&&bulletY>pointy)//�ӵ��ڷɻ������,�ӵ��ڷɻ��·�
		{
			bulletX+=(speed-2);
			bulletY-=speed;
			if(ydx>=0||bulletY<=pointy)
		    {
		    	isDead = true;	   
		    }		
		}
		if(ydx>0&&bulletY>pointy)//�ӵ��ڷɻ����Ҳ�,�ӵ��ڷɻ��·�
		{
			bulletX-=(speed-2);
			bulletY-=speed;
			if(ydx<=0||bulletY<=pointy)
		    {
		    	isDead = true;
		   
		    }
	
		}
		
		if ( bulletY > MySurfaceView.screenH  ) {
			isDead = true;
		}
			
		break;
		*/
		
		case BULLET_A:
		   switch(dir)
		   {
		   case A_1 :
			   bulletX-=speed-7;
			   bulletY+=speed+5;
		     break;
		   case A_2 :
			   bulletX-=speed-7;
			   bulletY+=speed+5;
		     break;
		   case A_3 :
			   
			   bulletY+=speed+5;
		     break;
		   case A_4 :
			   bulletX+=speed-7;
			   bulletY+=speed+5;
		     break;
		   case A_5 :
			   bulletX+=speed-7;
			   bulletY+=speed+5;
		     break;		   		   
		   }
		   break;
		
		//Boss�ӵ��߼�
		case BULLET_BOSS:
		
			switch (dir) {
			case DIR1_A:
				bulletY += speed;
				break;
			
			case DIR1_B:
				bulletY += speed;
				break;
			
			case DIR1_C:
				bulletY += speed;
				bulletX+=speed/2;
				break;
			
			case DIR1_D:
				bulletY += speed;
				bulletX -= speed/2;
				break;
			
			case DIR1_E:
				bulletY += speed;
				
				break;
		
			case DIR1_F:
				
				bulletY += speed;
				break;
		
			case DIR1_G:
				bulletX += speed/3;
				bulletY += speed;
				break;
		
			case DIR1_H:
				bulletY += speed;
				bulletX -= speed/3;
				break;
			
			
		case DIR_A:
			bulletX -=30;
			bulletY +=30;
			break;
		case DIR_B:
			bulletX -=20;
			bulletY +=30;
		break;
		case	 DIR_C :
			bulletX -=10;
			bulletY +=30;
			break;
			
		case DIR_D :
		bulletY +=30;
		break;
		case	 DIR_E:
		bulletY +=30;
		break;
		case	DIR_F:
		bulletX +=10;
		bulletY +=30;
		break;
		case	 DIR_G :
		bulletX +=20;
		bulletY +=30;
		break;
		case	 DIR_H :
		bulletX +=30;
		bulletY +=30;
		break;
		case DIR_I:
			speed-=2;		
		    if(speed>=0)
		    {
		    	bulletX-=speed;
			    bulletY-=speed;
		    }
		    else{
		    	bulletY-=speed;
		    }
		    break;
		case DIR_J:
			speed-=2;		
		    if(speed>=0)
		    {
		    	bulletX+=speed;
			    bulletY-=speed;
		    }
		    else{
		    	bulletY-=speed;
		    }
		    break;
		
		case DIR_Z:
			bulletY +=15;	
		    break;   		  
			
		case DIR_R:	
			bulletX+=8;
			bulletY +=10;	
		    break;   		  
		case DIR_U:	
			speed-=1;	
			if(speed>=0)
			  bulletY +=speed;	
			else{
			   if(GamingPlayer.pointX>bulletX)
				   bulletX-=speed;
			   if(GamingPlayer.pointX<bulletX)
				   bulletX+=speed;
			   else
				  bulletX+=0;
			   
			  bulletY-=speed;
			}
		    break;	
	    
	    case DIR_S:	
	    bulletX-=8;
		bulletY +=10;	
	    break;   	
	    case DIR_P:
	    	speed-=2;	
	    	  if(speed>=0)
			    {
			    	bulletX-=speed;
				    bulletY-=speed;
			    }
			    else{
			    	if(GamingPlayer.pointX>bulletX)
			    	{
			    	  bulletX+=speed/2;	
			    	bulletY-=speed;
			    	}
			    
			    if(GamingPlayer.pointX<bulletX)
			    {
			    	 bulletX-=speed/2;	
			    	 bulletY-=speed;
			    }
			    if(GamingPlayer.pointX>bulletX)
			    {
			    	 bulletY-=speed;
			    }
			}
				    break;
		case DIR_Q:
			speed-=2;		
		    if(speed>=0)
		    {
		    	bulletX+=speed;
			    bulletY-=speed;
		    }
		    else{
		    	if(GamingPlayer.pointX>bulletX)
		    	  bulletX-=speed/2;	
		    	bulletY-=speed;
		    
		    if(GamingPlayer.pointX<bulletX)
		    {
		    	 bulletX+=speed/2;	
		    	 bulletY-=speed;
		    }
		    if(GamingPlayer.pointX>bulletX)
		    {
		    	 bulletY-=speed;
		    }
		    }
			    break;
		}
			//�Ż��ӵ��������ӵ�����������
			if (bulletY > GamingPlaneTest.screenH || bulletY <= -40 || bulletX > GamingPlaneTest.screenW || bulletX <= -40) {
				isDead = true;
			}
			break;
		
		}
	}
}

