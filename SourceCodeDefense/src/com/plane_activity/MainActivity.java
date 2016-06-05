package com.plane_activity;
import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;

import com.plane_database.DataBase_Player;
import com.plane_test.GamingPlayer;
import com.plane_test.R;
import com.plane_ui.GameMenu;
import com.umeng.update.UmengUpdateAgent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends Activity {
	public static boolean zlkg=false;
	public static boolean zlsz=false;
	//�𶯿���
	public static boolean vikg=false;
	//��ȡ������ֵ
	public static float  xValue,yValue,zValue ;
//	public static float tx,ty,tz;
	public Button button;
	public static String APPID = "66105390f77fbb5a562565a4a827de91";
	public static MainActivity instance;
	private SensorManager sensormanager;
	public static Vibrator vibrator;  
	//�ɻ������ƶ��ٶ�
	public static int spx,spy,spz;
	public static String  mac ;
	DataBase_Player database_player;
	//�����С������
	public static int TEXT_SIZE_50;
	public static int TEXT_SIZE_28;;
	float OFFSET_LEFT;
    float OFFSET_TOP;
    float  RATIO;
    ImageView imageview;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UmengUpdateAgent.update(this);
		instance = this;
		//����ȫ��
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ʾ�Զ����SurfaceView��ͼ
		//setContentView(new MySurfaceView(this));
		 setContentView(R.layout.activity_main);
		 getWindow().setBackgroundDrawableResource(R.drawable.main);
		 /* 
	         *�𶯴�С����ͨ���ı�pattern���趨 
	         * */  
	        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
	       // long [] pattern = {100,400,100,400};   // ֹͣ ���� ֹͣ ����   
	     //   vibrator.vibrate(pattern,-1);           // ���ֻ����һ�Σ�index��Ϊ-1   
	        
		/// button =(Button)findViewById(R.id.button);
		    sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);  //ʵ����
	        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER); //���������ͣ����ٶȴ�����
	        sensormanager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);    //ע��
	        mac=getMacFromWifi();
	        Bmob.initialize(getApplicationContext(),APPID);//�ƴ洢
	        //���ݲ�ѯ
	        database_player=new DataBase_Player(this);        
	        database_player.query_player();
	        
	        //�����С
	    	DisplayMetrics displayMetrics = new DisplayMetrics();  
			this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
			int screenWidth = displayMetrics.widthPixels;  
			int screenHeight = displayMetrics.heightPixels;  
			float ratioWidth = (float)screenWidth / 720;  
			float ratioHeight = (float)screenHeight / 1280;  
	        RATIO = Math.min(ratioWidth, ratioHeight);  
	        if (ratioWidth != ratioHeight) {  
	           if (RATIO == ratioWidth) {  
	           OFFSET_LEFT = 0;  
	           OFFSET_TOP = Math.round((screenHeight - 1280 * RATIO) / 2);  
	           }else {  
	           OFFSET_LEFT = Math.round((screenWidth - 720 * RATIO) / 2);  
	           OFFSET_TOP = 0;  
	           }  
	        }  
	        TEXT_SIZE_50 = Math.round(50* RATIO);
	        TEXT_SIZE_28 = Math.round(28* RATIO);
    //   Intent it = new Intent(MainActivity.this, Activity2.class); 
	  //      startActivity(it);
	    //    this.finish();
//	        button.setOnClickListener(new OnClickListener(){
//		        public void onClick(View v) {
//		       	 	tx=xValue;
//		       	 	ty=yValue;
////		       	 	tz=zValue;		 
//		       	 	if(zlstart)
//		       	 	   zlstart=false;
////		       	 	else
//		       	 	   zlstart=true;
//		        }});
	        final Intent it = new Intent(MainActivity.this, Activity_donghua.class); //��Ҫת���Activity   
	        Timer timer = new Timer(); 
	        TimerTask task = new TimerTask() {  
	    	public void run() {   
	    		startActivity(it); //ִ��      		
	     		} 
	        };
	        timer.schedule(task, 1000); //10���
	        
	}
	public  String getMacFromWifi(){
 		WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
 		WifiInfo info = wifi.getConnectionInfo();
 		return info.getMacAddress();
		}
    
	public void onStop(){  
        super.onStop();  
        vibrator.cancel();  
    }  
	
	//����
		private SensorEventListener listener = new SensorEventListener(){					
			@Override
			public void onAccuracyChanged(Sensor sensor, int accuracy) {						
			}
			@Override
			public void onSensorChanged(SensorEvent event) {
				//���ٶȿ���Ϊ��ֵ������Ҫȡ����ֵ    x,y,z
				  xValue = event.values[0];
				  yValue = event.values[1];
				  zValue = event.values[2];
				   spx=(int) (xValue-GameMenu.x);
				   spy=(int)(yValue-GameMenu.y);
				   spz=(int)(zValue-GameMenu.z);
				if(zlkg&&zlsz) {  
					
			         pyd();
				}
	
			
			}
		};

		 private void pyd()
		 {
			 
			 if(GameMenu.x>=8||GameMenu.x<=-8)
			 {
				 if(zValue>GameMenu.z+1)
			        GamingPlayer.isleft=true;
			     if(zValue<GameMenu.z-1)
			    	    GamingPlayer.isright=true ;
			     if(zValue<GameMenu.z+1&&zValue>GameMenu.z-1){
			    	 GamingPlayer.isleft=false;
			     GamingPlayer.isright=false;
			     }
			 }
			 if(GameMenu.x<8&&GameMenu.x>-8)
			 {
				 if(xValue>GameMenu.x+1)				 
					  GamingPlayer.isleft=true;			   
				 if(xValue<GameMenu.x-1)		 
					  GamingPlayer.isright=true;				   
				 if(xValue<GameMenu.x+1&&xValue>GameMenu.x-1){				 
					  GamingPlayer.isleft=false;
					  GamingPlayer.isright=false;
				 }						
			 }
			 if(GameMenu.y>=8||GameMenu.y<=-8)
			 {
				 if(zValue<GameMenu.z-1)				 
					GamingPlayer.isdown=true;				   
				 if(zValue>GameMenu.z+1)				  
						GamingPlayer.isup=true;			   
				 if(zValue>GameMenu.z-1&&zValue<GameMenu.z+1)		  
				 {
						GamingPlayer.isdown=false;		
						GamingPlayer.isup=false;		
				 }			   					 
			 }
			 if(GameMenu.y<8&&GameMenu.y>-8)
			 {
				 if(yValue>GameMenu.y+1)
					 GamingPlayer.isdown=true;	
				 if(yValue<GameMenu.y-1)
					 GamingPlayer.isup=true;	
				 if(yValue<GameMenu.y+1&&yValue>GameMenu.y-1)
				 {
					 GamingPlayer.isup=false;	
				 GamingPlayer.isdown=false;	
				 }
     
			 
		 }
		
		 }
		 protected void onDestroy()
		 {
			 super.onDestroy();
			 if(sensormanager != null)
			 {
				 sensormanager.unregisterListener(listener);
				 
			 }
		 }
		
}