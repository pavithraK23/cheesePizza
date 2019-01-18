package com.cg.mms.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mms.dao.Mobiledao;
import com.cg.mms.dao.MobiledaoImpl;
import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;

public class MobiledaoImplTest {
	Mobiledao mobileDao=null;
	@Before
	public void setUp() throws Exception {
		mobileDao=new MobiledaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		mobileDao=null;
	}

	@Test
	public void testInsertMobileDetails() {

		Mobilemodel mobile=new Mobilemodel();
		mobile.setMobileId(1009);
		mobile.setName("iphone");
		mobile.setPrice(100000.00);
		mobile.setQuantity(50);
		int id=0;
		try {
			
			id=mobileDao.insertMobileDetails(mobile);
			
		} catch (MobileException e) {
			
			e.printStackTrace();
		}
		assertEquals(1, id);
	}

	@Test
	public void testMobileRange() {
		double range1=10000;
		double range2=20000;
	   List<Mobilemodel> list=new ArrayList<>();	
		try {
			list=mobileDao.MobileRange(range1, range2);

		} catch (MobileException e) {
			
			e.printStackTrace();
		}
		assertEquals(1, list.size());
		
	}

}
