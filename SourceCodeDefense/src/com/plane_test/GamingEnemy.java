package com.plane_test;



import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GamingEnemy {
	//�л������ʶ
	public int type;
	
	public static final int TYPE_F1 = 1;
	
	public static final int TYPE_F2 = 2;
	
	public static final int TYPE_F3 = 3;
	//�л���,վߣ ɢ��
	public static final int TYPE_A=4;
	public static final int TYPE_B=5;
	public static final int TYPE_C=6;
	public static final int TYPE_D=7;
	//�л���,վߣ ɢ��
	//	public static final int TYPE_B=5;
	//�л�ͼƬ��Դ
	public Bitmap bmpEnemy;
	//�л�����
	public int x, y;
	//�л�ÿ֡�Ŀ��
	public int frameW, frameH;
	//�л���ǰ֡�±�
	private int frameIndex;
	//�л����ƶ��ٶ�
	private int speed;;
	public boolean isDead;
	public static int enHp;
	private int test=0;

	//�л��Ĺ��캯��
	public GamingEnemy(Bitmap bmpEnemy, int enemyType, int x, int y){
		this.bmpEnemy = bmpEnemy;
		frameW = bmpEnemy.getWidth() / 10;
		frameH = bmpEnemy.getHeight();
		this.type = enemyType;
		this.x = x;
		this.y = y;
		//��ͬ����ĵл�Ѫ����ͬ
		switch (type) {
		
		case TYPE_F1:
			speed = 25;
			enHp=(300*GamingPlaneTest.lv);
			break;
		
		case TYPE_F2:
			speed = 4;
			enHp=(400*GamingPlaneTest.lv);
			break;
		case TYPE_F3:
			speed = 3;
			enHp=(400*GamingPlaneTest.lv);
			break;
		case TYPE_A:
			speed=15;
			enHp=(500*GamingPlaneTest.lv);
			break;
		case TYPE_B:
			speed=20;
			enHp=(200*GamingPlaneTest.lv);
			break;
		case TYPE_C:
			speed+=10;
			enHp=(100*GamingPlaneTest.lv);
		case TYPE_D:
			speed=10;
			enHp=(100*GamingPlaneTest.lv);
		}
	}

	//�л���ͼ����
	public void draw(Canvas canvas, Paint paint) {
		canvas.save();
		//�л����꣬�л���֡�Ŀ��
		canvas.clipRect(x, y, x + frameW, y + frameH);
		//�л����� -��ǰ֡����*ÿ֡�Ŀ��
		canvas.drawBitmap(bmpEnemy, x - frameIndex * frameW, y, paint);
		canvas.restore();
	}

	
	public void logic() {
		//����ѭ������֡�γɶ���
		frameIndex++;
		if (frameIndex >= 10) {
			frameIndex = 0;
		}
		//��ͬ����ĵл�ӵ�в�ͬ��AI�߼�
		switch (type) {
		case TYPE_F1:
			if (isDead == false) {
				
				speed -= 1;
				y += speed;
				if (y <= -200) {
					isDead = true;
				}
			}
			break;
		case TYPE_F2:
			if (isDead == false) {
			
				x += speed / 2;
				y += speed;
				if (x > GamingPlaneTest.screenW) {
					isDead = true;
				}
			}
			break;
		case TYPE_F3:
			if (isDead == false) {
			
				x -= speed / 2;
				y += speed;
				if (x < -50) {
					isDead = true;
				}
			}
			break;
			
		case TYPE_A:			
				if (isDead == false) {	
					if(frameIndex==5&&test<=5){   //����ӵ�
						GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.zhidan1, x-40, y+10, GamingBullet.BULLET_A, GamingBullet.A_1));
						GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.zhidan1, x-20, y+10, GamingBullet.BULLET_A, GamingBullet.A_2));
						GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.zhidan1, x   , y+10, GamingBullet.BULLET_A, GamingBullet.A_3));
						GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.zhidan1, x+20, y+10, GamingBullet.BULLET_A, GamingBullet.A_4));
						GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.zhidan1, x+40, y+10, GamingBullet.BULLET_A, GamingBullet.A_5));
						test++;
					}
					if(test>=300){
						test=0;
					}
					if(speed>0){
					speed -= 1;		
					}					
					y += speed;					
					if (x < -50) {
						isDead = true;
					}
				}
				break;
		case TYPE_B:{
			if (isDead == false) {
				//���ӵ�			
				y += speed;
				if (y > GamingPlaneTest.screenH) {
					isDead = true;
				}
			}
		break;
		}
		case TYPE_C:
			if(speed>0)
		     	speed-=1;
			x+=speed;
			if(speed==0)
			{   		
				GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.zidan12, x+frameW/2+16, y+10, GamingBullet.BULLET_C));				
				speed+=10;
			}	
			if(x>=GamingPlaneTest.screenW){
				isDead = true;
			}		
			break;		
	case TYPE_D:		
		speed-=1;
		y+=speed;     
       if(speed==0)
       {
    	   isDead=true;
    	  GamingPlaneTest.vcBoom.add(new GamingBoom(GamingPlaneTest.Boom, x,y+10 , 5));
    	  GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.baozazidan, x, y+10, GamingBullet.BULLET_D, GamingBullet.D_1));
			GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.baozazidan, x, y+10, GamingBullet.BULLET_D, GamingBullet.D_2));
			GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.baozazidan, x   , y+10, GamingBullet.BULLET_D, GamingBullet.D_3));
			GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.baozazidan, x, y+10, GamingBullet.BULLET_D, GamingBullet.D_4));
			GamingPlaneTest.vcBullet.add(new GamingBullet(GamingPlaneTest.baozazidan, x, y+10, GamingBullet.BULLET_D, GamingBullet.D_5));
    	  
       }
		break;		
		}
		
	}
	//�ж���ײ(�л��������ӵ���ײ)
	public boolean isCollsionWith(GamingBullet bullet) {
		int x2 = bullet.bulletX1;   //�ӵ�x,y����
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
	    enHp=enHp-1;
		if(enHp<=0)
		{		  
		  isDead = true;		 
		}			
		return true;

	}
	}

