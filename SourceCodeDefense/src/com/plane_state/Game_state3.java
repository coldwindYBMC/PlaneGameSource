package com.plane_state;
import com.plane_activity.MainActivity;
import com.plane_test.GamingPlaneTest;
import com.plane_test.GamingPlayer;
import com.plane_ui.GameMenu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
public class Game_state3 {
	public static int scH,scW;
   
	Bitmap juqing_state3_dialog1;
	Bitmap juqing_state3_dialog2; 
	Bitmap juqing_state3_dialog3;
	Bitmap juqing_state3_dialog4;
	int dialog_width;//对话的宽度
	int dialog_height;//对话的高度
	int dialog_W;
	int dialog_Hup;//上面的位置。。对话位置
	int dialog_Hdown;//下面的位置
	public static boolean is_dialog1;
    public static boolean is_dialog2;
	public static boolean is_dialog3;
	public static boolean is_dialog4;
	public static boolean state3;
	public Game_state3(Bitmap juqing_state3_dialog1,
			Bitmap juqing_state3_dialog2, Bitmap juqing_state3_dialog3,
			Bitmap juqing_state3_dialog4) 
	{
	       this.juqing_state3_dialog1=juqing_state3_dialog1;
	       this.juqing_state3_dialog2=juqing_state3_dialog2;
	       this.juqing_state3_dialog3=juqing_state3_dialog3;
	       this.juqing_state3_dialog4=juqing_state3_dialog4;
	       state3=false;
	       is_dialog1=false;
	       is_dialog2=false;
	       is_dialog3=false;
	       is_dialog4=false;
	       scW=GamingPlaneTest.screenW;
	       scH=GamingPlaneTest.screenH;
	}
	public void draw1(Canvas canvas, Paint paint) {
	     // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);  
	     dialog_width=juqing_state3_dialog1.getWidth();
	     dialog_height=juqing_state3_dialog1.getHeight();
	     //获得新图片
	     Bitmap juqing_state3_dialog1_new  = Bitmap.createBitmap(juqing_state3_dialog1,0,0, dialog_width, dialog_height, matrix, true);
	     //对话框的位置
	     dialog_W=(scW-dialog_width)/2;
	     dialog_Hdown=(scH/3)*2;
	     dialog_Hup=scH/3;
	     canvas.drawBitmap(juqing_state3_dialog1_new,dialog_W,dialog_Hdown, paint);
	}
	public void draw2(Canvas canvas, Paint paint) {
		 // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);  
		//获得新图片
	     Bitmap juqing_state3_dialog2_new  = Bitmap.createBitmap(juqing_state3_dialog2,0,0, dialog_width, dialog_height, matrix, true);
	     canvas.drawBitmap(juqing_state3_dialog2_new,dialog_W,dialog_Hup, paint);
	}
	public void draw3(Canvas canvas, Paint paint) {
		 // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);  
		//获得新图片
	     Bitmap juqing_state3_dialog3_new  = Bitmap.createBitmap(juqing_state3_dialog3,0,0, dialog_width, dialog_height, matrix, true);
	     canvas.drawBitmap(juqing_state3_dialog3_new,dialog_W,dialog_Hdown, paint);
	}
	public void draw4(Canvas canvas, Paint paint) {
		 // 取得想要缩放的matrix参数
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight);  
		//获得新图片
	     Bitmap juqing_state3_dialog4_new  = Bitmap.createBitmap(juqing_state3_dialog4,0,0, dialog_width, dialog_height, matrix, true);
	     canvas.drawBitmap(juqing_state3_dialog4_new,dialog_W,dialog_Hup, paint);
	}
	
	public void onTouchEvent(MotionEvent event) {
		//获取用户当前触屏位置
		int pointX = (int) event.getX();
		int pointY = (int) event.getY();
		//当用户是按下动作或移动动作
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
			if (pointX > dialog_W && pointX < dialog_W + dialog_width)
			{
				if (pointY > dialog_Hup && pointY < dialog_Hup + dialog_height ) 
				{	
				    
					 if(is_dialog2)
				     {
						 GamingPlaneTest.gameState =  GamingPlaneTest.GAME_STATE_DIALOG3;
				    	 is_dialog2=false;
				     }
					 
					 if(is_dialog4)
				     {
						 //游戏的入口
						 state3=false;
				    	 is_dialog4=false;
				    	 GameMenu.x=MainActivity.xValue;
							GameMenu.y=MainActivity.yValue;
							GameMenu.z=MainActivity.zValue;
							//获取战机type;					
							GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player1, GamingPlaneTest.PlayerHp, 2);
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;		
							GameMenu. game=3;
							GamingPlaneTest.bossArrayIndex=2;
				     }
					
				}
			}
			if (pointX > dialog_W && pointX < dialog_W+dialog_width)
			{
				if (pointY > dialog_Hdown && pointY < dialog_Hdown+dialog_height ) 
				{	
					 if(is_dialog1)
				     {
				    	 GamingPlaneTest.gameState =  GamingPlaneTest.GAME_STATE_DIALOG2;
				    	 is_dialog1=false;
				     }
					 if(is_dialog3)
				     {
						 GamingPlaneTest.gameState =  GamingPlaneTest.GAME_STATE_DIALOG4;
				    	 is_dialog3=false;
				     }
				}
				
			}
	   }
   }
}
