package com.plane_test;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
public class GamingBullet extends Thread{
     //子弹图片资源
	public Bitmap Bullet;
	//public Bitmap Bullet1;
	//子弹的坐标
	public  int bulletX, bulletY;
	//主机子弹坐标
	public   int bulletX1;
	public  int bulletY1;
	//主角飞机的坐标
	public int pointx,pointy;

	//子弹每帧的宽高
	public int eframeW, eframeH;
	//子弹当前帧下标
	private int frameIndex;
	//子弹的速度
	public int speed;
	private int c;
	//子弹的种类以及常量
	public int bulletType;
	//主角的
	public static final int BULLET_PLAYER = -1;
	
	public static final int BULLET_F2 = 1;

	public static final int BULLET_F1 = 2;
	public static final int BULLET_liaoji = 7;
	
	public static final int BULLET_F3 = 3;
	//Boss的
	public static final int BULLET_BOSS = 10;
	//敌机4
	public static final int BULLET_A = 4;
	public static final int BULLET_B = 5;
	public static final int BULLET_C = 6;
	public static final int BULLET_D = 7;
	//子弹是否超屏， 优化处理
	public boolean isDead;   
   
    //Boss疯狂状态下子弹相关成员变量
	private int dir;
	public static int bulletlv;  
	//crazy 子弹
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
	//BOSS中弹
	public static final int DIR_M = 50;
	//enemy4 方向常量
	public static final int A_1 = 18;
	public static final int A_2 = 19;
	public static final int A_3 = 20;
	public static final int A_4 = 21;
	public static final int A_5 = 22;
	//方向常量
		public static final int D_1 = 18;
		public static final int D_2 = 19;
		public static final int D_3 = 20;
		public static final int D_4 = 21;
		public static final int D_5 = 22;
	
	//子弹当前方向
	public GamingBullet(Bitmap Bullet, int bulletX, int bulletY,int pointx,int pointy ,int bulletType,int bulletlv) {
		this.Bullet = Bullet;
		this.bulletX = bulletX;  //子弹位置，一般为飞机位置，如敌机位置
		this.bulletY = bulletY;
		this.bulletX1 = bulletX;  //子弹位置，一般为飞机位置，如敌机位置
		this.bulletY1 = bulletY;
		this.bulletType = bulletType;
		this.pointx=pointx; //主机位置
		this.pointy=pointy;
		this.bulletlv=bulletlv;		
		//不同的子弹类型速度不一
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
	 * 专用于处理小飞机子弹
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
	 * 专用于处理Boss疯狂状态下创建的子弹
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
	
	

	//子弹的绘制
    //若与敌机公用同一绘制方法，会使主机升级时，敌机子弹数量加强
	//加强方法，根据不同的敌机种类，调用绘制方法。暴走时，可以在敌机死亡时强行发射子弹（调用draw方法）
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
	//子弹的逻辑,根据不同的类型有不同的逻辑
	public void logic() {
		//不断循环播放帧形成动画
	frameIndex++;   //当前帧
	if (frameIndex >= 3) {
			frameIndex = 0;
	}
		//不同的子弹类型逻辑不一		
				switch (bulletType) {	
				
				
		case BULLET_PLAYER:						
				bulletY1-=speed;						
				if (bulletY1< 0) {   //子弹的Y坐标
					isDead = true;    //超出屏幕
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
		  //跟踪导弹
	/*		int ydx=	bulletX-pointx;//子弹-主机坐标  大于0 为子弹在飞机右侧，小于0为子弹在飞机左侧
			int ydy=    bulletY-pointy;
	
		if(ydx==0)    //子弹与飞机垂直
		{		
			if(bulletY<pointy)   //子弹在飞机上方
			    bulletY+=speed;	
			else
				isDead=true;
			if(bulletY>=pointy)                      //下方
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
		
		if(ydx<0 &&bulletY<pointy)//子弹在飞机的左侧,子弹在飞机上方
		{
			
			bulletX+=(speed-2);
			bulletY+=speed;
			if(ydx>=0||bulletY>=pointy)   //满足任意条件，子弹消亡
			{
				
				isDead = true; 
				
			}
		
		}
		if(ydx>0&&bulletY<pointy)//子弹在飞机的右侧,子弹在飞机上方
		{
			bulletX-=(speed-2);
			bulletY+=speed;
		    if(ydx<=0||bulletY>=pointy)
		    {	    	
		    	isDead = true;		    	
		    }
		
		}
		if(ydx<0&&bulletY>pointy)//子弹在飞机的左侧,子弹在飞机下方
		{
			bulletX+=(speed-2);
			bulletY-=speed;
			if(ydx>=0||bulletY<=pointy)
		    {
		    	isDead = true;	   
		    }		
		}
		if(ydx>0&&bulletY>pointy)//子弹在飞机的右侧,子弹在飞机下方
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
		
		//Boss子弹逻辑
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
			//优化子弹容器，子弹出屏变消亡
			if (bulletY > GamingPlaneTest.screenH || bulletY <= -40 || bulletX > GamingPlaneTest.screenW || bulletX <= -40) {
				isDead = true;
			}
			break;
		
		}
	}
}

