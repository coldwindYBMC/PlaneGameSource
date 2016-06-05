package com.plane_test;

import com.plane_ui.GameMenu;

public class GamingKey {
    public static int c;
	   public static void key(){
		 int k = (int)( Math.random()*10);
		 c=GamingPlaneTest.bulletlv;
		
		   if(GamingPlayer.type==1&&k<=8) //Œƒ∆Ê
		   {
			   GamingPlaneTest.bulletlv++;
		   }
		   if(GamingPlayer.type==2&&k<=8)//÷”…˘
		   {
			   c=GamingPlaneTest.bulletlv;
			   if(c>=9){
				   c=7;
			   }
			   GamingPlaneTest.bulletlv=20; 
		   }
		   if(GamingPlayer.type==3&&k>=5&&GamingPlayer.unbeatable==false)//–¿Õ©
		   {
			  GamingPlaneTest.player .setPlayerHp( GamingPlaneTest.player.getPlayerHp() + 1);
			  if(GameMenu.game==2){
				  GamingPlaneTest.bulletlv++;
			  }
		   }		  
	   }
	   //”Ó∫Ω  
	   public static void key1(){
		   if(GamingPlayer.type==4&&GamingPlaneTest.countPlayerBullet%250==0&&GamingPlaneTest.isBoss==false){
			   GamingPlaneTest.player .setPlayerHp( GamingPlaneTest.player.getPlayerHp() - 1);
			   GamingPlaneTest.player.harm+=20;		  
		   }
	   }
	   public static void key2(){
		   int k = (int)( Math.random()*9);	
		   if(GamingPlayer.type==5&&k==4&&GamingPlayer.playerHp<5){		  	  
			   GamingPlaneTest.player .setPlayerHp( GamingPlaneTest.player.getPlayerHp() +1);		
	   }
	  
		  			  
		   
	   }
}
