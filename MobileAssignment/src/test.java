import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mms.dao.Mobiledao;
import com.cg.mms.dao.MobiledaoImpl;
import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;

public class test {

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
	public void testInsertMobileData() {
		
		Mobilemodel mobile=new Mobilemodel();
		mobile.setMobileId(1006);
		mobile.setName("iphone");
		mobile.setPrice(100000.00);
		mobile.setQuantity(50);
		
		try {
			int id=mobileDao.insertMobileDetails(mobile);
			assertEquals(1, id);
			
		} catch (MobileException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testMobileBetweenRange() {
		
		double range1=10000;
		double range2=20000;
	   List<Mobilemodel> list=new ArrayList<>();	
		try {
			list=mobileDao.MobileRange(range1, range2);
//			assertEquals(3, list.size());
		} catch (MobileException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}


