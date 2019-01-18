package com.cg.mms.service;

import java.util.List;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.model.Purchasemodel;

public interface MobileService {

	int insertMobileDetails(Mobilemodel mobile) throws MobileException;

	boolean validateFields(Purchasemodel purchase);

	int UpdatemobileQuantity(Purchasemodel purchase) throws MobileException;
	
	List<Mobilemodel> selectAllMobiles() throws MobileException;

    List<Mobilemodel> MobileRange(Double range1, Double range2) throws MobileException;

	int DeleteId(Integer id) throws MobileException;
}
