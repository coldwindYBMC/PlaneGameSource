package com.plane_test;
import java.util.Random;
import java.util.Vector;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

import java.util.HashMap;

import com.plane_activity.MainActivity;
import com.plane_database.DataBase_Player;
import com.plane_state.Game_state1;
import com.plane_state.Game_state2;
import com.plane_state.Game_state3;
import com.plane_state.Game_state4;
import com.plane_state.Game_state5;
import com.plane_state.Game_state6;
import com.plane_state.Game_state7;
import com.plane_state.Game_state8;
import com.plane_state.Game_state9;
import com.plane_ui.GameLoading;
import com.plane_ui.GameMenu;
import com.plane_ui.Game_Lost;
import com.plane_ui.Game_NoMoney;
import com.plane_ui.Game_Querengoumai;
import com.plane_ui.Game_SelectPlane;
import com.plane_ui.Game_Shop;
import com.plane_ui.Game_Win;
import com.plane_ui.Game_exit;
import com.plane_ui.Game_jiesuan;
import com.plane_ui.Game_juqing;
import com.plane_ui.Game_shezhi;
import com.plane_ui.Gaming_exit;
@SuppressLint("NewApi") 
public class GamingPlaneTest extends SurfaceView implements Callback, Runnable {
	private SurfaceHolder sfh;
	private Paint paint;
	private Paint mpaint;
	private  int  pointX1;
	private Thread th;
	private boolean flag;
	private Canvas canvas;
	//战机加载判断
	private int sp1=0;
	public static int hurt=0,kill=0,gold=0;
	//剧情模式变量
	private int z;
	public static int screenW, screenH;
	//积分
	public static int mark=0;
	//声音开关
	public static boolean isSound;
	//震动时长
	long [] pattern = {100,400,100,400};	
	private boolean is_plane1,is_plane2,is_plane3,is_plane4,is_plane5;
	//定义游戏状态常量
	public static final int GAME_MENU = 0;//游戏菜单
	public static final int GAME_MENU1 = 99;//游戏菜单1
	public static final int GAMEING = 1;//游戏中
	public static final int GAME_WIN = 2;//游戏胜利
	public static final int GAME_LOST = 3;//游戏失败
	public static final int GAME_JIESUAN = 4;//结算页面
	public static final int GAME_SHOP_DAOJU = 5;//商店道具
	public static final int GAME_SHOP_FEIJI = 6;//商店飞机
	public static final int GAME_SHOP_XUNBAO =7;//商店寻宝
	public static final int GAME_SHOP_XUNBAOS =8;//商店寻宝
	public static final int GAME_SHOP_QUEREN =31;//商店确认
	public static final int GAME_SHOP_NOMONEY =32;//商店金钱不足
	public static final int GAME_SELECTPLANE1 = 15;//战机切换
	public static final int GAME_SELECTPLANE2 = 16;//战机切换
	public static final int GAME_SELECTPLANE3 = 17;//战机切换
	public static final int GAME_SELECTPLANE4 = 18;//战机切换
	public static final int GAME_SELECTPLANE5 = 19;//战机切换
	public static final int GAME_PAUSE = -1;//游戏暂停
	public static final int GAME_EXIT = 9;//退出界面
	public static final int GAMEING_EXIT = 10;//you游戏中的退出界面
	public static final int GAME_STATE1 = 21;//关卡一
	public static final int GAME_STATE2 = 22;//关卡一
	public static final int GAME_STATE3 = 23;//关卡一
	public static final int GAME_STATE4 = 24;//关卡一
	public static final int GAME_STATE5 = 25;//关卡一
	public static final int GAME_STATE6 = 26;//关卡一
	public static final int GAME_STATE7 = 27;//关卡一
	public static final int GAME_STATE8 = 28;//关卡一
	public static final int GAME_STATE9 = 29;//关卡一
	public static boolean state1;
	public static boolean state3;
	public static boolean state4;
	public static boolean state5;
	public static boolean state6;
	public static boolean state7;
	public static boolean state8;
	public static boolean state9;
	public static final int GAME_STATE_DIALOG2 = 302;
	public static final int GAME_STATE_DIALOG3 = 303;
	public static final int GAME_STATE_DIALOG4 = 304;
	public static final int GAME_STATE_DIALOG5 = 305;
	public static final int GAME_STATE_DIALOG6 = 306;
	public static final int GAME_STATE_DIALOG7 = 307;
	public static final int GAME_STATE_DIALOG8 = 308;
	public static final int GAME_STATE_DIALOG9 = 309;
	public static final int GAME_SHEZHI = 40;//设置界面
	public static final int GAME_SHEZHI_BANGZHU = 41;//设置帮组界面
	public static final int GAME_SHEZHI_GUANYU = 42;//设置关于界面
	public static final int GAME_SHEZHI_SHENGMING = 43;//设置声明界面
	public static final int GAME_LOADING1 = 51;
	
	public static final int GAME_JUQING = 60;//剧情按钮的背景
	public static final int GAME_JUQING_STORY1 = 62;//剧情故事1
	public static final int GAME_JUQING_STORY2 = 63;//剧情故事2
	public static final int GAME_JUQING_STORY3 = 64;//剧情故事3
	public static final int GAME_JUQING_STORY4 = 65;//剧情故事4
	public static final int GAME_JUQING_STORY5 = 66;//剧情故事5
	public static final int GAME_JUQING_STORY6 = 67;//剧情故事6
	public static final int GAME_JUQING_STORY7 = 68;//剧情故事7
	public static final int GAME_JUQING_STORY8 = 69;//剧情故事8
	public static final int GAME_JUQING_STORY9 = 70;//剧情故事9
	public static final int GAME_JUQING_STORY10 = 71;//剧情故事10
	public static final int GAME_JUQING_STORY11 = 72;//剧情故事11
	public static final int GAME_JUQING_STORY12 = 73;//剧情故事12
	public static final int GAME_JUQING_STORY13 = 74;//剧情故事13
	public static final int GAME_JUQING_STORY14 = 75;//剧情故事14
	public static final int GAME_JUQING_STORY15 = 76;//剧情故事15
	//当前游戏状态(默认初始在游戏菜单界面)
	public static int gameState = GAME_MENU;
	//子弹等级
	public static int bulletlv=1;
	//剧情模式数据判断
	public static int k=0;
	private int bcount=0;
	//声明一个Resources实例便于加载图片
	 Resources res = this.getResources();
	//声明游戏需要用到的图片资源(图片声明)
	 public static Bitmap jsm;
	 private GamingBaoXian bx;
	 public static Bitmap coinb;
	private Bitmap BackGround;//游戏背景
	static Bitmap Boom;//爆炸效果
	static Bitmap BoosBoom;//Boos爆炸效果
	private Bitmap EnemyF2;//怪物鸭子
	private Bitmap Enemy4;//飞机1
	private Bitmap EnemyF1;//飞机1
	private Bitmap Enemyzisa;
	private Bitmap EnemyBoos;//Boos
	private Bitmap EnemyBoos2;//boss2
	private Bitmap EnemyBoos1;//boss2
	private Bitmap EnemyBoos3;//boss2
	static Bitmap waring;//预警
	static Bitmap zidan6;
	private static Bitmap zidan10;
	private Bitmap jiguang;
	private Bitmap pause;
	static Bitmap bx1;
	static Bitmap bx2;
	static Bitmap bxb;
	static Bitmap cn;
	public static Bitmap Player;//文奇
	public static  Bitmap Player1;//钟声
	public static Bitmap Player2;//欣桐
	public static Bitmap Player3;//宇航
	public static Bitmap Player5;//文琪
	public static Bitmap PlayerHp;//主角飞机血量
	public static Bitmap PlayerHp0;//主角飞机血量
	public static Bitmap PlayerHp1;//主角飞机血量
	public static Bitmap PlayerHp2;//主角飞机血量
	public static Bitmap PlayerHp3;//主角飞机血量
	public static Bitmap PlayerHp4;//主角飞机血量
	public static Bitmap PlayerHp5;//主角飞机血量
	static Bitmap zhidan1;//敌机子弹
	static Bitmap zhidan2;//敌机导弹
	static Bitmap zhidan5;//敌机子弹
	static Bitmap zidanb2;
	static Bitmap zidanb6;
	static Bitmap zidanb7;
	static Bitmap zidanb9;
	static Bitmap zidan8;
	static Bitmap zidan7;
	static Bitmap zidan11;
	static Bitmap zidan12;
	static Bitmap baozazidan;
	public static Bitmap zhidan3;//敌机子弹3
	public static Bitmap bdd;//boss导弹
	private  Bitmap Bulletp1;//子弹
	private  Bitmap Bullet1;//子弹导弹
	public static  Bitmap Bullet2;//子弹激光
	public static Bitmap BossBullet;//Boss子弹
	private  Bitmap Buff;  //子弹升级buff
	private  Bitmap Buff2; //主机回血buff
	private Bitmap Buff3;//护盾buff
	private Bitmap button_jingdian;////经典模式
	private Bitmap button_juqing;//剧情模式
	private Bitmap juqing_guanqia;//ju剧情模式的关卡图片
	private Bitmap juqing_tongguo;//ju剧情模式的通过
	private Bitmap juqing_state1_dialog;//关卡一
	private Bitmap juqing_state2_dialog;//关卡二
	private Bitmap juqing_state3_dialog;//关卡三
	private Bitmap juqing_state4_dialog;//关卡四
	private Bitmap juqing_state5_dialog;//关卡五
	private Bitmap juqing_state6_dialog;//关卡六
	private Bitmap juqing_state7_dialog;//关卡七
	private Bitmap juqing_state8_dialog;//关卡八
	private Bitmap juqing_state9_dialog;//关卡九
	//关卡一的对话
	private Bitmap juqing_state_dialog1;
	private Bitmap juqing_state_dialog2;
	private Bitmap juqing_state_dialog3;
	private Bitmap juqing_state_dialog4;
	private Bitmap juqing_state_dialog5;
	private Bitmap juqing_state_dialog6;
	private Bitmap juqing_state_dialog7;
	private Bitmap juqing_state_dialog8;
	private Bitmap juqing_state_dialog9;
	private Bitmap button_shangdian;
	private Bitmap button_shezhi;//设置按钮
	private Bitmap button_wujin;//无尽模式
	public static Bitmap button_zhanjiqiehuan;//战机切换
	private Bitmap button_jingdian_press;////经典模式按下去
	private Bitmap button_juqing_press;//剧情模式按钮按下去
	private Bitmap button_wujin_press;//无尽模式按钮按下去
	private Bitmap ams_xingxing;//星星
	private Bitmap tuichu;//推出界面
	private Bitmap tuichu_queding;//退出确定
	private Bitmap tuichu_quxiao;//退出取消
	private Bitmap gameing_back;//推出界面
	//游戏中退出界面的控件
	private Bitmap button_continue;
	private Bitmap button_back_menu;
	//设置界面中的图片
	private Bitmap shezhi_fanhui;
	private Bitmap shezhi_guanyu;
	private Bitmap shezhi_bangzhu;
	private Bitmap shezhi_shengming;
	private Bitmap shezhi_mengban;
	private Bitmap shezhi_fanhui_press;
	private Bitmap shezhi_duihao;
	//分数
	private Bitmap score;//分数计算
	public static  Bitmap score1;
	public static Bitmap score2;
	public static Bitmap score3;
	public static Bitmap score4;
	public static Bitmap score5;
	public static Bitmap score6;
	public static Bitmap score7;
	public static Bitmap score8;
	public static Bitmap score9;
	public static Bitmap score10;
	public static Bitmap score11;
	public static Bitmap score_fenshu;
	
	//进度的页面
	private Bitmap jindu1;
	//y游戏界面的重力图片
	private Bitmap lock_zhongli;
	//结算界面
	private Bitmap jiesuan_again;
	private Bitmap jiesuan_again_press;
	private Bitmap jiesuan_back;
	private Bitmap jiesuan_back_press;
    private Bitmap jiesuan_mengban;
	//胜利和失败界面
	private Bitmap juqing_game_win;
	private Bitmap juqing_game_lost;
	//战机切换界面
	private Bitmap plane_anyeleiting;
	private Bitmap plane_anyeyingxue;
	private Bitmap plane_huangjinzhanjia;
	private Bitmap plane_lengyanhanfeng;
	private Bitmap plane_moshangyanyun;
	private Bitmap button_houtui;
	private Bitmap button_houtui_press;
	private Bitmap button_qianjin;
	private Bitmap button_qianjin_press;
	//商店
	private Bitmap shop_daoju;
	private Bitmap shop_shangpin;
	private Bitmap shop_queren;
	private Bitmap shop_nomoney;
	private Bitmap shop_nobuy;
	private Bitmap shop_buy;
	private Bitmap shop_mengban;
	private Bitmap shop_xunbao;
	//声明一个菜单对象
	private GameMenu gameMenu;
	
	private Bitmap boss6;
	//声明一个退出界面
	private Game_exit game_exit;
	private Gaming_exit gaming_exit;
	//声明一个进度条界面
	private GameLoading gameloading;
	//剧情模式页面
	private Game_juqing game_juqing;
	private static Game_state1 game_state1;//第一关
	private static Game_state2 game_state2;//第二关
	private static Game_state3 game_state3;//第三关
	private static Game_state4 game_state4;//第四关
	private static Game_state5 game_state5;//第五关
	private static Game_state6 game_state6;//第六关
	private static Game_state7 game_state7;//第七关
	private static Game_state8 game_state8;//第八关
	private static Game_state9 game_state9;//第九关
	//声明一个滚动游戏背景对象
	private GameingBg backGround;
	private Gameing_button gameb;
	//s设置界面
	private Game_shezhi game_shezhi;
	//计算
	private GamingNum_cal num_cal;
	public static GamingJsNum jsnum;
	//结算
	private Game_jiesuan game_jiesuan;
	//胜利界面
	private Game_Win game_win;
	//失败界面
	private Game_Lost game_lost;
	//战机切换
	private Game_SelectPlane game_selectplane;
	//商店
	private Game_Shop game_shop;
	private Game_Querengoumai game_querengoumai;
	private Game_NoMoney game_nomoney;
	//声明主角对象
	public static GamingPlayer player;
	// 声明敌机
	private GamingEnemy enemy;
	//声明一个敌机容器
	public static Vector<GamingEnemy> vcEnemy;
	// 声明一个buff容器
	public static Vector<GamingBuff> vcBuff;
	//每次生成敌机的时间(毫秒)
	private int createEnemyTime =100;
	private int count;//计数器
	private int count1;//计数器
	public static int lv=1;
	//敌人数组：1和2表示敌机的种类，-1表示Boss
	//二维数组的每一维都是一组怪物
	private int enemyArray[][] = {{2,2,1,5,5,7,5,5,5}, {1,2,3,6,7} ,{7,7,4,4,1,1},{5,5,5,7,7,7,6,6},{6,6,7,7},{4,4,7,7},{ -2 },
		{2,2},{2,1,1,2,2,1},{2,2,1,5,5,7,5,7,5},{7,7,4,4,1,1},{1,1,2,2,1,1,5,5,5},{6,6,4,2,1,2,3},{-2},
		{7,7,4,4,1,1},{1,1,2,1},{2,1,1,2,2,1},{3,2,1},{1,1,5,5},{1,1,2,2,1,1,5,5,5},{1,2,2,4,5,2,1,2,6,},{-4},
		{2,1,2}, {6,7},{2,1,1,2,2,1},{5,5,5,7,7,7,6,6},{7,7,4,4,1,1}, {6,3,2,5,7} ,{4,2,1,5,7,5,3,2},{-2},
		{7,7,4,4,1,1},{5,5,5,7,7,7,6,6},{5,5,5,7,7,7,6,6},{7,7,4,4,1,1}, {6,3,2,5,7} ,{6,7,3,2,1,3,5},{-3},
		{1,1,2,2,1,1,5,5,5},{5,5,5,7,7,7,6,6},{5,5,5,7,7,7,6,6},{1,1,2,2,1,1,5,5,5},{7,7,4,4,1,1},{2,4,7,4,2,1,3,5,6,2},{-4},
		{1,1,2,1},{2,1,1,2,2,1},{3,2,1},{1,1,5,5},{1,1,2,2,1,1,5,5,5},{1,1,1},{2,2},{2,2}, { 2, 1,2 },{2,1,1,2,2,1},{2,2},{1,1,2,1},{2,1,1,2,5,2,1},{4,4,4,4,7,7,7,7},{-4},
		{2,1,2},{1,2,3,4,5,6,7},{3,3,3,5,6,7,4,}, {6,7},{2,1,1,2,2,1},{5,5,5,7,7,7,6,6},{7,7,7,7,6,6,6,6,},{7,7,4,4,1,1},{-5},{0}};
	//剧情模式 boss数组
	private int bossArray[][]={{-1,-2,-3,0},{-2,-3,-2,0},{-1,-4,-2,-3,0},{-3,-2,-3,0},{-1,-4,-3,0},{-2,-3,-4,0},{-3,-1,-4,-5,0},{-3,-2,-5,0},{-3,-2,-5,-4,-5,0}};
	//当前取出一维数组的下标
	public static int enemyArrayIndex;
	//当前取出一维数组的下标  剧情
	public static int bossArrayIndex;
	//是否出现Boss标识位
	public static boolean isBoss;
	private Random random;
	//敌机子弹容器
	public static Vector<GamingBullet> vcBullet;
	//添加子弹的计数器
	private int countEnemyBullet;
	//主角子弹容器
	public static Vector<GamingBullet> vcBulletPlayer;
	//添加子弹的计数器
	static int countPlayerBullet;
	//爆炸效果容器
	static Vector<GamingBoom> vcBoom;
	//声明Boss
	private GamingBoss boss;
	//生命buff
	private GamingBuff buff;
	
	private int test_W;
	private int test_H;
	public static float scaleWidth;//比例
	public static float scaleHeight;//比例
	//Boss的子弹容器
	public static Vector<GamingBullet> vcBulletBoss;
    public static MediaPlayer mediaplayer; 
	//static MediaPlayer mediaplayer1; 
	//static MediaPlayer mediaplayer2; 
	public static MediaPlayer mediaplayer2; 
	public static MediaPlayer mediaplayer3; 
	public static MediaPlayer mediaplayer4; 
	SoundPool soundPool;//声音
	HashMap<Integer, Integer> soundPoolMap; 
	Context context;
	private int mProgress=0;
	private int mProgressBar = 0; 
	/**
	 * SurfaceView初始化函数
	 */
	public GamingPlaneTest(Context context) {
		super(context);
		this.context=context;
		sfh = this.getHolder();
		sfh.addCallback(this);
		  //数据读取
		SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
		isSound =prefs.getBoolean("isSound",true);//设置音乐开关
		paint = new Paint();
		mpaint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
		mpaint.setColor(Color.RED);
		mpaint.setTextSize(24);
		setFocusable(true);
		setFocusableInTouchMode(true);
		//设置背景常亮
		this.setKeepScreenOn(true);
		//设置背景透明
		setZOrderOnTop(true);
		//固定用法，背景透明
		getHolder().setFormat(PixelFormat.TRANSLUCENT);
		mediaplayer = MediaPlayer.create(context,R.raw.bgm_zhuxuanlv);
		mediaplayer.setLooping(true);
		mediaplayer2 = MediaPlayer.create(context,R.raw.ananniu);
		mediaplayer2.setLooping(false);
		mediaplayer2.setVolume((float) 0.7,(float) 0.7);
		mediaplayer3 = MediaPlayer.create(context,R.raw.fanhui);
		mediaplayer3.setLooping(false);
		mediaplayer3.setVolume((float) 0.7,(float) 0.7);
		mediaplayer4 = MediaPlayer.create(context,R.raw.bgm_juqingduihua);
		mediaplayer4.setLooping(true);
		mediaplayer4.setVolume((float) 0.7,(float) 0.7);
	}
	/**
	 * SurfaceView视图创建，响应此函数
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		screenW = this.getWidth();
		screenH = this.getHeight();
		initSounds();
		load();
		test_H = juqing_game_win.getHeight();//图片的高度
	    test_W = juqing_game_win.getWidth();//图片的宽度
		scaleWidth = ((float) screenW) /test_W;//比例，宽度
	    scaleHeight = ((float) screenH ) /test_H;//比例高度
	    //把值传给每一个界面	   
	    GameMenu.scaleWidth=scaleWidth;
	    GameMenu.scaleHeight=scaleHeight;
		flag = true;
		//实例线程
		th = new Thread(this);
		//启动线程
		th.start();    
	}
	/*
	 *TODO 自定义的游戏初始化函数
	 */
	private void load() {
		//放置游戏切入后台重新进入游戏时，游戏被重置!
		//当游戏状态处于菜单时，才会重置游戏		
			//游戏界面中的按钮
		   
		    PlayerHp = BitmapFactory.decodeResource(res, R.drawable.hp);	
		    Player = BitmapFactory.decodeResource(res, R.drawable.player);
			Player1= BitmapFactory.decodeResource(res, R.drawable.player1);
			Player2 = BitmapFactory.decodeResource(res, R.drawable.player3);
			Player3= BitmapFactory.decodeResource(res, R.drawable.player2);
			Player5= BitmapFactory.decodeResource(res, R.drawable.player5);
		//////////////////////////////////////// 
			
			ams_xingxing=BitmapFactory.decodeResource(res, R.drawable.ams_xingxing);
			button_shangdian=BitmapFactory.decodeResource(res, R.drawable.button_shangdian);
			button_juqing = BitmapFactory.decodeResource(res, R.drawable.button_juqing);
			button_wujin = BitmapFactory.decodeResource(res, R.drawable.button_wujin);
			button_shezhi = BitmapFactory.decodeResource(res, R.drawable.button_shezhi);
		
			button_zhanjiqiehuan = BitmapFactory.decodeResource(res, R.drawable.button_qiehuan);
			button_jingdian = BitmapFactory.decodeResource(res, R.drawable.button_jingdian);
			 //按下的
			button_juqing_press = BitmapFactory.decodeResource(res, R.drawable.button_juqing_press);
			//剧情模式关卡			
			button_wujin_press = BitmapFactory.decodeResource(res, R.drawable.button_wujin_press);
			button_jingdian_press=BitmapFactory.decodeResource(res, R.drawable.button_jingdian_press);
			//退出界面，以及他们的按钮
			tuichu_queding=BitmapFactory.decodeResource(res, R.drawable.tuichu_queding);
			tuichu_quxiao=BitmapFactory.decodeResource(res, R.drawable.tuichu_quxiao);
            jsm=BitmapFactory.decodeResource(res, R.drawable.jsm);
			//进度页面
			jindu1=BitmapFactory.decodeResource(res, R.drawable.jindu1);
			shezhi_fanhui=BitmapFactory.decodeResource(res, R.drawable.shezhi_fanhui);
			shezhi_fanhui_press=BitmapFactory.decodeResource(res, R.drawable.shezhi_fanhui_press);
			//剧情
			juqing_guanqia=BitmapFactory.decodeResource(res, R.drawable.juqing_guanqia);
			juqing_tongguo=BitmapFactory.decodeResource(res, R.drawable.juqing_tongguo);
			juqing_state1_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state1_dialog);
			
			//设置界面
			shezhi_guanyu=BitmapFactory.decodeResource(res, R.drawable.shezhi_guanyu);
			shezhi_shengming=BitmapFactory.decodeResource(res, R.drawable.shezhi_shengming);
			shezhi_bangzhu=BitmapFactory.decodeResource(res, R.drawable.shezhi_bangzhu);
			shezhi_mengban=BitmapFactory.decodeResource(res, R.drawable.shezhi_mengban);
			shezhi_duihao=BitmapFactory.decodeResource(res, R.drawable.shezhi_duihao);
			//设置中的帮助界面
			coinb=BitmapFactory.decodeResource(res, R.drawable.coinb);	
			//游戏胜利界面
			juqing_game_win =BitmapFactory.decodeResource(res, R.drawable.game_win);	
			//主界面
			gameMenu = new GameMenu(ams_xingxing,button_jingdian,button_juqing,button_shezhi,button_wujin,
					button_zhanjiqiehuan,
					button_jingdian_press,button_juqing_press,button_wujin_press,button_shangdian,context);
			//设置
			game_shezhi = new Game_shezhi(shezhi_fanhui,shezhi_guanyu,shezhi_bangzhu,
					shezhi_shengming,shezhi_mengban,shezhi_fanhui_press,shezhi_duihao,context);
			//结算界面
			 gameloading =new GameLoading(jindu1,context);
	}
	  public void Loading() throws InterruptedException {
	    switch (mProgress) {
		case 0:
			//加载游戏资源
			vcEnemy = new Vector<GamingEnemy>();
			//实例随机库
			random = new Random();
			//---Boss相关
			//实例boss对象
			//boss = new Boss(EnemyBoos);			
			//实例Boss子弹容器
			vcBulletBoss = new Vector<GamingBullet>();
			//爆炸效果容器实例
			vcBoom = new Vector<GamingBoom>();
			//敌机子弹容器实例
			vcBullet = new Vector<GamingBullet>();
			//主角子弹容器实例
			vcBulletPlayer = new Vector<GamingBullet>();    
			// buff 容器
			vcBuff = new  Vector<GamingBuff>();
		    break;
		case 1:
			 Boom = BitmapFactory.decodeResource(res, R.drawable.boom);		
			 BoosBoom = BitmapFactory.decodeResource(res, R.drawable.boos_boom);
			 EnemyF2= BitmapFactory.decodeResource(res, R.drawable.enemy2);
			 Enemy4= BitmapFactory.decodeResource(res, R.drawable.enemy4);
			 EnemyF1 = BitmapFactory.decodeResource(res, R.drawable.enemy1);
			 Enemyzisa=BitmapFactory.decodeResource(res, R.drawable.enemyzisa);
			
			 baozazidan= BitmapFactory.decodeResource(res, R.drawable.baozazidan);
		    break;
		case 2:
		
			//jiguang= BitmapFactory.decodeResource(res, R.drawable.jiguang);
		
		    Buff=BitmapFactory.decodeResource(res, R.drawable.buff);
		    Buff2=BitmapFactory.decodeResource(res, R.drawable.buff2);
		    Buff3=BitmapFactory.decodeResource(res, R.drawable.buff3);	   
		    zhidan1=BitmapFactory.decodeResource(res, R.drawable.zidan1);
		    jiguang=BitmapFactory.decodeResource(res, R.drawable.jiguang);
		   // zhidan2=BitmapFactory.decodeResource(res, R.drawable.zidan2);
		    break;
		case 3:
			 zhidan3=BitmapFactory.decodeResource(res, R.drawable.zidan3);	   
			 zhidan5=BitmapFactory.decodeResource(res, R.drawable.zidan5);
			 zidan10=BitmapFactory.decodeResource(res, R.drawable.zidan10);//雪球
			 zidan11=BitmapFactory.decodeResource(res, R.drawable.zidan11);
			 Bulletp1=BitmapFactory.decodeResource(res, R.drawable.zidanp1);
			 zidan12=BitmapFactory.decodeResource(res, R.drawable.zidan12);
		    break;
		case 4:
			   zidanb6=BitmapFactory.decodeResource(res, R.drawable.zidanb6);
			    zidanb7=BitmapFactory.decodeResource(res, R.drawable.zidanb7);
			    zidanb9=BitmapFactory.decodeResource(res, R.drawable.zidanb9);
			  //  zidan7=BitmapFactory.decodeResource(res, R.drawable.zidan7);
			    zidanb2=BitmapFactory.decodeResource(res, R.drawable.zidanb2);
			  
		    break;
		case 5:

		    //  BOSS导弹
		    bdd=BitmapFactory.decodeResource(res, R.drawable.daodan2);        
		    Bullet1= BitmapFactory.decodeResource(res, R.drawable.bullet1);
		    Bullet2= BitmapFactory.decodeResource(res, R.drawable.bullet3);	   
			//BitmapFactory.decodeResource(res, R.drawable.zidane1);
			//BossBullet = BitmapFactory.decodeResource(res, R.drawable.boosbullet);
		    bxb= BitmapFactory.decodeResource(res, R.drawable.bxb);
		    break;
		case 6:	
			EnemyBoos1 = BitmapFactory.decodeResource(res, R.drawable.boss1);
			 EnemyBoos = BitmapFactory.decodeResource(res, R.drawable.boss0);
			EnemyBoos2= BitmapFactory.decodeResource(res, R.drawable.boss2);
			EnemyBoos3= BitmapFactory.decodeResource(res, R.drawable.boss3);
			boss6= BitmapFactory.decodeResource(res, R.drawable.boss6);
		    break;
		case 7:
			  BackGround = BitmapFactory.decodeResource(res, R.drawable.background);
			  backGround = new GameingBg(BackGround,tuichu_queding);
			  bx1= BitmapFactory.decodeResource(res, R.drawable.bx1);
			  bx2= BitmapFactory.decodeResource(res, R.drawable.bx1);
			  cn=BitmapFactory.decodeResource(res, R.drawable.cn);
			  pause=BitmapFactory.decodeResource(res, R.drawable.pause);
			  lock_zhongli=BitmapFactory.decodeResource(res, R.drawable.zlsz);
			  gameb=new Gameing_button( lock_zhongli,pause) ;			
			  bx2=BitmapFactory.decodeResource(res, R.drawable.bx2);
			  bx=new GamingBaoXian(bx1,bx2,context);
		
		    break;
		case 8:	
			//失败界面
			juqing_game_lost =BitmapFactory.decodeResource(res, R.drawable.game_lost);
			//胜利和失败界面//结算
			jiesuan_again=BitmapFactory.decodeResource(res, R.drawable.jiesuan_again);
			jiesuan_again_press=BitmapFactory.decodeResource(res, R.drawable.jiesuan_again_press);
			jiesuan_back=BitmapFactory.decodeResource(res, R.drawable.jiesuan_back);
			jiesuan_back_press=BitmapFactory.decodeResource(res, R.drawable.jiesuan_back_press);
			jiesuan_mengban =BitmapFactory.decodeResource(res, R.drawable.jiesuan_mengban);
		    break;
		case 9:
			
			//分数计算
			score=BitmapFactory.decodeResource(res, R.drawable.score);
			score_fenshu=BitmapFactory.decodeResource(res, R.drawable.score_fenshu);
		    break;
		case 10:
			//游戏界面的重力校准按钮
		
		    break;
		case 11:
		    break;
		}
		mProgressBar = (100 / 12) * mProgress;
		mProgress++;
	    // 这里表示进度加载完成 
	    if (mProgressBar >= 100) {
		gameState=GAMEING;
	    }
	}
	//音乐
		public void initSounds(){
		     soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
		     soundPoolMap = new HashMap<Integer, Integer>();   
		     soundPoolMap.put(1, soundPool.load(getContext(), R.raw.effcet_sfx_dabaozha, 1));
		     soundPoolMap.put(3, soundPool.load(getContext(), R.raw.effcet_sfx_beiji, 1));
		     soundPoolMap.put(4, soundPool.load(getContext(), R.raw.effcet_sfx_siwang, 1));
		     soundPoolMap.put(5, soundPool.load(getContext(), R.raw.effcet_sfx_xiaobaozha, 1));
		     soundPoolMap.put(6, soundPool.load(getContext(), R.raw.effcet_sfx_zhongbaozha, 1));
		     soundPoolMap.put(7, soundPool.load(getContext(), R.raw.fanhui, 1));
		     soundPoolMap.put(8, soundPool.load(getContext(), R.raw.ananniu, 1)); 
		     soundPoolMap.put(9, soundPool.load(getContext(), R.raw.effcet_chizuanshi, 1)); 
		} 
		public  void playSound(int sound, int loop) {
		    AudioManager mgr = (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);   
		    float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);   
		    float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);       
		    float volume = streamVolumeCurrent / streamVolumeMax;      
		    if(isSound)
		    {
		    	soundPool.play(soundPoolMap.get(sound), volume, volume, 1, loop, 1f);
		    }  
		}
	/**
	 * TODO 游戏绘图
	 */
	public void myDraw() {
		try {
			canvas = sfh.lockCanvas();
			 //数据读取
			 Matrix matrix = new Matrix();
		     matrix.postScale(scaleWidth, scaleHeight);  
			SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
			if (canvas != null) {
				canvas.drawColor(Color.WHITE);
				//绘图函数根据游戏状态不同进行不同绘制
				switch (gameState) {
				//进度条
				case GAME_LOADING1:
					Loading() ;
					//进度条实例化
					game_jiesuan = new Game_jiesuan(jiesuan_again,jiesuan_again_press,jiesuan_back,
							jiesuan_back_press,jiesuan_mengban,context);  
					//胜利界面
					game_win = new Game_Win(juqing_game_win,jiesuan_again,jiesuan_again_press,jiesuan_back,
							jiesuan_back_press);
					//失败界面
					game_lost = new Game_Lost(juqing_game_lost,jiesuan_again,jiesuan_again_press,jiesuan_back,
							jiesuan_back_press);
					 
					if(isSound)
					{    try
					  {
						 mediaplayer.pause();
					  }catch(Exception e){}
					 try
						{
							mediaplayer4.pause();
						}catch(Exception e){}
					
					}			
					  canvas.drawColor(Color.BLACK);
				
					  gameloading.draw1(canvas, paint);
					  GameLoading.frameindex++;
					  if( GameLoading.frameindex>=6)
					  {
						  GameLoading.frameindex=1;
					  }
				    
				break;	
				
				case GAME_MENU:
	
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					//菜单的绘图函数
					gameMenu.draw(canvas, paint);
				
					if(isSound)
					{
					  mediaplayer.start();
					}
					  break;
				case GAMEING:	
					//游戏背景
					mProgress=5;
					backGround.draw(canvas, paint);
					 if(bx.bxkg){
					      bx.draw(canvas, paint);
					 }
					 bx.draw1(canvas, mpaint);
					if(MainActivity.zlkg&&MainActivity.zlsz)
							gameb.draw(canvas, paint);			
					//canvas.drawText("分数："+mark, 20, 20,mpaint);  					   
					if (isBoss == false) {
                       // buff
						if(isSound){
							GameLoading.mediaplayer.start();
						}
						for(int i = 0;i<vcBuff.size();i++)
						{
							vcBuff.elementAt(i).draw(canvas, paint);
						}
						//敌机绘制
						for (int i = 0; i < vcEnemy.size(); i++) {
							vcEnemy.elementAt(i).draw(canvas, paint);
						}
						//敌机子弹绘制
						for (int i = 0; i < vcBullet.size(); i++) {
							vcBullet.elementAt(i).ebdraw(canvas, paint);
						}
					} else {
						//Boos的绘制		
						
						boss.draw(canvas, paint);
						
						//Boss子弹逻辑
						for (int i = 0; i < vcBulletBoss.size(); i++) {
							vcBulletBoss.elementAt(i).ebdraw(canvas, paint);
						}
					}
					//处理主角子弹绘制
					for (int i = 0; i < vcBulletPlayer.size(); i++) {
						vcBulletPlayer.elementAt(i).pdraw(canvas, paint);
					}
					//爆炸效果绘制
					for (int i = 0; i < vcBoom.size(); i++) {
						vcBoom.elementAt(i).draw(canvas, paint);
					}
					//主角绘图函数				
					 player.draw(canvas, paint);	
					//分数
					int score_width=score.getWidth();
					int score_height=score.getHeight();
					Bitmap score_new  = Bitmap.createBitmap(score,0,0,score_width,score_height, matrix, true);
					int score_new_width=score_new.getWidth();
					int score_new_height=score_new.getHeight();
					int score_new_value=score_new_width/10;
					GamingNum_cal.score_new_value=score_new_value;
					//分数的宽度和高度
					int score_fenshu_width=score_fenshu.getWidth();
					int score_fenshu_height=score_fenshu.getHeight();
					Bitmap score_fenshu_new  = Bitmap.createBitmap(score_fenshu,0,0,score_fenshu_width,score_fenshu_height, matrix, true);
					int score_fenshu_new_width=score_fenshu_new.getWidth();
					GamingNum_cal.score_fenshu_new_width=score_fenshu_new_width;
					// surce：用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					score1 = Bitmap.createBitmap(score_new,0,0,score_new_value,score_new_height); 
					score2 = Bitmap.createBitmap(score_new,score_new_value*1,0,score_new_value,score_new_height); 
					score3 = Bitmap.createBitmap(score_new,score_new_value*2,0,score_new_value,score_new_height); 
					score4 = Bitmap.createBitmap(score_new,score_new_value*3,0,score_new_value,score_new_height); 
					score5 = Bitmap.createBitmap(score_new,score_new_value*4,0,score_new_value,score_new_height); 
					score6 = Bitmap.createBitmap(score_new,score_new_value*5,0,score_new_value,score_new_height); 
					score7 = Bitmap.createBitmap(score_new,score_new_value*6,0,score_new_value,score_new_height); 
					score8 = Bitmap.createBitmap(score_new,score_new_value*7,0,score_new_value,score_new_height); 
					score9 = Bitmap.createBitmap(score_new,score_new_value*8,0,score_new_value,score_new_height); 
					score10 = Bitmap.createBitmap(score_new,score_new_value*9,0,score_new_value,score_new_height); 
					num_cal = new GamingNum_cal(score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score_fenshu_new);
					GamingNum_cal.mark=mark;
                    num_cal.draw(canvas, paint);
                    gameb.draw(canvas, paint);
					break;
				case GAME_PAUSE:
					if(isSound)
					{
						GameLoading.mediaplayer.pause();
					}
					break;
				case GAME_WIN:
					game_win.draw(canvas, paint);
					//重置游戏
					isBoss=false;
					player.unbeatable=false;
					mark=0;
					enemyArrayIndex=0;
				    player.setPlayerHp(3);
					bulletlv=1;
					kill=0;
					hurt=0;
                     lv=1;
                     k=0;
                     vcEnemy.removeAllElements();
						vcBullet.removeAllElements();
						vcBuff.removeAllElements();	
						vcBulletPlayer.removeAllElements();			
					break;
				case GAME_LOST:
					game_lost.draw(canvas, paint);
					//重置游戏
					isBoss=false;
					player.unbeatable=false;
					mark=0;
					lv=1;
					enemyArrayIndex=0;
					player.setPlayerHp(3);
					bulletlv=1;		
					k=0;
					kill=0;
					hurt=0;
					vcEnemy.removeAllElements();
					vcBullet.removeAllElements();
					vcBuff.removeAllElements();	
				//	vcBulletPlayer.removeAllElements();
					if(isSound)
					{
						GameLoading.mediaplayer.stop();
					}
					break;
				case GAME_JIESUAN:
					//TODO  分数
					int  jsm_width=jsm.getWidth();
					int  jsm_height=jsm.getHeight();
					Bitmap  jsm_new  = Bitmap.createBitmap(jsm,0,0,jsm_width,jsm_height, matrix, true);
				    int 	 jsm_new_width=jsm_new.getWidth();
				    int 	 jsm_new_height=jsm_new.getHeight();
					int  jsm_new_value=jsm_new_width/11;
					score1 = Bitmap.createBitmap(jsm_new,0,0,jsm_new_value,jsm_new_height); 
					score2 = Bitmap.createBitmap(jsm_new,jsm_new_value*1,0,jsm_new_value,jsm_new_height); 
					score3 = Bitmap.createBitmap(jsm_new,jsm_new_value*2,0,jsm_new_value,jsm_new_height); 
					score4 = Bitmap.createBitmap(jsm_new,jsm_new_value*3,0,jsm_new_value,jsm_new_height); 
					score5 = Bitmap.createBitmap(jsm_new,jsm_new_value*4,0,jsm_new_value,jsm_new_height); 
					score6 = Bitmap.createBitmap(jsm_new,jsm_new_value*5,0,jsm_new_value,jsm_new_height); 
					score7 = Bitmap.createBitmap(jsm_new,jsm_new_value*6,0,jsm_new_value,jsm_new_height); 
					score8 = Bitmap.createBitmap(jsm_new,jsm_new_value*7,0,jsm_new_value,jsm_new_height); 
					score9 = Bitmap.createBitmap(jsm_new,jsm_new_value*8,0,jsm_new_value,jsm_new_height); 
					score10 = Bitmap.createBitmap(jsm_new,jsm_new_value*9,0,jsm_new_value,jsm_new_height); 
					score11 = Bitmap.createBitmap(jsm_new,jsm_new_value*10,0,jsm_new_value,jsm_new_height); 	
					jsnum = new GamingJsNum(score1,score2,score3,score4,score5,score6,score7,score8,score9,score10,score11);
					//初始位子                
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					game_jiesuan.draw(canvas, paint);
					
					  jsnum.draw(canvas, paint,Game_jiesuan.jiesuan_mengban_weizhi_W+Game_jiesuan.jiesuan_mengban_new_butW/2,
	                		   Game_jiesuan.jiesuan_mengban_weizhi_H+ Game_jiesuan.jiesuan_mengban_new_butH*5/24 ,   
	                		   mark,jsm_new_value);
					 
					  jsnum.draw(canvas, paint,Game_jiesuan.jiesuan_mengban_weizhi_W+Game_jiesuan.jiesuan_mengban_new_butW/2,
	                		   Game_jiesuan.jiesuan_mengban_weizhi_H+ Game_jiesuan.jiesuan_mengban_new_butH*25/64   ,   
	                		   kill,jsm_new_value);
					  jsnum.draw(canvas, paint,Game_jiesuan.jiesuan_mengban_weizhi_W+Game_jiesuan.jiesuan_mengban_new_butW/2,
	                		   Game_jiesuan.jiesuan_mengban_weizhi_H+ Game_jiesuan.jiesuan_mengban_new_butH* 5/9  ,   
	                		   hurt,jsm_new_value);
					  jsnum.draw(canvas, paint,Game_jiesuan.jiesuan_mengban_weizhi_W+Game_jiesuan.jiesuan_mengban_new_butW/2,
	                		   Game_jiesuan.jiesuan_mengban_weizhi_H+ Game_jiesuan.jiesuan_mengban_new_butH* 20/27 , mark/1000,
	                		   jsm_new_value);
					if(isSound)
					{  try
						{
							GameLoading.mediaplayer.stop();
							GameLoading.mediaplayer1.stop();
						}catch(Exception e){Log.d("音乐错误","Mysurfaceview  926");}
						}
				
					break;
				case GAME_EXIT:
					//退出界面
					tuichu=BitmapFactory.decodeResource(res, R.drawable.tuichu);
					game_exit = new Game_exit(tuichu,tuichu_queding,tuichu_quxiao);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					//菜单的绘图函数
					paint.setAlpha( 75 );//设置透明度   
					gameMenu.draw(canvas, paint);
					// 取得想要缩放的matrix参数
					paint.setAlpha(255); 
					game_exit.draw(canvas, paint);
					break;
				case GAMEING_EXIT:
					//实例游戏背景
					//y游戏中的退出界面中的按钮
					gameing_back=BitmapFactory.decodeResource(res, R.drawable.gameing_back);
					button_back_menu=BitmapFactory.decodeResource(res, R.drawable.button_back_menu);
					button_continue=BitmapFactory.decodeResource(res, R.drawable.button_continue);
					gaming_exit = new Gaming_exit(gameing_back,button_continue,button_back_menu);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					//菜单的绘图函数
					paint.setAlpha( 185 );//设置透明度   
					backGround.draw(canvas, paint);
					//主角绘图函数				
					player.draw(canvas, paint);								   
					// 取得想要缩放的matrix参数
					paint.setAlpha(255); 
					gaming_exit.draw(canvas, paint);
					break;
				case GAME_JUQING:	
					if(isSound)
					{  try
						{
							mediaplayer.pause();
							mediaplayer4.start();
						}catch(Exception e){Log.d("音乐错误","Mysurfaceview ");}
					}
				
					//剧情页面
					game_juqing= new Game_juqing(shezhi_fanhui,shezhi_fanhui_press,juqing_guanqia,juqing_tongguo,context);
					//菜单的绘图函数
					game_juqing.draw(canvas, paint);
					  break;
				case GAME_STATE1:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//剧情故事的切割
				
					//计算图片的大小
					int juqing_state1_dialog_W=juqing_state1_dialog.getWidth();
					int juqing_state1_dialog_H=juqing_state1_dialog.getHeight();
					//获取新图片
					Bitmap juqing_state1_dialog_new  = Bitmap.createBitmap(juqing_state1_dialog,0,0,juqing_state1_dialog_W,juqing_state1_dialog_H, matrix, true);
					//新图片的宽度和高度
					int juqing_state1_dialog_new_width=juqing_state1_dialog_new.getWidth();
					int juqing_state1_dialog_new_height=juqing_state1_dialog_new.getHeight();
					int juqing_state1_value=juqing_state1_dialog_new_height/9;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state1_dialog_new,0,0,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*2,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*3,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*4,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*5,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog7 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*6,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog8 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*7,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog9 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*8,juqing_state1_dialog_new_width,juqing_state1_value); 
					// 关卡动画
					game_state1 = new Game_state1(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,juqing_state_dialog4,juqing_state_dialog5,juqing_state_dialog6,
							juqing_state_dialog7,juqing_state_dialog8,juqing_state_dialog9);
					Game_state1.state1=true;
					
					if(Game_state1.state1)
					{   
						Game_state1.is_dialog1=true;
					    game_state1.draw1(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG2:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{    
						 Game_state1.is_dialog2=true;
					     game_state1.draw2(canvas, paint);
					}
					if(Game_state2.state2)
					{    
						 Game_state2.is_dialog2=true;
					     game_state2.draw2(canvas, paint);
					}
					if(Game_state3.state3)
					{   
						Game_state3.is_dialog2=true;
						game_state3.draw2(canvas, paint);
					}
					if(Game_state4.state4)
					{   
						Game_state4.is_dialog2=true;
						game_state4.draw2(canvas, paint);
					}
					if(Game_state5.state5)
					{   
						Game_state5.is_dialog2=true;
						game_state5.draw2(canvas, paint);
					}
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog2=true;
						game_state6.draw2(canvas, paint);
					}
					if(Game_state7.state7)
					{   
						Game_state7.is_dialog2=true;
						game_state7.draw2(canvas, paint);
					}
					if(Game_state8.state8)
					{   
						Game_state8.is_dialog2=true;
						game_state8.draw2(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog2=true;
						game_state9.draw2(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG3:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{  
					   Game_state1.is_dialog3=true;
					   game_state1.draw3(canvas, paint);
					}
					if(Game_state2.state2)
					{    
						 Game_state2.is_dialog3=true;
					     game_state2.draw3(canvas, paint);
					}
					if(Game_state3.state3)
					{   
						Game_state3.is_dialog3=true;
						game_state3.draw3(canvas, paint);
					}
					if(Game_state4.state4)
					{   
						Game_state4.is_dialog3=true;
						game_state4.draw3(canvas, paint);
					}
					if(Game_state5.state5)
					{   
						Game_state5.is_dialog3=true;
						game_state5.draw3(canvas, paint);
					}
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog3=true;
						game_state6.draw3(canvas, paint);
					}if(Game_state7.state7)
					{   
						Game_state7.is_dialog3=true;
						game_state7.draw3(canvas, paint);
					}
					if(Game_state8.state8)
					{   
						Game_state8.is_dialog3=true;
						game_state8.draw3(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog3=true;
						game_state9.draw3(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG4:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{   
						Game_state1.is_dialog4=true;
					    game_state1.draw4(canvas, paint);
					}
					if(Game_state2.state2)
					{    
						 Game_state2.is_dialog4=true;
					     game_state2.draw4(canvas, paint);
					}
					if(Game_state3.state3)
					{   
						Game_state3.is_dialog4=true;
						game_state3.draw4(canvas, paint);
					}
					if(Game_state4.state4)
					{   
						Game_state4.is_dialog4=true;
						game_state4.draw4(canvas, paint);
					}
					if(Game_state5.state5)
					{   
						Game_state5.is_dialog4=true;
						game_state5.draw4(canvas, paint);
					}
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog4=true;
						game_state6.draw4(canvas, paint);
					}
					if(Game_state7.state7)
					{   
						Game_state7.is_dialog4=true;
						game_state7.draw4(canvas, paint);
					}
					if(Game_state8.state8)
					{   
						Game_state8.is_dialog4=true;
						game_state8.draw4(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog4=true;
						game_state9.draw4(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG5:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{    
						 Game_state1.is_dialog5=true;
					     game_state1.draw5(canvas, paint);
					}
					if(Game_state2.state2)
					{    
						 Game_state2.is_dialog5=true;
					     game_state2.draw5(canvas, paint);
					}
					if(Game_state4.state4)
					{   
						Game_state4.is_dialog5=true;
						game_state4.draw5(canvas, paint);
					}
					if(Game_state5.state5)
					{   
						Game_state5.is_dialog5=true;
						game_state5.draw5(canvas, paint);
					}
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog5=true;
						game_state6.draw5(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog5=true;
						game_state9.draw5(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG6:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{   
						Game_state1.is_dialog6=true;
					     game_state1.draw6(canvas, paint);
					}
					if(Game_state2.state2)
					{    
						 Game_state2.is_dialog6=true;
					     game_state2.draw6(canvas, paint);
					}
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog6=true;
						game_state6.draw6(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog6=true;
						game_state9.draw6(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG7:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{
						Game_state1.is_dialog7=true;  
						game_state1.draw7(canvas, paint);
					}
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog7=true;
						game_state6.draw7(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog7=true;
						game_state9.draw7(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG8:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{   
						Game_state1.is_dialog8=true;
					    game_state1.draw8(canvas, paint);
					}
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog8=true;
						game_state9.draw8(canvas, paint);
					}
					break;
				case GAME_STATE_DIALOG9:
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					if(Game_state1.state1)
					{    
						 Game_state1.is_dialog9=true;
					     game_state1.draw9(canvas, paint);
					}
					break;
				case GAME_STATE2:
					juqing_state2_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state2_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state2_dialog_W=juqing_state2_dialog.getWidth();
					int juqing_state2_dialog_H=juqing_state2_dialog.getHeight();
					int juqing_state2_value=juqing_state2_dialog_H/6;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state2_dialog,0,0,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*2,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*3,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*4,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*5,juqing_state2_dialog_W,juqing_state2_value); 
					// 关卡动画
					game_state2 = new Game_state2(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4,juqing_state_dialog5,juqing_state_dialog6);
					Game_state2.state2=true;
					if(Game_state2.state2)
					{   
						Game_state2.is_dialog1=true;
						game_state2.draw1(canvas, paint);
					}
					break;
				case GAME_STATE3:
					juqing_state3_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state3_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state3_dialog_W=juqing_state3_dialog.getWidth();
					int juqing_state3_dialog_H=juqing_state3_dialog.getHeight();
					int juqing_state3_value=juqing_state3_dialog_H/4;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state3_dialog,0,0,juqing_state3_dialog_W,juqing_state3_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state3_dialog,0,juqing_state3_value,juqing_state3_dialog_W,juqing_state3_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state3_dialog,0,juqing_state3_value*2,juqing_state3_dialog_W,juqing_state3_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state3_dialog,0,juqing_state3_value*3,juqing_state3_dialog_W,juqing_state3_value); 
					// 关卡动画
					game_state3 = new Game_state3(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4);
					Game_state3.state3=true;
					if(Game_state3.state3)
					{   
						Game_state3.is_dialog1=true;
						game_state3.draw1(canvas, paint);
					}
					break;
				case GAME_STATE4:
					juqing_state4_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state4_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state4_dialog_W=juqing_state4_dialog.getWidth();
					int juqing_state4_dialog_H=juqing_state4_dialog.getHeight();
					int juqing_state4_value=juqing_state4_dialog_H/5;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state4_dialog,0,0,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value*2,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value*3,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value*4,juqing_state4_dialog_W,juqing_state4_value); 
					// 关卡动画
					game_state4 = new Game_state4(juqing_state_dialog1,juqing_state_dialog2,
							juqing_state_dialog3,juqing_state_dialog4,juqing_state_dialog5);
					Game_state4.state4=true;
					if(Game_state4.state4)
					{   
						Game_state4.is_dialog1=true;
						game_state4.draw1(canvas, paint);
					}
					break;
				case GAME_STATE5:
					juqing_state5_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state5_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state5_dialog_W=juqing_state5_dialog.getWidth();
					int juqing_state5_dialog_H=juqing_state5_dialog.getHeight();
					int juqing_state5_value=juqing_state5_dialog_H/5;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state5_dialog,0,0,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value*2,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value*3,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value*4,juqing_state5_dialog_W,juqing_state5_value); 
					// 关卡动画
					game_state5 = new Game_state5(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4,juqing_state_dialog5);
					Game_state5.state5=true;
					if(Game_state5.state5)
					{   
						Game_state5.is_dialog1=true;
						game_state5.draw1(canvas, paint);
					}
					break;
				case GAME_STATE6:
					juqing_state6_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state6_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state6_dialog_W=juqing_state6_dialog.getWidth();
					int juqing_state6_dialog_H=juqing_state6_dialog.getHeight();
					int juqing_state6_value=juqing_state6_dialog_H/7;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state6_dialog,0,0,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*2,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*3,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*4,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*5,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog7 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*6,juqing_state6_dialog_W,juqing_state6_value); 
					// 关卡动画
					game_state6 = new Game_state6(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4,juqing_state_dialog5,juqing_state_dialog6,juqing_state_dialog7);
					Game_state6.state6=true;
					if(Game_state6.state6)
					{   
						Game_state6.is_dialog1=true;
						game_state6.draw1(canvas, paint);
					}
					break;
				case GAME_STATE7:
					juqing_state7_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state7_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state7_dialog_W=juqing_state7_dialog.getWidth();
					int juqing_state7_dialog_H=juqing_state7_dialog.getHeight();
					int juqing_state7_value=juqing_state7_dialog_H/4;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state7_dialog,0,0,juqing_state7_dialog_W,juqing_state7_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state7_dialog,0,juqing_state7_value,juqing_state7_dialog_W,juqing_state7_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state7_dialog,0,juqing_state7_value*2,juqing_state7_dialog_W,juqing_state7_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state7_dialog,0,juqing_state7_value*3,juqing_state7_dialog_W,juqing_state7_value); 
					// 关卡动画
					game_state7 = new Game_state7(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4);
					Game_state7.state7=true;
					if(Game_state7.state7)
					{   
						Game_state7.is_dialog1=true;
						game_state7.draw1(canvas, paint);
					}
					break;
				case GAME_STATE8:
					juqing_state8_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state8_dialog);
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state8_dialog_W=juqing_state8_dialog.getWidth();
					int juqing_state8_dialog_H=juqing_state8_dialog.getHeight();
					int juqing_state8_value=juqing_state8_dialog_H/4;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state8_dialog,0,0,juqing_state8_dialog_W,juqing_state8_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state8_dialog,0,juqing_state8_value,juqing_state8_dialog_W,juqing_state8_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state8_dialog,0,juqing_state8_value*2,juqing_state8_dialog_W,juqing_state8_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state8_dialog,0,juqing_state8_value*3,juqing_state8_dialog_W,juqing_state8_value); 
					// 关卡动画
					game_state8 = new Game_state8(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4);
					Game_state8.state8=true;
					if(Game_state8.state8)
					{   
						Game_state8.is_dialog1=true;
						game_state8.draw1(canvas, paint);
					}
					break;
				case GAME_STATE9:
					juqing_state9_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state9_dialog);	
					//菜单的绘图函数
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//设置透明度   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//计算图片的大小
					int juqing_state9_dialog_W=juqing_state9_dialog.getWidth();
					int juqing_state9_dialog_H=juqing_state9_dialog.getHeight();
					int juqing_state9_value=juqing_state9_dialog_H/8;
					//   用来剪裁的图片源;
				    //   x：剪裁x方向的起始位置;
				    //   y：剪裁y方向的起始位置;
				     //  width：剪裁的宽度;
				    //   height：剪裁的高度
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state9_dialog,0,0,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*2,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*3,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*4,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*5,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog7 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*6,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog8 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*7,juqing_state9_dialog_W,juqing_state9_value); 
					/// 关卡动画
					game_state9 = new Game_state9(juqing_state_dialog1,juqing_state_dialog2,juqing_state_dialog3,
							juqing_state_dialog4,juqing_state_dialog5,juqing_state_dialog6,
							juqing_state_dialog7,juqing_state_dialog8
							);
					Game_state9.state9=true;
					if(Game_state9.state9)
					{   
						Game_state9.is_dialog1=true;
						game_state9.draw1(canvas, paint);
					}
					break;
				case GAME_SELECTPLANE1:
					//绘图函数	
					//战机加载
					if(sp1==0){
						plane_huangjinzhanjia =BitmapFactory.decodeResource(res, R.drawable.plane_huangjinzhanjia);
						plane_anyeleiting =BitmapFactory.decodeResource(res, R.drawable.plane_anyeleiting);
						plane_anyeyingxue =BitmapFactory.decodeResource(res, R.drawable.plane_anyeyingxue);
						plane_huangjinzhanjia =BitmapFactory.decodeResource(res, R.drawable.plane_huangjinzhanjia);
						plane_lengyanhanfeng =BitmapFactory.decodeResource(res, R.drawable.plane_lengyanhanfeng);
						plane_moshangyanyun =BitmapFactory.decodeResource(res, R.drawable.plane_moshangyanyun);
						button_houtui=BitmapFactory.decodeResource(res, R.drawable.button_houtui);
					    button_houtui_press=BitmapFactory.decodeResource(res, R.drawable.button_houtui_press);
						button_qianjin=BitmapFactory.decodeResource(res, R.drawable.button_qianjin);
						button_qianjin_press=BitmapFactory.decodeResource(res, R.drawable.button_qianjin_press);
						game_selectplane= new Game_SelectPlane(shezhi_fanhui,shezhi_fanhui_press,plane_anyeleiting,plane_anyeyingxue,
								plane_huangjinzhanjia,plane_lengyanhanfeng,plane_moshangyanyun,button_houtui,button_houtui_press,
								button_qianjin,button_qianjin_press,context);
				        sp1++;				       
					}
					Game_SelectPlane.frameIndex++;
					if (Game_SelectPlane.frameIndex >= 3) {				  
						Game_SelectPlane.frameIndex = 0;
					}
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					is_plane1 =prefs.getBoolean("is_plane1",true);
					is_plane2 =prefs.getBoolean("is_plane2",false);
					is_plane3 =prefs.getBoolean("is_plane3",false);
					is_plane4 =prefs.getBoolean("is_plane4",false);
					is_plane5 =prefs.getBoolean("is_plane5",false);					
					if(is_plane1)
				          game_selectplane.draw1(canvas, paint);
					if(is_plane2)
					      game_selectplane.draw2(canvas, paint);
					if(is_plane3)
					      game_selectplane.draw3(canvas, paint);
					if(is_plane4)
					      game_selectplane.draw4(canvas, paint);
					if(is_plane5)
					      game_selectplane.draw5(canvas, paint);
					break;			
				case GAME_SHOP_DAOJU:
					//商店
					shop_daoju=BitmapFactory.decodeResource(res, R.drawable.shop_daoju);
				
					shop_shangpin=BitmapFactory.decodeResource(res, R.drawable.shop_shangpin);
					shop_nobuy=BitmapFactory.decodeResource(res, R.drawable.shop_nobuy);
					shop_buy=BitmapFactory.decodeResource(res, R.drawable.shop_buy);
				
                    shop_xunbao=BitmapFactory.decodeResource(res, R.drawable.shop_xunbao);
					//商店
					game_shop= new Game_Shop(shezhi_fanhui,shezhi_fanhui_press,shop_daoju
							,shop_shangpin, shop_buy,shop_nobuy,shop_xunbao, context);
					//分数
					//绘图函数	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
				    game_shop.draw1(canvas, paint);
					break;
				case GAME_SHOP_FEIJI:
					//绘图函数	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
				    game_shop.draw2(canvas, paint);
					break;
				case GAME_SHOP_XUNBAO:
					//绘图函数	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_shop.draw3(canvas, paint);
					break;
				case GAME_SHOP_XUNBAOS:
					//绘图函数	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_querengoumai.draw2(canvas, paint);
					break;
				case GAME_SHOP_QUEREN:
					shop_queren = BitmapFactory.decodeResource(res, R.drawable.shop_queren);
					shop_mengban=BitmapFactory.decodeResource(res, R.drawable.shop_mengban);
					//绘图函数	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_querengoumai= new Game_Querengoumai(shop_queren,tuichu_queding,tuichu_quxiao,shop_mengban,context);
					game_querengoumai.draw(canvas, paint);
					break;
				case GAME_SHOP_NOMONEY:
					shop_nomoney = BitmapFactory.decodeResource(res, R.drawable.shop_nomoney);
					//绘图函数	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_nomoney= new Game_NoMoney(shop_nomoney, tuichu_queding, tuichu_quxiao,context);
					game_nomoney.draw(canvas, paint);
					break;
				case GAME_SHEZHI:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//绘图函数		   
					game_shezhi.draw(canvas, paint);
					break;
				case GAME_SHEZHI_BANGZHU:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//绘图函数		
					game_shezhi.draw1(canvas, paint);
					//字体设置
					//Typeface face = Typeface.createFromAsset (getAssets() , "ziti.TTF");  
				    //paint.setTypeface(face);
					///////////////////////////
					paint.setColor(getResources().getColor(R.color.ghostwhite));//颜色
					paint.setTextSize(MainActivity.TEXT_SIZE_50);
					canvas.drawText("帮助",screenW/20*8,screenH/20*4, paint);
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					canvas.drawText("         经典模式：连续通关，击败最终的BOSS。被敌机",0,screenH/20*5, paint);
					canvas.drawText("   击中的子弹等级不下降。                                             ",0,screenH/20*6, paint);
					canvas.drawText("         无尽模式：无穷无尽的敌人，随着时间增长难度",0,screenH/20*7, paint);
					canvas.drawText("   。全随机的敌机每一次都是不同的体验，完全可能出场 ",0,screenH/20*8, paint);
					canvas.drawText("   便遇到一个难缠的BOSS。被敌机击中子弹等级下降。    ",0,screenH/20*9, paint);
					canvas.drawText("         剧情模式：BOSS战斗，每一关都会出现若干BOSS",0,screenH/20*10,paint);
					canvas.drawText("   ，但少量主角BUFF效果，出现被敌机击中子弹等级不下",0,screenH/20*11,paint);	
					canvas.drawText("   降。                                                                            ",0,screenH/20*12,paint);	
					canvas.drawText("         移动：触屏移动，屏幕的任意一处均可拖拽。    ",0,screenH/20*13,paint);	
					canvas.drawText("         重力移动：设置中打开重力开关体验重力移动你",0,screenH/20*14,paint);	
					canvas.drawText("   可以在游戏中重置你的手机位置方便你用任意姿势体验",0,screenH/20*15,paint);	
					canvas.drawText("   重力感应。你可以侧着手机，直立手机等极端位置体验",0,screenH/20*16,paint);	
					canvas.drawText("   重力移动。用重力移动适应你的姿势，而非您去适应重",0,screenH/20*17,paint);	
					canvas.drawText("   力移动。在游戏中点击锁定按钮便可锁定当前手机的位",0,screenH/20*18,paint);	
					canvas.drawText("   置。        ",0,screenH/20*19,paint);	
					break;
				case GAME_SHEZHI_GUANYU:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//绘图函数		
					paint.setColor(Color.YELLOW);
					game_shezhi.draw1(canvas, paint);
					paint.setColor(getResources().getColor(R.color.ghostwhite));//颜色
					paint.setTextSize(MainActivity.TEXT_SIZE_50);//字体大小
					canvas.drawText("关于",screenW/20*8,screenH/20*4, paint);
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					canvas.drawText("	 ",screenW/20*3,screenH/20*6,paint);	
					canvas.drawText("	 制作团队：豆芽软件设计团队        ",screenW/20*3,screenH/20*7,paint);	
					canvas.drawText("	 总策划：    张宇航      ",screenW/20*3,screenH/20*8,paint);	
					canvas.drawText("	 程序设计：张宇航    舒文奇        ",screenW/20*3,screenH/20*9,paint);	
					canvas.drawText("	 界面设计：张宇航        ",screenW/20*3,screenH/20*10,paint);	
					canvas.drawText("	 美工设计：王文琪    张欣桐    夏钟升        ",screenW/20*3,screenH/20*11,paint);	
					canvas.drawText("	 动画设计：夏钟升        ",screenW/20*3,screenH/20*12,paint);	
					canvas.drawText("	 指导老师：朱荣        ",screenW/20*3,screenH/20*13,paint);	
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					break;
				case GAME_SHEZHI_SHENGMING:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//绘图函数		
					paint.setColor(Color.YELLOW);
					game_shezhi.draw1(canvas, paint);
					paint.setColor(getResources().getColor(R.color.ghostwhite));//颜色
					paint.setTextSize(MainActivity.TEXT_SIZE_50);//字体大小
					canvas.drawText("声明",screenW/20*8,screenH/20*4, paint);
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					canvas.drawText("                       ",screenW/20*3,screenH/20*6,paint);	
					canvas.drawText("本游戏作为豆芽游戏设计团队开发制作",screenW/20*3,screenH/20*7,paint);	
					canvas.drawText("本游戏作为齐鲁软件设计大赛参赛作品，",screenW/20*3,screenH/20*8,paint);
					canvas.drawText("禁止用于其他商业用途。",screenW/20*3,screenH/20*9,paint);
					canvas.drawText("若在本游戏中遇到问题，请联系游戏设计师",screenW/20*3,screenH/20*10,paint);	
					canvas.drawText("设计师邮箱：xiazhongsheng@outlook.com",screenW/20*3,screenH/20*11,paint);	
					break;


				}
			}
		} catch (Exception e) {
			
		} finally {
			if (canvas != null)
				sfh.unlockCanvasAndPost(canvas);
		}
	}
	/**
	 * 触屏事件监听
	 */
	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouchEvent(MotionEvent event) {
		//触屏监听事件函数根据游戏状态不同进行不同监听
		switch (gameState) {
		case GAME_MENU:
			//菜单的触屏事件处理
			try{
			gameMenu.onTouchEvent(event);
			}catch(Exception e)
			{}
			break;
	
			
		case GAMEING:
			try{
			player.onTouchEvent(event);
			gameb.onTouchEvent(event);
			bx.onTouchEvent(event);
			bx.onTouchEvent1(event);
			gameb.onTouchEvent1(event);
			}catch(Exception e)
			{}
			break;
		case GAME_PAUSE:
			break;
		case GAME_JIESUAN: 
			try{
			game_jiesuan.onTouchEvent(event);
			game_jiesuan.onTouchEvent1(event);
			}catch(Exception e)
			{}
			break;
		case GAME_WIN:
			try{
			game_win.onTouchEvent(event);
			game_win.onTouchEvent1(event);
			}catch(Exception e)
			{}
			break;
		case GAME_LOST: 
			try{
			game_lost.onTouchEvent(event);
			game_lost.onTouchEvent1(event);
			}catch(Exception e)
			{}
			break;
		case GAME_EXIT: 
			try{
			game_exit.onTouchEvent(event);
			}catch(Exception e)
			{}
			break;
		case GAMEING_EXIT: 
			try{
			gaming_exit.onTouchEvent(event);
			}catch(Exception e)
			{}
			break;
		case GAME_STATE1: 
			try{
				game_state1.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
	    case GAME_STATE_DIALOG2:
	    	try{
	    		if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state2.state2)
				{ game_state2.onTouchEvent(event); }
	    		if(Game_state3.state3)
				{ game_state3.onTouchEvent(event); }
	    		if(Game_state4.state4)
				{ game_state4.onTouchEvent(event); }
	    		if(Game_state5.state5)
				{ game_state5.onTouchEvent(event); }
	    		if(Game_state6.state6)
				{ game_state6.onTouchEvent(event); }
	    		if(Game_state7.state7)
				{ game_state7.onTouchEvent(event); }
	    		if(Game_state8.state8)
				{ game_state8.onTouchEvent(event); }
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
		case GAME_STATE_DIALOG4:
			try{
				if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state2.state2)
				{ game_state2.onTouchEvent(event); }
	    		if(Game_state3.state3)
				{ game_state3.onTouchEvent(event); }
	    		if(Game_state4.state4)
				{ game_state4.onTouchEvent(event); }
	    		if(Game_state5.state5)
				{ game_state5.onTouchEvent(event); }
	    		if(Game_state6.state6)
				{ game_state6.onTouchEvent(event); }
	    		if(Game_state7.state7)
				{ game_state7.onTouchEvent(event); }
	    		if(Game_state8.state8)
				{ game_state8.onTouchEvent(event); }
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
		case GAME_STATE_DIALOG3: 
			try{
				if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state2.state2)
				{ game_state2.onTouchEvent(event); }
	    		if(Game_state3.state3)
				{ game_state3.onTouchEvent(event); }
	    		if(Game_state4.state4)
				{ game_state4.onTouchEvent(event); }
	    		if(Game_state5.state5)
				{ game_state5.onTouchEvent(event); }
	    		if(Game_state6.state6)
				{ game_state6.onTouchEvent(event); }
	    		if(Game_state7.state7)
				{ game_state7.onTouchEvent(event); }
	    		if(Game_state8.state8)
				{ game_state8.onTouchEvent(event); }
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
		case GAME_STATE_DIALOG5: 
			try{
				if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state2.state2)
				{ game_state2.onTouchEvent(event); }
	    		if(Game_state4.state4)
				{ game_state4.onTouchEvent(event); }
	    		if(Game_state5.state5)
				{ game_state5.onTouchEvent(event); }
	    		if(Game_state6.state6)
				{ game_state6.onTouchEvent(event); }
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
		case GAME_STATE_DIALOG6: 
			try{
				if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state2.state2)
				{ game_state2.onTouchEvent(event); }
	    		if(Game_state6.state6)
				{ game_state6.onTouchEvent(event); }	
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
	    case GAME_STATE_DIALOG7: 
	    	try{
	    		if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state6.state6)
				{ game_state6.onTouchEvent(event); }
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
	    case GAME_STATE_DIALOG8: 
	    	try{
	    		if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
	    		if(Game_state9.state9)
				{ game_state9.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
		case GAME_STATE_DIALOG9: 
			try{
				if(Game_state1.state1)
				{ game_state1.onTouchEvent(event); }
				}catch(Exception e)
				{}
			break;
		case GAME_STATE2: 
			try{
				game_state2.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE3: 
			try{
				game_state3.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE4: 
			try{
				game_state4.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE5: 
			try{
				game_state5.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE6: 
			try{
				game_state6.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE7: 
			try{
				game_state7.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE8: 
			try{
				game_state8.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_STATE9: 
			try{
				game_state9.onTouchEvent(event);
				}catch(Exception e)
				{}
			break;
		case GAME_SELECTPLANE1:
			try{
			game_selectplane.onTouchEvent(event);
			game_selectplane.onTouchEvent1(event);
			game_selectplane.onTouchEvent2(event);
			}catch(Exception e)
			{}
			break;
		case GAME_SHEZHI_BANGZHU:
			try{
			game_shezhi.onTouchEvent(event);
		
			}catch(Exception e)
			{}
			break;
		case GAME_SHEZHI_GUANYU:
			try{
			game_shezhi.onTouchEvent(event);
			
			}catch(Exception e)
			{}
			break;
		case GAME_SHEZHI_SHENGMING:
			try{
			game_shezhi.onTouchEvent(event);
			
			}catch(Exception e)
			{}
			break;
		case GAME_SHEZHI:
			try{
			game_shezhi.onTouchEvent(event);
			game_shezhi.onTouchEvent1(event);
			game_shezhi.onTouchEvent2(event);
			}catch(Exception e)
			{}
			break;
		case GAME_JUQING: 
			try{
			game_juqing.onTouchEvent(event);
			game_juqing.onTouchEvent1(event);	
			}catch(Exception e)
			{}
			break;
		case GAME_SHOP_DAOJU: 
			try{
				game_shop.onTouchEvent(event);	
				game_shop.onTouchEvent1(event);
				}catch(Exception e)
				{}
			break;
		case GAME_SHOP_FEIJI: 
			try{
				game_shop.onTouchEvent(event);	
				game_shop.onTouchEvent2(event);
				}catch(Exception e)
				{}
			break;
		case GAME_SHOP_XUNBAO: 
			try{
				game_shop.onTouchEvent(event);	
				game_shop.onTouchEvent3(event);	
				}catch(Exception e)
				{}
			break;
		case GAME_SHOP_QUEREN: 
			try{
				game_querengoumai.onTouchEvent(event);	
				}catch(Exception e)
				{}
			break;
		case GAME_SHOP_XUNBAOS: 
			try{
				
				game_querengoumai.onTouchEvent2(event);	
				}catch(Exception e)
				{}
			break;
		case GAME_SHOP_NOMONEY: 
			try{
				game_nomoney.onTouchEvent(event);	
				}catch(Exception e)
				{}
			break;
		}
		return true;
	}

	/**
	 * 按键按下返回键事件监听
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//处理back返回按键
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			//游戏胜利、失败、进行时都默认返回菜单
			if ( gameState == GAME_WIN || gameState == GAME_LOST) {
				gameState = GAME_MENU;
				//Boss状态设置为没出现
				isBoss = false;
				//重置游戏
				load();
				//重置怪物出场
				enemyArrayIndex = 0;
				bossArrayIndex=0;
			} 
			else if (gameState  == GAMEING ) {
					//当前游戏状态在菜单界面，默认返回按键退出游戏
				 gameState = GamingPlaneTest.GAMEING_EXIT;
					//重置游戏
					//initGame();
					//mediaplayer1.pause();
				}
			else if (gameState == GAME_MENU) {
				//当前游戏状态在菜单界面，默认返回按键退出游戏
				//MainActivity.instance.finish();
				//System.exit(0);
				gameState = GamingPlaneTest.GAME_EXIT;
				playSound(7,0);
			}
			else if (gameState ==  GAME_EXIT) {
				//当前游戏状态在菜单界面，默认返回按键退出游戏
				//MainActivity.instance.finish();
				//System.exit(0);
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState ==  GAMEING_EXIT) {
				//当前游戏状态在菜单界面，默认返回按键退出游戏
				//MainActivity.instance.finish();
				//System.exit(0);
				gameState = GamingPlaneTest.GAMEING;
			}
			else if (gameState == GAME_SHEZHI) {
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState == GAME_SHEZHI_BANGZHU) {
				gameState = GamingPlaneTest.GAME_SHEZHI;
			}
			else if (gameState == GAME_SHEZHI_GUANYU) {
				gameState = GamingPlaneTest.GAME_SHEZHI;
			}
			else if (gameState == GAME_SHEZHI_SHENGMING) {
				gameState = GamingPlaneTest.GAME_SHEZHI;
			}
			else if (gameState == GAME_JUQING) {
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState == GAME_SHOP_DAOJU) {
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState == GAME_SHOP_FEIJI) {
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState == GAME_SHOP_XUNBAO) {
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState == GAME_SHOP_XUNBAOS) {
				gameState = GamingPlaneTest.GAME_SHOP_DAOJU;
			}
			else if (gameState == GAME_SHOP_QUEREN) {
				gameState = GamingPlaneTest.GAME_SHOP_DAOJU;
			}
			else if (gameState == GAME_SHOP_NOMONEY) {
				gameState = GamingPlaneTest.GAME_SHOP_DAOJU;
			}
			//表示此按键已处理，不再交给系统处理，
			//从而避免游戏被切入后台
			return true;
		}
		//按键监听事件函数根据游戏状态不同进行不同监听
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:
			//主角的按键按下事件
			break;
		case GAME_PAUSE:
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}
	/**
	 * 按键抬起事件监听
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		//处理back返回按键
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			//游戏胜利、失败、进行时都默认返回菜单
			if ( gameState == GAME_WIN || gameState == GAME_LOST) {
				gameState = GAME_MENU;
			}
			else if(gameState == GAME_MENU)
			{
				
			}
			//表示此按键已处理，不再交给系统处理，
			//从而避免游戏被切入后台
			return true;
		}
		//按键监听事件函数根据游戏状态不同进行不同监听
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:
			//按键抬起事件
			break;
		case GAME_PAUSE:
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_EXIT:
			break;
		case GAMEING_EXIT:
			break;
		case GAME_SHEZHI: 
			break;
		case GAME_SHEZHI_BANGZHU: 
			break;
		case GAME_SHEZHI_GUANYU:
			break;
		case GAME_SHEZHI_SHENGMING:
		    break;
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * 经典模式游戏逻辑
	 * TODO 
	 */
	
	private void jingdian() {	
		//逻辑处理根据游戏状态不同进行不同处理
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:			
			//背景逻辑
			backGround.logic();
			//主角逻辑
			player.logic();
		
			 if(bx.bxkg){						
					bx.logic();
					vcEnemy.removeAllElements();
					vcBullet.removeAllElements();
					vcBulletBoss.removeAllElements();
					if(isBoss){
						  boss.setHp(boss.hp -1000);					 
					}
					if(player.type==5){												
						if(bx.frameIndex>=2)
						{
							bx.frameIndex=0;
						}
						bx.frameIndex++;
					}
				}	
			GamingKey.key1();
			//敌机逻辑
			if (isBoss == false) {
				//敌机逻辑
				dead();
				//生成敌机
				count++;
				
				if (count % createEnemyTime == 0) {
					for (int i = 0; i < enemyArray[enemyArrayIndex].length; i++) {
						
						if (enemyArray[enemyArrayIndex][i] == 1) {
							int x = random.nextInt(screenW - 100) + 50;
							vcEnemy.addElement(enemy=new GamingEnemy(EnemyF1, 1, x, -50));
							
						} else if (enemyArray[enemyArrayIndex][i] == 2) {
							int y = random.nextInt(20);
							vcEnemy.addElement(enemy=new GamingEnemy(EnemyF2, 2, -50, y));
							
						} else if (enemyArray[enemyArrayIndex][i] == 3) {
							int y = random.nextInt(20);
							vcEnemy.addElement(enemy=new GamingEnemy(EnemyF2, 3, screenW + 50, y));
						}
						else if (enemyArray[enemyArrayIndex][i] == 4) {
							int x = random.nextInt(screenW - 100) + 50;
							vcEnemy.addElement(enemy=new GamingEnemy(Enemy4, 4, x, -50));
						}
						else if (enemyArray[enemyArrayIndex][i] == 5) {
							int x = random.nextInt(screenW - 100) + 50;							
							vcEnemy.addElement(new GamingEnemy(Enemyzisa, 5, x, -50));
						}		
						else if (enemyArray[enemyArrayIndex][i] == 6) {
							int y = random.nextInt(20);					
							vcEnemy.addElement(new GamingEnemy(Enemyzisa, 6, -2, y));
						}	
						else if (enemyArray[enemyArrayIndex][i] == 7) {
							int x = random.nextInt(screenW - 100) + 50;				
							vcEnemy.addElement(new GamingEnemy(Enemyzisa, 7, x, -2));
						}	
					//	elseif (enemyArray[enemyArrayIndex][i+2] == -1) {
					//		  Waring.draw(canvas, paint, War, 300, 400);	
					//	}
						if (enemyArray[enemyArrayIndex][i] <  0) {
							 // Warning.draw(canvas,  War, 300, 400,paint);	
							// boss优化完成
							//优化boss出场，1： 出现警报声音 2： 在上方绘图  3：  ！！！！如和清空其他道具，警报图片消失后再出现boss
							//  推理， 调用警报图片的绘图方法,~~~!!!! 
							if(enemyArray[enemyArrayIndex][i]==-1){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos,1);
							}
							if(enemyArray[enemyArrayIndex][i]==-2){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos2,2);
							}
							if(enemyArray[enemyArrayIndex][i]==-3){
								//实例boss对象
								boss = new GamingBoss(boss6,3);
							}
							if(enemyArray[enemyArrayIndex][i]==-4){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos3,4);
							}
							if(enemyArray[enemyArrayIndex][i]==-5){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos1,5);
							}
							isBoss = true;
							vcEnemy.removeAllElements();
							vcBullet.removeAllElements();
							vcBuff.removeAllElements();	
							vcBulletPlayer.removeAllElements();						
							boss.setHp(20000+5000*lv);
						}	
						if (enemyArray[enemyArrayIndex][i] == 0) {
							gameState =GAME_JIESUAN;
						}		
					}
						enemyArrayIndex++;
				}
				//处理敌机与主角的碰撞
				for (int i = 0; i < vcEnemy.size(); i++) {
					if (player.unbeatable==false&&player.isCollsionWith(vcEnemy.elementAt(i))) {
						//发生碰撞，主角血量-1		
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						player.setPlayerHp(player.getPlayerHp() - 1);
						hurt++;
						//当主角血量小于0，判定游戏失败
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
					
				}
				//每2秒添加一个敌机子弹
				countEnemyBullet++;
				if (countEnemyBullet % 40 == 0) {
					for (int i = 0; i < vcEnemy.size(); i++) {
						GamingEnemy en = vcEnemy.elementAt(i);
						//不同类型敌机不同的子弹运行轨迹
						int bulletType = 0;
						switch (en.type) {
						
						case GamingEnemy.TYPE_F1:
							bulletType = GamingBullet.BULLET_F1;
							vcBullet.add(new GamingBullet(zidan10, en.x + 10, en.y + 20,bulletType)); 
							break;
					
						case GamingEnemy.TYPE_F3:
							bulletType = GamingBullet.BULLET_F3;
							vcBullet.add(new GamingBullet(zhidan3, en.x + 10, en.y + 20,bulletType)); 
							break;
						case GamingEnemy.TYPE_F2:
							bulletType = GamingBullet.BULLET_F2;
							vcBullet.add(new GamingBullet(zhidan3, en.x + 10, en.y + 20,bulletType)); 
							break;
						case GamingEnemy.TYPE_A:
							bulletType=GamingBullet.BULLET_A;	
							break;
						case GamingEnemy.TYPE_B:
							break;
						case GamingEnemy.TYPE_C:
							break;
					 }						
					}
				}
				//处理敌机子弹逻辑
				for (int i = 0; i < vcBullet.size(); i++) { 
					GamingBullet b = vcBullet.elementAt(i);
					if (b.isDead) {
						vcBullet.removeElement(b);
					} else {
						b.logic();
					}
				}
				//处理敌机子弹与主角碰撞
				for (int i = 0; i < vcBullet.size(); i++) {
					if (player.isCollsionWith(vcBullet.elementAt(i))) {
		//				//发生碰撞，主角血量-1					
						if(	player.unbeatable==false){
						GamingKey.key();
						//TODO MainActivity.vibrator.vibrate(pattern,-1);
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);						
						//TODO					
						//碰撞即进入无敌状态
						hurt++;
						 player.unbeatable = true;	
					     player.setPlayerHp(player.getPlayerHp() - 1)	;	
					}
				    //当主角血量小于0，判定游戏失败
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}					
				}
				//处理主角子弹与敌机碰撞
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
					//取出主角子弹容器的每个元素
					GamingBullet blPlayer = vcBulletPlayer.elementAt(i);
					
					    
					for (int j = 0; j < vcEnemy.size(); j++) {
						//添加爆炸效果
						//取出敌机容器的每个元与主角子弹遍历判断
						if (vcEnemy.elementAt(j).isCollsionWith(blPlayer)) {
							mark+=(10+lv);
							if(bulletlv>=9)
							    GamingEnemy.enHp=GamingEnemy.enHp-player.harm-100;   
							if(bulletlv==7||bulletlv==8)
							  GamingEnemy.enHp=GamingEnemy.enHp-player.harm-10*bulletlv;
							if(bulletlv<7&&bulletlv>=4)
								GamingEnemy.enHp=GamingEnemy.enHp-player.harm-10*bulletlv;
							if(bulletlv<4){
							  GamingEnemy.enHp=GamingEnemy.enHp-player.harm-10*bulletlv;
						
							  blPlayer.isDead=true;							
							}
							  //主角子弹消亡
							if(GamingEnemy.enHp<=0)
							{
								mark+=(5+1*lv);
								enemy.isDead=true;
								kill++;
						       blPlayer.isDead=true;
						      GamingKey.key2();
							vcBoom.add(new GamingBoom(Boom, vcEnemy.elementAt(j).x, vcEnemy.elementAt(j).y, 7));		
							}
						}
					}
				}
			} else {//Boss相关逻辑
				
				boss.logic();
				
				//Boss子弹逻辑
				for (int i = 0; i < vcBulletBoss.size(); i++){
					GamingBullet b = vcBulletBoss.elementAt(i);
					if (b.isDead) {
						vcBulletBoss.removeElement(b);
					} else {
						b.logic();
					}
				}
				//Boss子弹与主角的碰撞
				for (int i = 0; i < vcBulletBoss.size(); i++) {

					try{
					if (player.isCollsionWith(vcBulletBoss.elementAt(i))) {
		//				//发生碰撞，主角血量-1					
						if(player.unbeatable==false){
						GamingKey.key();
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);														
							hurt++;
							 player.setPlayerHp(player.getPlayerHp() - 1);
							 player.unbeatable=true;
						}				  					
				    //当主角血量小于0，判定游戏失败
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
					}catch(Exception e){}
				}
				//Boss被主角子弹击中，产生爆炸效果
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
					GamingBullet b = vcBulletPlayer.elementAt(i);
					
					if (boss.isCollsionWith(b)) {
						if (boss.hp <= 0) {	
							 GamingKey.key2();
							 kill++;
							 if(GamingPlaneTest.isSound)
						      {
						    	  GameLoading.mediaplayer1.pause();
						    	  GameLoading.mediaplayer.start();
						      }
							mark+=(100+50*lv);
							vcBulletBoss.removeAllElements();
						    isBoss=false;
						    lv+=2;    //1，3，5, 8，11，    //血量增加迅速
						    if(lv>=5)
						    	lv+=1;    
						    if(lv>=8)
						    	lv+=1;    
						    playSound(6,0);
						   
						    for(int k = 0;k<=10;k++){	
						    	pointX1=player.pointX;
						    	if(pointX1<screenW/2-boss.frameW/2)
						    	{
						    		pointX1=screenW/2-boss.frameW/2;
						    	}
						    	if(pointX1>screenW/2+boss.frameW/2)
						    	{
						    		pointX1=screenW/2+boss.frameW/2;
						    	}
						         vcBoom.add(new GamingBoom(BoosBoom,pointX1-10,  boss.y+boss.Boss.getHeight()/2, 5));
							     vcBoom.add(new GamingBoom(BoosBoom, pointX1-20, boss.y+20, 5));
							     vcBoom.add(new GamingBoom(BoosBoom, pointX1-30, boss.y+boss.Boss.getHeight()/2, 5));							    
						    	 vcBoom.add(new GamingBoom(BoosBoom, pointX1+10,boss.y+10, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,pointX1+20, boss.y+boss.Boss.getHeight()/2, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,pointX1+30, boss.y+30, 5));						     
						    }
						} else {
							//及时删除本次碰撞的子弹，防止重复判定此子弹与Boss碰撞、
							mark+=(30+lv);
							if(bulletlv<4){
								  boss.setHp(boss.hp - player.harm-bulletlv*10);
								  b.isDead = true;	
							}
								if(bulletlv==7||bulletlv==8){
								   boss.setHp(boss.hp - player.harm-bulletlv*10);
								   b.isDead=true;
								}
								if(bulletlv>=9)
									boss.setHp(boss.hp - player.harm-100);
								else{
								   boss.setHp(boss.hp - player.harm-bulletlv*10);
								   b.isDead=true;
								}
							//在Boss上添加三个Boss爆炸效果							
							playSound(5,0);
							pointX1=player.pointX;
					    	if(pointX1<screenW/2-boss.frameW/2)
					    	{
					    		pointX1=screenW/2-boss.frameW/2;
					    	}
					    	if(pointX1>screenW/2+boss.frameW/2)
					    	{
					    		pointX1=screenW/2+boss.frameW/2;
					    	}
							vcBoom.add(new GamingBoom(BoosBoom, pointX1, boss.y+boss.Boss.getHeight()/2,5));
							vcBoom.add(new GamingBoom(BoosBoom, pointX1,boss.y+20 , 5));
							vcBoom.add(new GamingBoom(BoosBoom, pointX1,boss.y+10 , 5));
						}
					}
				}
			}
			
			//Buff逻辑
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isDead) {
					vcBuff.removeElement(buff);
					//子弹等级+1;  !!!buff.type!!!
					//TODO  宇航
					if(player.type==4&&player.getPlayerHp() < 5)
					{
						 player.setPlayerHp(player.getPlayerHp() + 1);
					}
					else{
					if(buff.type==1)
					   bulletlv+=1;
					if(buff.type==2){
						//player.playerHp+=1;
						//主角血量+1；最高为5
						if(player.getPlayerHp() < 5){
					      player.setPlayerHp(player.getPlayerHp() + 1);
						}	
					}
					if(buff.type==3)
						   player.unbeatable=true;	
					}
				} else {
					buff.logic();
				}
			}
		
			//每1秒添加一个主角子弹
			countPlayerBullet++;

			if (countPlayerBullet % 4 == 0&&GamingBoss.chuchang==false) {
				if(bulletlv<4){
				 vcBulletPlayer.add(new GamingBullet(Bulletp1, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				//子弹位置记录，不再使用static。
				//vpBullet.add(new Bullet(player.pointX,player.pointY));
				// vcBulletPlayer.add(new Bullet(Bulletp2,  player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				// vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				}
				if(bulletlv>=4&&bulletlv<7){
				//	 vcBulletPlayer.add(new Bullet(Bulletp2, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					// vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					//vpBullet.add(new Bullet(player.pointX,player.pointY));
					vcBulletPlayer.add(new GamingBullet(Bullet1,  player.pointX , player.pointY -40, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				}
				if(bulletlv>=7&&bulletlv<9)
				{
				//	 vcBulletPlayer.add(new Bullet(Bulletp2, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				//	 vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				//	vpBullet.add(new Bullet(player.pointX,player.pointY));
					vcBulletPlayer.add(new GamingBullet(Bullet2,  player.pointX , player.pointY - 150, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				}
				if(bulletlv>=9)
				{
				//	vpBullet.add(new Bullet(player.pointX,player.pointY));
					vcBulletPlayer.add(new GamingBullet(jiguang, player.pointX, player.pointY+player.player.getHeight()/2 , player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
					bcount++;
					//钟声
					if(bulletlv>=80){
						if(bcount==30)
						{
							bulletlv=GamingBaoXian.c;   
							vcBulletPlayer.removeAllElements();						
							bcount=0;						
						}
					}
					if(player.type==2)
					{
						if(bcount==30)
						{
							bulletlv=GamingKey.c;   
							vcBulletPlayer.removeAllElements();						
							bcount=0;						
						}
					}
					else{
					if(bcount==50)
					{
						vcBulletPlayer.removeAllElements();
						bcount=0;
						bulletlv=7;   //跳为7
					}
					}
				}
				
				
			}
			//处理主角子弹逻辑
			for (int i = 0; i < vcBulletPlayer.size(); i++) {
				GamingBullet b = vcBulletPlayer.elementAt(i);
              
				if (b.isDead) {
					vcBulletPlayer.removeElement(b);
				
				} else {
					b.logic();
				}
			}
              //处理buff与主角的碰撞 
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isCollsionWith(vcBuff.elementAt(i))) {
					buff.isDead=true;
					playSound(9,0);
				}
			}
			//爆炸效果逻辑
			for (int i = 0; i < vcBoom.size(); i++) {
				GamingBoom boom = vcBoom.elementAt(i);
				if (boom.end) {
					//播放完毕的从容器中删除
					vcBoom.removeElementAt(i);
				} else {
					vcBoom.elementAt(i).logic();
				}
			}
			break;
		case GAME_PAUSE:
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_SHEZHI: 
			break;
		case GAME_SHEZHI_BANGZHU: 
			break;
		case GAME_SHEZHI_GUANYU: 
			break;
		case GAME_SHEZHI_SHENGMING: 
			break;

		}
	}

	/**
	 * 无尽随机模式游戏逻辑
	 * TODO 
	*/
	@SuppressWarnings("unused")
	private void wujin() {
		
		
		//逻辑处理根据游戏状态不同进行不同处理
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:			
			//背景逻辑
			backGround.logic();
			//主角逻辑
			player.logic();
			 
			//保险是否打开
			 if(bx.bxkg){						
					bx.logic();
					vcEnemy.removeAllElements();
					vcBullet.removeAllElements();
					vcBulletBoss.removeAllElements();
					if(isBoss){
						  boss.setHp(boss.hp -1000);
						  if(boss.hp<=0){
							  isBoss=false;
						  }
					}
					if(player.type==5){
						if(bx.frameIndex>=2)
						{
							bx.frameIndex=0;
						}
						bx.frameIndex++;
						
					}
				}
			//宇航 被动
		 GamingKey.key1();
			
			int enemyArray[]= new int [6];
			int bnum = (int)(Math.random()*20);
			int ennum = (int)(Math.random()*3)+3;  //3~6	
	
			if(isBoss==false){
			if(bnum!=0){
			     for(int k = 0;k<=ennum;k++)
			    {
				   enemyArray[k]=(int)(Math.random()*4+4);  //1~4			
			    } 
			}
			else{
				 if(ennum==3)
				      enemyArray[0]=-2;  //  boss。///应为随机boss
				 if(ennum==4)
					  enemyArray[0]=-1;
				 if(ennum==5)
					  enemyArray[0]=-3;
				 if(ennum==2)
					  enemyArray[0]=-4;
				 if(ennum==1)
					  enemyArray[0]=-5;					 
			}
			}
			//敌机逻辑
			if (isBoss == false) {
				//敌机逻辑
				dead();
				//生成敌机
				count++;
				if (count % createEnemyTime == 0) {
					for (int i = 0; i < enemyArray.length; i++) {
						
						if (enemyArray[i] == 1) {
							int x = random.nextInt(screenW - 100) + 50;
							vcEnemy.addElement(enemy=new GamingEnemy(EnemyF1, 1, x, -50));
							
						} else if (enemyArray[i] == 2) {
							int y = random.nextInt(20);
							vcEnemy.addElement(enemy=new GamingEnemy(EnemyF2, 2, -50, y));
						
						} else if (enemyArray[i] == 3) {
							int y = random.nextInt(20);
							vcEnemy.addElement(enemy=new GamingEnemy(EnemyF2, 3, screenW + 50, y));
						}
						
						else if (enemyArray[i] == 4) {
							int x = random.nextInt(screenW - 100) + 50;
							vcEnemy.addElement(enemy=new GamingEnemy(Enemy4, 4, x, -50));
						
						}
						else if (enemyArray[i] == 5) {
							int x = random.nextInt(screenW - 100) + 50;
							vcEnemy.addElement(enemy=new GamingEnemy(Enemyzisa, 5, x, -50));
						}	
						else if (enemyArray[i] == 6) {
							int y = random.nextInt(20);		
							vcEnemy.addElement(enemy=new GamingEnemy(Enemyzisa, 6, -5, y));
						}	
						else if (enemyArray[i] == 7) {
							int x = random.nextInt(screenW - 100) + 50;	
							vcEnemy.addElement(enemy=new GamingEnemy(Enemyzisa, 7, x, -2));
						}	
						if (enemyArray[i] < 0) {
							//警告画面
							//Warning.draw(canvas,  War, 300, 300,paint);	
							
							//优化boss出场，1： 出现警报声音 2： 在上方绘图  3：  ！！！！如和清空其他道具，警报图片消失后再出现boss
							//  推理， 调用警报图片的绘图方法,~~~!!!!  
							// boss的类型
							if(enemyArray[i]==-1){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos,1);
							}
							if(enemyArray[i]==-2){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos2,2);
							}
							if(enemyArray[i]==-3){
								//实例boss对象
								boss = new GamingBoss(boss6,3);
							}
							if(enemyArray[i]==-4){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos1,4);
							}
							if(enemyArray[i]==-5){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos3,5);
							}
							//清空屏幕
							isBoss = true;
							vcBulletPlayer.removeAllElements();
							vcEnemy.removeAllElements();
							vcBullet.removeAllElements();
							vcBuff.removeAllElements();						
							boss.setHp(20000+5000*lv);;
							
						}	
				
											
					}						
				}
				
				//处理敌机与主角的碰撞
				for (int i = 0; i < vcEnemy.size(); i++) {
					if (player.unbeatable=false&&player.isCollsionWith(vcEnemy.elementAt(i))) {
						//发生碰撞，主角血量-1
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						player.setPlayerHp(player.getPlayerHp() - 1);
						hurt++;
						//TODO 当主角血量小于0，判定游戏失败
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
				}
				//每2秒添加一个敌机子弹
				countEnemyBullet++;
				if (countEnemyBullet % 60 == 0) {
					for (int i = 0; i < vcEnemy.size(); i++) {
						GamingEnemy en = vcEnemy.elementAt(i);
						//不同类型敌机不同的子弹运行轨迹
						int bulletType = 0;
						switch (en.type) {
						
						case GamingEnemy.TYPE_F1:
							bulletType = GamingBullet.BULLET_F1;
							vcBullet.add(new GamingBullet(zidan10, en.x + 10, en.y + 20,bulletType)); 
					// vcBullet.add(new Bullet(EnemyBullet, en.x + 10, en.y + 20,player.pointX,player.pointY, bulletType,bulletlv));
							break;
						
						case GamingEnemy.TYPE_F3:
							bulletType = GamingBullet.BULLET_F2;
							vcBullet.add(new GamingBullet(zhidan3, en.x + 10, en.y + 20,bulletType));
							break;
						case GamingEnemy.TYPE_F2:
							bulletType = GamingBullet.BULLET_F2;
							vcBullet.add(new GamingBullet(zhidan3, en.x + 10, en.y + 20,bulletType));
					// vcBullet.add(new Bullet(zhidan2, en.x + 10, en.y + 20,player.pointX,player.pointY, bulletType,bulletlv));
							break;
							
						case GamingEnemy.TYPE_A:
							bulletType=GamingBullet.BULLET_A;
							break;
							
						}
						
					}
				}
				//处理敌机子弹逻辑
				for (int i = 0; i < vcBullet.size(); i++) { 
					GamingBullet b = vcBullet.elementAt(i);
					if (b.isDead) {
						vcBullet.removeElement(b);
					} else {
						b.logic();
					}
				}			
				//处理敌机子弹与主角碰撞
				for (int i = 0; i < vcBullet.size(); i++) {
					if (player.isCollsionWith(vcBullet.elementAt(i))) {
						//发生碰撞，主角血量-1
						
						if(player.unbeatable==false){
						GamingKey.key();
						//震动开关
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);							
						if(bulletlv>1)
						      bulletlv-=1;					
							hurt++;
					        player.setPlayerHp(player.getPlayerHp() - 1);
					        player.unbeatable=true;
					        }				
				    //当主角血量小于0，判定游戏失败
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}			
				}
				//处理主角子弹与敌机碰撞				
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
					//取出主角子弹容器的每个元素
					GamingBullet blPlayer = vcBulletPlayer.elementAt(i);
					//TODO
				
					for (int j = 0; j < vcEnemy.size(); j++) {
						//添加爆炸效果
						//取出敌机容器的每个元与主角子弹遍历判断
						//TDDO 伤害
						if (vcEnemy.elementAt(j).isCollsionWith(blPlayer)) {
							if(bulletlv>=9)
							    GamingEnemy.enHp=GamingEnemy.enHp-player.harm-100;   
							if(bulletlv==7||bulletlv==8)
							  GamingEnemy.enHp=GamingEnemy.enHp-player.harm-10*bulletlv;
							if(bulletlv<7&&bulletlv>=4)
								GamingEnemy.enHp=GamingEnemy.enHp-player.harm-10*bulletlv;
							if(bulletlv<4){
							  GamingEnemy.enHp=GamingEnemy.enHp-player.harm-10*bulletlv;						
							  blPlayer.isDead=true;							
							}
							if(GamingEnemy.enHp<=0)
							{
								kill++;
								 GamingKey.key2();
								mark+=(30+lv);	
								enemy.isDead=true;
						       blPlayer.isDead=true; 						     
							vcBoom.add(new GamingBoom(Boom, vcEnemy.elementAt(j).x, vcEnemy.elementAt(j).y, 7));
							}
						}
					}
				}
			}else {//Boss相关逻辑
				//每0.5秒添加一个子弹
				boss.logic();
				//if (countPlayerBullet % 15== 0) {
					//Boss的没发疯之前的普通子弹
				//	if(Boss.chuchang==false)
				//	         vcBulletBoss.add(new Bullet(BossBullet, boss.x +(boss.frameW/2)-16, boss.y + 40,player.pointX,player.pointY, Bullet.BULLET_B,bulletlv));
				//}
				//Boss子弹逻辑
				for (int i = 0; i < vcBulletBoss.size(); i++) {
					GamingBullet b = vcBulletBoss.elementAt(i);
					if (b.isDead) {
						vcBulletBoss.removeElement(b);
					} else {
						b.logic();
					}
				}
				//Boss子弹与主角的碰撞
          for (int i = 0; i < vcBulletBoss.size(); i++) {
					try{
						GamingBullet b = vcBulletBoss.elementAt(i);
					if (player.isCollsionWith(vcBulletBoss.elementAt(i))) {
		//				//发生碰撞，主角血量-1						
						
						if(player.unbeatable==false){
						GamingKey.key();
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);							
							hurt++;
					        player.setPlayerHp(player.getPlayerHp() - 1);
					        player.unbeatable=true;
					        }		
					  
					   if(bulletlv>1)
					       bulletlv-=1;
				    //当主角血量小于0，判定游戏失败
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
					}catch(Exception e){}
				}
				//Boss被主角子弹击中，产生爆炸效果
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
					GamingBullet b = vcBulletPlayer.elementAt(i);
					
					if (boss.isCollsionWith(b)) {
						if (boss.hp <= 0) {	
							 GamingKey.key2();
							 kill++;
							 if(GamingPlaneTest.isSound)
						      {
								 GameLoading.mediaplayer1.pause();
						    	  GameLoading.mediaplayer.start();
						      }
							mark+=(100+lv);
							vcBulletBoss.removeAllElements();
						    isBoss=false;
						    lv+=2;    //1，3，5, 8，11，    //血量增加迅速
						    if(lv>=5)
						    	lv+=1;    
						    if(lv>=8)
						    	lv+=1;    
						    playSound(6,0);
						    for(int k = 0;k<=10;k++){	
						    	pointX1=player.pointX;
						    	if(pointX1<screenW/2-boss.frameW/2)
						    	{
						    		pointX1=screenW/2-boss.frameW/2;
						    	}
						    	if(pointX1>screenW/2+boss.frameW/2)
						    	{
						    		pointX1=screenW/2+boss.frameW/2;
						    	}
						         vcBoom.add(new GamingBoom(BoosBoom,pointX1-10,  boss.y+boss.Boss.getHeight()/2, 5));
							     vcBoom.add(new GamingBoom(BoosBoom, pointX1-20, boss.y+20, 5));
							     vcBoom.add(new GamingBoom(BoosBoom, pointX1-30, boss.y+boss.Boss.getHeight()/2, 5));							    
						    	 vcBoom.add(new GamingBoom(BoosBoom, pointX1+10,boss.y+10, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,pointX1+20, boss.y+boss.Boss.getHeight()/2, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,pointX1+30, boss.y+30, 5));						  
						    }
						} else {
							//及时删除本次碰撞的子弹，防止重复判定此子弹与Boss碰撞、
							mark+=(30+lv);
							if(bulletlv<4){
								  boss.setHp(boss.hp - player.harm-bulletlv*10);
								  b.isDead = true;	
							}
								if(bulletlv==7||bulletlv==8){
								   boss.setHp(boss.hp - player.harm-bulletlv*10);
								   b.isDead=true;
								}
								if(bulletlv>=9)
									boss.setHp(boss.hp - player.harm-100);
								else{
								   boss.setHp(boss.hp - player.harm-bulletlv*10);
								   b.isDead=true;
								}
							//在Boss上添加三个Boss爆炸效果							
							playSound(5,0);
							//TODO
							pointX1=player.pointX;
					    	if(pointX1<screenW/2-boss.frameW/2)
					    	{
					    		pointX1=screenW/2-boss.frameW/2;
					    	}
					    	if(pointX1>screenW/2+boss.frameW/2)
					    	{
					    		pointX1=screenW/2+boss.frameW/2;
					    	}
							vcBoom.add(new GamingBoom(BoosBoom, pointX1, boss.y+boss.Boss.getHeight()/2,5));
							vcBoom.add(new GamingBoom(BoosBoom, pointX1,boss.y+20 , 5));
							vcBoom.add(new GamingBoom(BoosBoom, pointX1,boss.y+10 , 5));
						}
					}
				}
			}
		
			//Buff逻辑
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isDead) {
					vcBuff.removeElement(buff);					 
					//子弹等级+1;  !!!buff.type!!!
					if(player.type==4&&player.getPlayerHp() < 5)
					{
						player.setPlayerHp(player.getPlayerHp() + 1);
					}
					else{
					if(buff.type==1)
					   bulletlv+=1;
					if(buff.type==2){
						//player.playerHp+=1;
						//主角血量+1；最高为5
						if(player.getPlayerHp() < 5){
					      player.setPlayerHp(player.getPlayerHp() + 1);
						}
					}
					if(buff.type==3)
						   player.unbeatable=true;	
					}
				} else {
					buff.logic();
				}
			}
		
			//每1秒添加一个主角子弹
			countPlayerBullet++;

			if (countPlayerBullet % 4 == 0&&GamingBoss.chuchang==false) {
				if(bulletlv<4){
					//vpBullet.add(new Bullet(player.pointX,player.pointY));
				 vcBulletPlayer.add(new GamingBullet(Bulletp1, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				// vcBulletPlayer.add(new Bullet(Bulletp2,  player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				// vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				}
				 if(bulletlv>=4&&bulletlv<7){
					// vpBullet.add(new Bullet(player.pointX,player.pointY));
				//	 vcBulletPlayer.add(new Bullet(Bulletp2, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					// vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					vcBulletPlayer.add(new GamingBullet(Bullet1,  player.pointX , player.pointY -40, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				}
				if(bulletlv>=7&&bulletlv<9)
				{
				///	vpBullet.add(new Bullet(player.pointX,player.pointY));
				//	 vcBulletPlayer.add(new Bullet(Bulletp2, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				//	 vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					vcBulletPlayer.add(new GamingBullet(Bullet2,  player.pointX , player.pointY - 150, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				}
				if(bulletlv>=9)
				{
				//	vpBullet.add(new Bullet(player.pointX,player.pointY));
					vcBulletPlayer.add(new GamingBullet(jiguang, player.pointX, player.pointY , player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
					bcount++;
					//TODO  钟声
					if(bulletlv>=80){
						if(bcount==30)
						{
							bulletlv=GamingBaoXian.c;   
							vcBulletPlayer.removeAllElements();						
							bcount=0;						
						}
					}
					if(player.type==2)
					{
						if(bcount==30)
						{
							bulletlv=GamingKey.c;   
							vcBulletPlayer.removeAllElements();						
							bcount=0;						
						}
					}
					else{
					if(bcount==50)
					{
						vcBulletPlayer.removeAllElements();
						bcount=0;
						bulletlv=7;   //跳为7
					}
					}
				}
				
				
			}
			//处理主角子弹逻辑
			for (int i = 0; i < vcBulletPlayer.size(); i++) {
				GamingBullet b = vcBulletPlayer.elementAt(i);
				
				if (b.isDead) {
					vcBulletPlayer.removeElement(b);
					
				} else {
					b.logic();
				}
			}
	         //处理buff与主角的碰撞
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isCollsionWith(vcBuff.elementAt(i))) {
					buff.isDead=true;	
					playSound(9,0);
				}
			}
			//爆炸效果逻辑
			for (int i = 0; i < vcBoom.size(); i++) {
				GamingBoom boom = vcBoom.elementAt(i);
				if (boom.end) {
					//播放完毕的从容器中删除
					vcBoom.removeElementAt(i);
				} else {
					vcBoom.elementAt(i).logic();
				}
			}
			break;
		}
	}
	/**
	 * 剧情模式游戏逻辑
	 * TODO
	*/
private void juqing() {
		
		
		//逻辑处理根据游戏状态不同进行不同处理
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:
			//背景逻辑
			backGround.logic();
			//主角逻辑
			player.logic();
			 if(bx.bxkg){						
					bx.logic();								
					vcBulletBoss.removeAllElements();					
					if(bx.frameIndex>=2)
					{
						bx.frameIndex=0;
					}
				}
			count1++;
			if(count1%200==0)
			{
				//添加BUFF	
				int k = (int)( Math.random()*3);
			
					
				if(k==1)
			      vcBuff.add(new GamingBuff(Buff,screenW / 2 ,0,1));	
				if(k==2)
				  vcBuff.add(new GamingBuff(Buff2,screenW / 2 ,0,2));	
				if(k==3)
				   vcBuff.add(new GamingBuff(Buff3,screenW / 2 ,0,3));	
				
			}
			if(isBoss==false){
				count++;
				if (count % (createEnemyTime+10) == 0) {
			//	.println(k);
			//	.println(bossArray[bossArrayIndex][k]);
							if(bossArray[bossArrayIndex][k]==-1){
								//实例boss对象
								vcBulletPlayer.removeAllElements();
							
								boss = new GamingBoss(EnemyBoos,1);								
								isBoss=true;
								boss.setHp(20000*(k+1)*(bossArrayIndex+1));
								z=0;
								break;
								
							}
							if(bossArray[bossArrayIndex][k]==-2){
								//实例boss对象
								boss = new GamingBoss(EnemyBoos2,2);
								vcBulletPlayer.removeAllElements();
							
								
								isBoss=true;
								//增长很快
								boss.setHp(20000*(k+1)*(bossArrayIndex+1));
								z=0;
								break;						
							}
							if(bossArray[bossArrayIndex][k]==-3){
								//实例boss对象
								boss = new GamingBoss(boss6,2);							
								vcBulletPlayer.removeAllElements();							
								isBoss=true;
								//增长很快
								boss.setHp(20000*(k+1)*(bossArrayIndex+1));
								z=0;
								break;						
							}
              			//若为0，胜利
							else  {		
								//数据存储
								SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
								SharedPreferences.Editor editor=prefs.edit();
								if(bossArrayIndex==0)
								   editor.putBoolean("is_tongguan1",true);
								if(bossArrayIndex==1)
									   editor.putBoolean("is_tongguan2",true);
								if(bossArrayIndex==2)
									   editor.putBoolean("is_tongguan3",true);
								if(bossArrayIndex==3)
									   editor.putBoolean("is_tongguan4",true);
								if(bossArrayIndex==4)
									   editor.putBoolean("is_tongguan5",true);
								if(bossArrayIndex==5)
									   editor.putBoolean("is_tongguan6",true);
								if(bossArrayIndex==6)
									   editor.putBoolean("is_tongguan7",true);
								if(bossArrayIndex==7)
									   editor.putBoolean("is_tongguan8",true);
								if(bossArrayIndex==8)
									   editor.putBoolean("is_tongguan9",true);
								 editor.commit();
							gameState =GAME_WIN;
							k=0;
							
						}		
				}
			}
			
			  //Boss相关逻辑
				//每0.5秒添加一个子弹
			if(isBoss){			
				boss.logic();
				GamingKey.key1();
				if (countPlayerBullet % 15== 0) {
					//Boss的没发疯之前的普通子弹
					//vcBulletBoss.add(new Bullet(BossBullet, boss.x + 35, boss.y + 40,player.pointX,player.pointY, Bullet.BULLET_F1,bulletlv));
				}
				//Boss子弹逻辑
				for (int i = 0; i < vcBulletBoss.size(); i++) {
					GamingBullet b = vcBulletBoss.elementAt(i);
					if (b.isDead) {
						vcBulletBoss.removeElement(b);
					} else {
						b.logic();
					}
				}
				 for (int i = 0; i < vcBulletBoss.size(); i++) {
						try{
						if (player.isCollsionWith(vcBulletBoss.elementAt(i))) {
			//				//发生碰撞，主角血量-1
							
							if(player.unbeatable==false){
							GamingKey.key();
							if(MainActivity.vikg)
							    MainActivity.vibrator.vibrate(pattern,-1);  
							playSound(3,0);													
						        player.setPlayerHp(player.getPlayerHp() - 1);
						        player.unbeatable=true;
						        }		
						  
					    //当主角血量小于0，判定游戏失败
							if (player.getPlayerHp() <= -1) {
								gameState = GAME_LOST;
							}
						}
						}catch(Exception e){}
					}
				//Boss被主角子弹击中，产生爆炸效果
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
				
					GamingBullet b = vcBulletPlayer.elementAt(i);
					
				
					if (boss.isCollsionWith(b)) {
						
						if (boss.hp <= 0) {										
							//boss死亡
							 GamingKey.key2();
							mark++;
							isBoss=false;
							 if(GamingPlaneTest.isSound)
						      {
								 GameLoading.mediaplayer1.pause();
						    	 GameLoading.mediaplayer.start();
						      }
							 if(z==0){
							    k++;
							 }
							 z++;
							vcBulletBoss.removeAllElements();
						    playSound(6,0);
						    count++;
						    for(int k = 0;k<=10;k++){
						    	if(player.pointX<screenW/2-boss.frameW/2)
						    	{
						    		player.pointX=screenW/2-boss.frameW/2;
						    	}
						    	if(player.pointX>screenW/2+boss.frameW/2)
						    	{
						    		player.pointX=screenW/2+boss.frameW/2;
						    	}
						    	vcBoom.add(new GamingBoom(BoosBoom, player.pointX,  boss.y+boss.Boss.getHeight()/2, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,player.pointX, boss.y+20, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,player.pointX, boss.y+boss.Boss.getHeight()/2, 5));							    
						    	 vcBoom.add(new GamingBoom(BoosBoom,player.pointX,boss.y+10, 5));
							     vcBoom.add(new GamingBoom(BoosBoom, player.pointX, boss.y+boss.Boss.getHeight()/2, 5));
							     vcBoom.add(new GamingBoom(BoosBoom,player.pointX, boss.y+30, 5));							     				     
						    }
						    
						} else {
							//及时删除本次碰撞的子弹，防止重复判定此子弹与Boss碰撞、
							mark+=(30+lv);
							if(bulletlv<4){
								  boss.setHp(boss.hp - player.harm-bulletlv*10);
								  b.isDead = true;	
							}
								if(bulletlv==7||bulletlv==8){
								   boss.setHp(boss.hp - player.harm-bulletlv*10);
								   b.isDead=true;
								}
								if(bulletlv>=9)
									boss.setHp(boss.hp - player.harm-100);
								else{
								   boss.setHp(boss.hp - player.harm-bulletlv*10);
								   b.isDead=true;
								}
							//在Boss上添加三个Boss爆炸效果
							
							playSound(5,0);
							pointX1=player.pointX;
					    	if(pointX1<screenW/2-boss.frameW/2)
					    	{
					    		pointX1=screenW/2-boss.frameW/2;
					    	}
					    	if(pointX1>screenW/2+boss.frameW/2)
					    	{
					    		pointX1=screenW/2+boss.frameW/2;
					    	}
							vcBoom.add(new GamingBoom(BoosBoom, pointX1, boss.y+boss.Boss.getHeight()/2,5));
							vcBoom.add(new GamingBoom(BoosBoom, pointX1,boss.y+20 , 5));
							vcBoom.add(new GamingBoom(BoosBoom, pointX1,boss.y+10 , 5));
						}
					}
				}
				
				}
			
			//Buff逻辑
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isDead) {
					vcBuff.removeElement(buff);	
					if(player.type==4&&player.getPlayerHp() < 5){
						player.setPlayerHp(player.getPlayerHp() + 1);
					}
					//子弹等级+1;  !!!buff.type!!!
					else{
					if(buff.type==1)
					   bulletlv+=1;
					if(buff.type==2){
						//player.playerHp+=1;
						//主角血量+1；最高为5
						if(player.getPlayerHp() < 5){
					      player.setPlayerHp(player.getPlayerHp() + 1);
						}
					}
					}
				} else {
					buff.logic();
				}
			}
		
			//每1秒添加一个主角子弹
			countPlayerBullet++;

			if (countPlayerBullet % 4 == 0&&GamingBoss.chuchang==false) {
				if(bulletlv<4)
				
				 vcBulletPlayer.add(new GamingBullet(Bulletp1, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				// vcBulletPlayer.add(new Bullet(Bulletp2,  player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				// vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				if(bulletlv>=4&&bulletlv<7){
					
				//	 vcBulletPlayer.add(new Bullet(Bulletp2, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					// vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					vcBulletPlayer.add(new GamingBullet(Bullet1,  player.pointX , player.pointY -40, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				}
				if(bulletlv>=7&&bulletlv<9)
				{
					
				//	 vcBulletPlayer.add(new Bullet(Bulletp2, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
				//	 vcBulletPlayer.add(new Bullet(Bulletp3, player.pointX+Player.Player.getWidth()+20 , player.pointY - 20, player.pointX , player.pointY - 20, Bullet.BULLET_liaoji,bulletlv));
					vcBulletPlayer.add(new GamingBullet(Bullet2,  player.pointX , player.pointY - 150, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				}
				if(bulletlv>=9)
				{
					
					vcBulletPlayer.add(new GamingBullet(jiguang, player.pointX, player.pointY , player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
					bcount++;
					if(bulletlv>=80){
						if(bcount==30)
						{
							bulletlv=GamingBaoXian.c;   
							vcBulletPlayer.removeAllElements();						
							bcount=0;						
						}
					}
					if(player.type==2)
					{
						if(bcount==30)
						{
							bulletlv=GamingKey.c;   
							vcBulletPlayer.removeAllElements();						
							bcount=0;						
						}
					}
					else{
					if(bcount==50)
					{
						vcBulletPlayer.removeAllElements();
						bcount=0;
						bulletlv=7;   //跳为7
					}
					}
				}
			}
			//处理主角子弹逻辑
			for (int i = 0; i < vcBulletPlayer.size(); i++) {
				try{
				GamingBullet b = vcBulletPlayer.elementAt(i);
				
				if (b.isDead) {
					vcBulletPlayer.removeElement(b);
									
				}				
				else {
					b.logic();
				}
				}catch(Exception e){}
			}
             //处理buff与主角的碰撞
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isCollsionWith(vcBuff.elementAt(i))) {
					buff.isDead=true;	
					playSound(9,0);
				}
			}
			//爆炸效果逻辑
			for (int i = 0; i < vcBoom.size(); i++) {
				GamingBoom boom = vcBoom.elementAt(i);
				if (boom.end) {
					
					vcBoom.removeElementAt(i);
				} else {
					vcBoom.elementAt(i).logic();
				}
			}
			break;

		}
	}


	@Override
	public void run() {
		while (flag) {
			long start = System.currentTimeMillis();
			
			myDraw();
			//执行不同的游戏逻辑
			if(GameMenu.game==1)
			jingdian();
			if(GameMenu.game==2)
			wujin();
			if(GameMenu.game==3)
			juqing();
			long end = System.currentTimeMillis();
			try {
				if (end - start < 50) {
					Thread.sleep(50 - (end - start));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		public void dead(){
		for (int i = 0; i < vcEnemy.size(); i++) {
			 enemy = vcEnemy.elementAt(i);
			//因为容器不断添加敌机 ，那么对敌机isDead判定，
			//如果已死亡那么就从容器中删除,对容器起到了优化作用；
			if (enemy.isDead) {
				//添加BUFF	
				int k = (int)( Math.random()*15);
				if(k==1)
			      vcBuff.add(new GamingBuff(Buff,enemy.x,enemy.y,1));	
				if(k==2)
				  vcBuff.add(new GamingBuff(Buff2,enemy.x,enemy.y,2));	
				if(k==3)
				   vcBuff.add(new GamingBuff(Buff3,enemy.x,enemy.y,3));	
				vcEnemy.removeElementAt(i);
				
				
			} else {
				enemy.logic();
			}
		}
		}
	/**
	 * SurfaceView视图状态发生改变，响应此函数
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	/**
	 * SurfaceView视图消亡时，响应此函数
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;
		soundPool.release();
		//yinyue 背景音乐关闭
		mediaplayer.stop();
		mediaplayer.release();
		MainActivity.instance.finish();
		System.exit(0);		
	}
}
