package com.plane_activity;
import java.util.Timer;
import java.util.TimerTask;
import com.plane_test.R;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
public class Activity_donghua extends Activity {
	private ImageView ams_xingxing = null;
	//private ImageView player = null;
	MediaPlayer mediaplayer;
	int explo = -1;
    public static Activity_donghua instance; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2); 
        mediaplayer = MediaPlayer.create(this,R.raw.effcet_loading);
		mediaplayer.setLooping(false);
		mediaplayer.start();
        ams_xingxing = (ImageView) findViewById(R.id.imageView1);
      //  player = (ImageView) findViewById(R.id.imageView1);
        //getWindow().setBackgroundDrawableResource(R.drawable.back);
        final Intent it = new Intent(Activity_donghua.this, Activity_tiaozhuan.class); //你要转向的Activity  
     // 使用AnimationUtils装载动画配置文件
        Animation animation = AnimationUtils.loadAnimation(Activity_donghua.this, R.anim.alpha);
        // 启动动画
        ams_xingxing.startAnimation(animation);
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation =  new TranslateAnimation(
               Animation.RELATIVE_TO_SELF,0f,
               Animation.RELATIVE_TO_SELF,8f,
               Animation.RELATIVE_TO_SELF,0f,
               Animation.RELATIVE_TO_SELF,0.1f);
        translateAnimation.setDuration(4000);
        animationSet.addAnimation(translateAnimation);
     //   player.startAnimation(animationSet);
        translateAnimation.setFillAfter(true);
        //如果fillAfter的值为true,则动画执行后，控件将停留在执行结束的状态 
        Timer timer = new Timer(); 
        TimerTask task = new TimerTask() {  
    @Override  
    	public void run() {   
    		startActivity(it); //执行  
    		Activity_donghua.this.finish();
     		} 
        };

        timer.schedule(task, 1000 * 3); //10秒后
    }

	
	
}
