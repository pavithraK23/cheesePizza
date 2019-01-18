package com.cg.mms.presentation;

import java.util.ArrayList;
import java.util.List;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class SelectAllmobile {

public static void main(String[] args) throws MobileException {
		
		
		
		List<Mobilemodel> list=new ArrayList<>();
		
		MobileService service=new MobileServiceImpl();
		
		list=service.selectAllMobiles();
		System.out.println("mobileid"+"   "+"mobile name"+"         "+"price"+"        "+"quantity");
		
		for(Mobilemodel mobile:list)
		{
			System.out.println(mobile.getMobileId()+"        "+mobile.getName()+"       "+mobile.getPrice()+"          "+mobile.getQuantity());
		}
		
		

	}

}


