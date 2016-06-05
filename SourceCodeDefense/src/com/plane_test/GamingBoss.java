package com.plane_test;


import com.plane_ui.GameLoading;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GamingBoss {
	//Boss的血量
	public int hp = 5000;
	//Boss的图片资源
static  Bitmap Boss;
	//Boss坐标
	public int x, y;
	//Boss每帧的宽高
	public static int frameW, frameH;
	//Boss下标
	private int index;
	//boss出场
	public static boolean chuchang;
	//boss是否连弹
	public static boolean liandan=false;
	//连弹计数
	public static int dan=0;
	//Boss运动的速度
	//private int speed = 5;
	//Boss的运动轨迹
	//一定时间会向着屏幕下方运动，并且发射大范围子弹，（是否狂态）
	//正常状态下 ，子弹垂直朝下运动
	private boolean isCrazy;
	private boolean isCrazy1=false;
	private boolean isCrazy2=false;
	private boolean isCrazy3=false;
	private boolean isCrazy4=false;
	private boolean isCrazy5=false;
	private boolean isCrazy6=false;
	private boolean isCrazy7=false;
	private boolean isCrazy8=false;
  private boolean liandan1=false;
  private boolean liandan2=false;
  private boolean liandan3=false;
	//进入疯狂状态0的状态时间间隔
	private int crazyTime = 90;
	//进入疯狂状态1的状态时间间隔
	private int crazyTime1 = 481;//散弹
	//进入疯狂状态2的状态时间间隔
	private int crazyTime2 = 310;
	//进入疯狂状态2的状态时间间隔
   private int crazyTime3 = 211;//导弹
   private int crazyTime4 = 241;//激光
   private  int crazyTime5 = 184;
   private int crazyTime6 = 153;//竖
   private int crazyTime7 = 100;//竖
   
	//计数器
public static int count;
	private int type;

	//Boss的构造函数
	public GamingBoss(Bitmap Boss,int type) {
		this.Boss = Boss;
		frameW = Boss.getWidth() / 10;
		frameH = Boss.getHeight();
		this.type=type;
		chuchang=true;
		//Boss的X坐标居中
		x = GamingPlaneTest.screenW / 2 - frameW / 2;
		y = -frameH-10;	
		if(type==2||type==1){
		 crazyTime = 90;
			//进入疯狂状态1的状态时间间隔
		 crazyTime1 = 481;//散弹
			//进入疯狂状态2的状态时间间隔
		 crazyTime2 = 310;
			//进入疯狂状态2的状态时间间隔
		  crazyTime3 = 211;//导弹
		 crazyTime4 = 241;//激光
		  crazyTime5 = 284;
		 crazyTime6 = 153;//竖
		  crazyTime7 = 100;
		}
		if(type==3||type==4){
			 crazyTime = 59;
				//进入疯狂状态1的状态时间间隔
			 crazyTime1 = 281;//散弹
				//进入疯狂状态2的状态时间间隔
			 crazyTime2 = 110;
				//进入疯狂状态2的状态时间间隔
			  crazyTime3 = 178;//导弹
			 crazyTime4 = 201;//激光
			  crazyTime5 = 154;
			 crazyTime6 = 103;//竖
			  crazyTime7 = 98;
			}
		if(type==5){
			 crazyTime =  crazyTime/2;
				//进入疯狂状态1的状态时间间隔
			 crazyTime1 =  crazyTime1/2;//散弹
				//进入疯狂状态2的状态时间间隔
			 crazyTime2 = crazyTime2/2;
				//进入疯狂状态2的状态时间间隔
			  crazyTime3 =  crazyTime3/2;//导弹
			 crazyTime4 =  crazyTime4/2;//激光
			  crazyTime5 = crazyTime5/2;
			 crazyTime6 =  crazyTime6/2;//竖
			  crazyTime7 =  crazyTime7/2;
			}
	}

	//Boss的绘制
	public void draw(Canvas canvas, Paint paint) {
		canvas.save();
		canvas.clipRect(x, y, x + frameW, y + frameH);
		canvas.drawBitmap(Boss, x - index * frameW, y, paint);
		canvas.restore();
	}

	//Boss的逻辑
	public void logic() {
		//不断循环播放帧形成动画
		index++;   //当前帧
		if (index >= 10) {
			index = 0;
		}
		
		if(chuchang&&y<=40){
		      y+=2;
		      if(GamingPlaneTest.isSound)
		      {
		    	  GameLoading.mediaplayer.pause();
		    	  GameLoading.mediaplayer1.start();
		      }
		    }
		else{
		      chuchang=false;		      
		   }
		//没有疯狂的状态		
		if (isCrazy == false&&chuchang==false) {
			
			count++;
			if (count % crazyTime == 0||liandan1) {
	
				liandan1=true;
				dan++;
				if(dan%2==0){
				  isCrazy = true;
				  isCrazy1 = true; 
				}			
				if(dan>=6)
				{
					dan=0;
					liandan1=false;
				}				
			}		
			if (count % crazyTime2 == 0) {
				isCrazy2 = true;		
				isCrazy = true;
			
			}			
			
			   if (count % crazyTime1 == 0) {
					isCrazy3 = true;					
					isCrazy = true;
					
			   }
			   if (count % crazyTime3 == 0) {
				isCrazy4 = true;
				
				isCrazy = true;
			
			}
			   if (count % crazyTime4 == 0) {
				   isCrazy = true;
					isCrazy5 = true;
				
				}
			   if (count % crazyTime5 == 0||liandan2) {
					isCrazy6 = true;
					liandan2=true;
					isCrazy = true;
					dan++;
					
					if(dan>=5){
						liandan2=false;
						dan=0;
					}
			   }
			 if (count % crazyTime6 == 0) {
							isCrazy7 = true;
							isCrazy = true;
						
						
						}	
				
				
			   if (count % crazyTime7 == 0||liandan3){
					isCrazy8 = true;
					liandan3=true;
					isCrazy = true;
					dan++;
					
					if(dan>=3){
						liandan3=false;
						dan=0;
					}  
			   }
			
		
			
			//疯狂的状态
		} else {	
			
			if(isCrazy1){
				//创建大量子弹	散弹		
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_A));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x+frameW-4, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_B));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_C));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5,x+frameW-4, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_D));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_E));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5,x+frameW-4, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_F));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_G));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x+frameW-4 ,y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_H));
					GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, GamingPlaneTest.screenW/2 ,y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_D));
					isCrazy = false;
					isCrazy1 = false;
			}
			if(isCrazy6){  //竖直子弹
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb7, x+frameW-16, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Z));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb6, x+frameW/2-16, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Z));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb9, x-16, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Z));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb6, x+frameW/2+10, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Z));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb9,x+frameW/-16+10, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Z));
				isCrazy = false;
				isCrazy6 = false;
			}				
			if(isCrazy2){   //侧翼子弹
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x-20, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_A));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x-10, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_B));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_C));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_D));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x+20, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_E));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x+10, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_F));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x+20, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_G));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan11, x+30, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_H));
				isCrazy = false;
				isCrazy2 = false;
				
				}				
				if(isCrazy3){    //导弹
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.bdd,x, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_I));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.bdd,x+frameW-32, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_J));
				
				//MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.zidan12,x+frameW-32, y+10, Bullet.BULLET_BOSS, Bullet.DIR_V));
				isCrazy = false;
				isCrazy3 = false;
			
				}
						
				if(isCrazy4){   //好看的那个
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb2, x+(frameW/2)-16-20, y, GamingBullet.BULLET_BOSS, GamingBullet.DIR_P));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidanb2, x+(frameW/2)+20, y, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Q));
				isCrazy = false;
				isCrazy4 = false;
			
				}
				if(isCrazy5){//双弹
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_A));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x+frameW-4, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_B));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_C));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5,x+frameW-4, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_D));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_E));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5,x+frameW-4, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_F));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x, y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_G));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan5, x+frameW-4 ,y+8, GamingBullet.BULLET_BOSS, GamingBullet.DIR1_H));	
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x-20, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_A));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x-10, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_B));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_C));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_D));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x+20, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_E));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x+10, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_F));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x+20, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_G));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zhidan3, x+30, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_H));
				isCrazy = false;
				isCrazy5 = false;
			
				}				
				if(isCrazy7){   //旋转的子弹
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan12, x+frameW/2, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_R));
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan12,x+frameW/2-16, y+10, GamingBullet.BULLET_BOSS, GamingBullet.DIR_S));
				isCrazy = false;
				isCrazy7 = false;
				}
							
				if(isCrazy8){   //中心单炮
				GamingPlaneTest.vcBulletBoss.add(new GamingBullet(GamingPlaneTest.zidan12,  GamingPlaneTest.screenW / 2- GamingPlaneTest.zidan12.getWidth()/2, y, GamingBullet.BULLET_BOSS, GamingBullet.DIR_Q));
				isCrazy = false;
				isCrazy8 = false;
				}
			}
		}
	

	//判断碰撞(Boss被主角子弹击中)
	public boolean isCollsionWith(GamingBullet bullet) {
		int x2 = bullet.bulletX1;
		int y2 = bullet.bulletY1;
		int w2 = bullet.Bullet.getWidth();
		int h2 = bullet.Bullet.getHeight();
		if (x >= x2 && x >= x2 + w2) {
			return false;
		} else if (x <= x2 && x + frameW <= x2) {
			return false;
		} else if (y >= y2 && y >= y2 + h2) {
			return false;
		} else if (y <= y2 && y + frameH <= y2) {
			return false;
		}
		return true;
	}
	//设置Boss血量
	public void setHp(int hp) {
		this.hp = hp;
	}
}
