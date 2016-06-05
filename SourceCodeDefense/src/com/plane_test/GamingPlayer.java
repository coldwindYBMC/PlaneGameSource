package com.plane_test;
import com.plane_activity.MainActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class GamingPlayer {
	//主角的血量与血量位图
	//默认3血
	//默认2伤
	private int count;
	public static int harm;
	public static int playerHp ;
	private Bitmap PlayerHp;
	public static float scaleWidth;//比例
	public static float scaleHeight;//比例
	//主角的坐标以及位图
	public int x, y;
	public static int pointX;
	public static int pointY;
	//触屏移动位置数据
	private int px,py,ppx,ppy,i=0;
   private int zx,zy;
    private int frame1;
    static Bitmap player;
	//碰撞后处于无敌时间
	//计时
	private int nounbeatableCount = 0;
	//因为无敌时间
	private int nounbeatable = 40;
	//是否碰撞的标识位
	public static boolean unbeatable=false;
	//移动
	private int speed=15;
	public static int type;
	static int pframeW;
	private int pframeH;
	private int frameIndex;
	public static boolean isleft,isright,isup,isdown;
	//主角的构造函数
	public GamingPlayer(Bitmap Player, Bitmap PlayerHp,int type) {
		this.player = Player;
		this.PlayerHp = PlayerHp;
		this.type=type;
		//根据不同的飞机type有不同的属性
		if(type==1){
			harm=230;
			 playerHp=3;
		}
		if(type==2){
			harm=280;
			 playerHp=3;
		}
		if(type==3){
		 harm=260;
		 playerHp=4;
		}
		if(type==4){
		 harm=200;
		 playerHp=3;
		}
		if(type==5){
		 harm=300;
		 playerHp=5;
		}
		pframeW = Player.getWidth()/3;
		pframeH = Player.getHeight();		
		x = GamingPlaneTest.screenW / 2 - Player.getWidth() / 2/3;
		y = GamingPlaneTest.screenH - Player.getHeight();
		pointX = x;
		pointY = y;
	}
	//主角的绘图函数
	public void draw(Canvas canvas, Paint paint) {
		//绘制主角
		//当处于无敌时间时，让主角闪烁
		  Matrix matrix = new Matrix();
		     matrix.postScale(scaleWidth, scaleHeight); 
		if (unbeatable) {
			//每2次游戏循环，绘制一次主角
			if (nounbeatableCount % 2 == 0) {
				canvas.save();
				canvas.clipRect(pointX,pointY, pointX + pframeW, pointY+ pframeH);
				canvas.drawBitmap(player,pointX- frameIndex * pframeW, pointY, paint);
				canvas.restore();				
			}
		} else {
			canvas.save();
			canvas.clipRect(pointX, pointY, pointX + pframeW, pointY + pframeH);
			canvas.drawBitmap(player,pointX- frameIndex * pframeW, pointY, paint);
			canvas.restore();			
		}
			//绘制主角血量
			for (int i = 0; i < playerHp; i++) {
				canvas.drawBitmap(PlayerHp, i * PlayerHp.getWidth(), GamingPlaneTest.screenH - PlayerHp.getHeight(), paint);			
		}
	}
 

   //重力移动	
		//主角的逻辑
		public void plogic() {
			//处理主角移动
			
			if (isleft) {
				pointX-=( speed+MainActivity.spx);
				zx=pointX;
			}
			if (isright) {
				pointX+= (speed+MainActivity.spx);
				zx=pointX;
			}
			if (isup) {
				pointY -= (speed+MainActivity.spx);
				zy=pointY;
			}
			if (isdown) {
				pointY+= (speed+MainActivity.spx);
				zy=pointY;
			}
		}
	//触摸监听
	public boolean onTouchEvent(MotionEvent event){
		//获取用户当前触屏位置
		 px = (int) event.getX();
		 py = (int) event.getY();
		
		 if (event.getAction() == MotionEvent.ACTION_DOWN ){
				//按下位置获取 
				 if(i==0){
				   ppx=px;
				   ppy=py;
				   if(MainActivity.zlkg&&MainActivity.zlsz)
				   {
					   x=zx;
					   y=zy;
					   MainActivity.zlkg=false;
				   }
				   i++;		   
				 }
		 }
		if (event.getAction() == MotionEvent.ACTION_MOVE ){
			//飞机移动逻辑			
			if(pointX<=GamingPlaneTest.screenW&&pointX>=0&&pointY>=0&&pointY<= GamingPlaneTest.screenH){
				if(pointX==0&&px-ppx<0)
	      		{
					 x=0;//重置x
		             ppx=px;//重置根点
	      		}
				if(pointX+pframeW> GamingPlaneTest.screenW&&px-ppx>0)
				{
		            	x= GamingPlaneTest.screenW-pframeW;//屏幕的宽
		            	ppx=px;
				}
				if(pointY==0&&py-ppy<0){
		      		 y=0;
		      		 ppy=py;
				}
				if(pointY+GamingPlayer.player.getHeight()==GamingPlaneTest.screenH&&py-ppy>0)
				{
	      			y= GamingPlaneTest.screenH-GamingPlayer.player.getHeight();
	      			ppy=py;
				}
				pointX=x+px-ppx;
				pointY=y+py-ppy;	
			
				
		}
		}
			//抬起
			 if (event.getAction() == MotionEvent.ACTION_UP){		
				 //重置飞机写x,y位置；
				 MainActivity.zlkg=true;//两个移动逻辑不能叠加
			    x=pointX;
			    y=pointY;	    
			    i=0;
			    
			}
	
		return true;
		
	}
	
	//主角的逻辑
	public void logic() {
		count++;
		frame1++;
		//防止越界
		if (pointX +pframeW >= GamingPlaneTest.screenW) {
			pointX = GamingPlaneTest.screenW - pframeW;
		} else if (pointX <= 0) {
			pointX = 0;
		}
		//防止越界
		if (pointY + player.getHeight() >= GamingPlaneTest.screenH) {
			pointY = GamingPlaneTest.screenH - player.getHeight();
		} else if (pointY <= 0) {
			pointY = 0;
		}
		if(frame1>=5){
			frame1=0;
		}
		//循环程度
		if(type==1){
		   frameIndex++;
		}
		if(type==2&&count%2==0){
			frameIndex++;
		}
		if(type==3&&count%3==0){
			frameIndex++;
		}
		if(type==4&&count%2==0){
			frameIndex++;
		}
		if(type==5&&count%2==0){
			frameIndex++;
		}
				
		//当前帧
		if (type==1&&frameIndex >= 3) {				  
			frameIndex = 0;
		}
		if(type==2&&frameIndex >= 3){			
			frameIndex = 0;
		}		
		if (type==3&&frameIndex >= 3) {				  
			frameIndex = 0;
		}
		if(type==4&&frameIndex >= 3){			
			frameIndex = 0;
		}		
		if (type==5&&frameIndex >= 3) {				  
			frameIndex = 0;
		}

		if(MainActivity.zlkg=true){
		     plogic();
		}
	
		//处理无敌状态
		if (unbeatable) {
			//计时器开始计时
			nounbeatableCount++;
			if (nounbeatableCount >= nounbeatable) {
				//无敌时间过后，接触无敌状态及初始化计数器
				unbeatable = false;
				nounbeatableCount = 0;
			}
		}
	}

	//设置主角血量
	public void setPlayerHp(int hp) {
		//不同机型血量不一样
		this.playerHp =hp;
	}

	//获取主角血量
	public int getPlayerHp() {		
		return playerHp;
	}
	//判断碰撞(主角与敌机)
	public boolean isCollsionWith(GamingEnemy en) {
		//是否处于无敌时间		
			int x2 = en.x;
			int y2 = en.y;
			int w2 = en.frameW;
			int h2 = en.frameH;
			if (pointX >= x2 && pointX >= x2 + w2) {
				return false;
			} else if (pointX <= x2 && pointX + pframeW <= x2) {
				return false;
			} else if (pointY >= y2 && pointY >= y2 + h2) {
				return false;
			} else if (pointY <= y2 && pointY + player.getHeight() <= y2) {
				return false;
			}
			
			unbeatable = true;
			return true;
		
	}
	//主角与敌机子弹
	public boolean isCollsionWith(GamingBullet bullet) {
		//是否处于无敌时间
		if (unbeatable == false) {
			int x2 = bullet.bulletX;
			int y2 = bullet.bulletY;
			int w2 = bullet.Bullet.getWidth()/3;
			int h2 = bullet.Bullet.getHeight()/3;
			if (pointX +pframeW/3>= x2 && pointX+pframeW/3 >= x2 + w2) {
				return false;
			} else if (pointX +pframeW/3<= x2 && pointX + (pframeW/3*2) <= x2) {
				return false;
			} else if (pointY+( player.getHeight()/3)>= y2 && pointY+(player.getHeight()/3) >= y2 + h2) {
				return false;
			} else if (pointY+( player.getHeight()/3) <= y2 && pointY + (player.getHeight()/3*2) <= y2) {
				return false;
			}
	
	
		}
		return true;
	}
}
