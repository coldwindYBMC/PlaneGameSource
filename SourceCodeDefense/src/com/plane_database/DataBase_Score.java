package com.plane_database;
import java.util.Date;
import java.util.List;
import com.plane_activity.MainActivity;
import com.plane_test.GamingPlaneTest;
import com.plane_test.GamingPlayer;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
public class DataBase_Score  {
	public static String objectId="";
	/**
	 * 插入对象
	 */
	 Context context;
	 String mac ;
	 int mark;
	 int hurt;
	 int kill;
	 int gold;
	 int type;
	 public DataBase_Score(Context context)
	 {
		 this.context=context;
		 mac =MainActivity.mac;
		 mark=GamingPlaneTest.mark;
		 hurt=GamingPlaneTest.hurt;
		 kill=GamingPlaneTest.kill;
		 gold=mark/1000;
		 type=GamingPlayer.type;
	 }
	public void insert_score() {
		final Data_Score p2 = new Data_Score();
		p2.setMac(mac);
		p2.setMaxscore(mark);
		p2.setHurt(hurt);
		p2.setKill(kill);
		p2.setGold(gold);
		p2.setType(type);
		p2.setUploadTime(new BmobDate(new Date()));
		p2.save(context, new SaveListener() {
			public void onSuccess() {
				objectId = p2.getObjectId();
				toast("创建数据成功：" + p2.getObjectId());
				Log.d("bmob", "objectId = " + p2.getObjectId());
				Log.d("bmob", "gender =" + p2.isGender());
				Log.d("bmob", "createAt = " + p2.getCreatedAt());
			}
			@Override
			public void onFailure(int code, String msg) {
				toast("创建数据失败：" + msg);
			}
		});
	}
		public void toast(String msg){
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}
	public void query_player(){
		BmobQuery<Data_Score> bmobQuery = new BmobQuery<Data_Score>();
		bmobQuery.addWhereEqualTo("mac", mac);
		bmobQuery.findObjects(context, new FindListener<Data_Score>() {
			public void onSuccess(List<Data_Score> objects) {
				if(objects!=null && objects.size()>0){
					Data_Score object = objects.get(0);
					toast("查询成功："+object.getMac());
				}
			}
			public void onError(int code, String arg0) {
				toast("查询失败："+arg0);
			}

		});
	}

}
