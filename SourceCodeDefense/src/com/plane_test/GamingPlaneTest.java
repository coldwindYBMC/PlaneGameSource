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
	//ս�������ж�
	private int sp1=0;
	public static int hurt=0,kill=0,gold=0;
	//����ģʽ����
	private int z;
	public static int screenW, screenH;
	//����
	public static int mark=0;
	//��������
	public static boolean isSound;
	//��ʱ��
	long [] pattern = {100,400,100,400};	
	private boolean is_plane1,is_plane2,is_plane3,is_plane4,is_plane5;
	//������Ϸ״̬����
	public static final int GAME_MENU = 0;//��Ϸ�˵�
	public static final int GAME_MENU1 = 99;//��Ϸ�˵�1
	public static final int GAMEING = 1;//��Ϸ��
	public static final int GAME_WIN = 2;//��Ϸʤ��
	public static final int GAME_LOST = 3;//��Ϸʧ��
	public static final int GAME_JIESUAN = 4;//����ҳ��
	public static final int GAME_SHOP_DAOJU = 5;//�̵����
	public static final int GAME_SHOP_FEIJI = 6;//�̵�ɻ�
	public static final int GAME_SHOP_XUNBAO =7;//�̵�Ѱ��
	public static final int GAME_SHOP_XUNBAOS =8;//�̵�Ѱ��
	public static final int GAME_SHOP_QUEREN =31;//�̵�ȷ��
	public static final int GAME_SHOP_NOMONEY =32;//�̵��Ǯ����
	public static final int GAME_SELECTPLANE1 = 15;//ս���л�
	public static final int GAME_SELECTPLANE2 = 16;//ս���л�
	public static final int GAME_SELECTPLANE3 = 17;//ս���л�
	public static final int GAME_SELECTPLANE4 = 18;//ս���л�
	public static final int GAME_SELECTPLANE5 = 19;//ս���л�
	public static final int GAME_PAUSE = -1;//��Ϸ��ͣ
	public static final int GAME_EXIT = 9;//�˳�����
	public static final int GAMEING_EXIT = 10;//you��Ϸ�е��˳�����
	public static final int GAME_STATE1 = 21;//�ؿ�һ
	public static final int GAME_STATE2 = 22;//�ؿ�һ
	public static final int GAME_STATE3 = 23;//�ؿ�һ
	public static final int GAME_STATE4 = 24;//�ؿ�һ
	public static final int GAME_STATE5 = 25;//�ؿ�һ
	public static final int GAME_STATE6 = 26;//�ؿ�һ
	public static final int GAME_STATE7 = 27;//�ؿ�һ
	public static final int GAME_STATE8 = 28;//�ؿ�һ
	public static final int GAME_STATE9 = 29;//�ؿ�һ
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
	public static final int GAME_SHEZHI = 40;//���ý���
	public static final int GAME_SHEZHI_BANGZHU = 41;//���ð������
	public static final int GAME_SHEZHI_GUANYU = 42;//���ù��ڽ���
	public static final int GAME_SHEZHI_SHENGMING = 43;//������������
	public static final int GAME_LOADING1 = 51;
	
	public static final int GAME_JUQING = 60;//���鰴ť�ı���
	public static final int GAME_JUQING_STORY1 = 62;//�������1
	public static final int GAME_JUQING_STORY2 = 63;//�������2
	public static final int GAME_JUQING_STORY3 = 64;//�������3
	public static final int GAME_JUQING_STORY4 = 65;//�������4
	public static final int GAME_JUQING_STORY5 = 66;//�������5
	public static final int GAME_JUQING_STORY6 = 67;//�������6
	public static final int GAME_JUQING_STORY7 = 68;//�������7
	public static final int GAME_JUQING_STORY8 = 69;//�������8
	public static final int GAME_JUQING_STORY9 = 70;//�������9
	public static final int GAME_JUQING_STORY10 = 71;//�������10
	public static final int GAME_JUQING_STORY11 = 72;//�������11
	public static final int GAME_JUQING_STORY12 = 73;//�������12
	public static final int GAME_JUQING_STORY13 = 74;//�������13
	public static final int GAME_JUQING_STORY14 = 75;//�������14
	public static final int GAME_JUQING_STORY15 = 76;//�������15
	//��ǰ��Ϸ״̬(Ĭ�ϳ�ʼ����Ϸ�˵�����)
	public static int gameState = GAME_MENU;
	//�ӵ��ȼ�
	public static int bulletlv=1;
	//����ģʽ�����ж�
	public static int k=0;
	private int bcount=0;
	//����һ��Resourcesʵ�����ڼ���ͼƬ
	 Resources res = this.getResources();
	//������Ϸ��Ҫ�õ���ͼƬ��Դ(ͼƬ����)
	 public static Bitmap jsm;
	 private GamingBaoXian bx;
	 public static Bitmap coinb;
	private Bitmap BackGround;//��Ϸ����
	static Bitmap Boom;//��ըЧ��
	static Bitmap BoosBoom;//Boos��ըЧ��
	private Bitmap EnemyF2;//����Ѽ��
	private Bitmap Enemy4;//�ɻ�1
	private Bitmap EnemyF1;//�ɻ�1
	private Bitmap Enemyzisa;
	private Bitmap EnemyBoos;//Boos
	private Bitmap EnemyBoos2;//boss2
	private Bitmap EnemyBoos1;//boss2
	private Bitmap EnemyBoos3;//boss2
	static Bitmap waring;//Ԥ��
	static Bitmap zidan6;
	private static Bitmap zidan10;
	private Bitmap jiguang;
	private Bitmap pause;
	static Bitmap bx1;
	static Bitmap bx2;
	static Bitmap bxb;
	static Bitmap cn;
	public static Bitmap Player;//����
	public static  Bitmap Player1;//����
	public static Bitmap Player2;//��ͩ
	public static Bitmap Player3;//�
	public static Bitmap Player5;//����
	public static Bitmap PlayerHp;//���Ƿɻ�Ѫ��
	public static Bitmap PlayerHp0;//���Ƿɻ�Ѫ��
	public static Bitmap PlayerHp1;//���Ƿɻ�Ѫ��
	public static Bitmap PlayerHp2;//���Ƿɻ�Ѫ��
	public static Bitmap PlayerHp3;//���Ƿɻ�Ѫ��
	public static Bitmap PlayerHp4;//���Ƿɻ�Ѫ��
	public static Bitmap PlayerHp5;//���Ƿɻ�Ѫ��
	static Bitmap zhidan1;//�л��ӵ�
	static Bitmap zhidan2;//�л�����
	static Bitmap zhidan5;//�л��ӵ�
	static Bitmap zidanb2;
	static Bitmap zidanb6;
	static Bitmap zidanb7;
	static Bitmap zidanb9;
	static Bitmap zidan8;
	static Bitmap zidan7;
	static Bitmap zidan11;
	static Bitmap zidan12;
	static Bitmap baozazidan;
	public static Bitmap zhidan3;//�л��ӵ�3
	public static Bitmap bdd;//boss����
	private  Bitmap Bulletp1;//�ӵ�
	private  Bitmap Bullet1;//�ӵ�����
	public static  Bitmap Bullet2;//�ӵ�����
	public static Bitmap BossBullet;//Boss�ӵ�
	private  Bitmap Buff;  //�ӵ�����buff
	private  Bitmap Buff2; //������Ѫbuff
	private Bitmap Buff3;//����buff
	private Bitmap button_jingdian;////����ģʽ
	private Bitmap button_juqing;//����ģʽ
	private Bitmap juqing_guanqia;//ju����ģʽ�Ĺؿ�ͼƬ
	private Bitmap juqing_tongguo;//ju����ģʽ��ͨ��
	private Bitmap juqing_state1_dialog;//�ؿ�һ
	private Bitmap juqing_state2_dialog;//�ؿ���
	private Bitmap juqing_state3_dialog;//�ؿ���
	private Bitmap juqing_state4_dialog;//�ؿ���
	private Bitmap juqing_state5_dialog;//�ؿ���
	private Bitmap juqing_state6_dialog;//�ؿ���
	private Bitmap juqing_state7_dialog;//�ؿ���
	private Bitmap juqing_state8_dialog;//�ؿ���
	private Bitmap juqing_state9_dialog;//�ؿ���
	//�ؿ�һ�ĶԻ�
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
	private Bitmap button_shezhi;//���ð�ť
	private Bitmap button_wujin;//�޾�ģʽ
	public static Bitmap button_zhanjiqiehuan;//ս���л�
	private Bitmap button_jingdian_press;////����ģʽ����ȥ
	private Bitmap button_juqing_press;//����ģʽ��ť����ȥ
	private Bitmap button_wujin_press;//�޾�ģʽ��ť����ȥ
	private Bitmap ams_xingxing;//����
	private Bitmap tuichu;//�Ƴ�����
	private Bitmap tuichu_queding;//�˳�ȷ��
	private Bitmap tuichu_quxiao;//�˳�ȡ��
	private Bitmap gameing_back;//�Ƴ�����
	//��Ϸ���˳�����Ŀؼ�
	private Bitmap button_continue;
	private Bitmap button_back_menu;
	//���ý����е�ͼƬ
	private Bitmap shezhi_fanhui;
	private Bitmap shezhi_guanyu;
	private Bitmap shezhi_bangzhu;
	private Bitmap shezhi_shengming;
	private Bitmap shezhi_mengban;
	private Bitmap shezhi_fanhui_press;
	private Bitmap shezhi_duihao;
	//����
	private Bitmap score;//��������
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
	
	//���ȵ�ҳ��
	private Bitmap jindu1;
	//y��Ϸ���������ͼƬ
	private Bitmap lock_zhongli;
	//�������
	private Bitmap jiesuan_again;
	private Bitmap jiesuan_again_press;
	private Bitmap jiesuan_back;
	private Bitmap jiesuan_back_press;
    private Bitmap jiesuan_mengban;
	//ʤ����ʧ�ܽ���
	private Bitmap juqing_game_win;
	private Bitmap juqing_game_lost;
	//ս���л�����
	private Bitmap plane_anyeleiting;
	private Bitmap plane_anyeyingxue;
	private Bitmap plane_huangjinzhanjia;
	private Bitmap plane_lengyanhanfeng;
	private Bitmap plane_moshangyanyun;
	private Bitmap button_houtui;
	private Bitmap button_houtui_press;
	private Bitmap button_qianjin;
	private Bitmap button_qianjin_press;
	//�̵�
	private Bitmap shop_daoju;
	private Bitmap shop_shangpin;
	private Bitmap shop_queren;
	private Bitmap shop_nomoney;
	private Bitmap shop_nobuy;
	private Bitmap shop_buy;
	private Bitmap shop_mengban;
	private Bitmap shop_xunbao;
	//����һ���˵�����
	private GameMenu gameMenu;
	
	private Bitmap boss6;
	//����һ���˳�����
	private Game_exit game_exit;
	private Gaming_exit gaming_exit;
	//����һ������������
	private GameLoading gameloading;
	//����ģʽҳ��
	private Game_juqing game_juqing;
	private static Game_state1 game_state1;//��һ��
	private static Game_state2 game_state2;//�ڶ���
	private static Game_state3 game_state3;//������
	private static Game_state4 game_state4;//���Ĺ�
	private static Game_state5 game_state5;//�����
	private static Game_state6 game_state6;//������
	private static Game_state7 game_state7;//���߹�
	private static Game_state8 game_state8;//�ڰ˹�
	private static Game_state9 game_state9;//�ھŹ�
	//����һ��������Ϸ��������
	private GameingBg backGround;
	private Gameing_button gameb;
	//s���ý���
	private Game_shezhi game_shezhi;
	//����
	private GamingNum_cal num_cal;
	public static GamingJsNum jsnum;
	//����
	private Game_jiesuan game_jiesuan;
	//ʤ������
	private Game_Win game_win;
	//ʧ�ܽ���
	private Game_Lost game_lost;
	//ս���л�
	private Game_SelectPlane game_selectplane;
	//�̵�
	private Game_Shop game_shop;
	private Game_Querengoumai game_querengoumai;
	private Game_NoMoney game_nomoney;
	//�������Ƕ���
	public static GamingPlayer player;
	// �����л�
	private GamingEnemy enemy;
	//����һ���л�����
	public static Vector<GamingEnemy> vcEnemy;
	// ����һ��buff����
	public static Vector<GamingBuff> vcBuff;
	//ÿ�����ɵл���ʱ��(����)
	private int createEnemyTime =100;
	private int count;//������
	private int count1;//������
	public static int lv=1;
	//�������飺1��2��ʾ�л������࣬-1��ʾBoss
	//��ά�����ÿһά����һ�����
	private int enemyArray[][] = {{2,2,1,5,5,7,5,5,5}, {1,2,3,6,7} ,{7,7,4,4,1,1},{5,5,5,7,7,7,6,6},{6,6,7,7},{4,4,7,7},{ -2 },
		{2,2},{2,1,1,2,2,1},{2,2,1,5,5,7,5,7,5},{7,7,4,4,1,1},{1,1,2,2,1,1,5,5,5},{6,6,4,2,1,2,3},{-2},
		{7,7,4,4,1,1},{1,1,2,1},{2,1,1,2,2,1},{3,2,1},{1,1,5,5},{1,1,2,2,1,1,5,5,5},{1,2,2,4,5,2,1,2,6,},{-4},
		{2,1,2}, {6,7},{2,1,1,2,2,1},{5,5,5,7,7,7,6,6},{7,7,4,4,1,1}, {6,3,2,5,7} ,{4,2,1,5,7,5,3,2},{-2},
		{7,7,4,4,1,1},{5,5,5,7,7,7,6,6},{5,5,5,7,7,7,6,6},{7,7,4,4,1,1}, {6,3,2,5,7} ,{6,7,3,2,1,3,5},{-3},
		{1,1,2,2,1,1,5,5,5},{5,5,5,7,7,7,6,6},{5,5,5,7,7,7,6,6},{1,1,2,2,1,1,5,5,5},{7,7,4,4,1,1},{2,4,7,4,2,1,3,5,6,2},{-4},
		{1,1,2,1},{2,1,1,2,2,1},{3,2,1},{1,1,5,5},{1,1,2,2,1,1,5,5,5},{1,1,1},{2,2},{2,2}, { 2, 1,2 },{2,1,1,2,2,1},{2,2},{1,1,2,1},{2,1,1,2,5,2,1},{4,4,4,4,7,7,7,7},{-4},
		{2,1,2},{1,2,3,4,5,6,7},{3,3,3,5,6,7,4,}, {6,7},{2,1,1,2,2,1},{5,5,5,7,7,7,6,6},{7,7,7,7,6,6,6,6,},{7,7,4,4,1,1},{-5},{0}};
	//����ģʽ boss����
	private int bossArray[][]={{-1,-2,-3,0},{-2,-3,-2,0},{-1,-4,-2,-3,0},{-3,-2,-3,0},{-1,-4,-3,0},{-2,-3,-4,0},{-3,-1,-4,-5,0},{-3,-2,-5,0},{-3,-2,-5,-4,-5,0}};
	//��ǰȡ��һά������±�
	public static int enemyArrayIndex;
	//��ǰȡ��һά������±�  ����
	public static int bossArrayIndex;
	//�Ƿ����Boss��ʶλ
	public static boolean isBoss;
	private Random random;
	//�л��ӵ�����
	public static Vector<GamingBullet> vcBullet;
	//����ӵ��ļ�����
	private int countEnemyBullet;
	//�����ӵ�����
	public static Vector<GamingBullet> vcBulletPlayer;
	//����ӵ��ļ�����
	static int countPlayerBullet;
	//��ըЧ������
	static Vector<GamingBoom> vcBoom;
	//����Boss
	private GamingBoss boss;
	//����buff
	private GamingBuff buff;
	
	private int test_W;
	private int test_H;
	public static float scaleWidth;//����
	public static float scaleHeight;//����
	//Boss���ӵ�����
	public static Vector<GamingBullet> vcBulletBoss;
    public static MediaPlayer mediaplayer; 
	//static MediaPlayer mediaplayer1; 
	//static MediaPlayer mediaplayer2; 
	public static MediaPlayer mediaplayer2; 
	public static MediaPlayer mediaplayer3; 
	public static MediaPlayer mediaplayer4; 
	SoundPool soundPool;//����
	HashMap<Integer, Integer> soundPoolMap; 
	Context context;
	private int mProgress=0;
	private int mProgressBar = 0; 
	/**
	 * SurfaceView��ʼ������
	 */
	public GamingPlaneTest(Context context) {
		super(context);
		this.context=context;
		sfh = this.getHolder();
		sfh.addCallback(this);
		  //���ݶ�ȡ
		SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
		isSound =prefs.getBoolean("isSound",true);//�������ֿ���
		paint = new Paint();
		mpaint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);
		mpaint.setColor(Color.RED);
		mpaint.setTextSize(24);
		setFocusable(true);
		setFocusableInTouchMode(true);
		//���ñ�������
		this.setKeepScreenOn(true);
		//���ñ���͸��
		setZOrderOnTop(true);
		//�̶��÷�������͸��
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
	 * SurfaceView��ͼ��������Ӧ�˺���
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		screenW = this.getWidth();
		screenH = this.getHeight();
		initSounds();
		load();
		test_H = juqing_game_win.getHeight();//ͼƬ�ĸ߶�
	    test_W = juqing_game_win.getWidth();//ͼƬ�Ŀ��
		scaleWidth = ((float) screenW) /test_W;//���������
	    scaleHeight = ((float) screenH ) /test_H;//�����߶�
	    //��ֵ����ÿһ������	   
	    GameMenu.scaleWidth=scaleWidth;
	    GameMenu.scaleHeight=scaleHeight;
		flag = true;
		//ʵ���߳�
		th = new Thread(this);
		//�����߳�
		th.start();    
	}
	/*
	 *TODO �Զ������Ϸ��ʼ������
	 */
	private void load() {
		//������Ϸ�����̨���½�����Ϸʱ����Ϸ������!
		//����Ϸ״̬���ڲ˵�ʱ���Ż�������Ϸ		
			//��Ϸ�����еİ�ť
		   
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
			 //���µ�
			button_juqing_press = BitmapFactory.decodeResource(res, R.drawable.button_juqing_press);
			//����ģʽ�ؿ�			
			button_wujin_press = BitmapFactory.decodeResource(res, R.drawable.button_wujin_press);
			button_jingdian_press=BitmapFactory.decodeResource(res, R.drawable.button_jingdian_press);
			//�˳����棬�Լ����ǵİ�ť
			tuichu_queding=BitmapFactory.decodeResource(res, R.drawable.tuichu_queding);
			tuichu_quxiao=BitmapFactory.decodeResource(res, R.drawable.tuichu_quxiao);
            jsm=BitmapFactory.decodeResource(res, R.drawable.jsm);
			//����ҳ��
			jindu1=BitmapFactory.decodeResource(res, R.drawable.jindu1);
			shezhi_fanhui=BitmapFactory.decodeResource(res, R.drawable.shezhi_fanhui);
			shezhi_fanhui_press=BitmapFactory.decodeResource(res, R.drawable.shezhi_fanhui_press);
			//����
			juqing_guanqia=BitmapFactory.decodeResource(res, R.drawable.juqing_guanqia);
			juqing_tongguo=BitmapFactory.decodeResource(res, R.drawable.juqing_tongguo);
			juqing_state1_dialog=BitmapFactory.decodeResource(res, R.drawable.juqing_state1_dialog);
			
			//���ý���
			shezhi_guanyu=BitmapFactory.decodeResource(res, R.drawable.shezhi_guanyu);
			shezhi_shengming=BitmapFactory.decodeResource(res, R.drawable.shezhi_shengming);
			shezhi_bangzhu=BitmapFactory.decodeResource(res, R.drawable.shezhi_bangzhu);
			shezhi_mengban=BitmapFactory.decodeResource(res, R.drawable.shezhi_mengban);
			shezhi_duihao=BitmapFactory.decodeResource(res, R.drawable.shezhi_duihao);
			//�����еİ�������
			coinb=BitmapFactory.decodeResource(res, R.drawable.coinb);	
			//��Ϸʤ������
			juqing_game_win =BitmapFactory.decodeResource(res, R.drawable.game_win);	
			//������
			gameMenu = new GameMenu(ams_xingxing,button_jingdian,button_juqing,button_shezhi,button_wujin,
					button_zhanjiqiehuan,
					button_jingdian_press,button_juqing_press,button_wujin_press,button_shangdian,context);
			//����
			game_shezhi = new Game_shezhi(shezhi_fanhui,shezhi_guanyu,shezhi_bangzhu,
					shezhi_shengming,shezhi_mengban,shezhi_fanhui_press,shezhi_duihao,context);
			//�������
			 gameloading =new GameLoading(jindu1,context);
	}
	  public void Loading() throws InterruptedException {
	    switch (mProgress) {
		case 0:
			//������Ϸ��Դ
			vcEnemy = new Vector<GamingEnemy>();
			//ʵ�������
			random = new Random();
			//---Boss���
			//ʵ��boss����
			//boss = new Boss(EnemyBoos);			
			//ʵ��Boss�ӵ�����
			vcBulletBoss = new Vector<GamingBullet>();
			//��ըЧ������ʵ��
			vcBoom = new Vector<GamingBoom>();
			//�л��ӵ�����ʵ��
			vcBullet = new Vector<GamingBullet>();
			//�����ӵ�����ʵ��
			vcBulletPlayer = new Vector<GamingBullet>();    
			// buff ����
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
			 zidan10=BitmapFactory.decodeResource(res, R.drawable.zidan10);//ѩ��
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

		    //  BOSS����
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
			//ʧ�ܽ���
			juqing_game_lost =BitmapFactory.decodeResource(res, R.drawable.game_lost);
			//ʤ����ʧ�ܽ���//����
			jiesuan_again=BitmapFactory.decodeResource(res, R.drawable.jiesuan_again);
			jiesuan_again_press=BitmapFactory.decodeResource(res, R.drawable.jiesuan_again_press);
			jiesuan_back=BitmapFactory.decodeResource(res, R.drawable.jiesuan_back);
			jiesuan_back_press=BitmapFactory.decodeResource(res, R.drawable.jiesuan_back_press);
			jiesuan_mengban =BitmapFactory.decodeResource(res, R.drawable.jiesuan_mengban);
		    break;
		case 9:
			
			//��������
			score=BitmapFactory.decodeResource(res, R.drawable.score);
			score_fenshu=BitmapFactory.decodeResource(res, R.drawable.score_fenshu);
		    break;
		case 10:
			//��Ϸ���������У׼��ť
		
		    break;
		case 11:
		    break;
		}
		mProgressBar = (100 / 12) * mProgress;
		mProgress++;
	    // �����ʾ���ȼ������ 
	    if (mProgressBar >= 100) {
		gameState=GAMEING;
	    }
	}
	//����
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
	 * TODO ��Ϸ��ͼ
	 */
	public void myDraw() {
		try {
			canvas = sfh.lockCanvas();
			 //���ݶ�ȡ
			 Matrix matrix = new Matrix();
		     matrix.postScale(scaleWidth, scaleHeight);  
			SharedPreferences  prefs =PreferenceManager.getDefaultSharedPreferences(context) ;
			if (canvas != null) {
				canvas.drawColor(Color.WHITE);
				//��ͼ����������Ϸ״̬��ͬ���в�ͬ����
				switch (gameState) {
				//������
				case GAME_LOADING1:
					Loading() ;
					//������ʵ����
					game_jiesuan = new Game_jiesuan(jiesuan_again,jiesuan_again_press,jiesuan_back,
							jiesuan_back_press,jiesuan_mengban,context);  
					//ʤ������
					game_win = new Game_Win(juqing_game_win,jiesuan_again,jiesuan_again_press,jiesuan_back,
							jiesuan_back_press);
					//ʧ�ܽ���
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
	
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					//�˵��Ļ�ͼ����
					gameMenu.draw(canvas, paint);
				
					if(isSound)
					{
					  mediaplayer.start();
					}
					  break;
				case GAMEING:	
					//��Ϸ����
					mProgress=5;
					backGround.draw(canvas, paint);
					 if(bx.bxkg){
					      bx.draw(canvas, paint);
					 }
					 bx.draw1(canvas, mpaint);
					if(MainActivity.zlkg&&MainActivity.zlsz)
							gameb.draw(canvas, paint);			
					//canvas.drawText("������"+mark, 20, 20,mpaint);  					   
					if (isBoss == false) {
                       // buff
						if(isSound){
							GameLoading.mediaplayer.start();
						}
						for(int i = 0;i<vcBuff.size();i++)
						{
							vcBuff.elementAt(i).draw(canvas, paint);
						}
						//�л�����
						for (int i = 0; i < vcEnemy.size(); i++) {
							vcEnemy.elementAt(i).draw(canvas, paint);
						}
						//�л��ӵ�����
						for (int i = 0; i < vcBullet.size(); i++) {
							vcBullet.elementAt(i).ebdraw(canvas, paint);
						}
					} else {
						//Boos�Ļ���		
						
						boss.draw(canvas, paint);
						
						//Boss�ӵ��߼�
						for (int i = 0; i < vcBulletBoss.size(); i++) {
							vcBulletBoss.elementAt(i).ebdraw(canvas, paint);
						}
					}
					//���������ӵ�����
					for (int i = 0; i < vcBulletPlayer.size(); i++) {
						vcBulletPlayer.elementAt(i).pdraw(canvas, paint);
					}
					//��ըЧ������
					for (int i = 0; i < vcBoom.size(); i++) {
						vcBoom.elementAt(i).draw(canvas, paint);
					}
					//���ǻ�ͼ����				
					 player.draw(canvas, paint);	
					//����
					int score_width=score.getWidth();
					int score_height=score.getHeight();
					Bitmap score_new  = Bitmap.createBitmap(score,0,0,score_width,score_height, matrix, true);
					int score_new_width=score_new.getWidth();
					int score_new_height=score_new.getHeight();
					int score_new_value=score_new_width/10;
					GamingNum_cal.score_new_value=score_new_value;
					//�����Ŀ�Ⱥ͸߶�
					int score_fenshu_width=score_fenshu.getWidth();
					int score_fenshu_height=score_fenshu.getHeight();
					Bitmap score_fenshu_new  = Bitmap.createBitmap(score_fenshu,0,0,score_fenshu_width,score_fenshu_height, matrix, true);
					int score_fenshu_new_width=score_fenshu_new.getWidth();
					GamingNum_cal.score_fenshu_new_width=score_fenshu_new_width;
					// surce���������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
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
					//������Ϸ
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
					//������Ϸ
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
					//TODO  ����
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
					//��ʼλ��                
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
						}catch(Exception e){Log.d("���ִ���","Mysurfaceview  926");}
						}
				
					break;
				case GAME_EXIT:
					//�˳�����
					tuichu=BitmapFactory.decodeResource(res, R.drawable.tuichu);
					game_exit = new Game_exit(tuichu,tuichu_queding,tuichu_quxiao);
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					//�˵��Ļ�ͼ����
					paint.setAlpha( 75 );//����͸����   
					gameMenu.draw(canvas, paint);
					// ȡ����Ҫ���ŵ�matrix����
					paint.setAlpha(255); 
					game_exit.draw(canvas, paint);
					break;
				case GAMEING_EXIT:
					//ʵ����Ϸ����
					//y��Ϸ�е��˳������еİ�ť
					gameing_back=BitmapFactory.decodeResource(res, R.drawable.gameing_back);
					button_back_menu=BitmapFactory.decodeResource(res, R.drawable.button_back_menu);
					button_continue=BitmapFactory.decodeResource(res, R.drawable.button_continue);
					gaming_exit = new Gaming_exit(gameing_back,button_continue,button_back_menu);
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);
					//�˵��Ļ�ͼ����
					paint.setAlpha( 185 );//����͸����   
					backGround.draw(canvas, paint);
					//���ǻ�ͼ����				
					player.draw(canvas, paint);								   
					// ȡ����Ҫ���ŵ�matrix����
					paint.setAlpha(255); 
					gaming_exit.draw(canvas, paint);
					break;
				case GAME_JUQING:	
					if(isSound)
					{  try
						{
							mediaplayer.pause();
							mediaplayer4.start();
						}catch(Exception e){Log.d("���ִ���","Mysurfaceview ");}
					}
				
					//����ҳ��
					game_juqing= new Game_juqing(shezhi_fanhui,shezhi_fanhui_press,juqing_guanqia,juqing_tongguo,context);
					//�˵��Ļ�ͼ����
					game_juqing.draw(canvas, paint);
					  break;
				case GAME_STATE1:
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//������µ��и�
				
					//����ͼƬ�Ĵ�С
					int juqing_state1_dialog_W=juqing_state1_dialog.getWidth();
					int juqing_state1_dialog_H=juqing_state1_dialog.getHeight();
					//��ȡ��ͼƬ
					Bitmap juqing_state1_dialog_new  = Bitmap.createBitmap(juqing_state1_dialog,0,0,juqing_state1_dialog_W,juqing_state1_dialog_H, matrix, true);
					//��ͼƬ�Ŀ�Ⱥ͸߶�
					int juqing_state1_dialog_new_width=juqing_state1_dialog_new.getWidth();
					int juqing_state1_dialog_new_height=juqing_state1_dialog_new.getHeight();
					int juqing_state1_value=juqing_state1_dialog_new_height/9;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state1_dialog_new,0,0,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*2,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*3,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*4,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*5,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog7 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*6,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog8 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*7,juqing_state1_dialog_new_width,juqing_state1_value); 
					juqing_state_dialog9 = Bitmap.createBitmap(juqing_state1_dialog_new,0,juqing_state1_value*8,juqing_state1_dialog_new_width,juqing_state1_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state2_dialog_W=juqing_state2_dialog.getWidth();
					int juqing_state2_dialog_H=juqing_state2_dialog.getHeight();
					int juqing_state2_value=juqing_state2_dialog_H/6;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state2_dialog,0,0,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*2,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*3,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*4,juqing_state2_dialog_W,juqing_state2_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state2_dialog,0,juqing_state2_value*5,juqing_state2_dialog_W,juqing_state2_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state3_dialog_W=juqing_state3_dialog.getWidth();
					int juqing_state3_dialog_H=juqing_state3_dialog.getHeight();
					int juqing_state3_value=juqing_state3_dialog_H/4;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state3_dialog,0,0,juqing_state3_dialog_W,juqing_state3_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state3_dialog,0,juqing_state3_value,juqing_state3_dialog_W,juqing_state3_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state3_dialog,0,juqing_state3_value*2,juqing_state3_dialog_W,juqing_state3_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state3_dialog,0,juqing_state3_value*3,juqing_state3_dialog_W,juqing_state3_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state4_dialog_W=juqing_state4_dialog.getWidth();
					int juqing_state4_dialog_H=juqing_state4_dialog.getHeight();
					int juqing_state4_value=juqing_state4_dialog_H/5;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state4_dialog,0,0,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value*2,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value*3,juqing_state4_dialog_W,juqing_state4_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state4_dialog,0,juqing_state4_value*4,juqing_state4_dialog_W,juqing_state4_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state5_dialog_W=juqing_state5_dialog.getWidth();
					int juqing_state5_dialog_H=juqing_state5_dialog.getHeight();
					int juqing_state5_value=juqing_state5_dialog_H/5;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state5_dialog,0,0,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value*2,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value*3,juqing_state5_dialog_W,juqing_state5_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state5_dialog,0,juqing_state5_value*4,juqing_state5_dialog_W,juqing_state5_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state6_dialog_W=juqing_state6_dialog.getWidth();
					int juqing_state6_dialog_H=juqing_state6_dialog.getHeight();
					int juqing_state6_value=juqing_state6_dialog_H/7;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state6_dialog,0,0,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*2,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*3,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*4,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*5,juqing_state6_dialog_W,juqing_state6_value); 
					juqing_state_dialog7 = Bitmap.createBitmap(juqing_state6_dialog,0,juqing_state6_value*6,juqing_state6_dialog_W,juqing_state6_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state7_dialog_W=juqing_state7_dialog.getWidth();
					int juqing_state7_dialog_H=juqing_state7_dialog.getHeight();
					int juqing_state7_value=juqing_state7_dialog_H/4;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state7_dialog,0,0,juqing_state7_dialog_W,juqing_state7_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state7_dialog,0,juqing_state7_value,juqing_state7_dialog_W,juqing_state7_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state7_dialog,0,juqing_state7_value*2,juqing_state7_dialog_W,juqing_state7_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state7_dialog,0,juqing_state7_value*3,juqing_state7_dialog_W,juqing_state7_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state8_dialog_W=juqing_state8_dialog.getWidth();
					int juqing_state8_dialog_H=juqing_state8_dialog.getHeight();
					int juqing_state8_value=juqing_state8_dialog_H/4;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state8_dialog,0,0,juqing_state8_dialog_W,juqing_state8_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state8_dialog,0,juqing_state8_value,juqing_state8_dialog_W,juqing_state8_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state8_dialog,0,juqing_state8_value*2,juqing_state8_dialog_W,juqing_state8_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state8_dialog,0,juqing_state8_value*3,juqing_state8_dialog_W,juqing_state8_value); 
					// �ؿ�����
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
					//�˵��Ļ�ͼ����
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					paint.setAlpha( 185 );//����͸����   
					game_juqing.draw(canvas, paint);
					paint.setAlpha(255); 
					//����ͼƬ�Ĵ�С
					int juqing_state9_dialog_W=juqing_state9_dialog.getWidth();
					int juqing_state9_dialog_H=juqing_state9_dialog.getHeight();
					int juqing_state9_value=juqing_state9_dialog_H/8;
					//   �������õ�ͼƬԴ;
				    //   x������x�������ʼλ��;
				    //   y������y�������ʼλ��;
				     //  width�����õĿ��;
				    //   height�����õĸ߶�
					juqing_state_dialog1 = Bitmap.createBitmap(juqing_state9_dialog,0,0,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog2 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog3 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*2,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog4 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*3,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog5 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*4,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog6 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*5,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog7 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*6,juqing_state9_dialog_W,juqing_state9_value); 
					juqing_state_dialog8 = Bitmap.createBitmap(juqing_state9_dialog,0,juqing_state9_value*7,juqing_state9_dialog_W,juqing_state9_value); 
					/// �ؿ�����
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
					//��ͼ����	
					//ս������
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
					//�̵�
					shop_daoju=BitmapFactory.decodeResource(res, R.drawable.shop_daoju);
				
					shop_shangpin=BitmapFactory.decodeResource(res, R.drawable.shop_shangpin);
					shop_nobuy=BitmapFactory.decodeResource(res, R.drawable.shop_nobuy);
					shop_buy=BitmapFactory.decodeResource(res, R.drawable.shop_buy);
				
                    shop_xunbao=BitmapFactory.decodeResource(res, R.drawable.shop_xunbao);
					//�̵�
					game_shop= new Game_Shop(shezhi_fanhui,shezhi_fanhui_press,shop_daoju
							,shop_shangpin, shop_buy,shop_nobuy,shop_xunbao, context);
					//����
					//��ͼ����	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
				    game_shop.draw1(canvas, paint);
					break;
				case GAME_SHOP_FEIJI:
					//��ͼ����	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
				    game_shop.draw2(canvas, paint);
					break;
				case GAME_SHOP_XUNBAO:
					//��ͼ����	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_shop.draw3(canvas, paint);
					break;
				case GAME_SHOP_XUNBAOS:
					//��ͼ����	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_querengoumai.draw2(canvas, paint);
					break;
				case GAME_SHOP_QUEREN:
					shop_queren = BitmapFactory.decodeResource(res, R.drawable.shop_queren);
					shop_mengban=BitmapFactory.decodeResource(res, R.drawable.shop_mengban);
					//��ͼ����	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_querengoumai= new Game_Querengoumai(shop_queren,tuichu_queding,tuichu_quxiao,shop_mengban,context);
					game_querengoumai.draw(canvas, paint);
					break;
				case GAME_SHOP_NOMONEY:
					shop_nomoney = BitmapFactory.decodeResource(res, R.drawable.shop_nomoney);
					//��ͼ����	
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);	
					game_nomoney= new Game_NoMoney(shop_nomoney, tuichu_queding, tuichu_quxiao,context);
					game_nomoney.draw(canvas, paint);
					break;
				case GAME_SHEZHI:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//��ͼ����		   
					game_shezhi.draw(canvas, paint);
					break;
				case GAME_SHEZHI_BANGZHU:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//��ͼ����		
					game_shezhi.draw1(canvas, paint);
					//��������
					//Typeface face = Typeface.createFromAsset (getAssets() , "ziti.TTF");  
				    //paint.setTypeface(face);
					///////////////////////////
					paint.setColor(getResources().getColor(R.color.ghostwhite));//��ɫ
					paint.setTextSize(MainActivity.TEXT_SIZE_50);
					canvas.drawText("����",screenW/20*8,screenH/20*4, paint);
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					canvas.drawText("         ����ģʽ������ͨ�أ��������յ�BOSS�����л�",0,screenH/20*5, paint);
					canvas.drawText("   ���е��ӵ��ȼ����½���                                             ",0,screenH/20*6, paint);
					canvas.drawText("         �޾�ģʽ�������޾��ĵ��ˣ�����ʱ�������Ѷ�",0,screenH/20*7, paint);
					canvas.drawText("   ��ȫ����ĵл�ÿһ�ζ��ǲ�ͬ�����飬��ȫ���ܳ��� ",0,screenH/20*8, paint);
					canvas.drawText("   ������һ���Ѳ���BOSS�����л������ӵ��ȼ��½���    ",0,screenH/20*9, paint);
					canvas.drawText("         ����ģʽ��BOSSս����ÿһ�ض����������BOSS",0,screenH/20*10,paint);
					canvas.drawText("   ������������BUFFЧ�������ֱ��л������ӵ��ȼ�����",0,screenH/20*11,paint);	
					canvas.drawText("   ����                                                                            ",0,screenH/20*12,paint);	
					canvas.drawText("         �ƶ��������ƶ�����Ļ������һ��������ק��    ",0,screenH/20*13,paint);	
					canvas.drawText("         �����ƶ��������д������������������ƶ���",0,screenH/20*14,paint);	
					canvas.drawText("   ��������Ϸ����������ֻ�λ�÷�������������������",0,screenH/20*15,paint);	
					canvas.drawText("   ������Ӧ������Բ����ֻ���ֱ���ֻ��ȼ���λ������",0,screenH/20*16,paint);	
					canvas.drawText("   �����ƶ����������ƶ���Ӧ������ƣ�������ȥ��Ӧ��",0,screenH/20*17,paint);	
					canvas.drawText("   ���ƶ�������Ϸ�е��������ť���������ǰ�ֻ���λ",0,screenH/20*18,paint);	
					canvas.drawText("   �á�        ",0,screenH/20*19,paint);	
					break;
				case GAME_SHEZHI_GUANYU:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//��ͼ����		
					paint.setColor(Color.YELLOW);
					game_shezhi.draw1(canvas, paint);
					paint.setColor(getResources().getColor(R.color.ghostwhite));//��ɫ
					paint.setTextSize(MainActivity.TEXT_SIZE_50);//�����С
					canvas.drawText("����",screenW/20*8,screenH/20*4, paint);
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					canvas.drawText("	 ",screenW/20*3,screenH/20*6,paint);	
					canvas.drawText("	 �����Ŷӣ���ѿ�������Ŷ�        ",screenW/20*3,screenH/20*7,paint);	
					canvas.drawText("	 �ܲ߻���    ���      ",screenW/20*3,screenH/20*8,paint);	
					canvas.drawText("	 ������ƣ����    ������        ",screenW/20*3,screenH/20*9,paint);	
					canvas.drawText("	 ������ƣ����        ",screenW/20*3,screenH/20*10,paint);	
					canvas.drawText("	 ������ƣ�������    ����ͩ    ������        ",screenW/20*3,screenH/20*11,paint);	
					canvas.drawText("	 ������ƣ�������        ",screenW/20*3,screenH/20*12,paint);	
					canvas.drawText("	 ָ����ʦ������        ",screenW/20*3,screenH/20*13,paint);	
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					break;
				case GAME_SHEZHI_SHENGMING:
					canvas.drawColor(Color.TRANSPARENT,Mode.CLEAR);		
					//��ͼ����		
					paint.setColor(Color.YELLOW);
					game_shezhi.draw1(canvas, paint);
					paint.setColor(getResources().getColor(R.color.ghostwhite));//��ɫ
					paint.setTextSize(MainActivity.TEXT_SIZE_50);//�����С
					canvas.drawText("����",screenW/20*8,screenH/20*4, paint);
					paint.setTextSize(MainActivity.TEXT_SIZE_28);
					canvas.drawText("                       ",screenW/20*3,screenH/20*6,paint);	
					canvas.drawText("����Ϸ��Ϊ��ѿ��Ϸ����Ŷӿ�������",screenW/20*3,screenH/20*7,paint);	
					canvas.drawText("����Ϸ��Ϊ��³�����ƴ���������Ʒ��",screenW/20*3,screenH/20*8,paint);
					canvas.drawText("��ֹ����������ҵ��;��",screenW/20*3,screenH/20*9,paint);
					canvas.drawText("���ڱ���Ϸ���������⣬����ϵ��Ϸ���ʦ",screenW/20*3,screenH/20*10,paint);	
					canvas.drawText("���ʦ���䣺xiazhongsheng@outlook.com",screenW/20*3,screenH/20*11,paint);	
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
	 * �����¼�����
	 */
	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouchEvent(MotionEvent event) {
		//���������¼�����������Ϸ״̬��ͬ���в�ͬ����
		switch (gameState) {
		case GAME_MENU:
			//�˵��Ĵ����¼�����
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
	 * �������·��ؼ��¼�����
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//����back���ذ���
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			//��Ϸʤ����ʧ�ܡ�����ʱ��Ĭ�Ϸ��ز˵�
			if ( gameState == GAME_WIN || gameState == GAME_LOST) {
				gameState = GAME_MENU;
				//Boss״̬����Ϊû����
				isBoss = false;
				//������Ϸ
				load();
				//���ù������
				enemyArrayIndex = 0;
				bossArrayIndex=0;
			} 
			else if (gameState  == GAMEING ) {
					//��ǰ��Ϸ״̬�ڲ˵����棬Ĭ�Ϸ��ذ����˳���Ϸ
				 gameState = GamingPlaneTest.GAMEING_EXIT;
					//������Ϸ
					//initGame();
					//mediaplayer1.pause();
				}
			else if (gameState == GAME_MENU) {
				//��ǰ��Ϸ״̬�ڲ˵����棬Ĭ�Ϸ��ذ����˳���Ϸ
				//MainActivity.instance.finish();
				//System.exit(0);
				gameState = GamingPlaneTest.GAME_EXIT;
				playSound(7,0);
			}
			else if (gameState ==  GAME_EXIT) {
				//��ǰ��Ϸ״̬�ڲ˵����棬Ĭ�Ϸ��ذ����˳���Ϸ
				//MainActivity.instance.finish();
				//System.exit(0);
				gameState = GamingPlaneTest.GAME_MENU;
			}
			else if (gameState ==  GAMEING_EXIT) {
				//��ǰ��Ϸ״̬�ڲ˵����棬Ĭ�Ϸ��ذ����˳���Ϸ
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
			//��ʾ�˰����Ѵ������ٽ���ϵͳ����
			//�Ӷ�������Ϸ�������̨
			return true;
		}
		//���������¼�����������Ϸ״̬��ͬ���в�ͬ����
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:
			//���ǵİ��������¼�
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
	 * ����̧���¼�����
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		//����back���ذ���
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			//��Ϸʤ����ʧ�ܡ�����ʱ��Ĭ�Ϸ��ز˵�
			if ( gameState == GAME_WIN || gameState == GAME_LOST) {
				gameState = GAME_MENU;
			}
			else if(gameState == GAME_MENU)
			{
				
			}
			//��ʾ�˰����Ѵ������ٽ���ϵͳ����
			//�Ӷ�������Ϸ�������̨
			return true;
		}
		//���������¼�����������Ϸ״̬��ͬ���в�ͬ����
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:
			//����̧���¼�
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
	 * ����ģʽ��Ϸ�߼�
	 * TODO 
	 */
	
	private void jingdian() {	
		//�߼����������Ϸ״̬��ͬ���в�ͬ����
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:			
			//�����߼�
			backGround.logic();
			//�����߼�
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
			//�л��߼�
			if (isBoss == false) {
				//�л��߼�
				dead();
				//���ɵл�
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
							// boss�Ż����
							//�Ż�boss������1�� ���־������� 2�� ���Ϸ���ͼ  3��  ���������������������ߣ�����ͼƬ��ʧ���ٳ���boss
							//  ���� ���þ���ͼƬ�Ļ�ͼ����,~~~!!!! 
							if(enemyArray[enemyArrayIndex][i]==-1){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos,1);
							}
							if(enemyArray[enemyArrayIndex][i]==-2){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos2,2);
							}
							if(enemyArray[enemyArrayIndex][i]==-3){
								//ʵ��boss����
								boss = new GamingBoss(boss6,3);
							}
							if(enemyArray[enemyArrayIndex][i]==-4){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos3,4);
							}
							if(enemyArray[enemyArrayIndex][i]==-5){
								//ʵ��boss����
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
				//����л������ǵ���ײ
				for (int i = 0; i < vcEnemy.size(); i++) {
					if (player.unbeatable==false&&player.isCollsionWith(vcEnemy.elementAt(i))) {
						//������ײ������Ѫ��-1		
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						player.setPlayerHp(player.getPlayerHp() - 1);
						hurt++;
						//������Ѫ��С��0���ж���Ϸʧ��
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
					
				}
				//ÿ2�����һ���л��ӵ�
				countEnemyBullet++;
				if (countEnemyBullet % 40 == 0) {
					for (int i = 0; i < vcEnemy.size(); i++) {
						GamingEnemy en = vcEnemy.elementAt(i);
						//��ͬ���͵л���ͬ���ӵ����й켣
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
				//����л��ӵ��߼�
				for (int i = 0; i < vcBullet.size(); i++) { 
					GamingBullet b = vcBullet.elementAt(i);
					if (b.isDead) {
						vcBullet.removeElement(b);
					} else {
						b.logic();
					}
				}
				//����л��ӵ���������ײ
				for (int i = 0; i < vcBullet.size(); i++) {
					if (player.isCollsionWith(vcBullet.elementAt(i))) {
		//				//������ײ������Ѫ��-1					
						if(	player.unbeatable==false){
						GamingKey.key();
						//TODO MainActivity.vibrator.vibrate(pattern,-1);
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);						
						//TODO					
						//��ײ�������޵�״̬
						hurt++;
						 player.unbeatable = true;	
					     player.setPlayerHp(player.getPlayerHp() - 1)	;	
					}
				    //������Ѫ��С��0���ж���Ϸʧ��
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}					
				}
				//���������ӵ���л���ײ
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
					//ȡ�������ӵ�������ÿ��Ԫ��
					GamingBullet blPlayer = vcBulletPlayer.elementAt(i);
					
					    
					for (int j = 0; j < vcEnemy.size(); j++) {
						//��ӱ�ըЧ��
						//ȡ���л�������ÿ��Ԫ�������ӵ������ж�
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
							  //�����ӵ�����
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
			} else {//Boss����߼�
				
				boss.logic();
				
				//Boss�ӵ��߼�
				for (int i = 0; i < vcBulletBoss.size(); i++){
					GamingBullet b = vcBulletBoss.elementAt(i);
					if (b.isDead) {
						vcBulletBoss.removeElement(b);
					} else {
						b.logic();
					}
				}
				//Boss�ӵ������ǵ���ײ
				for (int i = 0; i < vcBulletBoss.size(); i++) {

					try{
					if (player.isCollsionWith(vcBulletBoss.elementAt(i))) {
		//				//������ײ������Ѫ��-1					
						if(player.unbeatable==false){
						GamingKey.key();
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);														
							hurt++;
							 player.setPlayerHp(player.getPlayerHp() - 1);
							 player.unbeatable=true;
						}				  					
				    //������Ѫ��С��0���ж���Ϸʧ��
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
					}catch(Exception e){}
				}
				//Boss�������ӵ����У�������ըЧ��
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
						    lv+=2;    //1��3��5, 8��11��    //Ѫ������Ѹ��
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
							//��ʱɾ��������ײ���ӵ�����ֹ�ظ��ж����ӵ���Boss��ײ��
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
							//��Boss���������Boss��ըЧ��							
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
			
			//Buff�߼�
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isDead) {
					vcBuff.removeElement(buff);
					//�ӵ��ȼ�+1;  !!!buff.type!!!
					//TODO  �
					if(player.type==4&&player.getPlayerHp() < 5)
					{
						 player.setPlayerHp(player.getPlayerHp() + 1);
					}
					else{
					if(buff.type==1)
					   bulletlv+=1;
					if(buff.type==2){
						//player.playerHp+=1;
						//����Ѫ��+1�����Ϊ5
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
		
			//ÿ1�����һ�������ӵ�
			countPlayerBullet++;

			if (countPlayerBullet % 4 == 0&&GamingBoss.chuchang==false) {
				if(bulletlv<4){
				 vcBulletPlayer.add(new GamingBullet(Bulletp1, player.pointX , player.pointY - 20, player.pointX , player.pointY - 20, GamingBullet.BULLET_PLAYER,bulletlv));
				//�ӵ�λ�ü�¼������ʹ��static��
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
					//����
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
						bulletlv=7;   //��Ϊ7
					}
					}
				}
				
				
			}
			//���������ӵ��߼�
			for (int i = 0; i < vcBulletPlayer.size(); i++) {
				GamingBullet b = vcBulletPlayer.elementAt(i);
              
				if (b.isDead) {
					vcBulletPlayer.removeElement(b);
				
				} else {
					b.logic();
				}
			}
              //����buff�����ǵ���ײ 
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isCollsionWith(vcBuff.elementAt(i))) {
					buff.isDead=true;
					playSound(9,0);
				}
			}
			//��ըЧ���߼�
			for (int i = 0; i < vcBoom.size(); i++) {
				GamingBoom boom = vcBoom.elementAt(i);
				if (boom.end) {
					//������ϵĴ�������ɾ��
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
	 * �޾����ģʽ��Ϸ�߼�
	 * TODO 
	*/
	@SuppressWarnings("unused")
	private void wujin() {
		
		
		//�߼����������Ϸ״̬��ͬ���в�ͬ����
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:			
			//�����߼�
			backGround.logic();
			//�����߼�
			player.logic();
			 
			//�����Ƿ��
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
			//� ����
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
				      enemyArray[0]=-2;  //  boss��///ӦΪ���boss
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
			//�л��߼�
			if (isBoss == false) {
				//�л��߼�
				dead();
				//���ɵл�
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
							//���滭��
							//Warning.draw(canvas,  War, 300, 300,paint);	
							
							//�Ż�boss������1�� ���־������� 2�� ���Ϸ���ͼ  3��  ���������������������ߣ�����ͼƬ��ʧ���ٳ���boss
							//  ���� ���þ���ͼƬ�Ļ�ͼ����,~~~!!!!  
							// boss������
							if(enemyArray[i]==-1){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos,1);
							}
							if(enemyArray[i]==-2){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos2,2);
							}
							if(enemyArray[i]==-3){
								//ʵ��boss����
								boss = new GamingBoss(boss6,3);
							}
							if(enemyArray[i]==-4){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos1,4);
							}
							if(enemyArray[i]==-5){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos3,5);
							}
							//�����Ļ
							isBoss = true;
							vcBulletPlayer.removeAllElements();
							vcEnemy.removeAllElements();
							vcBullet.removeAllElements();
							vcBuff.removeAllElements();						
							boss.setHp(20000+5000*lv);;
							
						}	
				
											
					}						
				}
				
				//����л������ǵ���ײ
				for (int i = 0; i < vcEnemy.size(); i++) {
					if (player.unbeatable=false&&player.isCollsionWith(vcEnemy.elementAt(i))) {
						//������ײ������Ѫ��-1
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						player.setPlayerHp(player.getPlayerHp() - 1);
						hurt++;
						//TODO ������Ѫ��С��0���ж���Ϸʧ��
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
				}
				//ÿ2�����һ���л��ӵ�
				countEnemyBullet++;
				if (countEnemyBullet % 60 == 0) {
					for (int i = 0; i < vcEnemy.size(); i++) {
						GamingEnemy en = vcEnemy.elementAt(i);
						//��ͬ���͵л���ͬ���ӵ����й켣
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
				//����л��ӵ��߼�
				for (int i = 0; i < vcBullet.size(); i++) { 
					GamingBullet b = vcBullet.elementAt(i);
					if (b.isDead) {
						vcBullet.removeElement(b);
					} else {
						b.logic();
					}
				}			
				//����л��ӵ���������ײ
				for (int i = 0; i < vcBullet.size(); i++) {
					if (player.isCollsionWith(vcBullet.elementAt(i))) {
						//������ײ������Ѫ��-1
						
						if(player.unbeatable==false){
						GamingKey.key();
						//�𶯿���
						if(MainActivity.vikg)
						    MainActivity.vibrator.vibrate(pattern,-1);  
						playSound(3,0);							
						if(bulletlv>1)
						      bulletlv-=1;					
							hurt++;
					        player.setPlayerHp(player.getPlayerHp() - 1);
					        player.unbeatable=true;
					        }				
				    //������Ѫ��С��0���ж���Ϸʧ��
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}			
				}
				//���������ӵ���л���ײ				
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
					//ȡ�������ӵ�������ÿ��Ԫ��
					GamingBullet blPlayer = vcBulletPlayer.elementAt(i);
					//TODO
				
					for (int j = 0; j < vcEnemy.size(); j++) {
						//��ӱ�ըЧ��
						//ȡ���л�������ÿ��Ԫ�������ӵ������ж�
						//TDDO �˺�
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
			}else {//Boss����߼�
				//ÿ0.5�����һ���ӵ�
				boss.logic();
				//if (countPlayerBullet % 15== 0) {
					//Boss��û����֮ǰ����ͨ�ӵ�
				//	if(Boss.chuchang==false)
				//	         vcBulletBoss.add(new Bullet(BossBullet, boss.x +(boss.frameW/2)-16, boss.y + 40,player.pointX,player.pointY, Bullet.BULLET_B,bulletlv));
				//}
				//Boss�ӵ��߼�
				for (int i = 0; i < vcBulletBoss.size(); i++) {
					GamingBullet b = vcBulletBoss.elementAt(i);
					if (b.isDead) {
						vcBulletBoss.removeElement(b);
					} else {
						b.logic();
					}
				}
				//Boss�ӵ������ǵ���ײ
          for (int i = 0; i < vcBulletBoss.size(); i++) {
					try{
						GamingBullet b = vcBulletBoss.elementAt(i);
					if (player.isCollsionWith(vcBulletBoss.elementAt(i))) {
		//				//������ײ������Ѫ��-1						
						
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
				    //������Ѫ��С��0���ж���Ϸʧ��
						if (player.getPlayerHp() <= -1) {
							gameState = GAME_JIESUAN;
						}
					}
					}catch(Exception e){}
				}
				//Boss�������ӵ����У�������ըЧ��
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
						    lv+=2;    //1��3��5, 8��11��    //Ѫ������Ѹ��
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
							//��ʱɾ��������ײ���ӵ�����ֹ�ظ��ж����ӵ���Boss��ײ��
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
							//��Boss���������Boss��ըЧ��							
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
		
			//Buff�߼�
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isDead) {
					vcBuff.removeElement(buff);					 
					//�ӵ��ȼ�+1;  !!!buff.type!!!
					if(player.type==4&&player.getPlayerHp() < 5)
					{
						player.setPlayerHp(player.getPlayerHp() + 1);
					}
					else{
					if(buff.type==1)
					   bulletlv+=1;
					if(buff.type==2){
						//player.playerHp+=1;
						//����Ѫ��+1�����Ϊ5
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
		
			//ÿ1�����һ�������ӵ�
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
					//TODO  ����
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
						bulletlv=7;   //��Ϊ7
					}
					}
				}
				
				
			}
			//���������ӵ��߼�
			for (int i = 0; i < vcBulletPlayer.size(); i++) {
				GamingBullet b = vcBulletPlayer.elementAt(i);
				
				if (b.isDead) {
					vcBulletPlayer.removeElement(b);
					
				} else {
					b.logic();
				}
			}
	         //����buff�����ǵ���ײ
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isCollsionWith(vcBuff.elementAt(i))) {
					buff.isDead=true;	
					playSound(9,0);
				}
			}
			//��ըЧ���߼�
			for (int i = 0; i < vcBoom.size(); i++) {
				GamingBoom boom = vcBoom.elementAt(i);
				if (boom.end) {
					//������ϵĴ�������ɾ��
					vcBoom.removeElementAt(i);
				} else {
					vcBoom.elementAt(i).logic();
				}
			}
			break;
		}
	}
	/**
	 * ����ģʽ��Ϸ�߼�
	 * TODO
	*/
private void juqing() {
		
		
		//�߼����������Ϸ״̬��ͬ���в�ͬ����
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAMEING:
			//�����߼�
			backGround.logic();
			//�����߼�
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
				//���BUFF	
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
								//ʵ��boss����
								vcBulletPlayer.removeAllElements();
							
								boss = new GamingBoss(EnemyBoos,1);								
								isBoss=true;
								boss.setHp(20000*(k+1)*(bossArrayIndex+1));
								z=0;
								break;
								
							}
							if(bossArray[bossArrayIndex][k]==-2){
								//ʵ��boss����
								boss = new GamingBoss(EnemyBoos2,2);
								vcBulletPlayer.removeAllElements();
							
								
								isBoss=true;
								//�����ܿ�
								boss.setHp(20000*(k+1)*(bossArrayIndex+1));
								z=0;
								break;						
							}
							if(bossArray[bossArrayIndex][k]==-3){
								//ʵ��boss����
								boss = new GamingBoss(boss6,2);							
								vcBulletPlayer.removeAllElements();							
								isBoss=true;
								//�����ܿ�
								boss.setHp(20000*(k+1)*(bossArrayIndex+1));
								z=0;
								break;						
							}
              			//��Ϊ0��ʤ��
							else  {		
								//���ݴ洢
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
			
			  //Boss����߼�
				//ÿ0.5�����һ���ӵ�
			if(isBoss){			
				boss.logic();
				GamingKey.key1();
				if (countPlayerBullet % 15== 0) {
					//Boss��û����֮ǰ����ͨ�ӵ�
					//vcBulletBoss.add(new Bullet(BossBullet, boss.x + 35, boss.y + 40,player.pointX,player.pointY, Bullet.BULLET_F1,bulletlv));
				}
				//Boss�ӵ��߼�
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
			//				//������ײ������Ѫ��-1
							
							if(player.unbeatable==false){
							GamingKey.key();
							if(MainActivity.vikg)
							    MainActivity.vibrator.vibrate(pattern,-1);  
							playSound(3,0);													
						        player.setPlayerHp(player.getPlayerHp() - 1);
						        player.unbeatable=true;
						        }		
						  
					    //������Ѫ��С��0���ж���Ϸʧ��
							if (player.getPlayerHp() <= -1) {
								gameState = GAME_LOST;
							}
						}
						}catch(Exception e){}
					}
				//Boss�������ӵ����У�������ըЧ��
				for (int i = 0; i < vcBulletPlayer.size(); i++) {
				
					GamingBullet b = vcBulletPlayer.elementAt(i);
					
				
					if (boss.isCollsionWith(b)) {
						
						if (boss.hp <= 0) {										
							//boss����
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
							//��ʱɾ��������ײ���ӵ�����ֹ�ظ��ж����ӵ���Boss��ײ��
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
							//��Boss���������Boss��ըЧ��
							
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
			
			//Buff�߼�
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isDead) {
					vcBuff.removeElement(buff);	
					if(player.type==4&&player.getPlayerHp() < 5){
						player.setPlayerHp(player.getPlayerHp() + 1);
					}
					//�ӵ��ȼ�+1;  !!!buff.type!!!
					else{
					if(buff.type==1)
					   bulletlv+=1;
					if(buff.type==2){
						//player.playerHp+=1;
						//����Ѫ��+1�����Ϊ5
						if(player.getPlayerHp() < 5){
					      player.setPlayerHp(player.getPlayerHp() + 1);
						}
					}
					}
				} else {
					buff.logic();
				}
			}
		
			//ÿ1�����һ�������ӵ�
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
						bulletlv=7;   //��Ϊ7
					}
					}
				}
			}
			//���������ӵ��߼�
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
             //����buff�����ǵ���ײ
			
			for (int i = 0; i < vcBuff.size(); i++) {
				 buff = vcBuff.elementAt(i);
				if (buff.isCollsionWith(vcBuff.elementAt(i))) {
					buff.isDead=true;	
					playSound(9,0);
				}
			}
			//��ըЧ���߼�
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
			//ִ�в�ͬ����Ϸ�߼�
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
			//��Ϊ����������ӵл� ����ô�Եл�isDead�ж���
			//�����������ô�ʹ�������ɾ��,�����������Ż����ã�
			if (enemy.isDead) {
				//���BUFF	
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
	 * SurfaceView��ͼ״̬�����ı䣬��Ӧ�˺���
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	/**
	 * SurfaceView��ͼ����ʱ����Ӧ�˺���
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;
		soundPool.release();
		//yinyue �������ֹر�
		mediaplayer.stop();
		mediaplayer.release();
		MainActivity.instance.finish();
		System.exit(0);		
	}
}
