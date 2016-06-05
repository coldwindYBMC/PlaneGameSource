package com.plane_database;
import java.util.Date;
import java.util.List;
import com.plane_activity.MainActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
public class DataBase_Player  {
	public static String objectId="";
	/**
	 * 插入对象
	 */
	Context context;
	public static Integer goldcoin;
	public static Boolean plane1;
	public static Boolean plane2;
	public static Integer effect1;
	public static Integer effect2;
	public static String mac;
	public static String objectid;
	public static boolean is_player;
	 public DataBase_Player(Context context)
	 {
		 this.context=context;
		 mac=MainActivity.mac;
		 is_player=true;
	 }
	public void insert_player() {
		final Data_Player p2 = new Data_Player();
		if(mac==null)
		{       
			    SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
        		//数据存储
        		SharedPreferences.Editor editor=prefs.edit();
        		editor.putBoolean("is_player",true);
        		editor.putInt("goldcoin",0);
        		editor.putBoolean("plane1",false);
        		editor.putBoolean("plane2",false);
        		editor.putInt("effect1",3);
        		editor.putInt("effect2",3);
        		editor.commit();
        		
		}
		if(mac!=null)
		{
			p2.setMac(mac);
			p2.setGoldCoin(0);
			p2.setPlane1(false);
			p2.setPlane2(false);
			p2.setEffect1(0);
			p2.setEffect2(0);
			p2.setUploadTime(new BmobDate(new Date()));
			p2.save(context, new SaveListener() {
				public void onSuccess() {
					objectId = p2.getObjectId();
		
				}
				@Override
				public void onFailure(int code, String msg) {
					
				}
			});
		}
		
	}
		
		/**
		 * 更新对象
		 */
		//更新飞机类型
				public void UpdateType1(boolean plane1) {
					final Data_Player p2 = new Data_Player();
					p2.setPlane1(plane1);
					p2.update(context, objectid, new UpdateListener() {
						public void onSuccess() {
							
						}
						public void onFailure(int code, String msg) {
							
						}
					});
				}
				//更新飞机类型
				public void UpdateType2(boolean plane2) {
					final Data_Player p2 = new Data_Player();
					p2.setPlane2(plane2);
					p2.update(context, objectid, new UpdateListener() {
						public void onSuccess() {
						
						}
						public void onFailure(int code, String msg) {
					
						}
					});
				}
		//更新金币
		public void UpdateGoldCoin(Integer goldcoin) {
			final Data_Player p2 = new Data_Player();
			p2.setGoldCoin(goldcoin);
			p2.update(context, objectid, new UpdateListener() {
				public void onSuccess() {
					
				}
				public void onFailure(int code, String msg) {
				
				}
			});
		}
		//更新特效1
		public void UpdateEffect1(int effect1) {
			final Data_Player p2 = new Data_Player();
			p2.setEffect1(effect1);
			p2.update(context, objectid, new UpdateListener() {
				public void onSuccess() {
					
				}
				public void onFailure(int code, String msg) {
					
				}
			});
		}
		//更新特效2
				public void UpdateEffect2(int effect2) {
					final Data_Player p2 = new Data_Player();
					p2.setEffect2(effect2);
					p2.update(context, objectid, new UpdateListener() {
						public void onSuccess() {
					
						}
						public void onFailure(int code, String msg) {
						
						}
					});
				}
		//设置飞机1
				public void UpdatePlane1(boolean plane1) {
					final Data_Player p2 = new Data_Player();
					p2.setPlane1(plane1);
					p2.update(context, objectid, new UpdateListener() {
						public void onSuccess() {
							
						}
						public void onFailure(int code, String msg) {
						
						}
					});
				}
				//设置飞机2
				public void UpdatePlane2(boolean plane2) {
					final Data_Player p2 = new Data_Player();
					p2.setPlane2(plane2);
					p2.update(context, objectid, new UpdateListener() {
						public void onSuccess() {
						
						}
						public void onFailure(int code, String msg) {
				
						}
					});
				}	
		//查询objectid
		public void query_objectid(){
			BmobQuery<Data_Player> bmobQuery = new BmobQuery<Data_Player>();
			bmobQuery.addWhereEqualTo("mac", mac);
			bmobQuery.findObjects(context, new FindListener<Data_Player>() {
				public void onSuccess(List<Data_Player> objects) {
					if(objects!=null && objects.size()>0){
						Data_Player object = objects.get(0);
						objectid =object.getObjectId();
					
					}
				}
				public void onError(int code, String arg0) {
			
				}
			});
		}
	//查询所有
	public void query_player(){
		if(mac!=null)
		{  
			insert_player();
			BmobQuery<Data_Player> bmobQuery = new BmobQuery<Data_Player>();
			bmobQuery.addWhereEqualTo("mac",mac);
			bmobQuery.findObjects(context, new FindListener<Data_Player>() {
				public void onSuccess(List<Data_Player> objects) {
					if(objects!=null && objects.size()>0){
						Data_Player object = objects.get(0);
						objectid =object.getObjectId();
						mac =object.getMac();
						goldcoin=object.getGoldCoin();
						plane1=object.isPlane1();
						plane2=object.isPlane2();
						effect1=object.getEffect1();
						effect2=object.getEffect2();
								
					}
				}
				public void onError(int code, String arg0) {
				
				}
			});
		}
		if(mac==null)
		{
			 //数据读取
			SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
	        is_player=prefs.getBoolean("is_player",false);//读取是否有值，有则不存储，没有则重新创建
	        goldcoin =prefs.getInt("goldcoin",0);
	        plane1 =prefs.getBoolean("plane1",false);
	    	plane2=prefs.getBoolean("plane2",false);
	    	effect1=prefs.getInt("effect1",0);
	    	effect2=prefs.getInt("effect2",0);
		
	    	if(!is_player)
        	{
	    		insert_player();
        	}
		}
		
	}

}
