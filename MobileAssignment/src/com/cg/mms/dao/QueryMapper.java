package com.cg.mms.dao;

public interface QueryMapper {

	public static final String InsertQuery="insert into mobiles values(?,?,?,?)";
	public static final String insertPurchaseDetails="insert into purchasedetails values(purchase_id_sequence.nextval,?,?,?,sysdate,?)";
	public static final String checkMobileId="select * from mobiles";
	public static final String updateQuantity="update mobiles set quantity=? where mobileid=?";
	public static final String selectAllMobiles = "select * from mobiles";
	public static final String selectMobilerange = "select * from mobiles where price between ? and ?";
	public static final String DeleteId ="delete from mobiles where mobileid=?";
	
}
