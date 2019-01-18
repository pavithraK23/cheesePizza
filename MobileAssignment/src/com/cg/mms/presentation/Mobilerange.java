package com.cg.mms.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.mms.exception.MobileException;
import com.cg.mms.model.Mobilemodel;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class Mobilerange {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter price range for which you want mobiles");

		Double range1 = scanner.nextDouble();
		System.out.println("to");
		Double range2 = scanner.nextDouble();

		List<Mobilemodel> list = new ArrayList<>();
		MobileService service = new MobileServiceImpl();
		try {
			list = service.MobileRange(range1, range2);
			System.out.println("mobileid" + "   " + "mobile name" + "         " + "price" + "        " + "quantity");

			for (Mobilemodel mobiles : list) {
				System.out.println(mobiles.getMobileId() + "        " + mobiles.getName() + "       "
						+ mobiles.getPrice() + "          " + mobiles.getQuantity());
			}

		} catch (MobileException e) {
			System.out.println(e.getMessage());
		}

	}

}
