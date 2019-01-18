package com.cg.mms.dao;

import java.util.List;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.model.Purchasemodel;

public interface Mobiledao {

	int insertMobileDetails(Mobilemodel mobile) throws MobileException;

	List<Mobilemodel> selectAllMobile() throws MobileException;

	int updateMobileQuantity(Purchasemodel purchase) throws MobileException;

	List<Mobilemodel> MobileRange(Double range1, Double range2) throws MobileException;

	int DeleteId(Integer id) throws MobileException;

}
