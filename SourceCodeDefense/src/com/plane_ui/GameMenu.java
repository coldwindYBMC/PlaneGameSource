package com.plane_ui;
import com.plane_activity.MainActivity;
import com.plane_test.GamingPlaneTest;
import com.plane_test.GamingPlayer;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
public class GameMenu {
	//�˵�����ͼ
	//private Bitmap bmpMenu;
	//��ťͼƬ��Դ
	//��ť������
	private int scH,scW;
	private Bitmap button_jingdian;////����ģʽ
	private Bitmap button_shangdian;
	//��ť�Ƿ��±�ʶλ
	private Boolean isPress_jingdian;//j����
	private Boolean isPress_wujin;//�޾�
	private Boolean isPress_juqing;//����
	float button_jingdian_butH;
    float button_jingdian_butW;
    float button_jingdian_weizhi_W;//���䰴ť�İڷ�λ��W
    float button_jingdian_weizhi_H;//���䰴ť�İڷ�λ��H
    float button_jingdian_weizhi_zhongzhuan;
    
    private Bitmap button_wujin;//�޾�ģʽ
    float button_wujin_butH;
    float button_wujin_butW;
    float button_wujin_weizhi_H;//���䰴ť�İڷ�λ��H
    float button_wujin_weizhi_zhongzhuan;
	private Bitmap button_juqing;//����ģʽ
	float button_juqing_butH;
	float button_juqing_weizhi_H;//���鰴ť�İڷ�λ��H
	float button_juqing_weizhi_zhongzhuan;
	private Bitmap button_shezhi;//���ð�ť
	float button_shezhi_butH;
	float button_shezhi_butW;
	float button_shezhi_weizhi_H;//���䰴ť�İڷ�λ��H
	float button_shezhi_weizhi_zhongzhuan;
	private Bitmap button_zhanjiqiehuan;//ս���л�
	float button_zhanjiqiehuan_butH;
	float button_zhanjiqiehuan_weizhi_W;//���䰴ť�İڷ�λ��W
	float button_zhanjiqiehuan_weizhi_zhongzhuan;
	private Bitmap button_jingdian_press;////����ģʽ����ȥ
	private Bitmap button_juqing_press;//����ģʽ����ȥ
	private Bitmap button_wujin_press;//�޾���ť����ȥ
	public static  float scaleWidth;
    public static  float scaleHeight;
    //�̵�
   int button_shangdian_W;
   int button_shangdian_H;
  //�ɻ�״̬
  	private boolean is_plane1;//�ɻ�1
  	private boolean is_plane2;//�ɻ�2
  	private boolean is_plane3;//�ɻ�3
  	private boolean is_plane4;//�ɻ�4
  	private boolean is_plane5;//�ɻ�5
	//�˵���ʼ��
	GamingPlaneTest mys;
	MediaPlayer mediaplayer;
	Bitmap newbm;	
	Bitmap ams_xingxing;
	public static int game;
	public static float x;
	public static float y;
	public static float z;
	int button_zhanjiqiehuan_W;
	int button_zhanjiqiehuan_H;
	Context context;
	public GameMenu(Bitmap ams_xingxing,Bitmap button_jingdian,
			Bitmap button_juqing,Bitmap button_shezhi,Bitmap button_wujin,
			Bitmap button_zhanjiqiehuan,Bitmap button_jingdian_press,
			Bitmap button_juqing_press,Bitmap button_wujin_press,Bitmap button_shangdian,Context context) 
	{   
		this.button_shangdian=button_shangdian;
		this.context=context;
		this.ams_xingxing =ams_xingxing;
		this.button_jingdian= button_jingdian;
		this.button_juqing =button_juqing;
		this.button_shezhi =button_shezhi;
		this.button_wujin=button_wujin;
		this.button_zhanjiqiehuan=button_zhanjiqiehuan;
		this.button_jingdian_press= button_jingdian_press;
		this.button_juqing_press =button_juqing_press;
		this.button_wujin_press =button_wujin_press;
		//X���У�Y������Ļ�ײ�
		scH =  GamingPlaneTest.screenH ;//��Ļ�ĸ߶�
		scW =  GamingPlaneTest.screenW; //��Ļ�Ŀ��
		
		//bmpH = bmpMenu.getHeight();//ͼƬ�ĸ߶�
		//bmpW = bmpMenu.getWidth();//ͼƬ�Ŀ��
		isPress_jingdian = false;
		isPress_wujin = false;
		isPress_juqing = false;
		scaleWidth=0;
		scaleHeight=0;
	}
	//�˵���ͼ����
	public void draw(Canvas canvas, Paint paint) {
	     // ȡ����Ҫ���ŵ�matrix����
	     Matrix matrix = new Matrix();
	     matrix.postScale(scaleWidth, scaleHeight);
	    
	   
	  //���䰴ť   ///////////////////////////////////////   
	  // ���ͼƬ�Ŀ��
	     int button_jingdian_width = button_jingdian.getWidth();//��ȡ���䰴ť�Ŀ��
	     int button_jingdian_height = button_jingdian.getHeight();//��ȡ���䰴ť�ĸ߶�
	     // �õ��µ�ͼƬ
	     Bitmap button_jingdian_new  = Bitmap.createBitmap(button_jingdian,0,0, button_jingdian_width, button_jingdian_height, matrix, true);
	     button_jingdian_butH = button_jingdian_new.getHeight();//ͼƬ�ĸ߶�
	     button_jingdian_butW= button_jingdian_new.getWidth();//ͼƬ�Ŀ��
	     button_jingdian_weizhi_W=(scW-button_jingdian_butW)/2;//���㾭�䰴ť�İڷ�λ��W
	     button_jingdian_weizhi_zhongzhuan=4*button_jingdian_butH;
	     button_jingdian_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*3/7;//���㾭�䰴ť�İڷ�λ��H  //���Ʋ˵�����ͼ
	   
	     Bitmap button_jingdian_press_new  = Bitmap.createBitmap(button_jingdian_press,0,0, button_jingdian_width, button_jingdian_height, matrix, true);
	  //�޾���ť//////////////////////////////////////////  
	      int button_wujin_width = button_wujin.getWidth();//��ȡ���䰴ť�Ŀ��
		  int button_wujin_height = button_wujin.getHeight();//��ȡ���䰴ť�ĸ߶�
		  Bitmap button_wujin_new  = Bitmap.createBitmap(button_wujin,0,0, button_wujin_width, button_wujin_height, matrix, true);//����
		  button_wujin_butH = button_wujin_new.getHeight();//ͼƬ�ĸ߶�
		  button_wujin_butW = button_wujin_new.getWidth();//ͼƬ�ĸ߶�
		  button_wujin_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*4/7+button_wujin_butH;
		  Bitmap button_wujin_press_new  = Bitmap.createBitmap(button_wujin_press,0,0, button_wujin_width, button_wujin_height, matrix, true);//����
	 //���鰴ť//////////////////////////////////////////
		  int button_juqing_width = button_juqing.getWidth();//��ȡ���䰴ť�Ŀ��
		  int button_juqing_height = button_juqing.getHeight();//��ȡ���䰴ť�ĸ߶�
		  Bitmap button_juqing_new  = Bitmap.createBitmap(button_juqing,0,0, button_juqing_width, button_juqing_height, matrix, true);//����
		  button_juqing_butH = button_wujin_new.getHeight();//ͼƬ�ĸ߶�
		  button_juqing_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*5/7+2*button_juqing_butH;
		  Bitmap button_juqing_press_new  = Bitmap.createBitmap(button_juqing_press,0,0, button_juqing_width, button_juqing_height, matrix, true);//����
	 //���ð�ť	  ////////////////////////////////////////
		  int button_shezhi_width = button_shezhi.getWidth();//��ȡ���䰴ť�Ŀ��
		  int button_shezhi_height = button_shezhi.getHeight();//��ȡ���䰴ť�ĸ߶�
		  Bitmap button_shezhi_new  = Bitmap.createBitmap(button_shezhi,0,0, button_shezhi_width, button_shezhi_height, matrix, true);//����
		  button_shezhi_butH = button_shezhi_new.getHeight();//ͼƬ�ĸ߶�
		  button_shezhi_butW = button_shezhi_new.getWidth();
		  button_shezhi_weizhi_H=(scH-button_jingdian_weizhi_zhongzhuan)*6/7+3*button_jingdian_butH;
		  canvas.drawBitmap(button_shezhi_new,button_jingdian_weizhi_W,button_shezhi_weizhi_H,paint);
	 //ս���л�//////////////////////////////////////////////////////////////////////  
		  int button_zhanjiqiehuan_width = button_zhanjiqiehuan.getWidth();//��ȡzhanji��ť�Ŀ��
		  int button_zhanjiqiehuan_height = button_zhanjiqiehuan.getHeight();//��ȡzhanji��ť�ĸ߶�
		  Bitmap button_zhanjiqiehuan_new  = Bitmap.createBitmap(button_zhanjiqiehuan,0,0, button_zhanjiqiehuan_width, button_zhanjiqiehuan_height, matrix, true);//����
		  button_zhanjiqiehuan_W=button_zhanjiqiehuan_new.getWidth();
		  button_zhanjiqiehuan_H=button_zhanjiqiehuan_new.getHeight();
		  button_zhanjiqiehuan_weizhi_W=button_jingdian_weizhi_W+button_jingdian_butW-button_zhanjiqiehuan_W;
		  canvas.drawBitmap(button_zhanjiqiehuan_new,button_zhanjiqiehuan_weizhi_W,button_shezhi_weizhi_H,paint); 
	 //�̵�//////////////////////////////////////////////////////////////////////////	  
		  int button_shangdian_width = button_shangdian.getWidth();//��ȡzhanji��ť�Ŀ��
		  int button_shangdian_height = button_shangdian.getHeight();//��ȡzhanji��ť�ĸ߶�
		  Bitmap button_shangdian_new  = Bitmap.createBitmap(button_shangdian,0,0, button_shangdian_width, button_shangdian_height, matrix, true);//����
		  button_shangdian_W=button_shangdian_new.getWidth();
		  button_shangdian_H=button_shangdian_new.getHeight();
		// int button_zhanjiqiehuan_weizhi_W=button_shangdian_weizhi_W+button_jingdian_butW-button_zhanjiqiehuan_W;
		  canvas.drawBitmap(button_shangdian_new,button_jingdian_weizhi_W+button_jingdian_butW-button_shangdian_W,
				  button_jingdian_weizhi_H/3,paint); 
     //����
		  canvas.drawBitmap(ams_xingxing, 0, 0, paint);		  
		//����//////////
		if (isPress_jingdian) 
		{//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			 canvas.drawBitmap(button_jingdian_press_new,button_jingdian_weizhi_W,button_jingdian_weizhi_H,paint);
			
		} else
		{
			 canvas.drawBitmap(button_jingdian_new,button_jingdian_weizhi_W,button_jingdian_weizhi_H,paint);
		}
		
		//������//////////
		 if (isPress_juqing) 
		{//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			canvas.drawBitmap(button_juqing_press_new,button_jingdian_weizhi_W,button_juqing_weizhi_H,paint);
					
		} else
		{
			canvas.drawBitmap(button_juqing_new,button_jingdian_weizhi_W,button_juqing_weizhi_H,paint);
		}
		//�޾����//////////
		 if (isPress_wujin) 
		{//�����Ƿ��»��Ʋ�ͬ״̬�İ�ťͼ
			 //�޾���ť
			  canvas.drawBitmap(button_wujin_press_new,button_jingdian_weizhi_W,button_wujin_weizhi_H,paint);
		} else
		{
			 //�޾���ť
			  canvas.drawBitmap(button_wujin_new,button_jingdian_weizhi_W,button_wujin_weizhi_H,paint);
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
			//����ģʽ/////////////////////////////////////
			if (pointX > button_jingdian_weizhi_W && pointX < button_jingdian_weizhi_W + button_jingdian_butW)
			{
				if (pointY > button_jingdian_weizhi_H && pointY < button_jingdian_weizhi_H + button_jingdian_butH) 
				{
					isPress_jingdian = true;
					if(GamingPlaneTest.isSound)
					{
						GamingPlaneTest.mediaplayer2.start();
					}
				} else 
				{
					isPress_jingdian = false;
				}
			}
			//�޾�ģʽ/////////////////////////////////////
			if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW)
			{
				if (pointY > button_wujin_weizhi_H && pointY < button_wujin_weizhi_H + button_wujin_butH) 
				{
					isPress_wujin = true;
					if(GamingPlaneTest.isSound)
					{
						GamingPlaneTest.mediaplayer2.start();
					}
				} else 
				{
					isPress_wujin = false;
				}
			}
			/////////////����/////////
			if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW)
			{
				if (pointY > button_juqing_weizhi_H && pointY < button_juqing_weizhi_H + button_juqing_butH) 
				{
					isPress_juqing = true;
					if(GamingPlaneTest.isSound)
					{
						GamingPlaneTest.mediaplayer2.start();
					}
				}
				else 
				{
					isPress_juqing = false;
				}
			}
			 //ս���л�
			 if(pointX > button_zhanjiqiehuan_weizhi_W && pointX <button_zhanjiqiehuan_weizhi_W +button_zhanjiqiehuan_W)
				{
					if(pointY >button_shezhi_weizhi_H&& pointY < button_shezhi_weizhi_H+button_zhanjiqiehuan_H)
					{
					
					}else
					{
						
					}
				}
			else 
			{
				isPress_jingdian = false;
				isPress_juqing = false;
				isPress_wujin = false;
			}
			//���û���̧����
		} 
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			//̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
			//����ģʽ����������//////////////////////////////
			if (pointX > button_jingdian_weizhi_W && pointX < button_jingdian_weizhi_W + button_jingdian_butW) 
			{
				if (pointY > button_jingdian_weizhi_H && pointY < button_jingdian_weizhi_H + button_jingdian_butH) 
				{			
					//��ԭButton״̬Ϊδ����״̬
					isPress_jingdian = false;
					//�ı䵱ǰ��Ϸ״̬Ϊ��ʼ��Ϸ
					//  ��ȡ����
					MainActivity.zlkg=true;
					x=MainActivity.xValue;
					y=MainActivity.yValue;
					z=MainActivity.zValue;
					 //���ݶ�ȡ
					SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
					is_plane1 =prefs.getBoolean("is_plane1",true);
					is_plane2 =prefs.getBoolean("is_plane2",false);
					is_plane3 =prefs.getBoolean("is_plane3",false);
					is_plane4 =prefs.getBoolean("is_plane4",false);
					is_plane5 =prefs.getBoolean("is_plane5",false);
					if(is_plane1){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player, GamingPlaneTest.PlayerHp, 1);
					}
					if(is_plane2){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player3, GamingPlaneTest.PlayerHp, 4);
					}
					if(is_plane3){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player1, GamingPlaneTest.PlayerHp, 2);
					}
					if(is_plane4){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player2, GamingPlaneTest.PlayerHp, 3);
					}
					if(is_plane5){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player5, GamingPlaneTest.PlayerHp, 5);
					}
					//��ȡս��type;										
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;		
  					 game=1;
				}
			}
			////////////�޾�ģʽ///////////////////////////////////////////////
			 if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW) 
			{
				if (pointY > button_wujin_weizhi_H && pointY < button_wujin_weizhi_H + button_wujin_butH) 
				{
					//��ԭButton״̬Ϊδ����״̬
					isPress_wujin = false;		
					MainActivity.zlkg=true;
					x=MainActivity.xValue;
					y=MainActivity.yValue;
					z=MainActivity.zValue;
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_LOADING1;				
				// ��ȡս��type,��ȡ�ɻ�����ͼƬbmpPlayer1
					SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
					is_plane1 =prefs.getBoolean("is_plane1",true);
					is_plane2 =prefs.getBoolean("is_plane2",false);
					is_plane3 =prefs.getBoolean("is_plane3",false);
					is_plane4 =prefs.getBoolean("is_plane4",false);
					is_plane5 =prefs.getBoolean("is_plane5",false);
					if(is_plane1){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player, GamingPlaneTest.PlayerHp, 1);
					}
					if(is_plane2){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player3, GamingPlaneTest.PlayerHp, 4);
					}
					if(is_plane3){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player1, GamingPlaneTest.PlayerHp, 2);
					}
					if(is_plane4){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player2, GamingPlaneTest.PlayerHp, 3);
					}
					if(is_plane5){
						GamingPlaneTest.player = new GamingPlayer(GamingPlaneTest.Player5, GamingPlaneTest.PlayerHp, 5);
					}
                    game=2;					
				}
			}
	/////////////����/////////
				if (pointX >button_jingdian_weizhi_W&& pointX < button_jingdian_weizhi_W + button_wujin_butW)
				{
					if (pointY > button_juqing_weizhi_H && pointY < button_juqing_weizhi_H + button_juqing_butH) 
					{
						isPress_juqing = false;		
						//��ԭButton״̬Ϊδ����״̬		
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_JUQING;							
					} 
				}
			//////////////////////////���ð�ť/////////////////////////////////////
			 if(pointX > button_jingdian_weizhi_W && pointX < button_jingdian_weizhi_W + button_shezhi_butW)
			{
				if(pointY > button_shezhi_weizhi_H && pointY < button_shezhi_weizhi_H + button_shezhi_butH)
				{				
					GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHEZHI;	
				}
			}	
			//ս���л�
			 if(pointX > button_zhanjiqiehuan_weizhi_W && pointX <button_zhanjiqiehuan_weizhi_W +button_zhanjiqiehuan_W)
				{
					if(pointY >button_shezhi_weizhi_H&& pointY < button_shezhi_weizhi_H+button_zhanjiqiehuan_H)
					{   				
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SELECTPLANE1;																		
					}
				}
			 //�̵�
			 if(pointX >button_jingdian_weizhi_W+button_jingdian_butW-button_shangdian_W && pointX <button_jingdian_weizhi_W+button_jingdian_butW)
				{
					if(pointY >button_jingdian_weizhi_H/3&& pointY < button_jingdian_weizhi_H/3+button_shangdian_H)
					{   				
						GamingPlaneTest.gameState = GamingPlaneTest.GAME_SHOP_DAOJU;																		
					}
				}
		}
	}
}
