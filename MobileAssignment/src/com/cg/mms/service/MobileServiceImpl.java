package com.cg.mms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.mms.dao.Mobiledao;
import com.cg.mms.dao.MobiledaoImpl;
import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.model.Purchasemodel;

public class MobileServiceImpl implements MobileService {

	 Mobiledao mobileDao=new MobiledaoImpl();	
	@Override
	public int insertMobileDetails(Mobilemodel mobile) throws MobileException{
		
		return mobileDao.insertMobileDetails(mobile);
		
	}
	@Override
	public boolean validateFields(Purchasemodel purchase) {
		List<String> list=new ArrayList<>();
		boolean resultFlag=false;
		
		if(!checkName(purchase.getcName())) {
			
			list.add("Name should start with uppercase letters and max length is of 20");
			
		}
		
		if(!checkMailId(purchase.getMailId())) {
			
			list.add("Mailid should contain @ and start with only characters");
		}
		if(!checkPhoneNumber(purchase.getPhoneNumber()))
		{
			
			list.add("Phone number should be of 10 digits only and should start with 6|7|8|9");
		}
		if(!checkMobileId(purchase.getMobile_id())) {
			list.add("Moible id should be of 4 digits only and should contain only digits");
			
		}
		
		if(!list.isEmpty()) {
			
			
			System.out.println(list+"");
		}else
		{
			resultFlag=true;
		}
		
		return resultFlag;
		
	}
	public boolean checkName(String name) {
		String regEx="[A-Z]{1}[A-Za-z\\s]{1,19}$";
		
		return Pattern.matches(regEx, name);
		
	}
	public boolean checkMailId(String mailId) {
		
		String regEx="[a-zA-Z]{1}[a-zA-Z0-9._]*@[A-Za-z]*\\.[a-zA-Z]*";
		return Pattern.matches(regEx, mailId);
	}
	public boolean checkPhoneNumber(Long phoneNumber) {
	
		String regEx="[6|7|8|9]{1}[0-9]{9}$";
		return Pattern.matches(regEx, phoneNumber.toString());
	}
	
	public boolean checkMobileId(Integer mobileId) {
		
		String regEx="[0-9]{4}$";
		
		return Pattern.matches(regEx, mobileId.toString());
		
	}
	@Override
	public int UpdatemobileQuantity(Purchasemodel purchase) throws MobileException {
		
		return mobileDao.updateMobileQuantity(purchase);
	}
	@Override
	public List<Mobilemodel> selectAllMobiles() throws MobileException {
		
		return mobileDao.selectAllMobile();
	}
	@Override
	public int DeleteId(Integer id) throws MobileException {
		
		return mobileDao.DeleteId(id);
	}
	@Override
	public List<Mobilemodel> MobileRange(Double range1, Double range2) throws MobileException {
		
		return mobileDao.MobileRange(range1, range2);
	}
}
	