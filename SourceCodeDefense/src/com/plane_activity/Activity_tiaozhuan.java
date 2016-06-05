package com.plane_activity;
import com.plane_test.GamingPlaneTest;
import com.plane_test.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
public class Activity_tiaozhuan extends Activity {
    public static Activity_tiaozhuan instance;
    GamingPlaneTest game; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        //setVolumeControlStream(AudioManager.STREAM_MUSIC);   
        getWindow().setBackgroundDrawableResource(R.drawable.back_bg);
       // mediaplayer=MediaPlayer.create(this,R.raw.zhuxuanlv)
        //instance = this;
       // getWindow().setBackgroundDrawableResource(R.drawable.feiji_background);
        try
        
        {   
        	game = new GamingPlaneTest (this);
        	//System.out.print("1111");
        	//AssetManager assetManager=getAssets();   
           // System.out.println(getAssets().list("").toString());
            //System.out.print("1111");
        	//AssetFileDescriptor descriptor = assetManager.openFd(R.raw.zhuxuanlv);
        	//mediaplayer.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());        	
        	//mediaplayer.prepare();
        	//mediaplayer.setLooping(true);
        	//mediaplayer.start();
        	
        	
        	//mediaplayer.prepare();
        	//mediaplayer.start();
        }
        catch(Exception e)
        {
        System.out.println("错误信息");
        e.printStackTrace();
        }
         	setContentView(game);
    }
	protected void dialog() {
		  AlertDialog.Builder builder = new Builder(Activity_tiaozhuan.this);
		  builder.setMessage("确认退出吗？");

		  builder.setTitle("提示");

		  builder.setPositiveButton("确认", new OnClickListener() {

		   @Override
		   public void onClick(DialogInterface dialog, int which) {
		    dialog.dismiss();

		    Activity_tiaozhuan.this.finish();
		   }
		  });

		  builder.setNegativeButton("取消", new OnClickListener() {

		   @Override
		public void onClick(DialogInterface dialog, int which) {
		    dialog.dismiss();
		   }
		  });

		  builder.create().show();
		 }	
}
