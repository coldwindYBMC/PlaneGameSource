package com.plane_ui;
import com.plane_database.DataBase_Player;
import com.plane_test.GamingPlaneTest;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class Game_SelectPlane {
	public static int frameIndex;
	Bitmap plane_anyeleiting;
	Bitmap plane_anyeyingxue;
	Bitmap plane_huangjinzhanjia;
	Bitmap plane_lengyanhanfeng;
	Bitmap plane_moshangyanyun;
	Bitmap shezhi_fanhui;
	Bitmap shezhi_fanhui_press;
	Bitmap button_houtui;
	Bitmap button_houtui_press;
	Bitmap button_qianjin;
	Bitmap button_qianjin_press;
	Context context;
	public static int scH;
	public static int scW;
	//public static float scaleWidth;//����
	//public static float scaleHeight;//����
	private int plane_W,plane_H;
	//���ý����еķ��ذ�ť
	int shezhi_fanhui_new_butH;
	int shezhi_fanhui_new_butW;
	int shezhi_fanhui_weizhi_W;
	int shezhi_fanhui_weizhi_H;
	//ս��1
	int plane_huangjinzhanjia_new_butH;
	int plane_huangjinzhanjia_new_butW;
	int plane_huangjinzhanjia_weizhi_W;
	int plane_huangjinzhanjia_weizhi_H;
	//ս��2
	int plane_anyeleiting_new_butH;
	int plane_anyeleiting_new_butW;
	int plane_anyeleiting_weizhi_W;
	int plane_anyeleiting_weizhi_H;
		//ս��3
	int plane_lengyanhanfeng_new_butH;
	int plane_lengyanhanfeng_new_butW;
	int plane_lengyanhanfeng_weizhi_W;
	int plane_lengyanhanfeng_weizhi_H;
		//ս��4
	int plane_anyeyingxue_new_butH;
	int plane_anyeyingxue_new_butW;
	int plane_anyeyingxue_weizhi_W;
	int plane_anyeyingxue_weizhi_H;
		//ս��5
	int plane_moshangyanyun_new_butH;
	int plane_moshangyanyun_new_butW;
	int plane_moshangyanyun_weizhi_W;
	int plane_moshangyanyun_weizhi_H;
	//����
	int houtui_new_butH;
	int houtui_new_butW;
	int houtui_weizhi_W;
	int houtui_weizhi_H;
	//ǰ��
	int qianjin_new_butH;
	int qianjin_new_butW;
	int qianjin_weizhi_W;
	int qianjin_weizhi_H;
	//����ȥ��״̬
	private boolean isPress_shezhi_fanhui;
	private boolean isPress_houtui;
	private boolean isPress_qianjin;
	//�ɻ�״̬
	public boolean is_plane1;//�ɻ�1
	public  boolean is_plane2;//�ɻ�2
	public  boolean is_plane3;//�ɻ�3
	public  boolean is_plane4;//�ɻ�4
	public boolean is_plane5;//�ɻ�5
	public DataBase_Player database_player;
	public static Boolean plane1;
	public static Boolean plane2;
	public Game_SelectPlane(Bitmap shezhi_fanhui, Bitmap shezhi_fanhui_press,
			Bitmap plane_anyeleiting, Bitmap plane_anyeyingxue,
			Bitmap plane_huangjinzhanjia, Bitmap plane_lengyanhanfeng,Bitmap plane_moshangyanyun,
			Bitmap button_houtui, Bitmap button_houtui_press, Bitmap button_qianjin, Bitmap button_qianjin_press,
			Context context) {
		this.shezhi_fanhui=shezhi_fanhui;
		this.shezhi_fanhui_press=shezhi_fanhui_press;
		this.plane_anyeleiting=plane_anyeleiting;
		this.plane_anyeyingxue=plane_anyeyingxue;
		this.plane_huangjinzhanjia=plane_huangjinzhanjia;
		this.plane_lengyanhanfeng=plane_lengyanhanfeng;
		this.plane_moshangyanyun= plane_moshangyanyun;
		this.button_houtui=button_houtui;
		this.button_houtui_press=button_houtui_press;
		this.button_qianjin=button_qianjin;
		this.button_qianjin_press=button_qianjin_press;
		this.context=context;
		isPress_shezhi_fanhui= false;
		isPress_houtui=false;
		isPress_qianjin=false;
		scW=GamingPlaneTest.screenW;
		scH=GamingPlaneTest.screenH;	
		database_player=new DataBase_Player(context);
		plane1=DataBase_Player.plane1;
		plane2=DataBase_Player.plane2;
	}

	public void draw1(Canvas canvas, Paint paint) {
		 // ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //���ý���ķ��ذ�ť
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;     
	   //����δ���°�ťͼ
			if (isPress_shezhi_fanhui) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			}
		//ս��1��λ��
			int plane_huangjinzhanjia_width = plane_huangjinzhanjia.getWidth();
		    int plane_huangjinzhanjia_height = plane_huangjinzhanjia.getHeight();
		    Bitmap plane_huangjinzhanjia_new  = Bitmap.createBitmap(plane_huangjinzhanjia,0,0,plane_huangjinzhanjia_width,plane_huangjinzhanjia_height, matrix, true);
		    plane_huangjinzhanjia_new_butH = plane_huangjinzhanjia_new.getHeight();//ͼƬ�ĸ߶�
		    plane_huangjinzhanjia_new_butW = plane_huangjinzhanjia_new.getWidth();//ͼƬ�Ŀ��
		    plane_huangjinzhanjia_weizhi_W = (scW-plane_huangjinzhanjia_new_butW)/2;
		    plane_huangjinzhanjia_weizhi_H =  (scH/16)*3;;
		    canvas.drawBitmap(plane_huangjinzhanjia_new,plane_huangjinzhanjia_weizhi_W,plane_huangjinzhanjia_weizhi_H, paint);
		  
		    plane_W=GamingPlaneTest.Player.getWidth();
		    plane_H=GamingPlaneTest.Player.getHeight();
		    //TODO 
		    canvas.save();
			canvas.clipRect(plane_huangjinzhanjia_weizhi_W+plane_W/3/2, plane_huangjinzhanjia_weizhi_H+10, plane_huangjinzhanjia_weizhi_W + plane_W/3+plane_W/3/2,plane_huangjinzhanjia_weizhi_H + plane_H+ plane_huangjinzhanjia_new_butH /10);
			canvas.drawBitmap(GamingPlaneTest.Player,plane_huangjinzhanjia_weizhi_W+plane_W/3/2- frameIndex *plane_W/3, plane_huangjinzhanjia_weizhi_H+plane_huangjinzhanjia_new_butH /10, paint);
			canvas.restore();		    
		     //ǰ��
		         int qianjin_width = button_qianjin.getWidth();
			     int qianjin_height = button_qianjin.getHeight();
			     Bitmap qianjin_new  = Bitmap.createBitmap(button_qianjin,0,0,qianjin_width,qianjin_height, matrix, true);
			     Bitmap qianjin_press_new  = Bitmap.createBitmap(button_qianjin_press,0,0,qianjin_width,qianjin_height, matrix, true);
			     qianjin_new_butH = qianjin_new.getHeight();//ͼƬ�ĸ߶�
			     qianjin_new_butW = qianjin_new.getWidth();//ͼƬ�Ŀ��
			     qianjin_weizhi_W = (scW/18)*17-qianjin_new_butW;
			     qianjin_weizhi_H = (scH/16)*15-qianjin_new_butH;
		    if (isPress_qianjin) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(qianjin_press_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				} else {
					canvas.drawBitmap(qianjin_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				}
		    
	}
	public void draw2(Canvas canvas, Paint paint) {
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //���ý���ķ��ذ�ť
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;
	   //����δ���°�ťͼ
			if (isPress_shezhi_fanhui) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			}
		//ս��2��λ��
			int plane_anyeleiting_width = plane_anyeleiting.getWidth();
		    int plane_anyeleiting_height = plane_anyeleiting.getHeight();
		    Bitmap plane_anyeleiting_new  = Bitmap.createBitmap(plane_anyeleiting,0,0,plane_anyeleiting_width,plane_anyeleiting_height, matrix, true);
		    plane_anyeleiting_new_butH = plane_anyeleiting_new.getHeight();//ͼƬ�ĸ߶�
		    plane_anyeleiting_new_butW = plane_anyeleiting_new.getWidth();//ͼƬ�Ŀ��
		    plane_anyeleiting_weizhi_W = (scW-plane_anyeleiting_new_butW)/2;
		    plane_anyeleiting_weizhi_H =  (scH/16)*3;;
		    canvas.drawBitmap(plane_anyeleiting_new,plane_anyeleiting_weizhi_W,plane_anyeleiting_weizhi_H, paint);

		    plane_W=GamingPlaneTest.Player3.getWidth();
		    plane_H=GamingPlaneTest.Player3.getHeight();
		    //TODO 
		    canvas.save();
			canvas.clipRect(plane_anyeleiting_weizhi_W +plane_W/3/2,   plane_anyeleiting_weizhi_H+10,plane_anyeleiting_weizhi_W + plane_W/3+plane_W/3/2,   plane_anyeleiting_weizhi_H + plane_H+plane_huangjinzhanjia_new_butH /10);
			canvas.drawBitmap(GamingPlaneTest.Player3,plane_anyeleiting_weizhi_W +plane_W/3/2- frameIndex *plane_W/3,    plane_anyeleiting_weizhi_H+plane_huangjinzhanjia_new_butH /10, paint);
			canvas.restore();		
		    //����
		    int houtui_width = button_houtui.getWidth();
		    int houtui_height = button_houtui.getHeight();
		     Bitmap houtui_new  = Bitmap.createBitmap(button_houtui,0,0,houtui_width,houtui_height, matrix, true);
		     Bitmap houtui_press_new  = Bitmap.createBitmap(button_houtui_press,0,0,houtui_width,houtui_height, matrix, true);
		     houtui_new_butH = houtui_new.getHeight();//ͼƬ�ĸ߶�
		     houtui_new_butW = houtui_new.getWidth();//ͼƬ�Ŀ��
		     houtui_weizhi_W = scW/18;
		     houtui_weizhi_H = (scH/16)*15-houtui_new_butH;
		     //ǰ��
		        int qianjin_width = button_qianjin.getWidth();
			    int qianjin_height = button_qianjin.getHeight();
			     Bitmap qianjin_new  = Bitmap.createBitmap(button_qianjin,0,0,qianjin_width,qianjin_height, matrix, true);
			     Bitmap qianjin_press_new  = Bitmap.createBitmap(button_qianjin_press,0,0,qianjin_width,qianjin_height, matrix, true);
			     qianjin_new_butH = qianjin_new.getHeight();//ͼƬ�ĸ߶�
			     qianjin_new_butW = qianjin_new.getWidth();//ͼƬ�Ŀ��
			     qianjin_weizhi_W = (scW/18)*17-qianjin_new_butW;
			     qianjin_weizhi_H = (scH/16)*15-houtui_new_butH;
		    if (isPress_houtui) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(houtui_press_new,houtui_weizhi_W,houtui_weizhi_H, paint);
				} else {
					canvas.drawBitmap(houtui_new ,houtui_weizhi_W,houtui_weizhi_H, paint);
				}
		    if (isPress_qianjin) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(qianjin_press_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				} else {
					canvas.drawBitmap(qianjin_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				}
	}
	public void draw3(Canvas canvas, Paint paint) {
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //���ý���ķ��ذ�ť
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;
	   //����δ���°�ťͼ
			if (isPress_shezhi_fanhui) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			}
		//ս��1��λ��
			int plane_lengyanhanfeng_width =plane_lengyanhanfeng.getWidth();
		    int plane_lengyanhanfeng_height = plane_lengyanhanfeng.getHeight();
		    Bitmap plane_lengyanhanfeng_new  = Bitmap.createBitmap(plane_lengyanhanfeng,0,0,plane_lengyanhanfeng_width,plane_lengyanhanfeng_height, matrix, true);
		    plane_lengyanhanfeng_new_butH = plane_lengyanhanfeng_new.getHeight();//ͼƬ�ĸ߶�
		    plane_lengyanhanfeng_new_butW = plane_lengyanhanfeng_new.getWidth();//ͼƬ�Ŀ��
		    plane_lengyanhanfeng_weizhi_W = (scW-plane_lengyanhanfeng_new_butW)/2;
		    plane_lengyanhanfeng_weizhi_H =  (scH/16)*3;;
		    canvas.drawBitmap(plane_lengyanhanfeng_new,plane_lengyanhanfeng_weizhi_W,plane_lengyanhanfeng_weizhi_H, paint);
		    plane_W=GamingPlaneTest.Player1.getWidth();
		    plane_H=GamingPlaneTest.Player1.getHeight();
		    //TODO 
		    canvas.save();
			canvas.clipRect( plane_lengyanhanfeng_weizhi_W +plane_W/3/2,  plane_lengyanhanfeng_weizhi_H +10,  plane_lengyanhanfeng_weizhi_W  + plane_W/3+plane_W/3/2, plane_lengyanhanfeng_weizhi_H  + plane_H+plane_huangjinzhanjia_new_butH /10);
			canvas.drawBitmap(GamingPlaneTest.Player1, plane_lengyanhanfeng_weizhi_W +plane_W/3/2- frameIndex *plane_W/3,  plane_lengyanhanfeng_weizhi_H +plane_huangjinzhanjia_new_butH /10, paint);
			canvas.restore();
		    //����
		    int houtui_width = button_houtui.getWidth();
		    int houtui_height = button_houtui.getHeight();
		     Bitmap houtui_new  = Bitmap.createBitmap(button_houtui,0,0,houtui_width,houtui_height, matrix, true);
		     Bitmap houtui_press_new  = Bitmap.createBitmap(button_houtui_press,0,0,houtui_width,houtui_height, matrix, true);
		     houtui_new_butH = houtui_new.getHeight();//ͼƬ�ĸ߶�
		     houtui_new_butW = houtui_new.getWidth();//ͼƬ�Ŀ��
		     houtui_weizhi_W = scW/18;
		     houtui_weizhi_H = (scH/16)*15-houtui_new_butH;
		     //ǰ��
		         int qianjin_width = button_qianjin.getWidth();
			     int qianjin_height = button_qianjin.getHeight();
			     Bitmap qianjin_new  = Bitmap.createBitmap(button_qianjin,0,0,qianjin_width,qianjin_height, matrix, true);
			     Bitmap qianjin_press_new  = Bitmap.createBitmap(button_qianjin_press,0,0,qianjin_width,qianjin_height, matrix, true);
			     qianjin_new_butH = qianjin_new.getHeight();//ͼƬ�ĸ߶�
			     qianjin_new_butW = qianjin_new.getWidth();//ͼƬ�Ŀ��
			     qianjin_weizhi_W = (scW/18)*17-qianjin_new_butW;
			     qianjin_weizhi_H = (scH/16)*15-houtui_new_butH;
		    if (isPress_houtui) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(houtui_press_new,houtui_weizhi_W,houtui_weizhi_H, paint);
				} else {
					canvas.drawBitmap(houtui_new ,houtui_weizhi_W,houtui_weizhi_H, paint);
				}
		    if (isPress_qianjin) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(qianjin_press_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				} else {
					canvas.drawBitmap(qianjin_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				}
	}
	public void draw4(Canvas canvas, Paint paint) {
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //���ý���ķ��ذ�ť
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;
	   //����δ���°�ťͼ
			if (isPress_shezhi_fanhui) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			}
		//ս��1��λ��
			int plane_anyeyingxue_width = plane_anyeyingxue.getWidth();
		    int plane_anyeyingxue_height = plane_anyeyingxue.getHeight();
		    Bitmap plane_anyeyingxue_new  = Bitmap.createBitmap(plane_anyeyingxue,0,0,plane_anyeyingxue_width,plane_anyeyingxue_height, matrix, true);
		    plane_anyeyingxue_new_butH = plane_anyeyingxue_new.getHeight();//ͼƬ�ĸ߶�
		    plane_anyeyingxue_new_butW = plane_anyeyingxue_new.getWidth();//ͼƬ�Ŀ��
		    plane_anyeyingxue_weizhi_W = (scW-plane_anyeyingxue_new_butW)/2;
		    plane_anyeyingxue_weizhi_H =  (scH/16)*3;;
		    canvas.drawBitmap(plane_anyeyingxue_new,plane_anyeyingxue_weizhi_W,plane_anyeyingxue_weizhi_H, paint);
		    plane_W=GamingPlaneTest.Player2.getWidth();
		    plane_H=GamingPlaneTest.Player2.getHeight();
		    //TODO 
		    canvas.save();
			canvas.clipRect( plane_anyeyingxue_weizhi_W +plane_W/3/2,   plane_anyeyingxue_weizhi_H +10,  plane_anyeyingxue_weizhi_W + plane_W/3+plane_W/3/2,  plane_anyeyingxue_weizhi_H  + plane_H+plane_huangjinzhanjia_new_butH /10);
			canvas.drawBitmap(GamingPlaneTest.Player2,plane_anyeyingxue_weizhi_W+plane_W/3/2- frameIndex *plane_W/3,  plane_anyeyingxue_weizhi_H +plane_huangjinzhanjia_new_butH /10, paint);
			canvas.restore();
		    //����
		    int houtui_width = button_houtui.getWidth();
		    int houtui_height = button_houtui.getHeight();
		     Bitmap houtui_new  = Bitmap.createBitmap(button_houtui,0,0,houtui_width,houtui_height, matrix, true);
		     Bitmap houtui_press_new  = Bitmap.createBitmap(button_houtui_press,0,0,houtui_width,houtui_height, matrix, true);
		     houtui_new_butH = houtui_new.getHeight();//ͼƬ�ĸ߶�
		     houtui_new_butW = houtui_new.getWidth();//ͼƬ�Ŀ��
		     houtui_weizhi_W = scW/18;
		     houtui_weizhi_H = (scH/16)*15-houtui_new_butH;
		        //ǰ��
		        int qianjin_width = button_qianjin.getWidth();
			     int qianjin_height = button_qianjin.getHeight();
			     Bitmap qianjin_new  = Bitmap.createBitmap(button_qianjin,0,0,qianjin_width,qianjin_height, matrix, true);
			     Bitmap qianjin_press_new  = Bitmap.createBitmap(button_qianjin_press,0,0,qianjin_width,qianjin_height, matrix, true);
			     qianjin_new_butH = qianjin_new.getHeight();//ͼƬ�ĸ߶�
			     qianjin_new_butW = qianjin_new.getWidth();//ͼƬ�Ŀ��
			     qianjin_weizhi_W = (scW/18)*17-qianjin_new_butW;
			     qianjin_weizhi_H = (scH/16)*15-houtui_new_butH;
		    if (isPress_houtui) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(houtui_press_new,houtui_weizhi_W,houtui_weizhi_H, paint);
				} else {
					canvas.drawBitmap(houtui_new ,houtui_weizhi_W,houtui_weizhi_H, paint);
				}
		    if (isPress_qianjin) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(qianjin_press_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				} else {
					canvas.drawBitmap(qianjin_new ,qianjin_weizhi_W,qianjin_weizhi_H, paint);
				}
	
	}
	public void draw5(Canvas canvas, Paint paint) {
		// ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(GamingPlaneTest.scaleWidth, GamingPlaneTest.scaleHeight); 
	     //���ý���ķ��ذ�ť
		 int shezhi_fanhui_width = shezhi_fanhui.getWidth();
	     int shezhi_fanhui_height = shezhi_fanhui.getHeight();
	     Bitmap shezhi_fanhui_new  = Bitmap.createBitmap(shezhi_fanhui,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     Bitmap shezhi_fanhui_press_new  = Bitmap.createBitmap(shezhi_fanhui_press,0,0,shezhi_fanhui_width,shezhi_fanhui_height, matrix, true);
	     shezhi_fanhui_new_butH = shezhi_fanhui_new.getHeight();//ͼƬ�ĸ߶�
	     shezhi_fanhui_new_butW = shezhi_fanhui_new.getWidth();//ͼƬ�Ŀ��
	     shezhi_fanhui_weizhi_W = scW/18;
	     shezhi_fanhui_weizhi_H = scH/16;
	   //����δ���°�ťͼ
			if (isPress_shezhi_fanhui) {
			//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
				canvas.drawBitmap(shezhi_fanhui_press_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			} else {
				canvas.drawBitmap(shezhi_fanhui_new ,shezhi_fanhui_weizhi_W,shezhi_fanhui_weizhi_H, paint);
			}
			/*
			 * 	int plane_anyeyingxue_width = plane_anyeyingxue.getWidth();
		    int plane_anyeyingxue_height = plane_anyeyingxue.getHeight();
		    Bitmap plane_anyeyingxue_new  = Bitmap.createBitmap(plane_anyeyingxue,0,0,plane_anyeyingxue_width,plane_anyeyingxue_height, matrix, true);
		    plane_anyeyingxue_new_butH = plane_anyeyingxue_new.getHeight();//ͼƬ�ĸ߶�
		    plane_anyeyingxue_new_butW = plane_anyeyingxue_new.getWidth();//ͼƬ�Ŀ��
		    plane_anyeyingxue_weizhi_W = (scW-plane_anyeyingxue_new_butW)/2;
		    plane_anyeyingxue_weizhi_H =  (scH/16)*3;;
		    canvas.drawBitmap(plane_anyeyingxue_new,plane_anyeyingxue_weizhi_W,plane_anyeyingxue_weizhi_H, paint);
		    plane_W=MySurfaceView.bmpPlayer2.getWidth();
		    plane_H=MySurfaceView.bmpPlayer2.getHeight();
		    //TODO 
		    canvas.save();
			canvas.clipRect( plane_anyeyingxue_weizhi_W +plane_W/3/2,   plane_anyeyingxue_weizhi_H +10,  plane_anyeyingxue_weizhi_W + plane_W/3+plane_W/3/2,  plane_anyeyingxue_weizhi_H  + plane_H+10);
			canvas.drawBitmap(MySurfaceView.bmpPlayer2,plane_anyeyingxue_weizhi_W+plane_W/3/2- frameIndex *plane_W/3,  plane_anyeyingxue_weizhi_H +10, paint);
			canvas.restore();*/
		//ս��1��λ��
			int plane_moshangyanyun_width = plane_moshangyanyun.getWidth();
		    int plane_moshangyanyun_height = plane_moshangyanyun.getHeight();
		    Bitmap plane_moshangyanyun_new  = Bitmap.createBitmap(plane_moshangyanyun,0,0,plane_moshangyanyun_width,plane_moshangyanyun_height, matrix, true);
		    plane_moshangyanyun_new_butH = plane_moshangyanyun_new.getHeight();//ͼƬ�ĸ߶�
		    plane_moshangyanyun_new_butW = plane_moshangyanyun_new.getWidth();//ͼƬ�Ŀ��
		    plane_moshangyanyun_weizhi_W = (scW-plane_moshangyanyun_new_butW)/2;
		    plane_moshangyanyun_weizhi_H =  (scH/16)*3;;
		    canvas.drawBitmap(plane_moshangyanyun_new,plane_moshangyanyun_weizhi_W,plane_moshangyanyun_weizhi_H, paint);
		    plane_W=GamingPlaneTest.Player5.getWidth();
		    plane_H=GamingPlaneTest.Player5.getHeight();
		    //TODO 
		    canvas.save();
			canvas.clipRect( plane_moshangyanyun_weizhi_W +plane_W/3/2,   plane_moshangyanyun_weizhi_H+10,   plane_moshangyanyun_weizhi_W + plane_W/3+plane_W/3/2, plane_moshangyanyun_weizhi_H  + plane_H+plane_huangjinzhanjia_new_butH /10);
			canvas.drawBitmap(GamingPlaneTest.Player5, plane_moshangyanyun_weizhi_W+plane_W/3/2- frameIndex *plane_W/3,  plane_moshangyanyun_weizhi_H +plane_huangjinzhanjia_new_butH /10, paint);
			canvas.restore();
		    
			
			//����
		    int houtui_width = button_houtui.getWidth();
		    int houtui_height = button_houtui.getHeight();
		     Bitmap houtui_new  = Bitmap.createBitmap(button_houtui,0,0,houtui_width,houtui_height, matrix, true);
		     Bitmap houtui_press_new  = Bitmap.createBitmap(button_houtui_press,0,0,houtui_width,houtui_height, matrix, true);
		     houtui_new_butH = houtui_new.getHeight();//ͼƬ�ĸ߶�
		     houtui_new_butW = houtui_new.getWidth();//ͼƬ�Ŀ��
		     houtui_weizhi_W = scW/18;
		     houtui_weizhi_H = (scH/16)*15-houtui_new_butH;
		    if (isPress_houtui) {
				//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
					canvas.drawBitmap(houtui_press_new,houtui_weizhi_W,houtui_weizhi_H, paint);
				} else {
					canvas.drawBitmap(houtui_new ,houtui_weizhi_W,houtui_weizhi_H, paint);
				}
	}
	//�˵������¼���������Ҫ���ڴ���ť�¼�
		public void onTouchEvent(MotionEvent event) {
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//�ж��û��Ƿ����˰�ť
				//����
				if (pointX >shezhi_fanhui_weizhi_W && pointX <shezhi_fanhui_weizhi_W + shezhi_fanhui_new_butW)
				{
					if (pointY >shezhi_fanhui_weizhi_H && pointY < shezhi_fanhui_weizhi_H+shezhi_fanhui_new_butH) 
					{   
						isPress_shezhi_fanhui= true;
					} else 
					{
						isPress_shezhi_fanhui= false;
					}
				}	
				else 
				{   
					isPress_shezhi_fanhui= false;
				}
				//���û���̧����
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
				if (pointX >shezhi_fanhui_weizhi_W && pointX <shezhi_fanhui_weizhi_W + shezhi_fanhui_new_butW)
				{
					if (pointY >shezhi_fanhui_weizhi_H && pointY < shezhi_fanhui_weizhi_H+shezhi_fanhui_new_butH) 
					{   
						isPress_shezhi_fanhui= false;
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_MENU;	
					} 
				}
					
				
			}
		}
		public void onTouchEvent1(MotionEvent event) {
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//�ж��û��Ƿ����˰�ť
				if (pointX >houtui_weizhi_W && pointX <houtui_weizhi_W + houtui_new_butW)
				{
					if (pointY >houtui_weizhi_H && pointY <houtui_weizhi_H+houtui_new_butH ) 
					{   
						isPress_houtui= true;
					} else 
					{
						isPress_houtui= false;
					}
				}	
				else 
				{   
					isPress_houtui=false;
				}
			
				//���û���̧����
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
				if (pointX >houtui_weizhi_W && pointX <houtui_weizhi_W + houtui_new_butW)
				{
					if (pointY >houtui_weizhi_H && pointY <houtui_weizhi_H+houtui_new_butH ) 
					{   
						isPress_houtui= false;
						 //���ݶ�ȡ
						SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
						is_plane1 =prefs.getBoolean("is_plane1",true);
						is_plane2 =prefs.getBoolean("is_plane2",false);
						is_plane3 =prefs.getBoolean("is_plane3",false);
						is_plane4 =prefs.getBoolean("is_plane4",false);
						is_plane5 =prefs.getBoolean("is_plane5",false);
						SharedPreferences.Editor editor=prefs.edit();
						//plane1 plane2 4.5�ɻ�����true Ϊ����
						if(is_plane2)
						{   
							editor.putBoolean("is_plane2",false);
							editor.putBoolean("is_plane1",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;					
						}
						if(is_plane3)
						{   
							editor.putBoolean("is_plane3",false);
							editor.putBoolean("is_plane2",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;	
						}
						if(is_plane4)
						{   
							editor.putBoolean("is_plane4",false);
							editor.putBoolean("is_plane3",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;	
                        }
						if(is_plane5)
						{   
							editor.putBoolean("is_plane5",false);
							editor.putBoolean("is_plane4",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;	
						}	
					}
				}
				
			}
		}
		public void onTouchEvent2(MotionEvent event) {
			//��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			//���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
				//�ж��û��Ƿ����˰�ť
				if (pointX >qianjin_weizhi_W && pointX <qianjin_weizhi_W + qianjin_new_butW)
				{
					if (pointY >qianjin_weizhi_H && pointY <qianjin_weizhi_H+qianjin_new_butH) 
					{   
						isPress_qianjin= true;
					} else 
					{
						isPress_qianjin= false;
					}
				}	
				else 
				{   
					isPress_qianjin=false;
				}
			
				//���û���̧����
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
				if (pointX >qianjin_weizhi_W && pointX <qianjin_weizhi_W + qianjin_new_butW)
				{
					if (pointY >qianjin_weizhi_H && pointY <qianjin_weizhi_H+qianjin_new_butH) 
					{   
						isPress_qianjin= false;
						 //���ݶ�ȡ
						SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
						is_plane1 =prefs.getBoolean("is_plane1",true);
						is_plane2 =prefs.getBoolean("is_plane2",false);
						is_plane3 =prefs.getBoolean("is_plane3",false);
						is_plane4 =prefs.getBoolean("is_plane4",false);
						is_plane5 =prefs.getBoolean("is_plane5",false);
						SharedPreferences.Editor editor=prefs.edit();
						if(is_plane2)
						{   
							editor.putBoolean("is_plane2",false);
							editor.putBoolean("is_plane3",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;
							
						}
						if(is_plane3)
						{    
							if(plane1)
							{
							editor.putBoolean("is_plane3",false);
							editor.putBoolean("is_plane4",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;
							}
							
						}
						if(is_plane4)
						{   if(plane2)
						   {
							editor.putBoolean("is_plane4",false);
							editor.putBoolean("is_plane5",true);
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;
							editor.commit();
						   }
							
                        }
						if(is_plane1)
						{   
							editor.putBoolean("is_plane1",false);
							editor.putBoolean("is_plane2",true);
							editor.commit();
							GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;
							
						}	
							
					}
				}	
				
			}
		}
  }
