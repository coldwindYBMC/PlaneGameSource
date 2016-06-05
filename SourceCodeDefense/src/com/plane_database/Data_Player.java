package com.plane_database;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobDate;
public class Data_Player extends BmobObject {
	private static final long serialVersionUID = 1L;
	private String mac;
	private Boolean gender;
	private BmobDate uploadTime;
	private Integer goldcoin;
	private Boolean plane1;
	private Boolean plane2;
	private Integer effect1;
	private Integer effect2;
	public Boolean getGender() {
		return gender;
	}
	//mac地址
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	//金币
		public int getGoldCoin() {
			return goldcoin;
		}
		public void setGoldCoin(Integer goldcoin) {
			this.goldcoin = goldcoin;
		}
		//特效1
		public int getEffect1() {
			return effect1;
		}
		public void setEffect1(Integer effect1) {
			this.effect1 = effect1;
		}
		//texiao特效2
		public int getEffect2() {
			return effect2;
		}
		public void setEffect2(Integer effect2) {
			this.effect2 = effect2;
		}
	    //飞机1
		public Boolean isPlane1() {
			return plane1;
		}
		public void setPlane1(Boolean plane1) {
			this.plane1 = plane1;
		}
		//飞机2
		public Boolean isPlane2() {
			return plane2;
		}
		public void setPlane2(Boolean plane2) {
			this.plane2 = plane2;
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
