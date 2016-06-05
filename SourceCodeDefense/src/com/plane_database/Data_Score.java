package com.plane_database;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
public class Data_Score extends BmobObject {
	private static final long serialVersionUID = 1L;
	private String mac;
	private int maxscore;
	private int hurt;
	private int kill;
	private int gold;
	private int type;
	private Boolean gender;
	private BmobDate uploadTime;
	public Boolean getGender() {
		return gender;
	}
	//mac��ַ
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	//��߷�
	public void setMaxscore(int maxscore) {
		this.maxscore=maxscore;
	}
	public int getMaxscore() {
		return maxscore;
	}
	
	//����
	public int getHurt() {
		return hurt;
	}
	public void setHurt(int hurt) {
		this.hurt = hurt;
	}
	//ɱ��
	public int getKill() {
		return kill;
	}
	public void setKill(int kill) {
		this.kill = kill;
	}
	//���
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	//�ɻ�����
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Boolean isGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public BmobDate getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(BmobDate uploadTime) {
		this.uploadTime = uploadTime;
	}
}
