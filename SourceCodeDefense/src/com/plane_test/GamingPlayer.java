package com.plane_test;
import com.plane_activity.MainActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class GamingPlayer {
	//���ǵ�Ѫ����Ѫ��λͼ
	//Ĭ��3Ѫ
	//Ĭ��2��
	private int count;
	public static int harm;
	public static int playerHp ;
	private Bitmap PlayerHp;
	public static float scaleWidth;//����
	public static float scaleHeight;//����
	//���ǵ������Լ�λͼ
	public int x, y;
	public static int pointX;
	public static int pointY;
	//�����ƶ�λ������
	private int px,py,ppx,ppy,i=0;
   private int zx,zy;
    private int frame1;
    static Bitmap player;
	//��ײ�����޵�ʱ��
	//��ʱ
	private int nounbeatableCount = 0;
	//��Ϊ�޵�ʱ��
	private int nounbeatable = 40;
	//�Ƿ���ײ�ı�ʶλ
	public static boolean unbeatable=false;
	//�ƶ�
	private int speed=15;
	public static int type;
	static int pframeW;
	private int pframeH;
	private int frameIndex;
	public static boolean isleft,isright,isup,isdown;
	//���ǵĹ��캯��
	public GamingPlayer(Bitmap Player, Bitmap PlayerHp,int type) {
		this.player = Player;
		this.PlayerHp = PlayerHp;
		this.type=type;
		//���ݲ�ͬ�ķɻ�type�в�ͬ������
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
	//���ǵĻ�ͼ����
	public void draw(Canvas canvas, Paint paint) {
		//��������
		//�������޵�ʱ��ʱ����������˸
		  Matrix matrix = new Matrix();
		     matrix.postScale(scaleWidth, scaleHeight); 
		if (unbeatable) {
			//ÿ2����Ϸѭ��������һ������
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
			//��������Ѫ��
			for (int i = 0; i < playerHp; i++) {
				canvas.drawBitmap(PlayerHp, i * PlayerHp.getWidth(), GamingPlaneTest.screenH - PlayerHp.getHeight(), paint);			
		}
	}
 

   //�����ƶ�	
		//���ǵ��߼�
		public void plogic() {
			//���������ƶ�
			
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
	//��������
	public boolean onTouchEvent(MotionEvent event){
		//��ȡ�û���ǰ����λ��
		 px = (int) event.getX();
		 py = (int) event.getY();
		
		 if (event.getAction() == MotionEvent.ACTION_DOWN ){
				//����λ�û�ȡ 
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
			//�ɻ��ƶ��߼�			
			if(pointX<=GamingPlaneTest.screenW&&pointX>=0&&pointY>=0&&pointY<= GamingPlaneTest.screenH){
				if(pointX==0&&px-ppx<0)
	      		{
					 x=0;//����x
		             ppx=px;//���ø���
	      		}
				if(pointX+pframeW> GamingPlaneTest.screenW&&px-ppx>0)
				{
		            	x= GamingPlaneTest.screenW-pframeW;//��Ļ�Ŀ�
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
			//̧��
			 if (event.getAction() == MotionEvent.ACTION_UP){		
				 //���÷ɻ�дx,yλ�ã�
				 MainActivity.zlkg=true;//�����ƶ��߼����ܵ���
			    x=pointX;
			    y=pointY;	    
			    i=0;
			    
			}
	
		return true;
		
	}
	
	//���ǵ��߼�
	public void logic() {
		count++;
		frame1++;
		//��ֹԽ��
		if (pointX +pframeW >= GamingPlaneTest.screenW) {
			pointX = GamingPlaneTest.screenW - pframeW;
		} else if (pointX <= 0) {
			pointX = 0;
		}
		//��ֹԽ��
		if (pointY + player.getHeight() >= GamingPlaneTest.screenH) {
			pointY = GamingPlaneTest.screenH - player.getHeight();
		} else if (pointY <= 0) {
			pointY = 0;
		}
		if(frame1>=5){
			frame1=0;
		}
		//ѭ���̶�
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
				
		//��ǰ֡
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
	
		//�����޵�״̬
		if (unbeatable) {
			//��ʱ����ʼ��ʱ
			nounbeatableCount++;
			if (nounbeatableCount >= nounbeatable) {
				//�޵�ʱ����󣬽Ӵ��޵�״̬����ʼ��������
				unbeatable = false;
				nounbeatableCount = 0;
			}
		}
	}

	//��������Ѫ��
	public void setPlayerHp(int hp) {
		//��ͬ����Ѫ����һ��
		this.playerHp =hp;
	}

	//��ȡ����Ѫ��
	public int getPlayerHp() {		
		return playerHp;
	}
	//�ж���ײ(������л�)
	public boolean isCollsionWith(GamingEnemy en) {
		//�Ƿ����޵�ʱ��		
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
	//������л��ӵ�
	public boolean isCollsionWith(GamingBullet bullet) {
		//�Ƿ����޵�ʱ��
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
